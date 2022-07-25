package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentRepo stdRepo;

	@GetMapping
	private List<Student> student() {
		try {
			return stdRepo.findAll();

		} catch (Exception e) {
			return null;
		}

	}

	@GetMapping("/{id}")
	private Student student(@PathVariable("id") long id) {
		try {
			return stdRepo.findById(id);
		} catch (Exception e) {
			return null;
		}

	}

	/* for update the record we just need to privied id in request Body */
	@PostMapping
	private Student student(@RequestBody Student student) {
		try {
			return stdRepo.save(student);
		} catch (Exception e) {
			return null;
		}

	}

	@PutMapping("/{id}")
	private Student student(@RequestBody Student student, @PathVariable long id) {

		try {
			Student s = stdRepo.findById(id);
			if (!s.equals(null)) {
				student.setId(s.getId());
				return stdRepo.save(student);
			} else {
				return null;
			}

		} catch (Exception e) {
			return null;
		}
	}

	@DeleteMapping("{id}")
	private String student(@PathVariable("id") Long id) {
		try {
			stdRepo.deleteById(id);
			return "Record Deleted";
		} catch (Exception e) {
			return "Record Not deleted.";
		}

	}

}
