package com.fm.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fm.dto.FinanceOptionDTO;
import com.fm.model.FinanceOption;
import com.fm.model.FinanceTerms;
import com.fm.service.impl.FinanceOptionServiceImpl;

@RestController
@RequestMapping("/loans-svc/api/v1")
public class FinanceOptionController {

	@Autowired
	private FinanceOptionServiceImpl financeOptionServiceImpl;

	@PostMapping("/finance-options/save")
	public FinanceOption added(@RequestBody FinanceOption financeOption) {
		return financeOptionServiceImpl.createFinanceOption(financeOption);
	}

	@PostMapping("/finance-options/save_terms")
	public FinanceTerms addedfinanceTerms(@RequestBody FinanceTerms financeTerms) {
		return financeOptionServiceImpl.createFinanceTerms(financeTerms);
	}

	@GetMapping("/getAll")
	public List<FinanceOption> getfinanceOptionDetails() {

		return financeOptionServiceImpl.getAllFinanceOption();
	}

	@GetMapping("/finance-options/{id}")
	public FinanceOption getFinanceOptionById(@PathVariable Integer id) {
		return financeOptionServiceImpl.getFinanceOptionById(id);
	}

	@GetMapping("/financeoptions/{financeOptionId}")
	public FinanceOptionDTO getfinanceOptionsWithDownPayment(@PathVariable Integer financeOptionId) {
		return financeOptionServiceImpl.getfinanceOptionsWithDownPaymentDetails(financeOptionId);

	}
	
	@GetMapping("/financeoptions/{financeOptionId}/FinanceTerms/{financeTermsId}")
	public FinanceOptionDTO getfinanceOptionsWithDownPayment(@PathVariable Integer financeOptionId,@PathVariable Integer financeTermsId) {
		return financeOptionServiceImpl.getfinanceOptionsWitFinanceTerms(financeOptionId, financeTermsId);

	}
}
