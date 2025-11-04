import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
// Importación de la clase Padre desde su ubicación (aunque parece haber un error en la ruta)
import { Padre } from '../ ../../Entidad/Padre';
// Importación de la clase Hijo
import { Hijo } from '../ ../../Entidad/Hijo';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PeticionesWS {
  private url = "http://localhost:8001/api/padre";
  private urlHijo = "http://localhost:8001/api/hijo";

  constructor(private http: HttpClient) { }

  listarP(): Observable<Padre[]> {
    return this.http.get<Padre[]>(`${this.url}/listar`);
  }

  listarH(): Observable<Hijo[]> {
    return this.http.get<Hijo[]>(`${this.urlHijo}/listar`);
  }

  guardarP(padre: Padre): Observable<string> {
    return this.http.post(this.url + "/guardar", padre, { responseType: 'text' });
  }

  guardarH(hijo: Hijo): Observable<string> {
    return this.http.post(this.urlHijo + "/guardar", hijo, { responseType: 'text' });
  }

  buscarP(padre: Padre) {
    return this.http.post<Padre>(this.url + "/buscar", padre);
  }

  editarP(padre: Padre) {
    return this.http.put<String>(this.url + "/editar", padre);
  }

  eliminarP(padre: Padre) {
    return this.http.delete<void>(this.url + "/eliminar", { body: padre });
  }

  eliminarH(hijo: Hijo) {
    return this.http.delete<void>(`${this.urlHijo}/eliminar-hijo`, { body: hijo });
  }
  buscarHijoPorId(id: number) {
  return this.http.post<Hijo>(`${this.urlHijo}/buscar`, { idHijo: id });
}

editarHijo(hijo: Hijo) {
  return this.http.put(`${this.urlHijo}/editar`, hijo);
}

listarPadres() {
  return this.http.get<Padre[]>(`${this.url}/listar`);
}
}