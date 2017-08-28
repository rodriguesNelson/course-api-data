package io.javabrains.springbootstarter.topic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.javabrains.springbootstarter.topic.bean.Topic;

@Repository
public interface ITopicRepository extends CrudRepository<Topic, String> {
}
