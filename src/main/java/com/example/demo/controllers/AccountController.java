package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Account;
import com.example.demo.entities.Transaction;
import com.example.demo.repositories.AccRepo;
import com.example.demo.repositories.TransactionRepo;






@RestController
public class AccountController {

	@Autowired
	AccRepo repo;
	@Autowired
	TransactionRepo trep;
	
	@PostMapping("/login")
	public boolean login(@ RequestBody Account a)
	{
		if(!(repo.existsById(a.getCid())))
			return false; 
		Optional<Account> opt=repo.findById(a.getCid());
		Account at=opt.get();
		if((at.getPassword())==a.getPassword())
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	
	@PostMapping("/employee")
	public String register(@ RequestBody Account a)
	{
		if(repo.existsById(a.getCid()))
			return "Account Record Already exist"; 
		
		repo.save(a);
		return "Successfully added " + a.getAccountno() +" Account";
	}
	
	
	@PutMapping("/changepwd/{cid}/{old_psswd}/{new_psswd}")
	public String changePassword(@PathVariable int cid,@PathVariable String old_psswd,@PathVariable String new_psswd)
	{
		if(!repo.existsById(cid))
		{
			return " Employee ID Don't exist";
		}
		Optional<Account> opt=repo.findById(cid);
		Account at=opt.get();
		if((at.getPassword())==old_psswd)
		{
			at.setPassword(new_psswd);
			repo.save(at);
			return " Password Updated ";
		}
		else
		{
			return " Old Password and New Password doesn't match ";
		}
		
	}
	
	static int traid=1;
	@GetMapping("/transfer")
	public String transfer(@RequestParam int amount,@RequestBody Transaction a)
	{
		if(!repo.existsByAccountno(a.getFrom_Acctno()))
		{
			return " From Account ID Doesn't exist";
		}
		if(!repo.existsByAccountno(a.getTo_Account()))
		{
			return " To Account ID Doesn't exist";
		}
		if(!repo.existsByIFSC(a.getIFSC()))
		{
			return " IFSC Doesn't exist";
		}
		
		List<Account> opt1=repo.findByAccountnoEquals(a.getFrom_Acctno());
		Account from=opt1.get(0);
		List<Account> opt2=repo.findByAccountnoEquals(a.getTo_Account());
		Account to=opt2.get(0);
		from.setBalance(from.getBalance() - amount);
		to.setBalance(to.getBalance() + amount);
		Transaction t1=new Transaction();
		t1.setFrom_Acctno(a.getFrom_Acctno());
		t1.setTo_Account(a.getTo_Account());
		t1.setTid(traid++);
		t1.setAmount(amount);
		t1.setIFSC(a.getIFSC());
		trep.save(t1);
		return "Amount deducted successfully";
		
	}
	
	@GetMapping("/accounts/below")
	public List<Account> findByBalGreaterThan(@RequestParam int amount )
	{
		return repo.findByBalanceLessThan(amount);
	}
			
	@GetMapping("/accounts/above")
	public List<Account> findByBalLesserThan(@RequestParam int amount )
	{
		return repo.findByBalanceGreaterThan(amount);
	}

}
