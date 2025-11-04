//private Long idUsuario;
    //private String nombre;
   // private String app;
   // private String apm;
   // private String sexo;

  export class Usuario {
  idUsuario?: number;
  nombre!: string;
  app!: string;
  apm!: string;
  sexo!: string;
  fechaNacimiento!: Date;
  fechaCreacion!: Date;
  correo!: string;
  rol!: { rolId: number }; // Asegúrate de que rol está definido
}
