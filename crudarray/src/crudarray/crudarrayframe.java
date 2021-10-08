package crudarray;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class crudarrayframe extends JFrame {
    
    metodosSistema ms=new metodosSistema();
    
    JLabel lb_nombre=new JLabel("Nombre");
    JTextField txt_nombre=new JTextField();
    
    JLabel lb_apellido_paterno=new JLabel("Ap. Paterno");
    JTextField txt_apellido_paterno=new JTextField();
    
    JLabel lb_apellido_materno=new JLabel("Ap. Materno");
    JTextField txt_apellido_materno=new JTextField();
    
    JLabel lb_codigo=new JLabel("Codigo");
    JTextField txt_codigo=new JTextField();
    
    public crudarrayframe(){
        JMenuBar menubar=new JMenuBar();
        
        JMenu menuFile=new JMenu();
        JMenu menuMantenimiento=new JMenu();
        JMenu menuReports=new JMenu();
        
        JMenuItem menuFile_Exit=new JMenuItem();
        
        JMenuItem menuMantenimiento_Ingresar=new JMenuItem();
        JMenuItem menuMantenimiento_Eliminar=new JMenuItem();
        
        JMenuItem menuReports_General=new JMenuItem();
        JMenuItem menuReports_Detallado=new JMenuItem();
    
        menuFile.setText("File");
        menuFile_Exit.setText("Salir");
        
        menuMantenimiento.setText("Crud");
        menuMantenimiento_Ingresar.setText("Registrar");
        menuMantenimiento_Eliminar.setText("Eliminar");
        
        menuReports.setText("Reportes");
        menuReports_General.setText("Global");
        menuReports_Detallado.setText("Detalle");
          
        menuFile.add(menuFile_Exit);
        
        menuMantenimiento.add(menuMantenimiento_Eliminar);
        menuMantenimiento.add(menuMantenimiento_Ingresar);
        
        menuReports.add(menuReports_General);
        menuReports.add(menuReports_Detallado);
        
        menubar.add(menuFile);
        menubar.add(menuMantenimiento);
        menubar.add(menuReports);

        setTitle("Practicando Crud con Vector");
        setJMenuBar(menubar);
        setSize(new Dimension(500,500)); 
        setLocationRelativeTo(menubar);
        
        menuFile_Exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        
        menuMantenimiento_Eliminar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JPanel panel1=new JPanel(new GridLayout(1,2));
                panel1.add(lb_nombre);
                panel1.add(txt_nombre);
                
                JPanel panel4=new JPanel(new GridLayout(1,2));
                panel4.add(lb_codigo);
                panel4.add(txt_codigo);
                
                Object msg[]={panel1, panel4};

                do{
                    if(JOptionPane.showOptionDialog(null, msg, "Eliminar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null,null,null)==JOptionPane.OK_OPTION){
                        datosPersona dp=new datosPersona();
                        dp.nombres=txt_nombre.getText();
                        dp.codigo=txt_codigo.getText();
                        if(txt_nombre.getText().equals("") || txt_codigo.getText().equals("")){                        
                            JOptionPane.showMessageDialog(null,"Complete sus datos", "Registro",  JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            System.out.print("Eliminado "+dp.nombres);
                            ms.eliminarPersona(txt_nombre.getText());
                            JOptionPane.showMessageDialog(null,"Se elimino con exito", "Registro",  JOptionPane.INFORMATION_MESSAGE);
                        }                      
                    }                        
                }while(txt_nombre.getText().equals("") || txt_codigo.getText().equals(""));
                txt_nombre.setText("");
                txt_apellido_paterno.setText("");
                txt_apellido_materno.setText("");
                txt_codigo.setText("");
            }
        });
        
        menuMantenimiento_Ingresar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JPanel panel1=new JPanel(new GridLayout(1,2));
                panel1.add(lb_nombre);
                panel1.add(txt_nombre);
                
                JPanel panel2=new JPanel(new GridLayout(1,2));
                panel2.add(lb_apellido_paterno);
                panel2.add(txt_apellido_paterno);
                
                JPanel panel3=new JPanel(new GridLayout(1,2));
                panel3.add(lb_apellido_materno);
                panel3.add(txt_apellido_materno);
                
                JPanel panel4=new JPanel(new GridLayout(1,2));
                panel4.add(lb_codigo);
                panel4.add(txt_codigo);
                
                Object msg[]={panel1, panel2, panel3, panel4};
                
                do{
                    if(JOptionPane.showOptionDialog(null, msg, "Registrar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null,null,null)==JOptionPane.OK_OPTION){
                        datosPersona dp=new datosPersona();
                        dp.nombres=txt_nombre.getText();
                        dp.ap_paterno=txt_apellido_paterno.getText();
                        dp.ap_materno=txt_apellido_materno.getText();
                        dp.codigo=txt_codigo.getText();
                            if(txt_nombre.getText().equals("") || txt_apellido_paterno.getText().equals("") || txt_apellido_materno.getText().equals("") || txt_codigo.getText().equals("")){                        
                                JOptionPane.showMessageDialog(null,"Complete sus datos", "Registro",  JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                System.out.print("Insertar "+dp.nombres);
                                ms.registrarPersona(dp);
                                JOptionPane.showMessageDialog(null,"Se registro con exito", "Registro",  JOptionPane.INFORMATION_MESSAGE);
                            }
                    }
                }while(txt_nombre.getText().equals("") || txt_apellido_paterno.getText().equals("") || txt_apellido_materno.getText().equals("") || txt_codigo.getText().equals(""));
                txt_nombre.setText("");
                txt_apellido_paterno.setText("");
                txt_apellido_materno.setText("");
                txt_codigo.setText("");
            }
        });
    
        menuReports_General.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String columnas[]={"Nombres","Paterno","Materno","Codigo"};
                Object filas[][]=new Object[ms.listaPersonas.size()][4];
                
                ArrayList nuevoArray=ms.listaPersonas;
                for(int i=0;i<nuevoArray.size();i++){
                    datosPersona v=(datosPersona)ms.listaPersonas.get(i);
                    filas[i][0]=v.nombres;
                    filas[i][1]=v.ap_paterno;
                    filas[i][2]=v.ap_materno;
                    filas[i][3]=v.codigo;
                }                
                JTable tabla=new JTable(filas, columnas);
                JScrollPane tabla1=new JScrollPane(tabla);
                JPanel reporte=new JPanel();
                reporte.add(tabla1);
                Object msg []={reporte};
                JOptionPane.showMessageDialog(null,msg,"Reporte", JOptionPane.QUESTION_MESSAGE);
            }
        });
    }
}
