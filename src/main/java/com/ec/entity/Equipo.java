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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "equipo")
public class Equipo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ("sec_equi"))
	@SequenceGenerator(name = "sec_equi", sequenceName = "sec_equi", allocationSize = 1)
	@Column(name = "equi_id")
	private Integer id;

	@Column(name = "equi_tipo")
	private String tipo;
	
	@Column(name = "equi_marca")
	private String marca;
	
	@Column(name = "equi_modelo")
	private String modelo;
	
	@Column(name = "equi_serie")
	private String serie;
	
	@Column(name = "equi_precio_reparacion")
	private BigDecimal precioReparacion;

	//-------RELACIONES
	
	@OneToMany(mappedBy = "equipo")
	private List<DetalleRequerimiento> detallesReq;
	
	@OneToMany(mappedBy = "equipo")
	private List<Repuesto> repuestos;
	
	
	//--------GET Y SET relaciones

}
