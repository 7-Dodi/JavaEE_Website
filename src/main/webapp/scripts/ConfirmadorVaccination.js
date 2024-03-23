/**
 * 
 */

 function confirmar (id){
	 let resposta = confirm("Confirmar a exclusão dessa vacinação?");
	 if(resposta === true){
		 window.location.href= "deleteVaccination?idVaccine=" + id;
	 }
 }