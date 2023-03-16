package org.example;

import org.example.models.StudyGroup;

import java.util.Date;
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

}
