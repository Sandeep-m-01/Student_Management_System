package com.sandeep.studentmanagement.repo;

import com.sandeep.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StdRepository extends JpaRepository<Student, Integer> {
}
