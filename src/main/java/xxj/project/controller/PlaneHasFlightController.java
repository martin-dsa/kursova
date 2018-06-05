package xxj.project.controller;//package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xxj.project.model.Flight;
import xxj.project.model.Plane;
import xxj.project.model.PlaneHasFlight;
import xxj.project.repository.FlightRepository;
import xxj.project.repository.PlaneHasFlightRepository;
import xxj.project.repository.PlaneRepository;

import java.util.List;

@RestController
@RequestMapping("/api/planeHasFlight")
public class PlaneHasFlightController {
    @Autowired
    PlaneHasFlightRepository planeHasFlightRepository;
    @Autowired
    PlaneRepository planeRep;
    @Autowired
    FlightRepository flightRep;

    // @Autowired
    //IBuildingService buildingService;
    @RequestMapping("")
    public List<PlaneHasFlight> getAll() {
        return planeHasFlightRepository.findAll();
    }

    @RequestMapping("/get")
    public PlaneHasFlight get(@RequestParam int id) {
        return planeHasFlightRepository.findById(id).get();
    }

    @RequestMapping("/insert")
    public PlaneHasFlight insert(@RequestParam int plane, int flight) {
        Plane plane1 = planeRep.findById(plane).get();
        Flight flight1 = flightRep.findById(flight).get();
        return planeHasFlightRepository.save(new PlaneHasFlight(plane1, flight1));
    }

    @RequestMapping("/update")
    public PlaneHasFlight update(@RequestParam int id, int plane, int flight) {
        PlaneHasFlight planeHasFlight = planeHasFlightRepository.findById(id).get();
        Plane plane1 = planeRep.findById(plane).get();
        Flight flight1 = flightRep.findById(flight).get();
        planeHasFlight.setFlight(flight1);
        planeHasFlight.setPlane(plane1);
        return planeHasFlightRepository.save(planeHasFlight);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id) {
        planeHasFlightRepository.deleteById((int) id);
    }

}