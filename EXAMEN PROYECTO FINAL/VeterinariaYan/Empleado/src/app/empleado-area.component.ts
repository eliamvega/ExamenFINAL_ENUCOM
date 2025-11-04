import { Component } from '@angular/core';
import { EmpleadoService } from './services/empleado.service';
import { AreaService } from './services/area.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-empleado-area',
  templateUrl: './empleado-area.component.html',
  styleUrl: './empleado-area.component.css',
  standalone: true,
  imports: [CommonModule, FormsModule]
})
export class EmpleadoAreaComponent {
  empleados: any[] = [];
  areas: any[] = [];

  areaEmpleados: any = null;

  mostrarFormEmpleado = false;
  mostrarFormArea = false;

  empleadoEdit: any = { nombre: '', areaId: '' };
  areaEdit: any = { nombre: '' };

  constructor(
    private empleadoService: EmpleadoService,
    private areaService: AreaService
  ) {}

  // Empleado CRUD
  listarEmpleados() {
    this.empleadoService.getEmpleados().subscribe(data => {
      // Mapear los datos para asegurar que idEmpleado esté presente
      this.empleados = data.map((e: any) => ({
        empleadoId: e.idEmpleado ?? e.empleadoId ?? e.id,
        nombre: e.nombre,
        areaId: e.areaId
      }));
    });
  }

  onSubmitEmpleado() {
    this.crearEmpleado(this.empleadoEdit);
    this.resetEmpleadoForm();
    this.mostrarFormEmpleado = false;
  }

  crearEmpleado(empleado: any) {
    this.empleadoService.createEmpleado({
      nombre: empleado.nombre,
      areaId: empleado.areaId
    }).subscribe(() => {
      this.listarEmpleados();
    });
  }

  setEmpleadoEdit(empleado: any) {
    this.empleadoEdit = { ...empleado };
  }

  resetEmpleadoForm() {
    this.empleadoEdit = { nombre: '', areaId: '' };
  }

  editarEmpleado(empleado: any) {
    this.empleadoService.updateEmpleado(empleado.id, empleado).subscribe(() => {
      this.listarEmpleados();
    });
  }

  eliminarEmpleado(id: number) {
    if (!id) {
      alert('No se puede eliminar: ID de empleado no válido.');
      return;
    }
    this.empleadoService.deleteEmpleado(id).subscribe(() => {
      this.listarEmpleados();
    });
  }

  eliminarTodosEmpleados() {
    this.empleadoService.deleteAllEmpleados().subscribe(() => {
      this.listarEmpleados();
    });
  }

  // Area CRUD
  listarAreas() {
    this.areaService.getAreas().subscribe(data => this.areas = data);
  }

  onSubmitArea() {
    this.crearArea(this.areaEdit);
    this.resetAreaForm();
    this.mostrarFormArea = false;
  }

  crearArea(area: any) {
    this.areaService.createArea({
      nombre: area.nombre
    }).subscribe(() => {
      this.listarAreas();
    });
  }

  setAreaEdit(area: any) {
    this.areaEdit = { ...area };
  }

  resetAreaForm() {
    this.areaEdit = { nombre: '' };
  }

  editarArea(area: any) {
    this.areaService.updateArea(area.id, area).subscribe(() => {
      this.listarAreas();
    });
  }

  eliminarArea(id: number) {
    if (!id) {
      alert('No se puede eliminar: ID de área no válido.');
      return;
    }
    this.areaService.deleteArea(id).subscribe(() => {
      this.listarAreas();
    });
  }

  eliminarTodosAreas() {
    this.areaService.deleteAllAreas().subscribe(() => {
      this.listarAreas();
    });
  }

  listarEmpleadosPorArea(area: any) {
    const areaId = area.idArea || area.id;
    if (!areaId) {
      alert('El área seleccionada no tiene un ID válido.');
      return;
    }
    this.areaService.getEmpleadosPorArea(areaId).subscribe(data => {
      // El backend responde con { area: {...}, empleados: [...] }
      this.areaEmpleados = data;
    });
  }
}
