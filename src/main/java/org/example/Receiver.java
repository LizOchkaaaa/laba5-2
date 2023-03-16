package org.example;

import org.example.models.StudyGroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

public class Receiver {
    private final LocalDateBase localDateBase;

    public Receiver(LocalDateBase localDateBase) {
        this.localDateBase = localDateBase;
//        var readerXml = new xmlFileHandler();
//        localDateBase.setMainCollection(readerXml.get());
    }

    public Date getDateOfInitialization() {
        return localDateBase.getDateOfInitialization();
    }

    public Stack<StudyGroup> getMainCollection() {
        return localDateBase.getMainCollection();
    }

    public Date getDateOfLastChange() {
        return localDateBase.getDateOfLastChange();
    }

    public void setDateOfLastChange(){
        localDateBase.setDateOfLastChange(new Date());
    }

    public LocalDateBase getLocalDateBase() {
        return localDateBase;
    }
    public String clearCollection() {
        if (getMainCollection().size() != 0) {
            getMainCollection().clear();
            return "Main collection cleared";
        }
        else {
            return "There is no elements in main collection";
        }
    }
    public String saveCollection() {
        return new xmlFileHandler.save(getMainCollection());
    }

}
