package com.socialmedia.application.data;

import com.socialmedia.application.data.embeddable.UserChatKey;
import jakarta.persistence.*;

@Entity
public class UserChat {

    @EmbeddedId
    private UserChatKey userChatKey;

    @ManyToOne
    @MapsId("username")
    @JoinColumn(name = "username")
    private User user;

    @ManyToOne
    @MapsId("chatId")
    @JoinColumn(name = "chat_id")
    private Chat chat;

    private String toUser;
}
