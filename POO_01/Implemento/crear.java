package POO_01.Implemento;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import POO_01.Listado.listar;

public class crear {
    
    List<listar> lis=new CopyOnWriteArrayList<>();
    int id=0;
    
    public void create(listar p){
        id=id+1;
        p.setId(id);
        lis.add(p);
    }
    
    public List<listar> list(){
        return lis;
    }
    
    public void delete(int id){
        for(listar ps:lis){
            if(id==ps.getId()){
                System.out.print("Eliminado: "+ps.getId()+" "+ps.getNombres()+" "+ps.getAp_paterno()+" "+ps.getAp_materno()+" "+ps.getSexo());
                System.out.println();
                lis.remove(ps);
                for(listar p:list()){
                    System.out.print(p.getId()+" ");
                    System.out.print(p.getNombres()+" ");
                    System.out.print(p.getAp_paterno()+" ");
                    System.out.print(p.getAp_materno()+" ");
                    System.out.println(p.getSexo());            
                }
            } 
        }
    }
    
}