package org.example;

import org.example.Client.FileManager.InputClireader;
import org.example.models.StudyGroup;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
//        var studyGroupsStack = new Stack<StudyGroup>();
//        var person = new Person("Liza", ZonedDateTime.now(), 34, "passport", Color.RED);
//        var coor = new Coordinates(34, 3434);
//        var studyGroupObj = new StudyGroup(1, "123", person, Semester.FIRST, FormOfEducation.DISTANCE_EDUCATION, coor, 34);
//        studyGroupsStack.push(studyGroupObj);
//        System.out.println(studyGroupsStack.contains(studyGroupObj));
//        var xmlFieHandler = new xmlFileHandler();
//        xmlFieHandler.save(studyGroupsStack, new File("studyGroups.xml"));
//
//        xmlFieHandler.load(new File("studyGroups.xml"));
//        var groups = xmlFieHandler.get();
//
        UniqueId id = new UniqueId();
        LocalDateBase localDateBase = new LocalDateBase(new Stack<StudyGroup>());
        Receiver receiver = new Receiver(localDateBase);
        Invoker invoker = new Invoker(receiver);
        InputClireader.openStream();
    }
}