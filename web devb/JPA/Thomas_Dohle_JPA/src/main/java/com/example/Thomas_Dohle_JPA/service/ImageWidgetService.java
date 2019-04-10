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
import com.example.Thomas_Dohle_JPA.model.Topic;
import com.example.Thomas_Dohle_JPA.repositories.ImageWidgetRepository;
import com.example.Thomas_Dohle_JPA.repositories.TopicRepository;

@CrossOrigin(allowCredentials="true")
@RestController
public class ImageWidgetService {

	@Autowired
	ImageWidgetRepository imageWidgetRepository;
	
	@Autowired
	TopicRepository topicRepository;
	
	@GetMapping
	("/api/image/widget")
	public List<ImageWidget> findAllImageWidgets(){
		return (List<ImageWidget>) imageWidgetRepository.findAll();
	}
	
	@GetMapping
	("/api/image/widget/{id}")
	public ImageWidget findImageWidgetById(@PathVariable (value="id") int id) {
		return imageWidgetRepository.findById(id).get();
	}
	
	@PostMapping
	("/api/topic/{tid}/image/widget")
	public ImageWidget createParagraphWidget(@RequestBody ImageWidget wid,
			@PathVariable (value="tid") int tid) {
		Topic topic = topicRepository.findById(tid).get();
		wid.setTopic(topic);
		topic.addWidget(wid);
		imageWidgetRepository.save(wid);
		topicRepository.save(topic);
		return wid;
	}
	
	@PutMapping
	("/api/image/widget/{wid}")
	public ImageWidget updateImageWidget(@PathVariable (value="wid") int wid,
			@RequestBody ImageWidget newWidget) {
		System.out.println("Before save: " + newWidget.toString());
		ImageWidget original = imageWidgetRepository.findById(wid).get();
		original.update(newWidget);
		imageWidgetRepository.save(original);
		System.out.println("After save: " + original.toString());
		return original;
	}
	
	@DeleteMapping
	("/api/image/widget/{wid}")
	public void deleteImageWidget(@PathVariable (value="wid") int wid) {
		imageWidgetRepository.deleteById(wid);
	}
	
	
}
