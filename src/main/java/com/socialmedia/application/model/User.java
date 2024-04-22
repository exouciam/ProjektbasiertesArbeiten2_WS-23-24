package com.socialmedia.application.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.apache.commons.lang3.builder.HashCodeExclude;

import java.awt.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractEntity {

    @NotEmpty
    @Column(name = "username", nullable = false)
    private String username;

    @Email
    @NotEmpty
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    @Size(min = 8, max = 64, message = "Passwort muss 8 bis 64 Zeichen lang sein.")
    @EqualsAndHashCode.Include
    private String password;

    @Column(name = "profilePictureUrl")
    private String profilePictureUrl;

    @Column(name = "biography")
    private String biography;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private Status currentStatus;


    @Column(name = "addedFriends")
    @ManyToMany(mappedBy = "addedFriends")
    private Set<User> addedFriends;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.DETACH) //TODO: verstehen
    @JoinTable(name = "user_friendships", joinColumns = {
            @JoinColumn(name = "added_Friends", referencedColumnName = "addedFriends_id", nullable =   false)}, inverseJoinColumns = {
            @JoinColumn(name = "adding_user", referencedColumnName = "user_id", nullable = false)})
    private Set<User> addingUser;


 //TODO: Relationship zu anderen Entities
}
