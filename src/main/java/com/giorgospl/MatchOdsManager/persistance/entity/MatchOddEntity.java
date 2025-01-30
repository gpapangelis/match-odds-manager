package com.giorgospl.MatchOdsManager.persistance.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "odd")
public class MatchOddEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String oddId;

    @Column(length = 100)
    private String specifier;

    @Column(nullable = false)
    private BigDecimal odd;

    @CreationTimestamp
    @Column
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    @Column
    private LocalDateTime dateUpdated;

    @ManyToOne
    @JoinColumn(name = "match_id")
    @JsonIgnore
    private MatchEntity match;

}
