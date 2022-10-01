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

    public List<Reservation> getAllReservations() {
        return (List<Reservation>) reservationRepository.getAllReservations();
    }

    public Optional<Reservation> getReservationById(Integer id) {
        return reservationRepository.getReservationById(id);
    }

    public Reservation saveReservation(Reservation r) {
        if (r.getIdReservation() == null) {
            return reservationRepository.saveReservation(r);
        } else {
            Optional<Reservation> rs = reservationRepository.getReservationById(r.getIdReservation());
            if (rs.isEmpty()) {
                return reservationRepository.saveReservation(r);
            } else {
                return r;
            }
        }
    }

    public Reservation updateReservation(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> e = reservationRepository.getReservationById(reservation.getIdReservation());
            if (!e.isEmpty()) {
                if (reservation.getStartDate() != null) {
                    e.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    e.get().setStatus(reservation.getStatus());
                }
                reservationRepository.saveReservation(e.get());
                return e.get();
            }
        }
        return reservation;
    }

    public boolean deleteReservation(Integer id) {
        Boolean d = getReservationById(id).map(reservation -> {
            reservationRepository.deleteReservation(reservation);
            return true;
        }).orElse(false);
        return d;
    }
}
