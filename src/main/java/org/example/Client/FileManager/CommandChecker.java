package org.example.Client.FileManager;

import org.example.Commands.AbstractCommand;
import org.example.Invoker;
import org.example.MetaInfoCommand;
import org.example.UniqueId;
import org.example.interfaces.Execute;

import java.io.OutputStream;
import java.util.*;

public class CommandChecker {
    public DataInOutStatus checkCorrectnessOfCommand(String commandName , ArrayList<String> argumentsToCommand) {
        DataInOutStatus correctnessStatus = DataInOutStatus.SUCCESSFULLY;
        MetaInfoCommand metaInfoCommand = new MetaInfoCommand();
        /*обращаемся ко всем коммандам и смотрим есть ли такая команда вообще */
        Map<String, AbstractCommand> mapCommand = metaInfoCommand.getMapOfCommand();
        /*ищем по имени */
        if (mapCommand.containsKey(commandName)) {
            /* создаем объект команды */
            AbstractCommand command = mapCommand.get(commandName);
            if (command.getExtraArgs() == 0 && argumentsToCommand.size() != 0) {
                return DataInOutStatus.WRONGARGS;
            }
            if (command.getExtraArgs() >= 1) {
                if (command.getName().equals("update")) {
                    if (argumentsToCommand.size() == 0) {
                        return DataInOutStatus.FAILED;
                    } else {
                        correctnessStatus = checkCorrectnessOfComplicatedCommand(command, argumentsToCommand);
                    }
                } else {
                    argumentsToCommand.add(String.valueOf(UniqueId.getNewId()));
                    correctnessStatus = checkCorrectnessOfComplicatedCommand(command, argumentsToCommand);
                }
            }
            if (correctnessStatus == DataInOutStatus.SUCCESSFULLY) {
                OutStream.outputIntoCLI(Invoker.execute(command, argumentsToCommand));
            }
        } else {
            return DataInOutStatus.NOCOMMAND;
        }
        return DataInOutStatus.SUCCESSFULLY;
    }


    /*проверяем команду у которой много аргусентов на правильность введения */
    private DataInOutStatus checkCorrectnessOfComplicatedCommand(AbstractCommand command, ArrayList<String> argumentsToCommand) {
        DataInOutStatus correctnessStatus = DataInOutStatus.SUCCESSFULLY;
        if (command.getExtraArgs() == 1 && argumentsToCommand.size() == 1) {
            correctnessStatus = DataInOutStatus.SUCCESSFULLY;
            return correctnessStatus;
        }
        if (command.getExtraArgs() > 1) {
            CommandDataChecker commandChecker = new CommandDataChecker();
            correctnessStatus = commandChecker.checkInputCommand(command);
            if (correctnessStatus == DataInOutStatus.SUCCESSFULLY) {
                argumentsToCommand.addAll(commandChecker.getExtraArgs());
            }
            if (argumentsToCommand.size() == 0) {
                return DataInOutStatus.WRONGARGS;
            }
        }
        return correctnessStatus;
    }
}
