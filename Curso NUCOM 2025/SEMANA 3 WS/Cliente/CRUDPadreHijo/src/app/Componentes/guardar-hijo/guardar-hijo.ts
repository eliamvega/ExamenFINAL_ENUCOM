import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Hijo } from '../../Entidad/Hijo';
import { Padre } from '../../Entidad/Padre';
import { PeticionesWS } from '../../Service/peticiones-ws';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-guardar-hijo',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './guardar-hijo.html',
  styleUrls: ['./guardar-hijo.css']
})
export class GuardarHijo {
  hijo = new Hijo();      // Objeto hijo a guardar
  padres: Padre[] = [];   // Lista de padres para el combo

  constructor(private peticion: PeticionesWS, private router: Router) {}

  ngOnInit() {
    // Al iniciar, cargar los padres disponibles
    this.peticion.listarP().subscribe(data => {
      this.padres = data;
    });
  }

  guardar() {
    this.peticion.guardarH(this.hijo).subscribe({
      next: (mensaje: string) => {
        Swal.fire({
          icon: 'success',
          title: 'GUARDADO',
          text: mensaje,
          timer: 2000,
          showConfirmButton: false
        });
        this.router.navigate(['listar-hijo']);
      },
      error: error => {
        const mensaje = error?.error?.mensaje || 'Ocurrió un error al guardar';
        console.error(error);
        Swal.fire({
          title: 'Error',
          icon: 'error',
          text: mensaje,
          timer: 2000
        });
      }
    });
  }
}
