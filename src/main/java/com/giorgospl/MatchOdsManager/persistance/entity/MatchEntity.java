package com.giorgospl.MatchOdsManager.persistance.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "match")
public class MatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String matchId;

    @Column(length = 100)
    private String description;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime time;

    @Column(nullable = false, length = 100)
    private String firstTeam;

    @Column(nullable = false, length = 100)
    private String secondTeam;

    @Column(nullable = false)
    private int sport;

    @CreationTimestamp
    @Column
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    @Column
    private LocalDateTime dateUpdated;

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MatchOddEntity> odds;

}
