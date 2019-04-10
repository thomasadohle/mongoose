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

import com.example.Thomas_Dohle_JPA.model.ImageWidget;
import com.example.Thomas_Dohle_JPA.model.ListWidget;
import com.example.Thomas_Dohle_JPA.model.Topic;
import com.example.Thomas_Dohle_JPA.repositories.ListWidgetRepository;
import com.example.Thomas_Dohle_JPA.repositories.TopicRepository;

@CrossOrigin(allowCredentials="true")
@RestController
public class ListWidgetService {
	
	@Autowired
	ListWidgetRepository listWidgetRepository;
	
	@Autowired
	TopicRepository topicRepository;
	
	@GetMapping
	("/api/list/widget")
	public List<ListWidget> findAllListWidgets(){
		return (List<ListWidget>) listWidgetRepository.findAll();
	}
	
	@GetMapping
	("/api/list/widget/{id}")
	public ListWidget findListWidgetById(@PathVariable (value="id") int id) {
		return listWidgetRepository.findById(id).get();
	}
	
	@PostMapping
	("/api/topic/{tid}/list/widget")
	public ListWidget createListWidget(@RequestBody ListWidget wid,
			@PathVariable (value="tid") int tid) {
		Topic topic = topicRepository.findById(tid).get();
		wid.setTopic(topic);
		topic.addWidget(wid);
		listWidgetRepository.save(wid);
		topicRepository.save(topic);
		return wid;
	}
	
	@PutMapping
	("/api/list/widget/{wid}")
	public ListWidget updateListWidget(@PathVariable (value="wid") int wid,
			@RequestBody ListWidget newWidget) {
		ListWidget original = listWidgetRepository.findById(wid).get();
		original.update(newWidget);
		listWidgetRepository.save(original);
		return original;
	}
	
	@DeleteMapping
	("/api/list/widget/{wid}")
	public void deleteListWidget(@PathVariable (value="wid") int wid) {
		listWidgetRepository.deleteById(wid);
	}
	

}
