public class FileSystemCompositeExample {
    // Абстрактты компонент класы
    public static abstract class FileSystemComponent {
        protected String name;

        public FileSystemComponent(String name) {
            this.name = name;
        }

        public abstract void display(int depth);

        public void add(FileSystemComponent component) {
            throw new UnsupportedOperationException();
        }

        public void remove(FileSystemComponent component) {
            throw new UnsupportedOperationException();
        }

        public FileSystemComponent getChild(int index) {
            throw new UnsupportedOperationException();
        }

        protected String repeat(String str, int times) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < times; i++) {
                sb.append(str);
            }
            return sb.toString();
        }
    }

    // File класы - жапырақ элементі
    public static class File extends FileSystemComponent {
        public File(String name) {
            super(name);
        }

        @Override
        public void display(int depth) {
            System.out.println(repeat(" ", depth) + "- Файл: " + name);
        }
    }

    // Directory класы - контейнер
    public static class Directory extends FileSystemComponent {
        private final java.util.List<FileSystemComponent> children = new java.util.ArrayList<>();

        public Directory(String name) {
            super(name);
        }

        @Override
        public void add(FileSystemComponent component) {
            children.add(component);
        }

        @Override
        public void remove(FileSystemComponent component) {
            children.remove(component);
        }

        @Override
        public FileSystemComponent getChild(int index) {
            return children.get(index);
        }

        @Override
        public void display(int depth) {
            System.out.println(repeat(" ", depth) + "+ Каталог: " + name);
            for (FileSystemComponent component : children) {
                component.display(depth + 2);
            }
        }
    }

    // Клиенттік код
    public static void main(String[] args) {
        Directory root = new Directory("Тамыр");
        File file1 = new File("Файл1.txt");
        File file2 = new File("Файл2.txt");

        Directory subDir = new Directory("ІшкіКаталог");
        File subFile1 = new File("ІшкіФайл1.txt");

        // Компоновщик құрылымын құру
        root.add(file1);
        root.add(file2);
        subDir.add(subFile1);
        root.add(subDir);

        // Файлдық жүйенің құрылымын көрсету
        root.display(1);
    }
}
