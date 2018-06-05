package xxj.project.controller;//package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xxj.project.model.Flight;
import xxj.project.repository.FlightRepository;

import java.util.List;

@RestController
@RequestMapping("/api/flight")
public class FlightController {
    @Autowired
    FlightRepository flightRepository;

    // @Autowired
    //IBuildingService buildingService;
    @RequestMapping("")
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    @RequestMapping("/get")
    public Flight get(@RequestParam int id) {
        return flightRepository.findById(id).get();
    }

    @RequestMapping("/insert")
    public Flight insert(@RequestParam String startingPoint, String finalPoint, String transferPoint, int ticketPrice, String type, int time) {
        return flightRepository.save(new Flight(startingPoint, finalPoint, transferPoint, ticketPrice, type, time));
    }

    @RequestMapping("/update")
    public Flight update(@RequestParam int id, String startingPoint, String finalPoint, String transferPoint, int ticketPrice, String type, int time) {
        Flight flight = flightRepository.findById(id).get();
        flight.setStartingPoint(startingPoint);
        flight.setFinalPoint(finalPoint);
        flight.setTransferPoint(transferPoint);
        flight.setTicketPrice(ticketPrice);
        flight.setTime(time);
        flight.setType(type);
        return flightRepository.save(flight);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id) {
        flightRepository.deleteById(id);
    }

}