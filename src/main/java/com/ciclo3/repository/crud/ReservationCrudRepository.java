package com.ciclo3.repository.crud;

import com.ciclo3.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository <Reservation, Integer> {
}
