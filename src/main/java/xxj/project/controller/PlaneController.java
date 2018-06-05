package xxj.project.controller;//package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xxj.project.model.Plane;
import xxj.project.repository.PlaneRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/plane")
public class PlaneController {
    @Autowired
    PlaneRepository planeRepository;

    // @Autowired
    //IBuildingService buildingService;
    @RequestMapping("")
    public List<Plane> getAll() {
        return planeRepository.findAll();
    }

    @RequestMapping("/get")
    public Plane get(@RequestParam int id) {
        return planeRepository.findById(id).get();
    }

    @RequestMapping("/insert")
    public Plane insert(@RequestParam String name, int numberOfRepairs, int age, int numberOfFlights, String status, int numberOfSeats, String timeOfArrive) {
        return planeRepository.save(new Plane(name, numberOfRepairs, age, numberOfFlights, status, numberOfSeats, LocalDate.parse (timeOfArrive)));
    }

    @RequestMapping("/update")
    public Plane update(@RequestParam int  id,String name, int numberOfRepairs, int age, int numberOfFlights, String status, int numberOfSeats, String timeOfArrive) {
        Plane plane = planeRepository.findById(id).get();
        plane.setName(name);
        plane.setNumberOfRepairs(numberOfRepairs);
        plane.setNumberOfFlights(numberOfFlights);
        plane.setAge(age);
        plane.setNumberOfSeats(numberOfSeats);
        plane.setStatus(status);
        plane.setTimeOfArrive(LocalDate.parse (timeOfArrive));
        return planeRepository.save(plane);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id) {
        planeRepository.deleteById((int) id);
    }

}