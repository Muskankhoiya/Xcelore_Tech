package Q3;

interface DivisionInterface {
int division(int a, int b) throws ArithmeticException;
}

public class Division implements DivisionInterface {
    public static void main(String[] args) {
        Division divisionInstance = new Division();

        Runnable divisionTask = () -> {
            try {
                System.out.println("Result of 4 / 2: " + divisionInstance.division(4, 2));
                System.out.println("Result of 4 / 0: " + divisionInstance.division(4, 0)); // This will cause an exception
            } catch (ArithmeticException ae) {
                System.err.println("ArithmeticException caught: " + ae.getMessage());
            } catch (Exception e) {
                System.err.println("Exception caught: " + e.getMessage());
            }
        };

        // Execute the division task
        divisionTask.run();
    }

    @Override
    public int division(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division not allowed");
        }
        return a / b;
    }
}