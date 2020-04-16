package com.estudiantes.notas.notasestudiantes.model;

import java.util.Objects;

public class NotasModel {

    private int idCedula;
    private int idMateria;
    private int nota;
    private int porcenaje;

    public NotasModel() {
    }

    public NotasModel(int idCedula) {
        this.idCedula = idCedula;
    }

    public NotasModel(int idCedula, int idMateria) {
        this.idCedula = idCedula;
        this.idMateria = idMateria;
    }

    public NotasModel(int idCedula, int idMateria, int nota, int porcenaje) {
        this.idCedula = idCedula;
        this.idMateria = idMateria;
        this.nota = nota;
        this.porcenaje = porcenaje;
    }

    public int getIdCedula() {
        return idCedula;
    }

    public void setIdCedula(int idCedula) {
        this.idCedula = idCedula;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getPorcenaje() {
        return porcenaje;
    }

    public void setPorcenaje(int porcenaje) {
        this.porcenaje = porcenaje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotasModel that = (NotasModel) o;
        return idCedula == that.idCedula;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCedula);
    }
}
