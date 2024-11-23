import java.util.List;
import java.util.ArrayList;

// Интерфейс компонента файловой системы
abstract class FileSystemComponent {
    String name;
    public FileSystemComponent(String name) { this.name = name; }
    abstract void display();
    abstract int getSize();
}

// Класс Файл
class File extends FileSystemComponent {
    int size;
    public File(String name, int size) {
        super(name);
        this.size = size;
    }
    void display() { System.out.println("Файл: " + name + ", Размер: " + size + "КБ"); }
    int getSize() { return size; }
}

// Класс Папка
class Directory extends FileSystemComponent {
    private List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name) { super(name); }

    void addComponent(FileSystemComponent component) {
        if (!components.contains(component)) {
            components.add(component);
        }
    }

    void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }

    void display() {
        System.out.println("Папка: " + name);
        for (FileSystemComponent component : components) {
            component.display();
        }
    }

    int getSize() {
        int totalSize = 0;
        for (FileSystemComponent component : components) {
            totalSize += component.getSize();
        }
        return totalSize;
    }
}

// Клиентский код
public class domash {
    public static void main(String[] args) {
        Directory root = new Directory("Корневая папка");
        File file1 = new File("Файл1.txt", 100);
        File file2 = new File("Файл2.txt", 200);

        Directory subDir = new Directory("Подпапка");
        File file3 = new File("Файл3.txt", 50);
        subDir.addComponent(file3);

        root.addComponent(file1);
        root.addComponent(file2);
        root.addComponent(subDir);

        root.display();
        System.out.println("Общий размер: " + root.getSize() + "КБ");
    }
}
