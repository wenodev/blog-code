package srp.InvertedDependencies;

public class PayCalculator implements Employee {

    @Override
    public void saveEmployee() {
        System.out.println("called saveEmployee PayCalculator");
    }

    @Override
    public void reportHours() {
        System.out.println("called reportHours PayCalculator");
    }

    public void calculatePay(){
        System.out.println("called calculatePay PayCalculator");
    };
}
