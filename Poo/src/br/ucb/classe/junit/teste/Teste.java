package br.ucb.classe.junit.teste;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.ucb.classe.modelo.Paciente;
import br.ucb.classe.modelo.Posto;
import br.ucb.classe.modelo.Vacina;

	

class Teste {
	
	private static Paciente paciente;
	private static Vacina vacina;
	@BeforeAll
	public static void ini() {
		paciente = new Paciente("Aninha", 69, "468151354", "esquina");
		vacina = new Vacina("VacinaTeste", 32, 4, LocalDateTime.now().plusDays(92),3);
		Posto.adicionarVacinas(vacina);
		Posto.adicionarPacientes(paciente);
		Posto.utilizarVacina(4, paciente);
		paciente.setDatas(paciente);
		
	}
	
	@Test
	void TestUnidadeCadastrarVacina() {
		assertEquals("VacinaTeste", vacina.getNome());
		assertEquals(4, vacina.getLote());
		assertEquals("25/02/2023", vacina.getDataVencimento());
		assertEquals(3, vacina.getDosesPorPaciente());
	}
	@Test
	void TestUnidadeCadastrarPaciente() {
		assertEquals("Aninha", paciente.getNome());
		assertEquals(69, paciente.getIdade());
		assertEquals("468151354", paciente.getCpf());
		assertEquals("esquina", paciente.getEndereco());
	}
	@Test
	void TestUnidadeAplicarDose() {
		assertEquals("25/11/2022", paciente.getDataPrimeira());
		assertEquals("25/02/2023", paciente.getDataRetorno());
		assertEquals("VacinaTeste", paciente.getVacinaRecebida().getNome());
		assertEquals(1, paciente.getQuantidadeDoses());
	}
}
