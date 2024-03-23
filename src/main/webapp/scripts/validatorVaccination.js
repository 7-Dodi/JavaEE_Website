/**
 * 
 */

const button = document.querySelector("#button");
 
 button.addEventListener("click", ()=>{
	 let patient = formAddVaccination.patient.value;
	 let data = formAddVaccination.data.value;
	 let vaccine = formAddVaccination.vaccine.value;
	 let lote = formAddVaccination.lote.value;
	 let doctor = formAddVaccination.doctor.value;
	 
	 if(patient === "" || data === "" || vaccine === "" || lote === "" || doctor === ""){
		 alert("Preencha os campos corretamente");
		 return false;
	 }else{
		 document.forms['formAddVaccination'].submit();
	 }
	 
 })
 
 