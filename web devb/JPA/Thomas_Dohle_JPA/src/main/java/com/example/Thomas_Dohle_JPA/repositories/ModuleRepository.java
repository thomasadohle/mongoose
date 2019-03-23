package com.example.Thomas_Dohle_JPA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;

import com.example.Thomas_Dohle_JPA.model.Module;



public interface ModuleRepository extends CrudRepository <Module, Integer>{
	@Query(value="SELECT * FROM MODULE WHERE course_course_id=:courseId",
			nativeQuery=true)
	public List<Module> findModulesByCourse(@Param("courseId") int courseId);

}
