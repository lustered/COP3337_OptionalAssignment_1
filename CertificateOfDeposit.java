import java.lang.Math;
import java.text.DecimalFormat;

public class CertificateOfDeposit {
    private double principal;
    private double interestRate;
    private int maturity;
    private String compoundingMode;
    private int elapsedTime;

    public CertificateOfDeposit(double principal, double interestRate, int maturity, String compoundingMode) {
        this.principal = principal;
        this.interestRate = interestRate;
        this.maturity = maturity;
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

    public int getElapsedTime() {
        return elapsedTime;
    }

    // Elapsed time in years | not maturity
    public String computeValues(int elapsedTime) {
        this.elapsedTime = elapsedTime;
        // Number of times compounded per year
        double compoundInterest = 0.0;
        switch (this.compoundingMode) {
            case "daily":
                compoundInterest = 365.0;
                break;
            case "monthly":
                compoundInterest = 12.0;
                break;
            case "quarterly":
                compoundInterest = 4.0;
                break;
            default:
                System.out.println("LOG::Check for typo in the Compounding Mode");
        }
        double rate = interestRate / 100.0;
        double ret = principal * Math.pow((1.0 + (rate / compoundInterest)), (compoundInterest * (double) elapsedTime));

        DecimalFormat df = new DecimalFormat("###.##");
        return String.valueOf(df.format(ret));
    }

    public String toString() {
        // Insert 140 '-'
        String divider = new String(new char[140]).replace("\0", "-");
        return divider + "\n| Principal Amount = $" + principal + " | Initial Interest Rate = " + interestRate
                + "% | Maturity = " + maturity + " | Compound Value = " + compoundingMode.toUpperCase()
                + " | Accumulated Interest = $" + computeValues(3) + " |";
    }

}
