package com.fm.dto;

import java.util.List;

import lombok.Data;

@Data
public class FinanceOptionDTO {

	private Integer id;
	private String name;
	private String startDate;
	private String endDate;
	private List<FinanceTermsDTO> financeTermsDTO;
	private List<RelateFinanceTerms> RelateFinanceTerms;

}
