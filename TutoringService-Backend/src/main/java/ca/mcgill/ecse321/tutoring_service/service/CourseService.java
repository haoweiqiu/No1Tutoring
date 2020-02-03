package ca.mcgill.ecse321.tutoring_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.tutoring_service.dao.CourseRepository;
import ca.mcgill.ecse321.tutoring_service.model.Course;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepo;

	/**
	 * This is used to create the course by checking if the input is valid.
	 * 
	 * @param name
	 * @return
	 */

	@Transactional
	public Course createCourse(String name) {
		if (name == null || name == "") {
			throw new IllegalArgumentException("Course name cannot be empty!");
		}
		Course course = courseRepo.findCourseByName(name);
		if (course == null) {
			course = new Course();
			course.setName(name);
			courseRepo.save(course);
		}
		return course;
	}

	/**
	 * This is used to delete the course with given name.
	 * 
	 * @param name
	 */
	@Transactional
	public void deleteCourseByName(String name) {
		courseRepo.deleteByName(name);
	}

	/**
	 * Find all the Courses
	 * 
	 * @return
	 */
	@Transactional
	public List<Course> getAllCourses() {
		return toList(courseRepo.findAll());
	}

	/**
	 * This is used to get course by providing the course name.
	 * 
	 * @param name
	 * @return
	 */
	@Transactional
	public Course getCourse(String name) {
		return courseRepo.findCourseByName(name);
	}

	private <T> List<T> toList(Iterable<T> iterable) {
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
}
