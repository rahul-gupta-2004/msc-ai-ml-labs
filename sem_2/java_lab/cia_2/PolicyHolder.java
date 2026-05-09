public class PolicyHolder {
    String name;
    String policyType;
    double premiumAmount;

    // Default Constructor
    public PolicyHolder() {
        this.name = "Unknown";
        this.policyType = "General";
        this.premiumAmount = 0.0;
    }

    // Overloaded Constructor (Demonstrating Constructor Overloading)
    public PolicyHolder(String name, String policyType, double premiumAmount) {
        // Using 'this' keyword to distinguish instance variables from parameters
        this.name = name;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }

    public void displayBaseDetails() {
        System.out.println("Policy Holder: " + this.name);
        System.out.println("Policy Type: " + this.policyType);
        System.out.println("Premium Paid: ₹" + this.premiumAmount);
    }
}