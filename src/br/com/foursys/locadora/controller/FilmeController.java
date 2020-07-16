package br.com.foursys.locadora.controller;

import java.util.ArrayList;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.dao.FilmeDAO;
import br.com.foursys.locadora.dao.FilmeDAO;
import br.com.foursys.locadora.vo.FilmeVO;
/**
 * @author nataliauyu
 * @author patrick
 * 08/04/2020
 * */
public class FilmeController {

	public void salvar(Filme filme) {
		FilmeDAO dao = new FilmeDAO();

		try {
			dao.salvar(filme);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Filme> buscarTodos() {
		ArrayList<Filme> listaRetorno = new ArrayList<Filme>();
		FilmeDAO dao = new FilmeDAO();

		try {
			listaRetorno = dao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}

	public ArrayList<Filme> buscarNome(String nome) {

		ArrayList<Filme> listaRetorno = new ArrayList<Filme>();
		FilmeDAO dao = new FilmeDAO();

		try {
			listaRetorno = dao.buscarNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}

	public void excluir(Filme filme) {
		FilmeDAO dao = new FilmeDAO();

		try {
			dao.excluir(filme);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public ArrayList<Filme> buscarDisponivel(){
        ArrayList<Filme> listaRetorno = new ArrayList<Filme>();
        FilmeDAO dao = new FilmeDAO();
        try {
            listaRetorno = dao.buscarDisponivel();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaRetorno;
    }
	
	public ArrayList<Filme> buscarIndisponivel(){
        ArrayList<Filme> listaRetorno = new ArrayList<Filme>();
        FilmeDAO dao = new FilmeDAO();
        try {
            listaRetorno = dao.buscarIndisponivel();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaRetorno;
    }
	
	/**
	 * Método  para gerar uma lista de Filme para exibir no relatório
	 * 
	 * @return ArrayList de Filmes
	 */
	
	
	public ArrayList<FilmeVO> retornaFilmes(){
		ArrayList<FilmeVO> listaVO = new ArrayList<FilmeVO>();
		
		try {
			ArrayList<Filme> listaFilmes = new FilmeDAO().buscarTodos();
			for (Filme filme : listaFilmes) {
			FilmeVO vo = new FilmeVO();	
		
			vo.setCodigo(filme.getCodigo()+ "");
			vo.setNome(filme.getNome());
			vo.setGenero(filme.getGenero());
		
			listaVO.add(vo);
			}
			
		} catch (Exception e) {
			
		}
		return listaVO;
	}
	
}
