package xxj.project.controller;//package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xxj.project.model.Brigade;
import xxj.project.model.Plane;
import xxj.project.model.VehicleInspection;
import xxj.project.repository.PlaneRepository;
import xxj.project.repository.VehicleInspectionRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/vehicleInspection")
public class VehicleInspectionController {
    @Autowired
    VehicleInspectionRepository vehicleInspectionRepository;
    @Autowired
    PlaneRepository planeRep;

    // @Autowired
    //IBuildingService buildingService;
    @RequestMapping("")
    public List<VehicleInspection> getAll() {
        return vehicleInspectionRepository.findAll();
    }

    @RequestMapping("/get")
    public VehicleInspection get(@RequestParam int id) {
        return vehicleInspectionRepository.findById(id).get();
    }

    @RequestMapping("/insert")
    public VehicleInspection insert(@RequestParam String date, int plane, String type, int numberOfFlights) {
        Plane plane1 = planeRep.findById(plane).get();
        return vehicleInspectionRepository.save(new VehicleInspection(LocalDate.parse(date), plane1, type, numberOfFlights));
    }

    @RequestMapping("/update")
    public VehicleInspection update(@RequestParam int id, LocalDate date, int plane, String type, int numberOfFlights) {
        VehicleInspection vehicleInspection = vehicleInspectionRepository.findById(id).get();
        Plane plane1 = planeRep.findById(plane).get();
        vehicleInspection.setPlane(plane1);
        vehicleInspection.setDate(date);
        vehicleInspection.setType(type);
        vehicleInspection.setNumberOfFlights(numberOfFlights);

        return vehicleInspectionRepository.save(vehicleInspection);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id) {
        vehicleInspectionRepository.deleteById((int) id);
    }

}