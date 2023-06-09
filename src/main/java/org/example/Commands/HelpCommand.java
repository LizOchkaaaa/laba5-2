package org.example.Commands;
import org.example.Receiver;
import org.example.interfaces.Execute;

import java.util.ArrayList;
import java.util.Collection;

public class HelpCommand extends AbstractCommand implements Execute {

    Collection<AbstractCommand> collectionOfCommands;

    public HelpCommand(Collection<AbstractCommand> collectionOfCommands) {
        super("help", "display help on available commands" , 0);
        this.collectionOfCommands = collectionOfCommands;
    }

    @Override
    public String execute(ArrayList<String> arguments , Receiver worker) {
        StringBuilder execution = new StringBuilder();
        for (Execute command : collectionOfCommands) {
            execution.append(command.toString() + "\n");
        }
        execution.delete(execution.toString().length() - 1, execution.toString().length());
        return execution.toString();
    }
}
