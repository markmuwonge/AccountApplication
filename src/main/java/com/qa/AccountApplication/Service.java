package com.qa.AccountApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Service {
	
	Scanner scanner = new Scanner(System.in);
	ArrayList<Account> accounts = new ArrayList<>();
	HashMap<Integer, Account> map = new HashMap<Integer, Account>();
	
	String firstName = "";
	String lastName = "";
	int accountNumber = 1;
	
	public Service()
	{
		startService();
	}
	
	private void startService()
	{
		
	}
	
	private void addAccount()
	{
				
		accounts.add(new Account());
		accounts.get(accounts.size() -1).setFirstName(firstName);
		accounts.get(accounts.size() -1).setLastName(lastName);
		accounts.get(accounts.size() -1).setAccountNumber(accountNumber);
		
		map.put(accounts.get(accounts.size() -1).getAccountNumber(), accounts.get(accounts.size() -1));
		
		accountNumber++;
		
		startService();
	}
	
	private void retrieveAccounts()
	{
		for (Entry<Integer, Account> key : map.entrySet()) {	
			
			System.out.print(key.getValue().getFirstName());
			System.out.print(" ");
			System.out.print(key.getValue().getLastName());
			System.out.print(" ");
			System.out.print(key.getValue().getAccountNumber());
			System.out.println();
		}
	}

}
