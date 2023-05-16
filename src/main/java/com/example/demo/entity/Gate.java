package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Entity
@Table(name = "gate")
public class Gate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gate_id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "terminal_id", nullable = false)
    private Terminal terminalId;

    @Column(name = "num", nullable = false)
    private int num;
}
