package com.example.Thomas_Dohle_JPA.repositories;
import com.example.Thomas_Dohle_JPA.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;


public interface TopicRepository extends CrudRepository<Topic, Integer>{

	@Query(value="SELECT * FROM TOPIC WHERE lesson_lesson_id=:lessonId",
			nativeQuery=true)
	public List<Topic> findTopicsByLesson(@Param("lessonId") int lessonId);
	
	@Query(value="DELETE FROM TOPIC WHERE lesson_lesson_id=:lessonId",
			nativeQuery=true)
	public void deleteLessonTopics(@Param("lessonId") int lessonId);
}
