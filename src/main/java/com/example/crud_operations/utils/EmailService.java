package com.example.crud_operations.utils;
import org.springframework.stereotype.Service;

import com.example.crud_operations.bean.NotificationRequestDTO;

@Service
public class EmailService {

	public void sendEmail(NotificationRequestDTO notification) {
		System.out.println("Send EMAIL using SMTP");
		
	}

}
