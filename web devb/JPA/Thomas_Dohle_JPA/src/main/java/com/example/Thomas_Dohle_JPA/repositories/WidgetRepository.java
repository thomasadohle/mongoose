package com.example.Thomas_Dohle_JPA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.Thomas_Dohle_JPA.model.Widget;

public interface WidgetRepository extends CrudRepository<Widget, Integer>{
	@Query(value="SELECT * FROM WIDGET WHERE topic_id =:topicId",
			nativeQuery=true)
	public List<Widget> findWidgetsByTopic (@Param ("topicId") int topicId);

}
