package xxj.project.controller;//package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xxj.project.model.Schedule;
import xxj.project.model.Seats;
import xxj.project.model.SeatsHasSchedule;
import xxj.project.repository.ScheduleRepository;
import xxj.project.repository.SeatsHasScheduleRepository;
import xxj.project.repository.SeatsRepository;

import java.util.List;

@RestController
@RequestMapping("/api/seatsHasSchedule")
public class SeatsHasScheduleController {
    @Autowired
    SeatsHasScheduleRepository seatsHasScheduleRepository;
    @Autowired
    SeatsRepository seatsRep;
    @Autowired
    ScheduleRepository scheduleRep;

    // @Autowired
    //IBuildingService buildingService;
    @RequestMapping("")
    public List<SeatsHasSchedule> getAll() {
        return seatsHasScheduleRepository.findAll();
    }

    @RequestMapping("/get")
    public SeatsHasSchedule get(@RequestParam int id) {
        return seatsHasScheduleRepository.findById(id).get();
    }

    @RequestMapping("/insert")
    public SeatsHasSchedule insert(@RequestParam int seat, int schedule, boolean isBooked) {
        Seats seats = seatsRep.findById(seat).get();
        Schedule schedule1 = scheduleRep.findById(schedule).get();
        return seatsHasScheduleRepository.save(new SeatsHasSchedule(seats, schedule1, isBooked));
    }

    @RequestMapping("/update")
    public SeatsHasSchedule update(@RequestParam int id, int seat, int schedule, boolean isBooked) {
        SeatsHasSchedule seatsHasSchedule = seatsHasScheduleRepository.findById(id).get();
        Seats seats = seatsRep.findById(seat).get();
        Schedule schedule1 = scheduleRep.findById(schedule).get();
        seatsHasSchedule.setSeat(seats);
        seatsHasSchedule.setSchedule(schedule1);
        seatsHasSchedule.setBooked(isBooked);
        return seatsHasScheduleRepository.save(seatsHasSchedule);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id) {
        seatsHasScheduleRepository.deleteById((int) id);
    }

}