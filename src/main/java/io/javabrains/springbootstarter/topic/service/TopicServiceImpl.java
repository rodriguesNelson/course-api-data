package io.javabrains.springbootstarter.topic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.springbootstarter.topic.bean.Topic;
import io.javabrains.springbootstarter.topic.repository.ITopicRepository;

@Service
public class TopicServiceImpl implements ITopicService {
	
	@Autowired
	private ITopicRepository topicRepository;

	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Topic getTopic(String id) {
		return topicRepository.findOne(id);
	}

	public Topic addTopic(Topic topic) {
		return topicRepository.save(topic);
	}

	public Topic updateTopic(Topic topic) {
		if (!topicRepository.exists(topic.getId()))
			return null;
		return topicRepository.save(topic);
	}

	public boolean deleteTopic(String id) {
		if (!topicRepository.exists(id))
			return false;
		topicRepository.delete(id);
		return true;
	}
}
