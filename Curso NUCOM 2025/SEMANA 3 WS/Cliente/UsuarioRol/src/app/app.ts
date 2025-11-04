import { Component, signal } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { ListarUsuario } from './Componentes/listar-usuario/listar-usuario';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('UsuarioRol');
  constructor(private router:Router) {}

  listar(){
    this.router.navigate(["listarRol"]);
  }
  
  listarU(){
    this.router.navigate(["listarUsuario"]);
  }
   irAgregarRol() {
    this.router.navigate(['/agregar-rol']);
  }
   irAgregarUsuario() {
    this.router.navigate(['/agregar-usuario']);
  }
}
