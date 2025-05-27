package com.duoc.alumnos.service;


import com.duoc.alumnos.model.Alumno;
import com.duoc.alumnos.model.Sede;
import com.duoc.alumnos.repository.SedeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SedeService {

   @Autowired
    private SedeRepository sedeRepository;

    public List<Sede> findAll() {

        return sedeRepository.findAll();
    }

    //Traer un alumno consultado
    public Sede findById(Integer id) {
        return sedeRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        sedeRepository.deleteById(id);
    }

    public Sede save(Sede sede) {
        return sedeRepository.save(sede);
    }

}
