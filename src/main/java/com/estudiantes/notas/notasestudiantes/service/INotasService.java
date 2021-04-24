package com.estudiantes.notas.notasestudiantes.service;

import com.estudiantes.notas.notasestudiantes.model.NotasModel;

import java.util.List;


public interface INotasService {

    List<NotasModel> getNotas();

    String addNota(NotasModel notasModel);

    String delNota(int idCedula, int idMateria);

    String getNotaF(NotasModel notasModel);

    String getNotaA();
}
