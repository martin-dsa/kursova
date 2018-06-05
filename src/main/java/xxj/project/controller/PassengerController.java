package xxj.project.controller;//package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xxj.project.model.Passenger;
import xxj.project.repository.PassengerRepository;

import java.util.List;

@RestController
@RequestMapping("/api/passenger")
public class PassengerController {
    @Autowired
    PassengerRepository passengerRepository;

    // @Autowired
    //IBuildingService buildingService;
    @RequestMapping("")
    public List<Passenger> getAll() {
        return passengerRepository.findAll();
    }

    @RequestMapping("/get")
    public Passenger get(@RequestParam int id) {
        return passengerRepository.findById(id).get();
    }

    @RequestMapping("/insert")
    public Passenger insert(@RequestParam String name, String surname, String middleName, String gender, int age) {
        return passengerRepository.save(new Passenger(name, surname, middleName, gender, age));
    }

    @RequestMapping("/update")
    public Passenger update(@RequestParam int id, String name, String surname, String middleName, String gender, int age) {
        Passenger passenger = passengerRepository.findById(id).get();
        passenger.setName(name);
        passenger.setSurname(surname);
        passenger.setMiddleName(middleName);
        passenger.setGender(gender);
        passenger.setAge(age);
        return passengerRepository.save(passenger);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id) {
        passengerRepository.deleteById((int) id);
    }

}