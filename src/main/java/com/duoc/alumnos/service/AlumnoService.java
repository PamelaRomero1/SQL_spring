package com.duoc.alumnos.service;

import com.duoc.alumnos.model.Alumno;
import com.duoc.alumnos.repository.AlumnoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AlumnoService {

    @Autowired
    public AlumnoRepository alumnoRepository;

    //Traer a todos los alumnos registrados
    public List<Alumno> findAll() {

        return alumnoRepository.findAll();
    }

    //Traer un alumno consultado
    public Alumno findById(Integer id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        alumnoRepository.deleteById(id);
    }
    //Metodo para buscar por correo

    public Alumno findByCorreo(String correo) {
        return alumnoRepository.findByCorreo(correo);
    }

    public List<Alumno> findByNombres(String nombres) {
        return alumnoRepository.findByNombres(nombres);
    }

    public Alumno save(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }
}