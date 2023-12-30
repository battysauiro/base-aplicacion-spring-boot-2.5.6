package IOI.myinovationsapp.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanDTO {

    private String id;
    private boolean livemode;
    private long created_at;
    private String name;
    private Double amount; // Cambiado a double para manejar números con decimales
    private String currency;
    private String interval;
    private Integer frequency;
    private Integer expiry_count;
    private Integer trial_period_days; // Usado Integer en lugar de int para permitir nulo
    private String object;
}
