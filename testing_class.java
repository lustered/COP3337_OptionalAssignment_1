import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class testing_class {

    public static void main(String[] args) {

        /*
         * Arrlist to store each account each account is stored in an individual array
         * in the ArrayList to access each account:
         * ArrayList.get(accountIndex)[accountItems]
         */

        // ArrayList to store accounts from text file
        ArrayList<String[]> accounts = new ArrayList<String[]>();
        // Call method to store accounts
        getAccountsFromFile(accounts);

        // Extract each account
        String[] account1 = accounts.get(0);
        String[] account2 = accounts.get(1);
        String[] account3 = accounts.get(2);

        // Creating CD skeletons
        CertificateOfDeposit account_1 = new CertificateOfDeposit(account1);
        CertificateOfDeposit account_2 = new CertificateOfDeposit(account2);
        CertificateOfDeposit account_3 = new CertificateOfDeposit(account3);

        // Add accounts
        CertificateOfDepositList cd1 = new CertificateOfDepositList();
        cd1.addAccountToList(account_1);
        cd1.addAccountToList(account_2);
        cd1.addAccountToList(account_3);
        cd1.accountReport();

        // Print testing
        // System.out.println(account.computeValues(10));
        // System.out.println(account.getPrincipal());
        // System.out.println(accounts.get(4)[3]);
    }

    private static void getAccountsFromFile(ArrayList<String[]> accounts) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("accounts.txt"));
            String line = reader.readLine();

            while (line != null) {
                String[] words = line.split(" ");
                accounts.add(words);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
