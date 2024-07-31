package com.socialmedia.application.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "chatRooms")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatRooms{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "chatRoom_Id")

    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "id")
    private Users users;
}
