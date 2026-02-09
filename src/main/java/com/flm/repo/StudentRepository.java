package com.flm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flm.entity.Student;

public interface StudentRepository  extends JpaRepository<Student, Integer>
{

}
