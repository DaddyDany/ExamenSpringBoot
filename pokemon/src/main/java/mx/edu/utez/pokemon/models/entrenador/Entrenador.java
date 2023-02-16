package mx.edu.utez.pokemon.models.entrenador;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemon.models.lista.Lista;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "entrenadores")
@NoArgsConstructor
@Getter
@Setter
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "nombre", length = 150)
    private String nombre;

    @Column(nullable = false, name = "equipo", length = 150)
    private String equipo;

    @JsonIgnore
    @OneToMany(mappedBy = "entrenador")
    private List<Lista> listas;

    public Entrenador(Long id, String nombre, String equipo, List<Lista> listas){
        this.id = id;
        this.nombre = nombre;
        this.equipo = equipo;
        this.listas = listas;
    }

}
