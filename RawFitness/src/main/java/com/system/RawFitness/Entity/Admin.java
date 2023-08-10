package com.system.RawFitness.Entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pricing")
public class Admin  {
    @Id
    @SequenceGenerator(name = "pms_pricing_seq_gen", sequenceName = "pms_pricing_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "pms_pricing_seq_gen", strategy = GenerationType.SEQUENCE)

    private Integer id;
    private String duration;
    private Integer price;




}
