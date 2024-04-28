package com.example.Project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Project.dto.Courses;


public interface CoursesRepo extends JpaRepository<Courses, Integer> {

}
