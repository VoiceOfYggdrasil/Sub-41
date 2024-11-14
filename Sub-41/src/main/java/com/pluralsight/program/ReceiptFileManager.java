package com.pluralsight.program;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReceiptFileManager {
    public static void writeNewReceipt(String receipt) {
        String fileName = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()) + ".txt";

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

            bufferedWriter.write(receipt);

            System.out.println("Thank you for your order, receipt saved to file.");
        } catch (Exception e) {
            System.err.println("ERROR: Cannot write to file.");
        }
    }

    public String printReceipt(Order order) {
        return order.toString();
    }
}
