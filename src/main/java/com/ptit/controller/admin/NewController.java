package com.ptit.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ptit.dto.NewDTO;
import com.ptit.service.ICategoryService;
import com.ptit.service.INewService;

@Controller(value = "newControlerOfAdmin")
public class NewController {

	@Autowired
	private INewService newService;

	@Autowired
	private ICategoryService categoryService;

	@GetMapping(value = "/admin-new/list")
	public ModelAndView listNew(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		ModelAndView mav = new ModelAndView("/admin/new/list");
		NewDTO model = new NewDTO();
		model.setPage(page);
		model.setLimit(limit);
		model.setTotalPage((int) Math.ceil((double) newService.getTotalItem() / limit));
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(newService.findAll(pageable));
		mav.addObject("model", model);
		return mav;
	}

	@GetMapping(value = "/admin-new/edit")
	public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id) {
		ModelAndView mav = new ModelAndView("/admin/new/edit");
		NewDTO model = new NewDTO();
		if (id != null) {
			model = newService.findOne(id);
		}
		mav.addObject("categories", categoryService.findAll());
		mav.addObject("model", model);
		return mav;
	}
}
