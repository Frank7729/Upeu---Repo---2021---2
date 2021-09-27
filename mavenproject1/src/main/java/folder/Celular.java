package folder;

public class Celular {
    
    private String nombre;
    private String color;
    
    public Celular(String nombre, String color){     
        this.nombre= nombre;
        this.color=color;
    }
    
    public Celular(){       
    }
    
    public void llamar(){
        System.out.println("Llamando a: "+nombre+
                            " Color: "+color);
    }
    
    public void detalleCelular(Celular celular){
        System.out.println("Detalle del Celular:");
        System.out.println("Nombre: "+celular.nombre+
                            " Color: "+celular.color);
    }
}
