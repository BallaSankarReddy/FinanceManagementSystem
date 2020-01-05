package com.fm.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fm.model.FinanceOption;
import com.fm.service.impl.FinanceOptionServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TestController {

	private FinanceOptionServiceImpl financeOptionServiceImpl;
	
	@PostMapping("/save")
	public FinanceOption saveData(@RequestBody FinanceOption financeOption) {
		return financeOptionServiceImpl.createFinanceOption(financeOption);
	}

}
