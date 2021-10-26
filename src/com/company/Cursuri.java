package com.company;

import java.util.List;
import java.util.Objects;

public class Cursuri {

    private String name;
    private Profesor profesor;
    private int nrStudenti;
    private List<Student> studenti;

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

    public int getNrStudenti() {
        return nrStudenti;
    }

    public void setNrStudenti(int nrStudenti) {
        this.nrStudenti = nrStudenti;
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
        return nrStudenti == cursuri.nrStudenti && Objects.equals(name, cursuri.name) && Objects.equals(profesor, cursuri.profesor) && Objects.equals(studenti, cursuri.studenti);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, profesor, nrStudenti, studenti);
    }

    @Override
    public String toString() {
        return "Cursuri{" +
                "name='" + name + '\'' +
                ", profesor=" + profesor +
                ", nrStudenti=" + nrStudenti +
                ", studenti=" + studenti +
                '}';
    }
}
