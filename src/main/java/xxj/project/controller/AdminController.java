package xxj.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xxj.project.model.Admin;
import xxj.project.model.Department;
import xxj.project.repository.AdminRepository;
import xxj.project.repository.DepartmentRepository;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    private DepartmentRepository depRepository;

    @RequestMapping("")
    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    @RequestMapping("/get")
    public Admin get(@RequestParam int id) {
        return adminRepository.findById(id).get();
    }

    @RequestMapping("/insert")
    public Admin insert(@RequestParam String name, String surname, String middleName, String position, int department) {
        Admin admin = new Admin();
        admin.setName(name);
        admin.setSurname(surname);
        admin.setMiddleName(middleName);
        admin.setPosition(position);
        admin.setDepartment(depRepository.findById(department).get());
        return adminRepository.save(admin);
    }

    @RequestMapping("/update")
    public Admin update(@RequestParam int id,String name, String surname, String middleName, String position, int department) {
        Admin admin = adminRepository.findById(id).get();
        admin.setName(name);
        admin.setSurname(surname);
        admin.setMiddleName(middleName);
        admin.setPosition(position);
        Department d = depRepository.findById(department).get();
        admin.setDepartment(d);
        return adminRepository.save(admin);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id) {
        adminRepository.deleteById((int) id);
    }

}