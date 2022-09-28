package com.ciclo3.service;

import com.ciclo3.model.Reservation;
import com.ciclo3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations(){
        return (List<Reservation>) reservationRepository.getAllReservations();
    }
    public Optional<Reservation> getReservationById(Integer id){
        return reservationRepository.getReservationById(id);
    }
    public Reservation saveReservation(Reservation r){
        return reservationRepository.saveReservation(r);
    }
    public boolean deleteReservation(Integer id){
        reservationRepository.deleteReservation(id);
        return true;
    }
    public Reservation updateReservation(Reservation r){
        return reservationRepository.updateReservation(r);
    }
}
