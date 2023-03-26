package org.example.Commands;

import org.example.Receiver;
import org.example.interfaces.Execute;

import java.util.ArrayList;

public class RemoveGreaterCommand extends AbstractCommand implements Execute {
    public RemoveGreaterCommand() {
        super("remove_greater", "remove from the collection all elements greater than the given", 1);
    }
    @Override
    public String execute(ArrayList<String> arguments, Receiver worker) {
        String id = arguments.remove(0);
        return worker.removeGreater(arguments , Integer.parseInt(id));
    }
}
