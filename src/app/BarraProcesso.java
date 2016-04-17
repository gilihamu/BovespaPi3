/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import javax.swing.JProgressBar;

/**
 *
 * @author Giliard
 */
class BarraProcesso  implements Runnable{
private JProgressBar jProgressBar;
 private int value = 30;//retardo en milisegundos

    BarraProcesso(JProgressBar jProgressBar, int valor) {
        this.jProgressBar = jProgressBar;
        this.value=valor;
    }

    @Override
    public void run() {
        for(int i=1;i<=100;i++){
            jProgressBar.setValue(i);
            jProgressBar.repaint();  
            //retardo en milisegundos
            try{Thread.sleep( (this.value*10) );}            
            catch (InterruptedException e){ System.err.println( e.getMessage() ); }     
        }
    }
    
}