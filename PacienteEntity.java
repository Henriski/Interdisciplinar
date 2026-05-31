package entities;

import java.time.LocalDate;

public class PacienteEntity extends PessoaEntity {
    private String endereco;
    private LocalDate dataNascimento;

    public PacienteEntity() {
        super();
        endereco = new String();
        dataNascimento = null;
    }

    public PacienteEntity(int id, String nome, String email, String senha, String telefone, String cpf, String rg,
            String endereco, LocalDate dataNascimento) {
        super(id, nome, email, senha, telefone, cpf, rg);
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
}
