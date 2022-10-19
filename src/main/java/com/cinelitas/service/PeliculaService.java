/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinelitas.service;

import com.cinelitas.entity.Pelicula;
import com.cinelitas.repository.PeliculaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marvinjimenez
 */
@Service
public class PeliculaService implements IPeliculaService{
    
    @Autowired
    private PeliculaRepository pelicularepository;

    @Override
    public List<Pelicula> getALLPelicula() {
        
        return (List<Pelicula>)pelicularepository.findAll();
        
    }

    @Override
    public Pelicula getPeliculaById(long id) {
        return pelicularepository.findById(id).orElse(null);
    }

    @Override
    public void savePelicula(Pelicula pelicula) {
        pelicularepository.save(pelicula);
    }

    @Override
    public void delete(long id) {
        pelicularepository.deleteById(id);
    }
    
}
