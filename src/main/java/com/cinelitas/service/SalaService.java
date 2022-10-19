/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinelitas.service;

import com.cinelitas.entity.Sala;
import com.cinelitas.repository.SalaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marvinjimenez
 */
@Service
public class SalaService implements ISalaService{
    
    @Autowired
    private SalaRepository salarepository;

    @Override
    public List<Sala> listSala() {
        
        return (List<Sala>)salarepository.findAll();
        
    }
    
}
