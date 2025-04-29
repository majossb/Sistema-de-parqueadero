package com.colegio.sistemadeparqueadero.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaParqueaderoDTO {
    private Long id;

    @NotBlank(message = "La placa del vehículo es obligatoria")
    @Size(max = 6, message = "La placa no debe exceder los 6 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "La placa debe ser alfanumérica")
    private String placa;

    @NotNull(message = "La hora de entrada es obligatoria")
    private Integer horaEntrada;

    private Integer horaSalida;

    @NotBlank(message = "La ubicación es obligatoria")
    private String ubicacion;

    @NotNull(message = "El tipo de vehículo es obligatorio")
    private Long idTipoVehiculo;

    private String nombreTipoVehiculo;
}