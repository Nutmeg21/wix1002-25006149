public class L10Q1 {
    public static void main(String[] args) {
        Employee permA = new Permanent("Permanent A", 'A');
        Employee permB = new Permanent("Permanent B", 'B');
        Employee permC = new Permanent("Permanent C", 'C');
        permA.salary();
        permB.salary();
        permC.salary();

        Employee contract = new Contract("Contract Employee", 8750);
        contract.salary();

        Employee temporary = new Temporary("Temporary Staff", 64);
        temporary.salary();
    }
}

abstract class Employee {
    String name;
    String type;
    double salary;

    public Employee(String employeeName, String employeeType)
    {
        name = employeeName;
        type = employeeType;
    }
    public abstract void salary();
}

class Permanent extends Employee {
    char category;

    public Permanent(String employeeName, char category)
    {
        super(employeeName, "Permanent");
        this.category = category;
    }

    public void salary()
    {
        switch (category) {
            case 'A':
                salary = 4000;
                break;
            case 'B':
                salary = 3000;
                break;
            case 'C':
                salary = 2000;
                break;
            default:
                salary = 0;
                break;
        }
        System.out.printf("%s Salary: RM%.2f\n", name, salary);
    }
}

class Contract extends Employee {
    double totalSales;

    public Contract(String employeeName, double totalSales)
    {
        super(employeeName, "Contract");
        this.totalSales = totalSales;
    }

    public void salary()
    {
        salary = 500 + (totalSales * 0.5);
        System.out.printf("%s Salary: RM%.2f\n", name, salary);
    }
}

class Temporary extends Employee {
    int hours;

    public Temporary(String employeeName, int hours)
    {
        super(employeeName, "Temporary");
        this.hours = hours;
    }

    public void salary()
    {
        salary = 15 * hours;
        System.out.printf("%s Salary: RM%.2f\n", name, salary);
    }
}