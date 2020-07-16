package br.com.foursys.locadora.backingbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.controller.FilmeController;
import br.com.foursys.locadora.util.JSFUtil;
/**
 * @author nataliauyu
 * @author patrick
 * 08/04/2020
 * */
public class FilmeBacking {

	private int codigo;
	private String nome;
	private String genero;
	private double valor;
	private String disponivel;
	private String promocao;
	private double valorPromocao;

	private Filme filme;
	private Filme filmeSelecionado = new Filme();
	private List<SelectItem> itensFilmes;
	static List<Filme> listaFilme = new ArrayList<Filme>();
	static List<Filme> listaFilmeDevolucao= new ArrayList<Filme>();
	private Filme filmeDevolvidoSelecionado = new Filme();
	private int scrollerPage;
	private int qtdLinhas;
	private int paginaTotal;
	private List<Filme> listaFilmeTotal;
	private List<Filme> listaDevolucao;

	
	
	public Filme getFilmeDevolvidoSelecionado() {
		return filmeDevolvidoSelecionado;
	}

	public void setFilmeDevolvidoSelecionado(Filme filmeDevolvidoSelecionado) {
		this.filmeDevolvidoSelecionado = filmeDevolvidoSelecionado;
	}

	public List<Filme> getListaDevolucao() {
		return listaDevolucao;
	}

	public void setListaDevolucao(List<Filme> listaDevolucao) {
		this.listaDevolucao = listaDevolucao;
	}

	public List<SelectItem> getItensFilmes() {
		return itensFilmes;
	}

	public void setItensFilmes(List<SelectItem> itensFilmes) {
		this.itensFilmes = itensFilmes;
	}

	public static List<Filme> getListaFilmeDevolucao() {
		return listaFilmeDevolucao;
	}

	public static void setListaFilmeDevolucao(List<Filme> listaFilmeDevolucao) {
		FilmeBacking.listaFilmeDevolucao = listaFilmeDevolucao;
	}

	public int getScrollerPage() {
		return scrollerPage;
	}

	public void setScrollerPage(int scrollerPage) {
		this.scrollerPage = scrollerPage;
	}

	public int getQtdLinhas() {
		return qtdLinhas;
	}

	public void setQtdLinhas(int qtdLinhas) {
		this.qtdLinhas = qtdLinhas;
	}

	public int getPaginaTotal() {
		return paginaTotal;
	}

	public void setPaginaTotal(int paginaTotal) {
		this.paginaTotal = paginaTotal;
	}

	public List<Filme> getListaFilmeTotal() {
		return listaFilmeTotal;
	}

