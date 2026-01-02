package com.example.crud_operations.entity;

public enum NotificationType {
	EMAIL("SMTP", 1), SMS("Twilio", 2), WEBPUSH("Firebase", 0),MOBILEPUSH("Firebase", 0), SLACK("Webhook", 3);

	private final String provider;
	private final int priority;

	NotificationType(String provider, int priority) {
		this.provider = provider;
		this.priority = priority;
	}

	public String getProvider() {
		return provider;
	}

	public int getPriority() {
		return priority;
	}
}