package com.example.Project.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Project.dto.Courses;
import com.example.Project.repo.CoursesRepo;

@Repository
public class CoursesDao{
	@Autowired
	CoursesRepo coursesRepo;

	public Courses saveCourse(Courses courses) {
		
		return coursesRepo.save(courses);
	}
	
	public Courses fetchCoursesById(int id) {
		 Optional<Courses> optional=coursesRepo.findById(id);
		 if(optional.isPresent()) {
			 return optional.get();
		 }
		 else {
			return null;
		}

		
	}
	
	
}
