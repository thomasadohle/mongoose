package com.example.Thomas_Dohle_JPA.repositories;
import com.example.Thomas_Dohle_JPA.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;


public interface LessonRepository extends CrudRepository <Lesson, Integer> {
	@Query(value="SELECT * FROM LESSON WHERE module_module_id=:moduleId",
			nativeQuery=true)
	public List<Lesson> findLessonsByModule(@Param("moduleId") int moduleId);
}
