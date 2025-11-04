import { Component } from '@angular/core';
import { Peticion } from '../../services/peticion';
import { Rol } from '../../Entidad/Rol';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import Swal from 'sweetalert2';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-agregar-rol',
  imports: [FormsModule, CommonModule],
  templateUrl: './agregar-rol.html',
})
export class AgregarRolComponent {
  rol: Rol = new Rol();

  constructor(private peticion: Peticion, private router: Router) {}

  guardarRol() {
    // Validar duplicado antes de guardar
    this.peticion.listarRoles().subscribe({
      next: (roles) => {
        const existe = roles.some(
          (r: Rol) =>
            r.privilegio.trim().toLowerCase() ===
            this.rol.privilegio.trim().toLowerCase()
        );

        if (existe) {
          Swal.fire({
            icon: 'warning',
            title: 'Duplicado',
            text: `El rol con privilegio "${this.rol.privilegio}" ya existe.`,
          });
          return; // No seguir guardando
        }

        // Si no existe, guardamos normalmente
        this.peticion.agregarR(this.rol).subscribe({
          next: (mensaje) => {
            Swal.fire({
              icon: 'success',
              title: '¡Éxito!',
              text: mensaje, // Muestra el mensaje que envía el backend
              timer: 2000,
              showConfirmButton: false,
            });
            this.router.navigate(['/listar-rol']);
          },
          error: (err) => {
            console.error('Error al agregar rol:', err);
            const mensaje = err.error ? err.error : 'Error al guardar el rol';
            Swal.fire({
              icon: 'error',
              title: 'Oops...',
              text: mensaje,
            });
          },
        });
      },
      error: (err) => {
        console.error('Error al obtener lista de roles:', err);
        Swal.fire({
          icon: 'error',
          title: 'Error',
          text: 'No se pudo verificar duplicados. Intente más tarde.',
        });
      },
    });
  }
}