package uca.ncapas.parcial2_pnc.domain.dto.response;

import lombok.Builder;
import lombok.Data;
import uca.ncapas.parcial2_pnc.common.enums.Type;

@Data
@Builder
public class MagicProviderResponse {
    private Long id;
    private String name;
    private Type type;
}
