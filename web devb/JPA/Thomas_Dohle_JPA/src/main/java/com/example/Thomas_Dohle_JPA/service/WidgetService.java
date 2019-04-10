package com.example.Thomas_Dohle_JPA.service;

import java.util.ArrayList;
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
import com.example.Thomas_Dohle_JPA.model.Widget;
import com.example.Thomas_Dohle_JPA.repositories.TopicRepository;
import com.example.Thomas_Dohle_JPA.repositories.WidgetRepository;

@CrossOrigin(allowCredentials="true")
@RestController
public class WidgetService {
	@Autowired
	WidgetRepository widgetRepository;
	
	@Autowired
	TopicRepository topicRepository;
	
	@GetMapping("/api/widget/{wid}")
	public Widget findWidgetById(@PathVariable(value="wid") int wid) {
		Widget widget = widgetRepository.findById(wid).get();
		return widget;
	}
	
	@GetMapping("/api/topic/{topicId}/widget")
	public List<Widget> getWidgetsForTopic(@PathVariable(value="topicId") int topicId){
		List<Widget> widgets = widgetRepository.findWidgetsByTopic(topicId);
		return widgets;
	}
	
	@PostMapping
	("/api/topic/{tid}/widget")
	public Widget createWidget(@RequestBody Widget wid,
			@PathVariable (value="tid") int tid) {
		Topic topic = topicRepository.findById(tid).get();
		wid.setWidgetType("HEADING");
		wid.setTopic(topic);
		topic.addWidget(wid);
		widgetRepository.save(wid);
		topicRepository.save(topic);
		return wid;
	}
	
	@PutMapping("/api/widget/{wid}")
	public Widget updateWidget(@PathVariable(value="wid") int wid,
			@RequestBody Widget newWidget){
		Widget oldWidget = widgetRepository.findById(wid).get();
		oldWidget = newWidget;
		widgetRepository.save(newWidget);
		System.out.println(widgetRepository.findById(wid).get().toString());
		return widgetRepository.findById(wid).get();
	}
	
	@DeleteMapping("/api/widget/{wid}")
	public void deleteWidget(@PathVariable(value="wid") int wid){
		widgetRepository.deleteById(wid);
	}
	


}
