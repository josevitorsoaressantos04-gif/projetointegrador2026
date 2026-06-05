package sistema.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private int idCliente;
    private String nome;
    private int cpfCnpj;
    private int telefone;
    private String email;

}