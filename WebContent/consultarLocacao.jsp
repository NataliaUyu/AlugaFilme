<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta Locação</title>
</head>
<body class="backgroundTelaConsultaClienteLocacao">


	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>
		<center>

			<h:form id="formConsulta">
				<h:panelGrid columns="1">
					<h:messages />
				</h:panelGrid>
				<br>

				<h:panelGrid columns="3">
					<h:outputText style="color: white" value="Nome: " />
					<h:inputText value="#{locacaoBacking.nomeFilme}" maxlength="50"
						style="font-size: 15px" size="40" />
					<h:commandButton value="Pesquisar Locação"
						action="#{locacaoBacking.pesquisar}" />
				</h:panelGrid>
				<br>

				<h2 style="color: white">Lista de Locações Efetuadas</h2>

				<a4j:keepAlive beanName="locacaoBacking" ajaxOnly="true" />
				<rich:spacer height="30" />
				<rich:dataTable width="490" id="listaLocacao" rows="10"
					columnClasses="col" value="#{locacaoBacking.listaLocacao}"
					var="locacao">

					<f:facet name="header">
						<rich:columnGroup>
							<rich:column styleClass="corDaTabelaConsultaLocacao">
								<h:outputText value="Cliente" />
							</rich:column>
							<rich:column styleClass="corDaTabelaConsultaLocacao">
								<h:outputText value="Filme" />
							</rich:column>
							<rich:column styleClass="corDaTabelaConsultaLocacao">
								<h:outputText value="Valor" />
							</rich:column>
							<rich:column styleClass="corDaTabelaConsultaLocacao">
								<h:outputText value="Data" />
							</rich:column>

						</rich:columnGroup>
					</f:facet>

					<rich:column style="text-align:center">


						<h:outputText value="#{locacao.nomeCliente}" />
					</rich:column>
					<rich:column style="text-align:center">
						<h:outputText value="#{locacao.nomeFilme}" />
					</rich:column>
					<rich:column style="text-align:center">
						<h:outputText value="#{locacao.valorFilme}" />
					</rich:column>
					<rich:column style="text-align:center">
						<h:outputText value="#{locacao.data}" />
					</rich:column>
				</rich:dataTable>
				<br>

				<rich:datascroller align="center" for="listaLocacao" maxPages="20"
					page="#{locacaoBacking.scrollerPage}" id="sc2"
					reRender="listaLocacao" />
				<br>


				<h:panelGrid>
					<h:panelGrid columns="1">

						<h:commandButton value="Cancelar"
							action="#{locacaoBacking.cancelar}" />

					</h:panelGrid>
				</h:panelGrid>
			</h:form>
		</center>


	</f:view>

</body>
</html>