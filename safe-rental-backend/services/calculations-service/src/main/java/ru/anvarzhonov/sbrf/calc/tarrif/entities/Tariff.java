package ru.anvarzhonov.sbrf.calc.tarrif.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.anvarzhonov.sbrf.base.ObjectId;

import java.math.BigDecimal;

@Entity
@Table(name  = "tariffs")
@Data
@EqualsAndHashCode(callSuper = true)
public class Tariff extends ObjectId {

    /**
     * Срок тарифа от
     */
    Integer termFrom;
    /**
     * Срок тарифа до
     */
    Integer termTo;

    /**
     * Цена за период
     */
    BigDecimal price;
}
