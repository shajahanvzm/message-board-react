package com.sha.messageboardreact.controller;

import com.sha.messageboardreact.payloads.MessageDto;
import com.sha.messageboardreact.payloads.MessageResponse;
import com.sha.messageboardreact.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1.0/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public ResponseEntity<MessageDto> save(@Valid @RequestBody MessageDto messageDto){
        return new ResponseEntity<>(messageService.save(messageDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDto> update(@PathVariable int id, @Valid @RequestBody MessageDto messageDto){
        return new ResponseEntity<>(messageService.update(id, messageDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<MessageResponse> getAllMessages(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false)  int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false)  int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false)  String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "dsc", required = false)  String sortDir){
        return new ResponseEntity<>(messageService.getAllMessage(pageNo, pageSize,sortBy,sortDir),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDto> getById(@PathVariable int id){
        return new ResponseEntity<>(messageService.getMessageById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        messageService.deleteMessageBy(id);
        return new ResponseEntity<>("Message deleted successfully", HttpStatus.OK);
    }
}