	public void setListaFilmeTotal(List<Filme> listaFilmeTotal) {
		this.listaFilmeTotal = listaFilmeTotal;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(String disponivel) {
		this.disponivel = disponivel;
	}

	public String getPromocao() {
		return promocao;
	}

	public void setPromocao(String promocao) {
		this.promocao = promocao;
	}

	public double getValorPromocao() {
		return valorPromocao;
	}

	public void setValorPromocao(double valorPromocao) {
		this.valorPromocao = valorPromocao;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Filme getFilmeSelecionado() {
		return filmeSelecionado;
	}

	public void setFilmeSelecionado(Filme filmeSelecionado) {
		this.filmeSelecionado = filmeSelecionado;
	}

	public String cadastrarFilme() {
		return "";
	}

	public String consultarFilme() {
		listarFilme();
		return "";
	}

	public String cancelar() {
		limparDados();
		return "cancelar";
	}
	
	public String consultaDevolucao() {
        listarDevolucao();
        return "";
    }
	
	
	public List<Filme> getListaFilme() {
		return listaFilme;
	}

	public void setListaFilme(List<Filme> listaFilme) {
		this.listaFilme = listaFilme;
	}

	public boolean validarDados() {
		if (nome.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o nome, campo obrigatório!");
			return false;
		}
		if (genero.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o genero, campo obrigatório!");
			return false;
		}
		if (valor == 0) {
			JSFUtil.addInfoMessage("Informe o valor, campo obrigatório!");
			return false;
		}
		if (disponivel.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o disponivel, campo obrigatório!");
			return false;
		}
		if (promocao.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o promocao, campo obrigatório!");
			return false;
		}
		if (valorPromocao == 0) {
			JSFUtil.addInfoMessage("Informe o valorPromocao, campo obrigatório!");
			return false;
		}
		return true;
	}

	public void limparDados() {
		nome = null;
		genero = null;
		valor = 0;
		disponivel = null;
		promocao = null;
		valorPromocao = 0;

	}

	public String salvar() {

		if (validarDados()) {
			Filme filme = new Filme();
			filme.setNome(nome);
			filme.setDisponivel(disponivel);
			filme.setGenero(genero);
			filme.setPromocao(promocao);
			filme.setValor(valor);
			filme.setValorPromocao(valorPromocao);
			
			FilmeController controller = new FilmeController();
			try {
				controller.salvar(filme);
				
				JSFUtil.addInfoMessage("Filme salvo com sucesso!!");
				limparDados();
			} catch (Exception e) {
				JSFUtil.addInfoMessage("Filme erro ao salvar!!");
			
			}

		}

		return "";

	}
	public String pesquisar() {
		listaFilme = new ArrayList<Filme>();

		FilmeController controller = new FilmeController();

		try {
			listaFilme = controller.buscarNome(nome);
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao pesquisar o Filme!");
			
		}
		return "";
	}

	public String excluir() {
		FilmeController controller = new FilmeController();

		try {
			controller.excluir(filmeSelecionado);
			pesquisar();
			JSFUtil.addInfoMessage("filme excluido com sucesso!");
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao excluir filme!");
			
		}

		return "";
	}

	public String alterarFilme() {

		codigo = filmeSelecionado.getCodigo();
		nome = filmeSelecionado.getNome();
		genero = filmeSelecionado.getGenero();
		valor = filmeSelecionado.getValor();
		disponivel = filmeSelecionado.getDisponivel();
		promocao = filmeSelecionado.getPromocao();
		valorPromocao = filmeSelecionado.getValorPromocao();

		return "alterar";
	}
	
	public String alterar() {

		if (validarDados()) {

			filmeSelecionado.setCodigo(codigo);
			filmeSelecionado.setNome(nome);
			filmeSelecionado.setGenero(genero);
			filmeSelecionado.setValor(valor);
			filmeSelecionado.setDisponivel(disponivel);
			filmeSelecionado.setPromocao(promocao);
			filmeSelecionado.setValorPromocao(valorPromocao);
			
			FilmeController controller = new FilmeController();
			

			try {
				controller.salvar(filmeSelecionado);
				limparDados();
				JSFUtil.addInfoMessage("Filme alterado com sucesso!");
			} catch (Exception e) {
				JSFUtil.addInfoMessage("Erro ao alterado o Filme!");
				
			}

		}

		return "";
	}
	
	
	public String listarFilme() {
		this.scrollerPage = 1;
	
		try {
			this.listaFilme = new FilmeController().buscarTodos();

		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao listar os Filmes");
		}
		return "";
	}
	
	
	
	
	
	public void pegarFilmes() {
		itensFilmes = new ArrayList<SelectItem>();
		int i = 1;
		List<Filme> listaFilmes = new FilmeController().buscarDisponivel();
		itensFilmes.add(new SelectItem("0", "Selecione um Filme"));
		
		for (Filme filme : listaFilmes) {
			listaFilme.add(filme);
			itensFilmes.add(new SelectItem(i+"",filme.getNome()));
			i++;	
		}
		
	}
	
	public List<SelectItem> carregarFilmesCombo(){
		pegarFilmes();
		return itensFilmes;
	}

	
	public void carregarFilmes() {
		
		listaFilmeDevolucao = new ArrayList<Filme>();
		int cont = 0;
		int contFilme = 0;
		for (Filme filme: this.listaDevolucao) {
			contFilme++;
			if (cont == this.qtdLinhas)
				break;
			if ((contFilme <= (this.qtdLinhas * this.scrollerPage))
					&& (contFilme > (this.qtdLinhas * (this.scrollerPage - 1)))) {
				listaFilmeDevolucao.add(filme);
				cont++;
			}

		}

	}
	public String devolver() {
		FilmeController controller = new FilmeController();
		
		try {
			filmeDevolvidoSelecionado.setDisponivel("sim");
			controller.salvar(filmeDevolvidoSelecionado);
			JSFUtil.addInfoMessage("Devolução efetuada com sucesso!");

		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao devolver!");

		}
		
		return"";
		
	}
	
	public String listarDevolucao() {
        this.scrollerPage = 1;
        this.qtdLinhas = 10;

 

        try {
            this.listaFilmeDevolucao = new FilmeController().buscarTodos();

 

            if (this.listaFilmeDevolucao.size() % 10 == 0) {
                this.paginaTotal = this.listaFilmeDevolucao.size() / 10;
            } else {
                this.paginaTotal = (this.listaFilmeDevolucao.size() / 10) + 1;
            }
            carregaLocacao();
        } catch (Exception e) {
            JSFUtil.addInfoMessage("Erro ao listar Devoluções!");
        }

 

        return "";
    }

 

    public void carregaLocacao() {
        listaFilmeDevolucao = new ArrayList<Filme>();
        int contador = 0;
        int contFilme = 0;

 

        for (Filme filme : this.listaDevolucao) {
            if (filme.getDisponivel().equals("NÃO")) {

 

                contFilme++;
                if (contador == this.qtdLinhas)
                    break;

 

                if ((contFilme <= (this.qtdLinhas * this.scrollerPage))
                        && (contFilme > (this.qtdLinhas * (this.scrollerPage - 1)))) {
                    listaFilmeDevolucao.add(filme);
                    contador++;

 

                }
            }
        }
    }
    
    public void trartarFilmesIndisponivel() {
		itensFilmes = new ArrayList<SelectItem>();
		int i = 1;
		List<Filme> listaFilmes = new FilmeController().buscarIndisponivel();
		itensFilmes.add(new SelectItem("0", "Selecione um Filme"));

		for (Filme filme : listaFilmes) {
			listaFilme.add(filme);
			itensFilmes.add(new SelectItem(i + "", filme.getNome()));
			i++;
		}

	}

	public List<SelectItem> carregarFilmesComboIndisponivel() {
		trartarFilmesIndisponivel();
		return itensFilmes;
	}
	
}
