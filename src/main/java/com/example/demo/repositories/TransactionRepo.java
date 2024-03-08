package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Account;
import com.example.demo.entities.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer>{
	



}