package io.javabrains.springbootstarter.lesson.service;

import java.util.List;

import io.javabrains.springbootstarter.lesson.bean.Lesson;

public interface ILessonService {
	
	public List<Lesson> getAllLessons(String topicId, String lessonId);

	public Lesson getLesson(Long id);

	public Lesson addLesson(Lesson lesson);

	public Lesson updateLesson(Lesson lesson);
	
	public boolean deleteLesson(Long id);
}
