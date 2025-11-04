import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Hijo } from '../../Entidad/Hijo';
import { Padre } from '../../Entidad/Padre';
import { PeticionesWS } from '../../Service/peticiones-ws';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-formulario-hijo',
  templateUrl: './formulario-hijo.html',
  styleUrls: ['./formulario-hijo.css']
})
export class FormularioHijo implements OnInit {
  hijo: Hijo = new Hijo();
  padres: Padre[] = [];

  constructor(
    private ruta: ActivatedRoute,
    private servicio: PeticionesWS
  ) {}

  ngOnInit(): void {
    const id = this.ruta.snapshot.paramMap.get('id');
    if (id) {
      this.servicio.buscarHijoPorId(+id).subscribe((res: Hijo) => {
        this.hijo = res;
      });
    }

    this.servicio.listarPadres().subscribe((res: Padre[]) => {
      this.padres = res;
    });
  }

  guardar() {
    this.servicio.editarHijo(this.hijo).subscribe(() => {
      alert('Hijo actualizado correctamente');
    });
  }
}
