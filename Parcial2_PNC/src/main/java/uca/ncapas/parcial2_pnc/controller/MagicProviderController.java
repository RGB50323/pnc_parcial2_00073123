package uca.ncapas.parcial2_pnc.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import uca.ncapas.parcial2_pnc.domain.dto.request.MagicProvider.CreateMagicProviderRequest;
import uca.ncapas.parcial2_pnc.domain.dto.request.MagicProvider.UpdateMagicProviderRequest;
import uca.ncapas.parcial2_pnc.domain.dto.response.GeneralResponse;
import uca.ncapas.parcial2_pnc.services.MagicProviderService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/magicProvider")
@RequiredArgsConstructor
public class MagicProviderController {

    private final MagicProviderService magicProviderService;

    @PostMapping("/providers")
    public ResponseEntity<GeneralResponse> createMagicProvider(@Valid @RequestBody CreateMagicProviderRequest request){
        return buildResponse(
                "Magic Provider created successfully!",
                HttpStatus.CREATED,
                magicProviderService.createMagicProvider(request)
        );
    }

    @PutMapping("/providers/{id}")
    public ResponseEntity<GeneralResponse> updateMagicProvider(@Valid @RequestBody UpdateMagicProviderRequest request, @PathVariable Long id){
        return buildResponse(
                "Magic Provider updated successfully!",
                HttpStatus.OK,
                magicProviderService.updateMagicProvider(request, id)
        );
    }

    @DeleteMapping("/providers/{id}")
    public ResponseEntity<GeneralResponse> deleteMagicProvider(@PathVariable Long id){
        return buildResponse(
                "Magic Provider deleted successfully!",
                HttpStatus.OK,
                magicProviderService.deleteMagicProvider(id)
        );
    }

    @GetMapping("/")
    public ResponseEntity<GeneralResponse> getAllMagicProviders(){
        return buildResponse(
                "Magic Providers found",
                HttpStatus.OK,
                magicProviderService.getAllMagicProviders()
        );
    }

    @GetMapping("/providers/{id}")
    public ResponseEntity<GeneralResponse> getMagicProviderById(@PathVariable Long id){
        return buildResponse(
                "Magic Provider found",
                HttpStatus.OK,
                magicProviderService.getMagicProviderById(id)
        );
    }

    public ResponseEntity<GeneralResponse> buildResponse(String message, HttpStatus status, Object data) {
        String uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().getPath();
        return ResponseEntity
                .status(status)
                .body(GeneralResponse.builder()
                        .uri(uri)
                        .message(message)
                        .status(status.value())
                        .time(LocalDateTime.now())
                        .data(data)
                        .build()
                );
    }

}
