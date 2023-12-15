package IOI.myinovationsapp.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id", nullable = false)
    private Long rolId;

    @Column(name = "nombre_rol",nullable = false)
    private String nombreRol;

    @ManyToMany(mappedBy = "roles")
    private Set<Usuario> usuarios;
}
