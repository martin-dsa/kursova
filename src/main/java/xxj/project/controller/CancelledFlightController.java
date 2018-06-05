package xxj.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xxj.project.model.CancelledFlight;
import xxj.project.model.Schedule;
import xxj.project.repository.CancelledFlightRepository;
import xxj.project.repository.ScheduleRepository;

import java.util.List;

@RestController
@RequestMapping("/api/cancelledFlight")
public class CancelledFlightController {
    @Autowired
    CancelledFlightRepository cancelledFlightRepository;
    @Autowired
    ScheduleRepository scheduleRep;

    // @Autowired
    //IBuildingService buildingService;
    @RequestMapping("")
    public List<CancelledFlight> getAll() {
        return cancelledFlightRepository.findAll();
    }

    @RequestMapping("/get")
    public CancelledFlight get(@RequestParam int id) {
        return cancelledFlightRepository.findById(id).get();
    }

    @RequestMapping("/insert")
    public CancelledFlight insert(@RequestParam int schedule) {

        return cancelledFlightRepository.save(new CancelledFlight(scheduleRep.findById(schedule).get()));
    }

    @RequestMapping("/update")
    public CancelledFlight update(@RequestParam int id, int schedule) {
        CancelledFlight cancelledFlight = cancelledFlightRepository.findById(id).get();
        cancelledFlight.setSchedule(scheduleRep.findById(schedule).get());
        return cancelledFlightRepository.save(cancelledFlight);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id) {
        cancelledFlightRepository.deleteById((int) id);
    }

}