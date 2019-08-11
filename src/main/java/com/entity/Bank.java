package com.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "bank")
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String description;

	/**
	 * Constructors
	 */
	public Bank() {
	}

	public Bank(String name, String description) {
		this.name = name;
		this.description = description;
	}

	/**
	 * setters & getters
	 *
	 */
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToMany(cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE
	})
	@JoinTable(name = "bank_users",
			joinColumns = @JoinColumn(name = "bank_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	@JsonManagedReference
	private Set<User> users = new HashSet<>();


	public void addUser(User user) {
		users.add( user );
		user.getBanks().add( this );
	}

	public void removeUser(User user) {
		users.remove( user );
		user.getBanks().remove( this );
	}

	@OneToMany(mappedBy = "bank",
			cascade = CascadeType.MERGE,
			orphanRemoval = true)
	private List<BankBill> bankBills;

	public void addBankBill(BankBill bankBill) {
		bankBills.add( bankBill );
		bankBill.setBank( this );
	}

	public void removeBankBill(BankBill bankBill) {
		bankBills.remove( bankBill );
	}

	public List<BankBill> getBankBills() {
		return bankBills;
	}

	public void setBankBills(List<BankBill> bankBills) {
		this.bankBills = bankBills;
	}

	@OneToMany(mappedBy = "bank_id",
			cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<Accounts> accounts;

	public List<Accounts> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Accounts> accounts) {
		this.accounts = accounts;
	}
}
