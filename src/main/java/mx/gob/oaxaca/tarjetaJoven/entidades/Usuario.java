package mx.gob.oaxaca.tarjetaJoven.entidades;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String usuario;
    @Column(name = "contrasena")
    private String password;
    @Column(name = "correo_institucional", unique = true)
    private String correoInstitucional;

    @ManyToMany
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id", "rol_id"})}
    )
    private List<Rol> roles;

    private Boolean activo;
}
