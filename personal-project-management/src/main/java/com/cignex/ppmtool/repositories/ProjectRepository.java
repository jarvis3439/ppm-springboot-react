package com.cignex.ppmtool.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cignex.ppmtool.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{
	
}
