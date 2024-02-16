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
@Table (name = "repuesto")
public class Repuesto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ("sec_repu"))
	@SequenceGenerator(name = "sec_repu", sequenceName = "sec_repu", allocationSize = 1)
	@Column(name = "repu_id")
	private Integer id;
	
	
	@Column(name = "repu_tipo")
	private String tipo;
	
	@Column(name = "repu_precio")
	private BigDecimal precio;
	
	@Column(name = "repu_nombre")
	private String nombre;
	
	@Column(name = "repu_stock")
	private BigDecimal stock;
	
	@Column(name = "repu_cantidad")
	private BigDecimal cantidad;
	
	
	//-----Relaciones
	
	@ManyToOne
	@JoinColumn(name = "repu_equipo_id")
	private Equipo equipo;
	
	
	@OneToMany(mappedBy = "repuesto")
	private List<Proveedor> proveedor;
	
	//-------Get y set relaciones
}
