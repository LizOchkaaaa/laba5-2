package org.example.Commands;

import org.example.Receiver;
import org.example.interfaces.Execute;

import java.util.ArrayList;

public class ReorderCommand extends AbstractCommand implements Execute {
    public ReorderCommand() {
        super("reorder", "sort the collection in reverse order", 0);
    }
    @Override
    public String execute(ArrayList<String> arguments, Receiver worker) {
        return worker.reorder().toString();
    }
}
