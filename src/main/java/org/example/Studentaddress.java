package org.example;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Studentaddress {

    public int getAddrID() {
        return AddrID;
    }

    public void setAddrID(int addrID) {
        AddrID = addrID;
    }

    @Id
    @GeneratedValue
    private int AddrID;

    @Column(name = "StuAddress1")
    private String Addr1;
    private String Addr2;

    public String getAddr1() {
        return Addr1;
    }

    public List<student> getStdnt() {
        return student;
    }

    public void setStdnt(List<student> stdnt) {
        this.student = stdnt;
    }
@ManyToMany
@JoinTable(
        name = "StudentAddr_tbl",
        joinColumns = { @JoinColumn(name = "Studentid") },
        inverseJoinColumns = { @JoinColumn(name = "StudentAddressid") }
)
    private  List<student> student = new ArrayList<student>();


    @Override
    public String toString() {
        return "Studentaddress{" +
                "Addr1='" + Addr1 + '\'' +
                ", Addr2='" + Addr2 + '\'' +
                '}';
    }

    public void setAddr1(String addr1) {
        Addr1 = addr1;
    }

    public String getAddr2() {
        return Addr2;
    }

    public void setAddr2(String addr2) {
        Addr2 = addr2;
    }
}
