package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepo extends JpaRepository<Student, Long> {
	Student findById(long id);
}
