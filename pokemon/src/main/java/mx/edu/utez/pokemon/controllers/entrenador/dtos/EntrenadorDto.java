package mx.edu.utez.pokemon.controllers.entrenador.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemon.models.entrenador.Entrenador;
import mx.edu.utez.pokemon.models.lista.Lista;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EntrenadorDto {
    private Long id;
    @NotEmpty(message = "El nombre del entrenador no puede quedar vacio")
    private String nombre;

    private String equipo;

    private List<Lista> listas;

    public Entrenador getEntrenador(){
        return new Entrenador(
                getId(),
                getNombre(),
                getEquipo(),
                getListas()
        );
    }
}
