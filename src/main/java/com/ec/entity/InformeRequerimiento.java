package com.ec.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "informe_requerimiento")
public class InformeRequerimiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ("info_req"))
	@SequenceGenerator(name = "info_req", sequenceName = "info_req", allocationSize = 1)
	@Column(name = "info_id")
	private Integer id;
	@Column(name = "info_estado")
	private String estado;
	@Column(name = "info_diagnostico")
	private String diagnostico;
	@Column(name = "info_observacion")
	private String observacion;

	//------Relaciones-------------
	
	@OneToOne
	@JoinColumn(name = "info_detalle_id")
	private DetalleRequerimiento detalle;
	
	
	
	//get y set ---relaciones
	
	public DetalleRequerimiento getDetalle() {
		return detalle;
	}

	public void setDetalle(DetalleRequerimiento detalle) {
		this.detalle = detalle;
	}
	
	
	
	
	//get y set
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	
	
	
}
