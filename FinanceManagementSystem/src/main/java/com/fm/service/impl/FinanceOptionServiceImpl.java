package com.fm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fm.dao.rep.FinanceOptionDao;
import com.fm.dao.rep.FinanceTermsDao;
import com.fm.dto.FinanceOptionDTO;
import com.fm.dto.FinanceTermsDTO;
import com.fm.dto.RelateFinanceTerms;
import com.fm.model.FinanceOption;
import com.fm.model.FinanceTerms;
import com.fm.service.FinanceOptionServices;

@Service
public class FinanceOptionServiceImpl implements FinanceOptionServices {

	@Autowired
	private FinanceOptionDao financeOptionDao;
	@Autowired
	private FinanceTermsDao financeTermsDao;

	@Transactional
	@Override
	public FinanceOption createFinanceOption(FinanceOption financeOption) {
		return financeOptionDao.save(financeOption);
	}

	@Override
	public FinanceTerms createFinanceTerms(FinanceTerms financeTerms) {
		return financeTermsDao.save(financeTerms);
	}

	@Override
	public List<FinanceOption> getAllFinanceOption() {
		ArrayList<FinanceOption> financeOptionDetails = new ArrayList<FinanceOption>();
		financeOptionDao.findAll().forEach(financeOptionDetails::add);
		return financeOptionDetails;
	}

	@Override
	public FinanceOption getFinanceOptionById(Integer id) {
		return financeOptionDao.getOne(id);
	}

	@Override
	public FinanceOptionDTO getfinanceOptionsWithDownPaymentDetails(Integer financeOptionId) {

		FinanceOption financeOption = getFinanceOptionById(financeOptionId);
		List<FinanceTermsDTO> financeTermsDTOs = new ArrayList<FinanceTermsDTO>();

		FinanceOptionDTO financeOptionDTO = new FinanceOptionDTO();
		financeOptionIdValidatation(financeOption, financeTermsDTOs, financeOptionDTO);
		financeOptionDTO.setFinanceTermsDTO(financeTermsDTOs);
		return financeOptionDTO;
	}

	private void financeOptionIdValidatation(FinanceOption financeOption, List<FinanceTermsDTO> financeTermsDTOs,
			FinanceOptionDTO financeOptionDTO) {
		if (financeOption.getId() != null) {

			financeOptionDTO.setId(financeOption.getId());
			financeOptionDTO.setName(financeOption.getName());
			financeOptionDTO.setStartDate(financeOption.getStartDate());
			financeOptionDTO.setEndDate(financeOption.getEndDate());
			financeTermsValidate(financeOption, financeTermsDTOs);

		}
	}

	private void financeTermsValidate(FinanceOption financeOption, List<FinanceTermsDTO> financeTermsDTOs) {
		financeOption.getFinanceTerms().stream().forEach(f -> {
			FinanceTermsDTO termsDTO = new FinanceTermsDTO();
			termsDTO.setFTid(f.getFTid());
			termsDTO.setName(f.getName());
			financeTermsDTOs.add(termsDTO);
		});
	}

	@Override
	public FinanceOptionDTO getfinanceOptionsWitFinanceTerms(Integer financeOptionId, Integer FinanceTermsId) {
		FinanceOption financeOption = getFinanceOptionById(financeOptionId);
		FinanceOptionDTO financeOptionDTO = new FinanceOptionDTO();
		
		
		return financeOptionDTO;
		
		/*
		 * List<RelateFinanceTerms> financeTermsDTOs = new
		 * ArrayList<RelateFinanceTerms>();
		 * 
		 * FinanceOptionDTO financeOptionDTO = new FinanceOptionDTO();
		 * financeOptionIdValidatationById(financeOption, financeTermsDTOs,
		 * financeOptionDTO); financeOptionDTO.setRelateFinanceTerms(financeTermsDTOs);
		 */

	}

	/*
	 * private void financeOptionIdValidatationById(FinanceOption financeOption,
	 * List<RelateFinanceTerms> relateFinanceTerms, FinanceOptionDTO
	 * financeOptionDTO) { if(financeOption.getId()!=null) {
	 * 
	 * financeOptionDTO.setId(financeOption.getId());
	 * financeOptionDTO.setName(financeOption.getName());
	 * financeOptionDTO.setStartDate(financeOption.getStartDate());
	 * financeOptionDTO.setEndDate(financeOption.getEndDate());
	 * financeTermsValidateById(financeOption, relateFinanceTerms);
	 * 
	 * } }
	 * 
	 * private void financeTermsValidateById(FinanceOption financeOption, Integer
	 * FinanceTermsId) { financeOption.getFinanceTerms().stream().forEach(f ->{
	 * RelateFinanceTerms termsDTO = new RelateFinanceTerms();
	 * 
	 * termsDTO.setFTid(f.getFTid()); termsDTO.setName(f.getName());
	 * termsDTO.setAchDiscountPercentage(f.getAchDiscountPercentage());
	 * termsDTO.setDownPaymentPercentage(f.getDownPaymentPercentage());
	 * termsDTO.setEndDate(f.getEndDate()); termsDTO.setStartDate(f.getStartDate());
	 * termsDTO.setStatementInterestPercentage(f.getStatementInterestPercentage());
	 * });
	 * 
	 * 
	 * }
	 */

	@Override
	public FinanceTerms getFinanceTermsDetails(Integer FinanceTermsId) {

		return null;
	}
}
