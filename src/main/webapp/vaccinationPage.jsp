<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ page import="br.com.JavaWeb.entities.Vaccination" %>
<%@ page import ="java.util.List"%>
<%
	List<Vaccination> vaccination = (List<Vaccination>) request.getAttribute("vaccination");
%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home Page</title>
</head>

<style>
* {
	margin: 0;
	box-sizing: border-box;
	font-family: system-ui;
}

.main {
	position: fixed;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	padding: 10px;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: space-between;
}

.main h1 {
	font-size: 50px;
}

.buttons{
		width: 100%;
		display: flex;
		gap: 80px;
		justify-content: center;
}
.buttonsTd{
		width: 100%;
		height: 100%;
		display: flex;
		gap: 10px;
		justify-content: center;
}
button {
	background-color: blue;
	color: #fff;
	width: 90px;
	height: 40px;
	border: none;
	border-radius: 10px;
	transition: all 0.5s;
	font-weight: 530;
	cursor: pointer;
}
.remover{
	background-color: red;
}

#tableContainer{
	margin-top: 30px;
	overflow-y: auto; /* Adiciona uma barra de rolagem vertical */
	max-height: 400px; /* Altura máxima da tabela antes da barra de rolagem aparecer */
}

#tabela {
	border-collapse: collapse;
	width: 100%;
}
#tabela th{
	border: 1px solid #ddd;
	padding: 10px;
	text-align: left;
	background-color: blue;
	color: #fff;
}
#tabela td{
	border: 1px solid #ddd;
	padding: 10px;
	text-align: left;
}

</style>

<body>
	<div class="main">
		<h1>Página de Vacinações</h1>
		<div class="buttons">
			<a href="./addVaccination.html"><button>Registrar Vacinação</button></a>
			<a href="./index.html"><button>Home Page</button></a>		
		</div>
		<div id="tableContainer">
			<table id="tabela">
				<thead>
					<tr>
						<th>Id</th>
						<th>Paciente</th>
						<th>Vacina</th>
						<th>Data de Vacinação</th>
						<th>Lote</th>
						<th>Médico</th>
						<th>Opções</th>
					</tr>
				</thead>
				<tbody>
					<% for(int k=0; k < vaccination.size(); k++){%>
					<tr>
						<td><%=vaccination.get(k).getId()%></td>
						<td><%=vaccination.get(k).getIdPaciente()%></td>
						<td><%=vaccination.get(k).getNomeVaccine()%></td>
						<td><%=vaccination.get(k).getData()%></td>
						<td><%=vaccination.get(k).getLote()%></td>
						<td><%=vaccination.get(k).getMedico()%></td>
						<td class="buttonsTd">
							<a href="selectVaccination?idVaccine=<%=vaccination.get(k).getId()%>"><button>Editar</button></a>
							<a href="javascript: confirmar(<%=vaccination.get(k).getId()%>)"><button class="remover">Remover</button></a>
						</td>
					</tr>
					<%} %>
				</tbody>
			</table>		
		</div>
	</div>
</body>
<script src="./scripts/ConfirmadorVaccination.js"></script>
</html>