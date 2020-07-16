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
<title>Consulta de Filme</title>
</head>
<body class="backgroundTelaConsultaFilme">


	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>



		<h:form id="formConsulta">
			<h:panelGrid columns="1">
				<h:messages />
			</h:panelGrid>
			<br>

			<center>

				<h:panelGrid columns="3">
					<h:outputText style="color: white" value="Nome: " />
					<h:inputText value="#{filmeBacking.nome}" maxlength="50" size="40" />
					<h:commandButton value="Pesquisar Filme"
						action="#{filmeBacking.pesquisar}" />
				</h:panelGrid>
				<br>

				<h2 style="color: white">Lista de Filmes Cadastrados</h2>

				<a4j:keepAlive beanName="filmeBacking" ajaxOnly="true" />
				<rich:spacer height="30" />
				<rich:dataTable width="490" id="listaFilme" rows="10"
					columnClasses="col" value="#{filmeBacking.listaFilme}" var="filme">




					<f:facet name="header">
						<rich:columnGroup>
							<rich:column styleClass="corTabelaConsultaFilme">
								<h:outputText value="Nome" />
							</rich:column>
							<rich:column styleClass="corTabelaConsultaFilme">
								<h:outputText value="Gênero" />
							</rich:column>
							<rich:column styleClass="corTabelaConsultaFilme">
								<h:outputText value="Valor" />
							</rich:column>
							<rich:column styleClass="corTabelaConsultaFilme">
								<h:outputText value="Disponivel" />
							</rich:column>
							<rich:column styleClass="corTabelaConsultaFilme">
								<h:outputText value="Promoção" />
							</rich:column>
							<rich:column colspan="2" styleClass="corTabelaConsultaFilme">
								<h:outputText value="Ações" />
							</rich:column>
						</rich:columnGroup>
					</f:facet>

					<rich:column style="text-align:center">
						<h:outputText value="#{filme.nome}" />
					</rich:column>
					<rich:column style="text-align:center">
						<h:outputText value="#{filme.genero}" />
					</rich:column>
					<rich:column style="text-align:center">
						<h:outputText value="#{filme.valor}" />
					</rich:column>
					<rich:column style="text-align:center">
						<h:outputText value="#{filme.disponivel}" />
					</rich:column>
					<rich:column style="text-align:center">
						<h:outputText value="#{filme.promocao}" />
					</rich:column>

					<rich:column style="text-align:center">
						<h:commandLink value="Alterar"
							action="#{filmeBacking.alterarFilme}">
							<f:setPropertyActionListener value="#{filme}"
								target="#{filmeBacking.filmeSelecionado}" />
						</h:commandLink>
					</rich:column>

					<rich:column style="text-align:center">
						<h:commandLink value="Excluir" action="#{filmeBacking.excluir}">
							<f:setPropertyActionListener value="#{filme}"
								target="#{filmeBacking.filmeSelecionado}" />
						</h:commandLink>
					</rich:column>
				</rich:dataTable>


				<rich:datascroller align="center" for="listaFilme" maxPages="20"
					page="#{filmeBacking.scrollerPage}" id="sc2" reRender="listaFilme" />
				<br>



				<h:panelGrid columns="1">
					<h:commandButton style="margin-right: 15px" value="Cancelar"
						action="#{filmeBacking.cancelar}" />
				</h:panelGrid>
			</center>

		</h:form>
	</f:view>

</body>
</html>