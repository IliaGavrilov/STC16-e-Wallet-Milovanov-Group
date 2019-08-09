package com.service;

import com.entity.Claim;

public interface ClaimConfirmService {

	void acceptClaim(Claim claim);

	void resetClaim(Claim claim);
}
