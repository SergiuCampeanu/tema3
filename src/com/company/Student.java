package com.company;
import java.util.Objects;
import java.util.List;

public class Student{
    private String name, vorName;
    private int nrMatricol, nrCredite;
    private List<Cursuri> cursuri;

    public Student(String name, String vorName, int nrMatricol, int nrCredite, List<Cursuri> cursuri) {
        this.name = name;
        this.vorName = vorName;
        this.nrMatricol = nrMatricol;
        this.nrCredite = nrCredite;
        this.cursuri = cursuri;
    }

    public void addCurs(Cursuri c){
        cursuri.add(c);
        nrCredite+=c.getNrCredite();
    }
    public void delCurs(Cursuri c){
        cursuri.remove(c);
        nrCredite-=c.getNrCredite();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getVorname() {
        return vorName;
    }

    public void setVorname(String vorname) {
        this.vorName = vorname;
    }

    public int getNrMatricol() {
        return nrMatricol;
    }

    public void setNrMatricol(int nrMatricol) {
        this.nrMatricol = nrMatricol;
    }

    public int getNrCredite() {
        return nrCredite;
    }

    public void setNrCredite(int nrCredite) {
        this.nrCredite = nrCredite;
    }

    public List<Cursuri> getCursuri() {
        return cursuri;
    }

    public void setCursuri(List<Cursuri> cursuri) {
        this.cursuri = cursuri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return nrMatricol == student.nrMatricol && nrCredite == student.nrCredite && Objects.equals(name, student.name) && Objects.equals(vorName, student.vorName) && Objects.equals(cursuri, student.cursuri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vorName, nrMatricol, nrCredite, cursuri);
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + name + '\'' +
                ", vorname='" + vorName + '\'' +
                ", nrMatricol=" + nrMatricol +
                ", nrCredite=" + nrCredite +
                ", cursuri=" + cursuri +
                '}';
    }
}
