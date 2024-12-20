package com.pluralsight.program;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReceiptFileManager {
    public static void writeNewReceipt(String receipt) {
        String fileName = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()) + ".txt";

        String folderPath = "receipts";
        String filePath = folderPath + "/" + fileName;

        try {
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));

            bufferedWriter.write(receipt);

            System.out.println("Thank you for your order, receipt saved to file.");
            bufferedWriter.close();
        } catch (Exception e) {
            System.err.println("ERROR: Cannot write to file.");
        }
    }
}
