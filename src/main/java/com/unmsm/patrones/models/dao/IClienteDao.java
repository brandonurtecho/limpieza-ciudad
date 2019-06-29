package com.unmsm.patrones.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.unmsm.patrones.models.entity.Distrito;

public interface IClienteDao extends PagingAndSortingRepository<Distrito, Long>{


}
