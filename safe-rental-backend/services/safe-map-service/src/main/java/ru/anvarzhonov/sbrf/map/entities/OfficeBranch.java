package ru.anvarzhonov.sbrf.map.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.anvarzhonov.sbrf.base.ObjectId;

@Entity
@Table(name = "Officebranch")
@Getter
@Setter
@ToString
public class OfficeBranch extends ObjectId {

    @Column(name = "office_number", unique = true)
    private Integer officeNumber;
    private String address;

    private String phoneNumber;

    @Column(nullable = false, name = "latitude_coordinate")
    private Float latitudeCoordinate;
    @Column(name = "longitude_coordinate")
    private Float longitudeCoordinate;
}
