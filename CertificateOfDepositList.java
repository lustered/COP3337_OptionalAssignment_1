import java.util.ArrayList;
import java.util.Arrays;

public class CertificateOfDepositList {
    private ArrayList<CertificateOfDeposit> listOfCDs;

    // constructor
    public CertificateOfDepositList() {
        listOfCDs = new ArrayList<CertificateOfDeposit>();
    }

    // add CertificateOfDeposit to list
    public void addAccountToList(CertificateOfDeposit account) {
        listOfCDs.add(account);
        System.out.println("account added");
    }

    public void accountReport() {
        for (CertificateOfDeposit cd : listOfCDs)
            System.out.println(cd);

        // System.out.println(Arrays.deepToString(listOfCDs.toArray()));

        // for (int i = 0; i < listOfCDs.get(0).size(); i++)
        // System.out.println(listOfCDs.size());
        // System.out.println(listOfCDs.get(i));
    }

    public String toString()

    {

        String out = "";

        for (int i = 0; i < listOfCDs.size(); i++)

        {

            out = out + listOfCDs.get(i) + "";

        }

        return out;

    }

}
