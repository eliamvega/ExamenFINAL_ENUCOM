import { Component, OnInit } from '@angular/core';
import { Peticion } from '../../services/peticion';
import { Veterinaria } from '../../Entidad/Veterinaria';
import Swal from 'sweetalert2';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-listar-veterinaria',
  imports: [FormsModule,CommonModule ],
  templateUrl: './listar-veterinaria.html',
  styleUrl: './listar-veterinaria.css'
})
export class ListarVeterinaria implements OnInit {
constructor(private peticion:Peticion){}


  ngOnInit(): void {
  this.listar();
}
veterinarias !: Veterinaria[];
  nuevaVeterinaria: Veterinaria = new Veterinaria();
   mostrarFormulario: boolean = false;
    mostrarFormularioEditar: boolean = false;
veterinariaSeleccionada: Veterinaria | null = null;

listar(){
  this.peticion.listarV().subscribe(respuesta => {
    console.log(JSON.stringify(respuesta));
this.veterinarias = respuesta;
  })
}

 eliminarV(veterinaria: Veterinaria) {
    Swal.fire({
      title: '¿Estás seguro?',
      text: 'Esta acción no se puede deshacer.',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Sí, eliminar',
      cancelButtonText: 'Cancelar'
    }).then((result) => {
      if (result.isConfirmed) {
        this.peticion.eliminarV(veterinaria).subscribe({
          next: () => {
            Swal.fire({
              title: '¡Eliminada!',
              text: 'La veterinaria ha sido eliminada correctamente.',
              icon: 'success'
            }).then(() => {
              this.listar();
            });
          },
          error: (err) => {
            if (err.status === 200 || err.status === 204) {
              Swal.fire({
                title: '¡Eliminada!',
                text: 'La veterinaria ha sido eliminada correctamente.',
                icon: 'success'
              }).then(() => {
                this.listar();
              });
            } else {
              Swal.fire({
                title: 'Error',
                text: 'No se pudo eliminar la veterinaria.',
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
    this.nuevaVeterinaria = new Veterinaria(); // limpia el formulario
  }

  agregarVeterinaria() {
  if(!this.nuevaVeterinaria.nombre || !this.nuevaVeterinaria.direccion || !this.nuevaVeterinaria.telefono) {
    Swal.fire('Error', 'Todos los campos son obligatorios', 'error');
    return;
  }

  this.peticion.agregarV(this.nuevaVeterinaria).subscribe({
    next: (res) => {
      Swal.fire('¡Agregada!', 'La veterinaria ha sido registrada correctamente', 'success')
        .then(() => {
          this.listar();
          this.mostrarFormulario = false;
          this.nuevaVeterinaria = new Veterinaria();
        });
    },
    error: (err) => {
      console.error('Error real:', err);
      if(err.status >= 200 && err.status < 300){
        Swal.fire('¡Agregada!', 'La veterinaria ha sido registrada correctamente', 'success')
          .then(() => {
            this.listar();
            this.mostrarFormulario = false;
            this.nuevaVeterinaria = new Veterinaria();
            
          });
      } else {
        Swal.fire('Error', 'No se pudo agregar la veterinaria', 'error');
      }
    }
  });
}
editarVeterinaria(veterinaria: Veterinaria) {
    this.veterinariaSeleccionada = { ...veterinaria }; // copia para edición
    this.mostrarFormularioEditar = true;
  }

  guardarEdicion() {
  if (!this.veterinariaSeleccionada?.nombre || 
      !this.veterinariaSeleccionada?.direccion || 
      !this.veterinariaSeleccionada?.telefono) {
    Swal.fire('Error', 'Todos los campos son obligatorios', 'error');
    return;
  }

  this.peticion.editarV(this.veterinariaSeleccionada).subscribe({
    next: () => {
      Swal.fire('¡Actualizada!', 'La veterinaria ha sido actualizada correctamente', 'success')
        .then(() => {
          this.listar();
          this.mostrarFormularioEditar = false;
          this.veterinariaSeleccionada = null;
        });
    },
    error: (err) => {
      console.error('Error real:', err);

      // Si el backend devuelve status 200 pero Angular lo interpreta como error
      if (err.status >= 200 && err.status < 300) {
        Swal.fire('¡Actualizada!', 'La veterinaria ha sido actualizada correctamente', 'success')
          .then(() => {
            this.listar();
            this.mostrarFormularioEditar = false;
            this.veterinariaSeleccionada = null;
          });
      } else {
        Swal.fire('Error', 'No se pudo actualizar la veterinaria', 'error');
      }
    }
  });
}
 cancelarEdicion() {
    this.mostrarFormularioEditar = false;
    this.veterinariaSeleccionada = null;
  }
}
