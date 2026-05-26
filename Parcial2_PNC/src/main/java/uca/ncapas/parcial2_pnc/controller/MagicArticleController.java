package uca.ncapas.parcial2_pnc.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import uca.ncapas.parcial2_pnc.domain.dto.request.MagicArticle.CreateMagicArticleRequest;
import uca.ncapas.parcial2_pnc.domain.dto.request.MagicArticle.UpdateMagicArticleRequest;
import uca.ncapas.parcial2_pnc.domain.dto.response.GeneralResponse;
import uca.ncapas.parcial2_pnc.services.MagicArticleService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/magicArticle")
@RequiredArgsConstructor
public class MagicArticleController {

    private final MagicArticleService magicArticleService;

    @PostMapping("/artefacts")
    public ResponseEntity<GeneralResponse> createMagicArticle(@Valid @RequestBody CreateMagicArticleRequest request){
        return buildResponse(
                "Magic Article created successfully!",
                HttpStatus.CREATED,
                magicArticleService.createMagicArticle(request)
        );
    }

    @PutMapping("/artefacts/{id}")
    public ResponseEntity<GeneralResponse> updateMagicArticle(@Valid @RequestBody UpdateMagicArticleRequest request, @PathVariable Long id){
        return buildResponse(
                "Magic Article updated successfully!",
                HttpStatus.OK,
                magicArticleService.updateMagicArticle(request, id)
        );
    }

    @DeleteMapping("/artefacts/{id}")
    public ResponseEntity<GeneralResponse> deleteMagicArticle(@PathVariable Long id){
        return buildResponse(
                "Magic article deleted successfully!",
                HttpStatus.OK,
                magicArticleService.deleteMagicArticle(id)
        );
    }

    @GetMapping("/")
    public ResponseEntity<GeneralResponse> getAllMagicArticles(){
        return buildResponse(
                "Magic Articles found",
                HttpStatus.OK,
                magicArticleService.getAllMagicArticles()
        );
    }

    @GetMapping("/artefacts/{id}")
    public ResponseEntity<GeneralResponse> getMagicArticleById(@PathVariable Long id){
        return buildResponse(
                "Magic Article found",
                HttpStatus.OK,
                magicArticleService.getMagicArticleId(id)
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
