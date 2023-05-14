package ru.anvarzhonov.sbrf.map.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import ru.anvarzhonov.sbrf.base.ObjectId;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "agreement")
public class Agreement extends ObjectId {

    @Column(name = "agreement_number", unique = true)
    private String agreementNumber;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private String endDate;

//    @OneToOne(orphanRemoval = true)
//    @JoinColumn(name = "safe_id")
//    private Safe safe;

}