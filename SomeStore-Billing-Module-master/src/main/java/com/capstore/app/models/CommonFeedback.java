package com.capstore.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "common_feedback")
public class CommonFeedback {

	@Id
	@GeneratedValue
	@Column(name = "feedback_id")
	private int feedbackId;  //(Primary Key)
	@Column(name = "feedback_subject")
    private String feedbackSubject;
	@Column(name = "feedback_message")
    private String feedbackMessage;
	@Column(name="product_id")
	private int productId;
	@Column(name="user_id")
	private int userId;
	@Column(name="request_flag")     
	private boolean requestFlag;		//customer sets 1  when sending fb
	@Column(name="response_flag")
	private boolean responseFlag;		//merchnat sets 1 when responding fb
	@Column(name="request_approved")	
	private boolean requestApproved;	//admin sets 1 when approved and reday to send merchnat
	@Column(name="response_approved")
	private boolean responseApproved;   //admin sets 1 whne approved and ready to send to customer
	@Column(name="responseMessage")
	private String responseMessage;
	
   
	public CommonFeedback(int feedbackId, String feedbackSubject, String feedbackMessage, int productId, int userId,
			boolean requestApproved, boolean responseApproved, String responseMessage) {
		super();
		this.feedbackId = feedbackId;
		this.feedbackSubject = feedbackSubject;
		this.feedbackMessage = feedbackMessage;
		this.productId = productId;
		this.userId = userId;
		this.requestApproved = requestApproved;
		this.responseApproved = responseApproved;
		this.responseMessage = responseMessage;
	}
	//private int feedbackForUserId;  //(Foreign Key)
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getFeedbackSubject() {
		return feedbackSubject;
	}
	public void setFeedbackSubject(String feedbackSubject) {
		this.feedbackSubject = feedbackSubject;
	}
	public String getFeedbackMessage() {
		return feedbackMessage;
	}
	public void setFeedbackMessage(String feedbackMessage) {
		this.feedbackMessage = feedbackMessage;
	}
	
	public CommonFeedback() {
	}
}
