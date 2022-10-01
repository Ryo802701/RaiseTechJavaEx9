package com.example.ex9.service;

import java.util.List;

import com.example.ex9.entity.Calory;

public interface CaloryService {
	List<Calory> findAll();

	List<Calory> findByKcal(int kcal_from, int kcal_to);

	List<Calory> findByKindKcal(String kind, int kcal_from, int kcal_to);

	void create(Calory form);

	void update(Calory form);

	void delete(int id);

}
