package br.com.JavaWeb.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.JavaWeb.dao.PatientDAO;

public class DeletePatient implements Logica{

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String idUser = req.getParameter("idUser");
		int id = Integer.parseInt(idUser);
		
		PatientDAO dao = new PatientDAO();
		dao.removePatient(id);
		
		res.sendRedirect("main");
	}

}
