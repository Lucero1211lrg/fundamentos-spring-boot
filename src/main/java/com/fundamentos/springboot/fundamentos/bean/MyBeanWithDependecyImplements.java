package com.fundamentos.springboot.fundamentos.bean;

import com.fundamentos.springboot.fundamentos.FundamentosApplication;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependecyImplements implements MyBeanWithDependency{

    private final Log LOGGER = LogFactory.getLog(MyBeanWithDependecyImplements.class);

    MyOperation myOperation;

    public MyBeanWithDependecyImplements(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {

        LOGGER.info("Entre al metodo printWithDependency ");
        int numero =1;
        LOGGER.debug("El numero enviado como parametro a la dependencia es :" + numero);
        System.out.println(myOperation.suma(numero));
        System.out.println("Hola desde la implementacion de un bean con dependencia");
    }
}
