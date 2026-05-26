package uca.ncapas.parcial2_pnc.services.ServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uca.ncapas.parcial2_pnc.common.mappers.MagicArticleMapper;
import uca.ncapas.parcial2_pnc.domain.dto.request.MagicArticle.CreateMagicArticleRequest;
import uca.ncapas.parcial2_pnc.domain.dto.request.MagicArticle.UpdateMagicArticleRequest;
import uca.ncapas.parcial2_pnc.domain.dto.response.MagicArticleResponse;
import uca.ncapas.parcial2_pnc.domain.entities.MagicProvider;
import uca.ncapas.parcial2_pnc.exceptions.ResourceNotFoundException;
import uca.ncapas.parcial2_pnc.repository.MagicArticleRepository;
import uca.ncapas.parcial2_pnc.repository.MagicProviderRepository;
import uca.ncapas.parcial2_pnc.services.MagicArticleService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MagicArticleServiceImpl implements MagicArticleService {

    private final MagicArticleRepository magicArticleRepository;
    private final MagicArticleMapper magicArticleMapper;
    private final MagicProviderRepository magicProviderRepository;

    @Override
    public List<MagicArticleResponse> getAllMagicArticles() {
        return magicArticleMapper.toDtoList(magicArticleRepository.findAll());
    }

    @Override
    public MagicArticleResponse getMagicArticleId(Long id) {
        return magicArticleMapper.toDto(magicArticleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Magic Article not found")));
    }

    @Override
    public MagicArticleResponse createMagicArticle(CreateMagicArticleRequest request) {

        if (magicArticleRepository.existsByNameIgnoringCase(request.getName()))
            throw new ResourceNotFoundException("Name already exists");

        MagicProvider magicProvider = magicProviderRepository.findById(request.getMagicProviderId())
                .orElseThrow(() -> new ResourceNotFoundException("Magic Provider not found"));

        return magicArticleMapper.toDto(magicArticleRepository.save(magicArticleMapper.toEntityCreate(request, magicProvider)));
    }

    @Override
    @Transactional
    public MagicArticleResponse updateMagicArticle(UpdateMagicArticleRequest request, Long id) {
        this.getMagicArticleId(id);

        MagicProvider magicProvider = magicProviderRepository.findById(request.getMagicProviderId())
                .orElseThrow(() -> new ResourceNotFoundException("Magic Provider not found"));

        return magicArticleMapper.toDto(
                magicArticleRepository.save(magicArticleMapper.toEntityUpdate(request, id, magicProvider))
        );
    }

    @Override
    public MagicArticleResponse deleteMagicArticle(Long id) {
        MagicArticleResponse existMagicArticle = this.getMagicArticleId(id);
        magicArticleRepository.deleteById(id);
        return existMagicArticle;
    }
}
