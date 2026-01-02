package com.example.crud_operations.bean;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Component;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Component
public class NotificationRequestDTO {

	@Pattern(regexp = "^(EMAIL|SMS|WEBPUSH|MOBILEPUSH)$", message = "Type must be EMAIL, SMS, WEBPUSH or MOBILEPUSH")
	private String notificationType; // e.g., "EMAIL", "SMS", "WEBPUSH", "MOBILEPUSH"
	
	private UUID tenantId;

	@NotBlank(message = "Recipient is mandatory")
	private String recipient;
	
	@Size(min = 5, max = 100, message = "Subject must be between 5 and 100 characters")
	private String subject;
	
	@NotEmpty(message = "Message body cannot be empty")
	@Size(max = 2000, message = "Message body is too long")
	private String body;
	
	private Date createdAt;
	
	private UUID notificationId;
	
	@Lob
	private byte[] attachment;				//for attachment in less size use byte array
	private String attachmentLink;			//for higher size attachment keep it on S3/cloud storage and get link

	public NotificationRequestDTO() {
	}

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public UUID getTenantId() {
		return tenantId;
	}

	public void setTenantId(UUID tenantId) {
		this.tenantId = tenantId;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public UUID getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(UUID notificationId) {
		this.notificationId = notificationId;
	}

	public byte[] getAttachment() {
		return attachment;
	}

	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}

	public String getAttachmentLink() {
		return attachmentLink;
	}

	public void setAttachmentLink(String attachmentLink) {
		this.attachmentLink = attachmentLink;
	}




}
