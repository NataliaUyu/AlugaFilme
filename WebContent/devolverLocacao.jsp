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

<title>Devolucao Locacao</title>
<link href="css/config.css" rel="stylesheet">
</head>
<body class="backgroundTelaDevolverLocacao">
	<f:view>
		<jsp:include page="/menu.jsp" />
		<h:form styleClass="telaAtrasDevolverLocacao">
		<center>
			<h1 style="color: white">Devolucao Locacao</h1>
			
			<h:panelGrid columns="1">
				<h:messages />
			</h:panelGrid>
			
			<h:panelGrid columns="2"  styleClass="combobox">
				<h:selectOneMenu id="comboFilme"  onchange="submit()" required="true"
					valueChangeListener="#{locacaoBacking.popularFilmeIndisponivel}"  styleClass="combobox">
					<f:selectItems value="#{filmeBacking.carregarFilmesComboIndisponivel()}"  />
				</h:selectOneMenu>
			</h:panelGrid>
			<br>
		

			<h:panelGrid>
				<h:panelGrid columns="3">
					<h:commandButton value="Ok" action="#{locacaoBacking.mudarIndisponivel}"  styleClass="buttonTelaCadastro"  />
							<h:commandButton value="Sair" action="#{locacaoBacking.retornar}"
						styleClass="buttonTelaCadastro" />
				</h:panelGrid>
			</h:panelGrid>
			</center>
		</h:form>

	</f:view>
</body>
</html>