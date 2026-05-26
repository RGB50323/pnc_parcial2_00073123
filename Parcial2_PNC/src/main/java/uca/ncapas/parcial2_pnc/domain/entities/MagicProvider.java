package uca.ncapas.parcial2_pnc.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uca.ncapas.parcial2_pnc.common.enums.Type;

@Entity
@Table(name = "Magic_Provider")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MagicProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;
}
