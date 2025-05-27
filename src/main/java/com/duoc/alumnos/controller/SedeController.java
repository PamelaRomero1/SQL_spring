package com.duoc.alumnos.controller;


import com.duoc.alumnos.model.Alumno;
import com.duoc.alumnos.model.Sede;
import com.duoc.alumnos.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SedeController {

    @Autowired
    public SedeService sedeService;

    @GetMapping("/home")

    public String home() {

        return "Bienvenido a las sedes de Duoc";
    }
    @GetMapping("/api/v1/sedes")
    public ResponseEntity<?> getSedes() {

        return ResponseEntity.status(200).body(sedeService.findAll());
    }

    @DeleteMapping("/api/v1/sede/{id}")
    public ResponseEntity<?> deleteSede(@PathVariable Integer id) {
        Sede sede = sedeService.findById(id);
        if (sede == null) {
            return ResponseEntity.status(404).body("Sede no encontrada");
        }
        sedeService.delete(id);
        return ResponseEntity.status(200).body("Sede eliminada");
    }

    @PostMapping("/api/v1/sede")
    public ResponseEntity<?> guardarsede(@RequestBody Sede sede) {
        Sede sedeGuardada = sedeService.save(sede);
        return ResponseEntity.status(201).body(sedeGuardada);
    }



}
