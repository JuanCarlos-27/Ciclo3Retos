package com.ciclo3.service;

import com.ciclo3.model.Box;
import com.ciclo3.repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoxService {
    @Autowired
    private BoxRepository boxRepository;

    public List<Box> getAllBoxes(){
        return (List<Box>) boxRepository.getAllBoxes();
    }
    public Optional<Box> getBoxById(Integer id){
        return boxRepository.getBoxById(id);
    }
    public Box saveBox(Box b){
        return boxRepository.saveBox(b);
    }
    public boolean deleteBox(Integer id){
        boxRepository.deleteBox(id);
        return true;
    }
    public Box updateBox(Box b){
        return boxRepository.updateBox(b);
    }
}
