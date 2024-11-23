import java.util.List;
import java.util.ArrayList;
// Абстрактный класс компонента организации
abstract class OrganizationComponent {
    String name;
    public OrganizationComponent(String name) { this.name = name; }
    abstract void display();
    abstract double getBudget();
    abstract int getEmployeeCount();
}

// Класс Сотрудник
class Employee extends OrganizationComponent {
    String position;
    double salary;

    public Employee(String name, String position, double salary) {
        super(name);
        this.position = position;
        this.salary = salary;
    }

    void display() { System.out.println("Сотрудник: " + name + ", Должность: " + position + ", Зарплата: " + salary); }
    double getBudget() { return salary; }
    int getEmployeeCount() { return 1; }
}

// Класс Отдел
class Department extends OrganizationComponent {
    private List<OrganizationComponent> components = new ArrayList<>();

    public Department(String name) { super(name); }

    void addComponent(OrganizationComponent component) { components.add(component); }
    void removeComponent(OrganizationComponent component) { components.remove(component); }

    void display() {
        System.out.println("Отдел: " + name);
        for (OrganizationComponent component : components) {
            component.display();
        }
    }

    double getBudget() {
        double totalBudget = 0;
        for (OrganizationComponent component : components) {
            totalBudget += component.getBudget();
        }
        return totalBudget;
    }

    int getEmployeeCount() {
        int totalEmployees = 0;
        for (OrganizationComponent component : components) {
            totalEmployees += component.getEmployeeCount();
        }
        return totalEmployees;
    }
}

// Клиентский код
public class pracc {
    public static void main(String[] args) {
        Department root = new Department("Головной офис");

        Employee emp1 = new Employee("Иван", "Менеджер", 5000);
        Employee emp2 = new Employee("Ольга", "Бухгалтер", 4000);

        Department subDepartment = new Department("Отдел продаж");
        Employee emp3 = new Employee("Сергей", "Продавец", 3000);
        subDepartment.addComponent(emp3);

        root.addComponent(emp1);
        root.addComponent(emp2);
        root.addComponent(subDepartment);

        root.display();
        System.out.println("Общий бюджет: " + root.getBudget() + " руб.");
        System.out.println("Общее количество сотрудников: " + root.getEmployeeCount());
    }
}
