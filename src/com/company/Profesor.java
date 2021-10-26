package com.company;

import java.util.Objects;

public class Profesor {
    private String name, vorName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorName() {
        return vorName;
    }

    public void setVorName(String vorName) {
        this.vorName = vorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profesor profesor = (Profesor) o;
        return Objects.equals(name, profesor.name) && Objects.equals(vorName, profesor.vorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vorName);
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "name='" + name + '\'' +
                ", vorName='" + vorName + '\'' +
                '}';
    }
}
