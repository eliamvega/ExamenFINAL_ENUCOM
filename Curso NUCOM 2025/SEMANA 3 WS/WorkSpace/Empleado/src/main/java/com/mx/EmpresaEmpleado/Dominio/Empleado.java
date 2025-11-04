package com.mx.EmpresaEmpleado.Dominio;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "EMPLEADO")
public class Empleado {

    @Id
    @Column(name = "IDEMPLEADO")
    private Integer idEmpleado;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;

    @Column(name = "EDAD")
    private int edad;

    @Column(name = "SALARIO")
    private double salario;

    @Column(name = "CORREO")
    private String correo;

    @Column(name = "FECHANACIMIENTO")
    private LocalDate fechaNacimiento;

    @Column(name = "FECHACREACION")
    private LocalDate fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "ROL_IDROL", referencedColumnName = "IDROL")
    private Rol rol;

    public Empleado() {}

    public Empleado(Integer idEmpleado, String nombre, String apellido, int edad, double salario,
                    String correo, LocalDate fechaNacimiento, LocalDate fechaCreacion, Rol rol) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.salario = salario;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaCreacion = fechaCreacion;
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellido=" + apellido +
                ", edad=" + edad + ", salario=" + salario + ", correo=" + correo +
                ", fechaNacimiento=" + fechaNacimiento + ", fechaCreacion=" + fechaCreacion +
                ", rol=" + rol + "]";
    }

    // Getters y Setters
    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}  
