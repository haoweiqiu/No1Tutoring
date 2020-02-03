package ca.mcgill.ecse321.tutoring_service.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.tutoring_service.dto.TutorDto;
import ca.mcgill.ecse321.tutoring_service.model.Course;
import ca.mcgill.ecse321.tutoring_service.model.Tutor;
import ca.mcgill.ecse321.tutoring_service.service.CourseService;
import ca.mcgill.ecse321.tutoring_service.service.SubjectService;
import ca.mcgill.ecse321.tutoring_service.service.TutorService;

@CrossOrigin(origins = "*")
@RestController
public class SearchActionsRestController {
	@Autowired
	TutorService tutorService;

	@Autowired
	SubjectService subjectService;

	@Autowired
	CourseService courseService;

	/**
	 * This method use get mapping to get the list of tutor dtos by providing the
	 * tutor name.
	 * 
	 * @param courseName
	 * @return a list of tutor dtos
	 */
	@GetMapping(value = { "/tutors_byCourse/{name}", "/tutors_byCourse/{name}/" })
	public List<TutorDto> getAllTutorsForOneCourse(@PathVariable("name") String courseName) {
		List<TutorDto> tutorDtos = new ArrayList<>();
		for (Tutor tutor : tutorService.getAllTutors()) {
			HashSet<String> courseNames = new HashSet<>();
			for (Course c : tutor.getCourse()) {
				courseNames.add(c.getName());
			}
			if (courseNames.contains(courseName)) {
				tutorDtos.add(convertToDto(tutor));
			}
		}
		return tutorDtos;
	}

	/**
	 * This method uses get mapping to retrieves the tutor dto by providng the name
	 * of the tutor.
	 * 
	 * @param name
	 * @return
	 * @throws IllegalArgumentException
	 */
	@GetMapping(value = { "/tutors/{name}", "/tutors/{name}/" })
	public TutorDto getTutorByName(@PathVariable("name") String name) throws IllegalArgumentException {
		return convertToDto(tutorService.getTutor(name));
	}

	/**
	 * This method convert the tutor to tutor dto.
	 * 
	 * @param e
	 * @return
	 */
	private TutorDto convertToDto(Tutor e) {
		if (e == null) {
			throw new IllegalArgumentException("There is no such tutor!");
		}
		TutorDto tutorDto = new TutorDto(e.getName(), e.getEmail());
		return tutorDto;
	}

}