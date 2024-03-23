/**
 * 
 */

 function confirmar (id){
	 let resposta = confirm("Confirmar a exclusão desse paciente?");
	 if(resposta === true){
		 window.location.href= "delete?idUser=" + id;
	 }
 }