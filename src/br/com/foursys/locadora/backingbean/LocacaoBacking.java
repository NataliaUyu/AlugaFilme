package br.com.foursys.locadora.backingbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.bean.Locacao;
import br.com.foursys.locadora.controller.ClienteController;
import br.com.foursys.locadora.controller.FilmeController;
import br.com.foursys.locadora.controller.LocacaoController;
import br.com.foursys.locadora.util.JSFUtil;
/**
 * @author nataliauyu
 * @author patrick
 * 08/04/2020
 * */
public class LocacaoBacking {

	private int codigo;
	private String nomeCliente;
	private String nomeFilme;
	private double valorFilme;
	private String data;
	private String lblFilme;
	private String lblCliente;
	private String lblValor;
	
	private int i = 0;

	private Filme filme;
	private List<Filme> listaFilme;
	private Locacao locacao = new Locacao();
	private Locacao locacaoSelecionado = new Locacao();
	private Filme filmeSelecionado = new Filme();
	private List<SelectItem> itensLocacoes;
	private List<Locacao> listaLocacao;
	private List<Filme> listaFilmeD;
	
	

	private int scrollerPage;
	

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	public Locacao getLocacaoSelecionado() {
		return locacaoSelecionado;
	}

	public void setLocacaoSelecionado(Locacao locacaoSelecionado) {
		this.locacaoSelecionado = locacaoSelecionado;
	}

	public List<SelectItem> getItensLocacoes() {
		return itensLocacoes;
	}

	public void setItensLocacoes(List<SelectItem> itensLocacoes) {
		this.itensLocacoes = itensLocacoes;
	}

	public int getScrollerPage() {
		return scrollerPage;
	}

	public void setScrollerPage(int scrollerPage) {
		this.scrollerPage = scrollerPage;
	}

	

	public String consultarLocacao() {
		listarLocacao();
		return "";
	}

	public List<Locacao> getListaLocacao() {
		return listaLocacao;
	}

