<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/mascara.js"></script>

<title>Cadastro de Filme</title>
<link href="css/config.css" rel="stylesheet">
</head>
<body class="backgroundTelaCadastroFilme">

	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>
		<h:form styleClass="cadastro">
		
		<center>
			<h1 style="color: white;">Cadastro de Filme </h1>
			
			<h:panelGrid columns="1">
				<h:messages />
			</h:panelGrid>
		</center>	
		
		<center>
			<h:panelGrid columns="2">
				<h:outputText style="color: white;" value="Nome:  " />
				<h:inputText value="#{filmeBacking.nome}" maxlength="50" size="40" />			
			</h:panelGrid>
	
		
			<h:panelGrid columns="2">
				<h:outputText style="color: white;" value="Gênero: " />
				<h:inputText value="#{filmeBacking.genero}" maxlength="50" size="39" />			
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText style="color: white;" value="Valor: " />
				<h:inputText value="#{filmeBacking.valor}" maxlength="50" size="41" 
								onkeyup="masc_numero(this)" />			
			</h:panelGrid>
				</center>
		
			<center>
			<h:panelGrid columns="2">
			
				<h:outputText style="color: white;" value="Disponível: " />
				<h:selectOneRadio  style="color: white;" value="#{filmeBacking.disponivel}">
					<f:selectItem  itemValue="SIM" itemLabel="SIM" />
					<f:selectItem  itemValue="NÃO" itemLabel="NÃO"/>
				</h:selectOneRadio>		
					
			</h:panelGrid>
			</center>
			
			<center>
			<h:panelGrid columns="2">
				<h:outputText style="color: white;" value="Promoção: " />
				<h:selectOneRadio style="color: white;" value="#{filmeBacking.promocao}">
					<f:selectItem  itemValue="sim" itemLabel="SIM"/>
					<f:selectItem  itemValue="nao" itemLabel="NÃO"/>
				</h:selectOneRadio>		
			</h:panelGrid>
			</center>
			
			<center>
			<h:panelGrid columns="2">
				<h:outputText style="color: white;" value="Valor Promoção: " />
				<h:inputText value="#{filmeBacking.valorPromocao}" maxlength="50" size="29" 
								onkeyup="masc_numero(this)"  />			
			</h:panelGrid><br>
			</center>
		
		<center>
			<h:panelGrid>
				<h:panelGrid columns="2">
					<h:commandButton style="margin-right: 20px"  value="Salvar" action="#{filmeBacking.salvar}" styleClass="button1"/>
					<h:commandButton value="Cancelar" action="#{filmeBacking.cancelar}" styleClass="button1"/>
				</h:panelGrid>			
			</h:panelGrid>
		</center>
		</h:form>
		
	</f:view>

</body>
</html>