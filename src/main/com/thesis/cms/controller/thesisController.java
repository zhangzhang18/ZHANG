package com.thesis.cms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.thesis.cms.common.page.Pagination;
import com.thesis.cms.common.page.SimplePage;
import com.thesis.cms.model.Thesis;
import com.thesis.cms.service.StudentsService;
import com.thesis.cms.service.TeacherService;
import com.thesis.cms.service.Thesisservice;
import com.thesis.cms.util.Constants;

@Controller
@RequestMapping("/thesis")
public class thesisController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private Thesisservice thesisservice;

    @Autowired
    private StudentsService studentsService;

    @RequestMapping("/v_list.do")
    public String all(Integer pageNo, String ctitle,
                      HttpServletRequest request, HttpServletResponse response,
                      ModelMap model) {
        Pagination pagination = this.thesisservice.getPagea(
                SimplePage.cpn(pageNo), Constants.PAGE_SIZE, ctitle);
        model.addAttribute("pagination", pagination);
        return "user/thesis";
    }

    @RequestMapping(value = "/sel.do", method = RequestMethod.POST)
    public ModelAndView sel(Integer id, HttpServletRequest request,
                            HttpServletResponse response, ModelMap model, String ctitle) {

        List<Thesis> thesis = thesisservice.selectByTitle(ctitle);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/thesis");
        mav.addObject("thesis", thesis);
        return mav;

    }

    @RequestMapping("/add.do")
    public String add(HttpServletRequest request, HttpServletResponse response,
                      ModelMap model) {
        return "user/addthesis";
    }

    @RequestMapping(value = "/addthesis.do", method = RequestMethod.POST)
    public String addl(Integer id, HttpServletRequest request,
                       HttpServletResponse response, ModelMap model, Thesis thesis) {
        thesis.setResearch(0);
        thesisservice.insert(thesis);
        return "redirect:v_list.do";

    }

    @RequestMapping("/update.do")
    public String up(HttpServletRequest request, HttpServletResponse response,
                     ModelMap model, Thesis thesis) {
        model.addAttribute("thesis", thesis);
        return "user/thesisupdata";
    }

    @RequestMapping("/delthesis.do")
    public String delthesis(HttpServletRequest request, HttpServletResponse response,
                            ModelMap model) {
        String id = request.getParameter("id");
        thesisservice.deleteByPrimaryKey(Integer.parseInt(id));
        return "redirect:v_list.do";
    }

    @RequestMapping("/check.do")
    public String check(HttpServletRequest request, HttpServletResponse response,
                        ModelMap model) {
        String id = request.getParameter("id");
        Thesis thesis = thesisservice.selectByPrimaryKey(Integer.parseInt(id));
        if (thesis.getResearch() == 1) {
            thesis.setResearch(0);
            thesisservice.updateCheckByid(thesis);
        }else {
            thesis.setResearch(1);
            thesisservice.updateCheckByid(thesis);
        }

        return "redirect:v_list.do";
    }

    @RequestMapping(value = "/thesupdate.do", method = RequestMethod.POST)
    public String upl(Integer id, HttpServletRequest request,
                      HttpServletResponse response, ModelMap model, Thesis thesis) {

        thesisservice.updateByPrimaryKey(thesis);
        return "redirect:v_list.do";

    }

}
