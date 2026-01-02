package com.example.crud_operations.utils;

import com.example.crud_operations.bean.NotificationRequestDTO;
import com.example.crud_operations.entity.NotificationEntity;
import com.example.crud_operations.entity.NotificationType;

public class NotificationMapper {


	   public static NotificationEntity toEntity(NotificationRequestDTO dto) {
	        NotificationEntity entity = new NotificationEntity();
	      
	        entity.setTenantId(dto.getTenantId());
	        entity.setRecipient(dto.getRecipient());
	        entity.setSubject(dto.getSubject());
	        entity.setMessageBody(dto.getBody());
	        entity.setType(NotificationType.valueOf(dto.getNotificationType()));
	  
	        
	        return entity;
	    }
	}