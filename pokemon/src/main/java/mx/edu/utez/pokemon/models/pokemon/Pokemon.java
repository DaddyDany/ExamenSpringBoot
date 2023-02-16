package mx.edu.utez.pokemon.models.pokemon;
/*Tabla 1: Pokémon

ID del Pokemon (entero, clave primaria)
Nombre del Pokemon (texto)
Tipo de Pokemon (texto)
Nivel de poder (entero)
Puntos de salud (entero)
Ataque (entero)
Defensa (entero)
*/

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemon.models.lista.Lista;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "pokemons")
@NoArgsConstructor
@Getter
@Setter
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "nombre", length = 150)
    private String nombre;

    @Column(nullable = false, name = "tipo", length = 150)
    private String tipo;

    @Column(nullable = false, name = "nivel", length = 5)
    private Long nivel;

    @Column(nullable = false, name = "salud", length = 5)
    private Long salud;

    @Column(nullable = false, name = "ataque", length = 5)
    private Long ataque;

    @Column(nullable = false, name = "defensa", length = 5)
    private Long defensa;

    @JsonIgnore
    @OneToMany(mappedBy = "pokemon")
    private  List<Lista> listas;

    public Pokemon(Long id, String nombre, String tipo, Long nivel, Long salud, Long ataque, Long defensa, List<Lista> listas){
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.salud = salud;
        this.ataque = ataque;
        this.defensa = defensa;
        this.listas = listas;
    }


}
