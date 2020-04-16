package com.estudiantes.notas.notasestudiantes.service.notasServiceImpl;

import com.estudiantes.notas.notasestudiantes.dao.INotasDao;
import com.estudiantes.notas.notasestudiantes.model.NotasModel;
import com.estudiantes.notas.notasestudiantes.service.INotasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotasServiceImpl implements INotasService {

    @Autowired
    INotasDao dao;

    @Override
    public List<NotasModel> getNotas() {
        return dao.getNotas();
    }

    @Override
    public String addNota(NotasModel notasModel) {
        int sumP = 0;
        if (notasModel.getNota() > 0 && notasModel.getNota() <= 5) {
            if (notasModel.getPorcenaje() >= 10 && notasModel.getPorcenaje() <= 100) {
                for (int i = 0; i < getNotas().size(); i++) {
                    if (notasModel.getIdCedula() == getNotas().get(i).getIdCedula()) {
                        sumP = getNotas().get(i).getPorcenaje() + notasModel.getPorcenaje();
                    }
                }
                if (sumP <= 100) {
                    dao.addNota(notasModel);
                    return "Nota agregada";
                }
                return "Los porcentajes suman mas de 100";
            }
            return "El porcentaje tiene que ser entre 10 y 100";
        }
        return "La nota tiene que ser entre 0 y 5";
    }

    @Override
    public String delNota(int idCedula, int idMateria) {
        if (dao.delNota(idCedula, idMateria) == true) {
            return "Se elimino correctamente";
        }
        return "No se elimino la nota";
    }

    @Override
    public String getNotaF(NotasModel notasModel) {
        float notaF = 0;
        for (int i = 0; i < getNotas().size(); i++) {
            if ((notasModel.getIdCedula() == getNotas().get(i).getIdCedula()) && (notasModel.getIdMateria() == getNotas().get(i).getIdMateria())) {
                notaF += getNotas().get(i).getNota() * getNotas().get(i).getPorcenaje();
            }
        }
        return "la nota definitiva es " + (notaF / 100);
    }

    @Override
    public String getNotaA() {
        float notaA = 0;
        for (int i = 0; i < getNotas().size(); i++) {
            if (getNotas().get(i).getNota() > notaA) {
                notaA = getNotas().get(i).getNota();
            }
        }
        return "La nota mas alta es: " + notaA;
    }
}
