package com.fundamentos.springboot.fundamentos.bean;

import java.util.List;

public class MyBeanYaalanImplement implements MyBeanYaalan{

    @Override
    public void datosYaalan(String nombre, int edad, String correo) {
        System.out.println("nombre: "+nombre+"\n"+"edad: "+edad+"\n"+"correo: "+correo);
    }
}
