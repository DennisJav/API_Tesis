package com.ec.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "requerimiento")
public class Requerimiento {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ("req_usuario"))
	@SequenceGenerator(name = "req_usuario", sequenceName = "req_usuario", allocationSize = 1)
	@Column(name = "req_id")
	private Integer id;
	@Column(name = "req_numero")
	private Integer numeroReq;
	@Column(name = "req_precio_final")
	private BigDecimal precioFinal;
	//----------relaciones
	@ManyToOne
	@JoinColumn(name = "req_usuario_id")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "requerimiento")
	private List<DetalleRequerimiento> detallesReq;
	

	
}
