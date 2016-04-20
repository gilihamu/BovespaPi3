package app;

import dao.EmpresaDao;
import entidade.Empresa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

   
        //Inicio da aplicação. Primeira classe a ser executada
        new Principal().setVisible(true);


       
    }

}
