package org.example.Commands;

import org.example.Receiver;
import org.example.interfaces.Execute;

import java.util.ArrayList;

public class SaveCommand extends AbstractCommand implements Execute {
    public SaveCommand() {
        super("save", "save collection to file", 0);
    }
    @Override
    public String execute(ArrayList<String> arguments, Receiver worker) {
        return worker.saveCollection();
    }
}
