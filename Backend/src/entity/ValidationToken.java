package com.example.main.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

@Entity(name="Validation_token")
public class ValidationToken {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="token_id")
	private long tokenId;
	
	@Column(name="token_value")
	private String tokenValue;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@OneToOne(targetEntity= CustomerDetails.class, fetch=FetchType.EAGER)
	@JoinColumn(nullable = false, name="user_id")
	private User user;
	
	public ValidationToken(User user) {
		this.user= user;
		createdDate= new Date();
		tokenValue= UUID.randomUUID().toString();
	}

	public long getTokenId() {
		return tokenId;
	}

	public void setTokenId(long tokenId) {
		this.tokenId = tokenId;
	}

	public String getTokenValue() {
		return tokenValue;
	}

	public void setTokenValue(String tokenValue) {
		this.tokenValue = tokenValue;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ValidationToken [tokenId=" + tokenId + ", tokenValue=" + tokenValue + ", createdDate=" + createdDate
				+ ", user=" + user + "]";
	}

	public ValidationToken() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
