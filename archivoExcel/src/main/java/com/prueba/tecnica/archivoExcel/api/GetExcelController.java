package com.prueba.tecnica.archivoExcel.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.tecnica.archivoExcel.comun.AnimalDTO;
import com.prueba.tecnica.archivoExcel.comun.GeneralDTO;
import com.prueba.tecnica.archivoExcel.service.IManageExcel;

@RestController
@RequestMapping("/excelAnimales")
@CrossOrigin(origins = "*")
public class GetExcelController {
	private static Logger LOG = LoggerFactory.getLogger(GetExcelController.class);

	@Autowired
	private IManageExcel manageExcel;

	/***
	 * Método que guardaria la informacion del excel
	 * 
	 * @param lista de animales
	 * @return mensaje de exito
	 */
	@PostMapping("/subir")
	public GeneralDTO registroExcel(@RequestBody List<AnimalDTO> animales) {

		try {
			LOG.info("registraAnimales: " + animales.size());
			return manageExcel.registraAnimales(animales);
		} catch (Exception e) {
			LOG.error("Error al registraAnimales: " + e.getMessage());
			return null;
		}
	}

}
