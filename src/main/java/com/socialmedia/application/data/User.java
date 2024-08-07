package com.socialmedia.application.data;

import com.socialmedia.application.data.embeddable.UserChatKey;
import com.socialmedia.application.data.enums.OnlineStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Length(min = 8, max = 20)
    @NotNull
    @Column(name = "username", unique = true)
    private String username;

    @Email
    @NotEmpty
    @NotNull
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    @NotNull
    @Size(min = 8, max = 64, message = "Passwort muss 8 bis 64 Zeichen lang sein.")
    @EqualsAndHashCode.Include
    private String password;

    @Column(name = "profilePictureUrl")
    private String profilePictureUrl;

    @Column(name = "biography")
    private String biography;

    @Column(name = "phoneNumber", unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private OnlineStatus onlineStatus;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ChatRoom chatRoom;

    @OneToMany(mappedBy = "user")
    private Set<UserChat> chats;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fromUser")
    private Set<Message> messages = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "areFriends",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "friendUsername"))
    private Set<User> friends = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Post> posts = new HashSet<>();

}
