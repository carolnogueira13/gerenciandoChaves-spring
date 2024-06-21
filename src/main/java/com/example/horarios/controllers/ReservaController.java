package com.example.horarios.controllers;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.horarios.entity.Reserva;
import com.example.horarios.services.ReservaService;

@RestController
@RequestMapping("api/reserva")
public class ReservaController {

	private final ReservaService reservaService;

	public ReservaController(ReservaService reservaService) {
		this.reservaService = reservaService;
	}
	
	@GetMapping
	public ResponseEntity<List<Reserva>> getAllReservas(){
		List<Reserva> reservas = reservaService.getAllReservas();
		if (reservas.isEmpty())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(reservas);
	}
	
	@GetMapping("/ativas")
	public ResponseEntity<List<Reserva>> getAllReservasAtivas(){
		List<Reserva> reservas = reservaService.getAllReservasAtivas();
		if (reservas.isEmpty())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(reservas);
	}
	
	@PostMapping
	public ResponseEntity<Reserva> adicionarReserva(@RequestBody Reserva reserva) {
		Reserva reservaNova = reservaService.adicionarReserva(reserva);
		if (reservaNova == null) {
			return ResponseEntity.noContent().build();
		}
		return new ResponseEntity<>(reservaNova, HttpStatus.CREATED);
	}
	
	@PatchMapping("/iniciarReserva/{id}")
	public ResponseEntity<Optional<Reserva>> iniciarReserva(@PathVariable int id) {
		Optional<Reserva> reserva = reservaService.iniciarReserva(id);
		if(Objects.nonNull(reserva)) {
            return ResponseEntity.ok(reserva);
        }
        return ResponseEntity.notFound().build();
	}
	
	@PatchMapping("/finalizarReserva/{id}")
	public ResponseEntity<Optional<Reserva>> finalizarReserva(@PathVariable int id) {
		Optional<Reserva> reserva = reservaService.finalizarReserva(id);
		if(Objects.nonNull(reserva)) {
            return ResponseEntity.ok(reserva);
        }
        return ResponseEntity.notFound().build();
	}
}
