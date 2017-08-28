package io.javabrains.springbootstarter.topic.service;

import java.util.List;

import io.javabrains.springbootstarter.topic.bean.Topic;

public interface ITopicService {
	
	public List<Topic> getAllTopics();

	public Topic getTopic(String id);

	public Topic addTopic(Topic topic);

	public Topic updateTopic(Topic topic);
	
	public boolean deleteTopic(String id);
}
