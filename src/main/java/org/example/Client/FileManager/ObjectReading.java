package org.example.Client.FileManager;

import org.example.Commands.AbstractCommand;
import org.example.Commands.ExecuteScriptCommand;
import org.example.Validator.ValidateAbstract;
import org.example.Validator.ValidatorManager;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ObjectReading {
    public ArrayList<String> objread(AbstractCommand command , LinkedHashMap<String, String> fields) {
        ArrayList<String> extraArgs = new ArrayList<String>();
        try {
            OutStream.outputIntoCLI("Type extra data of object");
            if (command.isNeededExtraArgs()) {
                ValidatorManager validatorManager = new ValidatorManager();
                if(!command.getName().equals("execute_script")) {
                    int iter = 1;
                    /*идем по всем полям и ищем валидаторы */
                    while (iter < fields.keySet().size()) {
                        String field = fields.keySet().toArray()[iter].toString();
                        ValidateAbstract<?> validator = validatorManager.getValidator(field);
                        if (validator == null) {
                            iter++;
                            continue;
                        }
                        if (!field.equals("StudyGroup.id") && !field.equals("StudyGroup.creationDate")) {
                            OutStream.outputIntoCLI("Type '" + field + "'. Type of '" + field + "' is "
                                    + fields.get(field));
                        }
                        String valueOfField = InputClireader.getInputReader().nextLine().trim();

                        /*проверяем данные которые пришли на вход*/
                        if (validator.validate(valueOfField)) {
                            extraArgs.add(valueOfField);
                            iter++;
                        } else {
                            OutStream.outputIntoCLI("You've typed wrong value of field.");
                        }
                    }
                } else {
                    if (ExecuteScriptCommand.getReadedCommands().size() - ExecuteScriptCommand
                                .getCurrentCommand() < ExecuteScriptCommand.getCurrentCommand() + fields.size() - 1) {
                        return new ArrayList<String>();
                    }
                    System.out.println("ТУТ");
                    int startValue = ExecuteScriptCommand.getCurrentCommand();
                    for (int iter1 = startValue + 1; iter1 < ExecuteScriptCommand.getReadedCommands().size()
                            - startValue; iter1++) {
                        extraArgs.add(ExecuteScriptCommand.getReadedCommands().get(iter1).trim());
                        ExecuteScriptCommand.setCurrentCommand(ExecuteScriptCommand.getCurrentCommand() + 1);
                    }
                }
            }
        } catch (NullPointerException e) {
            OutStream.outputIntoCLI("\nInterrupting input stream.\n");
            extraArgs = new ArrayList<String>();
        }
    return extraArgs;
    }
}
