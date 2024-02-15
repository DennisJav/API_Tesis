package com.ec.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "proveedor")
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ("sec_prov"))
	@SequenceGenerator(name = "sec_prov", sequenceName = "sec_prov", allocationSize = 1)
	@Column(name = "prov_id")
	private Integer id;
	
	@Column(name = "prov_empresa")
	private String empresa;
	
	@Column(name = "prov_telefono")
	private String telefono;
	
	@Column(name = "prov_correo")
	private String correo;
	
	@Column(name = "prov_origen")
	private String origen;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@Column(name="prov_fecha_registro")
	private LocalDateTime fechaRegistro;
	
	@Column(name = "prov_precio_compra")
	private BigDecimal precioCompra;
	
	//-------Relaciones
	
	@ManyToOne
	@JoinColumn(name = "prov_repuesto_id")
	private Repuesto repuesto;

}
