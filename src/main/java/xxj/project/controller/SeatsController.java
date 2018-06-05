package xxj.project.controller;//package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xxj.project.model.Brigade;
import xxj.project.model.Plane;
import xxj.project.model.Seats;
import xxj.project.repository.PlaneRepository;
import xxj.project.repository.SeatsRepository;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatsController {
    @Autowired
    SeatsRepository seatsRepository;
    @Autowired
    PlaneRepository planeRep;

    // @Autowired
    //IBuildingService buildingService;
    @RequestMapping("")
    public List<Seats> getAll() {
        return seatsRepository.findAll();
    }

    @RequestMapping("/get")
    public Seats get(@RequestParam int id) {
        return seatsRepository.findById(id).get();
    }

    @RequestMapping("/insert")
    public Seats insert(@RequestParam int number, int plane) {
        Plane plane1 = planeRep.findById(plane).get();
        return seatsRepository.save(new Seats(number, plane1));
    }

    @RequestMapping("/update")
    public Seats update(@RequestParam int id, int number, int plane) {
        Seats seats = seatsRepository.findById(id).get();
        Plane plane1 = planeRep.findById(plane).get();
        seats.setNumber(number);
        seats.setPlane(plane1);
        return seatsRepository.save(seats);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id) {
        seatsRepository.deleteById((int) id);
    }

}