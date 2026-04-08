package receipts;

import model.Transaction;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReceiptGenerator {
    public static void generateReceipt(Transaction t) throws IOException {
        String directory = "src/receipts/generatedReceipts";
        String filename = "Receipt_" + t.getTransactionID() + "_" + t.getAccNumber() + ".txt";
        File obj = new File(directory + filename);
        obj.createNewFile();

        FileWriter writer = new FileWriter(directory + filename);
        writer.write("================  GG BANK ================\n");
        writer.write("Transaction Type : " + t.getTransactionType() + "\n");
        writer.write("Transaction ID   : " + t.getTransactionID() + "\n");

        if(t.getTransactionType().equalsIgnoreCase("transfer")){
            if(t.getDescription().contains("Withdrawal")){
                writer.write("Your account number   : " + t.getAccNumber() + "\n");
                writer.write("Receivers account number : " + t.getRelatedAccountNumber() + "\n");
            } else {
                writer.write("Your account number   : " + t.getAccNumber() + "\n");
                writer.write("Senders account number : " + t.getRelatedAccountNumber() + "\n");
            }
        } else {
            writer.write("Account Number   : " + t.getAccNumber() + "\n");
        }
        writer.write("Amount           : ₹ " + t.getAmount() + "\n");
        writer.write("Date             : " + t.getTimestamp() + "\n");
        writer.write("Description      : " + t.getDescription() + "\n");
        writer.write("==========================================");
        writer.close();



    }
//public static void generateReceipt(Transaction t) throws IOException {
//
//    String directory = "src/receipts/generatedReceipts";
//    String filename = "Receipt_" + t.getTransactionID() + "_" + t.getAccNumber() + ".txt";
//
//    File obj = new File(directory+ filename);
//    obj.createNewFile();
//
//    FileWriter writer = new FileWriter(directory + filename);
//
//    writer.write("================  GG BANK ================\n");
//    writer.write("Transaction Type : " + t.getTransactionType() + "\n");
//    writer.write("Transaction ID   : " + t.getTransactionID() + "\n");
//    writer.write("Account Number   : " + t.getAccNumber() + "\n");
//    writer.write("Amount           : ₹ " + t.getAmount() + "\n");
//    writer.write("Date             : " + t.getTimestamp() + "\n");
//    writer.write("Description      : " + t.getDescription() + "\n");
//    writer.write("==========================================");
//
//    writer.close();
//}
}