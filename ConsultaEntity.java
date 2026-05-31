package entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class ConsultaEntity {
    private int id;
    private LocalDate data;
    private LocalTime horario;
    private StatusEntity status;
    private String observacao;
    private PacienteEntity paciente;
    private ProfissionalEntity profissional;
    private SecretariaEntity secretaria;

    public ConsultaEntity() {
        data = null;
        horario = null;
        status = new StatusEntity();
        observacao = new String();
        paciente = new PacienteEntity();
        profissional = new ProfissionalEntity();
        secretaria = new SecretariaEntity();
    }

    public ConsultaEntity(int id, LocalDate data, LocalTime horario, StatusEntity status, String observacao,
            PacienteEntity paciente, ProfissionalEntity profissional, SecretariaEntity secretaria) {
        this.id = id;
        this.data = data;
        this.horario = horario;
        this.status = status;
        this.observacao = observacao;
        this.paciente = paciente;
        this.profissional = profissional;
        this.secretaria = secretaria;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public LocalTime getHorario() { return horario; }
    public void setHorario(LocalTime horario) { this.horario = horario; }

    public StatusEntity getStatus() { return status; }
    public void setStatus(StatusEntity status) { this.status = status; }

    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }

    public PacienteEntity getPaciente() { return paciente; }
    public void setPaciente(PacienteEntity paciente) { this.paciente = paciente; }

    public ProfissionalEntity getProfissional() { return profissional; }
    public void setProfissional(ProfissionalEntity profissional) { this.profissional = profissional; }

    public SecretariaEntity getSecretaria() { return secretaria; }
    public void setSecretaria(SecretariaEntity secretaria) { this.secretaria = secretaria; }
}
