package com.fm.dao.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fm.model.FinanceOption;


@Repository
public interface FinanceOptionDao extends JpaRepository<FinanceOption,Integer>{

}
