package com.example.Thomas_Dohle_JPA.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import java.util.Random;
import javax.servlet.http.HttpSession;
import com.example.Thomas_Dohle_JPA.model.*;
import com.example.Thomas_Dohle_JPA.repositories.CourseRepository;
import com.example.Thomas_Dohle_JPA.repositories.UserRepository;

@CrossOrigin(allowCredentials="true")
@RestController
public class CourseService {
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	UserRepository userRepository;
	

	@PostMapping("/api/courses")
	public Course createCourse(@RequestBody Course course,
			HttpSession session) {
		User author = (User) session.getAttribute("currentUser");
		course.setAuthor(author);
		courseRepository.save(course);
		author.addCourse(course);
		userRepository.save(author);
		session.setAttribute("currentCourse", course);
		return course;
	}
	

	
	@GetMapping("/api/courses")
	public List<Course> findAllCourses(HttpSession session) {
		User currentUser = (User)session.getAttribute("currentUser");
		int authorId = currentUser.getId();
		List<Course> courses = courseRepository.findCoursesByAuthor(authorId);
		return courses;
	}
	
	@GetMapping("/api/courses/{cid}")
	public Course findCourseById(@PathVariable(value="cid")  int id, HttpSession session) {
		Course course = courseRepository.findById(id).get();
		return course;
	}
	
	@DeleteMapping("/api/courses/{cid}")
	public void deleteCourse(@PathVariable(value="cid") int id) {
		courseRepository.deleteById(id);
	}
	
	@PutMapping("/api/courses/{cid}")
	public Course updateCourse(@PathVariable(value="cid") int id, @RequestBody Course course) {
		Course oldCourse = courseRepository.findById(id).get();
		oldCourse.updateCourse(course);
		return courseRepository.save(oldCourse);
	}
}
	

