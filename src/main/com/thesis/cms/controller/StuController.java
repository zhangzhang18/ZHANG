package com.thesis.cms.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.thesis.cms.common.page.Pagination;
import com.thesis.cms.common.page.SimplePage;
import com.thesis.cms.model.RcAdmin;
import com.thesis.cms.model.Students;
import com.thesis.cms.model.Teachers;
import com.thesis.cms.model.Thesis;
import com.thesis.cms.model.Time;
import com.thesis.cms.service.RcAdminService;
import com.thesis.cms.service.StudentsService;
import com.thesis.cms.service.TeacherService;
import com.thesis.cms.service.Thesisservice;
import com.thesis.cms.service.TimeService;
import com.thesis.cms.util.Constants;
import com.thesis.cms.util.UserUtil;

@Controller
@RequestMapping("/student")
public class StuController {

    @Autowired
    private RcAdminService rcAdminService;

    @Autowired
    private TimeService timeService;

    @Autowired
    private StudentsService studentsService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private Thesisservice thesisservice;


    @RequestMapping("/jq.do")
    public boolean jq(HttpServletRequest request,
                      HttpServletResponse response, ModelMap model) {
        boolean a = false;
        return a;
    }

    @RequestMapping("/pwd.do")
    public String pwd(HttpServletRequest request,
                      HttpServletResponse response, ModelMap model) {
        RcAdmin rcadmin = UserUtil.getUser(request);
        model.addAttribute("user", rcadmin);
        return "student/stupwd";
    }

    @RequestMapping(value = "/stupwd.do", method = RequestMethod.POST)
    public String stupwd(HttpServletRequest request,
                         HttpServletResponse response, ModelMap model, String passWord) {
        RcAdmin rcadmin = UserUtil.getUser(request);
        rcadmin.setPassWord(passWord);
        rcAdminService.updatebystuname(rcadmin);
        model.addAttribute("user", rcadmin);
        return "redirect:../welcome/index.do";
    }

    @RequestMapping(value = "/selth.do", method = RequestMethod.POST)
    public ModelAndView se(Integer id, HttpServletRequest request,
                           HttpServletResponse response) {
        String ctitle = request.getParameter("ctitle");
        String teaname = request.getParameter("teaname");
        String pinyin = request.getParameter("pinyin");
        ModelAndView mav = new ModelAndView();
        if (!ctitle.equals("")) {
            List<Thesis> thesis = thesisservice.selectByTitle(ctitle);
            mav.addObject("thesis", thesis);
        }else  if(!teaname.equals("")) {
            Teachers teacher =teacherService.selectTeacherByName(teaname);
            List<Thesis> thesis = thesisservice.selectThesisByTid(teacher.getTid());
            mav.addObject("thesis", thesis);
        }else {
            Teachers teacher =teacherService.getTeacherByName(pinyin);
            List<Thesis> thesis = thesisservice.selectThesisByTid(teacher.getTid());
            mav.addObject("thesis", thesis);
        }

        mav.setViewName("student/seatitle");

        // request.getSession().setAttribute("thesis", thesis);
        return mav;
    }

    @RequestMapping("/update.do")
    public String detail(Integer stuid, HttpServletRequest request,
                         HttpServletResponse response, ModelMap model, Students student) {
        student = studentsService.selectBystuId(stuid);
        model.addAttribute("student", student);
        return "student/stuupdate";
    }

    @RequestMapping(value = "/stupdate.do", method = RequestMethod.POST)
    public String stuup(Integer id, HttpServletRequest request,
                        HttpServletResponse response, ModelMap model, Students student) {
        RcAdmin rcadmin = UserUtil.getUser(request);
        studentsService.update(student);
        rcadmin.setPassWord(student.getStupwd());
        rcAdminService.updatebystuname(rcadmin);
        model.addAttribute("student", student);// fasong

        return "redirect:stulist.do";
    }

    @RequestMapping("/student.do")
    public String sslist(String root, HttpServletRequest request,
                         HttpServletResponse response, ModelMap model) {

        return "redirect:stulist.do";
    }

