package xxj.project.controller;//package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xxj.project.model.DelayedFlight;
import xxj.project.model.Schedule;
import xxj.project.repository.DelayedFlightRepository;
import xxj.project.repository.ScheduleRepository;

import java.util.List;

@RestController
@RequestMapping("/api/delayedFlight")
public class DelayedFlightController {
    @Autowired
    DelayedFlightRepository delayedFlightRepository;
    @Autowired
    ScheduleRepository scheduleRep;

    // @Autowired
    //IBuildingService buildingService;
    @RequestMapping("")
    public List<DelayedFlight> getAll() {
        return delayedFlightRepository.findAll();
    }


    @RequestMapping("/get")
    public DelayedFlight get(@RequestParam int id) {
        return delayedFlightRepository.findById(id).get();
    }

    @RequestMapping("/insert")
    public DelayedFlight insert(@RequestParam String reason, int schedule, int numberOfReturns) {
        Schedule schedule1 = scheduleRep.findById(schedule).get();
        return delayedFlightRepository.save(new DelayedFlight(reason, schedule1, numberOfReturns));
    }

    @RequestMapping("/update")
    public DelayedFlight update(@RequestParam int id, String reason, int schedule, int numberOfReturns) {
        DelayedFlight delayedFlight = delayedFlightRepository.findById(id).get();
        Schedule schedule1 = scheduleRep.findById(schedule).get();
        delayedFlight.setReason(reason);
        delayedFlight.setNumberOfReturns(numberOfReturns);
        delayedFlight.setSchedule(schedule1);
        return delayedFlightRepository.save(delayedFlight);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id) {
        delayedFlightRepository.deleteById((int) id);
    }

}