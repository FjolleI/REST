/**
 * 
 */
package com.coursestopics.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.coursestopics.springboot.model.Course;


public interface CourseRepository extends CrudRepository<Course, String>{
	
	public List<Course> findByTopicId(String topicId);
}
