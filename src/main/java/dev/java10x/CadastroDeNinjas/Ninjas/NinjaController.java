package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }


    @GetMapping("/listar")
    public String mostrarTodosOsNinjas(){
        return "mostrar todos os ninjas ";
    }
    @GetMapping("/listarID")
    public String mostrarNinjaPorId(){
        return "mostrar ninja por id";
    }

    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado";
    }
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterar ninja por id";
    }
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "Ninja deletado por id";
    }
}
