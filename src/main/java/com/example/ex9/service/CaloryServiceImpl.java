package com.example.ex9.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ex9.entity.Calory;
import com.example.ex9.repository.CaloryRepository;

@Service
public class CaloryServiceImpl implements CaloryService {

	private CaloryRepository caloryRepository;

	public CaloryServiceImpl(CaloryRepository caloryRepository) {
		this.caloryRepository = caloryRepository;
	}

	@Override
	public List<Calory> findAll() {
		return caloryRepository.findAll();
	}

	@Override
	public List<Calory> findByKcal(int kcal_from, int kcal_to) {
		return caloryRepository.findByKcal(kcal_from, kcal_to);
	}

	@Override
	public List<Calory> findByKindKcal(String kind, int kcal_from, int kcal_to) {
		return caloryRepository.findByKindKcal(kind, kcal_from, kcal_to);
	}

	@Override
	public void create(Calory form) {
		caloryRepository.create(form);
	}

	@Override
	public void update(Calory form) {
		caloryRepository.update(form);
	}

	@Override
	public void delete(int id) {
		caloryRepository.delete(id);
	}
}
