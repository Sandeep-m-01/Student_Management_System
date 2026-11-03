package com.sandeep.studentmanagement.server;

import com.sandeep.studentmanagement.entity.Student;
import com.sandeep.studentmanagement.repo.StdRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StdService {
    private final StdRepository repository;

    public StdService(StdRepository repository) {
        this.repository = repository;
    }

    public Student saveData(Student std){
        return repository.save(std);
    }

    public List<Student> getAllData(){
        return repository.findAll();
    }

    public Student getDataById(Integer id){
        return repository.findById(id).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    public Student updateById(Integer id,Student std){
        Student exist = repository.findById(id).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND)
        );

        exist.setAge(std.getAge());
        exist.setName(std.getName());

        return repository.save(exist);
    }

    public Student deleteById(Integer id){
        Student exist = repository.findById(id).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        repository.delete(exist);
        return exist;
    }


}
