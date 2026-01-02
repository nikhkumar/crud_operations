package com.example.crud_operations.utils;

import org.springframework.stereotype.Service;

import com.example.crud_operations.bean.NotificationRequestDTO;

@Service
public class SMSService {

	public void sendSMS(NotificationRequestDTO notification) {
		System.out.println("Send SMS using Twilio");
		
	}

}
