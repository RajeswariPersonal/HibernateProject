package org.example;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        StudentName sname = new StudentName();
        sname.setfName("Firstna");
        sname.setlName("Lastna");

        Studentaddress sAdr = new Studentaddress();
        sAdr.setAddr1(("Add111111"));
        sAdr.setAddr2("Add222222");

        Set<String> phoneNumbers = new HashSet<>();
        phoneNumbers.add("9988776655");
        phoneNumbers.add("9876543210");
        phoneNumbers.add("8899776655");
        phoneNumbers.add("9876543210");

        StudentMarks studentmarks = new StudentMarks();
        studentmarks.setPercentage("77");
        studentmarks.setTotalMarks("888");


        student obj = new student();
        obj.setName(sname);
        obj.getStAddr().add(sAdr);
        obj.setPhoneNumbers(phoneNumbers);
        sAdr.getStdnt().add(obj);
        obj.setStudentmarks(studentmarks);


        org.hibernate.cfg.Configuration con = new Configuration().configure().addAnnotatedClass(student.class).addAnnotatedClass(Studentaddress.class).addAnnotatedClass(StudentMarks.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction txn = session.beginTransaction();
        session.persist(studentmarks);
       session.persist(obj);
       session.persist(sAdr);

        //updata data

      //  StudentName snameobj = new StudentName();
       // sname.setfName("Abi");
      //  sname.setlName("Bhaji");


       // student  stuObj = (student)session.get(student.class, 1);
       // stuObj.setName(snameobj);
      //  session.update(stuObj);


    //    Studentaddress  stuaddrObj = (Studentaddress)session.get(Studentaddress.class, 7);
    //    stuaddrObj.setAddr2("CHRT");
    //    session.update(stuaddrObj);

        //Delete data
       //student  studelobj = (student)session.get(student.class, 1);
       //session.delete(studelobj);


        txn.commit();

        session.close();
        sessionFactory.close();

    }
}