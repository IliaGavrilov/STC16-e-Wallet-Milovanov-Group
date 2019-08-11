package com.service;

import com.entity.Claim;

public interface ClaimConfirmService {

	void setStatus(Claim claim, Claim.StatusEnum status);
}
