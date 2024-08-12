package org.example;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class StudentName {
    private String fName;
    private String lName;

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    @Override
    public String toString() {
        return "StudentName{" +
                "fName='" + fName + '\'' +
                ", lName=" + lName +
                '}';
    }

    public void setfName(String fName) {
        this.fName = fName;
    }
}
