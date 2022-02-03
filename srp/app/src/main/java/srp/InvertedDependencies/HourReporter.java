package srp.InvertedDependencies;

public class HourReporter implements Employee{

    @Override
    public void saveEmployee() {
        System.out.println("called saveEmployee HourReporter");

    }

    public void reportHours(){
        System.out.println("called reportHours HourReporter");
    }

    @Override
    public void calculatePay() {
        System.out.println("called calculatePay HourReporter");
    }
}
