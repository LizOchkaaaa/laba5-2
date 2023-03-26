package org.example.Client.FileManager;

import org.example.Commands.AbstractCommand;
import org.example.MetaInfoCommand;

import java.util.ArrayList;

public class CommandDataChecker {
    private ArrayList<String> extraArgs = new ArrayList<>();

    public ArrayList<String> getExtraArgs() {
        return extraArgs;
    }

    public DataInOutStatus checkInputCommand(AbstractCommand command) {
        if (command.getExtraArgs() > 1) {
            var fields = MetaInfoCommand.getFields();
            extraArgs = new ObjectReading().objread(command , fields);
            if (extraArgs.size() == 0) {
                return DataInOutStatus.FAILED;
            }
        }
        return DataInOutStatus.SUCCESSFULLY;
    }
}
