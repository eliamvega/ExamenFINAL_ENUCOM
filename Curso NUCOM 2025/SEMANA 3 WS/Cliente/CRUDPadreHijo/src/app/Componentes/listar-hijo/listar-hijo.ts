import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router'; // Importación para navegación
import { PeticionesWS } from '../../Service/peticiones-ws'; // Servicio HTTP
import { Hijo } from '../../Entidad/Hijo'; // Modelo Hijo
import { RouterModule } from '@angular/router';
@Component({
  selector: 'app-listar-hijo',
  standalone: true, // Componente independiente
  imports: [CommonModule,    RouterModule], // Para usar *ngIf, *ngFor
  templateUrl: './listar-hijo.html',
  styleUrls: ['./listar-hijo.css']
  
})
export class ListarHijo implements OnInit {
  hijos!: Hijo[]; // Arreglo para guardar los hijos

  constructor(private peticion: PeticionesWS, private router: Router) {}

  ngOnInit(): void {
    this.listar();
  }

  trackByHijoId(index: number, hijo: Hijo): number {
    return hijo.idHijo;
  }

  listar(): void {
    this.peticion.listarH().subscribe(respuesta => {
      console.log('Respuesta del backend hijos:', respuesta);
      this.hijos = respuesta;
    });
  }

  nuevo(): void {
    this.router.navigate(['nuevo-hijo']);
  }

  editar(idHijo: number): void {
    localStorage.setItem('idHijo', idHijo.toString());
    this.router.navigate(['editar-hijo']);
  }

  eliminar(idHijo: number): void {
    const hijo = new Hijo();
    hijo.idHijo = idHijo;

    this.peticion.eliminarH(hijo).subscribe({
      next: () => {
        alert('Hijo eliminado correctamente');
        this.listar(); // Refresca la lista tras eliminar
      },
      error: (err) => {
        console.error('Error al eliminar hijo:', err);
        alert('Error al eliminar el hijo');
      }
    });
  }
}
