package uca.ncapas.parcial2_pnc.domain.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ApiErrorResponse {
    private Object message;
    private int status;
    private LocalDate time;
    private String uri;
}