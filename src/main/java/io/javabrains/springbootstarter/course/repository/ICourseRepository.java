package io.javabrains.springbootstarter.course.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.javabrains.springbootstarter.course.bean.Course;

public interface ICourseRepository extends CrudRepository<Course, String> {
	
	public List<Course> findByTopicId(String topicId);
	
	public List<Course> findByName(String name);
	
	public List<Course> findByDescription(String description);
}
