package com.prueba.tecnica.archivoExcel.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.prueba.tecnica.archivoExcel.comun.AnimalDTO;
import com.prueba.tecnica.archivoExcel.comun.GeneralDTO;
import com.prueba.tecnica.archivoExcel.comun.ManageFiles;

@Component
public class ManageExcelImpl implements IManageExcel {
	private static Logger log = LoggerFactory.getLogger(ManageExcelImpl.class);

	@Override
	public GeneralDTO registraAnimales(List<AnimalDTO> animales) throws Exception {
		log.info(" registraAnimales(List<AnimalDTO> animales)");
		GeneralDTO respuesta = new GeneralDTO();
		ManageFiles manejador = new ManageFiles();
		HashMap<String, Object> archivo = manejador.leerArchivo();
		if (archivo.size() == 1) {
			List<AnimalDTO> animalesLeidos = (List<AnimalDTO>) archivo.get("listaAnimales");
			String modificados = "";
			List<AnimalDTO> animalesGuardar = new ArrayList<AnimalDTO>();
			for (AnimalDTO animalNuevo : animales) {
				for (AnimalDTO animalReg : animalesLeidos) {
					if (animalReg.getIdentificacion().equals(animalNuevo.getIdentificacion())) {
						log.info(animalNuevo.getIdentificacion() + " , " + animalNuevo.getSexo() + " , "
								+ animalNuevo.getEspecie() + " , " + animalNuevo.getEdad() + " || "
								+ animalReg.getIdentificacion() + " , " + animalReg.getSexo() + " , "
								+ animalReg.getEspecie() + " , " + animalReg.getEdad());
						if (!animalReg.getSexo().equals(animalNuevo.getSexo())
								|| !animalReg.getEspecie().equals(animalNuevo.getEspecie())
								|| !animalReg.getEdad().equals(animalNuevo.getEdad())) {
							// log.info("Se modifico el animal con identificador: " +
							// animalNuevo.getIdentificacion());
							modificados = modificados + " Se modifico el animal con identificador: "
									+ animalNuevo.getIdentificacion() + " ";
						}
					}
				}
			}
			respuesta.setMessage("Se guardaron correctamente los datos>>>> " + modificados);
			manejador.aniadirArchivo((ArrayList<AnimalDTO>) animales);

		} else if (archivo.size() == 2) {
			respuesta.setMessage("Se guardaron los nuevos datos correctamente los datos");
		} else {
			respuesta.setMessage("ocurrio un error al guardar los datos");
		}
		return respuesta;
	}

}
