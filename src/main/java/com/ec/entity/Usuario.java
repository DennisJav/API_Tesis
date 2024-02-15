package com.ec.entity;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ("seq_usuario"))
	@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario",allocationSize = 1)
	@Column(name="usua_id")
	private Integer id;
	
	@Column(name="usua_nombre")
	private String nombre;
	
	@Column(name="usua_apellido")
	private String apellido;
	
	@Column(name="usua_cedula")
	private String cedula;
	
	@Column(name="usua_contrasena")
	private String contrasena;
	
	@Column(name="usua_telefono")
	private String telefono;
	
	@Column(name="usua_tipo")
	private String tipo;
	
	@Column(name="usua_email")
	private String email;
	
	@Column(name="usua_estado")
	private String estado;

	@Column(name = "usua_identificador")
	private String identificador;

	@Column(name = "usua_direccion")
	private String direccion;

	
	//-------Relaciones
	
	@OneToMany(mappedBy = "usuario")
	private List<Requerimiento> requerimientos;

	// get y set ---- relaciones
	
	public List<Requerimiento> getRequerimientos() {
		return requerimientos;
	}

	public void setRequerimientos(List<Requerimiento> requerimientos) {
		this.requerimientos = requerimientos;
	}

	
	//get and set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", contrasena=" + contrasena + ", telefono=" + telefono + ", tipo=" + tipo + ", email=" + email
				+ ", estado=" + estado + "]";
	}
	
	
	
	
	
	
}
