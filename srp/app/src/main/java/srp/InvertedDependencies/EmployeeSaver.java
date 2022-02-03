package srp.InvertedDependencies;

public class EmployeeSaver implements Employee {
    @Override
    public void saveEmployee(){
        System.out.println("called EmployeeSaver saveEmployee");
    }

    @Override
    public void reportHours() {
        System.out.println("called EmployeeSaver reportHours");
    }

    @Override
    public void calculatePay() {
        System.out.println("called EmployeeSaver calculatePay");
    }
}
