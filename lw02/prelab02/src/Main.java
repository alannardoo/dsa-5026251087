import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(Main.class.getResourceAsStream("transactions.txt"));

        LinkedList<String[]> processList = new LinkedList<>();
        LinkedList<String[]> customerList = new LinkedList<>();
        Queue<String[]> custTransaction = new LinkedList<>();
        Stack<String[]> failedTransactions = new Stack<>();

        // Read file
        while (sc.hasNextLine()) {

            String line = sc.nextLine();
            String[] lineSplit = line.split(" ");

            processList.add(lineSplit);
        }

        //Create unique customer list
        for (String[] transaction : processList) {

            boolean difference = false;
            String custName = transaction[0];

            for (String[] customer : customerList) {

                if (custName.equals(customer[0])) {
                    difference = true;
                    break;
                }
            }

            if (!difference) {
                String[] newCustomer = { transaction[0], "0" };
                customerList.add(newCustomer);
            }
        }

        //Transfer to Queue
        for (String[] transaction : processList) {
            custTransaction.add(transaction);
        }

        // Process Queue
        while (!custTransaction.isEmpty()) {

            String[] transaction = custTransaction.poll();

            String custName = transaction[0];
            String transactionType = transaction[1];
            int amount = Integer.parseInt(transaction[2]);

            for (String[] customer : customerList) {

                if (custName.equals(customer[0])) {

                    int currentBalance = Integer.parseInt(customer[1]);

                    if (transactionType.equals("DEPOSIT")) {

                        currentBalance += amount;
                        customer[1] = String.valueOf(currentBalance);

                    } else if (transactionType.equals("WITHDRAW")) {
                        if (currentBalance >= amount) {
                            currentBalance -= amount;
                            customer[1] = String.valueOf(currentBalance);
                        } else {
                            failedTransactions.push(transaction);

                        }
                    }

                    break;
                }
            }
        }

        //Print result
        System.out.println("=== Final Balances ===");

        for (String[] customer : customerList) {
            System.out.println(customer[0] + " " + customer[1]);
        }
        System.out.println("=== Failed Transactions ===");
        while (!failedTransactions.isEmpty()) {
            String[] failedTransaction = failedTransactions.pop();
            System.out.println(
                    failedTransaction[0] + " " +failedTransaction[1] + " " + failedTransaction[2]);
        }
    }
}