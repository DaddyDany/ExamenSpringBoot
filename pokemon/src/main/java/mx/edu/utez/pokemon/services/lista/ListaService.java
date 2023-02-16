package mx.edu.utez.pokemon.services.lista;

import mx.edu.utez.pokemon.models.lista.Lista;
import mx.edu.utez.pokemon.models.lista.ListaRepository;
import mx.edu.utez.pokemon.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ListaService {
    @Autowired
    private ListaRepository Repository;

    //GETALL
    @Transactional(readOnly = true)
    public Response<List<Lista>> getAll(){
        return new Response<>(
                this.Repository.findAll(),false,200,"OK"
        );
    }

    //GETONE
    @Transactional(readOnly = true)
    public Response<Lista> getOne(Long id){
        return new Response<>(
                this.Repository.findById(id).get(),false,200,"ok"
        );
    }

    //INSERT
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Lista> insert(Lista lista){

        return new Response<>(
                this.Repository.saveAndFlush(lista),false,200,"OK"
        );
    }

    //UPDATE
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Lista> update(Long id,Lista lista){
        if((!this.Repository.existsById(id))){
            return new Response<>(null,true,400,"Lista inexistente");
        }
        return new Response<>(
                this.Repository.saveAndFlush(lista),false,200,"ok"
        );
    }

    //DELETE
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Lista> delete(Long id){
        Optional<Lista> exists = this.Repository.findById(id);

        if((exists.isEmpty())){
            return new Response<>(null,true,400,"Lista inexistente");
        }
        this.Repository.deleteById(id);
        return new Response<>(
                null,false,200,"OK"
        );
    }
}
