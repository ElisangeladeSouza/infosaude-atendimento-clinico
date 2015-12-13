//package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;
//
//import java.io.Serializable;
//import javax.annotation.PostConstruct;
//import javax.enterprise.inject.Model;
//
///**
// * Classe utilitária que provê recursos que podem ser usados por todas as
// * páginas do sistema.
// *
// * @author cassio
// */
//@Model
//public class SystemUtilBean implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    private int numero;
//    
//    int tempo;
//
//    public SystemUtilBean() {
//
//    }
//
//    @PostConstruct
//    public void init() {
//        tempo = 5;
//    }
//
//    /**
//     *
//     */
//    public void contagem() throws InterruptedException {
//        for (int i = tempo; i > 0; i--) {
//            numero = i;
//            Thread.sleep(1000);
//            System.out.println(numero);
//        }
//    }
//
//    public int getNumero() {
//        return numero;
//    }
//
//}
