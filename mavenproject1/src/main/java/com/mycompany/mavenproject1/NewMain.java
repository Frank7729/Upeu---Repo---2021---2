package com.mycompany.mavenproject1;

import folder.Celular;
//import folder.Person;

public class NewMain {

    public static void main(String[] args) {
        /*Person p1=new Person();
        p1.setName("Jose");
        p1.laugth();
        
        System.out.println("Holasss");
        
        Person p2=new Person();
        p2.setName("Mary");
        p2.laugth(); */
        
        Celular c1=new Celular("LG","Blanco");
        c1.llamar();
        
        Celular c2=new Celular("Samsung","Negro");
        c2.llamar();
        
        Celular dcelular=new Celular();
        dcelular.detalleCelular(c2);
    }   
}
