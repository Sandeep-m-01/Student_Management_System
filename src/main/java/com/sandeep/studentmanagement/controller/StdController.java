package com.sandeep.studentmanagement.controller;

import com.sandeep.studentmanagement.entity.Student;
import com.sandeep.studentmanagement.repo.StdRepository;
import com.sandeep.studentmanagement.server.StdService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/std")
public class StdController {

    private final StdService service;

    StdController(StdService service){
        this.service =service;
    }
    @PostMapping
    public Student saveData(@RequestBody Student std){
        return service.saveData(std);
    }
    @GetMapping
    public List<Student> getData(){
        return service.getAllData();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Integer id){
        return service.getDataById(id);
    }

    @PutMapping("/{id}")
    public Student updateById(@PathVariable Integer id,@RequestBody Student std){
        return service.updateById(id,std);
    }

    @DeleteMapping("/{id}")
    public Student deleteById(@PathVariable Integer id){
        return service.deleteById(id);
    }

}
