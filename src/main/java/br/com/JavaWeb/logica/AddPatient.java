package br.com.JavaWeb.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import br.com.JavaWeb.dao.PatientDAO;
import br.com.JavaWeb.entities.Patient;

public class AddPatient implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("Executando a logica e redirecionando...");
        
		// buscando os parâmetros no request
		String name = req.getParameter("nome");
		String dataNascimentoString = req.getParameter("dataNascimento");
		String genre = req.getParameter("genre");
		String numTelefone = req.getParameter("tephone");
		String email = req.getParameter("email");
		
		//Montando  o obejto paciente
		Patient paciente = new Patient();
		paciente.setName(name);
		paciente.setDataNascimento(dataNascimentoString);
		paciente.setGenre(genre);
		paciente.setEmail(email);
		paciente.setNumTelefone(numTelefone);
		
		//salvar o cliente
		PatientDAO dao;
		try {
			dao = new PatientDAO();
			dao.createdPatient(paciente);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/patientAdd.jsp");
		rd.forward(req, res);
	}
}
