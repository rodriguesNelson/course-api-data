package io.javabrains.springbootstarter.lesson;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.course.bean.Course;
import io.javabrains.springbootstarter.lesson.bean.Lesson;
import io.javabrains.springbootstarter.lesson.service.ILessonService;

@RestController
@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
public class LessonController {
	
	private static final String APPLICATION_JSON = "application/json";
	@Autowired
	private ILessonService lessonService;

	@RequestMapping("")
	public List<Lesson> getAllLessons(@PathVariable String topicId, @PathVariable String courseId) {
		return lessonService.getAllLessons(topicId, courseId);
	}
	
	@RequestMapping("/{id}")
	public Lesson getLesson(@PathVariable String topicId, @PathVariable String courseId, @PathVariable Long id) {
		return lessonService.getLesson(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	public Lesson addLesson(@PathVariable String topicId, @PathVariable String courseId, @RequestBody Lesson lesson) {
		Lesson lessonLocal = lesson;
		lessonLocal.setCourse(new Course(courseId, "", "", topicId));
		return lessonService.addLesson(lessonLocal);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	public Lesson updateLesson(@PathVariable String topicId,  @PathVariable String courseId, @PathVariable Long id, @RequestBody Lesson lesson) {
		Lesson lessonLocal = lesson;
		lessonLocal.setId(id);
		lessonLocal.setCourse(new Course(courseId, "", "", topicId));
		return lessonService.updateLesson(lessonLocal);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public boolean deleteLesson(@PathVariable String topicId, @PathVariable String courseId, @PathVariable Long id) {
		return lessonService.deleteLesson(id);
	}
}
