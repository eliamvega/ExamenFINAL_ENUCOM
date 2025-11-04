package com.mx.Principal;

import java.util.ArrayList;
import java.util.List;

public class Principal {

	
	public static void main(String[] args) {
		
		List<Alumno> alumnos = new ArrayList<Alumno>();
		
		alumnos.add(new Alumno(123,"JUAN", "LOPEZ","LOPEZ","UNAM", 25));
		alumnos.add(new Alumno(122,"MARIA", "PAZ", "SANCHEZ", "BUAP", 28));
		
		alumnos.add(new Alumno(560,"MIGUEL", "ROSAS","VEGA","UNAM", 25));
		alumnos.add(new Alumno(500,"ISABEL", "ANDRADE", "SANCHEZ", "UVA", 23));
		
		alumnos.add(new Alumno(1701, "GRICELDA","LORENZO", "GARCIA", "ITSOEH", 25));
	    alumnos.add(new Alumno(1810, "JORGE", "MENDOZA", "MARQUEZ", "UAEH", 240));
	    
	    alumnos.add(new Alumno(1701, "ARIEL","LORENZO", "PORTILO", "ITSOEH", 25));
	    alumnos.add(new Alumno(1810, "MARTIN", "LOPEZ", "MARQUEZ", "UAEH", 240));
	    
		//EXPRESION LAMBDA
	    
	    alumnos.forEach(
	    //expresion lambda
	    
	    (alumno) ->{System.out.println("alumno : " + alumno.getNombre() + " " + alumno.getApellidoP());}
	    	 );
	    
	    //APLICANDO FILTRO
	    
	    alumnos.stream().filter(
	    		
	    		//expresion lambda
	    		
	    		alumno -> alumno.getUniversidad().equalsIgnoreCase("unam")
	    		).forEach(
	    			//expresion lambda
	    				
	    			    alumno -> {System.out.println("alumno : " + alumno.getNombre() + " " + alumno.getApellidoP() + " " + alumno.getApellidoM ()+ 
	    			    		" estudia en la " + alumno.getUniversidad());}
	    		    	 );
	    				
	}
}
