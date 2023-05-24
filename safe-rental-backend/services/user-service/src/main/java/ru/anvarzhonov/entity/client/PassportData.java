package ru.anvarzhonov.entity.client;

import jakarta.persistence.*;
import lombok.*;
import ru.anvarzhonov.sbrf.base.ObjectId;

import java.time.LocalDate;

@Entity
@Table(name = "passport_data")
@Getter
@Setter
@RequiredArgsConstructor
@ToString(callSuper = true)
public class PassportData extends ObjectId {
    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @Column(name = "passport_series")
    private String passportSeries;
    @Column(name = "passport_number")
    private String passportNumber;
    @Column(name = "issue_department")
    private String issueDepartment;
    @Column(name = "issue_date")
    private LocalDate issueDate;
}