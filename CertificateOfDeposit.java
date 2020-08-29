import java.lang.Math;

public class CertificateOfDeposit {
    private double principal;
    private double interestRate;
    private int maturity;
    private String compoundingMode;

    public CertificateOfDeposit(double principal, int maturity, double interestRate, String compoundingMode) {
        this.principal = principal;
        this.maturity = maturity;
        this.interestRate = interestRate;
        this.compoundingMode = compoundingMode;
    }

    public CertificateOfDeposit(String[] accountInfo) {
        this.principal = Double.parseDouble(accountInfo[0]);
        this.maturity = Integer.parseInt(accountInfo[1]);
        this.interestRate = Double.parseDouble(accountInfo[2]);
        this.compoundingMode = accountInfo[3];
    }

    public CertificateOfDeposit() {
        this.principal = 10000;
        this.interestRate = 10;
        this.maturity = 5;
        this.compoundingMode = "daily";
    }

    // Getters
    public double getPrincipal() {
        return principal;
    }

    public int getMaturity() {
        return maturity;
    }

    public String getCompoundingMode() {
        return compoundingMode;
    }

    public double getInterestRate() {
        return interestRate;
    }

    // Elapsed time in years | not maturity
    public double computeValues(double elapsedTime) {
        // Number of times compounded per year
        double compoundInterest = 0.0;
        switch (this.compoundingMode) {
            case "daily":
                compoundInterest = 365;
                break;
            case "monthly":
                compoundInterest = 12;
                break;
            case "quarterly":
                compoundInterest = 4;
                break;
            default:
                System.out.println("LOG::Check for typo in the Compounding Mode");
        }
        double ret = principal * Math.pow((1 + (interestRate / compoundInterest)), (compoundInterest * elapsedTime));
        return ret;
    }

    public String toString() {
        return "[Certificate of Deposit]::[Principal Amount = " + principal + ", Initial Rate = " + interestRate
                + ", Maturity = " + maturity + ", Compound Value = " + compoundingMode + ", Computed Balance = "
                + computeValues(10) + "]";
    }

}
