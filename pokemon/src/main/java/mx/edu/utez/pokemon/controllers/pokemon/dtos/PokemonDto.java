package mx.edu.utez.pokemon.controllers.pokemon.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemon.models.lista.Lista;
import mx.edu.utez.pokemon.models.pokemon.Pokemon;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PokemonDto {
    private Long id;

    @NotEmpty(message = "El nombre del pokemon no puede quedar vacio")
    private String nombre;

    private String tipo;

    private Long nivel;
    private Long salud;

    private Long ataque;
    private Long defensa;

    private List<Lista> listas;

    public Pokemon getPokemon(){
        return new Pokemon(
                getId(),
                getNombre(),
                getTipo(),
                getNivel(),
                getSalud(),
                getAtaque(),
                getDefensa(),
                getListas()
        );
    }
}
