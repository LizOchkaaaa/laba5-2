package org.example.models;
import org.example.XmlUtils.DateTimeAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.ZonedDateTime;

@XmlRootElement(name="studyGroup")
public class StudyGroup implements Comparable<StudyGroup>{
    @XmlElement
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @XmlElement
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement
    private Coordinates coordinates; //Поле не может быть null
    @XmlElement
    @XmlJavaTypeAdapter(DateTimeAdapter.class)
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @XmlElement
    private int studentsCount; //Значение поля должно быть больше 0
    @XmlElement
    private FormOfEducation formOfEducation; //Поле не может быть null
    @XmlElement
    private Semester semesterEnum; //Поле может быть null
    @XmlElement
    private Person groupAdmin; //Поле не может быть null


    public StudyGroup(){}
    public StudyGroup(int id, String name, Person groupAdmin, Semester semesterEnum, FormOfEducation formOfEducation, Coordinates coordinates, int studentsCount) {
        this.id = id;
        this.name = name;
        this.creationDate = ZonedDateTime.now();
        this.groupAdmin = groupAdmin;
        this.semesterEnum = semesterEnum;
        this.formOfEducation = formOfEducation;
        this.coordinates = coordinates;
        this.studentsCount = studentsCount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Person getGroupAdmin() {
        return groupAdmin;
    }


    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public Semester getSemesterEnum() {
        return semesterEnum;
    }

    public FormOfEducation getFormOfEducation() {
        return formOfEducation;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public Person getPerson() {
        return groupAdmin;
    }

    @Override
    public int compareTo(StudyGroup prod) {
        return (int)(prod.getId() - getId());
    }

    @Override
    public String toString() {
        return id + " " + name + " " + creationDate;
    }
}
