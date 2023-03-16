package org.example;

import org.example.Commands.*;
import org.example.exceptions.CommandInterruptedException;
import org.example.interfaces.Execute;
import org.example.interfaces.Loading;
import org.example.models.StudyGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Invoker {
    private static Receiver receiver;
    private static HashMap<String, AbstractCommand> commandsMap;
    public Invoker(Receiver receiver) {
        this.receiver = receiver;
        commandsMap = new HashMap<>();
        var helpCommand = new HelpCommand(commandsMap.values());
        var infoCommand = new InfoCommand();
        var exitCommand = new ExitCommand();
        var clearCommand = new ClearCommand();

        commandsMap.put("help", helpCommand);
        commandsMap.put("info", infoCommand);
        commandsMap.put("exit", exitCommand);
        commandsMap.put("clear", clearCommand);
    }
////        commandsMap.put("show", new ShowCommand(this));
////        commandsMap.put("add", new AddCommand(this));
////        commandsMap.put("update id", new UpdateIdCommand(this));
////        commandsMap.put("remove_by_id", new RemoveByIdCommand(this));
////        commandsMap.put("save", new SaveCommand(this));
////        commandsMap.put("execute_script", new ExecuteScriptCommand(this));

////        commandsMap.put("add_if_max", new AddIfMaxCommand(this));
////        commandsMap.put("remove_greater", new RemoveGreaterCommand(this));
////        commandsMap.put("reorder", new ReorderCommand(this));
////        commandsMap.put("sum_of_students_count", new SumOfStudentsCountCommand(this));
////        commandsMap.put("print_unique_form_of_education", new PrintUniqueFormOfEducationCommand(this));
////        commandsMap.put("print_field_ascending_students_count", new PrintFieldAscendingStudentsCountCommand(this));
////        CommandsContainer.setCommands(commandsMap.keySet().stream().toList());
//    }
//
    public static String execute(Execute command , ArrayList<String> arguments) {
        StringBuilder excution = new StringBuilder();
        excution.append(command.execute(arguments, receiver));
        return excution.toString();
    }

    public static HashMap<String, AbstractCommand> getCommandsMap(){
        return commandsMap;
    }
}
