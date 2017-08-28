package io.javabrains.springbootstarter.lesson.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.springbootstarter.lesson.bean.Lesson;
import io.javabrains.springbootstarter.lesson.repository.ILessonRepository;

@Service
public class LessonServiceImpl implements ILessonService {
	
	@Autowired
	private ILessonRepository lessonRepository;

	public List<Lesson> getAllLessons(String topicId, String courseId) {
		List<Lesson> lessons = new ArrayList<>();
		lessonRepository.findByCourseId(courseId).forEach(lessons::add);
		return lessons;
	}

	public Lesson getLesson(Long id) {
		return lessonRepository.findOne(id);
	}

	public Lesson addLesson(Lesson lesson) {
		return lessonRepository.save(lesson);
	}

	public Lesson updateLesson(Lesson lesson) {
		if (!lessonRepository.exists(lesson.getId()))
			return null;
		return lessonRepository.save(lesson);
	}

	public boolean deleteLesson(Long id) {
		if (!lessonRepository.exists(id))
			return false;
		lessonRepository.delete(id);
		return true;
	}
}
