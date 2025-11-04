import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { RouterModule } from '@angular/router'; // Importa RouterModule completo para evitar advertencias
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterModule, CommonModule], // Usa RouterModule en vez de solo RouterOutlet
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class App {
  protected title = 'CRUDPadreHijo';

  constructor(private router: Router) {}

  listar() {
    this.router.navigate(['listar']);
  }
}








