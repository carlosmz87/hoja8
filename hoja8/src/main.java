import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DiegoJossué
 */
public class main {
    public static void main(String args []){
      VectorHeap pacientes=new VectorHeap();
      paciente p;
      int contador=0;
      String nombre="";
      String sintoma="";
      String codigo="";
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
 
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File ("C:\\pacientes.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
 
         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null)
            contador=0;
            System.out.println(linea);
            for(int i=0;i<(linea.length()-1);i++){
                if(contador==0&&linea.charAt(i)!=','){
                    nombre=nombre+linea.charAt(i);
                }else{
                    if(contador==1&&linea.charAt(i)!=','){
                        sintoma=sintoma+linea.charAt(i);
                    }else{
                        if(contador==2&&linea.charAt(i)!=','){
                            if(linea.charAt(i)!=' '){
                                codigo=codigo+linea.charAt(i);
                            }
                        }else
                            if(linea.charAt(i)==','){
                                contador++;
                                
                            }
                    }
                }
            }
            p=new paciente(nombre,sintoma,codigo);
            pacientes.add(p);
            
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }

    }
}
