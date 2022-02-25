package com.sha.messageboardreact.service.impl;

import com.sha.messageboardreact.entity.Message;
import com.sha.messageboardreact.exception.ResourceNotFoundException;
import com.sha.messageboardreact.payloads.MessageDto;
import com.sha.messageboardreact.payloads.MessageResponse;
import com.sha.messageboardreact.repository.MessageRepository;
import com.sha.messageboardreact.service.MessageService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final ModelMapper mapper;

    public MessageServiceImpl(MessageRepository messageRepository, ModelMapper mapper) {
        this.messageRepository = messageRepository;
        this.mapper = mapper;
    }


    @Override
    public MessageDto save(MessageDto messageDto) {
        Message message = messageRepository.save(mapper.map(messageDto, Message.class));
        return mapper.map(message, MessageDto.class);
    }

    @Override
    public MessageDto update(int id, MessageDto messageDto) {
        Message message = messageRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Message","ID",id));
        message.setDate(messageDto.getDate());
        message.setMessage(messageDto.getMessage());
        message.setDate(messageDto.getDate());
        message = messageRepository.save(message);
        return mapper.map(message,MessageDto.class);
    }

    @Override
    public MessageResponse getAllMessage(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
        Page<Message> messages = messageRepository.findAll(pageable);

        List<MessageDto> content = messages.stream().map(message -> mapper.map(message, MessageDto.class))
                .collect(Collectors.toList());
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setContent(content);
        messageResponse.setPageNo(messages.getNumber());
        messageResponse.setPageSize(messages.getSize());
        messageResponse.setTotalElements(messages.getTotalElements());
        messageResponse.setTotalPages(messages.getTotalPages());
        messageResponse.setLast(messages.isLast());
        return messageResponse;
    }

    @Override
    public MessageDto getMessageById(int id) {
        Message message = messageRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Message","ID",id));
        return mapper.map(message,MessageDto.class);
    }

    @Override
    public void deleteMessageBy(int id) {
        Message message = messageRepository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("Message","ID",id));
        messageRepository.deleteById(id);

    }
}
