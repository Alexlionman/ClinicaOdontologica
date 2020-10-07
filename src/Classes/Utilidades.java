/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Formularios.frmImagemErro;
import Formularios.frmImagemSucesso;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author perei
 */
public final class Utilidades {
    
    
    //Cria a imagem para uma ação que foi concluida com sucesso
     public static void criarMensagemSucesso(){
        frmImagemSucesso form = new frmImagemSucesso();
        form.setVisible(true);
         form.setLocationRelativeTo(null);
    }
     
     
    //Cria a imagem para uma ação teve erro
     public static void criarMensagemErro(){
        frmImagemErro form = new frmImagemErro();
        form.setVisible(true);
         form.setLocationRelativeTo(null);
    }
   
}
