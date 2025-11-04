import { Routes } from '@angular/router';
import { ListarRol } from './Componentes/listar-rol/listar-rol';
import { ListarUsuario } from './Componentes/listar-usuario/listar-usuario';
import { AgregarRolComponent } from './Componentes/agregar-rol/agregar-rol';
import { EditarRol } from './Componentes/editar-rol/editar-rol';
import { AgregarUsuario } from './Componentes/agregar-usuario/agregar-usuario';
import { EditarUsuario } from './Componentes/editar-usuario/editar-usuario';
export const routes: Routes = [
    {path:"listarRol",component:ListarRol},
    {path:"listarUsuario",component:ListarUsuario},
    { path: 'agregar-rol', component: AgregarRolComponent },
    { path: 'editar-rol/:id', component: EditarRol },
    { path: 'agregar-usuario', component: AgregarUsuario },
    { path: 'editar-usuario/:id', component: EditarUsuario }
    
];
