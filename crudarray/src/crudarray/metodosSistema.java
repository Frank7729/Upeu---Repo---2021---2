package crudarray;

import java.util.ArrayList;

public class metodosSistema {
    
        public ArrayList<datosPersona> listaPersonas=new ArrayList<>();
        
        public void registrarPersona(Object x){
            listaPersonas.add((datosPersona) x);
        }
        
        public void eliminarPersona(String x){
            for(int i=0;i<listaPersonas.size();i++){
                datosPersona dp=listaPersonas.get(i);
                if(x.equals(dp.nombres)){
                    listaPersonas.remove(i);  
                }
            }
        }
}
