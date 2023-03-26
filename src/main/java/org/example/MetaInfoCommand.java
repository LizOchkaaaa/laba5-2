package org.example;

import org.example.Commands.AbstractCommand;
import org.example.Factores.StudyGroupFactory;
import org.example.interfaces.Execute;
import org.example.models.StudyGroup;
import org.example.models.StudyGroups;

import java.lang.reflect.Field;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Stack;

public class MetaInfoCommand {

    private static HashMap<String, AbstractCommand> mapOfCommand;
    private  static LinkedHashMap<String, String> fields;


    /*взяли все команды из Invoker*/
    public MetaInfoCommand() {
        mapOfCommand = Invoker.getCommandsMap();
        fields = new FieldFetcher().fetchFields();
    }

    public HashMap<String, AbstractCommand> getMapOfCommand() {
        return mapOfCommand;
    }

    public static LinkedHashMap<String, String> getFields() {
        return fields;
    }





}
