package uca.ncapas.parcial2_pnc.common.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uca.ncapas.parcial2_pnc.domain.dto.request.MagicProvider.CreateMagicProviderRequest;
import uca.ncapas.parcial2_pnc.domain.dto.request.MagicProvider.UpdateMagicProviderRequest;
import uca.ncapas.parcial2_pnc.domain.dto.response.MagicProviderResponse;
import uca.ncapas.parcial2_pnc.domain.entities.MagicProvider;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MagicProviderMapper {


    public MagicProvider toEntityCreate(CreateMagicProviderRequest request){
        return MagicProvider.builder()
                .name(request.getName())
                .type(request.getType())
                .build();
    }

    public MagicProvider toEntityUpdate(UpdateMagicProviderRequest request, Long id){
        return MagicProvider.builder()
                .id(id)
                .name(request.getName())
                .type(request.getType())
                .build();
    }

    public MagicProviderResponse toDto(MagicProvider magicProvider){
        return MagicProviderResponse.builder()
                .id(magicProvider.getId())
                .name(magicProvider.getName())
                .type(magicProvider.getType())
                .build();
    }

    public List<MagicProviderResponse> toDtoList(List<MagicProvider> magicProviders){
        return magicProviders.stream().map(this::toDto).toList();
    }

}
