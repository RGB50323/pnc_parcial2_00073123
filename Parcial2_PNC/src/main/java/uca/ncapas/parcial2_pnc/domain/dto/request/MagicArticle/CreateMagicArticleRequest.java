package uca.ncapas.parcial2_pnc.domain.dto.request.MagicArticle;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uca.ncapas.parcial2_pnc.common.enums.Type;
import uca.ncapas.parcial2_pnc.domain.entities.MagicProvider;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMagicArticleRequest {

    @NotBlank(message = "Name can not be empty")
    private String name;

    @NotNull(message = "Type can not be empty")
    private Type type;

    @NotNull(message = "Price can not be empty")
    @Positive(message = "Price must be a positive value")
    private Double price;

    @NotNull(message = "Magic provider can not be empty")
    private Long magicProviderId;

}
