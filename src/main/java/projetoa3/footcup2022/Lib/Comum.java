/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoa3.footcup2022.Lib;

import java.io.File;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author digog
 */
public final class Comum {

    public static String Hash256(String pTexto) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte hashBytes[] = messageDigest.digest(pTexto.getBytes(StandardCharsets.UTF_8));
            BigInteger noHash = new BigInteger(1, hashBytes);
            return noHash.toString(16);
        } catch (NoSuchAlgorithmException ex) {
            throw ex;
        }
    }

    public static void setTextoCombo(String pTexto, JComboBox pCombo) {

        for (int i = 0; i < pCombo.getItemCount(); i++) {
            if (pCombo.getItemAt(i).toString().contains(pTexto)) {
                pCombo.setSelectedIndex(i);
            }
        }
    }

    public static JRadioButton getSelectedRadio(ButtonGroup pRadioGroup) {

        for (Enumeration<AbstractButton> buttons = pRadioGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton btn = buttons.nextElement();
            if (btn.isSelected()) {
                return (JRadioButton) btn;
            }
        }
        return null;

    }

    public static void setSelectedRadio(String pTexto, ButtonGroup pRadioGroup) {
        for (Enumeration<AbstractButton> buttons = pRadioGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton btn = buttons.nextElement();
            if (btn.getText().contains(pTexto)) {
                btn.setSelected(true);
                break;
            }
        }
    }

    public static void setBandeiraTime(JLabel pLabel, String pBandeira) {
        String imgPath = System.getProperty("user.dir") + "/src/main/java/projetoa3/footcup2022/Imagens/Times/";
        // Instanciamos um objeto do tipo File com o nome 'f'.
        pBandeira = pBandeira.replace(" ", "-");
        if (pBandeira.endsWith("-")) {
            pBandeira = pBandeira.substring(0, pBandeira.length() - 1);
        }
        File f = new File(imgPath + pBandeira.toLowerCase() + ".png");
        // Verificamos se existe um arquivo dentro da pasta imgPath com o nome de jtxtNome.getText().
        if (f.exists()) {
            pLabel.setIcon(new ImageIcon(f.getPath()));
        } else {
            pLabel.setIcon(new ImageIcon(imgPath + "time_default.png"));
        }
    }

    
}
