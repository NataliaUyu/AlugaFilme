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
<title>Consulta de Vendedor</title>
</head>
<body class="backgroundTelaConsultaVendedor">


	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>
	<center>
		

			<h:form id="formConsulta">
            <h:panelGrid columns="1">
                <h:messages />
			</h:panelGrid>	<br>

			<h:panelGrid columns="3">
				<h:outputText style="color: white" value="Nome: " />
				<h:inputText value="#{vendedorBacking.nome}" maxlength="50" size="40" />
				<h:commandButton  value="Pesquisar Vendedor" 
					action="#{vendedorBacking.pesquisar}" /><br>
			</h:panelGrid>
			
			<h2 style="color: white">Lista de Vendedores Cadastrados</h2>
			
			<a4j:keepAlive beanName="vendedorBacking" ajaxOnly="true" />
                <rich:spacer height="30" />
                <rich:dataTable width="490" id="listaVendedor" rows="10"
                    columnClasses="col" value="#{vendedorBacking.listaVendedor}"
                    var="vendedor">

					
			<f:facet name="header">
						<rich:columnGroup>
							<rich:column  styleClass="corDaTabelaConsultaVendedor">
								<h:outputText value="Nome" />
							</rich:column>
							<rich:column styleClass="corDaTabelaConsultaVendedor">
								<h:outputText value="Area Venda" />
							</rich:column>
							<rich:column styleClass="corDaTabelaConsultaVendedor">
								<h:outputText value="Salário" />
							</rich:column>
							<rich:column colspan="2" styleClass="corDaTabelaConsultaVendedor">
								<h:outputText value="Ações" />
							</rich:column>
						</rich:columnGroup>
					</f:facet> 

					<rich:column style="text-align:center">
						<h:outputText value="#{vendedor.nome}" />
					</rich:column>
					<rich:column style="text-align:center">
						<h:outputText value="#{vendedor.areaVenda}" />
					</rich:column>
					<rich:column style="text-align:center">
						<h:outputText value="#{vendedor.salario}" />
					</rich:column>
					
					<rich:column style="text-align:center">
						<h:commandLink value="Alterar"
								action="#{vendedorBacking.alteraVendedor}">
								<f:setPropertyActionListener value="#{vendedor}"
									target="#{vendedorBacking.vendedorSelecionado}" />
							</h:commandLink>
					</rich:column>
					
					<rich:column style="text-align:center">
						<h:commandLink value="Excluir" action="#{vendedorBacking.excluir}">
							<f:setPropertyActionListener value="#{vendedor}"
								target="#{vendedorBacking.vendedorSelecionado}" />
						</h:commandLink>
					</rich:column>
				</rich:dataTable><br>


			     <rich:datascroller align="center" for="listaVendedor" maxPages="20"
                page="#{vendedorBacking.scrollerPage}" id="sc2"
                reRender="listaVendedor" /><br>



			<h:panelGrid>
				<h:panelGrid columns="3">
					
			
				<h:commandButton style="margin-right: 15px"  value="Cancelar"
						action="#{vendedorBacking.cancelar}" />
				</h:panelGrid>
				
			</h:panelGrid>

		</h:form>
		</center>
	</f:view>

</body>
</html>