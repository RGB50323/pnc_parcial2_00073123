package uca.ncapas.parcial2_pnc.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uca.ncapas.parcial2_pnc.common.enums.Type;

@Entity
@Table(name = "Magic_Article")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MagicArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    private MagicProvider magicProvider;

}
