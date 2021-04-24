package com.estudiantes.notas.notasestudiantes.dao;

import com.estudiantes.notas.notasestudiantes.model.NotasModel;

import java.util.List;

public interface INotasDao {

    List<NotasModel> getNotas();

    NotasModel addNota(NotasModel notasModel);

    boolean delNota(int idCedula, int idMateria);
}
