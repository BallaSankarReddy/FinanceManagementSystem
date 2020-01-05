package com.fm.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class RelateFinanceTerms {

	private Integer fTid;
	private String name;
	private String startDate;
	private String endDate;

	private BigDecimal downPaymentPercentage;
	private BigDecimal statementInterestPercentage;
	private BigDecimal achDiscountPercentage;

}
