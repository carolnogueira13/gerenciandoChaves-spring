package com.example.horarios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.horarios.entity.Reserva;
import com.example.horarios.repository.ReservaRepository;


import jakarta.transaction.Transactional;

@Service
public class ReservaService {
	
	private final ReservaRepository reservaRepository;

	public ReservaService(ReservaRepository reservaRepository) {
		this.reservaRepository = reservaRepository;
	}
	
	@Transactional
	public List<Reserva> getAllReservas(){
		return reservaRepository.findAll();
	}
	
	@Transactional
	public Reserva adicionarReserva(Reserva reserva){
		boolean existe = reservaRepository.existsBySalaAndHorarioInicioLessThanEqualAndHorarioFimGreaterThanEqual(reserva.getSala(), reserva.getHorarioInicio(), reserva.getHorarioFim());
		if (existe) {
			return null;
		}
		return reservaRepository.save(reserva);
	}
	
	
	@Transactional 
	public Optional<Reserva> iniciarReserva(int id) {
		reservaRepository.iniciarReserva(id);
		return reservaRepository.findById((long) id);
		
	}
	
	@Transactional 
	public Optional<Reserva> finalizarReserva(int id) {
		reservaRepository.finalizarReserva(id);
		return reservaRepository.findById((long) id);
	}
	
	@Transactional
	public Optional<Reserva> procuraPorId(int id) {
		return reservaRepository.findById((long) id);
		
	}
	
	@Transactional
	public List<Reserva> getAllReservasAtivas(){
		return reservaRepository.procurarReservasAtivas();
	}
	
	
	
	

	
	

}
