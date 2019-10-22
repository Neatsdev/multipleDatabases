package com.multiple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiple.maria.repository.Demo1Repository;
import com.multiple.postgres.repository.Demo2Repository;

@RestController
public class ApiController {
	@Autowired
	Demo1Repository dmeo1Repo;
	
	
	@Autowired
	Demo2Repository demo2Repo;
	@GetMapping("hello")
	ResponseEntity<Object> hello()
	{
		System.out.println(demo2Repo.findAll().get(0).getId());
		System.out.println(dmeo1Repo.findById(new Long(4215928)).get().getId());
	
		return new ResponseEntity<>("Hi",HttpStatus.ACCEPTED);
	}

}
