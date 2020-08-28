import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class testing_class {

    public static void main(String[] args) {

        /*
         * arrlist to store each account each account is stored in an individual array
         * in the ArrayList to access each account:
         * arrlist.get(accountIndex)[accountItems]
         */
        ArrayList<String[]> accounts = new ArrayList<String[]>();
        getAccountsFromFile(accounts);

        String[] account1 = accounts.get(0);
        String[] account2 = accounts.get(1);

        // Creating CD skeletons
        CertificateOfDeposit account_1 = new CertificateOfDeposit(Double.parseDouble(account1[0]),
                Integer.parseInt(account1[1]), Double.parseDouble(account1[2]), account1[3]);

        CertificateOfDeposit account_2 = new CertificateOfDeposit(Double.parseDouble(account2[0]),
                Integer.parseInt(account2[1]), Double.parseDouble(account2[2]), account2[3]);

        // Bank CD Account List 1
        CertificateOfDepositList cd1 = new CertificateOfDepositList();
        cd1.addAccountToList(account_1);
        cd1.addAccountToList(account_2);
        cd1.accountReport();

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
