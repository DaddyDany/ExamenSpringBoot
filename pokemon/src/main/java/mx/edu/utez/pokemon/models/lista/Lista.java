package mx.edu.utez.pokemon.models.lista;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemon.models.entrenador.Entrenador;
import mx.edu.utez.pokemon.models.pokemon.Pokemon;

import javax.persistence.*;

@Entity
@Table(name="listas")
@NoArgsConstructor
@Getter
@Setter
public class Lista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon;

    @ManyToOne
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;

    public Lista(Long id, Pokemon pokemon, Entrenador entrenador){
        this.id = id;
        this.pokemon = pokemon;
        this.entrenador = entrenador;
    }

    public Long getId(){return id;}
    public void setId(Long id) {
        this.id = id;
    }

    public Pokemon getPokemon(){return pokemon;}

    public void setPokemon(Pokemon pokemon){this.pokemon = pokemon;}
    public Entrenador getEntrenador(){return entrenador;}
    public void setEntrenador(Entrenador entrenador){this.entrenador = entrenador;}

}
