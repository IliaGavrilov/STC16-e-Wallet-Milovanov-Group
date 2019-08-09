package com.controllers;

import com.entity.Claim;
import com.serviceImpl.ClaimConfirmServiceImpl;
import com.serviceImpl.ClaimServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class ClaimConfirmController {

	private final ClaimConfirmServiceImpl claimConfirmServiceImpl;

	private final ClaimServiceImpl claimService;

	public ClaimConfirmController(ClaimConfirmServiceImpl claimConfirmServiceImpl, ClaimServiceImpl claimService) {
		this.claimConfirmServiceImpl = claimConfirmServiceImpl;
		this.claimService = claimService;
	}

	@RequestMapping("/active-applications")
	public String index(Model model){

		return "active-applications";
	}

//	@RequestMapping(value="/active-applications", method = RequestMethod.GET)
//	public ModelAndView addService() {
//		Claim claim = new Claim(  );
//
//		ModelAndView modelAndView = new ModelAndView(  );
//		modelAndView.addObject( "claim",claim );
//		modelAndView.addObject( "action", "save" );
//		modelAndView.addObject( "formAction", "/bankservicecreate" );
//		modelAndView.setViewName( "bankservicecreate" );
//		return modelAndView;
//	}

	@GetMapping("/active-applications")
	public String showAll(Model model) {
		Claim claim = new Claim(  );
		model.addAttribute( "claim", claim );
		List<Claim> claimList = claimService.findAll();
		model.addAttribute("claims", claimList);
		return "active-applications";
	}

	@RequestMapping(value = "/statusChange", method = RequestMethod.POST, params = "action=apply")
	public ModelAndView apply(@ModelAttribute Claim claim) {
		claimConfirmServiceImpl.acceptClaim( claim );
		return new ModelAndView("/active-applications");
	}

	@RequestMapping(value = "/statusChange", method = RequestMethod.POST, params = "action=cancel")
	public ModelAndView cancel(@ModelAttribute Claim claim) {
		claimConfirmServiceImpl.resetClaim( claim );
		return new ModelAndView("/active-applications");
	}
}
