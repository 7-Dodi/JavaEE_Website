<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vaccination</title>
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
	    
	    height:200px;
	    padding:10px;
	    
	    display: flex;
	    flex-direction: column;
	    align-items: center;
	    justify-content: space-between;
	}
	.main h1{
		font-size: 50px;
	}	
	
	.main span{
		color: blue;
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
</style>

<body>
	<div class="main">
		<h1>Vacinação com a vacina <span>${param.vaccine}</span> cadastrado com sucesso!!!</h1>
		<a href="vaccination"><button>Voltar a página inicial</button></a>
	</div>
</body>

</html>