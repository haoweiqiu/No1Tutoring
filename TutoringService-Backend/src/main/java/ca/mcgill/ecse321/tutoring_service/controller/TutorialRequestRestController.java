package ca.mcgill.ecse321.tutoring_service.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.tutoring_service.dto.BillDto;
import ca.mcgill.ecse321.tutoring_service.dto.RegistrationDto;
import ca.mcgill.ecse321.tutoring_service.dto.SessionDto;
import ca.mcgill.ecse321.tutoring_service.dto.TutorDto;
import ca.mcgill.ecse321.tutoring_service.model.Bill;
import ca.mcgill.ecse321.tutoring_service.model.Registration;
import ca.mcgill.ecse321.tutoring_service.model.Room;
import ca.mcgill.ecse321.tutoring_service.model.Session;
import ca.mcgill.ecse321.tutoring_service.service.BillService;
import ca.mcgill.ecse321.tutoring_service.service.RegistrationService;
import ca.mcgill.ecse321.tutoring_service.service.RoomService;
import ca.mcgill.ecse321.tutoring_service.service.SessionService;

@CrossOrigin(origins = "*")
@RequestMapping("/tutorial_request")
@RestController
public class TutorialRequestRestController {

	@Autowired
	private SessionService sessionService;
	@Autowired
	private BillService billService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private RegistrationService regService;

	/**
	 * This methods use post mapping to create a session by providing the finish
	 * time, start time, tutor name and course name.
	 * 
	 * @param startTime
	 * @param finishTime
	 * @param tutorName
	 * @param courseName
	 * @return session dto
	 */
	@PostMapping(value = { "/tutorial_sessions", "/tutorial_sessions/" })

	public SessionDto createTutorialSession(@RequestParam(name = "startTime") String startTime,
			@RequestParam(name = "finishTime") String finishTime, @RequestParam(name = "tutorName") String tutorName,
			@RequestParam(name = "courseName") String courseName) {

		List<Room> rooms = roomService.getAllRooms();
		for (Room room : rooms) {
			if (room.getCapacity() == 0) {
				Session session = sessionService.createSession(startTime, finishTime, tutorName, courseName, room);
				return convertDto(session);
			}
		}
		return null;
	}

	/**
	 * This method creates a registration dto by providing finish time, start time,
	 * tutor name and student name
	 * 
	 * @param startTime
	 * @param finishTime
	 * @param tutorName
	 * @param studentName
	 * @return
	 */
	@PostMapping(value = { "/registration", "/registration/" })
	public RegistrationDto createRegistrationDto(@RequestParam("startTime") String startTime,
			@RequestParam("finishTime") String finishTime, @RequestParam("tutorName") String tutorName,
			@RequestParam("studentName") String studentName) {
		Registration reg = regService.createRegistration(startTime, studentName, tutorName, startTime, finishTime);
		return convertDto(reg);
	}

	/**
	 * getRegistration is required in the for displaying a list of registrations
	 * ATTENTION: passed in var is type student
	 * 
	 * @Yuhang Zhang
	 */
	@GetMapping(value = { "/registrations/" })
	public List<RegistrationDto> getRegistrations(@RequestParam("studentName") String studentName)
			throws IllegalArgumentException {
		List<Registration> allRegistrations = regService.getAllRegistration();

		// ALL registrations for a specific student
		List<Registration> allStudentRegistrations = new ArrayList<>();

		for (Registration reg : allRegistrations) {
			if (reg.getStudent().getName().equals(studentName))
				allStudentRegistrations.add(reg);
		}

		// allStuReg stands for allStudentRegistrationDtos
		List<RegistrationDto> allStuRegsDtos = new ArrayList<>();
		for (Registration reg : allStudentRegistrations) {
			allStuRegsDtos.add(convertDto(reg));
		}

		return allStuRegsDtos;
	}

	/**
	 * This method uses post mapping to create the bill dto.
	 * 
	 * @param amount
	 * @param registrationId
	 * @return
	 */
	@PostMapping(value = { "/bills", "/bills/" })
	public BillDto createTutorialBillDto(@RequestParam(name = "amount") String amount,
			@RequestParam(name = "registrationNr") String registrationId) {
		double fee = Double.parseDouble(amount);
		int regiNum = Integer.parseInt(registrationId);
		Bill bill = billService.createBill(fee, regiNum);
		return convertDto(bill);
	}

	/**
	 * This method converts the bill to bill dto.
	 * 
	 * @param bill
	 * @return
	 */
	private BillDto convertDto(Bill bill) {
		if (bill == null) {
			throw new IllegalArgumentException("There is no such bill!");
		}

		RegistrationDto regDto = new RegistrationDto(bill.getRegistration().getTime(),
				convertDto(bill.getRegistration().getSession()), bill.getRegistration().getIsFeedbackGiven());
		BillDto billDto = new BillDto(bill.getAmount(), regDto);

		return billDto;
	}

	/**
	 * This method converts the session to session dto.
	 * 
	 * @param session
	 * @return session dto
	 */
	private SessionDto convertDto(Session session) {
		if (session == null) {
			throw new IllegalArgumentException("There is no such session!");
		}
		TutorDto tutorDto = new TutorDto(session.getTutor().getName(), session.getTutor().getEmail());
		SessionDto sessionDto = new SessionDto(session.getStartTime(), session.getFinishTime(), 1, tutorDto,
				session.getRoom().getRoomNr());
		return sessionDto;
	}

	/**
	 * This method converts the registration to resgistration dto.
	 * 
	 * @param reg
	 * @return registration dto
	 */
	private RegistrationDto convertDto(Registration reg) {
		if (reg == null) {
			throw new IllegalArgumentException("There is no such registration!");
		}
		RegistrationDto regDto = new RegistrationDto(reg.getTime(), convertDto(reg.getSession()),
				reg.getIsFeedbackGiven());
		return regDto;
	}

}
