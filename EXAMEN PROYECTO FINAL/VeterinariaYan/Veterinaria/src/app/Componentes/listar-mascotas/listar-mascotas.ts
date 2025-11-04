import { Component, OnInit } from '@angular/core';
import { Peticion } from '../../services/peticion';
import { Mascota } from '../../Entidad/Mascota';
import Swal from 'sweetalert2';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-listar-mascotas',
  imports: [FormsModule,CommonModule],
  templateUrl: './listar-mascotas.html',
  styleUrl: './listar-mascotas.css'
})
export class ListarMascotas implements OnInit {

  constructor(private peticion:Peticion){}
  ngOnInit(): void {
    this.listarM();
  }
    mascotas !: Mascota[];
    nuevaMascota: Mascota = new Mascota();
  mostrarFormulario: boolean = false;
   mascotaSeleccionada: Mascota | null = null;
  mostrarFormularioEditar: boolean = false;

    listarM(){
      this.peticion.listarM().subscribe(respuesta => {
        console.log(JSON.stringify(respuesta));
        this.mascotas = respuesta;
      })
    }

    eliminarM(mascota: Mascota) {
    Swal.fire({
      title: '¿Estás seguro?',
      text: 'Esta acción no se puede deshacer.',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Sí, eliminar',
      cancelButtonText: 'Cancelar'
    }).then((result) => {
      if (result.isConfirmed) {
        this.peticion.eliminarM(mascota).subscribe({
          next: () => {
            Swal.fire({
              title: '¡Eliminado!',
              text: 'La mascota ha sido eliminada correctamente.',
              icon: 'success'
            }).then(() => {
              this.listarM();
            });
          },
          error: (err) => {
            if (err.status === 200 || err.status === 204) {
              Swal.fire({
                title: '¡Eliminado!',
                text: 'La mascota ha sido eliminada correctamente.',
                icon: 'success'
              }).then(() => {
                this.listarM();
              });
            } else {
              Swal.fire({
                title: 'Error',
                text: 'No se pudo eliminar la mascota.',
                icon: 'error'
              });
            }
          }
        });
      }
    });
  }
    toggleFormulario() {
    this.mostrarFormulario = !this.mostrarFormulario;
    this.nuevaMascota = new Mascota(); // limpiar formulario
  }

  agregarMascota() {
    if (!this.nuevaMascota.nombre || !this.nuevaMascota.raza || !this.nuevaMascota.edad || !this.nuevaMascota.clienteId) {
      Swal.fire('Error', 'Todos los campos son obligatorios', 'error');
      return;
    }

    this.peticion.agregarM(this.nuevaMascota).subscribe({
      next: () => {
        Swal.fire('¡Agregada!', 'La mascota ha sido registrada correctamente', 'success')
          .then(() => {
            this.listarM();
            this.mostrarFormulario = false;
            this.nuevaMascota = new Mascota();
          });
      },
      error: (err) => {
        console.error('Error real:', err);
        if (err.status >= 200 && err.status < 300) {
          Swal.fire('¡Agregada!', 'La mascota ha sido registrada correctamente', 'success')
            .then(() => {
              this.listarM();
              this.mostrarFormulario = false;
              this.nuevaMascota = new Mascota();
            });
        } else {
          Swal.fire('Error', 'No se pudo agregar la mascota', 'error');
        }
      }
    });
  }
  editarMascota(mascota: Mascota) {
    this.mascotaSeleccionada = { ...mascota }; // copia para edición
    this.mostrarFormularioEditar = true;
  }

  guardarEdicion() {
    if (!this.mascotaSeleccionada?.nombre || 
        !this.mascotaSeleccionada?.raza || 
        !this.mascotaSeleccionada?.edad ||
        !this.mascotaSeleccionada?.razonCita ||
        !this.mascotaSeleccionada?.clienteId ||
        !this.mascotaSeleccionada?.responsableId ||
        !this.mascotaSeleccionada?.veterinariaId) {
      Swal.fire('Error', 'Todos los campos son obligatorios', 'error');
      return;
    }

    this.peticion.editarM(this.mascotaSeleccionada).subscribe({
      next: () => {
        Swal.fire('¡Actualizada!', 'La mascota ha sido actualizada correctamente', 'success')
          .then(() => {
            this.listarM();
            this.mostrarFormularioEditar = false;
            this.mascotaSeleccionada = null;
          });
      },
      error: (err) => {
        console.error('Error real:', err);

        if (err.status >= 200 && err.status < 300) {
          Swal.fire('¡Actualizada!', 'La mascota ha sido actualizada correctamente', 'success')
            .then(() => {
              this.listarM();
              this.mostrarFormularioEditar = false;
              this.mascotaSeleccionada = null;
            });
        } else {
          Swal.fire('Error', 'No se pudo actualizar la mascota', 'error');
        }
      }
    });
  }

  cancelarEdicion() {
    this.mostrarFormularioEditar = false;
    this.mascotaSeleccionada = null;
  }

}
