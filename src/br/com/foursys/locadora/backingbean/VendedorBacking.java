package br.com.foursys.locadora.backingbean;

import java.util.ArrayList;
import java.util.List;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.bean.Vendedor;
import br.com.foursys.locadora.controller.FilmeController;
import br.com.foursys.locadora.controller.VendedorController;
import br.com.foursys.locadora.util.JSFUtil;
/**
 * @author nataliauyu
 * @author patrick
 * 08/04/2020
 * */
public class VendedorBacking {
	private int codigo;
	private String nome;
	private String areaVenda;
	private String cidade;
	private String estado;
	private String sexo;
	private int idade;
	private double salario;
	private Vendedor vendedor = new Vendedor();
	private Vendedor vendedorSelecionado = new Vendedor();
	private List<Vendedor> listaVendedor;

	private int scrollerPage;

	
	
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

	public String getAreaVenda() {
		return areaVenda;
	}

	public void setAreaVenda(String areaVenda) {
		this.areaVenda = areaVenda;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Vendedor getVendedorSelecionado() {
		return vendedorSelecionado;
	}

	public void setVendedorSelecionado(Vendedor vendedorSelecionado) {
		this.vendedorSelecionado = vendedorSelecionado;
	}

	public String cadastrarVendedor() {
		return "";
	}

	public String consultarVendedor() {
		listarVendedor();
		return "";
	}

	public String cancelar() {
		limparDados();
		return "cancelar";
	}

	public List<Vendedor> getListaVendedor() {
		return listaVendedor;
	}
	
	public int getScrollerPage() {
		return scrollerPage;
	}

	public void setScrollerPage(int scrollerPage) {
		this.scrollerPage = scrollerPage;
	}


	public String salvar() {
		Vendedor vendedor = new Vendedor();

		if (validarDados()) {
			vendedor.setNome(nome);
			vendedor.setAreaVenda(areaVenda);
			vendedor.setCidade(cidade);
			vendedor.setEstado(estado);
			vendedor.setSexo(sexo);
			vendedor.setIdade(idade);
			vendedor.setSalario(salario);

			
			VendedorController controller = new VendedorController();

			try {
				controller.salvar(vendedor);
			
				limparDados();
				JSFUtil.addInfoMessage("Vendedor salvo com sucesso!");
			} catch (Exception e) {
				JSFUtil.addInfoMessage("Erro ao inserir o vendedor!");
				
			}

		}
		return "";
	}

	public void limparDados() {
		nome = null;
		areaVenda = null;
		cidade = null;
		estado = null;
		sexo = null;
		idade = 0;
		salario = 0;
	}

	public boolean validarDados() {
		if (nome.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o nome, campo obrigatório!");
			return false;
		}

		if (areaVenda.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o logradouro, campo obrigatório!");
			return false;
		}

		if (cidade.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o cidade, campo obrigatório!");
			return false;
		}

		if (estado.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o estado, campo obrigatório!");
			return false;
		}

		if (sexo.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o sexo, campo obrigatório!");
			return false;
		}

		if (idade == 0) {
			JSFUtil.addInfoMessage("Informe a idade, campo obrigatório!");
			return false;
		}
		
		if (salario == 0) {
			JSFUtil.addInfoMessage("Informe o salário, campo obrigatório!");
			return false;
		}

		return true;
	}
	
	public String pesquisar() {
		this.scrollerPage = 1;
		

		listaVendedor = new ArrayList<Vendedor>();

		VendedorController controller = new VendedorController();
		
		try {
			this.listaVendedor = new VendedorController().buscarNome(nome);
			
			
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao listar os Vendedores");
		}
		return "";
	}
	
	public String excluir() {
		VendedorController controller = new VendedorController();

		
		try {
			controller.excluir(vendedorSelecionado);
		
			pesquisar();
			JSFUtil.addInfoMessage("Vendedor excluído com sucesso!");
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao excluir o vendedor!");
		
		}
		return "";
	}
	
	public String alteraVendedor() {
		codigo = vendedorSelecionado.getCodigo();
		nome = vendedorSelecionado.getNome();
		areaVenda = vendedorSelecionado.getAreaVenda();
		cidade = vendedorSelecionado.getCidade();
		estado = vendedorSelecionado.getEstado();
		sexo = vendedorSelecionado.getSexo() + "";
		idade = vendedorSelecionado.getIdade();
		salario = vendedorSelecionado.getSalario();
		return "alterar";
	}
	
	public String alterar() {
		if (validarDados()) {
			vendedorSelecionado.setCodigo(codigo);
			vendedorSelecionado.setNome(nome);
			vendedorSelecionado.setAreaVenda(areaVenda);
			vendedorSelecionado.setCidade(cidade);
			vendedorSelecionado.setEstado(estado);
			vendedorSelecionado.setSexo(sexo);
			vendedorSelecionado.setIdade(idade);
			vendedorSelecionado.setSalario(salario);

			VendedorController controller = new VendedorController();

			try {
				controller.salvar(vendedorSelecionado);
		
				limparDados();
				JSFUtil.addInfoMessage("Vendedor alterado com sucesso!");
			} catch (Exception e) {
				JSFUtil.addInfoMessage("Erro ao alterar o Vendedor!");
				
			}

		}		
		return "";
	}

	
	
	public String listarVendedor() {
		this.scrollerPage = 1;
	
		
		try {
			this.listaVendedor = new VendedorController().buscarTodos();
			
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao listar os Vendedores");
		}
		return "";
	}
	
	
	
} // fim da classe
