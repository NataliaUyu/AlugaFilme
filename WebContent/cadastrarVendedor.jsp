<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/mascara.js"></script>

<title>Cadastro de Vendedor</title>
<link href="css/config.css" rel="stylesheet">
</head>
<body class="backgroundTelaCadastroVendedor">
	

	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>
		<h:form styleClass="cadastroVendedor">
		<center>
			<h2 style="color: white"> Cadastro de Vendedor</h2>
			
			<h:panelGrid columns="1">
				<h:messages />
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText style="color: white" value="Nome: " />
				<h:inputText  style="horizontal-align:center" value="#{vendedorBacking.nome}" maxlength="50" size="50" />			
			</h:panelGrid>
			
			
			<h:panelGrid columns="2">
				<h:outputText style="color: white" value="Area Venda: " />
				<h:inputText value="#{vendedorBacking.areaVenda}" maxlength="50" size="44" />			
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText style="color: white" value="Cidade: " />
				<h:inputText value="#{vendedorBacking.cidade}" maxlength="50" size="49" />			
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText style="color: white" value="Estado: " />
				<h:inputText value="#{vendedorBacking.estado}" maxlength="50" size="49" />			
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText style="color: white" value="Sexo: " />	
				<h:selectOneRadio style="color: white" value="#{vendedorBacking.sexo}">
					<f:selectItem itemValue="F" itemLabel="Feminino"/>
					<f:selectItem itemValue="M"  itemLabel="Masculino" />
				</h:selectOneRadio>		
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText style="color: white" value="Idade: " />
				<h:inputText value="#{vendedorBacking.idade}" maxlength="50" size="50" onkeyup="masc_numero(this)"/>			
			</h:panelGrid>
		
		<h:panelGrid columns="2">
				<h:outputText style="color: white" value="Salário: " />
				<h:inputText value="#{vendedorBacking.salario}" maxlength="50" size="48" onkeyup="masc_numero(this)"/>			
			</h:panelGrid>
		
			<h:panelGrid>
				<h:panelGrid columns="2">
					<h:commandButton  style="margin-right: 15px"  value="Salvar" action="#{vendedorBacking.salvar}"/>
					<h:commandButton value="Cancelar" action="#{vendedorBacking.cancelar}"/>
				</h:panelGrid>			
			</h:panelGrid>
			</center>
		</h:form>
		
	</f:view>

</body>
</html>