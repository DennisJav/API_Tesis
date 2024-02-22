package com.ec.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
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
	@Size(max = 2)
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
	
	@ManyToMany(mappedBy = "proveedores")
	private Set<Repuesto> repuestos;



	/*
@ManyToMany(mappedBy = "suscriptores")
    private Set<Foro> foros = new HashSet<>();
	 */

}
