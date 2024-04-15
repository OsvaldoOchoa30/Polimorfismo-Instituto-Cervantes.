package org.osvaldoochoa.polimorfismoc3.models;
import java.util.ArrayList;

public class Sistema {
    private ArrayList<Database> basesDeDatos = new ArrayList<>();
    private ArrayList<Student> estudiantes = new ArrayList<>();

    public Sistema(Database... bases) {
        for (Database base : bases) {
            basesDeDatos.add(base);
        }
    }

    public Boolean addAlumno(Student student){
        estudiantes.add(student);
        return true;
    }

    public void addBaseDatos(){
        for (Database base : basesDeDatos) {
            base.addStudent(estudiantes);
        }
    }

    public ArrayList<Student> getEstudiantes() {
        return estudiantes;
    }

    public void updateAlumno(Student student){
        for (Database base : basesDeDatos) {
            base.updateStudent(student);
            System.out.println("Estudiante actualizado en la base de datos: " + base.getClass().getSimpleName());
        }
    }

    public void saveAlumno(Student student) {
        for (Database base : basesDeDatos){
            base.saveStudent(student);
            System.out.println("Estudiante en la base de datos: " + base.getClass().getSimpleName());
        }
    }
}
