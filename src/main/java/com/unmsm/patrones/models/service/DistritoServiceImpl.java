package com.unmsm.patrones.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unmsm.patrones.models.dao.ICalleDao;
import com.unmsm.patrones.models.dao.IClienteDao;
import com.unmsm.patrones.models.entity.Calle;
import com.unmsm.patrones.models.entity.Distrito;

@Service
public class DistritoServiceImpl implements IDistritoService {

	@Autowired
	private IClienteDao clienteDao;

	@Autowired
	private ICalleDao calleDao;

	@Transactional(readOnly = true)
	public List<Distrito> findAll() {
		// TODO Auto-generated method stub
		return (List<Distrito>) clienteDao.findAll();
	}

	@Transactional
	public void save(Distrito distrito) {
		clienteDao.save(distrito);

	}

	@Transactional(readOnly = true)
	public Distrito findOne(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id).orElse(null);
	}

	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);

	}

	@Transactional(readOnly = true)
	public Page<Distrito> findAll(Pageable pageable) {
		return clienteDao.findAll(pageable);
	}
	
	@Transactional
	public void saveCalle(Calle calle) {
		calleDao.save(calle);
	}

	@Transactional(readOnly=true)
	public Calle findFacturaById(Long id) {
		// TODO Auto-generated method stub
		return calleDao.findById(id).orElse(null);
	}

	@Transactional
	public void deleteCalle(Long id) {
		calleDao.deleteById(id);
	}
}
