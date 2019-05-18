package br.pucrs.ages.mase.user_service.dto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class LocationDto {

    private @NotNull BigDecimal latitude;
    private @NotNull BigDecimal longitude;

    public BigDecimal getLatitude() {
        return latitude;
    }


    public BigDecimal getLongitude() {
        return longitude;
    }
}
