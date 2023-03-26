package org.example.Commands;

import org.example.Receiver;
import org.example.interfaces.Execute;

import java.util.ArrayList;

public class UpdateIdCommand extends AbstractCommand implements Execute {
    public UpdateIdCommand() {
        super("update", "update the value of the collection element whose" +
                " id is equal to the given one", 11);
    }

    @Override
    public String execute(ArrayList<String> arguments, Receiver worker) {
        String id = arguments.remove(0);
        try {
            return worker.update(arguments, Integer.parseInt(id));
        } catch (NumberFormatException e) {
            return "Failed. Wrong Id.";
        }
    }
}

