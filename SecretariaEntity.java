package entities;

public class SecretariaEntity extends PessoaEntity {
    private String cargo;

    public SecretariaEntity() {
        super();
        cargo = new String();
    }

    public SecretariaEntity(int id, String nome, String email, String senha, String telefone, String cpf, String rg,
            String cargo) {
        super(id, nome, email, senha, telefone, cpf, rg);
        this.cargo = cargo;
    }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
}
