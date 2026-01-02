package com.example.crud_operations.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud_operations.entity.NotificationEntity;
import com.example.crud_operations.entity.NotificationType;
@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity, UUID> {

    // Derived Query: Finds notifications for a specific recipient
    List<NotificationEntity> findByRecipient(String recipient);

    // Pagination Support: Fetches notifications for a user in pages
    // Useful for "Notification centre" where users scroll through history
    Page<NotificationEntity> findByRecipientOrderByCreatedAtDesc(String recipient, Pageable pageable);

    // Derived Query: Finds notifications by type (e.g., all SMS)
    List<NotificationEntity> findByType(NotificationType type);
}