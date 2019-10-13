package dev.ateam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.ateam.entities.Build;
import dev.ateam.services.BuildService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BuildController {
	
	@Autowired
	@Qualifier("BuildServiceDATA")
	BuildService br ;

	// create
	@RequestMapping(value = "/builds", method = RequestMethod.POST)
	public Build createBuild(@RequestBody Build build) {
		return br.createBuild(build);
	}

	// read
	@RequestMapping(value = "/builds", method = RequestMethod.GET)
	public List<Build> allbuilds() {
		return br.getAllBuilds();
	}

	@RequestMapping(value = "/builds/{id}", method = RequestMethod.GET)
	public Build getbuild(@PathVariable int id) {
		return br.getBuildById(id);
	}

	// update use the put method for updating a resource
	// put should update a resource if it exists else it will create a new associate
	@RequestMapping(value = "/builds", method = RequestMethod.PUT)
	public Build updatebuild(@RequestBody Build build) {
		return br.updateBuild(build);
	}

	// delete
	@RequestMapping(value = "/builds/{id}", method = RequestMethod.DELETE)
	public boolean removebuild(@PathVariable int id) {
		return br.deleteBuild(br.getBuildById(id));
	}

}
