<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/mascara.js"></script>

<title>Efetuar Locacao</title>
<link href="css/config.css" rel="stylesheet">

</head>


<body class="backgroundTelaEfetuarLocacao">



	<f:view>
		<jsp:include page="/menu.jsp"/>
		<h:form styleClass="cadastro">

			<center>
				<h1 style="color: white">Efetuar Locacao</h1>

				<h:panelGrid columns="1">
					<h:messages />
				</h:panelGrid>

				<f:facet name="caption">
					<h:outputText value="Lista de Clientes" />
				</f:facet>


				<h:panelGrid columns="2" styleClass="combobox">
					<h:selectOneMenu id="comboCliente" required="true"
						onchange="submit()"
						valueChangeListener="#{locacaoBacking.popularCliente}"
						styleClass="combobox">
						<f:selectItem itemValue="#{null}" itemLabel="Selecione um Cliente" />
						<f:selectItems value="#{clienteBacking.carregarClientesCombo()}" />
					</h:selectOneMenu>
				</h:panelGrid>
				<br>

				<h:panelGrid columns="2" styleClass="combobox">
					<h:selectOneMenu id="comboFilme" required="true"
						onchange="submit()"
						valueChangeListener="#{locacaoBacking.popularFilme}"
						styleClass="combobox">
						<f:selectItem itemValue="#{null}" itemLabel="Selecione um Filme" />
						<f:selectItems value="#{filmeBacking.carregarFilmesCombo()}" />
					</h:selectOneMenu>
				</h:panelGrid>


				<h:panelGrid columns="2">
					<h:outputText style="color: white" value="Filme: "
						styleClass="labelNomeFilme" />
					<h:outputText id="nomeFilme" value="#{locacaoBacking.nomeFilme}"
						style="color: white" styleClass="labelNomeFilme1" />
				</h:panelGrid>
				<center>
					<h:panelGrid columns="2">
						<h:outputText style="color: white" value="Cliente: "
							styleClass="labelNomeCliente" />
						<f:selectItem itemValue="#{null}" itemLabel="Selecione um cliente" />
						<h:outputText id="nomeCliente"
							value="#{locacaoBacking.nomeCliente}"
							styleClass="correcaoEfetuarLocacao"
							style="color: white;
    position: absolute;
    margin-left: 58px;
    margin-top: -22px;" />
					</h:panelGrid>
				</center>
				<h:panelGrid columns="2">
					<h:outputText style="color: white" value="Valor: "
						styleClass="labelValor" />

					<h:outputText id="valor" value="#{locacaoBacking.valorFilme}"
						style="color: white" styleClass="labelValor1" />
				</h:panelGrid>

				<h:panelGrid columns="3">
					<h:commandButton value="Cancelar"
						action="#{locacaoBacking.efetuarLocacao}" />
					<h:commandButton value="Salvar" action="#{locacaoBacking.salvar}" />
					<h:commandButton value="Sair" action="#{locacaoBacking.sair}" />
				</h:panelGrid>
			</center>

		</h:form>
	</f:view>

</body>
</html>