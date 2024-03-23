package br.com.JavaWeb.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.JavaWeb.dao.VaccinatioDAO;

public class DeleteVaccination implements Logica{

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String idVaccine = req.getParameter("idVaccine");
		int id = Integer.parseInt(idVaccine);
		
		VaccinatioDAO dao = new VaccinatioDAO();
		dao.removePatient(id);
		
		res.sendRedirect("vaccination");
	}

}
