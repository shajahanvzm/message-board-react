package com.sha.messageboardreact.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class MessageDto {

    private int id;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size(min =10, max=500, message = "Message must be between 10 and 500 characters" )
    private String message;
    @NotNull
    private Date date;

    public MessageDto(String email, String message, Date date) {
        this.email = email;
        this.message = message;
        this.date = date;
    }
}
