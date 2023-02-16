package mx.edu.utez.pokemon.controllers.lista.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemon.models.entrenador.Entrenador;
import mx.edu.utez.pokemon.models.lista.Lista;
import mx.edu.utez.pokemon.models.pokemon.Pokemon;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ListaDto {
    private Long id;
    private Pokemon pokemon;
    private Entrenador entrenador;
    public Lista getLista(){
        return new Lista(
                getId(),
                getPokemon(),
                getEntrenador()
        );
    }
}
