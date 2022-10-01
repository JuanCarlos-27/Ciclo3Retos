package com.ciclo3.repository;

import com.ciclo3.model.Reservation;
import com.ciclo3.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAllReservations(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservationById(Integer id){
        return reservationCrudRepository.findById(id);
    }
    public Reservation saveReservation(Reservation r){
        return reservationCrudRepository.save(r);
    }
    public void deleteReservation(Reservation r){
        reservationCrudRepository.delete(r);
    }
}
