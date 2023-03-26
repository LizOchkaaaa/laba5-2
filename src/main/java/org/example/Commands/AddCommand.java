package org.example.Commands;


import org.example.Receiver;
import org.example.UniqueId;
import org.example.interfaces.Execute;

import java.util.ArrayList;
import java.util.Collection;

public class AddCommand extends AbstractCommand implements Execute {

    public AddCommand() {
        super("add", "add a new element to the collection" , 11);
    }

    @Override
    public String execute(ArrayList<String> arguments, Receiver worker) {
        String id = arguments.remove(0);
        return worker.addNew(arguments, Integer.parseInt(id));
    }
}
