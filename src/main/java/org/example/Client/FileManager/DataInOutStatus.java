package org.example.Client.FileManager;

public enum DataInOutStatus {
    FAILED ("Failed"),
    SUCCESSFULLY("Successfully"),
    WRONGARGS ("Wrong args"),
    NOCOMMAND ("No command");

    private String name;

    public String getName(){
        return name;
    }

    DataInOutStatus(String message) {
        name = message;
    }

}
