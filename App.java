import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import entities.ConsultaEntity;
import entities.EtapaEntity;
import entities.OrcamentoEntity;
import entities.PacienteEntity;
import entities.ProfissionalEntity;
import entities.SecretariaEntity;
import entities.StatusEntity;
import entities.TratamentoEntity;

public class App {
    public static void main(String[] args) throws Exception {

        // Status
        StatusEntity statusAgendada    = new StatusEntity(1, "Agendada");
        StatusEntity statusRealizada   = new StatusEntity(2, "Realizada");
        StatusEntity statusEmAndamento = new StatusEntity(3, "Em Andamento");
        StatusEntity statusConcluido   = new StatusEntity(4, "Concluído");
        StatusEntity statusPendente    = new StatusEntity(5, "Pendente");
        StatusEntity statusAprovado    = new StatusEntity(6, "Aprovado");

        // Pacientes
        PacienteEntity pac1 = new PacienteEntity(1, "Ana Clara Souza", "ana@email.com", "senha123",
                "(17) 99100-0001", "111.222.333-01", "1111111",
                "Rua das Flores, 100", LocalDate.of(1990, 3, 15));

        PacienteEntity pac2 = new PacienteEntity(2, "Bruno Lima", "bruno@email.com", "senha123",
                "(17) 99100-0002", "111.222.333-02", "2222222",
                "Av. Bady Bassitt, 200", LocalDate.of(1985, 7, 22));

        // Secretaria
        SecretariaEntity sec1 = new SecretariaEntity(1, "Karla Mendes", "karla@clinica.com", "sec123",
                "(17) 99100-0011", "111.222.333-11", "1111111", "Secretária Administrativa");

        // Profissionais
        ProfissionalEntity prof1 = new ProfissionalEntity(1, "Lucas Barbosa", "lucas@clinica.com", "prof123",
                "(17) 99100-0012", "111.222.333-12", "3333333", "Clínico Geral", "CRM-SP-001234");

        ProfissionalEntity prof2 = new ProfissionalEntity(2, "Mariana Gomes", "mariana@clinica.com", "prof456",
                "(17) 99100-0013", "111.222.333-13", "4444444", "Dermatologista", "CRM-SP-005678");

        // Consultas
        ConsultaEntity con1 = new ConsultaEntity(1, LocalDate.of(2025, 1, 10), LocalTime.of(8, 0),
                statusRealizada, "Consulta de rotina", pac1, prof1, sec1);

        ConsultaEntity con2 = new ConsultaEntity(2, LocalDate.of(2025, 3, 5), LocalTime.of(9, 30),
                statusAgendada, null, pac2, prof2, sec1);

        // Tratamento com etapas
        ArrayList<EtapaEntity> etapas1 = new ArrayList<>();
        TratamentoEntity trat1 = new TratamentoEntity(1, "Tratamento para hipertensão",
                LocalDate.of(2025, 1, 15), LocalDate.of(2025, 7, 15),
                statusEmAndamento, pac1, prof1, etapas1);

        EtapaEntity etapa1 = new EtapaEntity(1, "Avaliação inicial e anamnese", 1, statusConcluido, trat1);
        EtapaEntity etapa2 = new EtapaEntity(2, "Exames laboratoriais", 2, statusConcluido, trat1);
        EtapaEntity etapa3 = new EtapaEntity(3, "Início da medicação anti-hipertensiva", 3, statusEmAndamento, trat1);
        EtapaEntity etapa4 = new EtapaEntity(4, "Reavaliação em 30 dias", 4, statusPendente, trat1);
        etapas1.add(etapa1);
        etapas1.add(etapa2);
        etapas1.add(etapa3);
        etapas1.add(etapa4);

        // Orçamentos
        OrcamentoEntity orc1 = new OrcamentoEntity(1, 250.00, LocalDate.of(2025, 1, 10),
                statusAprovado, con1, null);

        OrcamentoEntity orc2 = new OrcamentoEntity(2, 420.00, LocalDate.of(2025, 1, 15),
                statusPendente, null, trat1);

        // Exibindo resultados
        System.out.println("=== PACIENTES ===");
        System.out.println(pac1.getNome() + " | CPF: " + pac1.getCpf() + " | Nasc: " + pac1.getDataNascimento());
        System.out.println(pac2.getNome() + " | CPF: " + pac2.getCpf() + " | Nasc: " + pac2.getDataNascimento());

        System.out.println("\n=== PROFISSIONAIS ===");
        System.out.println(prof1.getNome() + " | " + prof1.getEspecialidade() + " | " + prof1.getRegistroProfissional());
        System.out.println(prof2.getNome() + " | " + prof2.getEspecialidade() + " | " + prof2.getRegistroProfissional());

        System.out.println("\n=== CONSULTAS ===");
        System.out.println("Consulta #" + con1.getId() + " | " + con1.getPaciente().getNome()
                + " | " + con1.getData() + " " + con1.getHorario()
                + " | Status: " + con1.getStatus().getDescricao());
        System.out.println("Consulta #" + con2.getId() + " | " + con2.getPaciente().getNome()
                + " | " + con2.getData() + " " + con2.getHorario()
                + " | Status: " + con2.getStatus().getDescricao());

        System.out.println("\n=== TRATAMENTO ===");
        System.out.println("Tratamento #" + trat1.getId() + " | " + trat1.getDescricao()
                + " | Status: " + trat1.getStatus().getDescricao());
        System.out.println("Etapas:");
        for (EtapaEntity e : trat1.getEtapas()) {
            System.out.println("  " + e.getOrdem() + ". " + e.getDescricao()
                    + " [" + e.getStatus().getDescricao() + "]");
        }

        System.out.println("\n=== ORÇAMENTOS ===");
        System.out.println("Orçamento #" + orc1.getId() + " | R$ " + orc1.getValorTotal()
                + " | Status: " + orc1.getStatus().getDescricao());
        System.out.println("Orçamento #" + orc2.getId() + " | R$ " + orc2.getValorTotal()
                + " | Status: " + orc2.getStatus().getDescricao());
    }
}
