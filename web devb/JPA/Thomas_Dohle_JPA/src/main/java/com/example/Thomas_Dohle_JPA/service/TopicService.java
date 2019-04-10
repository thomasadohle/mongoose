package com.example.Thomas_Dohle_JPA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Thomas_Dohle_JPA.model.*;
import com.example.Thomas_Dohle_JPA.repositories.LessonRepository;
import com.example.Thomas_Dohle_JPA.repositories.TopicRepository;
import com.example.Thomas_Dohle_JPA.repositories.WidgetRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpSession;

@CrossOrigin(allowCredentials="true")
@RestController
public class TopicService {

	@Autowired
	LessonRepository lessonRepository;
	
	@Autowired
	TopicRepository topicRepository;
	
	@Autowired
	WidgetRepository widgetRepository;

	@PostMapping("/api/lessons/{lid}/topic")
	public Topic createTopic(@RequestBody Topic topic,
			HttpSession session, @PathVariable (value="lid") int lessonId) {
		Lesson lesson = lessonRepository.findById(lessonId).get();
		topic.setLesson(lesson);
		lesson.addTopic(topic);
		topicRepository.save(topic);
		lessonRepository.save(lesson);
		session.setAttribute("currentTopic", topic);
		return topic;
	}
	
	@PutMapping("/api/topics/{tid}")
	public Topic updateTopic(@RequestBody Topic topic, @PathVariable(value="tid") int topicId) {
		Topic oldTopic = topicRepository.findById(topicId).get();
		oldTopic.updateTopic(topic);
		return topicRepository.save(oldTopic);
	}
	
	@GetMapping("/api/lessons/{lid}/topics")
	public List<Topic> findAllTopics(@PathVariable(value="lid") int lessonId){
		List<Topic> topicsForLesson = topicRepository.findTopicsByLesson(lessonId);
		return topicsForLesson;
	}
	
	@GetMapping("/api/topics/{tid}")
	public Topic findTopicById(@PathVariable(value="tid")  int topicId, HttpSession session) {
		return topicRepository.findById(topicId).get();
	}
	
	@DeleteMapping("/api/topics/{tid}")
	public void deleteTopic(@PathVariable(value="tid") int topicId) {
		topicRepository.deleteById(topicId);
	}
	
//	@PostMapping("/api/topic/{tid}/widget")
//	public Widget createWidget(@RequestBody Widget widget, @PathVariable (value="tid") int topicId) {
//		Topic topic = topicRepository.findById(topicId).get();
//		topic.addWidget(widget);
//		widget.setTopic(topic);
//		topicRepository.save(topic);
//		widgetRepository.save(widget);
//		return widget;
//	}
	

}