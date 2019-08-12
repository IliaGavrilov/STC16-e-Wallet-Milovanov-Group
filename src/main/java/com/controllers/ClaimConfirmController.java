package com.controllers;

import com.entity.Claim;
import com.serviceImpl.ClaimConfirmServiceImpl;
import com.serviceImpl.ClaimServiceImpl;
import com.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping
public class ClaimConfirmController {

	@Autowired
	private ClaimConfirmServiceImpl claimConfirmServiceImpl;
	@Autowired
	private ProductServiceImpl productService;
	@Autowired
	private ClaimServiceImpl claimService;

	@GetMapping("/active-applications")
	public String showAll(Model model) {
		List<Claim> claimList = claimService.getAllByStatus(Claim.StatusEnum.In_Question);
		model.addAttribute("claims", claimList);
		return "active-applications";
	}

	@PostMapping(value = "/active-applications/statusChange")
	public String cancel(long claimId, String status, Model model) {
		Claim claim = claimService.getClaimById(claimId);
		Claim.StatusEnum statusClaim = Claim.StatusEnum.valueOf(status);
		if(statusClaim.equals(Claim.StatusEnum.Accept)){
			productService.addProduct(claim.getUser(), claim.getBankBill(), claim.getBankBill().getBank());
			claimService.removeClaimById(claimId);
		}else{
			claimConfirmServiceImpl.setStatus( claim, statusClaim );
		}

		return showAll(model);
	}
}
