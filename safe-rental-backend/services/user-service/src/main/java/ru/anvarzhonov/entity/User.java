package ru.anvarzhonov.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.anvarzhonov.sbrf.base.ObjectId;

import java.util.Set;

@Entity
@Data
@ToString(callSuper = true)
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends ObjectId {

    private String username;
    private String password;
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
