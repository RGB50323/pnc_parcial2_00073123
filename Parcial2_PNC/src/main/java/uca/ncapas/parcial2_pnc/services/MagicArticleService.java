package uca.ncapas.parcial2_pnc.services;

import uca.ncapas.parcial2_pnc.domain.dto.request.MagicArticle.CreateMagicArticleRequest;
import uca.ncapas.parcial2_pnc.domain.dto.request.MagicArticle.UpdateMagicArticleRequest;
import uca.ncapas.parcial2_pnc.domain.dto.response.MagicArticleResponse;

import java.util.List;

public interface MagicArticleService {

    List<MagicArticleResponse> getAllMagicArticles();
    MagicArticleResponse getMagicArticleId(Long id);
    MagicArticleResponse createMagicArticle(CreateMagicArticleRequest request);
    MagicArticleResponse updateMagicArticle(UpdateMagicArticleRequest request, Long id);
    MagicArticleResponse deleteMagicArticle(Long id);

}
