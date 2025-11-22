package com.isabela.at1_t2_tarefas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class Tarefa{
	private Integer id;
	private String descricao;

	public Tarefa(Integer id, String descricao){
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId(){ return id;}
	public void setId(Integer id) { this.id = id;}
	public String getDescricao(){ return descricao;}
	public void setDescricao(String descricao) { this.descricao = descricao;}
}