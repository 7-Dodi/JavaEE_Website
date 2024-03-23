package br.com.JavaWeb.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.JavaWeb.dao.PatientDAO;
import br.com.JavaWeb.entities.Patient;

public class EditPatient implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		// buscando os parâmetros no request
		String idUser = req.getParameter("id");
		String name = req.getParameter("nome");
		String dataNascimentoString = req.getParameter("dataNascimento");
		String genre = req.getParameter("genre");
		String numTelefone = req.getParameter("tephone");
		String email = req.getParameter("email");

		// Montando o obejto paciente
		Patient paciente = new Patient();
		paciente.setId(Integer.parseInt(idUser));;
		paciente.setName(name);
		paciente.setDataNascimento(dataNascimentoString);
		paciente.setGenre(genre);
		paciente.setEmail(email);
		paciente.setNumTelefone(numTelefone);
		
		PatientDAO dao;
		try {
			dao = new PatientDAO();
			dao.editPacient(paciente);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		res.sendRedirect("main");
	}

}
