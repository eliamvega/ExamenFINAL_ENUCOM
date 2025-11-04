import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Rol } from '../Entidad/Rol';
import { Usuario } from '../Entidad/Usuario';

@Injectable({
  providedIn: 'root'
})
export class Peticion {
  constructor(private http: HttpClient) {}
//private readonly es una combinación de dos modificadores de acceso: Significa que la propiedad solo 
// se puede acceder desde dentro de la clase donde está declarada.
  // Base del API Gateway 
  private readonly apiBase = 'http://localhost:9000';
  private readonly urlRol = `${this.apiBase}/api/rol`;
  private readonly urlUsuario = `${this.apiBase}/api/usuario`;
  private usernme ='eliam';
  private password ='12345';
  // -------- ROL --------
  listarR(): Observable<Rol[]> {
    return this.http.get<Rol[]>(`${this.urlRol}/listar`);
  }
  listarRoles(): Observable<Rol[]> {
    return this.http.get<Rol[]>(`${this.urlRol}/listar`);
  }
//es guardar 
  agregarR(rol: Rol): Observable<string> {
    return this.http.post(`${this.urlRol}/guardar`, rol, { responseType: 'text' });
  }

  buscarRolPorId(id: number): Observable<Rol> {
    return this.http.post<Rol>(`${this.urlRol}/buscar`, { idRol: id });
  }

  editarRol(rol: Rol): Observable<any> {
    return this.http.put(`${this.urlRol}/editar`, rol);
  }

  eliminarR(id: number): Observable<any> {
    return this.http.request('delete', `${this.urlRol}/eliminar`, {
      body: { idRol: id }
    });
  }

  // (Opcional) usuarios por rol si ya tienes el endpoint en RolService
  usuariosPorRol(rolId: number): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(`${this.urlRol}/usuarios/${rolId}`);
  }

  // -------- USUARIO --------
  listarU(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(`${this.urlUsuario}/listar`);
  }

  agregarUsuario(usuario: Usuario): Observable<string> {
    return this.http.post(`${this.urlUsuario}/guardar`, usuario, { responseType: 'text' });
  }

  buscarUsuario(id: number): Observable<Usuario> {
    return this.http.post<Usuario>(`${this.urlUsuario}/buscar`, { idUsuario: id });
  }

  actualizarUsuario(usuario: Usuario): Observable<string> {
    return this.http.put(`${this.urlUsuario}/editar`, usuario, { responseType: 'text' });
  }

  eliminarU(id: number): Observable<string> {
    return this.http.request('delete', `${this.urlUsuario}/eliminar`, {
      body: { idUsuario: id },
      responseType: 'text'
    });
  }
}
