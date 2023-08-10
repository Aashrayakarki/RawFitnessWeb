package com.system.RawFitness.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "membership")
public class Membership {
    @Id
    @SequenceGenerator(name = "pms_member_seq_gen", sequenceName = "pms_member_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "pms_member_seq_gen", strategy = GenerationType.SEQUENCE)


    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_categoryId"))
    private Category category_id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_userId"))
    private SignUp user_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_priceId"))
    private Admin price_id;


}
