import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from '../../Entidad/Usuario';
import { Peticion } from '../../services/peticion';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-editar-usuario',
  standalone: true,
  templateUrl: './editar-usuario.html',
  imports: [CommonModule, FormsModule]
})
export class EditarUsuario implements OnInit {

  usuario: Usuario = new Usuario();

  constructor(
    private rutaActiva: ActivatedRoute,
    private peticion: Peticion,
    private router: Router
  ) {}

  ngOnInit(): void {
  const id = Number(this.rutaActiva.snapshot.paramMap.get('id'));
  console.log('ID recibido:', id); // <- Asegúrate que NO sea NaN
  this.peticion.buscarUsuario(id).subscribe({
    next: (data) => {
      this.usuario = data;
    },
    error: (err) => {
      console.error('Error al cargar usuario:', err);
      Swal.fire('Error', 'No se pudo cargar el usuario', 'error');
    }
  });
}

  actualizarUsuario(): void {
  this.peticion.actualizarUsuario(this.usuario).subscribe({
    next: () => {
      Swal.fire({
        icon: 'success',
        title: '¡Éxito!',
        text: 'Usuario actualizado correctamente',
        confirmButtonColor: '#3085d6',
        confirmButtonText: 'Aceptar'
      });
      this.router.navigate(['/listar-usuario']);
    },
    error: (error) => {
      let mensaje = 'Error al actualizar el usuario';
      if (error.error) {
        if (typeof error.error === 'string') {
          mensaje = error.error;
        } else if (error.error.text) {
          mensaje = error.error.text;
        }
      }
      Swal.fire({
        icon: 'error',
        title: 'Error',
        text: mensaje,
        confirmButtonColor: '#d33',
        confirmButtonText: 'Cerrar'
      });
    }
  });
}
}