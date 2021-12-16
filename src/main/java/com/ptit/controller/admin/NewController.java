package com.ptit.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.ptit.entity.NewEntity;
import com.ptit.service.INewService;

@Controller(value = "newControlerOfAdmin")
public class NewController {

	@Autowired
	private INewService newService;

	@ModelAttribute("model")
	public List<NewEntity> findAll() {
		return newService.findAll();
	}

	@GetMapping(value = "/admin-new/list")
	public ModelAndView listNew() {
		ModelAndView mav = new ModelAndView("/admin/new/list");
		return mav;
	}
	
	@GetMapping(value = "/admin-new/edit")
	public ModelAndView editNew() {
		ModelAndView mav = new ModelAndView("/admin/new/edit");
		return mav;
	}
}
