package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {
    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    //adicionar ninja
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado";
    }
    //mostrar os ninjas
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "mostrar todos os ninjas ";
    }
    //mostrar ninja por ID
    @GetMapping("/todosID")
    public String mostrarNinjaPorId(){
        return "mostrar ninja por id";
    }
    //alterar dados dos ninjas
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterar ninja por id";
    }
    //deletar Ninja
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "Ninja deletado por id";
    }
}
