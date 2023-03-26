package org.example.Commands;

import org.example.Receiver;
import org.example.interfaces.Execute;

import java.util.ArrayList;

public class SumOfStudentsCountCommand extends AbstractCommand implements Execute {

    public SumOfStudentsCountCommand() {
        super("sum_of_students_count", "display the sum of the values of the studentsCount" +
                " field for all elements of the collection", 0);
    }

    @Override
    public String execute(ArrayList<String> arguments, Receiver worker) {
        return worker.sumOfStudentsCount();
    }
}
