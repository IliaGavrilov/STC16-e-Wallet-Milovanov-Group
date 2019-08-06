package com.serviceImpl;

import com.entity.BankBill;
import com.repository.BankBillRepository;
import com.service.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuickSortingServiceImpl implements SortingService {

    @Autowired
    private BankBillRepository bankBillRepository;

    @Override
    public List<BankBill> findAllWithSort(String sort, String field){

        Sort.Direction direction = Sort.Direction.valueOf(sort);
        return bankBillRepository.findAll(Sort.by(direction, field));
    }
}
