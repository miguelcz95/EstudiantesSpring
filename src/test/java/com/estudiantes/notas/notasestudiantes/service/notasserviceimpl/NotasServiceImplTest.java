package com.estudiantes.notas.notasestudiantes.service.notasserviceimpl;

import com.estudiantes.notas.notasestudiantes.dao.notasdaoimpl.NotasDaoImpl;
import com.estudiantes.notas.notasestudiantes.model.NotasModel;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest()
@AutoConfigureMockMvc
public class NotasServiceImplTest extends TestCase {

    List<NotasModel> listado;

    @Mock
    private NotasDaoImpl notasDao;

    @Autowired
    private NotasServiceImpl notasService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void setUp() {
        listado = new ArrayList<>();
        listado.add(new NotasModel(1, 1010, 5, 10));
        listado.add(new NotasModel(2, 2020, 3, 20));
        listado.add(new NotasModel(3, 3030, 4, 30));
        listado.add(new NotasModel(4, 4040, 2, 50));

    }

    @Test
    public void testGetNotas() {
        //Arrange
        notasDao = Mockito.mock(NotasDaoImpl.class);
        notasService = new NotasServiceImpl(notasDao);
        //Actions
        Mockito.when(notasDao.getNotas()).thenReturn(listado);
        List<NotasModel> result = notasService.getNotas();
        //Assert
        Assert.assertNotNull(result);
    }

    @Test
    public void testGetNotaA() {
        //Arrange
        notasDao = Mockito.mock(NotasDaoImpl.class);
        notasService = new NotasServiceImpl(notasDao);
        //Actions
        Mockito.when(notasDao.getNotas()).thenReturn(listado);
        String result = notasService.getNotaA();
        //Assert
        Assert.assertEquals("La nota mas alta es: " + 5.0, result);
        Assert.assertNotNull(result);
    }

    @Test
    public void testGetNotaF() {
        //Arrange
        notasDao = Mockito.mock(NotasDaoImpl.class);
        notasService = new NotasServiceImpl(notasDao);
        NotasModel notasModelMock = new NotasModel(2, 2020, 3, 20);
        //Actions
        Mockito.when(notasDao.getNotas()).thenReturn(listado);
        String result = notasService.getNotaF(notasModelMock);
        //Assert
        Assert.assertEquals("la nota definitiva es " + 0.6, result);
        Assert.assertNotNull(result);
    }

    public void testAddNota() {
    }

    public void testDelNota() {
    }

}