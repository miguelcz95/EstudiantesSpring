package com.estudiantes.notas.notasestudiantes.controller;

import com.estudiantes.notas.notasestudiantes.model.NotasModel;
import com.estudiantes.notas.notasestudiantes.service.INotasService;
import com.estudiantes.notas.notasestudiantes.service.notasserviceimpl.NotasServiceImpl;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class NotasControllerTest extends TestCase {

    List<NotasModel> listado;

    INotasService notasService = Mockito.mock(NotasServiceImpl.class);

    @Autowired
    NotasController notasController = new NotasController(notasService);

    @BeforeEach
    public void setUp() throws Exception {
        super.setUp();
        listado = new ArrayList<>();
        listado.add(new NotasModel(1, 1010, 5, 10));
        listado.add(new NotasModel(2, 2020, 3, 20));
        listado.add(new NotasModel(3, 3030, 4, 30));
        listado.add(new NotasModel(4, 4040, 2, 50));

    }

    public void testGetNotas() {
        Mockito.when(notasService.getNotas()).thenReturn(listado);
        System.out.println(notasController.getNotas());
    }
}