	public void setListaLocacao(List<Locacao> listaLocacao) {
		this.listaLocacao = listaLocacao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public double getValorFilme() {
		return valorFilme;
	}

	public void setValorFilme(double valorFilme) {
		this.valorFilme = valorFilme;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getLblFilme() {
		return lblFilme;
	}

	public void setLblFilme(String lblFilme) {
		this.lblFilme = lblFilme;
	}

	public String getLblCliente() {
		return lblCliente;
	}

	public void setLblCliente(String lblCliente) {
		this.lblCliente = lblCliente;
	}

	public String getLblValor() {
		return lblValor;
	}

	public void setLblValor(String lblValor) {
		this.lblValor = lblValor;
	}

	public String confirmacaoLocacao() {
		return "";
	}

	public String efetuarLocacao() {
		limparDados();
		return "";
	}

	public String devolucaoLocacao() {
		return "";
	}

	public String cancelar() {
		limparDados();
		return "cancelar";
	}

	public String sair() {

		return "sair";
	}
	
	public String popularFilmeAlugado(ValueChangeEvent e) {
		FilmeController filmeController = new FilmeController();
		i = 1;
		String auxIndice = e.getNewValue().toString();
		listaFilme = filmeController.buscarIndisponivel();
		filme = listaFilme.get(Integer.parseInt(auxIndice) - 1);
		this.nomeFilme = filme.getNome();
		if (filme.getPromocao().equals("SIM")) {
			this.valorFilme = filme.getValorPromocao();

		} else {
			this.valorFilme = filme.getValor();
		}

		return "";
	}
	
	public String popularFilmeIndisponivel(ValueChangeEvent e) {
		FilmeController filmeController = new FilmeController();
		i = 1;
		String auxIndice = e.getNewValue().toString();
		listaFilme = filmeController.buscarIndisponivel();
		filme = listaFilme.get(Integer.parseInt(auxIndice) - 1);
		this.nomeFilme = filme.getNome();
		if (filme.getPromocao().equals("NÃO")) {
			this.valorFilme = filme.getValorPromocao();

		} else {
			this.valorFilme = filme.getValor();
		}

		return "";
	}


	public String mudarIndisponivel() {
		filme.setDisponivel("SIM");
		FilmeController controller = new FilmeController();
		controller.salvar(filme);
		return "";
	}


	public void limparDados() {
		nomeCliente = null;
		nomeFilme = null;
		valorFilme = 0;
		lblCliente = null;
		lblFilme = null;
		lblValor = null;

	}

	public String popularCliente(ValueChangeEvent e) {
		nomeCliente = e.getNewValue().toString();
		return "";
	}

	public String popularFilme(ValueChangeEvent e) {
		FilmeController filmeController = new FilmeController();

		String auxIndice = e.getNewValue().toString();
		listaFilme = filmeController.buscarDisponivel();
		filme = listaFilme.get(Integer.parseInt(auxIndice) - 1);
		this.nomeFilme = filme.getNome();
		if (filme.getPromocao().equals("sim")) {
			this.valorFilme = filme.getValorPromocao();

		} else {
			this.valorFilme = filme.getValor();
		}

		return "";
	}

	public String Alugado(ValueChangeEvent e) {
		FilmeController filmeController = new FilmeController();

		String auxIndice = e.getNewValue().toString();
		listaFilme = filmeController.buscarIndisponivel();
		filme = listaFilme.get(Integer.parseInt(auxIndice) - 1);
		this.nomeFilme = filme.getNome();
		if (filme.getPromocao().equals("nao")) {
			this.valorFilme = filme.getValorPromocao();

		} else {
			this.valorFilme = filme.getValor();
		}

		return "";
	}

	public String salvar() {

		if (validarDados()) {
			java.util.Date atual = new java.util.Date();
			java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");
			Locacao locacao = new Locacao();

			locacao.setNomeCliente(nomeCliente);
			locacao.setNomeFilme(nomeFilme);
			locacao.setValorFilme(valorFilme);
			locacao.setData(formater.format(atual));
			filme.setDisponivel("nao");

			LocacaoController lController = new LocacaoController();
			FilmeController fController = new FilmeController();
			try {
				lController.salvar(locacao);
				fController.salvar(filme);
				limparDados();
				JSFUtil.addInfoMessage("Locação salva com sucesso!");
			} catch (Exception e) {
				JSFUtil.addInfoMessage("Erro ao salvar a Locação!");

			}
		}
		return "salvar";
	}

	public boolean validarDados() {

		return true;
	}

	public String pesquisar() {
	
		
		
		listaLocacao = new ArrayList<Locacao>();

		LocacaoController controller = new LocacaoController();

		try {
			listaLocacao = controller.buscarNome(nomeCliente);
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao pesquisar o Filme!");
			
		}
		return "";
	}


	
	public String listarLocacao() {
		this.scrollerPage = 1;
		
		try {
			this.listaLocacao = new LocacaoController().buscarTodos();

		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao listar as locações");
		}
		return "";
	}

	
//	public String devolverFilme() {
//
//		codigo = locacaoSelecionado.getCodigo();
//		nomeCliente = locacaoSelecionado.getNomeCliente();
//		nomeFilme = locacaoSelecionado.getNomeFilme();
//		valorFilme = locacaoSelecionado.getValorFilme();
//		data = locacaoSelecionado.getData();
//		filmeSelecionado.getDisponivel();
//
//		return "devolver";
//	}
//
//	public String devolver() {
//
//		Filme filme = new Filme();
//		FilmeController controllerF = new FilmeController();
//		listaFilmeD = controllerF.buscarTodos();
//
//		if (validarDados()) {
//			java.util.Date atual = new java.util.Date();
//			java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");
//
//			locacao.setNomeCliente(nomeCliente);
//			locacao.setNomeFilme(nomeFilme);
//			locacao.setValorFilme(valorFilme);
//			locacao.setData(formater.format(atual));
//
//			for (Filme filmeD : listaFilmeD) {
//				if (filmeD.getNome().equals(nomeFilme)) {
//					filme.setDisponivel("sim");
//					controllerF.salvar(filme);
//				}
//			}
//
//			LocacaoController lController = new LocacaoController();
//
//			try {
//
//				lController.salvar(locacao);
//
//				limparDados();
//				JSFUtil.addInfoMessage("Devolução feita com sucesso!");
//			} catch (Exception e) {
//				JSFUtil.addInfoMessage("Erro ao Devolver!");
//
//			}
//		}
//
//		return "";
//	}
	
	
	

}
