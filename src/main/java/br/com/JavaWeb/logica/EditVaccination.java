package br.com.JavaWeb.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.JavaWeb.dao.VaccinatioDAO;
import br.com.JavaWeb.entities.Vaccination;

public class EditVaccination implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// buscando os parâmetros no request
		String idVaccine = req.getParameter("id");
		String patient = req.getParameter("patient");
		String vacina = req.getParameter("vaccine");
		String data = req.getParameter("data");
		String lote = req.getParameter("lote");
		String medico = req.getParameter("doctor");

		// Montando o obejto vacinação
		Vaccination vaccination = new Vaccination();
		vaccination.setId(Integer.parseInt(idVaccine));
		vaccination.setIdPaciente(Integer.parseInt(patient));
		vaccination.setNomeVaccine(vacina);
		vaccination.setData(data);
		vaccination.setLote(lote);
		vaccination.setMedico(medico);

		// salvar o cliente
		VaccinatioDAO dao;
		try {
			dao = new VaccinatioDAO();
			dao.editVaccination(vaccination);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		res.sendRedirect("vaccination");
	}

}
