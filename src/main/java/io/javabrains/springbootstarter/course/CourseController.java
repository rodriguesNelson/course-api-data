package io.javabrains.springbootstarter.course;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.course.bean.Course;
import io.javabrains.springbootstarter.course.service.ICourseService;
import io.javabrains.springbootstarter.topic.bean.Topic;

@RestController
@RequestMapping("/topics/{topicId}/courses")
public class CourseController {
	
	private static final String APPLICATION_JSON = "application/json";
	@Autowired
	private ICourseService courseService;

	@RequestMapping("")
	public List<Course> getAllCourses(@PathVariable String topicId) {
		return courseService.getAllCourses(topicId);
	}
	
	@RequestMapping("/{id}")
	public Course getCourse(@PathVariable String topicId, @PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	public Course addCourse(@PathVariable String topicId, @RequestBody Course course) {
		Course courseLocal = course;
		courseLocal.setTopic(new Topic(topicId, "", ""));
		return courseService.addCourse(courseLocal);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	public Course updateCourse(@PathVariable String topicId, @RequestBody Course course, @PathVariable String id) {
		Course courseLocal = course;
		courseLocal.setId(id);
		courseLocal.setTopic(new Topic(topicId, "", ""));
		return courseService.updateCourse(courseLocal);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public boolean deleteCourse(@PathVariable String topicId, @PathVariable String id) {
		return courseService.deleteCourse(id);
	}
}
