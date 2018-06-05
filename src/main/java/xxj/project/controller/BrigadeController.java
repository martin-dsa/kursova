package xxj.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xxj.project.model.Brigade;
import xxj.project.model.Flight;
import xxj.project.model.Plane;
import xxj.project.repository.BrigadeRepository;
import xxj.project.repository.FlightRepository;
import xxj.project.repository.PlaneRepository;

import java.util.List;

@RestController
@RequestMapping("/api/brigade")
public class BrigadeController {
    @Autowired
    BrigadeRepository brigadeRepository;
    @Autowired
    PlaneRepository planeRep;
    @Autowired
    FlightRepository flightRep;

    // @Autowired
    //IBuildingService buildingService;
    @RequestMapping("")
    public List<Brigade> getAll() {
        return brigadeRepository.findAll();
    }

    @RequestMapping("/get")
    public Brigade get(@RequestParam int id) {
        return brigadeRepository.findById(id).get();
    }

    @RequestMapping("/insert")
    public Brigade insert(@RequestParam String name, int plane, int flight) {
        Brigade brigade = new Brigade();
        brigade.setName(name);
        brigade.setPlane(planeRep.findById(plane).get());
        brigade.setFlight(flightRep.findById(flight).get());
        return brigadeRepository.save(brigade);
    }

    @RequestMapping("/update")
    public Brigade update(@RequestParam int id,String name, int plane, int flight) {
        Brigade brigade = brigadeRepository.findById(id).get();
        brigade.setName(name);
        brigade.setPlane(planeRep.findById(plane).get());
        brigade.setFlight(flightRep.findById(flight).get());
        return brigadeRepository.save(brigade);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id) {
        brigadeRepository.deleteById((int) id);
    }

}