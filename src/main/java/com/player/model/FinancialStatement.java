//package com.player.model;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.*;
//
//import javax.persistence.*;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
//@Entity
//public class FinancialStatement {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    private String requiredAmount;
//    private  double totalAmount;
//    private double paidAmount;
//    private double outstandingAmount;
//    private double seasonRequiredAmount;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "player_id", nullable = false)
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private Player player;
//}
