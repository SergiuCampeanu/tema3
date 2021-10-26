package com.company;

import java.util.List;
import java.util.Objects;

public class Cursuri {

    private String name;
    private Profesor profesor;
    private int nrCredite;
    private int nrStudenti;
    private int nrMaxStudenti;
    private List<Student> studenti;

    public Cursuri(String name, Profesor profesor, int nrCredite, int nrStudenti, int nrMaxStudenti, List<Student> studenti) {
        this.name = name;
        this.profesor = profesor;
        this.nrCredite = nrCredite;
        this.nrStudenti = nrStudenti;
        this.nrMaxStudenti = nrMaxStudenti;
        this.studenti = studenti;
    }

    public void addStudent(Student s){
        studenti.add(s);
        nrStudenti+=1;
    }
    public void delStudent(Student s){
        studenti.remove(s);
        nrStudenti-=1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public int getNrCredite() {
        return nrCredite;
    }

    public void setNrCrdite(int nrCredite) {
        this.nrCredite = nrCredite;
    }

    public int getNrStudenti() {
        return nrStudenti;
    }

    public void setNrStudenti(int nrStudenti) {
        this.nrStudenti = nrStudenti;
    }

    public int getNrMaxStudenti() {
        return nrMaxStudenti;
    }

    public void setNrMaxStudenti(int nrMaxStudenti) {
        this.nrMaxStudenti = nrMaxStudenti;
    }

    public List<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Student> studenti) {
        this.studenti = studenti;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cursuri cursuri = (Cursuri) o;
        return nrCredite == cursuri.nrCredite && nrStudenti == cursuri.nrStudenti && nrMaxStudenti == cursuri.nrMaxStudenti && Objects.equals(name, cursuri.name) && Objects.equals(profesor, cursuri.profesor) && Objects.equals(studenti, cursuri.studenti);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, profesor, nrCredite, nrStudenti, nrMaxStudenti, studenti);
    }

    @Override
    public String toString() {
        return "Cursuri{" +
                "name='" + name + '\'' +
                ", profesor=" + profesor +
                ", nrCredite=" + nrCredite +
                ", nrStudenti=" + nrStudenti +
                ", nrMaxStudenti=" + nrMaxStudenti +
                ", studenti=" + studenti +
                '}';
    }
}
