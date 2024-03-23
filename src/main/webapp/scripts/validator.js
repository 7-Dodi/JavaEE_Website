/**
 * 
 */

const button = document.querySelector("#button");

 function validator () {
	 let name = formAddPaciente.nome.value;
	 let data = formAddPaciente.dataNascimento.value;
	 let genero = formAddPaciente.genre.value;
	 let telefone = formAddPaciente.tephone.value;
	 let email = formAddPaciente.email.value;
	 
	 
 }
 
 button.addEventListener("click", ()=>{
	 let name = formAddPaciente.nome.value;
	 let data = formAddPaciente.dataNascimento.value;
	 let genero = formAddPaciente.genre.value;
	 let telefone = formAddPaciente.tephone.value;
	 let email = formAddPaciente.email.value;
	 
	 if(name === "" || data === "" || genero === "" || telefone === "" || email === ""){
		 alert("Preencha os campos corretamente");
		 return false;
	 }else{
		 document.forms['formAddPaciente'].submit();
	 }
	 
 })
 
 