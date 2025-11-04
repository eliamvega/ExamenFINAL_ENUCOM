import { Routes } from '@angular/router';
import { ListarVeterinaria } from './Componentes/listar-veterinaria/listar-veterinaria';
import { ListarResponsables } from './Componentes/listar-responsables/listar-responsables';
import { ListarMascotas } from './Componentes/listar-mascotas/listar-mascotas';
import { ListarClientes } from './Componentes/listar-clientes/listar-clientes';

export const routes: Routes = [
    {path: "listarVeterinaria", component: ListarVeterinaria},
    {path: "listarResponsable", component: ListarResponsables},
    {path: "listarMascota", component: ListarMascotas},
    {path: "listarCliente", component: ListarClientes}
];
