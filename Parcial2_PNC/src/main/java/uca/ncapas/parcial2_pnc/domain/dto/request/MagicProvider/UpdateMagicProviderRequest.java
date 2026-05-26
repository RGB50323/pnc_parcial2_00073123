package uca.ncapas.parcial2_pnc.domain.dto.request.MagicProvider;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uca.ncapas.parcial2_pnc.common.enums.Type;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMagicProviderRequest {

    @NotBlank(message = "Name can not be empty")
    private String name;

    @NotNull(message = "Type can not be empty")
    private Type type;

}
