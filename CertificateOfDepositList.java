import java.util.ArrayList;

public class CertificateOfDepositList {
    private ArrayList<CertificateOfDeposit> listOfCDs;
    public int totalAccountsCreated = 0;

    // constructor
    public CertificateOfDepositList() {
        listOfCDs = new ArrayList<CertificateOfDeposit>();
    }

    // add CertificateOfDeposit to list
    public void addAccountToList(CertificateOfDeposit account) {
        listOfCDs.add(account);
        totalAccountsCreated += 1;
        System.out.println("[LOG]:: Account " + totalAccountsCreated + " Added");
    }

    public void accountReport() {
        System.out.println("\n[LOG]:: Total Accounts: " + totalAccountsCreated);
        System.out.println("\n\t\t\t\t\t\t[:: Certificate of Deposit List ::]");
        for (CertificateOfDeposit cd : listOfCDs)
            System.out.println(cd);
    }
}
