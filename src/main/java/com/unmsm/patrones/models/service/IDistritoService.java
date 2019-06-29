package com.unmsm.patrones.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.unmsm.patrones.models.entity.Calle;
import com.unmsm.patrones.models.entity.Distrito;

public interface IDistritoService {

	public List<Distrito> findAll();

	public Page<Distrito> findAll(Pageable pageable);

	public void save(Distrito distrito);

	public Distrito findOne(Long id);

	public void delete(Long id);

	public void saveCalle(Calle calle);
	
	public Calle findFacturaById(Long id);
	
	public void deleteCalle(Long id);

}
