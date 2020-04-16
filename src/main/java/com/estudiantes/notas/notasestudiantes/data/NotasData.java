package com.estudiantes.notas.notasestudiantes.data;

import com.estudiantes.notas.notasestudiantes.model.NotasModel;

import java.util.ArrayList;
import java.util.List;

public class NotasData {

    public static List<NotasModel> listado;

    static {
        listado = new ArrayList<NotasModel>();
        listado.add(new NotasModel(1,1010,5,10));
        listado.add(new NotasModel(2,2020,3,20));
        listado.add(new NotasModel(3,3030,4,30));
        listado.add(new NotasModel(4,4040,2,50));
    }

    public static List<NotasModel> getListado() {
        return listado;
    }

    public static void setListado(List<NotasModel> listado) {
        NotasData.listado = listado;
    }
}
