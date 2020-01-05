package com.fm.service;

import java.util.List;

import com.fm.dto.FinanceOptionDTO;
import com.fm.model.FinanceOption;
import com.fm.model.FinanceTerms;

public interface FinanceOptionServices {
	

	public FinanceOption createFinanceOption(FinanceOption financeOption);
	
	public List<FinanceOption> getAllFinanceOption();
	
	public FinanceOption getFinanceOptionById(Integer id);

	FinanceTerms createFinanceTerms(FinanceTerms financeTerms);
	FinanceTerms getFinanceTermsDetails(Integer FinanceTermsId);
	
	public FinanceOptionDTO getfinanceOptionsWithDownPaymentDetails(Integer financeOptionId);
	public FinanceOptionDTO getfinanceOptionsWitFinanceTerms(Integer financeOptionId,Integer FinanceTermsId);
	

}
