package com.example.Thomas_Dohle_JPA.repositories;
import com.example.Thomas_Dohle_JPA.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;


public interface CourseRepository extends CrudRepository <Course, Integer> {
	@Query(value="SELECT * FROM COURSE where author_id=:authorId",
			nativeQuery=true)
	public List<Course> findCoursesByAuthor(@Param("authorId") int authorId);
}
