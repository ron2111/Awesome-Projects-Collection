package com.cg.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.demo.dao.StudentRepo;
import com.cg.demo.model.Student;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	StudentRepo repo;
	
		@RequestMapping("/")
		public String home() {
			return "home.jsp";
		}
		
		@RequestMapping("/addStudent")
		public String addStudent(Student student) {
			repo.save(student);
			return "home.jsp";
		}
		
		@RequestMapping("/getStudent")
		public ModelAndView getStudent(@RequestParam int id) {
			ModelAndView mv = new ModelAndView();
			Student student = repo.findById(id).orElse(null);
			
			System.out.println(repo.findByTech("Android"));
			System.out.println(repo.findByIdGreaterThan(101));
			System.out.println(repo.findByIdLessThan(105));
			
			System.out.println(repo.findByTechSorted("Android"));
			
			mv.addObject(student);
			mv.setViewName("showStudent.jsp");
			return mv;
		}
		
		@RequestMapping("/getAll")
		public ModelAndView getAllStudent() {
			System.out.println("Check");
			ModelAndView mv = new ModelAndView();
			List<Student> list = new ArrayList<>();
			repo.findAll().forEach(list::add);
			mv.addObject("list", list);
			mv.setViewName("showAllStudent.jsp");
			return mv;
		}
		
		@RequestMapping("/updateStudent")
		public ModelAndView updateStudent(@RequestParam int id, @RequestParam String name, @RequestParam String tech) {
			ModelAndView mv = new ModelAndView();
			Student student = repo.findById(id).orElse(null);
			student.setName(name);
			student.setTech(tech);
			repo.save(student);
			mv.addObject(student);
			mv.setViewName("updateStudent.jsp");
			return mv;
		}
		
		@RequestMapping("/deleteStudent")
		public String deleteStudent(@RequestParam int id) {
			repo.deleteById(id);
			return "home.jsp";
		}
		
		
		
}
