import { Component, OnInit } from '@angular/core';
import { Peticion } from '../../services/peticion';
import { Cliente } from '../../Entidad/Cliente';
import Swal from 'sweetalert2';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-listar-clientes',
  imports: [CommonModule, FormsModule],
  templateUrl: './listar-clientes.html',
  styleUrl: './listar-clientes.css'
})
export class ListarClientes implements OnInit {
  constructor(private peticion: Peticion){}
  ngOnInit(): void {
    this.listarC();
  }
clientes !: Cliente[];
 nuevoCliente: Cliente = new Cliente();
  mostrarFormulario: boolean = false;
    clienteSeleccionado: Cliente | null = null;
  mostrarFormularioEditar: boolean = false;
listarC(){
  this.peticion.listarC().subscribe(respuesta =>{
    console.log(JSON.stringify(respuesta));
    this.clientes = respuesta;
  })
}
 eliminarC(cliente: Cliente) {
    Swal.fire({
      title: '¿Estás seguro?',
      text: 'Esta acción no se puede deshacer.',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Sí, eliminar',
      cancelButtonText: 'Cancelar'
    }).then((result) => {
      if (result.isConfirmed) {
        this.peticion.eliminarC(cliente).subscribe({
          next: () => {
            Swal.fire({
              title: '¡Eliminado!',
              text: 'El cliente ha sido eliminado correctamente.',
              icon: 'success'
            }).then(() => {
              this.listarC();
            });
          },
          error: (err) => {
            if (err.status === 200 || err.status === 204) {
              Swal.fire({
                title: '¡Eliminado!',
                text: 'El cliente ha sido eliminado correctamente.',
                icon: 'success'
              }).then(() => {
                this.listarC();
              });
            } else {
              Swal.fire({
                title: 'Error',
                text: 'No se pudo eliminar el cliente.',
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
    this.nuevoCliente = new Cliente();
  }

  agregarCliente() {
    if (!this.nuevoCliente.nombre || !this.nuevoCliente.contacto || !this.nuevoCliente.direccion) {
      Swal.fire('Error', 'Todos los campos son obligatorios', 'error');
      return;
    }

    this.peticion.agregarC(this.nuevoCliente).subscribe({
      next: () => {
        Swal.fire('¡Agregado!', 'El cliente ha sido registrado correctamente', 'success')
          .then(() => {
            this.listarC();
            this.mostrarFormulario = false;
            this.nuevoCliente = new Cliente();
          });
      },
      error: (err) => {
        console.error('Error real:', err);
        if (err.status >= 200 && err.status < 300) {
          Swal.fire('¡Agregado!', 'El cliente ha sido registrado correctamente', 'success')
            .then(() => {
              this.listarC();
              this.mostrarFormulario = false;
              this.nuevoCliente = new Cliente();
            });
        } else {
          Swal.fire('Error', 'No se pudo agregar el cliente', 'error');
        }
      }
    });
  }
  editarCliente(cliente: Cliente) {
    this.clienteSeleccionado = { ...cliente }; // copia para edición
    this.mostrarFormularioEditar = true;
  }

  guardarEdicion() {
    if (!this.clienteSeleccionado?.nombre || !this.clienteSeleccionado?.direccion || !this.clienteSeleccionado?.contacto) {
      Swal.fire('Error', 'Todos los campos son obligatorios', 'error');
      return;
    }

    this.peticion.editarC(this.clienteSeleccionado).subscribe({
      next: () => {
        Swal.fire('¡Actualizado!', 'El cliente ha sido actualizado correctamente', 'success')
          .then(() => {
            this.listarC();
            this.mostrarFormularioEditar = false;
            this.clienteSeleccionado = null;
          });
      },
      error: (err) => {
        console.error('Error real:', err);

        if (err.status >= 200 && err.status < 300) {
          Swal.fire('¡Actualizado!', 'El cliente ha sido actualizado correctamente', 'success')
            .then(() => {
              this.listarC();
              this.mostrarFormularioEditar = false;
              this.clienteSeleccionado = null;
            });
        } else {
          Swal.fire('Error', 'No se pudo actualizar el cliente', 'error');
        }
      }
    });
  }

  cancelarEdicion() {
    this.mostrarFormularioEditar = false;
    this.clienteSeleccionado = null;
  }
}
