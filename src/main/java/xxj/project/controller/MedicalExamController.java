package xxj.project.controller;//package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xxj.project.model.MedicalExam;
import xxj.project.model.Worker;
import xxj.project.repository.MedicalExamRepository;
import xxj.project.repository.WorkerRepository;

import java.util.List;

@RestController
@RequestMapping("/api/medicalExam")
public class MedicalExamController {
    @Autowired
    MedicalExamRepository medicalExamRepository;
    @Autowired
    WorkerRepository workerRep;

    // @Autowired
    //IBuildingService buildingService;
    @RequestMapping("")
    public List<MedicalExam> getAll() {
        return medicalExamRepository.findAll();
    }

    @RequestMapping("/get")
    public MedicalExam get(@RequestParam int id) {
        return medicalExamRepository.findById(id).get();
    }

    @RequestMapping("/insert")
    public MedicalExam insert(@RequestParam int year, boolean hasPassed, int worker) {
        Worker worker1 = workerRep.findById(worker).get();
        return medicalExamRepository.save(new MedicalExam(year, hasPassed, worker1));
    }

    @RequestMapping("/update")
    public MedicalExam update(@RequestParam int id, int year, boolean hasPassed, int worker) {
        MedicalExam medicalExam = medicalExamRepository.findById(id).get();
        Worker worker1 = workerRep.findById(worker).get();
        medicalExam.setYear(year);
        medicalExam.setHasPassed(hasPassed);
        medicalExam.setWorker(worker1);
        return medicalExamRepository.save(medicalExam);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id) {
        medicalExamRepository.deleteById((int) id);
    }

}