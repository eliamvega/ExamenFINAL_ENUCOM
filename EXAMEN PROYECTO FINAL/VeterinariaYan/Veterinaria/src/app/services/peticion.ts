import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Veterinaria } from '../Entidad/Veterinaria';
import { Responsable } from '../Entidad/Responsable';
import { Mascota } from '../Entidad/Mascota';
import { Cliente } from '../Entidad/Cliente';

@Injectable({
  providedIn: 'root'
})
export class Peticion {
constructor (private http: HttpClient){}

url="http://localhost:9000/api/veterinaria"
urlR="http://localhost:9000/api/responsable"
urlM="http://localhost:9000/api/mascota"
urlC="http://localhost:9000/api/cliente"
listarV(){
 return this.http.get<Veterinaria[]>(this.url + "/listar");
}
  
listarR(){
  return this.http.get<Responsable[]>(this.urlR + "/listar");
}
listarM(){
  return this.http.get<Mascota[]>(this.urlM + "/listar");
}
listarC(){
  return this.http.get<Cliente[]>(this.urlC + "/listar");
}

eliminarR(responsable: Responsable) {
  return this.http.delete(this.urlR + "/eliminar", { body: responsable });
}
eliminarV(veterinaria: Veterinaria) {
  return this.http.delete(this.url + "/eliminar", { body: veterinaria });
}
eliminarC(cliente: Cliente) {
  return this.http.delete(this.urlC + "/eliminar", { body: cliente });
}
eliminarM(mascota: Mascota) {
  return this.http.delete(this.urlM + "/eliminar", { body: mascota });
}
agregarV(veterinaria: Veterinaria) {
  return this.http.post(this.url + "/guardar", veterinaria);
}
agregarR(responsable: Responsable) {
  return this.http.post(this.urlR + "/guardar", responsable);
}
agregarM(mascota: Mascota) {
  return this.http.post(this.urlM + "/guardar", mascota);
}
agregarC(cliente: Cliente) {
  return this.http.post(this.urlC + "/guardar", cliente);
}
editarV(veterinaria: Veterinaria) {
    return this.http.put(this.url + "/editar", veterinaria);
  }
  editarR(responsable: Responsable) {
  return this.http.put(this.urlR + "/editar", responsable);
}
editarM(mascota: Mascota) {
  return this.http.put(this.urlM + "/editar", mascota);
}
editarC(cliente: Cliente) {
  return this.http.put(this.urlC + "/editar", cliente);
}
}
