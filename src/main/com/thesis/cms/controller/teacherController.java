package com.thesis.cms.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.thesis.cms.common.page.Pagination;
import com.thesis.cms.common.page.SimplePage;
import com.thesis.cms.model.RcAdmin;
import com.thesis.cms.model.Students;
import com.thesis.cms.model.Teachers;
import com.thesis.cms.model.Thesis;
import com.thesis.cms.model.Time;
import com.thesis.cms.service.StudentsService;
import com.thesis.cms.service.TeacherService;
import com.thesis.cms.service.Thesisservice;
import com.thesis.cms.service.TimeService;
import com.thesis.cms.util.Constants;
import com.thesis.cms.util.UserUtil;

@Controller
@RequestMapping("/teacher")
public class teacherController {

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private TimeService timeService;
	
	
	@Autowired
	private Thesisservice thesisservice;

	@Autowired
	private StudentsService studentsService;

	@RequestMapping(value = "/addthesis.do", method = RequestMethod.POST)
	public String add(Thesis thesis, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		RcAdmin admin = UserUtil.getUser(request);
		Teachers teacher = teacherService.getTeacherByName(admin.getName());
		Date date =new Date();
		thesis.setTid(teacher.getTid());
		thesis.setCflag(0);
		thesis.setSubmitDate(date);
		thesisservice.insert(thesis);
		return "redirect:allth.do";
	}

	@RequestMapping("/intitle.do")
	public String add(HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		return "teacher/intitle";
	}

	@RequestMapping("/allth.do")
	public String detail(Integer id, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		RcAdmin admin = UserUtil.getUser(request);
		String username = admin.getName();
		Teachers teacher = teacherService.getTeacherByName(username);

		System.out.println(teacher.getTid());
		List<Thesis> thesis = thesisservice.test(teacher.getTid());
		for (int i = 0; i < thesis.size(); i++) {
			if (thesis.get(i).getStuid()!=null) {
				  String stuname=studentsService.selectBystuId(thesis.get(i).getStuid()).getStuname();
		          thesis.get(i).setStuname(stuname);
			}
		}
		
		model.addAttribute("thesis", thesis);
		return "teacher/Mythesis";
	}

	@RequestMapping("/v_list.do")
	public String detail2(Integer id, HttpServletRequest request,
			HttpServletResponse response, ModelMap model,Integer pageNo) {
		RcAdmin admin = UserUtil.getUser(request);
		String username = admin.getName();
		Teachers teacher = teacherService.getTeacherByName(username);
		Pagination pagination = this.thesisservice.getPaget(
				SimplePage.cpn(pageNo), Constants.PAGE_SIZE, teacher.getTid());
		model.addAttribute("pagination", pagination);
		return "teacher/teath";
	}

	@RequestMapping("/{cid}/v_list.do")
	public String appoint(Integer pageNo, String stuname,@PathVariable("cid") Integer cid,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		Pagination pagination = this.studentsService.getPage(
				SimplePage.cpn(pageNo), Constants.PAGE_SIZE,stuname);
		ModelAndView mav = new ModelAndView();
		model.addAttribute("pagination", pagination);
		model.addAttribute("cid", cid);
		mav.addObject("cid",cid);
		return "teacher/students";
	}

	@RequestMapping("/stuappoint.do")
	public String appoint2(Students student, Integer cid,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		RcAdmin admin = UserUtil.getUser(request);
		Teachers teacher = teacherService.getTeacherByName(admin.getName());
		Time time=timeService.selectTime();
		if (teacher.getSsum() == time.getStunumber()) {
			System.out.println("以达到教师可选最大人数");
			return "redirect:allth.do";

		} else {
			Thesis thesis = thesisservice.getThesisByCid(cid);
			student.setTid(teacher.getTid());
			thesis.setCflag(1);
			thesis.setStuid(student.getStuid());
			thesis.setTid(teacher.getTid());
			System.out.println(thesis.getCtitle());
			System.out.println(thesis.getStuid());
			thesisservice.updateByPrimaryKey(thesis);

			teacherService.updateSum(teacher);
			studentsService.updateTid(student);
			return "redirect:allth.do";
		}
	}

}
