package uca.ncapas.parcial2_pnc.services.ServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uca.ncapas.parcial2_pnc.common.mappers.MagicProviderMapper;
import uca.ncapas.parcial2_pnc.domain.dto.request.MagicProvider.CreateMagicProviderRequest;
import uca.ncapas.parcial2_pnc.domain.dto.request.MagicProvider.UpdateMagicProviderRequest;
import uca.ncapas.parcial2_pnc.domain.dto.response.MagicProviderResponse;
import uca.ncapas.parcial2_pnc.domain.entities.MagicProvider;
import uca.ncapas.parcial2_pnc.exceptions.ResourceNotFoundException;
import uca.ncapas.parcial2_pnc.repository.MagicProviderRepository;
import uca.ncapas.parcial2_pnc.services.MagicProviderService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MagicProviderServiceImpl implements MagicProviderService {

    private final MagicProviderRepository magicProviderRepository;
    private final MagicProviderMapper magicProviderMapper;

    @Override
    public List<MagicProviderResponse> getAllMagicProviders() {
        return magicProviderMapper.toDtoList(magicProviderRepository.findAll());
    }

    @Override
    public MagicProviderResponse getMagicProviderById(Long id) {
        return magicProviderMapper.toDto(
                magicProviderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Magic Provider not found"))
        );
    }

    @Override
    public MagicProviderResponse createMagicProvider(CreateMagicProviderRequest request) {
        return magicProviderMapper.toDto(
                magicProviderRepository.save(magicProviderMapper.toEntityCreate(request))
        );
    }

    @Override
    public MagicProviderResponse updateMagicProvider(UpdateMagicProviderRequest request, Long id) {
        this.getMagicProviderById(id);
        return magicProviderMapper.toDto(magicProviderRepository.save(magicProviderMapper.toEntityUpdate(request, id)));
    }

    @Override
    public MagicProviderResponse deleteMagicProvider(Long id) {
        MagicProvider magicProvider = magicProviderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Magic Provider not found"));

        magicProviderRepository.deleteById(id);
        return magicProviderMapper.toDto(magicProvider);
    }
}
