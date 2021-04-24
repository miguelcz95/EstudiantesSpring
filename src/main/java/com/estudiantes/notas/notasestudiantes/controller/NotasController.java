package com.estudiantes.notas.notasestudiantes.controller;

import com.estudiantes.notas.notasestudiantes.model.NotasModel;
import com.estudiantes.notas.notasestudiantes.service.INotasService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Backend de Notas y Estudiantes")
public class NotasController {

    INotasService service;

    @Autowired
    public NotasController(INotasService service) {
        this.service = service;
    }

    @GetMapping("/notas")
    @ApiOperation("Devuelve todas las notas registradas")
    public List<NotasModel> getNotas() {
        return service.getNotas();
    }

    @PostMapping("/notas")
    @ApiOperation("Agrega una nota nueva")
    public String addNota(@RequestBody NotasModel notasModel) {
        return service.addNota(notasModel);
    }

    @DeleteMapping("/notas")
    @ApiOperation("Elimina una nota segun el idCedula y idMateria")
    public String delNota(@RequestBody NotasModel notasModel) {
        return service.delNota(notasModel.getIdCedula(), notasModel.getIdMateria());
    }

    @PostMapping("/notaDefinitiva")
    @ApiOperation("Obtiene la nota definitiva segun idCedula y idMateria")
    public String getDefinitiva(@RequestBody NotasModel notasModel) {
        return service.getNotaF(notasModel);
    }

    @GetMapping("/notaAlta")
    @ApiOperation("Obtiene la nota mas alta")
    public String getNotaA() {
        return service.getNotaA();
    }

}
