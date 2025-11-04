import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class AreaService {
  private apiUrl = 'http://localhost:9000/api/area';

  constructor(private http: HttpClient) {}

  getAreas(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  createArea(area: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, area);
  }

  updateArea(id: number, area: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${id}`, area);
  }

  deleteArea(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/${id}`);
  }

  deleteAllAreas(): Observable<any> {
    return this.http.delete<any>(this.apiUrl);
  }

  getEmpleadosPorArea(areaId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/${areaId}/empleados`);
  }
}
