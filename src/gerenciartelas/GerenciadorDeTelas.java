package gerenciartelas;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class GerenciadorDeTelas {
    private static JDesktopPane jDesktopPane;

    public GerenciadorDeTelas (JDesktopPane jDesktopPane){
        GerenciadorDeTelas.jDesktopPane = jDesktopPane;
    }

    public void abrirJanelas(JInternalFrame jInternalFrame){
        if (jInternalFrame.isVisible()){
            jInternalFrame.toFront();
            jInternalFrame.requestFocus();
        }else{
            jDesktopPane.add(jInternalFrame);
            jInternalFrame.setVisible(true);
            jInternalFrame.setLocation(
                jInternalFrame.getWidth()/2 - jInternalFrame.getWidth()/2,
                jInternalFrame.getHeight()/2 - jInternalFrame.getHeight()/2
            );

        }
    }
}