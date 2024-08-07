package com.socialmedia.application.data.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Embeddable
public class UserChatKey implements Serializable {

    @Column(name = "username")
    private String username;

    @Column(name = "chat_id")
    private UUID chatId;
}
