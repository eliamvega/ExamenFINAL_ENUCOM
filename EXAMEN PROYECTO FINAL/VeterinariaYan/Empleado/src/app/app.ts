import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { EmpleadoAreaComponent } from './empleado-area.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, HttpClientModule, EmpleadoAreaComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('Empleado');
}
