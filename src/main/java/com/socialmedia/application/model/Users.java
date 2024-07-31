package com.socialmedia.application.model;

import com.socialmedia.application.model.enums.UserStatus;
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
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @Length(min = 8, max = 20)
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Email
    @NotEmpty
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
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
    private UserStatus currentUserStatus;

    @ManyToMany
    @JoinTable(
            name = "isFriendsWith",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "friendUsername")
    )
    private Set<Users> friends = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private Set<Comments> comments = new HashSet<>();

    @OneToOne(mappedBy = "users")
    private ChatRooms chatRooms;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private Set<Posts> posts = new HashSet<>();

}
