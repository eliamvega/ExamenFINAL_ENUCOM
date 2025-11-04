import { Component, OnInit } from '@angular/core';
import { Peticion } from '../../services/peticion';
import { Usuario } from '../../Entidad/Usuario';
import Swal from 'sweetalert2';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
@Component({
  selector: 'app-listar-usuario',
  imports: [FormsModule,CommonModule],
  templateUrl: './listar-usuario.html',
  styleUrl: './listar-usuario.css'
})
export class ListarUsuario implements OnInit {
constructor(private peticion: Peticion, private router: Router) {}
  ngOnInit(): void {
this.listar();  
}
usuarios !: Usuario[];
listar(){
  this.peticion.listarU().subscribe(respuesta =>{
    console.log(JSON.stringify(respuesta));
    this.usuarios = respuesta;
  })
}
eliminarUsuario(id: number): void {
  Swal.fire({
    title: '¿Estás seguro?',
    text: '¡No podrás revertir esto!',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Sí, eliminar',
    cancelButtonText: 'Cancelar'
  }).then((result) => {
    if (result.isConfirmed) {
      this.peticion.eliminarU(id).subscribe({
        next: (msg: string) => {
          Swal.fire({
            icon: 'success',
            title: '¡Eliminado!',
            text: msg,
            confirmButtonText: 'Aceptar'
          });
          this.listar(); // refresca la lista
        },
        error: (err) => {
          console.error('Error al eliminar usuario:', err);
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
            title: 'No se pudo eliminar el usuario',
            text: mensaje,
            confirmButtonText: 'Aceptar'
          });
        }
      });
    }
  });
}
irAEditar(id: number): void {
  this.router.navigate(['/editar-usuario', id]);
}
}