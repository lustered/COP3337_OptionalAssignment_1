// What is a CD?:
// Certificates of deposit are a secure form of time deposit, where money must stay in the bank for a certain 
// length of time to earn a promised return. A CD, also called a “share certificate” at
// credit unions, almost always earns more interest than a regular savings account.

// Compute the accumulated value (principal plus interest earned) 
// for any number of such CD's at yearly intervals

/*
5000 5 8.25 quarterly
12000 10 10.80 daily
2000 5 7.30 quarterly
10000 3 5.55 monthly
2000 1 4.50 daily
5000 10 9.15 monthly
*/
import java.lang.Math;

public class CertificateOfDeposit {
    private double principal;
    private int maturity;
    private double interestRate;
    private String compoundingMode;

    public CertificateOfDeposit(double principal, int maturity, double interestRate, String compoundingMode) {
        this.principal = principal;
        this.maturity = maturity;
        this.interestRate = interestRate;
        this.compoundingMode = compoundingMode;
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

        return "Certificate of Deposit [principalAmount = " + principal + ", initialRate = " + interestRate
                + ", maturity = " + maturity

                + ", compoundValue = " + compoundingMode + "]";

    }

}
