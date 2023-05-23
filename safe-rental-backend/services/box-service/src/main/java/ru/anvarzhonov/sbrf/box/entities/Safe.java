package ru.anvarzhonov.sbrf.box.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.anvarzhonov.sbrf.base.ObjectId;
import ru.anvarzhonov.sbrf.box.dto.SafeStatus;

@Entity
@Table(name = "safes")
@Getter
@Setter
@ToString
public class Safe extends ObjectId {
    @ManyToOne(optional = false)
    @JoinColumn(name = "safe_type_id", nullable = false)
    private SafeType safeType;

    @Column(name = "office_id")
    private Long officeId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private SafeStatus status;
}
