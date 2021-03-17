package com.coursestopics.springboot.controllers;

import java.util.List;

import com.coursestopics.springboot.model.User;
import com.coursestopics.springboot.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.coursestopics.springboot.model.Topic;
import com.coursestopics.springboot.service.TopicService;

@RestController
@RequestMapping("/topics")

public class TopicController {

	@Autowired
	private TopicService topicService;



	@RequestMapping("/")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}

	@RequestMapping("/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/")
	public ResponseEntity<Response> addTopic(@RequestBody Topic topic) throws Exception {

		topicService.addTopic(topic);

		try {
			Response response = Response.builder()
					.success(true)
					.code(200)
					.message("User has been created successfully!")
					.data(topic)
					.build();
			return ResponseEntity.ok(response);

		}catch (Exception e) {
			throw new Exception("Failed to create user!");
		}


	}

	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public void updateTopic(@PathVariable String id, @RequestBody Topic topic){
		topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public void deleteTopic(@PathVariable String id){
		topicService.deleteTopic(id);
	}
	
}