class Employee {
    int employeeId;
    String employeeName, designation;

    // Method to accept and display employee details
    public void acceptDetails(int empId, String empName, String desg) {
        this.employeeId = empId;
        this.employeeName = empName;
        this.designation = desg;
        System.out.println("Employee Id = " + empId);
        System.out.println("Employee Name = " + empName);
        System.out.println("Employee Designation = " + desg);
    }

    // Method to calculate bonus based on percentage and annual salary
    public double calculateBonus(double bonusPercentage, double annualSal) {
        if (bonusPercentage >= 0 && bonusPercentage <= 100) {
            double bonus = annualSal * (bonusPercentage / 100);
            return bonus;
        } else {
            System.out.println("Invalid bonus percentage. Please enter a value between 0 and 100.");
            return 0; // Return a default value or handle the error as per your requirement
        }
    }
}

class HourlyEmployee extends Employee {
    double hourlyRate;
    int hoursWorked;

    // Constructor for HourlyEmployee with data validation
    public HourlyEmployee(int empId, String empName, String desg, double hourlyRate, int hoursWorked) {
        super(); // Call base class constructor

        // Setting employee details
        this.employeeId = empId;
        this.employeeName = empName;
        this.designation = desg;

        // Validate and set hourly rate
        if (hourlyRate >= 0) {
            this.hourlyRate = hourlyRate;
        } else {
            System.out.println("Invalid hourly rate. Please enter a non-negative value.");
            // Handle the error accordingly
        }

        // Validate and set hours worked
        if (hoursWorked >= 0 && hoursWorked <= 168) {
            this.hoursWorked = hoursWorked;
        } else {
            System.out.println("Invalid hours worked. Please enter a value between 0 and 168.");
            // Handle the error accordingly
        }
    }

    // Method to calculate weekly earnings
    public double weeklyEarnings() {
        double earnWeek = hourlyRate * hoursWorked;
        return earnWeek;
    }
}

class SalariedEmployee extends Employee {
    double monthlySalary;

    // Constructor for SalariedEmployee with data validation
    public SalariedEmployee(int empId, String empName, String desg, double monthlySalary) {
        super(); // Call base class constructor

        // Setting employee details
        this.employeeId = empId;
        this.employeeName = empName;
        this.designation = desg;

        // Validate and set monthly salary
        if (monthlySalary >= 0) {
            this.monthlySalary = monthlySalary;
        } else {
            System.out.println("Invalid monthly salary. Please enter a non-negative value.");
            // Handle the error accordingly
        }
    }

    // Method to calculate weekly salary
    public double weeklySalary() {
        double weekSalary = monthlySalary / 4;
        return weekSalary;
    }
}

class ExecutiveEmployee extends SalariedEmployee {
    double bonusPercentage;

    // Constructor for ExecutiveEmployee with data validation
    public ExecutiveEmployee(int empId, String empName, String desg, double monthlySalary, double bonusPercentage) {
        super(empId, empName, desg, monthlySalary); // Call base class constructor

        // Validate and set bonus percentage
        if (bonusPercentage >= 0 && bonusPercentage <= 100) {
            this.bonusPercentage = bonusPercentage;
        } else {
            System.out.println("Invalid bonus percentage. Please enter a value between 0 and 100.");
            // Handle the error accordingly
        }
    }

    // Overridden method to calculate bonus considering annual salary
    @Override
    public double calculateBonus(double bonusPercentage, double annualSal) {
        double bonus = super.calculateBonus(bonusPercentage, annualSal * 12); // Considering annual salary
        return bonus;
    }
}

public class TestProgram {
    public static void main(String[] args) {
        // Creating instances of different employee types
        HourlyEmployee hourlyEmployee = new HourlyEmployee(1, "Rakesh Roshan", "Cashier", 100.5, 170);
        SalariedEmployee salariedEmployee = new SalariedEmployee(2, "Suresh Krishna", "Data Architect", -20000);
        ExecutiveEmployee executiveEmployee = new ExecutiveEmployee(3, "Soheli Paul", "CEO", 20000, 200);

        // Displaying details and earnings for each employee
        System.out.println("Hourly Employee Details:");
        hourlyEmployee.acceptDetails(hourlyEmployee.employeeId, hourlyEmployee.employeeName, hourlyEmployee.designation);
        System.out.println("Weekly Earnings: Rs " + hourlyEmployee.weeklyEarnings());

        System.out.println("\nSalaried Employee Details:");
        salariedEmployee.acceptDetails(salariedEmployee.employeeId, salariedEmployee.employeeName, salariedEmployee.designation);
        System.out.println("Weekly Salary: Rs " + salariedEmployee.weeklySalary());

        System.out.println("\nExecutive Employee Details:");
        executiveEmployee.acceptDetails(executiveEmployee.employeeId, executiveEmployee.employeeName, executiveEmployee.designation);
        double executiveBonus = executiveEmployee.calculateBonus(executiveEmployee.bonusPercentage, executiveEmployee.monthlySalary);
        System.out.println("Executive Annual Bonus: Rs " + executiveBonus);

        // Displaying total payroll
        double totalPayroll = hourlyEmployee.weeklyEarnings() + salariedEmployee.weeklySalary() + executiveBonus;
        System.out.println("\nTotal Payroll: Rs " + totalPayroll);
    }
}