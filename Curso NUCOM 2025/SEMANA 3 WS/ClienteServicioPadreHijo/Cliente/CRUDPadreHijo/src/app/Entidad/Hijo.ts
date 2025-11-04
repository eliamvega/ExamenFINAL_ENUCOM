import { Padre } from './Padre';

export class Hijo {
  idHijo!: number;
  nombre!: string;
  apellido!: string;
  edad!: number;
  hobbie!: string;
  padre!: Padre; // <-- ahora sí es coherente
}
