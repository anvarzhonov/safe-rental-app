package ru.anvarzhonov.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import ru.anvarzhonov.sbrf.base.ObjectId;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "agreement")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Agreement extends ObjectId {
    @Column(name = "agreement_number", unique = true)
    private String agreementNumber;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Basic
    private Long safeId;
    @Basic
    private String username;
}