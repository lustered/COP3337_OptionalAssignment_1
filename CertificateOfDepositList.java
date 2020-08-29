import java.util.ArrayList;

public class CertificateOfDepositList {
    private ArrayList<CertificateOfDeposit> listOfCDs;

    // constructor
    public CertificateOfDepositList() {
        listOfCDs = new ArrayList<CertificateOfDeposit>();
    }

    // add CertificateOfDeposit to list
    public void addAccountToList(CertificateOfDeposit account) {
        listOfCDs.add(account);
        System.out.println("[LOG]::Account Added");
    }

    public void accountReport() {
        for (CertificateOfDeposit cd : listOfCDs)
            System.out.println(cd);
    }
}
