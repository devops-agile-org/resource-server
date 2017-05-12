package com.accenture.banking.model;
// Generated 11-may-2017 15:04:59 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Account generated by hbm2java
 */
@Entity
@Table(name = "account", catalog = "banking", uniqueConstraints = @UniqueConstraint(columnNames = "iban"))
public class Account implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	private Office office;
	private String iban;
	private Date createdDatetime;
	private Date deletedDatetime;
	private long balance;
	private Set<Transaction> transactions = new HashSet<Transaction>(0);
	private Set<AccountClient> accountClients = new HashSet<AccountClient>(0);

	public Account() {
	}

	public Account(Office office, String iban, Date createdDatetime, long balance) {
		this.office = office;
		this.iban = iban;
		this.createdDatetime = createdDatetime;
		this.balance = balance;
	}

	public Account(Office office, String iban, Date createdDatetime, Date deletedDatetime, long balance,
			Set<Transaction> transactions, Set<AccountClient> accountClients) {
		this.office = office;
		this.iban = iban;
		this.createdDatetime = createdDatetime;
		this.deletedDatetime = deletedDatetime;
		this.balance = balance;
		this.transactions = transactions;
		this.accountClients = accountClients;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "office_id", nullable = false)
	public Office getOffice() {
		return this.office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	@Column(name = "iban", unique = true, nullable = false)
	public String getIban() {
		return this.iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_datetime", nullable = false, length = 19)
	public Date getCreatedDatetime() {
		return this.createdDatetime;
	}

	public void setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "deleted_datetime", length = 19)
	public Date getDeletedDatetime() {
		return this.deletedDatetime;
	}

	public void setDeletedDatetime(Date deletedDatetime) {
		this.deletedDatetime = deletedDatetime;
	}

	@Column(name = "balance", nullable = false)
	public long getBalance() {
		return this.balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	public Set<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	public Set<AccountClient> getAccountClients() {
		return this.accountClients;
	}

	public void setAccountClients(Set<AccountClient> accountClients) {
		this.accountClients = accountClients;
	}

}
