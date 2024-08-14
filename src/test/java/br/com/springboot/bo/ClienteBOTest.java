package br.com.springboot.bo;

import java.time.LocalDate;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.springboot.model.Cliente;
import br.com.springboot.model.Sexo;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(OrderAnnotation.class)
public class ClienteBOTest {
	
	@Autowired
	private ClienteBO bo;
	
	@Test
	@Order(1)
	public void insere() {
		Cliente cliente = new Cliente();
		cliente.setNome("William");
		cliente.setCpf("000.000.000-00");
		cliente.setDataDeNascimento(LocalDate.of(2000, 1, 8));
		cliente.setSexo(Sexo.MASCULINO);
		cliente.setTelefone("0123456789");
		cliente.setCelular("01234567890");
		cliente.setAtivo(true);
		cliente.setEmail("will@gmail.com");
		bo.insere(cliente);
	}
	
	@Test
	@Order(2)
	public void pesquisaPeloID() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		System.out.println(cliente);
	}
	
	@Test
	@Order(3)
	public void atualiza() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		cliente.setCpf("111.111.111-11");
		bo.atualiza(cliente);
	}
	
}
