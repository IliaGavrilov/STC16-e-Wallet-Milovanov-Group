package com.service;

import com.entity.BankBill;

import java.util.List;

public interface SortingService {
    List<BankBill> findAllWithSort(String sort, String field);
}
