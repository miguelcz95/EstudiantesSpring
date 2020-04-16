package com.estudiantes.notas.notasestudiantes.dao.notasDaoImpl;

import com.estudiantes.notas.notasestudiantes.dao.INotasDao;
import com.estudiantes.notas.notasestudiantes.data.NotasData;
import com.estudiantes.notas.notasestudiantes.model.NotasModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NotasDaoImpl implements INotasDao {


    @Override
    public List<NotasModel> getNotas() {
        return NotasData.getListado();
    }

    @Override
    public NotasModel addNota(NotasModel notasModel) {
        List<NotasModel> listado = NotasData.getListado();
        listado.add(notasModel);
        NotasData.setListado(listado);
        return notasModel;
    }

    @Override
    public boolean delNota(int idCedula, int idMateria) {
        List<NotasModel> listado = NotasData.getListado();
        listado.remove(new NotasModel(idCedula,idMateria));
        NotasData.setListado(listado);
        return true;
    }
}
