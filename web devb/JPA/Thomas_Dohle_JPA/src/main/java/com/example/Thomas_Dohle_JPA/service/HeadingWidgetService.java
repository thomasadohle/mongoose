package com.example.Thomas_Dohle_JPA.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Thomas_Dohle_JPA.model.HeadingWidget;
import com.example.Thomas_Dohle_JPA.model.ImageWidget;
import com.example.Thomas_Dohle_JPA.model.Topic;
import com.example.Thomas_Dohle_JPA.repositories.HeadingWidgetRepository;
import com.example.Thomas_Dohle_JPA.repositories.ImageWidgetRepository;
import com.example.Thomas_Dohle_JPA.repositories.TopicRepository;

@CrossOrigin(allowCredentials="true")
@RestController
public class HeadingWidgetService {

	@Autowired
	HeadingWidgetRepository headingWidgetRepository;
	
	@Autowired
	TopicRepository topicRepository;
	
	@GetMapping
	("/api/heading/widget")
	public List<HeadingWidget> findAllImageWidgets(){
		return (List<HeadingWidget>) headingWidgetRepository.findAll();
	}
	
	@GetMapping
	("/api/heading/widget/{id}")
	public HeadingWidget findImageWidgetById(@PathVariable (value="id") int id) {
		return headingWidgetRepository.findById(id).get();
	}
	
	@PostMapping
	("/api/topic/{tid}/heading/widget")
	public HeadingWidget createParagraphWidget(@RequestBody HeadingWidget wid,
			@PathVariable (value="tid") int tid) {
		Topic topic = topicRepository.findById(tid).get();
		wid.setTopic(topic);
		topic.addWidget(wid);
		headingWidgetRepository.save(wid);
		topicRepository.save(topic);
		return wid;
	}
	
	@PutMapping
	("/api/heading/widget/{wid}")
	public HeadingWidget updateHeadingWidget(@PathVariable (value="wid") int wid,
			@RequestBody HeadingWidget newWidget) {
		HeadingWidget original = headingWidgetRepository.findById(wid).get();
		original.update(newWidget);
		headingWidgetRepository.save(original);
		return original;
	}
	
	@DeleteMapping
	("/api/heading/widget/{wid}")
	public void deleteImageWidget(@PathVariable (value="wid") int wid) {
		headingWidgetRepository.deleteById(wid);
	}
	
}
