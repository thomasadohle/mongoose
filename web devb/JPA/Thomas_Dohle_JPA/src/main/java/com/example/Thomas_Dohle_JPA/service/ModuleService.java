package com.example.Thomas_Dohle_JPA.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Thomas_Dohle_JPA.model.Course;
import com.example.Thomas_Dohle_JPA.model.Module;
import com.example.Thomas_Dohle_JPA.repositories.CourseRepository;
import com.example.Thomas_Dohle_JPA.repositories.ModuleRepository;


@CrossOrigin(allowCredentials="true")
@RestController
public class ModuleService {
	@Autowired
	ModuleRepository moduleRepository;
	
	@Autowired
	CourseRepository courseRepository;

	
	@PostMapping("/api/courses/{cid}/modules")
	public Module createModule(@RequestBody Module module,
			HttpSession session, @PathVariable (value="cid") int courseId) {
		Course course = courseRepository.findById(courseId).get();
		module.setCourse(course);
		course.addModule(module);
		moduleRepository.save(module);
		courseRepository.save(course);
		session.setAttribute("currentModule", module);
		return module;
	}
	
	@PutMapping("/api/modules/{mid}")
	public Module updateModule(@RequestBody Module module, @PathVariable(value="mid") int moduleId) {
		Module oldModule = moduleRepository.findById(moduleId).get();
		oldModule.updateModule(module);
		return moduleRepository.save(oldModule);
	}
	
	@GetMapping("/api/courses/{cid}/modules")
	public List<Module> findAllModules(@PathVariable(value="cid") int courseId){
		List<Module> modules = moduleRepository.findModulesByCourse(courseId);
		return modules;
	}
	
	@GetMapping("/api/modules/{mid}")
	public Module findModuleById(@PathVariable(value="mid")  int id, HttpSession session) {
		return moduleRepository.findById(id).get();
	}
	
	
	
	@DeleteMapping("/api/modules/{mid}")
	public void deleteModule(@PathVariable(value="mid") int id) {
		moduleRepository.deleteById(id);
	}
	
	

	
}