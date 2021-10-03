package com.cg.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cg.demo.model.Student;

public interface StudentRepo extends CrudRepository<Student, Integer> {
	List<Student> findByTech(String tech);
	List<Student> findByIdGreaterThan(int id);
	List<Student> findByIdLessThan(int id);
	
	@Query("from Student where tech=?1 order by name")
	List<Student> findByTechSorted(String tech);
}
