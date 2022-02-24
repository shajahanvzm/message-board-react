package com.sha.messageboardreact.repository;

import com.sha.messageboardreact.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
