package uca.ncapas.parcial2_pnc.common.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uca.ncapas.parcial2_pnc.domain.dto.request.MagicArticle.CreateMagicArticleRequest;
import uca.ncapas.parcial2_pnc.domain.dto.request.MagicArticle.UpdateMagicArticleRequest;
import uca.ncapas.parcial2_pnc.domain.dto.request.MagicProvider.CreateMagicProviderRequest;
import uca.ncapas.parcial2_pnc.domain.dto.request.MagicProvider.UpdateMagicProviderRequest;
import uca.ncapas.parcial2_pnc.domain.dto.response.MagicArticleResponse;
import uca.ncapas.parcial2_pnc.domain.dto.response.MagicProviderResponse;
import uca.ncapas.parcial2_pnc.domain.entities.MagicArticle;
import uca.ncapas.parcial2_pnc.domain.entities.MagicProvider;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MagicArticleMapper {

    public MagicArticle toEntityCreate(CreateMagicArticleRequest request, MagicProvider magicProvider){
        return MagicArticle.builder()
                .name(request.getName())
                .type(request.getType())
                .price(request.getPrice())
                .magicProvider(magicProvider)
                .build();
    }

    public MagicArticle toEntityUpdate(UpdateMagicArticleRequest request, Long id, MagicProvider magicProvider){
        return MagicArticle.builder()
                .id(id)
                .name(request.getName())
                .type(request.getType())
                .price(request.getPrice())
                .magicProvider(magicProvider)
                .build();
    }

    public MagicArticleResponse toDto(MagicArticle magicArticle){
        return MagicArticleResponse.builder()
                .id(magicArticle.getId())
                .name(magicArticle.getName())
                .type(magicArticle.getType())
                .price(magicArticle.getPrice())
                .magicProvider(magicArticle.getMagicProvider())
                .build();
    }

    public List<MagicArticleResponse> toDtoList(List<MagicArticle> magicArticles){
        return magicArticles.stream().map(this::toDto).toList();
    }


}