    @RequestMapping("/stulist.do")
    public String slist(String root, HttpServletRequest request,
                        HttpServletResponse response, ModelMap model) {
        RcAdmin rcadmin = UserUtil.getUser(request);
        Students student = studentsService.selectByName(rcadmin.getName());
        Teachers teacher = new Teachers();
        Thesis thesis = new Thesis();
        if (student.getTid() != null) {
            thesis = thesisservice.getthesisBySid(student.getStuid());
            teacher = teacherService.getTeacherByCTid(student.getTid());
        } else {
            thesis.setCtitle("未选");
            teacher.setTeaName("未选");
        }
        model.addAttribute("student", student);
        model.addAttribute("thesis", thesis);
        model.addAttribute("teacher", teacher);
        return "student/stuziliao";
    }

    @RequestMapping("/v_list.do")
    public String thlist(Integer pageNo, String teaname,
                         HttpServletRequest request, HttpServletResponse response,
                         ModelMap model) {
        RcAdmin rcadmin = UserUtil.getUser(request);
        String papers = rcadmin.getPapers();
        Pagination pagination = this.thesisservice.getPage(
                SimplePage.cpn(pageNo), Constants.PAGE_SIZE, teaname);
        model.addAttribute("pagination", pagination);
        Students u = studentsService.selectByName(rcadmin.getName());
        request.getSession().setAttribute("papers", papers);
        request.getSession().setAttribute("u", u);
        return "student/seatitle";
    }
    @ResponseBody
    @RequestMapping(value = "/selthesis.do",method = RequestMethod.POST)
    public Map seld(HttpServletRequest request,
                       HttpServletResponse response, ModelMap model, Thesis thesis) {
        Map map = new HashMap();
        Map modelMap = new HashMap(1);
        Date date = new Date();
        Time time = timeService.selectTime();
        RcAdmin rcadmin = UserUtil.getUser(request);
        System.out.println(rcadmin.getName());
        String username = rcadmin.getName();
        Students student = studentsService.selectByName(username);
        System.out.println(time.getStustarttime().getTime());
        System.out.println(time.getStuendtime().getTime());
        if (thesisservice.setflagByStuid(student.getStuid()) == 1) {
            System.out.println("多选 或重选");
            String mesg="多选 或重选!";
            modelMap.put("mesg", mesg);
            return modelMap;
        } else if (date.getTime() <= time.getStustarttime().getTime()) {
            return modelMap;
        } else if (date.getTime() >= time.getStuendtime().getTime()) {
            System.out.println("选题已结束！");
            String mesg="选题已结束!";
            modelMap.put("mesg", mesg);
            return modelMap;
        } else {
            System.out.println(date.getTime());
            thesis = thesisservice.getThesisByCid(thesis.getCid());
            Teachers teacher = teacherService.getTeacherByCTid(thesis.getTid());

            if (thesis.getCflag() == 1) {

                System.out.println("论文已经被选定");
                String mesg="论文已经被选定!";
                modelMap.put("mesg", mesg);
                return modelMap;
            } else if (thesis.getCflag() == 0) {
                if (teacher.getSsum() < time.getStunumber()) {
                    teacherService.updateSum(teacher);
                    thesis.setCflag(1);
                    thesis.setStuid(student.getStuid());
                    student.setTid(thesis.getTid());
                    studentsService.setTidByThesis(student);
                    thesisservice.setflag(thesis);
                    return modelMap;
                } else {
                    System.out.println("人数已满！");
                    String mesg="人数已满!";
                    modelMap.put("mesg", mesg);
                    return modelMap;

                }

            } else {

                return modelMap;
            }
        }
    }

    @RequestMapping("/nothesis.do")
    public String noth(HttpServletRequest request,
                       HttpServletResponse response, ModelMap model, Thesis thesis) {
        RcAdmin rcadmin = UserUtil.getUser(request);
        String username = rcadmin.getName();
        Students student = studentsService.selectByName(username);
        thesis = thesisservice.getthesisBySid(thesis.getStuid());
        Teachers teacher = teacherService.getTeacherByCTid(thesis.getTid());

        thesis.setCflag(0);
        thesis.setStuid(null);
        thesisservice.updateByPrimaryKey(thesis);

        teacherService.updatesubsum(teacher);
        student.setTid(null);
        studentsService.updateTid(student);

        return "redirect:v_list.do";
    }

    @RequestMapping("/file.do")
    public String file(HttpServletRequest request,
                       HttpServletResponse response, ModelMap model) {

        return "student/testfile";
    }
}
