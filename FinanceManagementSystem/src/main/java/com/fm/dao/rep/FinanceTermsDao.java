package com.fm.dao.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fm.model.FinanceTerms;

@Repository
public interface FinanceTermsDao extends JpaRepository<FinanceTerms, Integer> {

}
