import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TestingClass {

    public static void main(String[] args) {
        /*
         * Arrlist to store each account each account is stored in an individual array
         * in the ArrayList to access each account:
         * ArrayList.get(accountIndex)[accountItems]
         */

        // Get Document Name
        Scanner scan = new Scanner(System.in);
        // default options
        String accountsFile = "accounts.txt";
        int userOption = 2;

        System.out.println("\n[::Options::]");
        System.out.println("\t[::1-Load from file::]");
        System.out.println("\t[::2-Use default file::]\n\t\t");
        System.out.print("\tChoice:: ");
        userOption = Integer.parseInt(scan.next());

        // Assuming there are no wrong filenames
        if (userOption == 1) {
            try {
                System.out.print("\n\t[::Enter file name::] ");
                accountsFile = scan.next();

            } catch (Exception e) {
                e.printStackTrace();
            }
            scan.close();

        }

        // ArrayList to store accounts
        ArrayList<String[]> accountsFromFile = new ArrayList<String[]>();
        // Call method to store accounts from a file and get number of lines
        int lineCount = getAccountsFromFile(accountsFromFile, accountsFile);

        // Create CD List
        CertificateOfDepositList cdlist1 = new CertificateOfDepositList();

        for (int i = 0; i < lineCount; i++) {
            // Each Account Info
            String[] accountInfo = accountsFromFile.get(i);
            // Creating CD skeletons
            CertificateOfDeposit CDAccount = new CertificateOfDeposit(accountInfo);
            // Add accounts to the CD List
            cdlist1.addAccountToList(CDAccount);
        }
        // Print each accounts compured information
        cdlist1.accountReport();

    }

    private static int getAccountsFromFile(ArrayList<String[]> accountsFromFile, String accountFile) {
        int lineCount = 0;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(accountFile));
            String line = reader.readLine();

            while (line != null) {
                // Insert each item in the .txt into an array
                String[] words = line.split(" ");
                accountsFromFile.add(words);
                line = reader.readLine();
                lineCount++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineCount;
    }
}
