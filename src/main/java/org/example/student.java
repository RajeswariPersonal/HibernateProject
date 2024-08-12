package org.example;


import jdk.jfr.SettingDefinition;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "stu")
public class student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @ElementCollection
    @CollectionTable(name = "student_phoneNumbers", joinColumns = @JoinColumn(name = "Id"))
    @Column(name = "phone_number")
    private Set<String> phoneNumbers;


    public List<Studentaddress> getStAddr() {
        return stAddr;
    }

    public void setStAddr(List<Studentaddress> stAddr) {
        this.stAddr = stAddr;
    }

    @ManyToMany(mappedBy = "student")

    private List<Studentaddress> stAddr = new ArrayList<Studentaddress>();

    public StudentName getName() {
        return Name;
    }

    public void setName(StudentName name) {
        Name = name;
    }

    ;
    private StudentName Name;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "student{" +
                "Id=" + Id +
                ", phoneNumbers=" + phoneNumbers +
                ", stAddr=" + stAddr +
                ", Name=" + Name +
                ", studentmarks=" + studentmarks +
                '}';
    }

    public StudentMarks getStudentmarks() {
        return studentmarks;
    }

    public void setStudentmarks(StudentMarks studentmarks) {
        this.studentmarks = studentmarks;
    }
    @OneToOne
    @JoinColumn(name = "Student_Mark_ID")
    private StudentMarks studentmarks;



}

@Entity
class  StudentMarks
{
    @Id
    @GeneratedValue
    private int Marks_ID ;
    private String TotalMarks;
    private String Percentage;

    public student getStudentobj() {
        return studentobj;
    }

    public int getMarks_ID() {
        return Marks_ID;
    }

    public void setMarks_ID(int marks_ID) {
        Marks_ID = marks_ID;
    }

    @Override
    public String toString() {
        return "StudentMarks{" +
                "Marks_ID=" + Marks_ID +
                ", TotalMarks='" + TotalMarks + '\'' +
                ", Percentage='" + Percentage + '\'' +
                ", studentobj=" + studentobj +
                '}';
    }

    public String getPercentage() {
        return Percentage;
    }

    public void setPercentage(String percentage) {
        Percentage = percentage;
    }

    public String getTotalMarks() {
        return TotalMarks;
    }

    public void setTotalMarks(String totalMarks) {
        TotalMarks = totalMarks;
    }

    public void setStudentobj(student studentobj) {
        this.studentobj = studentobj;
    }

    @JoinColumn(name = "Student_Mark_ID")
@OneToOne
    private student studentobj;

}

