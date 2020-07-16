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
<title>Consulta de Cliente</title>
</head>
<body class="backgroundTelaConsultaCliente">

 

    <f:view>
        <jsp:include page="/menu.jsp"></jsp:include>


   
 	
 

        <h:form id="formConsulta">
            <h:panelGrid columns="1">
                <h:messages />
            </h:panelGrid>
	<center>	
 						
		<br>
			<h:panelGrid columns="3">
				<h:outputText  style="color: white" value="Nome: " />
				<h:inputText value="#{clienteBacking.nome}" maxlength="50" size="40" />
				<h:commandButton value="Pesquisar Cliente"
					action="#{clienteBacking.pesquisar}" />
			</h:panelGrid><br>

 
					<h2 style="color: white">Lista de Clientes Cadastrados</h2>
          
                <a4j:keepAlive beanName="clienteBacking" ajaxOnly="true" />
                <rich:spacer height="30" />
                <rich:dataTable width="490" id="listaCliente" rows="10"
                    columnClasses="col" value="#{clienteBacking.listaCliente}"
                    var="cliente">
                    <f:facet name="header">
                        <rich:columnGroup>
                            <rich:column styleClass="corBarraMenuConsultaCliente">
                                <h:outputText value="Nome" />
                            </rich:column>
                            <rich:column styleClass="corBarraMenuConsultaCliente">
                                <h:outputText value="Telefone" />
                            </rich:column>
                            <rich:column styleClass="corBarraMenuConsultaCliente">
                                <h:outputText value="Data de Nascimento" />
                            </rich:column>
                            <rich:column colspan="2" styleClass="corBarraMenuConsultaCliente">
                                <h:outputText value="A��es" />
                            </rich:column>
                        </rich:columnGroup>
                    </f:facet>

 

                    <rich:column style="text-align:center">
                        <h:outputText value="#{cliente.nome}" />
                    </rich:column>
                    <rich:column style="text-align:center">
                        <h:outputText value="#{cliente.telefone}" />
                    </rich:column>
                    <rich:column style="text-align:center">
                        <h:outputText value="#{cliente.dataNascimento}" />
                    </rich:column>
                    
                    <rich:column style="text-align:center">
                    
                        <h:commandLink value="Alterar"
                            action="#{clienteBacking.alteraCliente}">
                            <f:setPropertyActionListener value="#{cliente}"
                                target="#{clienteBacking.clienteSelecionado}" />
                        </h:commandLink>
                    </rich:column>
                    
                    <rich:column style="text-align:center">
                    
                        <h:commandLink value="Excluir" action="#{clienteBacking.excluir}">
                            <f:setPropertyActionListener value="#{cliente}"
                                target="#{clienteBacking.clienteSelecionado}" />
                        </h:commandLink>
                    </rich:column>


                </rich:dataTable>
 
            <rich:datascroller align="center" for="listaCliente" maxPages="20"
                page="#{clienteBacking.scrollerPage}" id="sc2"
                reRender="listaCliente" />

            <h:panelGrid columns="1"><br>
                <h:commandButton value="Cancelar"
                    action="#{clienteBacking.cancelar}" />
            </h:panelGrid>

       </center>

        </h:form>
    </f:view>

 

</body>
</html>