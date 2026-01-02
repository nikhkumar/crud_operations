package com.example.crud_operations.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "notifications")
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID notificationId;
    
    @Column(nullable = false)
    private UUID tenantId;
    
    @Column(nullable = false)
    private String recipient;

	private String subject;

    @Column(columnDefinition = "TEXT")
    private String messageBody;

    @Enumerated(EnumType.STRING)
    private NotificationType type;

    private LocalDateTime createdAt = LocalDateTime.now();

    // Standard no-arg constructor required by JPA
    public NotificationEntity() {}

	public UUID getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(UUID notificationId) {
		this.notificationId = notificationId;
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

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public NotificationType getType() {
		return type;
	}

	public void setType(NotificationType type) {
		this.type = type;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public NotificationEntity(UUID notificationId, UUID tenantId, String recipient, String subject, String messageBody,
			NotificationType type, LocalDateTime createdAt) {
		super();
		this.notificationId = notificationId;
		this.tenantId = tenantId;
		this.recipient = recipient;
		this.subject = subject;
		this.messageBody = messageBody;
		this.type = type;
		this.createdAt = createdAt;
	}


    
    
}