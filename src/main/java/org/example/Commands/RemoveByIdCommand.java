package org.example.Commands;

import org.example.Receiver;
import org.example.interfaces.Execute;
import org.example.models.StudyGroup;

import java.util.ArrayList;

public class RemoveByIdCommand extends AbstractCommand implements Execute {
    public RemoveByIdCommand() {
        super("remove by id", "remove element from collection by its id", 1);
    }

    @Override
    public String execute(ArrayList<String> arguments, Receiver worker) {
        String id = arguments.remove(0);
        return worker.removeID(id);
    }
}
