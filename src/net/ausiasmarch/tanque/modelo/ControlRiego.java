/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.ausiasmarch.tanque.modelo;

import net.ausiasmarch.common.Convert;

/**
 *
 * @author al038968
 */
public class ControlRiego {
    
    
    /* Creamos los metodos */
    
    String mensaje;
    int sequia;
    int humedad;
    EstadoTanque estado;
 
    
public ControlRiego (EstadoTanque estado){
    
}
public ControlRiego(){
    
}

int premitidoLlenar(){
     
      
   if (sequia >10 || sequia <0){
        mensaje = ("El valor de la sequía no puede ser mayor que 10 o menor que 0 ");
        return 1;
    }
    if (estado == EstadoTanque.LLENO){
        mensaje = ("No se puede llenar el tanque si está lleno ");
        return 2;
    }
   if   (sequia == 10){
       mensaje = ("No se puede llenar si la sequía es 10. ");
       return 3;
   }
   if  (sequia <=7){
       mensaje =("No se puede llenar más de la mitad si la sequía es mayor o igual a 7");
       return 4;
   }
        return 0;
   
    
}
   
int premitidoVaciar(){
     
      
   if (sequia >10 || sequia <0){
        mensaje = ("El valor de la sequía no puede ser mayor que 10 o menor que 0 ");
        return 1;
    }
    if (estado == EstadoTanque.LLENO){
        mensaje = ("No se puede llenar el tanque si está lleno ");
        return 2;
    }
   if   (sequia == 10){
       mensaje = ("No se puede llenar si la sequía es 10. ");
       return 3;
   }
   if  (sequia <=7){
       mensaje =("No se puede llenar más de la mitad si la sequía es mayor o igual a 7");
       return 4;
   }
        return 0;
   
    
}

    
    
}



