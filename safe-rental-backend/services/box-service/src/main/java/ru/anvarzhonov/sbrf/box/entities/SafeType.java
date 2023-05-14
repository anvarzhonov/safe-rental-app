package ru.anvarzhonov.sbrf.box.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.anvarzhonov.sbrf.base.ObjectId;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "safe_type")
public class SafeType extends ObjectId {
    @Enumerated(EnumType.STRING)
    @Column(name = "size")
    private Size size;

    @Column(name = "width")
    private Integer width;

    @Column(name = "height")
    private Integer height;

    @Column(name = "deep")
    private Integer deep;

    @Column(name = "description")
    private String description;

    private BigDecimal priceOfDay;

    public enum Size {
        XS,
        S,
        L,
        XL
    }
}