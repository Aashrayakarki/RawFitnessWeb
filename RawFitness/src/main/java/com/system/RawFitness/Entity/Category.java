package com.system.RawFitness.Entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    @Id
    @SequenceGenerator(name = "pms_cat_seq_gen", sequenceName = "pms_cat_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "pms_cat_seq_gen", strategy = GenerationType.SEQUENCE)

    private Integer id;
    private String category;


}
