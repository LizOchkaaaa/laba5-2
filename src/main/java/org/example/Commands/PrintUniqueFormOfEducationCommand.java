package org.example.Commands;

import org.example.Receiver;
import org.example.interfaces.Execute;

import java.util.ArrayList;

public class PrintUniqueFormOfEducationCommand extends AbstractCommand implements Execute {
    public PrintUniqueFormOfEducationCommand() {
        super("print_unique_form_of_education", "print the unique values of the" +
                "formOfEducation field of all elements in the collection", 1);
    }

    @Override
    public String execute(ArrayList<String> arguments, Receiver worker) {
        return worker.printEnum(arguments);
    }
}
