package dev.java10x.CadastroDeNinjas.Missoes;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    @GetMapping("/listar")
    public String listarMissoes(){
        return "Missoes listadas com sucesso";
    }
    @GetMapping("/listarID")
    public String listarMissaoPorId(){
        return "Missao listada por id com sucesso ";
    }

    @PostMapping("/criar")
    public String criarMissao(){
        return "Missao criada com sucesso";
    }
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missao alterada com sucesso";
    }
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao deletada com sucesso";
    }

}
