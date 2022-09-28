package com.ciclo3.controller;

import com.ciclo3.model.Reservation;
import com.ciclo3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAllReservation() {
        return (List<Reservation>) reservationService.getAllReservations();
    }
    @GetMapping("/{id}")
    public Optional<Reservation> getReservationById(@PathVariable Integer id) {
        return reservationService.getReservationById(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation saveReservation(@RequestBody Reservation r) {
        return reservationService.saveReservation(r);
    }
    @DeleteMapping("/delete/{id}")
    public boolean deleteReservation(@PathVariable Integer id){
        reservationService.deleteReservation(id);
        return true;
    }
    @PutMapping("/update")
    public Reservation updateReservation(@RequestBody Reservation r){
        return reservationService.updateReservation(r);
    }

}
