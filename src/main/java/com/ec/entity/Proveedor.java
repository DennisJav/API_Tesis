package com.ec.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
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
	@NotNull
	private String empresa;

	@Column(name="prov_tipo_identificacion")
	@NotNull
	private String tipoIdentificacion;

	@Column(name="prov_identificacion", unique = true)
	@NotNull(message = "La identificacion es obligatoria")
	private String identificacion;
	
	@Column(name = "prov_telefono")
	private String telefono;
	
	@Column(name = "prov_correo")
	@NotNull(message = "El email es obligatorio")
	private String correo;
	
	@Column(name = "prov_origen")
	private String origen;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@Column(name="prov_fecha_registro")
	private LocalDateTime fechaRegistro;
	
	//-------Relaciones

//	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
//	@JoinTable(
//			name="proveedor_repuesto",
//			joinColumns = @JoinColumn(name = "prov_id"),
//			inverseJoinColumns = @JoinColumn(name = "repu_id")
//	)
//	private Set<Repuesto> repuestos;

	@OneToMany(mappedBy = "proveedor",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Repuesto> repuestos;


	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Proveedor{");
		sb.append("id=").append(id);
		sb.append(", empresa='").append(empresa).append('\'');
		sb.append(", tipoIdentificacion='").append(tipoIdentificacion).append('\'');
		sb.append(", identificacion='").append(identificacion).append('\'');
		sb.append(", telefono='").append(telefono).append('\'');
		sb.append(", correo='").append(correo).append('\'');
		sb.append(", origen='").append(origen).append('\'');
		sb.append(", fechaRegistro=").append(fechaRegistro);
		sb.append('}');
		return sb.toString();
	}
}
