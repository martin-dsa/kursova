package xxj.project.controller;//package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xxj.project.model.Flight;
import xxj.project.model.Schedule;
import xxj.project.repository.FlightRepository;
import xxj.project.repository.ScheduleRepository;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    FlightRepository flightRep;

    // @Autowired
    //IBuildingService buildingService;
    @RequestMapping("")
    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }

    @RequestMapping("/get")
    public Schedule get(@RequestParam int id) {
        return scheduleRepository.findById(id).get();
    }

    @RequestMapping("/insert")
    public Schedule insert(@RequestParam int flight, String dayOfDeparture, String dayOfArrive, String timeOfDeparture, String timeOfArrive, int numberOfUnusedSeats, int numberOfSoldTickets, String planeType) {
        Flight flight1 = flightRep.findById(flight).get();
        return scheduleRepository.save(new Schedule(flight1, LocalDate.parse(dayOfDeparture), LocalDate.parse(dayOfArrive), LocalTime.parse(timeOfDeparture), LocalTime.parse(timeOfArrive), numberOfUnusedSeats, numberOfSoldTickets, planeType));
    }

    @RequestMapping("/update")
    public Schedule update(@RequestParam int id, int flight, String dayOfDeparture, String dayOfArrive, String timeOfDeparture, String timeOfArrive, int numberOfUnusedSeats, int numberOfSoldTickets, String planeType) {
        Schedule schedule = scheduleRepository.findById(id).get();
        Flight flight1 = flightRep.findById(flight).get();
        schedule.setFlight(flight1);
        schedule.setDayOfArrive(LocalDate.parse(dayOfArrive));
        schedule.setDayOfDeparture(LocalDate.parse(dayOfDeparture));
        schedule.setTimeOfArrive(LocalTime.parse(timeOfArrive));
        schedule.setTimeOfDeparture(LocalTime.parse(timeOfDeparture));
        schedule.setPlaneType(planeType);
        schedule.setNumberOfSoldTickets(numberOfSoldTickets);
        schedule.setNumberOfUnusedSeats(numberOfUnusedSeats);
        return scheduleRepository.save(schedule);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id) {
        scheduleRepository.deleteById((int) id);
    }

}