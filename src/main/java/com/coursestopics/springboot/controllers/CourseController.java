package com.coursestopics.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coursestopics.springboot.model.Course;
import com.coursestopics.springboot.model.Topic;
import com.coursestopics.springboot.service.CourseService;

@RestController
@RequestMapping("/topics/{topicId}/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("/")
	public List<Course> getAllCourses(@PathVariable Integer topicId){
		return courseService.getAllCourses(topicId);
	}

	@RequestMapping("/{courseId}")
	public Course getCourse(@PathVariable String topicId, @PathVariable String courseId){
		return courseService.getCourse(topicId,courseId);
	}

	@RequestMapping(method=RequestMethod.POST, value="/")
	public void addCourse(@PathVariable Integer topicId, @RequestBody Course course){
		Topic topic = new Topic(topicId,"name", " description");
		course.setTopic(topic);
		courseService.addCourse(course);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/{courseId}")
	public void updateCourse(@PathVariable String courseId, @RequestBody Course course){
		courseService.updateCourse(courseId, course);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/{courseId}")
	public void deleteCourse(@PathVariable String courseId){
		courseService.deleteCourse(courseId);
	}

}