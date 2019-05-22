package com.qa.AccountApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.google.gson.Gson;

public class Service {
	
//	Scanner scanner = new Scanner(System.in);
	ArrayList<Account> accounts = new ArrayList<>();
	HashMap<Integer, Account> map = new HashMap<Integer, Account>();
//	
	Gson gson = new Gson(); 
//	
//	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("primary");
//	EntityManager entitymanager = emfactory.createEntityManager( );
//	
//	Account account = new Account();
//	
	String firstName = "Mark";
	String lastName = "Muwonge";
	int accountNumber = 1;
	
	public Service()
	{
////		startService();
////		startService();
//		addAccount();
////		mapToJSON();
//	
//		populateAccountTable();
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
	
	private void mapToJSON()
	{	
		String json = gson.toJson(map);
		System.out.println(json);
	}
	
	public long numberOfAccountsByFirstName(String name)
	{
		long count = accounts.stream().filter(x -> x.getFirstName().equalsIgnoreCase(name)).count();
		
		return count;
	}
	
//	private void populateAccountTable()
//	{
//		account.setFirstName("John");
//		account.setFirstName("Doe");
//		account.setAccountNumber(1234);
//		
//	    entitymanager.persist(account);
//	    entitymanager.getTransaction().commit();
//	    
//	    
//	    entitymanager.close();
//	    emfactory.close();
//	    
//	    
//		
//	}

}
