package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Account;

@Repository
public interface AccRepo extends JpaRepository<Account, Integer>{

	List<Account> findByBalanceGreaterThan(int amount);

	List<Account> findByBalanceLessThan(int amount);

	List<Account> findByAccountnoEquals(int from_Acctno);

	boolean existsByAccountno(int from_Acctno);

	boolean existsByIFSC(String ifsc);
	



}
