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
import javax.swing.JFrame;

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
     
     
    //Cria a imagem para uma ação que teve erro
     public static void criarMensagemErro(){
        frmImagemErro form = new frmImagemErro();
        form.setVisible(true);
         form.setLocationRelativeTo(null);
    }
     
     
    //Fechar a aplicaçao totalmente(em caso de erro insesperado)
     public static void fecharPrograma(){
       System.exit(0);
     }
     
     //retorna o nome enviado, mas com o Sr(a) na frente
     public static String incluiSreSra(String nome){
         String res =  "Sr(a) " + nome;
         return res;
     }
     
     //inclui o cifrão recebendo uma string
     public static String incluiCifrão(String valor){
         String res =  "R$ " + valor;
         return res;
     }
    
     //inclui o cifrão recebendo um float
     public static String incluiCifrãoParaFloat(Float valor){
        String res =  "R$ " + valor.toString();
         return res;
     }
     
     public void InserirIcone(JFrame frm){
    
         try {
             frm.setIconImage(Toolkit.getDefaultToolkit().getImage("ImagensIcones.newIcons/logo_icone.png"));
             
         } catch (Exception e) {
             System.out.println(e.toString());
         }
    }
  
}
