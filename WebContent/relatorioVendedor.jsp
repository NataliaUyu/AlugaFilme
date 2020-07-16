<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Relatório em Java</title>
<script type="text/javascript">
    function visualizarRelatorio() {        
        enviar("visualizar");        
    }

 

    function gerarRelatorioPDF() {        
        enviar("pdf");
    }

 

    function enviar(acao) {
        document.forms[0].acao.value = acao;
        document.forms[0].target = "_blank";
        document.forms[0].action = "./RelatorioVendedorServlet";
        document.forms[0].submit();
    }
</script>
</head>
<body>
<h1>Relatório de Vendedores</h1>

 

<form action="./RelatorioServlet" method="post" onsubmit="return false;">
    <input type="hidden" name="acao" />    
    <input type="submit" value="Visualizar Relatorio" onclick="javascript:visualizarRelatorio();">
    <input type="submit" value="Gerar Relatório PDF" onclick="javascript:gerarRelatorioPDF();">    
</form>

<form>
			<h:panelGrid>
				<h:panelGrid columns="3">
					
			
				<h:commandButton style="margin-right: 15px"  value="Cancelar"
						action="#{relatorioBacking.cancelar}" />
				</h:panelGrid>
				
			</h:panelGrid>
</form>
</body>
</html>