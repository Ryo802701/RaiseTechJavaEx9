package com.example.ex9.entity;

public class Calory {
	// id
	private int id;

	// 分類
	private String kind;

	// メニュー
	private String menu;

	// カロリー(kcal)
	private int kcal;

	public Calory() {
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getKind() {
		return this.kind;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getMenu() {
		return this.menu;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	public int getKcal() {
		return this.kcal;
	}
}
