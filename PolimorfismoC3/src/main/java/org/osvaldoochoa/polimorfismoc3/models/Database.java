package org.osvaldoochoa.polimorfismoc3.models;
import java.util.ArrayList;

public interface Database {
    boolean addStudent( ArrayList<Student> estudiantes);
    void saveStudent(Student student);
    void updateStudent(Student student);
}