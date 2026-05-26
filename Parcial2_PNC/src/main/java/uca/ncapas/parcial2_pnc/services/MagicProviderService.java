package uca.ncapas.parcial2_pnc.services;

import uca.ncapas.parcial2_pnc.domain.dto.request.MagicProvider.CreateMagicProviderRequest;
import uca.ncapas.parcial2_pnc.domain.dto.request.MagicProvider.UpdateMagicProviderRequest;
import uca.ncapas.parcial2_pnc.domain.dto.response.MagicProviderResponse;

import java.util.List;

public interface MagicProviderService {

    List<MagicProviderResponse> getAllMagicProviders();
    MagicProviderResponse getMagicProviderById(Long id);
    MagicProviderResponse createMagicProvider(CreateMagicProviderRequest request);
    MagicProviderResponse updateMagicProvider(UpdateMagicProviderRequest request, Long id);
    MagicProviderResponse deleteMagicProvider(Long id);

}
