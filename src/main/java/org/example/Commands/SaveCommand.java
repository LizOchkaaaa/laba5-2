package org.example.Commands;

import org.example.Client.FileManager.OutStream;
import org.example.Receiver;
import org.example.interfaces.Command;
import org.example.interfaces.Execute;

import java.util.ArrayList;

public class SaveCommand extends AbstractCommand implements Execute {
    public SaveCommand() {
        super("save", "save collection to file", 0);
    }

    @Override
    public boolean execute(String[] args) {
        commandManager.getCollectionManager().save();
        commandManager.getUndoManager().saveLoggingFiles();
        commandManager.getMessageHandler().displayToUser("collection was successfully saved");
        return true;
    }

    @Override
    public String execute(ArrayList<String> arguments, Receiver worker) {

    }
}
