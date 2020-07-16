<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/mascara.js"></script>

<title>Alteração de Vendedor</title>
</head>
<body class="backgroundTelaAlterarVendedor">

	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>
		<h:form>
	<center>	
			<h1>Alteração de Vendedor</h1>
			
			<h:panelGrid columns="1">
				<h:messages />
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText value="Nome: " />
				<h:inputText value="#{vendedorBacking.nome}" maxlength="50" size="50" readonly="true"/>			
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText value="Area Venda: " />
				<h:inputText value="#{vendedorBacking.areaVenda}" maxlength="50" size="44" />			
			</h:panelGrid>
	
			<h:panelGrid columns="2">
				<h:outputText value="Cidade: " />
				<h:inputText value="#{vendedorBacking.cidade}" maxlength="50" size="49" />			
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText value="Estado: " />
				<h:inputText value="#{vendedorBacking.estado}" maxlength="50" size="49" />			
			</h:panelGrid>
					
				<h:panelGrid columns="2">
				<h:outputText value="Sexo: " />
				<h:selectOneRadio value="#{vendedorBacking.sexo}" disabled="true">
					<f:selectItem itemValue="F" itemLabel="Feminino"/>
					<f:selectItem itemValue="M" itemLabel="Masculino"/>
				</h:selectOneRadio>		
			</h:panelGrid>
			
			
			<h:panelGrid columns="2">
				<h:outputText value="Idade: " />
				<h:inputText value="#{vendedorBacking.idade}" maxlength="50" size="50" readonly="true" onkeyup="masc_numero(this)" />			
			</h:panelGrid>
		
		<h:panelGrid columns="2">
				<h:outputText value="Salário: " />
				<h:inputText value="#{vendedorBacking.salario}" maxlength="50" size="48" onkeyup="masc_numero(this)"/>			
			</h:panelGrid>
			
			<h:panelGrid>
				<h:panelGrid columns="2">
					<h:commandButton style="margin: 30px"  value="Alterar"  action="#{vendedorBacking.alterar}"/>
					<h:commandButton value="Cancelar" action="#{vendedorBacking.cancelar}"/>
				</h:panelGrid>			
			</h:panelGrid>
			</center>
		</h:form>
		
	</f:view>

</body>
</html>