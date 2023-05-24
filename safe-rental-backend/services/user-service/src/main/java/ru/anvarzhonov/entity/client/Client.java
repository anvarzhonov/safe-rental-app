package ru.anvarzhonov.entity.client;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.anvarzhonov.entity.User;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client {
    @Id
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id") // same name as @Id Column
    private User user;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "birthday")
    private LocalDate birthday;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "client")
    private PassportData passportData;
}