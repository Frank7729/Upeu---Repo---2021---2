package POO_01.Menu;

import java.util.Scanner;
import POO_01.Implemento.*;
import POO_01.Listado.listar;

public class main {
    Scanner teclado=new Scanner(System.in);
    crear ip=new crear();

    public void Crear(){
        
        listar p1=new listar();
        p1.setNombres("Frank");
        p1.setAp_paterno("Chunca");
        p1.setAp_materno("Mamani");
        p1.setSexo("M");
        
        listar p2=new listar();
        p2.setNombres("Mirco");
        p2.setAp_paterno("Suarez");
        p2.setAp_materno("Pilar");
        p2.setSexo("M");
        
        listar p3=new listar();
        p3.setNombres("Alex");
        p3.setAp_paterno("Cereceda");
        p3.setAp_materno("Soncco");
        p3.setSexo("M");
        
        ip.create(p1); 
        ip.create(p2);
        ip.create(p3);

        System.out.println("¡¡¡¡ Se creo Correctamente !!!!");
    }

    public void Listar(){
        for(listar p:ip.list()){
            System.out.print(p.getId()+" ");
            System.out.print(p.getNombres()+" ");
            System.out.print(p.getAp_paterno()+" ");
            System.out.print(p.getAp_materno()+" ");
            System.out.println(p.getSexo());           
        }
    }

    public void Eliminar(){        

        Listar();
        int id;
        System.out.print("Elimine el numero : ");      
        id=teclado.nextInt();
        ip.delete(id);
    }
    
    public void menuMain(){   
    String mensaje="\nEjecutamos el siguiente algoritmo:"+
    "\n     1=Crear"+
    "\n     2=Listar"+
    "\n     3=Eliminar"+
    "\n     0=Salir del programa";
    System.out.print(mensaje+"\nElija la opcion del 0 - 3 : ");
    int opcion=0;
    opcion=teclado.nextInt();
    System.out.println("");
    do{        
        switch(opcion){
            case 1: Crear();break;
            case 2: Listar();break;
            case 3: Eliminar();break;
        }
        if(opcion!=0){
            System.out.print(mensaje+"\n   Elija la opcion del 0 - 3 : ");
            opcion=teclado.nextInt();          
        }
        System.out.println("");
    }while(opcion!=0);              
}
    
    public static void main(String[] args) {;
        main sp=new main();
        sp.menuMain();
    }
    
}
