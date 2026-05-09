public class Main {
    public static void main(String[] args) {
        // 1. Creating object using Default Constructor
        PolicyHolder holder1 = new PolicyHolder();

        // 2. Creating object using Overloaded Constructor (Different set of data)
        PolicyHolder holder2 = new PolicyHolder("Amit Sharma", "Jeevan Anand", 50000);

        // Initialize Calculator
        PolicyCalculator calc = new PolicyCalculator();

        // 3. Display Results
        System.out.println("Generating Policy Reports...\n");

        // Displaying details for holder 1
        calc.displayFinalStatement(holder1);

        // Displaying details for holder 2
        calc.displayFinalStatement(holder2);
    }
}