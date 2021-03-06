package br.com.foursys.locadora.controller;

import java.util.ArrayList;

import br.com.foursys.locadora.bean.Cliente;
import br.com.foursys.locadora.dao.ClienteDAO;
import br.com.foursys.locadora.vo.ClienteVO;
/**
 * @author nataliauyu
 * @author patrick
 * 08/04/2020
 * */
public class ClienteController {

	public void salvar(Cliente cliente) {
		ClienteDAO dao = new ClienteDAO();

		try {
			dao.salvar(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	

	public ArrayList<Cliente> buscarTodos() {
		ArrayList<Cliente> listaRetorno = new ArrayList<Cliente>();
		ClienteDAO dao = new ClienteDAO();

		try {
			listaRetorno = dao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}

	public ArrayList<Cliente> buscarNome(String nome) {

		ArrayList<Cliente> listaRetorno = new ArrayList<Cliente>();
		ClienteDAO dao = new ClienteDAO();

		try {
			listaRetorno = dao.buscarNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}

	public void excluir(Cliente cliente) {
		ClienteDAO dao = new ClienteDAO();

		try {
			dao.excluir(cliente);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	/**
	 * M�todo  para gerar uma lista de Cliente para exibir no relat�rio
	 * 
	 * @return ArrayList de clientes
	 */
	
	
	public ArrayList<ClienteVO> retornaClientes(){
		ArrayList<ClienteVO> listaVO = new ArrayList<ClienteVO>();
		
		try {
			ArrayList<Cliente> listaClientes = new ClienteDAO().buscarTodos();
			for (Cliente cliente : listaClientes) {
			ClienteVO vo = new ClienteVO();	
		
			vo.setNome(cliente.getNome());
			vo.setTelefone(cliente.getTelefone());
			vo.setDataNascimento(cliente.getDataNascimento());
			vo.setCidade(cliente.getCidade());
			listaVO.add(vo);
			}
			
		} catch (Exception e) {
			
		}
		return listaVO;
	}
	
	
}
