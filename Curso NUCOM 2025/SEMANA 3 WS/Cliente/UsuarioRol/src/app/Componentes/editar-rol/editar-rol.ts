import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Peticion } from '../../services/peticion';
import { Rol } from '../../Entidad/Rol';
import { FormsModule } from '@angular/forms';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-editar-rol',
  imports: [FormsModule],
  templateUrl: './editar-rol.html',
  styleUrls: ['./editar-rol.css']
})
export class EditarRol implements OnInit {
  rol: Rol = { idRol: 0, privilegio: '' };

  constructor(
    private rutaActiva: ActivatedRoute,
    private peticion: Peticion,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = this.rutaActiva.snapshot.params['id'];
    this.peticion.buscarRolPorId(id).subscribe((data: Rol) => {
      this.rol = data;
    });
  }

 guardarCambios() {
  this.peticion.editarRol(this.rol).subscribe({
    next: () => {
      Swal.fire({
        icon: 'success',
        title: 'Cambios guardados',
        text: 'El rol fue actualizado correctamente ✅',
        timer: 2000,
        showConfirmButton: false,
      });
      this.router.navigate(['/listar-rol']);
    },
    error: (err) => {
      Swal.fire({
        icon: 'error',
        title: 'Error',
        text: err.error?.mensaje || 'No se pudo actualizar el rol ❌',
      });
    }
  });
}
}
