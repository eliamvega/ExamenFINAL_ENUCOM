// Importa el decorador Component de Angular para definir un componente
import { Component } from '@angular/core';

// Importa FormsModule para habilitar el uso de [(ngModel)] en los formularios
import { FormsModule } from '@angular/forms';

// Importa la clase Padre desde el archivo correspondiente
import { Padre } from '../../Entidad/Padre'; // Entidad Padre

// Importa Swal para alertas bonitas
import Swal from 'sweetalert2';

// Importa Router para navegación programática
import { Router } from '@angular/router';

// Importa el servicio correctamente (con P mayúscula)
import { PeticionesWS } from '../../Service/peticiones-ws';

@Component({
  selector: 'app-guardar',
  imports: [FormsModule],
  templateUrl: './guardar.html',
  styleUrls: ['./guardar.css']
})
export class Guardar {
  // Inyecta correctamente el servicio con la clase PeticionesWS
  constructor(private peticion: PeticionesWS, private router: Router) {}

  padre = new Padre();

  nuevo() {
  this.peticion.guardarP(this.padre).subscribe({
    next: (mensaje: string) => {
      Swal.fire({
        icon: 'success',
        title: 'GUARDAR',
        text: mensaje, // Mostrará: Padre guardado correctamente
        showConfirmButton: false,
        timer: 2000
      });
      this.router.navigate(['listar']);
    },
    error: (error: any) => {
      const mensaje = error?.error?.mensaje || 'Ocurrió un error inesperado';
      console.error(error);
      Swal.fire({
        title: 'Error al guardar',
        icon: 'error',
        text: mensaje,
        timer: 2000
      });
    }
  });
}

}
