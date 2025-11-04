import { Routes } from '@angular/router';
import { Listar } from './Componentes/listar/listar';
import { ListarHijo } from './Componentes/listar-hijo/listar-hijo';
import { Guardar } from './Componentes/guardar/guardar'; // GuardarPadre
import { GuardarHijo } from './Componentes/guardar-hijo/guardar-hijo'; // GuardarHijo
import { FormularioHijo } from './Componentes/formulario-hijo/formulario-hijo';

export const routes: Routes = [
  { path: 'listar', component: Listar },
  { path: 'listar-hijo', component: ListarHijo },
  { path: 'nuevo', component: Guardar },
  { path: 'nuevo-hijo', component: GuardarHijo },
  { path: 'editar', component: Guardar }, // Ruta para editar padre
  { path: 'editar-hijo/:id', component: FormularioHijo }
];
