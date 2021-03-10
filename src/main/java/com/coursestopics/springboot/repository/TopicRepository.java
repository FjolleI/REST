/**
 * 
 */
package com.coursestopics.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.coursestopics.springboot.model.Topic;


public interface TopicRepository extends CrudRepository<Topic, String>{

}
