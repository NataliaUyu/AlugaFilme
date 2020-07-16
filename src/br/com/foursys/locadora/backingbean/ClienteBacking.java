package br.com.foursys.locadora.backingbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.foursys.locadora.bean.Cliente;
import br.com.foursys.locadora.controller.ClienteController;
import br.com.foursys.locadora.util.JSFUtil;

/**
 * @author nataliauyu
 * @author patrick
 * 08/04/2020
 * */
public class ClienteBacking {

	private int codigo;
	private String nome;
	private String logradouro;
	private int numeroLogradouro;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String telefone;
	private String cpf;
	private String rg;
	private String sexo;
	private String dataNascimento;
	private int idade;

	private Cliente cliente = new Cliente();
	private Cliente clienteSelecionado = new Cliente();
	private List<SelectItem> itensClientes;
	private List<Cliente> listaCliente = new ArrayList<Cliente>();

	private int scrollerPage;
	


	public int getScrollerPage() {
		return scrollerPage;
	}

	public void setScrollerPage(int scrollerPage) {
		this.scrollerPage = scrollerPage;
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumeroLogradouro() {
		return numeroLogradouro;
	}

	public void setNumeroLogradouro(int numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public String cadastrarCliente() {
		return "";
	}

	public String consultarCliente() {
		listarCliente();
		return "";
	}

	public String cancelar() {
		limparDados();
		return "cancelar";
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public String salvar() {

		Cliente cliente = new Cliente();
		if (validarDados()) {

			cliente.setNome(nome);
			cliente.setLogradouro(logradouro);
			cliente.setNumeroLogradouro(numeroLogradouro);
			cliente.setBairro(bairro);
			cliente.setCidade(cidade);
			cliente.setEstado(estado);
			cliente.setCep(cep);
			cliente.setTelefone(telefone);
			cliente.setCpf(cpf);
			cliente.setRg(rg);
			cliente.setSexo(sexo);
			cliente.setDataNascimento(dataNascimento);
			cliente.setIdade(idade);

			ClienteController controller = new ClienteController();

			try {
				controller.salvar(cliente);
				limparDados();
				JSFUtil.addInfoMessage("Cliente salvo com sucesso!");
			} catch (Exception e) {
				JSFUtil.addInfoMessage("Erro ao inserir o cliente!");

			}

		}

		return "";
	}

	public void limparDados() {
		nome = null;
		logradouro = null;
		numeroLogradouro = 0;
		bairro = null;
		cidade = null;
		estado = null;
		cep = null;
		telefone = null;
		cpf = null;
		rg = null;
		sexo = null;
		dataNascimento = null;
		idade = 0;
	}

	public boolean validarDados() {
		if (nome.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o nome, campo obrigat�rio!");
			return false;
		}
		if (logradouro.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o logradouro, campo obrigat�rio!");
			return false;
		}
		if (numeroLogradouro == 0) {
			JSFUtil.addInfoMessage("Informe o numero, campo obrigat�rio!");
			return false;
		}
		if (bairro.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o bairro, campo obrigat�rio!");
			return false;
		}
		if (cidade.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o cidade, campo obrigat�rio!");
			return false;
		}
		if (estado.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o estado, campo obrigat�rio!");
			return false;
		}
		if (cep.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o cep, campo obrigat�rio!");
			return false;
		}
		if (telefone.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o telefone, campo obrigat�rio!");
			return false;
		}
		if (cpf.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o cpf, campo obrigat�rio!");
			return false;
		}
		if (rg.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o rg, campo obrigat�rio!");
			return false;
		}
		if (sexo.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o sexo, campo obrigat�rio!");
			return false;
		}
		if (dataNascimento.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o nascimento, campo obrigat�rio!");
			return false;
		}
		if (idade == 0) {
			JSFUtil.addInfoMessage("Informe a idade, campo obrigat�rio!");
			return false;
		}
		return true;
	}

	public String excluir() {

		ClienteController controller = new ClienteController();
		try {
			controller.excluir(clienteSelecionado);

			pesquisar();
			JSFUtil.addInfoMessage("Cliente excluido com sucesso!");
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao excluir Cliente!");

		}

		return "";
	}

	public String alteraCliente() {
		codigo = clienteSelecionado.getCodigo();
		nome = clienteSelecionado.getNome();
		logradouro = clienteSelecionado.getLogradouro();
		numeroLogradouro = clienteSelecionado.getNumeroLogradouro();
		bairro = clienteSelecionado.getBairro();
		cidade = clienteSelecionado.getCidade();
		estado = clienteSelecionado.getEstado();
		cep = clienteSelecionado.getCep();
		telefone = clienteSelecionado.getTelefone();
		cpf = clienteSelecionado.getCpf();
		rg = clienteSelecionado.getRg();
		sexo = clienteSelecionado.getSexo() + "";
		dataNascimento = clienteSelecionado.getDataNascimento();
		idade = clienteSelecionado.getIdade();

		return "alterar";
	}

	public String alterar() {

		if (validarDados()) {

			clienteSelecionado.setCodigo(codigo);
			clienteSelecionado.setNome(nome);
			clienteSelecionado.setLogradouro(logradouro);
			clienteSelecionado.setNumeroLogradouro(numeroLogradouro);
			clienteSelecionado.setBairro(bairro);
			clienteSelecionado.setCidade(cidade);
			clienteSelecionado.setEstado(estado);
			clienteSelecionado.setCep(cep);
			clienteSelecionado.setTelefone(telefone);
			clienteSelecionado.setCpf(cpf);
			clienteSelecionado.setRg(rg);
			clienteSelecionado.setSexo(sexo);
			clienteSelecionado.setDataNascimento(dataNascimento);
			clienteSelecionado.setIdade(idade);

			ClienteController controller = new ClienteController();

			try {
				controller.salvar(clienteSelecionado);

				limparDados();
				JSFUtil.addInfoMessage("Cliente alterado com sucesso!");
			} catch (Exception e) {
				JSFUtil.addInfoMessage("Erro ao alterar o cliente!");

			}

		}

		return "";
	}

	public String pesquisar() {
		this.scrollerPage = 1;	

		try {
			this.listaCliente = new ClienteController().buscarNome(nome);

			
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao listar os Clientes !");
		}
		return "";
	}

	public String listarCliente() {
		this.scrollerPage = 1;
		

		try {
			this.listaCliente = new ClienteController().buscarTodos();

		
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao listar os Clientes!");
		}
		return "";
	}

	



	public void tratarCliente() {
		itensClientes = new ArrayList<SelectItem>();
		int i = 1;
		List<Cliente> listaClientes = new ClienteController().buscarTodos();
		
		for (Cliente cliente : listaClientes) {
			listaCliente.add(cliente);
			itensClientes.add(new SelectItem(cliente.getNome(),cliente.getNome()));
			i++;
		}

	}

	public List<SelectItem> carregarClientesCombo() {
		tratarCliente();
		return itensClientes;
	}
}