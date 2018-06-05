package xxj.project.controller;//package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xxj.project.model.Department;
import xxj.project.repository.DepartmentRepository;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    DepartmentRepository departmentRepository;

    // @Autowired
    //IBuildingService buildingService;
    @RequestMapping("")
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @RequestMapping("/get")
    public Department get(@RequestParam int id) {
        return departmentRepository.findById(id).get();
    }

    @RequestMapping("/insert")
    public Department insert(@RequestParam String name) {
        return departmentRepository.save(new Department(name));
    }

    @RequestMapping("/update")
    public Department update(@RequestParam int id, String name) {
        Department department= departmentRepository.findById(id).get();
        department.setName(name);
        return departmentRepository.save(department);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id) {
        departmentRepository.deleteById((int) id);
    }

}