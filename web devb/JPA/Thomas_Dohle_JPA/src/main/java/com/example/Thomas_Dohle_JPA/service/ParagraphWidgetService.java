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

import com.example.Thomas_Dohle_JPA.model.ParagraphWidget;
import com.example.Thomas_Dohle_JPA.model.Topic;
import com.example.Thomas_Dohle_JPA.repositories.ParagraphWidgetRepository;
import com.example.Thomas_Dohle_JPA.repositories.TopicRepository;

@CrossOrigin(allowCredentials="true")
@RestController
public class ParagraphWidgetService {
	@Autowired
	ParagraphWidgetRepository paragraphWidgetRepository;
	
	@Autowired
	TopicRepository topicRepository;
	
	@GetMapping
	("/api/paragraph/widget")
	public List<ParagraphWidget> findAllParagraphWidgets(){
		return (List<ParagraphWidget>) paragraphWidgetRepository.findAll();
	}
	
	@GetMapping
	("/api/paragraph/widget/{id}")
	public ParagraphWidget findParagraphWidgetById(@PathVariable (value="id") int id) {
		return paragraphWidgetRepository.findById(id).get();
	}
	
	@PostMapping
	("/api/topic/{tid}/paragraph/widget")
	public ParagraphWidget createParagraphWidget(@RequestBody ParagraphWidget wid,
			@PathVariable (value="tid") int tid) {
		Topic topic = topicRepository.findById(tid).get();
		wid.setTopic(topic);
		topic.addWidget(wid);
		paragraphWidgetRepository.save(wid);
		topicRepository.save(topic);
		return wid;
	}
	
	@PutMapping
	("/api/paragraph/widget/{wid}")
	public ParagraphWidget updateParagraphWidget(@PathVariable (value="wid") int wid,
			@RequestBody ParagraphWidget newWidget) {
		ParagraphWidget original = paragraphWidgetRepository.findById(wid).get();
		original.update(newWidget);
		paragraphWidgetRepository.save(original);
		return original;
	}
	
	@DeleteMapping
	("/api/paragraph/widget/{wid}")
	public void deleteParagraphWidget(@PathVariable (value="wid") int wid) {
		paragraphWidgetRepository.deleteById(wid);
	}
}
