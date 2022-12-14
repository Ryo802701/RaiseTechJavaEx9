package com.example.ex9.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.ex9.entity.Calory;
import com.example.ex9.service.CaloryService;

@RestController
@RequestMapping("/calories")
@Validated
public class CaloryController {

	private final CaloryService caloryService;

	public CaloryController(CaloryService caloryService) {
		this.caloryService = caloryService;
	}

	@GetMapping("/all")
	public List<Calory> getAllCaloriess() {
		return caloryService.findAll();
	}

	@GetMapping("/search")
	public List<Calory> getCaloriess(@RequestParam(value = "kind") String kind,
			@RequestParam(value = "kcal_from") @DecimalMin("0") String kcalFrom,
			@RequestParam(value = "kcal_to") @DecimalMax("9999") String kcalTo) {

		int from = Integer.parseInt(kcalFrom);
		int to = Integer.parseInt(kcalTo);

		if (kind.isEmpty()) {
			return caloryService.findByKcal(from, to);
		} else {
			return caloryService.findByKindKcal(kind, from, to);
		}
	}

	@PostMapping("/create")
	public ResponseEntity<Map<String, String>> create(@RequestBody Calory form, UriComponentsBuilder uriBuilder) {
		caloryService.create(form);

		int newid = form.getId();

		URI uri = uriBuilder.path("menu").pathSegment(String.valueOf(newid)).build().toUri();

		Map<String, String> response = new HashMap<>();
		response.put("message", "successfully created");

		return ResponseEntity.created(uri).body(response);
	}

	@PatchMapping("/update")
	public ResponseEntity<Map<String, String>> update(@RequestBody Calory form) {
		caloryService.update(form);

		Map<String, String> response = new HashMap<>();
		response.put("message", "successfully updated");

		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, String>> delete(@PathVariable("id") int id) {
		caloryService.delete(id);

		Map<String, String> response = new HashMap<>();
		response.put("message", "successfully deleted");

		return ResponseEntity.ok(response);
	}

}
