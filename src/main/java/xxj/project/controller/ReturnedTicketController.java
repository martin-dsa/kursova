package xxj.project.controller;//package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xxj.project.model.Passenger;
import xxj.project.model.ReturnedTicket;
import xxj.project.model.Schedule;
import xxj.project.repository.PassengerRepository;
import xxj.project.repository.ReturnedTicketRepository;
import xxj.project.repository.ScheduleRepository;

import java.util.List;

@RestController
@RequestMapping("/api/returnedTicket")
public class ReturnedTicketController {
    @Autowired
    ReturnedTicketRepository returnedticketRepository;
    @Autowired
    PassengerRepository passengerRep;
    @Autowired
    ScheduleRepository scheduleRep;

    // @Autowired
    //IBuildingService buildingService;
    @RequestMapping("")
    public List<ReturnedTicket> getAll() {
        return returnedticketRepository.findAll();
    }

    @RequestMapping("/get")
    public ReturnedTicket get(@RequestParam int id) {
        return returnedticketRepository.findById(id).get();
    }

    @RequestMapping("/insert")
    public ReturnedTicket insert(@RequestParam int passenger, int schedule) {
        Passenger passenger1 = passengerRep.findById(passenger).get();
        Schedule schedule1 = scheduleRep.findById(schedule).get();
        return returnedticketRepository.save(new ReturnedTicket(passenger1, schedule1));
    }

    @RequestMapping("/update")
    public ReturnedTicket update(@RequestParam int id, int passenger, int schedule) {
        ReturnedTicket returnedTicket = returnedticketRepository.findById(id).get();
        Passenger passenger1 = passengerRep.findById(passenger).get();
        Schedule schedule1 = scheduleRep.findById(schedule).get();
        returnedTicket.setPassenger(passenger1);
        returnedTicket.setSchedule(schedule1);
        return returnedticketRepository.save(returnedTicket);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id) {
        returnedticketRepository.deleteById((int) id);
    }

}