package com.qa.AccountApplication;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Transactional(SUPPORTS)
public class AccountRepoDB {
	
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	JSONUtil json; 
	
	@Transactional(SUPPORTS)
	private String getAllAccounts()
	{
		TypedQuery<Account> query = manager.createQuery("Select a FROM Account a", Account.class);
		Collection<Account> accounts = query.getResultList();
		return json.toJSON(accounts);
	}
	@Transactional(SUPPORTS)
	private Account findAnAccount(int id)
	{
		return manager.find(Account.class, id);
	}
	
	@Transactional(REQUIRED)
	private String createAnAccount(String account)
	{
		Account aAccount = json.fromJSON(account, Account.class);
		manager.persist(aAccount);
		return "{\"message\": \"account has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	private Account updateAnAccount(int id)
	{
		return null;
	}
	
	@Transactional(REQUIRED)
	private String deleteAnAccount(int id)
	{
		if (manager.contains(manager.find(Account.class, id))) {

			manager.remove(manager.find(Account.class, id));
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}

}
