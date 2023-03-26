package org.example.Commands;

import org.example.Receiver;
import org.example.interfaces.Execute;

import java.util.ArrayList;

public class ShowCommand extends AbstractCommand implements Execute {
    public ShowCommand() {
        super("show", "print to standard output all elements of the collection in string representation", 0);
    }

    @Override
    public String execute(ArrayList<String> arguments, Receiver worker) {
        StringBuilder stringBuilder = new StringBuilder();
        if (worker.getMainCollection().size() == 0) {
            return "There is no elements in main collection.";
        }
        return worker.getMainCollection().toString();
    }
}
