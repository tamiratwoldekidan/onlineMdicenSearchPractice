package dev.ateam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.ateam.entities.AppUser;
import dev.ateam.entities.Build;

@Repository
public interface BuildRepository extends CrudRepository<Build,Integer>{

	List<Build> findBypartList(String partList);

}
