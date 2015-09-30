/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carlosmartinez
 */
public class paciente implements Comparable {
    private String nombre;
    private String sintoma;
    private String codigo;
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setSintoma(String sintoma){
        this.sintoma=sintoma;
    }
    
    public void setCodigo(String codigo){
        this.codigo=codigo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    
    public String getSintoma(){
        return sintoma;
    }
    
    
    public String getCodigo(){
        return codigo;
    }

    
    
    
    
    
    
    
}
