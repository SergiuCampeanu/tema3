package com.company;

import java.util.List;
import java.util.Objects;

public class Profesor {
    private String name, vorName;
    private int nrProf;
    private List<Cursuri> cursuri;

    public Profesor(String name, String vorName, int nrProf, List<Cursuri> cursuri) {
        this.name = name;
        this.vorName = vorName;
        this.nrProf = nrProf;
        this.cursuri = cursuri;
    }

    public void addCurs(Cursuri c){
        cursuri.add(c);
    }
    public void delCurs(Cursuri c){
        cursuri.remove(c);
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getVorName() {
        return vorName;
    }

    public void setVorName(String vorName) {
        this.vorName = vorName;
    }

    public int getNrProf() {
        return nrProf;
    }

    public void setNrProf(int nrProf) {
        this.nrProf = nrProf;
    }

    public List<Cursuri> getCursuri() {return cursuri;}

    public void setCursuri(List<Cursuri> cursuri) {this.cursuri = cursuri;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profesor profesor = (Profesor) o;
        return nrProf == profesor.nrProf && Objects.equals(name, profesor.name) && Objects.equals(vorName, profesor.vorName) && Objects.equals(cursuri, profesor.cursuri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vorName, nrProf, cursuri);
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "name='" + name + '\'' +
                ", vorName='" + vorName + '\'' +
                ", nrProf=" + nrProf +
                ", cursuri=" + cursuri +
                '}';
    }
}
