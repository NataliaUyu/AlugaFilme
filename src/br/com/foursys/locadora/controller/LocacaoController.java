package br.com.foursys.locadora.controller;

import java.util.ArrayList;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.bean.Locacao;
import br.com.foursys.locadora.dao.FilmeDAO;
import br.com.foursys.locadora.dao.LocacaoDAO;
/**
 * @author nataliauyu
 * @author patrick
 * 08/04/2020
 * */
public class LocacaoController {

	public void salvar(Locacao filme) {
		LocacaoDAO dao = new LocacaoDAO();
		try {
			dao.salvar(filme);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Locacao> buscarTodos() {
		ArrayList<Locacao> listaRetorno = new ArrayList<Locacao>();
		LocacaoDAO dao = new LocacaoDAO();

		try {
			listaRetorno = dao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}

	public ArrayList<Locacao> buscarNome(String nomeCliente) {

		ArrayList<Locacao> listaRetorno = new ArrayList<Locacao>();
		LocacaoDAO dao = new LocacaoDAO();

		try {
			listaRetorno = dao.buscarNome(nomeCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}

	public void excluir(Locacao filme) {
		LocacaoDAO dao = new LocacaoDAO();

		try {
			dao.excluir(filme);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
