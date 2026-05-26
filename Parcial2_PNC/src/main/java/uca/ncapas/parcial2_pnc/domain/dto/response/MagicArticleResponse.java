package uca.ncapas.parcial2_pnc.domain.dto.response;

import lombok.Builder;
import lombok.Data;
import uca.ncapas.parcial2_pnc.common.enums.Type;
import uca.ncapas.parcial2_pnc.domain.entities.MagicProvider;

@Data
@Builder
public class MagicArticleResponse {

    private Long id;
    private String name;
    private Type type;
    private Double price;
    private MagicProvider magicProvider;
}
