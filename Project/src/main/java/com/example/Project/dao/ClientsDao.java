package com.example.Project.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Project.dto.Clients;
import com.example.Project.dto.Courses;
import com.example.Project.repo.ClientsRepo;

@Repository
public class ClientsDao {

	@Autowired
	ClientsRepo clientsRepo;

	@Autowired
	CoursesDao coursesDao;

	public Clients saveClient(Clients clients) {
		return clientsRepo.save(clients);
	}

	public Clients fetchClientsById(int id) {
		Optional<Clients> optional = clientsRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}

	}

	public Clients addExistingCoursesToExistingClients(int CourseId, int ClientId) {

		Courses courses = coursesDao.fetchCoursesById(CourseId);
		Clients clients = fetchClientsById(ClientId);
		clients.getCourses().add(courses);
		return saveClient(clients);
	}

	public Clients addNewCoursesToExistingClient(int clientId, Courses courses) {

		Clients clients = fetchClientsById(clientId);

		clients.getCourses().add(courses);
		return saveClient(clients);
	}

}
