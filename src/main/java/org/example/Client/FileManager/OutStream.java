package org.example.Client.FileManager;

public class OutStream {
    public static DataInOutStatus outputIntoCLI(String strCLI) {
        System.out.println(strCLI);
        return DataInOutStatus.SUCCESSFULLY;
    }
}
