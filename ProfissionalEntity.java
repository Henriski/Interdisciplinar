package entities;

public class ProfissionalEntity extends PessoaEntity {
    private String especialidade;
    private String registroProfissional;

    public ProfissionalEntity() {
        super();
        especialidade = new String();
        registroProfissional = new String();
    }

    public ProfissionalEntity(int id, String nome, String email, String senha, String telefone, String cpf, String rg,
            String especialidade, String registroProfissional) {
        super(id, nome, email, senha, telefone, cpf, rg);
        this.especialidade = especialidade;
        this.registroProfissional = registroProfissional;
    }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    public String getRegistroProfissional() { return registroProfissional; }
    public void setRegistroProfissional(String registroProfissional) { this.registroProfissional = registroProfissional; }
}
