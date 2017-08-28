package io.javabrains.springbootstarter.topic;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.bean.Topic;
import io.javabrains.springbootstarter.topic.service.ITopicService;

@RestController
@RequestMapping("/topics")
public class TopicController {
	
	private static final String APPLICATION_JSON = "application/json";
	@Autowired
	private ITopicService topicService;

	@RequestMapping("")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	public Topic addTopic(@RequestBody Topic topic) {
		return topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	public Topic updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		Topic topicLocal = topic;
		topicLocal.setId(id);
		return topicService.updateTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public boolean deleteTopic(@PathVariable String id) {
		return topicService.deleteTopic(id);
	}
}
