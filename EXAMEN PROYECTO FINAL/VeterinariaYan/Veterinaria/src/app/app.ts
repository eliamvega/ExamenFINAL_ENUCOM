import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('Veterinaria');
  constructor(private router:Router) {}

  listar(){
    this.router.navigate(["listarVeterinaria"]);
  }
  listarR(){
    this.router.navigate(["listarResponsable"]);
  }
  listarM(){
    this.router.navigate(["listarMascota"]);
  }
  listarC(){
    this.router.navigate(["listarCliente"]);
  }
}
