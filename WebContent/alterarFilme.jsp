<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/mascara.js"></script>

<title>Alteração de Filmes</title>
</head>
<body class="backgroundTelaAlterarFilme">

	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>
		<h:form>
	<center>	
			<h1>Alteração de Filmes</h1>
			
			<h:panelGrid columns="1">
				<h:messages />
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText value="Nome: " />
				<h:inputText value="#{filmeBacking.nome}" maxlength="50" size="43" readonly="true"/>			
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText value="Gênero: " />
				<h:inputText value="#{filmeBacking.genero}" maxlength="50" size="42" readonly="true"/>			
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText value="Valor: " />
				<h:inputText value="#{filmeBacking.valor}" maxlength="50" size="44" 
								onkeyup="masc_numero(this)" />			
			</h:panelGrid>
			
		
			<h:panelGrid columns="2">
				<h:outputText value="Disponível: " />
				<h:selectOneRadio value="#{filmeBacking.disponivel}" >
					<f:selectItem itemValue="sim" itemLabel="SIM"/>
					<f:selectItem itemValue="nao" itemLabel="NAO"/>
				</h:selectOneRadio>		
			</h:panelGrid>
			
		   <h:panelGrid columns="2">
				<h:outputText value="Promoção: " />
				<h:selectOneRadio value="#{filmeBacking.promocao}" >
					<f:selectItem itemValue="sim" itemLabel="SIM"/>
					<f:selectItem itemValue="nao" itemLabel="NAO"/>
				</h:selectOneRadio>		
			</h:panelGrid>
			
		<h:panelGrid columns="2">
				<h:outputText value="Valor da Promoção: " />
				<h:inputText value="#{filmeBacking.valorPromocao}" maxlength="50" size="28" onkeyup="masc_numero(this)"/>			
			</h:panelGrid><br>
		
			<h:panelGrid>
				<h:panelGrid columns="2">
					<h:commandButton style="margin: 30px" value="Alterar" action="#{filmeBacking.alterar}"/>
					<h:commandButton value="Cancelar" action="#{filmeBacking.cancelar}"/>
				</h:panelGrid>			
			</h:panelGrid>
			</center>
		</h:form>
		
	</f:view>

</body>
</html>