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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpSession;
import com.example.Thomas_Dohle_JPA.model.*;
import com.example.Thomas_Dohle_JPA.repositories.LessonRepository;
import com.example.Thomas_Dohle_JPA.repositories.ModuleRepository;
import com.example.Thomas_Dohle_JPA.repositories.TopicRepository;


@CrossOrigin(allowCredentials="true")
@RestController
public class LessonService {

	@Autowired
	ModuleRepository moduleRepository;
	
	@Autowired
	LessonRepository lessonRepository;
	
	@Autowired
	TopicRepository topicRepository;
	
	
	@PostMapping("/api/modules/{mid}/lesson")
	public Lesson createModule(@RequestBody Lesson lesson,
			HttpSession session, @PathVariable (value="mid") int moduleId) {
		Module module = moduleRepository.findById(moduleId).get();
		lesson.setModule(module);
		module.addLesson(lesson);
		moduleRepository.save(module);
		lessonRepository.save(lesson);
		session.setAttribute("currentLesson", lesson);
		return lesson;
	}
	
	@PutMapping("/api/lessons/{lid}")
	public Lesson updateLesson(@RequestBody Lesson lesson, @PathVariable(value="lid") int lessonId) {
		Lesson oldLesson = lessonRepository.findById(lessonId).get();
		oldLesson.updateLesson(lesson);
		return lessonRepository.save(oldLesson);
	}
	
	@GetMapping("/api/modules/{mid}/lessons")
	public List<Lesson> findAllLessons(@PathVariable(value="mid") int moduleId){
		List<Lesson> lessons = lessonRepository.findLessonsByModule(moduleId);
		return lessons;
	}
	
	@GetMapping("/api/lessons/{lid}")
	public Lesson findLessonById(@PathVariable(value="lid")  int id, HttpSession session) {
		return lessonRepository.findById(id).get();
	}
	
	
	
	@DeleteMapping("/api/lessons/{lid}")
	public void deleteLesson(@PathVariable(value="lid") int id) {
		lessonRepository.deleteById(id);
	}
	

}