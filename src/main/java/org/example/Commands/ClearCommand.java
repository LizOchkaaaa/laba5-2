package org.example.Commands;

import org.example.Receiver;
import org.example.interfaces.Execute;

import java.util.ArrayList;

public class ClearCommand extends AbstractCommand implements Execute {
    public ClearCommand() {
        super("clear", "clear the collection", 0);
    }
    @Override
    public String execute(ArrayList<String> arguments, Receiver worker) {
        return worker.clearCollection();
    }
}
