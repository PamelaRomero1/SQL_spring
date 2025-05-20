package com.duoc.alumnos.controller;


import com.duoc.alumnos.model.Alumno;
import com.duoc.alumnos.repository.AlumnoRepository;
import com.duoc.alumnos.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlumnoController {

    @Autowired
    public AlumnoService alumnoService;
    @GetMapping("/api/v1/home")

    public String home() {

        return "Bienvenido Alumno";
    }

    @GetMapping("/api/v1/alumnos")
    public ResponseEntity<?> getAlumnos() {

        return ResponseEntity.status(200).body(alumnoService.findAll());

}

    @GetMapping("/api/v1/alumno/{id}")
    public ResponseEntity<?> getAlumno(@PathVariable Integer id) {
        Alumno alumno = alumnoService.findById(id);

        if (alumno == null) {
            return ResponseEntity.status(404).body("Alumno no encontrado");
        }
        return ResponseEntity.status(200).body(alumno);
    }

    @DeleteMapping("/api/v1/alumno/{id}")
    public ResponseEntity<?> deleteAlumno(@PathVariable Integer id) {
        Alumno alumno = alumnoService.findById(id);
        if (alumno == null) {
            return ResponseEntity.status(404).body("Alumno no encontrado");
        }

        alumnoService.delete(id);
        return ResponseEntity.status(200).body("Alumno eliminado");
        }

        @GetMapping("/api/v1/alumno/buscar")
        public ResponseEntity<?> buscarAlumno(@RequestParam String correo) {
            Alumno alumno = alumnoService.findByCorreo(correo);
            return ResponseEntity.status(200).body(alumno);
        }

        @GetMapping("/api/v1/alumnos/{nombre}")
        public ResponseEntity<?> buscarAlumnoPorNombre(@PathVariable String nombres) {
            List<Alumno> alumnos = alumnoService.findByNombres(nombres);
            return ResponseEntity.status(200).body(alumnos);
        }
    }
