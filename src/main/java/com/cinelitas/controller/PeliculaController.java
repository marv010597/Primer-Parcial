/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinelitas.controller;

import com.cinelitas.entity.Pelicula;
import com.cinelitas.entity.Sala;
import com.cinelitas.service.IPeliculaService;
import com.cinelitas.service.ISalaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author marvinjimenez
 */
@Controller
public class PeliculaController {
    
    @Autowired
    private IPeliculaService peliculaservice;
    
    @Autowired
    private ISalaService salaservice;
    
    @GetMapping("/peliculas")
    public String index(Model model){
    
        List<Pelicula> listaPelicula = peliculaservice.getALLPelicula();
        model.addAttribute("titulo", "Cartelera");
        model.addAttribute("peliculas", listaPelicula);
        return "peliculas";
        
    }
    
    @GetMapping("/NewPelicula")
    public String crearPelicula (Model model){
    
        List<Sala> listaSala = salaservice.listSala();
        model.addAttribute("pelicula", new Pelicula());
        model.addAttribute("salas", listaSala);
        return "crear";
        
    }
    
    @PostMapping("/save")
    public String guardarPelicula(@ModelAttribute Pelicula pelicula){
        peliculaservice.savePelicula(pelicula);
        return "redirect:/peliculas";
    
    }
    
    @GetMapping("/editPelicula/{id}")
    public String editarPelicula(@PathVariable("id") Long idPelicula, Model model){
    
        Pelicula pelicula = peliculaservice.getPeliculaById(idPelicula);
        List<Sala> listaSala = salaservice.listSala();
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("sala", listaSala);
        return "crear";
        
    }
    
    @GetMapping("/delete/{id}")
    public String eliminarPelicula(@PathVariable("id") Long idPelicula){
        
        peliculaservice.delete(idPelicula);
        return "redirect:/peliculas";
    
    }
    
}
