package com.apirest.challenge.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class ErrorDetalles {

    @Getter @Setter
    private Date marcaDeTiempo;

    @Getter @Setter
    private String mensaje;

    @Getter @Setter
    private String detalles;

    public ErrorDetalles(Date marcaDeTiempo, String mensaje, String detalles) {
        super();
        this.marcaDeTiempo = marcaDeTiempo;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }

}
