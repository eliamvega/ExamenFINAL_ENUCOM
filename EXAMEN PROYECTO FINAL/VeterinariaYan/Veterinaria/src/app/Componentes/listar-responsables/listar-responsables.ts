import { Component, OnInit } from '@angular/core';
import { Peticion } from '../../services/peticion';
import { Responsable } from '../../Entidad/Responsable';
import Swal from 'sweetalert2';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-listar-responsables',
  imports: [FormsModule,CommonModule],
  templateUrl: './listar-responsables.html',
  styleUrl: './listar-responsables.css'
})
export class ListarResponsables implements OnInit {

  constructor (private peticion: Peticion){}
  ngOnInit(): void {
    this.listarR();
  }
  responsables !: Responsable[];
   nuevoResponsable: Responsable = new Responsable();
  mostrarFormulario: boolean = false;
    responsableSeleccionado: Responsable | null = null;
  mostrarFormularioEditar: boolean = false;

  listarR(){
    this.peticion.listarR().subscribe(respuesta => {
      console.log(JSON.stringify(respuesta));
      this.responsables = respuesta;
    })
  }
eliminarR(responsable: Responsable) {
  Swal.fire({
    title: '¿Estás seguro?',
    text: `Se eliminará a ${responsable.nombre}`,
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#d33',
    cancelButtonColor: '#3085d6',
    confirmButtonText: 'Sí, eliminar',
    cancelButtonText: 'Cancelar'
  }).then((result) => {
    if (result.isConfirmed) {
      this.peticion.eliminarR(responsable).subscribe({
  next: () => {
    Swal.fire({
      title: '¡Eliminado!',
      text: 'El responsable ha sido eliminado correctamente.',
      icon: 'success'
    }).then(() => {
      this.listarR();
    });
  },
  error: (err) => {
    if (err.status === 200 || err.status === 204) {
      // Lo tratamos como éxito
      Swal.fire({
        title: '¡Eliminado!',
        text: 'El responsable ha sido eliminado correctamente.',
        icon: 'success'
      }).then(() => {
        this.listarR();
      });
    } else {
      Swal.fire({
        title: 'Error',
        text: 'No se pudo eliminar el responsable.',
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
    this.nuevoResponsable = new Responsable();
  }

  agregarResponsable() {
    if (!this.nuevoResponsable.nombre || !this.nuevoResponsable.contacto || !this.nuevoResponsable.veterinariaId) {
      Swal.fire('Error', 'Todos los campos son obligatorios', 'error');
      return;
    }

    this.peticion.agregarR(this.nuevoResponsable).subscribe({
      next: () => {
        Swal.fire('¡Agregado!', 'El responsable ha sido registrado correctamente', 'success')
          .then(() => {
            this.listarR();
            this.mostrarFormulario = false;
            this.nuevoResponsable = new Responsable();
          });
      },
      error: (err) => {
        console.error('Error real:', err);
        if (err.status >= 200 && err.status < 300) {
          Swal.fire('¡Agregado!', 'El responsable ha sido registrado correctamente', 'success')
            .then(() => {
              this.listarR();
              this.mostrarFormulario = false;
              this.nuevoResponsable = new Responsable();
            });
        } else {
          Swal.fire('Error', 'No se pudo agregar el responsable', 'error');
        }
      }
    });
  }
   editarResponsable(responsable: Responsable) {
    this.responsableSeleccionado = { ...responsable }; // copia para edición
    this.mostrarFormularioEditar = true;
  }

  guardarEdicion() {
    if (!this.responsableSeleccionado?.nombre || !this.responsableSeleccionado?.contacto || !this.responsableSeleccionado?.veterinariaId) {
      Swal.fire('Error', 'Todos los campos son obligatorios', 'error');
      return;
    }

    this.peticion.editarR(this.responsableSeleccionado).subscribe({
      next: () => {
        Swal.fire('¡Actualizado!', 'El responsable ha sido actualizado correctamente', 'success')
          .then(() => {
            this.listarR();
            this.mostrarFormularioEditar = false;
            this.responsableSeleccionado = null;
          });
      },
      error: (err) => {
        console.error('Error real:', err);

        if (err.status >= 200 && err.status < 300) {
          Swal.fire('¡Actualizado!', 'El responsable ha sido actualizado correctamente', 'success')
            .then(() => {
              this.listarR();
              this.mostrarFormularioEditar = false;
              this.responsableSeleccionado = null;
            });
        } else {
          Swal.fire('Error', 'No se pudo actualizar el responsable', 'error');
        }
      }
    });
  }

  cancelarEdicion() {
    this.mostrarFormularioEditar = false;
    this.responsableSeleccionado = null;
  }
}


