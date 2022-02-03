package srp.InvertedDependencies;

public class EmployeeImpl {
    private Employee employee1 = new EmployeeSaver();
    private Employee employee2 = new HourReporter();
    private Employee employee3 = new PayCalculator();
}
