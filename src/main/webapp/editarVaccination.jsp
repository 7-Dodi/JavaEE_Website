<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>

<style>
	*{
		margin: 0;
		box-sizing: border-box;
		font-family: system-ui;
	}
	
	.main {
	    position: fixed;
	    top: 50%;
	    left: 50%;
	    transform: translate(-50%, -50%);
	    
	    padding:10px;
	    
	    display: flex;
	    flex-direction: column;
	    align-items: center;
	    justify-content: space-between;
	}
	.main h1{
		font-size: 50px;
	}
	.main form{
		width: 100%;
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}
	.main input{
		width: 400px;
	    height: 35px;
	    margin-bottom: 5px;
	    border-radius: 5px;
	    border: 1px solid #21E;
	    padding: 5px;
	    font-size: 14px;
	    cursor: pointer;
	}
	#button {
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
	#button::hover {
		background-color: #8AACEC;
	}
	
</style>

<body>
<div class="main">
	<h1>Editar paciente</h1>
	<form name="formAddVaccination" action="updateVaccination">
		<input type="text" name="id" readonly="readonly" value="<% out.print(request.getAttribute("id"));%>"/><br /> 
		<input type="text" name="patient" readonly="readonly" value="<% out.print(request.getAttribute("paciente"));%>"/><br /> 
		<input type="text" name="vaccine" value="<% out.print(request.getAttribute("vaccine"));%>"/><br />
		<input type="text" name="data" value="<% out.print(request.getAttribute("data"));%>"/><br /> 
		<input type="text" name="lote" value="<% out.print(request.getAttribute("lote"));%>"/><br /> 
		<input type="text" name="doctor" value="<% out.print(request.getAttribute("medico"));%>"/><br />   
		<input id="button" type="button" value="Salvar"/>
	</form>
</div>
</body>
<script src="./scripts/validatorVaccination.js"></script>
</html>