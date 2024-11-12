public class PayrollSystemTest {
    public static void main(String[] args) {
        // Instantiate HourlyEmployee
        HourlyEmployee hourlyEmployee = new HourlyEmployee(1, "Aditya", "Teaching Assistant", 20.0, 35);
        System.out.println("Hourly Employee Info:");
        hourlyEmployee.displayEmployeeInfo(); // Display details for hourly employee
        System.out.println("Annual Earnings: $" + calculateAnnualEarnings(hourlyEmployee.calculateWeeklySalary()));
        System.out.println();

        // Instantiate SalariedEmployee
        SalariedEmployee salariedEmployee = new SalariedEmployee(2, "Rhea", "Dean", 5000.0);
        System.out.println("Salaried Employee Info:");
        salariedEmployee.displayEmployeeInfo(); // Display details for salaried employee
        System.out.println("Annual Earnings: $" + calculateAnnualEarnings(salariedEmployee.calculateWeeklySalary()));
        System.out.println();

        // Instantiate ExecutiveEmployee
        ExecutiveEmployee executiveEmployee = new ExecutiveEmployee(3, "Radha", "Professor", 10000.0, 15.0);
        System.out.println("Executive Employee Info:");
        executiveEmployee.displayEmployeeInfo(); // Display details for executive employee
        System.out.println("Annual Earnings: $" + calculateAnnualEarnings(executiveEmployee.calculateWeeklySalary()));
        System.out.println();

        // Calculate and display total weekly payroll
        double totalWeeklyPayroll = hourlyEmployee.calculateWeeklySalary() 
                                    + salariedEmployee.calculateWeeklySalary() 
                                    + executiveEmployee.calculateWeeklySalary();
        System.out.println("Total Weekly Payroll: $" + totalWeeklyPayroll);
    }

    /**
     * Helper method to calculate annual earnings based on weekly salary.
     * Assumes a 52-week year for calculation.
     * 
     * @param weeklySalary the weekly salary of the employee
     * @return annual earnings
     */
    public static double calculateAnnualEarnings(double weeklySalary) {
        return weeklySalary * 52; // Calculate annual earnings
    }
}
