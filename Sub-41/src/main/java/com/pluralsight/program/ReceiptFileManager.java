package com.pluralsight.program;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {
    public void writeNewReceipt(String receipt) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String formattedDate = localDateTime.format(formatter);

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(formattedDate + ".txt"));

            bufferedWriter.write(receipt);

            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(localDateTime.toString());
            e.printStackTrace();
            System.err.println("ERROR: Cannot write to file.");
        }
    }

    public String printReceipt(Order order) {
        return order.toString();
    }
}
