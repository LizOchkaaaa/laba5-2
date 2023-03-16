package org.example.Commands;

import org.example.Receiver;
import org.example.interfaces.Execute;

import java.util.ArrayList;


public class InfoCommand extends AbstractCommand implements Execute {
    public InfoCommand() {
        super("info", "print information about the collection to the standard output stream (type, initialization date, number of elements, etc" , 0);
    }
    @Override
    public String execute(ArrayList<String> arg , Receiver worker) {
        return null;
    }
}
