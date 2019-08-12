package com.controllers;

import com.entity.Claim;
import com.serviceImpl.ClaimConfirmServiceImpl;
import com.serviceImpl.ClaimServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class ClaimConfirmController {

	@Autowired
	private ClaimConfirmServiceImpl claimConfirmServiceImpl;

	@Autowired
	private ClaimServiceImpl claimService;

	@GetMapping("/active-applications")
	public String showAll(Model model) {
		List<Claim> claimList = claimService.getAllByStatus(Claim.StatusEnum.In_Question);
		model.addAttribute("claims", claimList);
		return "active-applications";
	}

	@PostMapping(value = "/active-applications/statusChange")
	public ModelAndView cancel(long claimId, String status) {
		Claim claim = claimService.getClaimById(claimId);
		claimConfirmServiceImpl.setStatus( claim, Claim.StatusEnum.valueOf(status) );
		return new ModelAndView("/active-applications");
	}
}
