package com.ec.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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

	@Column(name="repu_codigo_barras",unique = true)
	private String codBarras;
	
	@Column(name = "repu_tipo")
	private String tipo;
	
	@Column(name = "repu_precio")
	private BigDecimal precio;
	
	@Column(name = "repu_nombre")
	private String nombre;
	
	@Column(name = "repu_stock")
	@Min(0)
	private Integer stock;
	
//	@Column(name = "repu_cantidad")
//	private Integer cantidad;

	@Column(name="repu_subtotal")
	private BigDecimal subTotal;

	@Column(name="repu_estado")
	private Boolean estado;

	
	@ManyToOne
	@JoinColumn(name = "repu_equipo_id")
	private Equipo equipo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "repuesto_prov_id")
	private Proveedor proveedor;


	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Repuesto{");
		sb.append("id=").append(id);
		sb.append(", codBarras='").append(codBarras).append('\'');
		sb.append(", tipo='").append(tipo).append('\'');
		sb.append(", precio=").append(precio);
		sb.append(", nombre='").append(nombre).append('\'');
		sb.append(", stock=").append(stock);
		sb.append(", subTotal=").append(subTotal);
		sb.append(", estado=").append(estado);
		sb.append('}');
		return sb.toString();
	}
}
