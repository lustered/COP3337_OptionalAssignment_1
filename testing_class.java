import java.util.Scanner;
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

        // ArrayList to store accounts
        ArrayList<String[]> accountsFromFile = new ArrayList<String[]>();
        // Call method to store accounts from a file
        getAccountsFromFile(accountsFromFile, "accounts.txt");

        // Each Account Info
        String[] account1 = accountsFromFile.get(0);
        String[] account2 = accountsFromFile.get(1);
        String[] account3 = accountsFromFile.get(2);
        String[] account4 = accountsFromFile.get(3);
        String[] account5 = accountsFromFile.get(4);
        String[] account6 = accountsFromFile.get(5);

        // Creating CD skeletons
        CertificateOfDeposit account_1 = new CertificateOfDeposit(account1);
        CertificateOfDeposit account_2 = new CertificateOfDeposit(account2);
        CertificateOfDeposit account_3 = new CertificateOfDeposit(account3);
        CertificateOfDeposit account_4 = new CertificateOfDeposit(account4);
        CertificateOfDeposit account_5 = new CertificateOfDeposit(account5);
        CertificateOfDeposit account_6 = new CertificateOfDeposit(account6);

        // Add accounts to the CD List
        CertificateOfDepositList cdlist1 = new CertificateOfDepositList();
        cdlist1.addAccountToList(account_1);
        cdlist1.addAccountToList(account_2);
        cdlist1.addAccountToList(account_3);
        cdlist1.addAccountToList(account_4);
        cdlist1.addAccountToList(account_5);
        cdlist1.addAccountToList(account_6);
        // Print each account's report
        cdlist1.accountReport();

        // Print Testing
        // / System.out.println(account_1.toString());
        // System.out.println(account_1.getInterestRate());
        // System.out.println(account.computeValues(10));
        // System.out.println(account.getPrincipal());
        // System.out.println(accounts.get(4)[3]);
    }

    private static void getAccountsFromFile(ArrayList<String[]> accountsFromFile, String accountFile) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(accountFile));
            String line = reader.readLine();

            while (line != null) {
                // Insert each item in the .txt into an array
                String[] words = line.split(" ");
                accountsFromFile.add(words);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
