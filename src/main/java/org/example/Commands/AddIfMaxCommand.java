package org.example.Commands;

import org.example.Receiver;
import org.example.interfaces.Execute;

import java.util.ArrayList;

public class AddIfMaxCommand extends AbstractCommand implements Execute {

    public AddIfMaxCommand() {
        super("add_if_max", "add a new element to the collection if its value is greater than the value of the largest element in this collection", 13);
    }

    @Override
    public String execute(ArrayList<String> arguments, Receiver worker) {
        String id = arguments.remove(0);
        return worker.addMax(arguments, Integer.parseInt(id));
    }
}
