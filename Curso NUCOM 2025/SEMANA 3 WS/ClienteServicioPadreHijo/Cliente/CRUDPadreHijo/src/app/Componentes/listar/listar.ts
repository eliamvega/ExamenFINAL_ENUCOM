import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PeticionesWS } from '../../Service/peticiones-ws'; // Servicio que hace las peticiones HTTP
import { Padre } from '../../Entidad/Padre'; // Entidad Padre
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar',
  standalone: true, // Componente independiente (no forma parte de un módulo)
  imports: [CommonModule], // Necesario para usar *ngIf y *ngFor
  templateUrl: './listar.html',
  styleUrls: ['./listar.css']
})
export class Listar implements OnInit {
  padres!: Padre[]; // Arreglo donde se guardarán los padres obtenidos del backend

  constructor(private peticion: PeticionesWS, private router: Router) {}

  // Se ejecuta al cargar el componente
  ngOnInit(): void {
  console.log('Listar componente cargado');
  this.listar();
}

  // Método para optimizar el renderizado al iterar
  trackByPadreId(index: number, padre: Padre): number {
    return padre.idPadre;
  }

  // Método que llama al servicio para obtener la lista de padres
  listar(): void {
    this.peticion.listarP().subscribe(respuesta => {
      console.log('Respuesta del backend:', respuesta);
      this.padres = respuesta;
    });
  }

nuevo(){
  this.router.navigate(['nuevo']);
}

editar(idPadre: Number){
  //alert(idPadre);
  localStorage.setItem("idPadre", idPadre.toString());
  this.router.navigate(["editar"]);
}

eliminar(idPadre: number) {
  const padre = new Padre();
  padre.idPadre = idPadre;

  this.peticion.eliminarP(padre).subscribe({
    next: () => {
      console.log("Padre eliminado correctamente");
      this.listar(); // recarga la lista después de eliminar
    },
    error: err => {
      console.error("Error al eliminar:", err);
    }
  });
}
}
