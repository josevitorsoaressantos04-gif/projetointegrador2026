package sistema.DAO;

import sistema.conexao.ConexaoBanco;
import sistema.model.Cliente;

import java.sql.*;
import java.util.Scanner;


//ajuste rapido
//develop
public class ClienteDAO {

    Scanner sc = new Scanner(System.in);

    public void cadastrarCliente(Cliente cliente) {
     int opacao;
     String sql = "";
        try {
                Connection conexao = ConexaoBanco.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql);
do {
    System.out.println("""
            =====Cadastro do cliente=====
            1 - Cadastrar
            2 - Ataualizar cadastro
            3 - Listar clientes
            4 - Excluir cliente
            5 - Sair""");
    System.out.println("Digite a opção: ");
    opacao = sc.nextInt();
    sc.nextLine();

    switch (opacao){
        case 1:
            System.out.println("Create");
            System.out.println("Digite o nome: ");
            String nome = sc.nextLine();
            System.out.println("CPF ou CNPJ: ");
            int cpf_cnpj = sc.nextInt();
            System.out.println("telefone ");
            int telefone = sc.nextInt();
            System.out.println("Email: ");
            String email = sc.nextLine();

            String insert = "Insert into cliente(nome,cpf_cnpj,telefone,email) values(?,?,?,?)";
            PreparedStatement psInsert = conexao.prepareStatement(insert);
            psInsert.setString(1,nome);
            psInsert.setInt(2,cpf_cnpj);
            psInsert.setInt(3,telefone);
            psInsert.setString(4,email);
            psInsert.executeUpdate();
            System.out.println("Cliente cadastrado");
    break;
        case 2:
            System.out.println("Atualizar ");
            System.out.println("Digite o ID para atualizar: ");
            int idUpadte = sc.nextInt();
            sc.nextLine();
            System.out.println("Novo nome: ");
            String nomeUpadte = sc.nextLine();
            System.out.println("CPF ou CNPJ correto: ");
            int cpfUpadte = sc.nextInt();
            System.out.println("Telefone novo: ");
            int telefoneUpadte = sc.nextInt();
            System.out.println("Email novo: ");
            String emailUpadte = sc.nextLine();

            String upadte = "UPADTE usuario set nome = ? , cpf_cnpj = ? , telefone = ? , email = ? where id = ?";
            PreparedStatement psUpadte = conexao.prepareStatement(upadte);
            psUpadte.setString(1,nomeUpadte);
            psUpadte.setInt(2,cpfUpadte);
            psUpadte.setInt(3,telefoneUpadte);
            psUpadte.setString(4,emailUpadte);
            psUpadte.executeUpdate();
            System.out.println("Usuairo atualizado.");
            break;

        case 3:
            System.out.println("Clientes");
            String select = " Select * from cliente";
            Statement stmtt = conexao.createStatement();
            ResultSet rs = stmtt.executeQuery(select);
            System.out.println("Cadastrados ");
            while (rs.next()) {
                System.out.printf("%d - %s - %d - %d - %s\n",
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("CPF ou Cnpj"),
                        rs.getInt("Telefone"),
                        rs.getString("email"));
            }
            break;

            case 4:
                System.out.println("Excluir");
                System.out.println("Digite a ID para excluir: ");
                int idDelete = sc.nextInt();
                String delete = "Delete from cliente where id = ?";
                PreparedStatement psDelete = conexao.prepareStatement(delete);
                psDelete.setInt(1,idDelete);
                psDelete.executeUpdate();
                System.out.println("Cliente excluido. ");

                break;

                case 5:
                    System.out.println("Cadastro finalizado ");
                    break;
                default:
                    System.out.println("Opção invalida.");
            }
        }while (opacao !=5);
    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        sc.close();
    }
}