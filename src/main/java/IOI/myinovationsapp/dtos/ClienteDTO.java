package IOI.myinovationsapp.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
    private String name;
    private String email;
    private String phone;
    private boolean corporate;

    // Getters y setters
    @Getter
    @Setter
    public static class AntifraudInfo {
        private long accountCreatedAt;

    }
    @Getter
    @Setter
    public static class Metadata {
        private String newKey;
    }
}
