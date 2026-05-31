package entities;

import java.time.LocalDate;
import java.util.ArrayList;

public class TratamentoEntity {
    private int id;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private StatusEntity status;
    private PacienteEntity paciente;
    private ProfissionalEntity profissional;
    private ArrayList<EtapaEntity> etapas;

    public TratamentoEntity() {
        descricao = new String();
        dataInicio = null;
        dataFim = null;
        status = new StatusEntity();
        paciente = new PacienteEntity();
        profissional = new ProfissionalEntity();
        etapas = new ArrayList<>();
    }

    public TratamentoEntity(int id, String descricao, LocalDate dataInicio, LocalDate dataFim,
            StatusEntity status, PacienteEntity paciente, ProfissionalEntity profissional,
            ArrayList<EtapaEntity> etapas) {
        this.id = id;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = status;
        this.paciente = paciente;
        this.profissional = profissional;
        this.etapas = etapas;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }

    public LocalDate getDataFim() { return dataFim; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }

    public StatusEntity getStatus() { return status; }
    public void setStatus(StatusEntity status) { this.status = status; }

    public PacienteEntity getPaciente() { return paciente; }
    public void setPaciente(PacienteEntity paciente) { this.paciente = paciente; }

    public ProfissionalEntity getProfissional() { return profissional; }
    public void setProfissional(ProfissionalEntity profissional) { this.profissional = profissional; }

    public ArrayList<EtapaEntity> getEtapas() { return etapas; }
    public void setEtapas(ArrayList<EtapaEntity> etapas) { this.etapas = etapas; }
}
