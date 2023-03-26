package org.example;

import org.example.Factores.StudyGroupFactory;
import org.example.models.FormOfEducation;
import org.example.models.StudyGroup;

import java.io.File;
import java.util.*;

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

    public void setDateOfLastChange() {
        localDateBase.setDateOfLastChange(new Date());
    }

    public LocalDateBase getLocalDateBase() {
        return localDateBase;
    }

    public String clearCollection() {
        if (getMainCollection().size() != 0) {
            getMainCollection().clear();
            return "Main collection cleared";
        } else {
            return "There is no elements in main collection";
        }
    }

    public String saveCollection() {
        try {
            if (new xmlFileHandler().save(getMainCollection(), new File("file.xml"))) {
                return "Collection load successfully";
            } else  {
                return "Faild";
            }
        } catch (Exception e) {
            return "exception";
        }
    }

    public String addNew(ArrayList<String> arguments , Integer id) {
        if (getMainCollection().add(new StudyGroupFactory().createStudyGroup(id,  arguments))) {
            return "Successfully";
        };
        return "Adding new StudyGroup failed.";
    }


    public String addMax(ArrayList<String> arguments , Integer id) {
        StudyGroup studyGroup = new StudyGroupFactory().createStudyGroup(id,  arguments);
        var iter = 0 ;
        for (StudyGroup studyGroup1 : this.getMainCollection() ) {
            if (studyGroup1.compareTo(studyGroup) > 0) {
                iter++;
            }
        }
        getMainCollection().add(studyGroup);
         if (iter == 0) {
             getMainCollection().add(studyGroup);
             return "Successfully";
         }
         return "Element was not added into the main collection. There is at least one element bigger than typed";
    }

    public String printEnum() {
        Stack<FormOfEducation> setOfFormOfEducation = new Stack<>();
        for (StudyGroup group : getMainCollection()) {
            if (!setOfFormOfEducation.contains(group.getFormOfEducation())) {
                setOfFormOfEducation.add(group.getFormOfEducation());
            }
        }
        return setOfFormOfEducation.toString();
    }


    public void remove(StudyGroup group){
        this.getMainCollection().remove(group);
    }



    public String  removeGreater(ArrayList<String> arguments , Integer id) {
        StudyGroup studyGroup = new StudyGroupFactory().createStudyGroup(id,  arguments);
        int countRemoved = 0;
        for (StudyGroup studyGroup1 : this.getMainCollection() ) {
            if (studyGroup1.compareTo(studyGroup) > 0) {
                getMainCollection().remove(studyGroup1);
                countRemoved++;
            }
        }
        return  "Successfully removed "  + countRemoved + " StudyGroups";
    }
    public String printEnum(ArrayList<String> arguments) {
        Stack<FormOfEducation> setOfFormOfEducation = new Stack<>();
        for (StudyGroup group : getMainCollection()) {
            if (!setOfFormOfEducation.contains(group.getFormOfEducation())) {
                setOfFormOfEducation.add(group.getFormOfEducation());
            }
        }
        return setOfFormOfEducation.toString();

    }

    public String sumOfStudentsCount() {
        int sumOfStudentsCountValue = 0;
        Stack<StudyGroup> mainCollection = this.getMainCollection();
        for (StudyGroup group : mainCollection) {
            sumOfStudentsCountValue += group.getStudentsCount();
        }

        return "Sum of all StudentsCount in Study Group = " + sumOfStudentsCountValue;
    }

    public String removeID(String idValue) {
        int id = Integer.parseInt(idValue);
        Stack<StudyGroup> mainCollection = this.getMainCollection();
        for (StudyGroup group : mainCollection) {
            if (group.getId() == id) {
                this.remove(group);
                return "Successfully";
            }
        }
        return "There is no element with that id.";
    }


    public String reorder() {
        var a = getMainCollection();
        if(a.size() != 0) {
            a.sort(StudyGroup::compareTo);
        }
        else {
            return a.toString() + " " + "There are not elements";
        }
        return a.toString();
    }

    public String update(ArrayList<String> arguments , Integer id) {
        StudyGroup studyGroup = new StudyGroupFactory().createStudyGroup(id,  arguments);
        var iter = 0;
        var succses = false;
        System.out.println("лох");
        for (StudyGroup studyGroup1 : this.getMainCollection() ) {
            if (studyGroup1.getId() == id) {
                getMainCollection().remove(id);
                getMainCollection().add(iter , studyGroup);
                succses = true;
            }
            iter++;
        }
        if(!succses) {
            return "Element was not updated";
        }
        else {
            return "Element updated successfully";
        }

    }
}
