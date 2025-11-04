import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { Peticion } from '../../services/peticion'; // ajusta si es necesario
import { Usuario } from '../../Entidad/Usuario';
import { Rol } from '../../Entidad/Rol';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-agregar-usuario',
  standalone: true,
  templateUrl: './agregar-usuario.html',
  imports: [CommonModule, FormsModule],
})
export class AgregarUsuario implements OnInit {

  usuario: Usuario = {
    idUsuario: 0,
    nombre: '',
    app: '',
    apm: '',
    sexo: '',
    fechaNacimiento: new Date(),
    fechaCreacion: new Date(),
    correo: '',
    rol: { rolId: 0 }
  };

  roles: Rol[] = [];

  constructor(private peticion: Peticion, private router: Router) {}

  ngOnInit(): void {
    this.cargarRoles();
  }

  cargarRoles(): void {
    this.peticion.listarRoles().subscribe(data => {
      this.roles = data;
    });
  }

  generarCorreo(): void {
    if (this.usuario.nombre && this.usuario.app) {
      const nombre = this.usuario.nombre.trim().toLowerCase();
      const app = this.usuario.app.trim().toLowerCase();
      this.usuario.correo = `${nombre}.${app}@enucom.com.mx`;
    }
  }

  esMayorDeEdad(fechaNacimiento: Date): boolean {
    const hoy = new Date();
    const nacimiento = new Date(fechaNacimiento);
    let edad = hoy.getFullYear() - nacimiento.getFullYear();
    const m = hoy.getMonth() - nacimiento.getMonth();
    if (m < 0 || (m === 0 && hoy.getDate() < nacimiento.getDate())) {
      edad--;
    }
    return edad >= 18;
  }

  guardarUsuario(): void {
    delete this.usuario.idUsuario;

    // Validar edad mínima
    if (!this.esMayorDeEdad(this.usuario.fechaNacimiento)) {
      Swal.fire({
        icon: 'warning',
        title: 'Edad insuficiente',
        text: 'El usuario debe tener al menos 18 años.',
        confirmButtonText: 'Aceptar'
      });
      return;
    }

    this.peticion.agregarUsuario(this.usuario).subscribe({
      next: (msg: string) => {
        Swal.fire({
          icon: 'success',
          title: '¡Éxito!',
          text: msg,
          confirmButtonText: 'Aceptar'
        }).then(() => {
          this.router.navigate(['/listar-usuario']);
        });
      },
      error: (err) => {
        console.error('Error al agregar usuario:', err);

        let mensaje = 'Error desconocido';

        if (typeof err.error === 'string') {
          mensaje = err.error;
        } else if (err.error && typeof err.error === 'object') {
          mensaje = err.error.message || JSON.stringify(err.error);
        } else {
          mensaje = JSON.stringify(err);
        }

        Swal.fire({
          icon: 'error',
          title: 'Error al guardar el usuario',
          text: mensaje,
          confirmButtonText: 'Aceptar'
        });
      }
    });
  }
}