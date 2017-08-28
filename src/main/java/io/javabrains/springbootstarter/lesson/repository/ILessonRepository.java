package io.javabrains.springbootstarter.lesson.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.javabrains.springbootstarter.lesson.bean.Lesson;

public interface ILessonRepository extends CrudRepository<Lesson, Long> {
	
	public List<Lesson> findByCourseId(String courseId);
}
