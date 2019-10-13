package dev.ateam.services;

import java.util.List;

import dev.ateam.entities.Build;

public interface BuildService {

	Build createBuild(Build build);
	boolean deleteBuild(Build build);
	Build updateBuild(Build build);
	Build getBuildById(int b_id);
	List<Build> getAllBuilds();

}
