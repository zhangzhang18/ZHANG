package com.thesis.cms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thesis.cms.common.session.SessionProvider;
import com.thesis.cms.model.RcAdmin;
import com.thesis.cms.service.RcAdminService;
import com.thesis.cms.util.UserUtil;

/**
 * @author rc.wys
 * @date 2013-5-27 下午5:54:16
 * @DESC 管理员登陆成功控制类
 */
@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	
	@Autowired
	private RcAdminService rcAdminService;
	
	
	@RequestMapping("/index.do")
	public String index(HttpServletRequest request, ModelMap model) {
		RcAdmin user = UserUtil.getUser(request);
		// Integer userDeptId = user.getDeptId();
		// Integer dtlv = user.getDeptLevel();
		Integer role=rcAdminService.getRolebyName(user.getName());
		if(role==1){
			HttpSession s = request.getSession();
			model.addAttribute("user", user);
			return "index/index";
		}else if(role==2){
			HttpSession s = request.getSession();
			model.addAttribute("user", user);
			return "index/teaindex";
		}else if(role==3){
			HttpSession s = request.getSession();
			String pwd=user.getPassWord();
			if (pwd.equals("123456")) {
				return "redirect:../student/pwd.do";
			}
			model.addAttribute("user", user);
			return "index/studentindex";
		}else{
	
	
		HttpSession s = request.getSession();
		// s.setAttribute("userDeptId", userDeptId);
		// s.setAttribute("dtlv", dtlv);
		model.addAttribute("user", user);
       
		return "index/login";
		
		}
	}

	@RequestMapping("/default.do")
	public String defaultContent(HttpServletRequest request, ModelMap model) {
		return "index/default";
	}

	@RequestMapping("/list.do")
	public String list(HttpServletRequest request, ModelMap model) {
		return "index/list";
	}

	@RequestMapping("/TQ8MenuCenter.do")
	public String TQ8MenuCenter(HttpServletRequest request, ModelMap model) {
		return "TQ8MenuCenterTml";
	}

	@Autowired
	private SessionProvider session;
}
