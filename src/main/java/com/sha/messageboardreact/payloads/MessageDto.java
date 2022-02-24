package com.sha.messageboardreact.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MessageDto {

    private int id;
    private String email;
    private String message;
    private Date date;

    public MessageDto(String email, String message, Date date) {
        this.email = email;
        this.message = message;
        this.date = date;
    }
}
