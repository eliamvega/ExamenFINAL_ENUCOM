import { Component, OnInit } from '@angular/core';
import { Peticion } from '../../services/peticion';
import { Rol } from '../../Entidad/Rol';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-listar-rol',
  imports: [FormsModule],
  templateUrl: './listar-rol.html',
  styleUrl: './listar-rol.css'
})
export class ListarRol implements OnInit {
 constructor(private peticion: Peticion, private router: Router) {}
  ngOnInit(): void {
  this.listar();
}
roles !: Rol[]; //List<Rol> roles = service.listar();
listar(){
  this.peticion.listarR().subscribe(respuesta =>{
    console.log(JSON.stringify(respuesta));
    this.roles = respuesta;
  })
}
eliminarRol(id: number): void {
  Swal.fire({
    title: '¿Estás seguro?',
    text: 'Esta acción eliminará el rol permanentemente.',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonText: 'Sí, eliminar',
    cancelButtonText: 'Cancelar',
    confirmButtonColor: '#d33',
    cancelButtonColor: '#3085d6',
  }).then((result) => {
    if (result.isConfirmed) {
      this.peticion.eliminarR(id).subscribe({
        next: (resp: any) => {
          // Aquí se interpreta como texto
          const mensaje = typeof resp === 'string' ? resp : 'Rol eliminado con éxito ✅';

          Swal.fire({
            icon: 'success',
            title: 'Eliminado',
            text: mensaje,
            confirmButtonColor: '#28a745',
            timer: 2500,
            showConfirmButton: false
          });

          this.listar(); // Recarga la tabla
        },
        error: (err) => {
          Swal.fire({
            icon: 'error',
            title: 'Error al eliminar',
            text: err.error?.mensaje || 'No se pudo eliminar el rol ❌',
            confirmButtonColor: '#dc3545'
          });
        }
      });
    }
  });
}
irAgregarRol() {
  this.router.navigate(['/agregar-rol']);
}
irEditarRol(id: number) {
  this.router.navigate(['/editar-rol', id]);
}
irAgregarUsuario() {
  this.router.navigate(['/agregar-usuario']);
}
}
