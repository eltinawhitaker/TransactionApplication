package edu.dcccd.trans.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.ofLocalizedTime;
import static java.time.format.FormatStyle.MEDIUM;

@Data
@Entity
@Table(name = "TRANSACTION")

public class Transaction {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String time;
        @NotNull
        @NotEmpty
        private String day;
        @NotNull
        @NotEmpty
        private String description;
        @NotNull
        @Column(precision = 7, scale = 2)
        private BigDecimal amount;
        @NotNull
        private String type;

     public Transaction() {
        this.time = currentTime();
    }

    public Transaction(Long id, String type, String day, BigDecimal amount, String description)
    {
        this.time = currentTime();
        this.id = id;
        this.day = day;
        this.description = description;
        this.amount = amount;
        this.type = type;
    }

    private static String currentTime ()
    {
        return LocalDateTime.now().format(ofLocalizedTime(MEDIUM));
    }

}