package com.example.crud_operations.service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.crud_operations.bean.NotificationRequestDTO;
import com.example.crud_operations.entity.NotificationEntity;
import com.example.crud_operations.repository.NotificationRepository;
import com.example.crud_operations.utils.EmailService;
import com.example.crud_operations.utils.NotificationMapper;
import com.example.crud_operations.utils.SMSService;

@Service
public class NotificationsService {

	@Autowired
	private NotificationRepository repository;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private SMSService smsService;
	
	
	public Page<NotificationEntity> getRecentNotifications(String email, int page, int size) {
		Pageable pageRequest = PageRequest.of(page, size);
		return repository.findByRecipientOrderByCreatedAtDesc(email, pageRequest);
	}
	
	

	//public NotificationEntity sendNotification(NotificationRequestDTO notification, MultipartFile attachmentFile) throws IOException {
	public NotificationEntity sendNotification(NotificationRequestDTO notification) throws IOException {

		if ("EMAIL".equalsIgnoreCase(notification.getNotificationType())) {
			//notification.setAttachment(attachmentFile.getBytes());
			emailService.sendEmail(notification);
		} else if ("SMS".equalsIgnoreCase(notification.getNotificationType())) {
			smsService.sendSMS(notification);
		}
		NotificationEntity entity = saveInDB(notification);
		
		return entity;
	}

	@Async
	private NotificationEntity saveInDB(NotificationRequestDTO notification) {
		
		NotificationEntity entity = NotificationMapper.toEntity(notification);
		return repository.save(entity);		
	}



	@Async
	private void sendEmail(NotificationRequestDTO bean) {
		System.out.println("Sending Email to: " + bean.getRecipient());
	}

	@Async
	private void sendSMS(NotificationRequestDTO bean) {
		System.out.println("Sending SMS to: " + bean.getRecipient());
	}

	public String getNotification(UUID id) {

		return null;
	}

	public String deleteNotification(UUID id) {

		return null;
	}



	public List<NotificationEntity> getAllNotification() {
		return repository.findAll();
	}

}
