package com.ec.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
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
	
	
	@ManyToMany
	@JoinTable(
			name="repuesto_proveedor",
			joinColumns = @JoinColumn(name = "repu_id"),
			inverseJoinColumns = @JoinColumn(name = "prov_id")
	)
	private Set<Proveedor> proveedores;

}
