package com.fm.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@NoArgsConstructor
public class FinanceTerms {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer fTid;
	private String name;
	private String startDate;
	private String endDate;

	private BigDecimal downPaymentPercentage;
	private BigDecimal statementInterestPercentage;
	private BigDecimal achDiscountPercentage;
	@ManyToOne
	private FinanceOption financeOption;

}
