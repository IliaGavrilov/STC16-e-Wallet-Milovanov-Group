package com.serviceImpl;

import com.entity.Claim;
import com.repository.ClaimRepository;
import com.service.ClaimConfirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "claimConfirmService")
public class ClaimConfirmServiceImpl implements ClaimConfirmService {

	@Autowired
	@Qualifier("claimRepository")
	private ClaimRepository claimRepository;

	public void acceptClaim(Claim claim) {
		claimRepository.findClaimById( claim.getId() ).setStatus( Claim.StatusEnum.Accept );
	}

	public void resetClaim(Claim claim) {
		claimRepository.findClaimById( claim.getId() ).setStatus( Claim.StatusEnum.Negative );
	}

	public void setStatus(Claim claim, Claim.StatusEnum status){
		claim.setStatus(status);
		claimRepository.save(claim);
	}

}
