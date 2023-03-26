package org.example.Client.FileManager;

import org.example.Client.FileManager.CommandValidator;
import org.example.Client.FileManager.DataInOutStatus;
import org.example.Client.FileManager.OutStream;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Scanner;

public class InputClireader {
     /* вызываем входящий поток */
     private static Scanner inputReader = new Scanner(System.in);

     public static Scanner getInputReader() {
         return inputReader;
     }
     public static DataInOutStatus openStream() {
         try {
             String inputData = inputReader.nextLine();
             OutStream.outputIntoCLI("Type commands");
             while (inputData != null) {
                 if (!inputData.equals("exit")) {
                     inputData = inputData.trim();
                     DataInOutStatus checkedCommand = new CommandValidator().validate(inputData);
                     if (checkedCommand != DataInOutStatus.SUCCESSFULLY) {
                         OutStream.outputIntoCLI(checkedCommand.getName());
                     }
                 } else {
                     inputReader.close();
                 }
                 inputData = inputReader.nextLine();
             }
             return DataInOutStatus.SUCCESSFULLY;
         } catch (NullPointerException e) {
             System.out.println("Какой-то эксепшон");
             return DataInOutStatus.FAILED;
         }
     }
}
