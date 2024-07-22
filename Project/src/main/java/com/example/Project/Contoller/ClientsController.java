package com.example.Project.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Service.ClientsService;
import com.example.Project.Util.ResponseStruture;
import com.example.Project.dto.Clients;
import com.example.Project.dto.Courses;

@RestController
public class ClientsController {

	@Autowired
	ClientsService clientsService;

	@PostMapping("/saveClient")
	public ResponseEntity<ResponseStruture<Clients>> saveClient(@RequestBody Clients clients) {
		System.out.println("raju");
	return  clientsService.saveClient(clients);
	}
	@GetMapping("/fetchClientById")
	public ResponseEntity<ResponseStruture<Clients>> fetchClientById(int id) {
		return clientsService.fetchClientsById(id);
	}
	@PutMapping("/addExistingCoursesToaddExistingClients")
	public Clients addExistingCoursesToaddExistingClients( int courseId,int clientId ) {

		return  clientsService.addExistingCoursesToaddExistingClients(courseId, clientId);

	}
	@PostMapping("/addNewCoursesToExistingClient")
	public Clients addNewCoursesToExistingClient(int clientId,@RequestBody Courses courses) {
		return clientsService.addNewCoursesToExistingClient(clientId, courses);
	}

}
