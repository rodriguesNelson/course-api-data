package io.javabrains.springbootstarter.course.service;

import java.util.List;

import io.javabrains.springbootstarter.course.bean.Course;

public interface ICourseService {
	
	public List<Course> getAllCourses(String topicId);

	public Course getCourse(String id);

	public Course addCourse(Course course);

	public Course updateCourse(Course course);
	
	public boolean deleteCourse(String id);
}
