package xxj.project.controller;//package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xxj.project.model.Brigade;
import xxj.project.model.Department;
import xxj.project.model.Worker;
import xxj.project.repository.BrigadeRepository;
import xxj.project.repository.DepartmentRepository;
import xxj.project.repository.WorkerRepository;

import java.util.List;

@RestController
@RequestMapping("/api/worker")
public class WorkerController {
    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    BrigadeRepository brigadeRep;
    @Autowired
    DepartmentRepository departmentRep;

    @RequestMapping("")
    public List<Worker> getAll() {
        return workerRepository.findAll();
    }

    @RequestMapping("/get")
    public Worker get(@RequestParam int id) {
        return workerRepository.findById(id).get();
    }

    @RequestMapping("/insert")
    public Worker insert(@RequestParam String name, String surname, String middleName, int brigade, int experience, String gender, int age, boolean hasChildren, Integer numberOfChildren, int salary, int department) {
        Brigade brigade1 = brigadeRep.findById(brigade).get();
        Department department1 = departmentRep.findById(department).get();
        return workerRepository.save(new Worker(name, surname, middleName, brigade1, experience, gender, age, hasChildren, numberOfChildren, salary, department1));
    }

    @RequestMapping("/update")
    public Worker update(@RequestParam int id, String name, String surname, String middleName, int brigade, int experience, String gender, int age, Integer numberOfChildren, int salary, int department) {
        Worker worker = workerRepository.findById(id).get();
        Brigade brigade1 = brigadeRep.findById(brigade).get();
        Department department1 = departmentRep.findById(department).get();
        worker.setName(name);
        worker.setSalary(salary);
        worker.setSurname(surname);
        worker.setMiddleName(middleName);
        worker.setBrigade(brigade1);
        worker.setDepartment(department1);

        worker.setNumberOfChildren(numberOfChildren);
        worker.setAge(age);
        worker.setGender(gender);
        worker.setExperience(experience);
        return workerRepository.save(worker);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id) {
        workerRepository.deleteById((int) id);
    }

}