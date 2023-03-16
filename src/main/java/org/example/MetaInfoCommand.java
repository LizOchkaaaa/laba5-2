package org.example;

import org.example.Commands.AbstractCommand;
import org.example.interfaces.Execute;

import java.util.HashMap;
import java.util.Stack;

public class MetaInfoCommand {

    private static HashMap<String, AbstractCommand> mapOfCommand;


    /*взяли все команды из Invoker*/
    public MetaInfoCommand() {
        mapOfCommand = Invoker.getCommandsMap();
    }

    public HashMap<String, AbstractCommand> getMapOfCommand() {
        return mapOfCommand;
    }


}
