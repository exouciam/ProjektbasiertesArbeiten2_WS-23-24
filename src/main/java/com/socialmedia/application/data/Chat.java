package com.socialmedia.application.data;

import com.socialmedia.application.data.embeddable.UserChatKey;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "chat")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "chat_id")
    private UUID id;

    @Transient
    private LocalTime dateTimeFromLastMessage;

    @ManyToMany(mappedBy = "chats")
    private Set<ChatRoom> chatRooms = new HashSet<>();

    @OneToMany(mappedBy = "chat")
    private Set<UserChat> users;


    @ManyToMany
    @JoinTable(
            name = "chatHasMessages",
            joinColumns = @JoinColumn(name = "chat_id"),
            inverseJoinColumns = @JoinColumn(name = "message_id"))
    private Set<Message> messages = new HashSet<>();




}

