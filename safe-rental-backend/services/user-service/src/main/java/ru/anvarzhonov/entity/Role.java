package ru.anvarzhonov.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;
import ru.anvarzhonov.sbrf.base.ObjectId;

@Data
@Entity
@ToString(callSuper = true)
@Table(name = "roles")
public class Role extends ObjectId {
    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private RoleName name;
}
