//package org.example.Commands;
//
//import org.example.interfaces.Command;
//
//public class SaveCommand implements Command {
//    @Override
//    public String getName() {
//        return "save";
//    }
//
//    @Override
//    public String description() {
//        return "save collection to file";
//    }
//
//    @Override
//    public boolean execute(String[] args) {
//        commandManager.getCollectionManager().save();
//        commandManager.getUndoManager().saveLoggingFiles();
//        commandManager.getMessageHandler().displayToUser("collection was successfully saved");
//        return true;
//    }
//}
