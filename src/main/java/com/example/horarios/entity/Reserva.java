package com.example.horarios.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reserva", nullable = false)
	private int id;

	@ManyToOne
	@JoinColumn(name = "responsavel_id_responsavel")
	private Responsavel responsavel;

	@ManyToOne
	@JoinColumn(name = "evento_id_evento")
	private Evento evento;

	@ManyToOne
	@JoinColumn(name = "sala_id_sala")
	private Sala sala;

	@ManyToOne
	@JoinColumn(name = "horario_id_horario_inicio")
	private Horario horarioInicio;

	@ManyToOne
	@JoinColumn(name = "horario_id_horario_fim")
	private Horario horarioFim;
	
	@Column(name = "status_reserva", nullable = false)
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Horario getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(Horario horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public Horario getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(Horario horarioFim) {
		this.horarioFim = horarioFim;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	

}
