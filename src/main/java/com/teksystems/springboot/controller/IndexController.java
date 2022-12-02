package com.teksystems.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.teksystems.springboot.database.dao.CourseDAO;
import com.teksystems.springboot.database.entity.Course;
import security.AuthenticatedUserService;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private CourseDAO courseDao;

	@Autowired
	private AuthenticatedUserService authService;

	@Value("${spring.datasource.url}")
	private String variable;

	// search by instructor name
	// add an additional search field to the jsp page to take in the instructor
	// name. Put it in the same form that already exists and give the input box a
	// different name
	// create a DAO method to search by instructor name. Maybe do something fancy to
	// allow finding any string in the instruct name value .. using one of the
	// spring data functions.
	// to the controller .. add another parameter that will take in the insturctor
	// name
	// add the instructor name to the model so you can display again on the page
	// after submit
	// query your list of courses and display them below.
	// BONUS : make a single query that can search by course name or instructor
	// name.

	@RequestMapping(value = { "/", "/index", "/index.html" }, method = RequestMethod.GET)
	public ModelAndView slash(@RequestParam(required = false) String courseName,
							  @RequestParam(required = false) String instructorName) {

		ModelAndView response = new ModelAndView();
		response.setViewName("index");

		response.addObject("name", "Eric");

		// print out the incoming value in search variable
		System.out.println("Search parameter to page courseName     : " + courseName);
		System.out.println("Search parameter to page instructorName : " + instructorName);
		// add the search variable to the model so it can be displayed on the page.
		response.addObject("courseNameKey", courseName);
		response.addObject("instructorNameKey", instructorName);

		// if ( courseName != null && !courseName.equals("") ) {
		// List<Course> courses =
		// courseDao.findByNameContainingIgnoreCaseOrderByNameDesc(courseName);
		List<Course> courses = courseDao.findByNameOrInstructor(courseName, instructorName);
		for (Course c : courses) {
			System.out.println(c.getName());
		}
		response.addObject("courses", courses);
		// }

		// if the user is authenticated
		if ( authService.isAuthenticated() ) {
			boolean isAdmin = authService.isUserInRole("ADMIN");
			log.debug(authService.getCurrentUsername() + " is current logged in and admin access = " + isAdmin);
			log.debug(authService.getCurrentUser() + "");
		} else {
			log.debug("USER NOT LOGGED IN");
		}

		return response;
	}

	@RequestMapping(value = { "/search" }, method = RequestMethod.GET)
	public ModelAndView search() {
		System.out.println("Index controller search request");

		return null;
	}

	@RequestMapping(value = { "/course" }, method = RequestMethod.GET)
	public ModelAndView course() {
		// this method is called when /course is in the URL
		log.info("Index controller course request method");
		logger.info("this is using the static logger");

		ModelAndView response = new ModelAndView();
		response.setViewName("course");

		return response;
	}

	@RequestMapping(value = { "/courseSubmit" }, method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView courseSubmit(@RequestParam(required = false) String courseName,
									 @RequestParam(required = false) String instructorName) {

		ModelAndView response = new ModelAndView();
		response.setViewName("course");

		log.info("Index controller course submit method");
		log.info("Course Submit : courseName     : " + courseName);
		log.info("Course Submit : instructorName : " + instructorName);

		// change this error message to a list of strings
		// add the error message list to the model
		// fix the JSP page to use a loop inside the if statement to show errors on the
		// page
		List<String> errormessages = new ArrayList<>();
		if (courseName == null || courseName.equals("")) {
			errormessages.add("The course name can not be empty");
		}

		if (instructorName == null || instructorName.equals("")) {
			errormessages.add("The instructor name can not be empty");
		}

		if (!errormessages.isEmpty()) {
			// there is an error
			for (String error : errormessages) {
				log.info(error);
			}
			response.addObject("errors", errormessages);

			// by putting these incoming values back into the model we can prepopulate the
			// form so the user does not have to enter the values again.
			// we only want to do this in the case of an error.
			response.addObject("courseNameKey", courseName);
			response.addObject("instructorNameKey", instructorName);
		} else {
			Course course = new Course();
			course.setName(courseName);
			course.setInstructor(instructorName);

			courseDao.save(course);
		}

		return response;
	}

	// this is completely and totally wrong for a controller
	// you can not have any class level parameters in a controller
	private String value = "X";

	@ResponseBody
	@RequestMapping(value = { "/course/path/{id}" }, method = RequestMethod.GET)
	public Course pathVar(@PathVariable Integer id, HttpSession session) {
		log.info("Incoming path variable = " + id);

		Course c = courseDao.findById(id);
		log.info("this is my couse name " + c.getName());

		if (session.getAttribute("key") == null) {
			log.info("Key not found in session");
			session.setAttribute("key", "value");
		} else {
			log.info("Key is in the session ");
		}

		return c;
	}

	@ResponseBody
	@RequestMapping(value = { "/course/all" }, method = RequestMethod.GET)
	public List<Course> allCourses() {
		log.error("This is an error");
		log.warn("This is a warning");
		log.info("This is info");
		log.debug("This is debug");

		System.out.println("This is never okay");

		List<Course> courses = courseDao.findAll();

		return courses;
	}

	@RequestMapping(value = { "/course/instructor" }, method = RequestMethod.GET)
	public ModelAndView instCount() {
		ModelAndView response = new ModelAndView();
		response.setViewName("instructor_count");

		List<Map<String,Object>> instructorCounts = courseDao.instructorCourseCount();
		for ( Map<String,Object> count : instructorCounts ) {
			log.debug(count.get("instructor") + " is teaching " + count.get("cnt") + " course(s)");
		}

		response.addObject("instructorCounts", instructorCounts);

		return response;
	}

}
