package io.javabrains.springbootstarter.course.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.springbootstarter.course.bean.Course;
import io.javabrains.springbootstarter.course.repository.ICourseRepository;

@Service
public class CourseServiceImpl implements ICourseService {
	
	@Autowired
	private ICourseRepository courseRepository;

	public List<Course> getAllCourses(String topicId) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}

	public Course getCourse(String id) {
		return courseRepository.findOne(id);
	}

	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}

	public Course updateCourse(Course course) {
		if (!courseRepository.exists(course.getId()))
			return null;
		return courseRepository.save(course);
	}

	public boolean deleteCourse(String id) {
		if (!courseRepository.exists(id))
			return false;
		courseRepository.delete(id);
		return true;
	}
}
