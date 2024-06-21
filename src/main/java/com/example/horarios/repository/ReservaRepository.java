package com.example.horarios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.horarios.entity.Horario;
import com.example.horarios.entity.Reserva;
import com.example.horarios.entity.Sala;

import jakarta.transaction.Transactional;


@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
	
	@Modifying
	@Transactional
	@Query(value="UPDATE reserva SET status_reserva = 2 WHERE id_reserva = :id", nativeQuery=true)
	void iniciarReserva(int id);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE reserva SET status_reserva = 3 WHERE id_reserva = :id", nativeQuery=true)
	void finalizarReserva(int id);
	
	@Transactional
	@Query(value="SELECT * from reserva WHERE status_reserva = 1", nativeQuery=true)
	List<Reserva> procurarReservasAtivas();
	
	boolean existsBySalaAndHorarioInicioLessThanEqualAndHorarioFimGreaterThanEqual(Sala sala, Horario horario1, Horario horario2);

}
