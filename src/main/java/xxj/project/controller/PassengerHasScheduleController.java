package xxj.project.controller;//package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xxj.project.model.Passenger;
import xxj.project.model.PassengerHasSchedule;
import xxj.project.model.Schedule;
import xxj.project.repository.PassengerHasScheduleRepository;
import xxj.project.repository.PassengerRepository;
import xxj.project.repository.ScheduleRepository;

import java.util.List;

@RestController
@RequestMapping("/api/passengerHasSchedule")
public class PassengerHasScheduleController {
    @Autowired
    PassengerHasScheduleRepository passengerHasScheduleRepository;
    @Autowired
    PassengerRepository passengerRep;
    @Autowired
    ScheduleRepository scheduleRep;

    // @Autowired
    //IBuildingService buildingService;
    @RequestMapping("")
    public List<PassengerHasSchedule> getAll() {
        return passengerHasScheduleRepository.findAll();
    }

    @RequestMapping("/get")
    public PassengerHasSchedule get(@RequestParam int id) {
        return passengerHasScheduleRepository.findById(id).get();
    }

    @RequestMapping("/insert")
    public PassengerHasSchedule insert(@RequestParam int passenger, int schedule, boolean hasLuggage) {
        Passenger passenger1 = passengerRep.findById(passenger).get();
        Schedule schedule1 = scheduleRep.findById(schedule).get();
        return passengerHasScheduleRepository.save(new PassengerHasSchedule(passenger1, schedule1, hasLuggage));
    }

    @RequestMapping("/update")
    public PassengerHasSchedule update(@RequestParam int id, int passenger, int schedule, boolean hasLuggage) {
        PassengerHasSchedule passengerHasSchedule = passengerHasScheduleRepository.findById(id).get();
        Passenger passenger1 = passengerRep.findById(passenger).get();
        Schedule schedule1 = scheduleRep.findById(schedule).get();
        passengerHasSchedule.setPassenger(passenger1);
        passengerHasSchedule.setSchedule(schedule1);
        passengerHasSchedule.setHasLuggage(hasLuggage);
        return passengerHasScheduleRepository.save(passengerHasSchedule);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id) {
        passengerHasScheduleRepository.deleteById((int) id);
    }

}