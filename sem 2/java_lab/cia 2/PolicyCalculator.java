public class PolicyCalculator {

    // Method to calculate simple maturity (Premium + 10% Bonus)
    // Demonstrates interaction between classes by passing PolicyHolder object
    public double calculateMaturity(PolicyHolder holder) {
        double bonus = holder.premiumAmount * 0.10; // 10% Bonus
        return holder.premiumAmount + bonus;
    }

    public void displayFinalStatement(PolicyHolder holder) {
        double total = calculateMaturity(holder);
        System.out.println("--- LIC Statement ---");
        holder.displayBaseDetails();
        System.out.println("Calculated Maturity (with Bonus): ₹" + total);
        System.out.println("----------------------\n");
    }
}