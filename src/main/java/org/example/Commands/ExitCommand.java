package org.example.Commands;

import org.example.Receiver;
import org.example.interfaces.Execute;

import java.util.ArrayList;

public class ExitCommand extends AbstractCommand implements Execute {
    public ExitCommand() {
        super("exit", "terminate program (without saving to file)", 0);
    }
    @Override
    public String execute(ArrayList<String> arguments, Receiver worker) {
        return "";
    }
}
