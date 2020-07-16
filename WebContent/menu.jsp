<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Locadora</title>

<link href="css/config.css" rel="stylesheet">

</head>
<body class="backgroundTelaPrincipal">





	<div>

		<f:subview id="view">

			<h:form id="menu">


				<rich:toolBar styleClass="corBarraMenu">


					<rich:dropDownMenu value="Cadastro" styleClass="corBarraMenu">

						<rich:menuItem id="menu1" value="Filme"
							action="#{filmeBacking.cadastrarFilme}" styleClass="corBarraMenu">
						</rich:menuItem>

						<rich:menuItem id="menu2" value="Cliente"
							action="#{clienteBacking.cadastrarCliente}"
							styleClass="corBarraMenu">
						</rich:menuItem>

						<rich:menuItem id="menu3" value="Vendedor"
							action="#{vendedorBacking.cadastrarVendedor}"
							styleClass="corBarraMenu">
						</rich:menuItem>

					</rich:dropDownMenu>


					<rich:dropDownMenu value="Consulta" styleClass="corBarraMenu">

						<rich:menuItem id="menu4" value="Filme"
							action="#{filmeBacking.consultarFilme}" styleClass="corBarraMenu">
						</rich:menuItem>

						<rich:menuItem id="menu5" value="Cliente"
							action="#{clienteBacking.consultarCliente}"
							styleClass="corBarraMenu">
						</rich:menuItem>

						<rich:menuItem id="menu6" value="Vendedor"
							action="#{vendedorBacking.consultarVendedor}"
							styleClass="corBarraMenu">
						</rich:menuItem>

						<rich:menuItem id="menu7" value="Loca��o"
							action="#{locacaoBacking.consultarLocacao}"
							styleClass="corBarraMenu">
						</rich:menuItem>

					</rich:dropDownMenu>

					<rich:dropDownMenu value="Loca��o" styleClass="corBarraMenu">

						<rich:menuItem id="menu8" value="Efetuar Loca��o"
							action="#{locacaoBacking.efetuarLocacao}"
							styleClass="corBarraMenu">
						</rich:menuItem>

						<rich:menuItem id="menu9" value="Devolu��o Loca��o"
							action="#{filmeBacking.consultaDevolucao}"
							styleClass="corBarraMenu">
						</rich:menuItem>

					</rich:dropDownMenu>

					<rich:dropDownMenu value="Relat�rio" styleClass="corBarraMenu">

						<rich:menuItem id="menu10" value="Relat�rio de Filmes"
							action="#{relatorioBacking.relatorioFilme}"
							styleClass="corBarraMenu">
						</rich:menuItem>

						<rich:menuItem id="menu11" value="Relat�rio de Clientes"
							action="#{relatorioBacking.relatorioCliente}"
							styleClass="corBarraMenu">
						</rich:menuItem>

						<rich:menuItem id="menu12" value="Relat�rio de Vendedores"
							action="#{relatorioBacking.relatorioVendedor}"
							styleClass="corBarraMenu">
						</rich:menuItem>

					</rich:dropDownMenu>







				</rich:toolBar>

			</h:form>

		</f:subview>



	</div>
</body>
</html>