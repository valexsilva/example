package com.prueba.tecnica.archivoExcel.service;

import java.util.List;

import com.prueba.tecnica.archivoExcel.comun.AnimalDTO;
import com.prueba.tecnica.archivoExcel.comun.GeneralDTO;

public interface IManageExcel {

	GeneralDTO registraAnimales(List<AnimalDTO> animales) throws Exception;

}
