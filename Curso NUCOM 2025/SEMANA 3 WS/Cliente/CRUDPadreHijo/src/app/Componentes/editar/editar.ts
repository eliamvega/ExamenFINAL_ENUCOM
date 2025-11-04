import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { PeticionesWS } from '../../Service/peticiones-ws';
import { Padre } from '../../Entidad/Padre';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-editar',
  imports: [FormsModule],
  templateUrl: './editar.html',
  styleUrl: './editar.css'
})
export class Editar implements OnInit {

  constructor(private peticion: PeticionesWS, private router : Router) { }

  padre = new Padre();
  ngOnInit(): void {
    //alert(localStorage.getItem("idPadre"));
    this.buscar();
  }
    buscar(){
      this.padre.idPadre = Number(localStorage.getItem("idPadre"));
      this.peticion.buscarP(this.padre).subscribe(data => {
        console.log(JSON.stringify(data));
        this.padre = data;
      })
    }

    editar(){
      this.peticion.editarP(this.padre).subscribe(data =>{
        Swal.fire({
          title: 'EDITAR',
          text: JSON.stringify(data),
          icon: 'warning',
          timer: 2500,
          showConfirmButton: false
        });
        this.router.navigate(['listar']);
      })
    }
  
}
