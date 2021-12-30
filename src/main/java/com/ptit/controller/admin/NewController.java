package com.ptit.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ptit.dto.NewDTO;
import com.ptit.service.INewService;

@Controller(value = "newControlerOfAdmin")
public class NewController {

	@Autowired
	private INewService newService;

	@GetMapping(value = "/admin-new/list")
	public ModelAndView listNew(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		ModelAndView mav = new ModelAndView("/admin/new/list");
		NewDTO newDTO = new NewDTO();
		newDTO.setPage(page);
		newDTO.setLimit(limit);
		newDTO.setTotalPage((int) Math.ceil((double) newService.getTotalItem() / limit));
		Pageable pageable = new PageRequest(page - 1, limit);
		newDTO.setListResult(newService.findAll(pageable));
		mav.addObject("model", newDTO);
		return mav;
	}

	@GetMapping(value = "/admin-new/edit")
	public ModelAndView editNew() {
		ModelAndView mav = new ModelAndView("/admin/new/edit");
		return mav;
	}
}
