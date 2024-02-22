package com.ec.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "detale_requerimiento")
public class DetalleRequerimiento {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ("deta_req"))
	@SequenceGenerator(name = "deta_req", sequenceName = "deta_req", allocationSize = 1)
	@Column(name = "deta_id")
	private Integer id;
	
	@Column(name = "deta_ingreso")
	private String detalleIngreso;
	
	@Column(name = "deta_precio")
	private BigDecimal precio;

	//---------------
	
	@ManyToOne
	@JoinColumn(name = "deta_req_id")
	private Requerimiento requerimiento;
	
	@ManyToOne
	@JoinColumn(name = "deta_equi_id")
	private Equipo equipo;
	
	
	@OneToOne(mappedBy = "detalle")
	private InformeRequerimiento informe;
	
	
	
	
	//get y set ---relaciones
	
	
	public InformeRequerimiento getInforme() {
		return informe;
	}

	public void setInforme(InformeRequerimiento informe) {
		this.informe = informe;
	}

	public Requerimiento getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(Requerimiento requerimiento) {
		this.requerimiento = requerimiento;
	}


	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	// get y set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDetalleIngreso() {
		return detalleIngreso;
	}

	public void setDetalleIngreso(String detalleIngreso) {
		this.detalleIngreso = detalleIngreso;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	} 
	
	
	
	
	
	
	
	
}
