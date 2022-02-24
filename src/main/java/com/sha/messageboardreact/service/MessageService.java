package com.sha.messageboardreact.service;

import com.sha.messageboardreact.payloads.MessageDto;
import com.sha.messageboardreact.payloads.MessageResponse;

import java.util.List;

public interface MessageService {

    public MessageDto save(MessageDto messageDto);
    public MessageDto update(int id, MessageDto messageDto);
    public MessageResponse getAllMessage(int pageNo, int pageSize, String sortBy, String sortDir);
    public MessageDto getMessageById(int id);
    public void deleteMessageBy(int id);

}
