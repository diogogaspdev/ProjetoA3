package projetoa3.footcup2022;

import java.sql.Connection;
import java.awt.Component;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import projetoa3.footcup2022.DAO.Grupo;
import projetoa3.footcup2022.DAO.Jogos;
import projetoa3.footcup2022.DAO.Time;
import projetoa3.footcup2022.Lib.Comum;
import projetoa3.footcup2022.Lib.ConexaoBD;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Parra
 */
public class frmVisualizarJogos extends javax.swing.JFrame {

    private HashMap componentMap;

    public frmVisualizarJogos() {
        initComponents();
        createComponentMap();
        String imgPath = System.getProperty("user.dir") + "/src/main/java/projetoa3/footcup2022/Imagens/";
        lblFootCupIcon.setIcon(new ImageIcon(imgPath + "logo.png"));
    }

    private void createComponentMap() {
        componentMap = new HashMap<String, Component>();
        Component[] components = jpnlContainer.getComponents();
        for (int i = 0; i < components.length; i++) {
            componentMap.put(components[i].getName(), components[i]);
        }
    }

    public Component getComponentByName(String name) {
        if (componentMap.containsKey(name)) {
            return (Component) componentMap.get(name);
        } else {
            return null;
        }
    }

    private void preparaGrupos() {
        try {
            var lGrupos = new JPanel[]{jpnlGrpA, jpnlGrpB, jpnlGrpC, jpnlGrpD, jpnlGrpE, jpnlGrpF, jpnlGrpG, jpnlGrpH};

            for (JPanel pnl : lGrupos) {
                String idGrupo = String.valueOf(pnl.getName().charAt(pnl.getName().length() - 1));
                Jogos oResultado = new Jogos();
                oResultado.SimularGrupo(idGrupo);

                var lGrupo = new Grupo().Listar(idGrupo);
                for (var component : pnl.getComponents()) {
                    int time = Character.getNumericValue(component.getName().charAt(component.getName().indexOf('T') + 1)) - 1;
                    if (component.getName().startsWith("lbl")) {
                        ((JLabel) component).setText(lGrupo.get(time).NomeTime);
                    } else if (component.getName().startsWith("icon")) {
                        Comum.setBandeiraTime(((JLabel) component), lGrupo.get(time).NomeTime + "_24");
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void preparaOitavas() {
        int resultadoT1, resultadoT2 = 0;
        Jogos jogo = new Jogos();

        //Oitavas 1
        lblO1T1.setText(lblGAT1.getText());
        resultadoT1 = jogo.getSimulacaoGols();
        Comum.setBandeiraTime(iconO1T1, lblGAT1.getText() + "_24");
        lblO1T2.setText(lblGBT2.getText());
        Comum.setBandeiraTime(iconO1T2, lblGBT2.getText() + "_24");
        resultadoT2 = jogo.getSimulacaoGols();
        
        while (resultadoT1 == resultadoT2) {
            resultadoT1 = jogo.getSimulacaoGols();
            resultadoT2 = jogo.getSimulacaoGols();
        }
        
        placarO1T1.setText(resultadoT1 + "");
        placarO1T2.setText(resultadoT2 + "");

        //Oitavas 2
        lblO2T1.setText(lblGCT1.getText());
        resultadoT1 = jogo.getSimulacaoGols();
        Comum.setBandeiraTime(iconO2T1, lblGCT1.getText() + "_24");
        lblO2T2.setText(lblGDT2.getText());
        Comum.setBandeiraTime(iconO2T2, lblGDT2.getText() + "_24");
        resultadoT2 = jogo.getSimulacaoGols();
        
        while (resultadoT1 == resultadoT2) {
            resultadoT1 = jogo.getSimulacaoGols();
            resultadoT2 = jogo.getSimulacaoGols();
        }        
        
        placarO2T1.setText(resultadoT1 + "");
        placarO2T2.setText(resultadoT2 + "");

        //Oitavas 3
        lblO3T1.setText(lblGET1.getText());
        resultadoT1 = jogo.getSimulacaoGols();
        Comum.setBandeiraTime(iconO3T1, lblGET1.getText() + "_24");
        lblO3T2.setText(lblGFT2.getText());
        Comum.setBandeiraTime(iconO3T2, lblGFT2.getText() + "_24");
        resultadoT2 = jogo.getSimulacaoGols();
        
        while (resultadoT1 == resultadoT2) {
            resultadoT1 = jogo.getSimulacaoGols();
            resultadoT2 = jogo.getSimulacaoGols();
        }
        
        placarO3T1.setText(resultadoT1 + "");
        placarO3T2.setText(resultadoT2 + "");

        //Oitavas 4
        lblO4T1.setText(lblGGT1.getText());
        resultadoT1 = jogo.getSimulacaoGols();
        Comum.setBandeiraTime(iconO4T1, lblGGT1.getText() + "_24");
        lblO4T2.setText(lblGHT2.getText());
        Comum.setBandeiraTime(iconO4T2, lblGHT2.getText() + "_24");
        resultadoT2 = jogo.getSimulacaoGols();
        
        while (resultadoT1 == resultadoT2) {
            resultadoT1 = jogo.getSimulacaoGols();
            resultadoT2 = jogo.getSimulacaoGols();
        }
        
        placarO4T1.setText(resultadoT1 + "");
        placarO4T2.setText(resultadoT2 + "");

        //Oitavas 5
        lblO5T1.setText(lblGBT1.getText());
        resultadoT1 = jogo.getSimulacaoGols();
        Comum.setBandeiraTime(iconO5T1, lblGBT1.getText() + "_24");
        lblO5T2.setText(lblGAT2.getText());
        Comum.setBandeiraTime(iconO5T2, lblGAT2.getText() + "_24");
        resultadoT2 = jogo.getSimulacaoGols();
        
        while (resultadoT1 == resultadoT2) {
            resultadoT1 = jogo.getSimulacaoGols();
            resultadoT2 = jogo.getSimulacaoGols();
        }
        
        placarO5T1.setText(resultadoT1 + "");
        placarO5T2.setText(resultadoT2 + "");

        //Oitavas 6
        lblO6T1.setText(lblGDT1.getText());
        resultadoT1 = jogo.getSimulacaoGols();
        Comum.setBandeiraTime(iconO6T1, lblGDT1.getText() + "_24");
        lblO6T2.setText(lblGCT2.getText());
        Comum.setBandeiraTime(iconO6T2, lblGCT2.getText() + "_24");
        resultadoT2 = jogo.getSimulacaoGols();
        
        while (resultadoT1 == resultadoT2) {
            resultadoT1 = jogo.getSimulacaoGols();
            resultadoT2 = jogo.getSimulacaoGols();
        }
        
        placarO6T1.setText(resultadoT1 + "");
        placarO6T2.setText(resultadoT2 + "");

        //Oitavas 7
        lblO7T1.setText(lblGFT1.getText());
        resultadoT1 = jogo.getSimulacaoGols();
        Comum.setBandeiraTime(iconO7T1, lblGFT1.getText() + "_24");
        lblO7T2.setText(lblGET2.getText());
        Comum.setBandeiraTime(iconO7T2, lblGET2.getText() + "_24");
        resultadoT2 = jogo.getSimulacaoGols();
        
        while (resultadoT1 == resultadoT2) {
            resultadoT1 = jogo.getSimulacaoGols();
            resultadoT2 = jogo.getSimulacaoGols();
        }
        
        placarO7T1.setText(resultadoT1 + "");
        placarO7T2.setText(resultadoT2 + "");

        //Oitavas 8
        lblO8T1.setText(lblGHT1.getText());
        resultadoT1 = jogo.getSimulacaoGols();
        Comum.setBandeiraTime(iconO8T1, lblGHT1.getText() + "_24");
        lblO8T2.setText(lblGGT2.getText());
        Comum.setBandeiraTime(iconO8T2, lblGGT2.getText() + "_24");
        resultadoT2 = jogo.getSimulacaoGols();
        
        while (resultadoT1 == resultadoT2) {
            resultadoT1 = jogo.getSimulacaoGols();
            resultadoT2 = jogo.getSimulacaoGols();
        }
        
        placarO8T1.setText(resultadoT1 + "");
        placarO8T2.setText(resultadoT2 + "");

    }

    private void setSimulacaoGols(JLabel time1, JLabel time2) {
        Jogos jogo = new Jogos();
        int resultado1 = 0;
        int resultado2 = 0;
        while (resultado1 == resultado2) {
            resultado1 = jogo.getSimulacaoGols();
            resultado2 = jogo.getSimulacaoGols();
        }
        time1.setText(resultado1 + "");
        time2.setText(resultado2 + "");
    }

    private void preparaQuartas() {
        int resultadoT1, resultadoT2, resultadoxT1, resultadoxT2 = 0;
        Jogos jogo = new Jogos();
        JLabel time = null;

        // ------------- Quartas 1 - Time 1
        resultadoT1 = Integer.parseInt(placarO1T1.getText());
        resultadoT2 = Integer.parseInt(placarO1T2.getText());
        time = (resultadoT1 > resultadoT2) ? lblO1T1 : lblO1T2;
        lblQ1T1.setText(time.getText());
        Comum.setBandeiraTime(iconQ1T1, time.getText() + "_24");
        
        // ------------- Quartas 1 - Time 2
        resultadoT1 = Integer.parseInt(placarO2T1.getText());
        resultadoT2 = Integer.parseInt(placarO2T2.getText());
        time = (resultadoT1 > resultadoT2) ? lblO2T1 : lblO2T2;
        lblQ1T2.setText(time.getText());
        Comum.setBandeiraTime(iconQ1T2, time.getText() + "_24");

        resultadoxT1 = jogo.getSimulacaoGols();
        resultadoxT2 = jogo.getSimulacaoGols();
        
        while (resultadoxT1 == resultadoxT2) {
            resultadoxT1 = jogo.getSimulacaoGols();
            resultadoxT2 = jogo.getSimulacaoGols();
        }
        
        placarQ1T1.setText(resultadoxT1 + "");
        placarQ1T2.setText(resultadoxT2 + "");
        
        // ------------- Quartas 2 - Time 1
        resultadoT1 = Integer.parseInt(placarO3T1.getText());
        resultadoT2 = Integer.parseInt(placarO3T2.getText());
        time = (resultadoT1 > resultadoT2) ? lblO3T1 : lblO3T2;
        lblQ2T1.setText(time.getText());
        Comum.setBandeiraTime(iconQ2T1, time.getText() + "_24");
        
        // ------------- Quartas 2 - Time 2
        resultadoT1 = Integer.parseInt(placarO4T1.getText());
        resultadoT2 = Integer.parseInt(placarO4T2.getText());
        time = (resultadoT1 > resultadoT2) ? lblO4T1 : lblO4T2;
        lblQ2T2.setText(time.getText());
        Comum.setBandeiraTime(iconQ2T2, time.getText() + "_24");

        resultadoxT1 = jogo.getSimulacaoGols();
        resultadoxT2 = jogo.getSimulacaoGols();
        
        while (resultadoxT1 == resultadoxT2) {
            resultadoxT1 = jogo.getSimulacaoGols();
            resultadoxT2 = jogo.getSimulacaoGols();
        }
        
        placarQ2T1.setText(resultadoxT1 + "");
        placarQ2T2.setText(resultadoxT2 + "");

        // ------------- Quartas 3 - Time 1
        resultadoT1 = Integer.parseInt(placarO5T1.getText());
        resultadoT2 = Integer.parseInt(placarO5T2.getText());
        time = (resultadoT1 > resultadoT2) ? lblO5T1 : lblO5T2;
        lblQ3T1.setText(time.getText());
        Comum.setBandeiraTime(iconQ3T1, time.getText() + "_24");
        
        // ------------- Quartas 3 - Time 2
        resultadoT1 = Integer.parseInt(placarO6T1.getText());
        resultadoT2 = Integer.parseInt(placarO6T2.getText());
        time = (resultadoT1 > resultadoT2) ? lblO6T1 : lblO6T2;
        lblQ3T2.setText(time.getText());
        Comum.setBandeiraTime(iconQ3T2, time.getText() + "_24");

        resultadoxT1 = jogo.getSimulacaoGols();
        resultadoxT2 = jogo.getSimulacaoGols();
        
        while (resultadoxT1 == resultadoxT2) {
            resultadoxT1 = jogo.getSimulacaoGols();
            resultadoxT2 = jogo.getSimulacaoGols();
        }
        
        placarQ3T1.setText(resultadoxT1 + "");
        placarQ3T2.setText(resultadoxT2 + "");

        // ------------- Quartas 4 - Time 1
        resultadoT1 = Integer.parseInt(placarO7T1.getText());
        resultadoT2 = Integer.parseInt(placarO7T2.getText());
        time = (resultadoT1 > resultadoT2) ? lblO7T1 : lblO7T2;
        lblQ4T1.setText(time.getText());
        Comum.setBandeiraTime(iconQ4T1, time.getText() + "_24");
        
        // ------------- Quartas 4 - Time 2
        resultadoT1 = Integer.parseInt(placarO8T1.getText());
        resultadoT2 = Integer.parseInt(placarO8T2.getText());
        time = (resultadoT1 > resultadoT2) ? lblO8T1 : lblO8T2;
        lblQ4T2.setText(time.getText());
        Comum.setBandeiraTime(iconQ4T2, time.getText() + "_24");

        resultadoxT1 = jogo.getSimulacaoGols();
        resultadoxT2 = jogo.getSimulacaoGols();
        
        while (resultadoxT1 == resultadoxT2) {
            resultadoxT1 = jogo.getSimulacaoGols();
            resultadoxT2 = jogo.getSimulacaoGols();
        }
        
        placarQ4T1.setText(resultadoxT1 + "");
        placarQ4T2.setText(resultadoxT2 + "");

    }

    private void preparaSemis() {
        int resultadoT1, resultadoT2, resultadoxT1, resultadoxT2 = 0;
        Jogos jogo = new Jogos();
        JLabel time = null;

        // ------------- SEMIS 1 - Time 1
        resultadoT1 = Integer.parseInt(placarQ1T1.getText());
        resultadoT2 = Integer.parseInt(placarQ1T2.getText());
        time = (resultadoT1 > resultadoT2) ? lblQ1T1 : lblQ1T2;
        lblS1T1.setText(time.getText());
        Comum.setBandeiraTime(iconS1T1, time.getText() + "_24");
        // ------------- SEMIS 1 - Time 2
        resultadoT1 = Integer.parseInt(placarQ2T1.getText());
        resultadoT2 = Integer.parseInt(placarQ2T2.getText());
        time = (resultadoT1 > resultadoT2) ? lblQ2T1 : lblQ2T2;
        lblS1T2.setText(time.getText());
        Comum.setBandeiraTime(iconS1T2, time.getText() + "_24");

        resultadoxT1 = jogo.getSimulacaoGols();
        resultadoxT2 = jogo.getSimulacaoGols();
        
        while (resultadoxT1 == resultadoxT2) {
            resultadoxT1 = jogo.getSimulacaoGols();
            resultadoxT2 = jogo.getSimulacaoGols();
        }
        
        placarS1T1.setText(resultadoxT1 + "");
        placarS1T2.setText(resultadoxT2 + "");

        // ------------- SEMIS 2 - Time 1
        resultadoT1 = Integer.parseInt(placarQ3T1.getText());
        resultadoT2 = Integer.parseInt(placarQ3T2.getText());
        time = (resultadoT1 > resultadoT2) ? lblQ3T1 : lblQ3T2;
        lblS2T1.setText(time.getText());
        Comum.setBandeiraTime(iconS2T1, time.getText() + "_24");
        // ------------- SEMIS 2 - Time 2
        resultadoT1 = Integer.parseInt(placarQ4T1.getText());
        resultadoT2 = Integer.parseInt(placarQ4T2.getText());
        time = (resultadoT1 > resultadoT2) ? lblQ4T1 : lblQ4T2;
        lblS2T2.setText(time.getText());
        Comum.setBandeiraTime(iconS2T2, time.getText() + "_24");

        resultadoxT1 = jogo.getSimulacaoGols();
        resultadoxT2 = jogo.getSimulacaoGols();
        
        while (resultadoxT1 == resultadoxT2) {
            resultadoxT1 = jogo.getSimulacaoGols();
            resultadoxT2 = jogo.getSimulacaoGols();
        }
        
        placarS2T1.setText(resultadoxT1 + "");
        placarS2T2.setText(resultadoxT2 + "");
    }

    private void preparaFinal() {
        int resultadoT1, resultadoT2, resultadoxT1, resultadoxT2 = 0;
        Jogos jogo = new Jogos();
        JLabel time = null;

        // ------------- Final 1 - Time 1
        resultadoT1 = Integer.parseInt(placarS1T1.getText());
        resultadoT2 = Integer.parseInt(placarS1T2.getText());
        time = (resultadoT1 > resultadoT2) ? lblS1T1 : lblS1T2;
        lblF1T1.setText(time.getText());
        placarF1T1.setText(jogo.getSimulacaoGols() + "");
        Comum.setBandeiraTime(iconF1T1, time.getText() + "_24");
        // ------------- Final 1 - Time 2
        resultadoT1 = Integer.parseInt(placarS2T1.getText());
        resultadoT2 = Integer.parseInt(placarS2T2.getText());
        time = (resultadoT1 > resultadoT2) ? lblS2T1 : lblS2T2;
        lblF1T2.setText(time.getText());
        placarF1T2.setText(jogo.getSimulacaoGols() + "");
        Comum.setBandeiraTime(iconF1T2, time.getText() + "_24");

        resultadoxT1 = jogo.getSimulacaoGols();
        resultadoxT2 = jogo.getSimulacaoGols();
        
        while (resultadoxT1 == resultadoxT2) {
            resultadoxT1 = jogo.getSimulacaoGols();
            resultadoxT2 = jogo.getSimulacaoGols();
        }
        
        placarF1T1.setText(resultadoxT1 + "");
        placarF1T2.setText(resultadoxT2 + "");

        resultadoT1 = Integer.parseInt(placarF1T1.getText());
        resultadoT2 = Integer.parseInt(placarF1T2.getText());
        time = (resultadoT1 > resultadoT2) ? lblF1T1 : lblF1T2;
        Comum.setBandeiraTime(jlblBandeira, time.getText() + "_24");
        jlblBandeira.setText(time.getText() + " ?? o novo campe??o mundial!");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jbtnVoltar = new javax.swing.JButton();
        jbtnSimular = new javax.swing.JButton();
        jpnlContainer = new javax.swing.JPanel();
        lblOitavas1 = new javax.swing.JLabel();
        lblOitavas2 = new javax.swing.JLabel();
        lblQuartas1 = new javax.swing.JLabel();
        lblQuartas2 = new javax.swing.JLabel();
        lblSemis1 = new javax.swing.JLabel();
        lblFootCupIcon = new javax.swing.JLabel();
        jpnlGrpA = new javax.swing.JPanel();
        lblGAT1 = new javax.swing.JLabel();
        lblGAT2 = new javax.swing.JLabel();
        lblGAT3 = new javax.swing.JLabel();
        lblGAT4 = new javax.swing.JLabel();
        iconGAT1 = new javax.swing.JLabel();
        iconGAT2 = new javax.swing.JLabel();
        iconGAT73 = new javax.swing.JLabel();
        iconGAT4 = new javax.swing.JLabel();
        jpnlGrpB = new javax.swing.JPanel();
        lblGBT1 = new javax.swing.JLabel();
        lblGBT2 = new javax.swing.JLabel();
        lblGBT3 = new javax.swing.JLabel();
        lblGBT4 = new javax.swing.JLabel();
        iconGBT1 = new javax.swing.JLabel();
        iconGBT2 = new javax.swing.JLabel();
        iconGBT3 = new javax.swing.JLabel();
        iconGBT4 = new javax.swing.JLabel();
        jpnlGrpC = new javax.swing.JPanel();
        lblGCT1 = new javax.swing.JLabel();
        lblGCT2 = new javax.swing.JLabel();
        lblGCT3 = new javax.swing.JLabel();
        lblGCT4 = new javax.swing.JLabel();
        iconGCT1 = new javax.swing.JLabel();
        iconGCT2 = new javax.swing.JLabel();
        iconGCT3 = new javax.swing.JLabel();
        iconGCT4 = new javax.swing.JLabel();
        jpnlGrpD = new javax.swing.JPanel();
        lblGDT1 = new javax.swing.JLabel();
        lblGDT2 = new javax.swing.JLabel();
        lblGDT3 = new javax.swing.JLabel();
        lblGDT4 = new javax.swing.JLabel();
        iconGDT1 = new javax.swing.JLabel();
        iconGDT2 = new javax.swing.JLabel();
        iconGDT3 = new javax.swing.JLabel();
        iconGDT4 = new javax.swing.JLabel();
        jpnlGrpE = new javax.swing.JPanel();
        lblGET1 = new javax.swing.JLabel();
        lblGET2 = new javax.swing.JLabel();
        lblGET3 = new javax.swing.JLabel();
        lblGET4 = new javax.swing.JLabel();
        iconGET1 = new javax.swing.JLabel();
        iconGET2 = new javax.swing.JLabel();
        iconGET3 = new javax.swing.JLabel();
        iconGET4 = new javax.swing.JLabel();
        jpnlGrpF = new javax.swing.JPanel();
        lblGFT1 = new javax.swing.JLabel();
        lblGFT2 = new javax.swing.JLabel();
        lblGFT3 = new javax.swing.JLabel();
        lblGFT4 = new javax.swing.JLabel();
        iconGFT1 = new javax.swing.JLabel();
        iconGFT2 = new javax.swing.JLabel();
        iconGFT3 = new javax.swing.JLabel();
        iconGFT4 = new javax.swing.JLabel();
        jpnlGrpG = new javax.swing.JPanel();
        lblGGT1 = new javax.swing.JLabel();
        lblGGT2 = new javax.swing.JLabel();
        lblGGT3 = new javax.swing.JLabel();
        lblGGT4 = new javax.swing.JLabel();
        iconGGT1 = new javax.swing.JLabel();
        iconGGT2 = new javax.swing.JLabel();
        iconGGT3 = new javax.swing.JLabel();
        iconGGT4 = new javax.swing.JLabel();
        jpnlGrpH = new javax.swing.JPanel();
        lblGHT1 = new javax.swing.JLabel();
        lblGHT2 = new javax.swing.JLabel();
        lblGHT3 = new javax.swing.JLabel();
        lblGHT4 = new javax.swing.JLabel();
        iconGHT1 = new javax.swing.JLabel();
        iconGHT2 = new javax.swing.JLabel();
        iconGHT3 = new javax.swing.JLabel();
        iconGHT4 = new javax.swing.JLabel();
        jpnlOitavas1 = new javax.swing.JPanel();
        lblO1T1 = new javax.swing.JLabel();
        lblO1T2 = new javax.swing.JLabel();
        iconO1T1 = new javax.swing.JLabel();
        iconO1T2 = new javax.swing.JLabel();
        placarO1T1 = new javax.swing.JLabel();
        placarO1T2 = new javax.swing.JLabel();
        jpnlOitavas2 = new javax.swing.JPanel();
        lblO2T1 = new javax.swing.JLabel();
        iconO2T1 = new javax.swing.JLabel();
        lblO2T2 = new javax.swing.JLabel();
        iconO2T2 = new javax.swing.JLabel();
        placarO2T1 = new javax.swing.JLabel();
        placarO2T2 = new javax.swing.JLabel();
        jpnlOitavas3 = new javax.swing.JPanel();
        lblO3T1 = new javax.swing.JLabel();
        iconO3T1 = new javax.swing.JLabel();
        lblO3T2 = new javax.swing.JLabel();
        iconO3T2 = new javax.swing.JLabel();
        placarO3T1 = new javax.swing.JLabel();
        placarO3T2 = new javax.swing.JLabel();
        jpnlOitavas4 = new javax.swing.JPanel();
        placarO4T2 = new javax.swing.JLabel();
        placarO4T1 = new javax.swing.JLabel();
        lblO4T1 = new javax.swing.JLabel();
        iconO4T1 = new javax.swing.JLabel();
        iconO4T2 = new javax.swing.JLabel();
        lblO4T2 = new javax.swing.JLabel();
        jpnlOitavas5 = new javax.swing.JPanel();
        lblO5T1 = new javax.swing.JLabel();
        iconO5T1 = new javax.swing.JLabel();
        lblO5T2 = new javax.swing.JLabel();
        iconO5T2 = new javax.swing.JLabel();
        placarO5T1 = new javax.swing.JLabel();
        placarO5T2 = new javax.swing.JLabel();
        jpnlOitavas6 = new javax.swing.JPanel();
        lblO6T1 = new javax.swing.JLabel();
        iconO6T1 = new javax.swing.JLabel();
        lblO6T2 = new javax.swing.JLabel();
        iconO6T2 = new javax.swing.JLabel();
        placarO6T1 = new javax.swing.JLabel();
        placarO6T2 = new javax.swing.JLabel();
        jpnlOitavas7 = new javax.swing.JPanel();
        lblO7T1 = new javax.swing.JLabel();
        iconO7T1 = new javax.swing.JLabel();
        lblO7T2 = new javax.swing.JLabel();
        iconO7T2 = new javax.swing.JLabel();
        placarO7T1 = new javax.swing.JLabel();
        placarO7T2 = new javax.swing.JLabel();
        jpnlOitavas8 = new javax.swing.JPanel();
        lblO8T1 = new javax.swing.JLabel();
        iconO8T1 = new javax.swing.JLabel();
        lblO8T2 = new javax.swing.JLabel();
        iconO8T2 = new javax.swing.JLabel();
        placarO8T1 = new javax.swing.JLabel();
        placarO8T2 = new javax.swing.JLabel();
        jpnlQuartas1 = new javax.swing.JPanel();
        lblQ1T1 = new javax.swing.JLabel();
        iconQ1T1 = new javax.swing.JLabel();
        lblQ1T2 = new javax.swing.JLabel();
        iconQ1T2 = new javax.swing.JLabel();
        placarQ1T1 = new javax.swing.JLabel();
        placarQ1T2 = new javax.swing.JLabel();
        jpnlQuartas2 = new javax.swing.JPanel();
        lblQ2T1 = new javax.swing.JLabel();
        iconQ2T1 = new javax.swing.JLabel();
        lblQ2T2 = new javax.swing.JLabel();
        iconQ2T2 = new javax.swing.JLabel();
        placarQ2T1 = new javax.swing.JLabel();
        placarQ2T2 = new javax.swing.JLabel();
        jpnlQuartas3 = new javax.swing.JPanel();
        lblQ3T1 = new javax.swing.JLabel();
        iconQ3T1 = new javax.swing.JLabel();
        lblQ3T2 = new javax.swing.JLabel();
        iconQ3T2 = new javax.swing.JLabel();
        placarQ3T1 = new javax.swing.JLabel();
        placarQ3T2 = new javax.swing.JLabel();
        jpnlQuartas4 = new javax.swing.JPanel();
        lblQ4T1 = new javax.swing.JLabel();
        iconQ4T1 = new javax.swing.JLabel();
        lblQ4T2 = new javax.swing.JLabel();
        iconQ4T2 = new javax.swing.JLabel();
        placarQ4T1 = new javax.swing.JLabel();
        placarQ4T2 = new javax.swing.JLabel();
        jpnlSemi1 = new javax.swing.JPanel();
        lblS1T1 = new javax.swing.JLabel();
        iconS1T1 = new javax.swing.JLabel();
        lblS1T2 = new javax.swing.JLabel();
        iconS1T2 = new javax.swing.JLabel();
        placarS1T1 = new javax.swing.JLabel();
        placarS1T2 = new javax.swing.JLabel();
        jpnlSemi2 = new javax.swing.JPanel();
        lblS2T1 = new javax.swing.JLabel();
        iconS2T1 = new javax.swing.JLabel();
        lblS2T2 = new javax.swing.JLabel();
        iconS2T2 = new javax.swing.JLabel();
        placarS2T1 = new javax.swing.JLabel();
        placarS2T2 = new javax.swing.JLabel();
        jpnlFinal = new javax.swing.JPanel();
        lblF1T1 = new javax.swing.JLabel();
        iconF1T1 = new javax.swing.JLabel();
        lblF1T2 = new javax.swing.JLabel();
        iconF1T2 = new javax.swing.JLabel();
        placarF1T1 = new javax.swing.JLabel();
        placarF1T2 = new javax.swing.JLabel();
        lblFinal = new javax.swing.JLabel();
        jlblBandeira = new javax.swing.JLabel();
        lblTaca1 = new javax.swing.JLabel();
        lblTaca2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel8.setBackground(new java.awt.Color(42, 170, 56));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtnVoltar.setText("Voltar");
        jbtnVoltar.setToolTipText("Voltar Para Home");
        jbtnVoltar.setHideActionText(true);
        jbtnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVoltarActionPerformed(evt);
            }
        });
        jPanel8.add(jbtnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 30));

        jbtnSimular.setText("Simular");
        jbtnSimular.setToolTipText("Simular Resultados");
        jbtnSimular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSimularActionPerformed(evt);
            }
        });
        jPanel8.add(jbtnSimular, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, 30));

        jpnlContainer.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jpnlContainer.setName("jpnlContainer"); // NOI18N

        lblOitavas1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblOitavas1.setText("Oitavas");

        lblOitavas2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblOitavas2.setText("Oitavas");

        lblQuartas1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblQuartas1.setText("Quartas");

        lblQuartas2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblQuartas2.setText("Quartas");

        lblSemis1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSemis1.setText("Semi Final");

        lblFootCupIcon.setText(" ");

        jpnlGrpA.setBorder(javax.swing.BorderFactory.createTitledBorder("Grupo A"));
        jpnlGrpA.setName("jpnlGrpA"); // NOI18N
        jpnlGrpA.setOpaque(false);

        lblGAT1.setText("            ");
        lblGAT1.setName("lblGAT1"); // NOI18N

        lblGAT2.setText("          ");
        lblGAT2.setName("lblGAT2"); // NOI18N

        lblGAT3.setText("          ");
        lblGAT3.setName("lblGAT3"); // NOI18N

        lblGAT4.setText("          ");
        lblGAT4.setName("lblGAT4"); // NOI18N

        iconGAT1.setText("          ");
        iconGAT1.setName("iconGAT1"); // NOI18N

        iconGAT2.setText("          ");
        iconGAT2.setName("iconGAT2"); // NOI18N

        iconGAT73.setText("          ");
        iconGAT73.setName("iconGAT3"); // NOI18N

        iconGAT4.setText("          ");
        iconGAT4.setName("iconGAT4"); // NOI18N

        javax.swing.GroupLayout jpnlGrpALayout = new javax.swing.GroupLayout(jpnlGrpA);
        jpnlGrpA.setLayout(jpnlGrpALayout);
        jpnlGrpALayout.setHorizontalGroup(
            jpnlGrpALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlGrpALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlGrpALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlGrpALayout.createSequentialGroup()
                        .addComponent(lblGAT4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGAT4))
                    .addGroup(jpnlGrpALayout.createSequentialGroup()
                        .addComponent(lblGAT2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGAT2))
                    .addGroup(jpnlGrpALayout.createSequentialGroup()
                        .addComponent(lblGAT3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGAT73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlGrpALayout.createSequentialGroup()
                        .addComponent(lblGAT1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 44, Short.MAX_VALUE)
                        .addComponent(iconGAT1)))
                .addContainerGap())
        );
        jpnlGrpALayout.setVerticalGroup(
            jpnlGrpALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlGrpALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlGrpALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iconGAT1)
                    .addComponent(lblGAT1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlGrpALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGAT2)
                    .addComponent(iconGAT2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlGrpALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGAT3)
                    .addComponent(iconGAT73))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlGrpALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGAT4)
                    .addComponent(iconGAT4))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jpnlGrpB.setBorder(javax.swing.BorderFactory.createTitledBorder("Grupo B"));
        jpnlGrpB.setName("jnplGrpB"); // NOI18N

        lblGBT1.setText("          ");
        lblGBT1.setName("lblGBT1"); // NOI18N

        lblGBT2.setText("          ");
        lblGBT2.setName("lblGBT2"); // NOI18N

        lblGBT3.setText("          ");
        lblGBT3.setName("lblGBT3"); // NOI18N

        lblGBT4.setText("          ");
        lblGBT4.setName("lblGBT4"); // NOI18N

        iconGBT1.setText("          ");
        iconGBT1.setName("iconGBT1"); // NOI18N

        iconGBT2.setText("          ");
        iconGBT2.setName("iconGBT2"); // NOI18N

        iconGBT3.setText("          ");
        iconGBT3.setName("iconGBT3"); // NOI18N

        iconGBT4.setText("          ");
        iconGBT4.setName("iconGBT4"); // NOI18N

        javax.swing.GroupLayout jpnlGrpBLayout = new javax.swing.GroupLayout(jpnlGrpB);
        jpnlGrpB.setLayout(jpnlGrpBLayout);
        jpnlGrpBLayout.setHorizontalGroup(
            jpnlGrpBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlGrpBLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlGrpBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlGrpBLayout.createSequentialGroup()
                        .addComponent(lblGBT1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGBT1))
                    .addGroup(jpnlGrpBLayout.createSequentialGroup()
                        .addComponent(lblGBT4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGBT4))
                    .addGroup(jpnlGrpBLayout.createSequentialGroup()
                        .addComponent(lblGBT2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGBT2))
                    .addGroup(jpnlGrpBLayout.createSequentialGroup()
                        .addComponent(lblGBT3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGBT3)))
                .addContainerGap())
        );
        jpnlGrpBLayout.setVerticalGroup(
            jpnlGrpBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlGrpBLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlGrpBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iconGBT1)
                    .addComponent(lblGBT1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlGrpBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGBT2)
                    .addComponent(iconGBT2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlGrpBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGBT3)
                    .addComponent(iconGBT3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlGrpBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGBT4)
                    .addComponent(iconGBT4))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jpnlGrpC.setBorder(javax.swing.BorderFactory.createTitledBorder("Grupo C"));
        jpnlGrpC.setName("jpnlGrpC"); // NOI18N

        lblGCT1.setText("          ");
        lblGCT1.setName("lblGCT1"); // NOI18N

        lblGCT2.setText("          ");
        lblGCT2.setName("lblGCT2"); // NOI18N

        lblGCT3.setText("          ");
        lblGCT3.setName("lblGCT3"); // NOI18N

        lblGCT4.setText("          ");
        lblGCT4.setName("lblGCT4"); // NOI18N

        iconGCT1.setText("          ");
        iconGCT1.setName("iconGCT1"); // NOI18N

        iconGCT2.setText("          ");
        iconGCT2.setName("iconGCT2"); // NOI18N

        iconGCT3.setText("          ");
        iconGCT3.setName("iconGCT3"); // NOI18N

        iconGCT4.setText("          ");
        iconGCT4.setName("iconGCT4"); // NOI18N

        javax.swing.GroupLayout jpnlGrpCLayout = new javax.swing.GroupLayout(jpnlGrpC);
        jpnlGrpC.setLayout(jpnlGrpCLayout);
        jpnlGrpCLayout.setHorizontalGroup(
            jpnlGrpCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlGrpCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlGrpCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlGrpCLayout.createSequentialGroup()
                        .addComponent(lblGCT1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGCT1))
                    .addGroup(jpnlGrpCLayout.createSequentialGroup()
                        .addComponent(lblGCT4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGCT4))
                    .addGroup(jpnlGrpCLayout.createSequentialGroup()
                        .addComponent(lblGCT2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGCT2))
                    .addGroup(jpnlGrpCLayout.createSequentialGroup()
                        .addComponent(lblGCT3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGCT3)))
                .addContainerGap())
        );
        jpnlGrpCLayout.setVerticalGroup(
            jpnlGrpCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlGrpCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlGrpCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iconGCT1)
                    .addComponent(lblGCT1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlGrpCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGCT2)
                    .addComponent(iconGCT2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlGrpCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGCT3)
                    .addComponent(iconGCT3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlGrpCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGCT4)
                    .addComponent(iconGCT4))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jpnlGrpD.setBorder(javax.swing.BorderFactory.createTitledBorder("Grupo D"));
        jpnlGrpD.setName("jpnlGrpD"); // NOI18N

        lblGDT1.setText("          ");
        lblGDT1.setName("lblGDT1"); // NOI18N

        lblGDT2.setText("          ");
        lblGDT2.setName("lblGDT2"); // NOI18N

        lblGDT3.setText("          ");
        lblGDT3.setName("lblGDT3"); // NOI18N

        lblGDT4.setText("          ");
        lblGDT4.setName("lblGDT4"); // NOI18N

        iconGDT1.setText("          ");
        iconGDT1.setName("iconGDT1"); // NOI18N

        iconGDT2.setText("          ");
        iconGDT2.setName("iconGDT2"); // NOI18N

        iconGDT3.setText("          ");
        iconGDT3.setName("iconGDT3"); // NOI18N

        iconGDT4.setText("          ");
        iconGDT4.setName("iconGDT4"); // NOI18N

        javax.swing.GroupLayout jpnlGrpDLayout = new javax.swing.GroupLayout(jpnlGrpD);
        jpnlGrpD.setLayout(jpnlGrpDLayout);
        jpnlGrpDLayout.setHorizontalGroup(
            jpnlGrpDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlGrpDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlGrpDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlGrpDLayout.createSequentialGroup()
                        .addComponent(lblGDT1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGDT1))
                    .addGroup(jpnlGrpDLayout.createSequentialGroup()
                        .addComponent(lblGDT4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGDT4))
                    .addGroup(jpnlGrpDLayout.createSequentialGroup()
                        .addComponent(lblGDT2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGDT2))
                    .addGroup(jpnlGrpDLayout.createSequentialGroup()
                        .addComponent(lblGDT3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGDT3)))
                .addContainerGap())
        );
        jpnlGrpDLayout.setVerticalGroup(
            jpnlGrpDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlGrpDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlGrpDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iconGDT1)
                    .addComponent(lblGDT1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlGrpDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGDT2)
                    .addComponent(iconGDT2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlGrpDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGDT3)
                    .addComponent(iconGDT3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlGrpDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGDT4)
                    .addComponent(iconGDT4))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jpnlGrpE.setBorder(javax.swing.BorderFactory.createTitledBorder("Grupo E"));
        jpnlGrpE.setName("jpnlGrpE"); // NOI18N

        lblGET1.setText("          ");
        lblGET1.setName("lblGET1"); // NOI18N

        lblGET2.setText("          ");
        lblGET2.setName("lblGET2"); // NOI18N

        lblGET3.setText("          ");
        lblGET3.setName("lblGET3"); // NOI18N

        lblGET4.setText("          ");
        lblGET4.setName("lblGET4"); // NOI18N

        iconGET1.setText("          ");
        iconGET1.setName("iconGET1"); // NOI18N

        iconGET2.setText("          ");
        iconGET2.setName("iconGET2"); // NOI18N

        iconGET3.setText("          ");
        iconGET3.setName("iconGET3"); // NOI18N

        iconGET4.setText("          ");
        iconGET4.setName("iconGET4"); // NOI18N

        javax.swing.GroupLayout jpnlGrpELayout = new javax.swing.GroupLayout(jpnlGrpE);
        jpnlGrpE.setLayout(jpnlGrpELayout);
        jpnlGrpELayout.setHorizontalGroup(
            jpnlGrpELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlGrpELayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlGrpELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlGrpELayout.createSequentialGroup()
                        .addComponent(lblGET1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGET1))
                    .addGroup(jpnlGrpELayout.createSequentialGroup()
                        .addComponent(lblGET4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGET4))
                    .addGroup(jpnlGrpELayout.createSequentialGroup()
                        .addComponent(lblGET2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGET2))
                    .addGroup(jpnlGrpELayout.createSequentialGroup()
                        .addComponent(lblGET3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGET3)))
                .addContainerGap())
        );
        jpnlGrpELayout.setVerticalGroup(
            jpnlGrpELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlGrpELayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlGrpELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iconGET1)
                    .addComponent(lblGET1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlGrpELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGET2)
                    .addComponent(iconGET2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlGrpELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGET3)
                    .addComponent(iconGET3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlGrpELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGET4)
                    .addComponent(iconGET4))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jpnlGrpF.setBorder(javax.swing.BorderFactory.createTitledBorder("Grupo F"));
        jpnlGrpF.setName("jpnlGrpF"); // NOI18N

        lblGFT1.setText("          ");
        lblGFT1.setName("lblGFT1"); // NOI18N

        lblGFT2.setText("          ");
        lblGFT2.setName("lblGFT2"); // NOI18N

        lblGFT3.setText("          ");
        lblGFT3.setName("lblGFT3"); // NOI18N

        lblGFT4.setText("          ");
        lblGFT4.setName("lblGFT4"); // NOI18N

        iconGFT1.setText("          ");
        iconGFT1.setName("iconGFT1"); // NOI18N

        iconGFT2.setText("          ");
        iconGFT2.setName("iconGFT2"); // NOI18N

        iconGFT3.setText("          ");
        iconGFT3.setName("iconGFT3"); // NOI18N

        iconGFT4.setText("          ");
        iconGFT4.setName("iconGFT4"); // NOI18N

        javax.swing.GroupLayout jpnlGrpFLayout = new javax.swing.GroupLayout(jpnlGrpF);
        jpnlGrpF.setLayout(jpnlGrpFLayout);
        jpnlGrpFLayout.setHorizontalGroup(
            jpnlGrpFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlGrpFLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlGrpFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlGrpFLayout.createSequentialGroup()
                        .addComponent(lblGFT1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGFT1))
                    .addGroup(jpnlGrpFLayout.createSequentialGroup()
                        .addComponent(lblGFT4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGFT4))
                    .addGroup(jpnlGrpFLayout.createSequentialGroup()
                        .addComponent(lblGFT2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGFT2))
                    .addGroup(jpnlGrpFLayout.createSequentialGroup()
                        .addComponent(lblGFT3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGFT3)))
                .addContainerGap())
        );
        jpnlGrpFLayout.setVerticalGroup(
            jpnlGrpFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlGrpFLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlGrpFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iconGFT1)
                    .addComponent(lblGFT1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlGrpFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGFT2)
                    .addComponent(iconGFT2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlGrpFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGFT3)
                    .addComponent(iconGFT3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlGrpFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGFT4)
                    .addComponent(iconGFT4))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jpnlGrpG.setBorder(javax.swing.BorderFactory.createTitledBorder("Grupo G"));
        jpnlGrpG.setName("jpnlGrpG"); // NOI18N

        lblGGT1.setText("          ");
        lblGGT1.setName("lblGGT1"); // NOI18N

        lblGGT2.setText("          ");
        lblGGT2.setName("lblGGT2"); // NOI18N

        lblGGT3.setText("          ");
        lblGGT3.setName("lblGGT3"); // NOI18N

        lblGGT4.setText("          ");
        lblGGT4.setName("lblGGT4"); // NOI18N

        iconGGT1.setText("          ");
        iconGGT1.setName("iconGGT1"); // NOI18N

        iconGGT2.setText("          ");
        iconGGT2.setName("iconGGT2"); // NOI18N

        iconGGT3.setText("          ");
        iconGGT3.setName("iconGGT3"); // NOI18N

        iconGGT4.setText("          ");
        iconGGT4.setName("iconGGT4"); // NOI18N

        javax.swing.GroupLayout jpnlGrpGLayout = new javax.swing.GroupLayout(jpnlGrpG);
        jpnlGrpG.setLayout(jpnlGrpGLayout);
        jpnlGrpGLayout.setHorizontalGroup(
            jpnlGrpGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlGrpGLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlGrpGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlGrpGLayout.createSequentialGroup()
                        .addComponent(lblGGT1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addComponent(iconGGT1))
                    .addGroup(jpnlGrpGLayout.createSequentialGroup()
                        .addComponent(lblGGT4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGGT4))
                    .addGroup(jpnlGrpGLayout.createSequentialGroup()
                        .addComponent(lblGGT2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGGT2))
                    .addGroup(jpnlGrpGLayout.createSequentialGroup()
                        .addComponent(lblGGT3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGGT3)))
                .addContainerGap())
        );
        jpnlGrpGLayout.setVerticalGroup(
            jpnlGrpGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlGrpGLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlGrpGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iconGGT1)
                    .addComponent(lblGGT1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlGrpGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGGT2)
                    .addComponent(iconGGT2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlGrpGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGGT3)
                    .addComponent(iconGGT3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlGrpGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGGT4)
                    .addComponent(iconGGT4))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jpnlGrpH.setBorder(javax.swing.BorderFactory.createTitledBorder("Grupo H"));
        jpnlGrpH.setName("jpnlGrpH"); // NOI18N

        lblGHT1.setText("          ");
        lblGHT1.setName("lblGHT1"); // NOI18N

        lblGHT2.setText("          ");
        lblGHT2.setName("lblGHT2"); // NOI18N

        lblGHT3.setText("          ");
        lblGHT3.setName("lblGHT3"); // NOI18N

        lblGHT4.setText("          ");
        lblGHT4.setName("lblGHT4"); // NOI18N

        iconGHT1.setText("          ");
        iconGHT1.setName("iconGHT1"); // NOI18N

        iconGHT2.setText("          ");
        iconGHT2.setName("iconGHT2"); // NOI18N

        iconGHT3.setText("          ");
        iconGHT3.setName("iconGHT3"); // NOI18N

        iconGHT4.setText("          ");
        iconGHT4.setName("iconGHT4"); // NOI18N

        javax.swing.GroupLayout jpnlGrpHLayout = new javax.swing.GroupLayout(jpnlGrpH);
        jpnlGrpH.setLayout(jpnlGrpHLayout);
        jpnlGrpHLayout.setHorizontalGroup(
            jpnlGrpHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlGrpHLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlGrpHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlGrpHLayout.createSequentialGroup()
                        .addComponent(lblGHT1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGHT1))
                    .addGroup(jpnlGrpHLayout.createSequentialGroup()
                        .addComponent(lblGHT4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGHT4))
                    .addGroup(jpnlGrpHLayout.createSequentialGroup()
                        .addComponent(lblGHT2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGHT2))
                    .addGroup(jpnlGrpHLayout.createSequentialGroup()
                        .addComponent(lblGHT3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconGHT3)))
                .addContainerGap())
        );
        jpnlGrpHLayout.setVerticalGroup(
            jpnlGrpHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlGrpHLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlGrpHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iconGHT1)
                    .addComponent(lblGHT1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlGrpHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGHT2)
                    .addComponent(iconGHT2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlGrpHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGHT3)
                    .addComponent(iconGHT3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlGrpHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGHT4)
                    .addComponent(iconGHT4))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jpnlOitavas1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblO1T1.setText("          ");

        lblO1T2.setText("          ");

        iconO1T1.setText("          ");

        iconO1T2.setText("          ");

        placarO1T1.setText("0");

        placarO1T2.setText("0");

        javax.swing.GroupLayout jpnlOitavas1Layout = new javax.swing.GroupLayout(jpnlOitavas1);
        jpnlOitavas1.setLayout(jpnlOitavas1Layout);
        jpnlOitavas1Layout.setHorizontalGroup(
            jpnlOitavas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlOitavas1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlOitavas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblO1T1)
                    .addComponent(lblO1T2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jpnlOitavas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconO1T1)
                    .addComponent(iconO1T2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlOitavas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(placarO1T1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(placarO1T2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jpnlOitavas1Layout.setVerticalGroup(
            jpnlOitavas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlOitavas1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlOitavas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblO1T1)
                    .addComponent(iconO1T1)
                    .addComponent(placarO1T1))
                .addGap(21, 21, 21)
                .addGroup(jpnlOitavas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblO1T2)
                    .addComponent(iconO1T2)
                    .addComponent(placarO1T2))
                .addContainerGap())
        );

        jpnlOitavas2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblO2T1.setText("          ");

        iconO2T1.setText("          ");

        lblO2T2.setText("          ");

        iconO2T2.setText("          ");

        placarO2T1.setText("0");

        placarO2T2.setText("0");

        javax.swing.GroupLayout jpnlOitavas2Layout = new javax.swing.GroupLayout(jpnlOitavas2);
        jpnlOitavas2.setLayout(jpnlOitavas2Layout);
        jpnlOitavas2Layout.setHorizontalGroup(
            jpnlOitavas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlOitavas2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlOitavas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblO2T1)
                    .addComponent(lblO2T2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpnlOitavas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconO2T1)
                    .addComponent(iconO2T2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlOitavas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(placarO2T1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(placarO2T2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        jpnlOitavas2Layout.setVerticalGroup(
            jpnlOitavas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlOitavas2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlOitavas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconO2T1)
                    .addGroup(jpnlOitavas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblO2T1)
                        .addComponent(placarO2T1)))
                .addGap(18, 18, 18)
                .addGroup(jpnlOitavas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconO2T2)
                    .addComponent(placarO2T2)
                    .addComponent(lblO2T2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnlOitavas3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblO3T1.setText("          ");

        iconO3T1.setText("          ");

        lblO3T2.setText("          ");

        iconO3T2.setText("          ");

        placarO3T1.setText("0");

        placarO3T2.setText("0");

        javax.swing.GroupLayout jpnlOitavas3Layout = new javax.swing.GroupLayout(jpnlOitavas3);
        jpnlOitavas3.setLayout(jpnlOitavas3Layout);
        jpnlOitavas3Layout.setHorizontalGroup(
            jpnlOitavas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlOitavas3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlOitavas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblO3T1)
                    .addComponent(lblO3T2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpnlOitavas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(iconO3T1)
                    .addComponent(iconO3T2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlOitavas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(placarO3T1, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                    .addComponent(placarO3T2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        jpnlOitavas3Layout.setVerticalGroup(
            jpnlOitavas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlOitavas3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlOitavas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblO3T1)
                    .addComponent(iconO3T1)
                    .addComponent(placarO3T1))
                .addGap(18, 18, 18)
                .addGroup(jpnlOitavas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblO3T2)
                    .addComponent(iconO3T2)
                    .addComponent(placarO3T2))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jpnlOitavas4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        placarO4T2.setText("0");

        placarO4T1.setText("0");

        lblO4T1.setText("          ");

        iconO4T1.setText("          ");

        iconO4T2.setText("          ");

        lblO4T2.setText("          ");

        javax.swing.GroupLayout jpnlOitavas4Layout = new javax.swing.GroupLayout(jpnlOitavas4);
        jpnlOitavas4.setLayout(jpnlOitavas4Layout);
        jpnlOitavas4Layout.setHorizontalGroup(
            jpnlOitavas4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlOitavas4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlOitavas4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblO4T1)
                    .addComponent(lblO4T2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jpnlOitavas4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconO4T1)
                    .addComponent(iconO4T2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlOitavas4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(placarO4T2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(placarO4T1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        jpnlOitavas4Layout.setVerticalGroup(
            jpnlOitavas4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlOitavas4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlOitavas4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnlOitavas4Layout.createSequentialGroup()
                        .addComponent(iconO4T1)
                        .addGap(18, 18, 18)
                        .addComponent(iconO4T2))
                    .addGroup(jpnlOitavas4Layout.createSequentialGroup()
                        .addGroup(jpnlOitavas4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblO4T1)
                            .addComponent(placarO4T1))
                        .addGap(18, 18, 18)
                        .addGroup(jpnlOitavas4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(placarO4T2)
                            .addComponent(lblO4T2))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jpnlOitavas5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jpnlOitavas5.setName("jpnlOitavas5"); // NOI18N
        jpnlOitavas5.setPreferredSize(new java.awt.Dimension(104, 76));

        lblO5T1.setText("          ");

        iconO5T1.setText("          ");

        lblO5T2.setText("          ");

        iconO5T2.setText("          ");

        placarO5T1.setText("0");

        placarO5T2.setText("0");

        javax.swing.GroupLayout jpnlOitavas5Layout = new javax.swing.GroupLayout(jpnlOitavas5);
        jpnlOitavas5.setLayout(jpnlOitavas5Layout);
        jpnlOitavas5Layout.setHorizontalGroup(
            jpnlOitavas5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlOitavas5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlOitavas5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblO5T1)
                    .addComponent(lblO5T2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jpnlOitavas5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlOitavas5Layout.createSequentialGroup()
                        .addComponent(iconO5T1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(placarO5T1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnlOitavas5Layout.createSequentialGroup()
                        .addComponent(iconO5T2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(placarO5T2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpnlOitavas5Layout.setVerticalGroup(
            jpnlOitavas5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlOitavas5Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jpnlOitavas5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblO5T1)
                    .addComponent(iconO5T1)
                    .addComponent(placarO5T1))
                .addGap(18, 18, 18)
                .addGroup(jpnlOitavas5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblO5T2)
                    .addComponent(iconO5T2)
                    .addComponent(placarO5T2))
                .addGap(18, 18, 18))
        );

        jpnlOitavas6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jpnlOitavas6.setName("jpnlOitavas6"); // NOI18N
        jpnlOitavas6.setPreferredSize(new java.awt.Dimension(104, 76));

        lblO6T1.setText("          ");

        iconO6T1.setText("          ");

        lblO6T2.setText("          ");

        iconO6T2.setText("          ");

        placarO6T1.setText("0");

        placarO6T2.setText("0");

        javax.swing.GroupLayout jpnlOitavas6Layout = new javax.swing.GroupLayout(jpnlOitavas6);
        jpnlOitavas6.setLayout(jpnlOitavas6Layout);
        jpnlOitavas6Layout.setHorizontalGroup(
            jpnlOitavas6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlOitavas6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlOitavas6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblO6T1)
                    .addComponent(lblO6T2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jpnlOitavas6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconO6T1)
                    .addComponent(iconO6T2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlOitavas6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(placarO6T1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(placarO6T2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jpnlOitavas6Layout.setVerticalGroup(
            jpnlOitavas6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlOitavas6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jpnlOitavas6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblO6T1)
                    .addComponent(iconO6T1)
                    .addComponent(placarO6T1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpnlOitavas6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblO6T2)
                    .addComponent(iconO6T2)
                    .addComponent(placarO6T2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        jpnlOitavas7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jpnlOitavas7.setName("jpnlOitavas7"); // NOI18N
        jpnlOitavas7.setPreferredSize(new java.awt.Dimension(104, 76));

        lblO7T1.setText("          ");

        iconO7T1.setText("          ");

        lblO7T2.setText("          ");

        iconO7T2.setText("          ");

        placarO7T1.setText("0");

        placarO7T2.setText("0");

        javax.swing.GroupLayout jpnlOitavas7Layout = new javax.swing.GroupLayout(jpnlOitavas7);
        jpnlOitavas7.setLayout(jpnlOitavas7Layout);
        jpnlOitavas7Layout.setHorizontalGroup(
            jpnlOitavas7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlOitavas7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlOitavas7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblO7T2)
                    .addComponent(lblO7T1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jpnlOitavas7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconO7T2)
                    .addComponent(iconO7T1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlOitavas7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(placarO7T1, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                    .addComponent(placarO7T2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnlOitavas7Layout.setVerticalGroup(
            jpnlOitavas7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlOitavas7Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jpnlOitavas7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblO7T1)
                    .addComponent(iconO7T1)
                    .addComponent(placarO7T1))
                .addGap(18, 18, 18)
                .addGroup(jpnlOitavas7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblO7T2)
                    .addComponent(iconO7T2)
                    .addComponent(placarO7T2))
                .addGap(18, 18, 18))
        );

        jpnlOitavas8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jpnlOitavas8.setName("jpnlOitavas8"); // NOI18N
        jpnlOitavas8.setPreferredSize(new java.awt.Dimension(104, 76));

        lblO8T1.setText("          ");

        iconO8T1.setText("          ");

        lblO8T2.setText("          ");

        iconO8T2.setText("          ");

        placarO8T1.setText("0");

        placarO8T2.setText("0");

        javax.swing.GroupLayout jpnlOitavas8Layout = new javax.swing.GroupLayout(jpnlOitavas8);
        jpnlOitavas8.setLayout(jpnlOitavas8Layout);
        jpnlOitavas8Layout.setHorizontalGroup(
            jpnlOitavas8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlOitavas8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlOitavas8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblO8T1)
                    .addComponent(lblO8T2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jpnlOitavas8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconO8T1)
                    .addComponent(iconO8T2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlOitavas8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(placarO8T1, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                    .addComponent(placarO8T2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnlOitavas8Layout.setVerticalGroup(
            jpnlOitavas8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlOitavas8Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jpnlOitavas8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblO8T1)
                    .addComponent(iconO8T1)
                    .addComponent(placarO8T1))
                .addGap(18, 18, 18)
                .addGroup(jpnlOitavas8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblO8T2)
                    .addComponent(iconO8T2)
                    .addComponent(placarO8T2))
                .addGap(18, 18, 18))
        );

        jpnlQuartas1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jpnlQuartas1.setName("jpnlQuartas1"); // NOI18N
        jpnlQuartas1.setPreferredSize(new java.awt.Dimension(104, 76));

        lblQ1T1.setText("          ");

        iconQ1T1.setText("          ");

        lblQ1T2.setText("          ");

        iconQ1T2.setText("          ");

        placarQ1T1.setText("0");

        placarQ1T2.setText("0");

        javax.swing.GroupLayout jpnlQuartas1Layout = new javax.swing.GroupLayout(jpnlQuartas1);
        jpnlQuartas1.setLayout(jpnlQuartas1Layout);
        jpnlQuartas1Layout.setHorizontalGroup(
            jpnlQuartas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlQuartas1Layout.createSequentialGroup()
                .addGroup(jpnlQuartas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQ1T1)
                    .addComponent(lblQ1T2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jpnlQuartas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconQ1T1)
                    .addComponent(iconQ1T2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlQuartas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(placarQ1T1, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                    .addComponent(placarQ1T2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnlQuartas1Layout.setVerticalGroup(
            jpnlQuartas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlQuartas1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jpnlQuartas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQ1T1)
                    .addComponent(iconQ1T1)
                    .addComponent(placarQ1T1))
                .addGap(18, 18, 18)
                .addGroup(jpnlQuartas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnlQuartas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(iconQ1T2)
                        .addComponent(placarQ1T2))
                    .addComponent(lblQ1T2))
                .addGap(16, 16, 16))
        );

        jpnlQuartas2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jpnlQuartas2.setName("jpnlQuartas2"); // NOI18N
        jpnlQuartas2.setPreferredSize(new java.awt.Dimension(104, 76));

        lblQ2T1.setText("          ");

        iconQ2T1.setText("          ");

        lblQ2T2.setText("          ");

        iconQ2T2.setText("          ");

        placarQ2T1.setText("0");

        placarQ2T2.setText("0");

        javax.swing.GroupLayout jpnlQuartas2Layout = new javax.swing.GroupLayout(jpnlQuartas2);
        jpnlQuartas2.setLayout(jpnlQuartas2Layout);
        jpnlQuartas2Layout.setHorizontalGroup(
            jpnlQuartas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlQuartas2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlQuartas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQ2T1)
                    .addComponent(lblQ2T2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jpnlQuartas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconQ2T1)
                    .addComponent(iconQ2T2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlQuartas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(placarQ2T1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(placarQ2T2))
                .addContainerGap())
        );
        jpnlQuartas2Layout.setVerticalGroup(
            jpnlQuartas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlQuartas2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jpnlQuartas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQ2T1)
                    .addComponent(iconQ2T1)
                    .addComponent(placarQ2T1))
                .addGap(18, 18, 18)
                .addGroup(jpnlQuartas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQ2T2)
                    .addComponent(iconQ2T2)
                    .addComponent(placarQ2T2))
                .addGap(25, 25, 25))
        );

        jpnlQuartas3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jpnlQuartas3.setName("jpnlQuartas3"); // NOI18N
        jpnlQuartas3.setPreferredSize(new java.awt.Dimension(104, 76));

        lblQ3T1.setText("          ");

        iconQ3T1.setText("          ");

        lblQ3T2.setText("          ");

        iconQ3T2.setText("          ");

        placarQ3T1.setText("0");

        placarQ3T2.setText("0");

        javax.swing.GroupLayout jpnlQuartas3Layout = new javax.swing.GroupLayout(jpnlQuartas3);
        jpnlQuartas3.setLayout(jpnlQuartas3Layout);
        jpnlQuartas3Layout.setHorizontalGroup(
            jpnlQuartas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlQuartas3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlQuartas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQ3T2)
                    .addComponent(lblQ3T1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jpnlQuartas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconQ3T2)
                    .addComponent(iconQ3T1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlQuartas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(placarQ3T1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(placarQ3T2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jpnlQuartas3Layout.setVerticalGroup(
            jpnlQuartas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlQuartas3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jpnlQuartas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQ3T1)
                    .addComponent(iconQ3T1)
                    .addComponent(placarQ3T1))
                .addGap(18, 18, 18)
                .addGroup(jpnlQuartas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQ3T2)
                    .addComponent(iconQ3T2)
                    .addComponent(placarQ3T2))
                .addGap(18, 18, 18))
        );

        jpnlQuartas4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jpnlQuartas4.setName("jpnlQuartas4"); // NOI18N
        jpnlQuartas4.setPreferredSize(new java.awt.Dimension(104, 76));

        lblQ4T1.setText("          ");

        iconQ4T1.setText("          ");

        lblQ4T2.setText("          ");

        iconQ4T2.setText("          ");

        placarQ4T1.setText("0");

        placarQ4T2.setText("0");

        javax.swing.GroupLayout jpnlQuartas4Layout = new javax.swing.GroupLayout(jpnlQuartas4);
        jpnlQuartas4.setLayout(jpnlQuartas4Layout);
        jpnlQuartas4Layout.setHorizontalGroup(
            jpnlQuartas4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlQuartas4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlQuartas4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQ4T2)
                    .addComponent(lblQ4T1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jpnlQuartas4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconQ4T2)
                    .addComponent(iconQ4T1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlQuartas4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(placarQ4T1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(placarQ4T2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jpnlQuartas4Layout.setVerticalGroup(
            jpnlQuartas4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlQuartas4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlQuartas4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQ4T1)
                    .addComponent(iconQ4T1)
                    .addComponent(placarQ4T1))
                .addGap(18, 18, 18)
                .addGroup(jpnlQuartas4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQ4T2)
                    .addComponent(iconQ4T2)
                    .addComponent(placarQ4T2))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jpnlSemi1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jpnlSemi1.setName("jpnlSemi1"); // NOI18N
        jpnlSemi1.setPreferredSize(new java.awt.Dimension(104, 76));

        lblS1T1.setText("          ");

        iconS1T1.setText("          ");

        lblS1T2.setText("          ");

        iconS1T2.setText("          ");

        placarS1T1.setText("0");

        placarS1T2.setText("0");

        javax.swing.GroupLayout jpnlSemi1Layout = new javax.swing.GroupLayout(jpnlSemi1);
        jpnlSemi1.setLayout(jpnlSemi1Layout);
        jpnlSemi1Layout.setHorizontalGroup(
            jpnlSemi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlSemi1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlSemi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblS1T1)
                    .addComponent(lblS1T2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jpnlSemi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconS1T1)
                    .addComponent(iconS1T2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlSemi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(placarS1T1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(placarS1T2))
                .addContainerGap())
        );
        jpnlSemi1Layout.setVerticalGroup(
            jpnlSemi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlSemi1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jpnlSemi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblS1T1)
                    .addComponent(iconS1T1)
                    .addComponent(placarS1T1))
                .addGap(18, 18, 18)
                .addGroup(jpnlSemi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblS1T2)
                    .addComponent(iconS1T2)
                    .addComponent(placarS1T2))
                .addGap(20, 20, 20))
        );

        jpnlSemi2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jpnlSemi2.setName("jpnlSemi2"); // NOI18N
        jpnlSemi2.setPreferredSize(new java.awt.Dimension(104, 76));

        lblS2T1.setText("          ");

        iconS2T1.setText("          ");

        lblS2T2.setText("          ");

        iconS2T2.setText("          ");

        placarS2T1.setText("0");

        placarS2T2.setText("0");

        javax.swing.GroupLayout jpnlSemi2Layout = new javax.swing.GroupLayout(jpnlSemi2);
        jpnlSemi2.setLayout(jpnlSemi2Layout);
        jpnlSemi2Layout.setHorizontalGroup(
            jpnlSemi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlSemi2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlSemi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblS2T1)
                    .addComponent(lblS2T2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jpnlSemi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconS2T1)
                    .addComponent(iconS2T2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlSemi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(placarS2T2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(placarS2T1))
                .addContainerGap())
        );
        jpnlSemi2Layout.setVerticalGroup(
            jpnlSemi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlSemi2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jpnlSemi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblS2T1)
                    .addComponent(iconS2T1)
                    .addComponent(placarS2T1))
                .addGap(18, 18, 18)
                .addGroup(jpnlSemi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblS2T2)
                    .addComponent(iconS2T2)
                    .addComponent(placarS2T2))
                .addGap(20, 20, 20))
        );

        jpnlFinal.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jpnlFinal.setName("jpnlFinal"); // NOI18N
        jpnlFinal.setPreferredSize(new java.awt.Dimension(104, 76));

        lblF1T1.setText("          ");

        iconF1T1.setText("          ");

        lblF1T2.setText("          ");

        iconF1T2.setText("          ");

        placarF1T1.setText("0");

        placarF1T2.setText("0");

        lblFinal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFinal.setText("Final");

        javax.swing.GroupLayout jpnlFinalLayout = new javax.swing.GroupLayout(jpnlFinal);
        jpnlFinal.setLayout(jpnlFinalLayout);
        jpnlFinalLayout.setHorizontalGroup(
            jpnlFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlFinalLayout.createSequentialGroup()
                .addGroup(jpnlFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlFinalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpnlFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblF1T1)
                            .addComponent(lblF1T2)))
                    .addGroup(jpnlFinalLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lblFinal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jpnlFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlFinalLayout.createSequentialGroup()
                        .addComponent(iconF1T2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(placarF1T2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlFinalLayout.createSequentialGroup()
                        .addComponent(iconF1T1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(placarF1T1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpnlFinalLayout.setVerticalGroup(
            jpnlFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlFinalLayout.createSequentialGroup()
                .addComponent(lblFinal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblF1T1)
                    .addComponent(iconF1T1)
                    .addComponent(placarF1T1))
                .addGap(18, 18, 18)
                .addGroup(jpnlFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblF1T2)
                    .addComponent(iconF1T2)
                    .addComponent(placarF1T2))
                .addGap(36, 36, 36))
        );

        jlblBandeira.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlblBandeira.setForeground(new java.awt.Color(0, 153, 0));
        jlblBandeira.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblTaca1.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:/C:/Users/digog/Documents/NetBeansProjects/FootCup2022/src/main/java/projetoa3/footcup2022/Imagens/trofeu2.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        lblTaca1.setText(" ");

        lblTaca2.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:/C:/Users/digog/Documents/NetBeansProjects/FootCup2022/src/main/java/projetoa3/footcup2022/Imagens/trofeu2.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        lblTaca2.setText(" ");

        javax.swing.GroupLayout jpnlContainerLayout = new javax.swing.GroupLayout(jpnlContainer);
        jpnlContainer.setLayout(jpnlContainerLayout);
        jpnlContainerLayout.setHorizontalGroup(
            jpnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlContainerLayout.createSequentialGroup()
                        .addGroup(jpnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpnlGrpD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnlGrpC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnlGrpB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnlGrpA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jpnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnlContainerLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jpnlOitavas4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jpnlOitavas3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jpnlOitavas2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jpnlOitavas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jpnlQuartas2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpnlContainerLayout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(lblQuartas1))
                                    .addComponent(jpnlQuartas1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpnlContainerLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(lblOitavas1))))
                    .addComponent(lblTaca1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jpnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlContainerLayout.createSequentialGroup()
                        .addGroup(jpnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlContainerLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblQuartas2)
                                .addGap(251, 251, 251))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlContainerLayout.createSequentialGroup()
                                .addGroup(jpnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlContainerLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jlblBandeira, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblTaca2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(120, 120, 120))
                                    .addGroup(jpnlContainerLayout.createSequentialGroup()
                                        .addGroup(jpnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jpnlContainerLayout.createSequentialGroup()
                                                .addGroup(jpnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jpnlContainerLayout.createSequentialGroup()
                                                        .addGap(125, 125, 125)
                                                        .addComponent(lblSemis1))
                                                    .addGroup(jpnlContainerLayout.createSequentialGroup()
                                                        .addGap(76, 76, 76)
                                                        .addComponent(jpnlFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(99, 99, 99)
                                                .addGroup(jpnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jpnlQuartas4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jpnlQuartas3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jpnlContainerLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jpnlSemi1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jpnlSemi2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGroup(jpnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jpnlOitavas6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jpnlOitavas7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jpnlOitavas8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlContainerLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(lblFootCupIcon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jpnlOitavas5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlContainerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblOitavas2)
                        .addGap(68, 68, 68)))
                .addGroup(jpnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpnlGrpG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnlGrpF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnlGrpE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnlGrpH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        jpnlContainerLayout.setVerticalGroup(
            jpnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlContainerLayout.createSequentialGroup()
                .addGroup(jpnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlContainerLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jpnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpnlContainerLayout.createSequentialGroup()
                                .addComponent(lblOitavas1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jpnlOitavas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jpnlGrpA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnlContainerLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jpnlGrpB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnlContainerLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jpnlOitavas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jpnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnlContainerLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jpnlGrpC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jpnlGrpD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnlContainerLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jpnlOitavas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jpnlOitavas4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jpnlContainerLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jpnlGrpE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnlGrpF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnlGrpG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnlGrpH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnlContainerLayout.createSequentialGroup()
                        .addGroup(jpnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jpnlContainerLayout.createSequentialGroup()
                                .addGap(187, 187, 187)
                                .addComponent(lblQuartas1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jpnlQuartas1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jpnlQuartas2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnlContainerLayout.createSequentialGroup()
                                .addGroup(jpnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnlContainerLayout.createSequentialGroup()
                                        .addGap(189, 189, 189)
                                        .addComponent(lblQuartas2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jpnlQuartas3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpnlContainerLayout.createSequentialGroup()
                                        .addGroup(jpnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jpnlContainerLayout.createSequentialGroup()
                                                .addGap(289, 289, 289)
                                                .addComponent(lblSemis1))
                                            .addGroup(jpnlContainerLayout.createSequentialGroup()
                                                .addGap(65, 65, 65)
                                                .addComponent(lblFootCupIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jpnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jpnlSemi1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jpnlSemi2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(26, 26, 26)
                                .addGroup(jpnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jpnlFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jpnlQuartas4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jpnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnlContainerLayout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(jlblBandeira, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnlContainerLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jpnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTaca2)
                                    .addComponent(lblTaca1))))))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(jpnlContainerLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(lblOitavas2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnlOitavas5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jpnlOitavas6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jpnlOitavas7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpnlOitavas8, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnlContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVoltarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        frmHome frm = new frmHome();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_jbtnVoltarActionPerformed

    private void jbtnSimularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSimularActionPerformed
        try {
            if (new Time().Listar().size() == 32) {
                new Grupo().LimpaSql();
                preparaGrupos();
                preparaOitavas();
                preparaQuartas();
                preparaSemis();
                preparaFinal();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jbtnSimularActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmVisualizarJogos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVisualizarJogos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVisualizarJogos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVisualizarJogos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmVisualizarJogos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconF1T1;
    private javax.swing.JLabel iconF1T2;
    private javax.swing.JLabel iconGAT1;
    private javax.swing.JLabel iconGAT2;
    private javax.swing.JLabel iconGAT4;
    private javax.swing.JLabel iconGAT73;
    private javax.swing.JLabel iconGBT1;
    private javax.swing.JLabel iconGBT2;
    private javax.swing.JLabel iconGBT3;
    private javax.swing.JLabel iconGBT4;
    private javax.swing.JLabel iconGCT1;
    private javax.swing.JLabel iconGCT2;
    private javax.swing.JLabel iconGCT3;
    private javax.swing.JLabel iconGCT4;
    private javax.swing.JLabel iconGDT1;
    private javax.swing.JLabel iconGDT2;
    private javax.swing.JLabel iconGDT3;
    private javax.swing.JLabel iconGDT4;
    private javax.swing.JLabel iconGET1;
    private javax.swing.JLabel iconGET2;
    private javax.swing.JLabel iconGET3;
    private javax.swing.JLabel iconGET4;
    private javax.swing.JLabel iconGFT1;
    private javax.swing.JLabel iconGFT2;
    private javax.swing.JLabel iconGFT3;
    private javax.swing.JLabel iconGFT4;
    private javax.swing.JLabel iconGGT1;
    private javax.swing.JLabel iconGGT2;
    private javax.swing.JLabel iconGGT3;
    private javax.swing.JLabel iconGGT4;
    private javax.swing.JLabel iconGHT1;
    private javax.swing.JLabel iconGHT2;
    private javax.swing.JLabel iconGHT3;
    private javax.swing.JLabel iconGHT4;
    private javax.swing.JLabel iconO1T1;
    private javax.swing.JLabel iconO1T2;
    private javax.swing.JLabel iconO2T1;
    private javax.swing.JLabel iconO2T2;
    private javax.swing.JLabel iconO3T1;
    private javax.swing.JLabel iconO3T2;
    private javax.swing.JLabel iconO4T1;
    private javax.swing.JLabel iconO4T2;
    private javax.swing.JLabel iconO5T1;
    private javax.swing.JLabel iconO5T2;
    private javax.swing.JLabel iconO6T1;
    private javax.swing.JLabel iconO6T2;
    private javax.swing.JLabel iconO7T1;
    private javax.swing.JLabel iconO7T2;
    private javax.swing.JLabel iconO8T1;
    private javax.swing.JLabel iconO8T2;
    private javax.swing.JLabel iconQ1T1;
    private javax.swing.JLabel iconQ1T2;
    private javax.swing.JLabel iconQ2T1;
    private javax.swing.JLabel iconQ2T2;
    private javax.swing.JLabel iconQ3T1;
    private javax.swing.JLabel iconQ3T2;
    private javax.swing.JLabel iconQ4T1;
    private javax.swing.JLabel iconQ4T2;
    private javax.swing.JLabel iconS1T1;
    private javax.swing.JLabel iconS1T2;
    private javax.swing.JLabel iconS2T1;
    private javax.swing.JLabel iconS2T2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JButton jbtnSimular;
    private javax.swing.JButton jbtnVoltar;
    private javax.swing.JLabel jlblBandeira;
    private javax.swing.JPanel jpnlContainer;
    private javax.swing.JPanel jpnlFinal;
    private javax.swing.JPanel jpnlGrpA;
    private javax.swing.JPanel jpnlGrpB;
    private javax.swing.JPanel jpnlGrpC;
    private javax.swing.JPanel jpnlGrpD;
    private javax.swing.JPanel jpnlGrpE;
    private javax.swing.JPanel jpnlGrpF;
    private javax.swing.JPanel jpnlGrpG;
    private javax.swing.JPanel jpnlGrpH;
    private javax.swing.JPanel jpnlOitavas1;
    private javax.swing.JPanel jpnlOitavas2;
    private javax.swing.JPanel jpnlOitavas3;
    private javax.swing.JPanel jpnlOitavas4;
    private javax.swing.JPanel jpnlOitavas5;
    private javax.swing.JPanel jpnlOitavas6;
    private javax.swing.JPanel jpnlOitavas7;
    private javax.swing.JPanel jpnlOitavas8;
    private javax.swing.JPanel jpnlQuartas1;
    private javax.swing.JPanel jpnlQuartas2;
    private javax.swing.JPanel jpnlQuartas3;
    private javax.swing.JPanel jpnlQuartas4;
    private javax.swing.JPanel jpnlSemi1;
    private javax.swing.JPanel jpnlSemi2;
    private javax.swing.JLabel lblF1T1;
    private javax.swing.JLabel lblF1T2;
    private javax.swing.JLabel lblFinal;
    private javax.swing.JLabel lblFootCupIcon;
    private javax.swing.JLabel lblGAT1;
    private javax.swing.JLabel lblGAT2;
    private javax.swing.JLabel lblGAT3;
    private javax.swing.JLabel lblGAT4;
    private javax.swing.JLabel lblGBT1;
    private javax.swing.JLabel lblGBT2;
    private javax.swing.JLabel lblGBT3;
    private javax.swing.JLabel lblGBT4;
    private javax.swing.JLabel lblGCT1;
    private javax.swing.JLabel lblGCT2;
    private javax.swing.JLabel lblGCT3;
    private javax.swing.JLabel lblGCT4;
    private javax.swing.JLabel lblGDT1;
    private javax.swing.JLabel lblGDT2;
    private javax.swing.JLabel lblGDT3;
    private javax.swing.JLabel lblGDT4;
    private javax.swing.JLabel lblGET1;
    private javax.swing.JLabel lblGET2;
    private javax.swing.JLabel lblGET3;
    private javax.swing.JLabel lblGET4;
    private javax.swing.JLabel lblGFT1;
    private javax.swing.JLabel lblGFT2;
    private javax.swing.JLabel lblGFT3;
    private javax.swing.JLabel lblGFT4;
    private javax.swing.JLabel lblGGT1;
    private javax.swing.JLabel lblGGT2;
    private javax.swing.JLabel lblGGT3;
    private javax.swing.JLabel lblGGT4;
    private javax.swing.JLabel lblGHT1;
    private javax.swing.JLabel lblGHT2;
    private javax.swing.JLabel lblGHT3;
    private javax.swing.JLabel lblGHT4;
    private javax.swing.JLabel lblO1T1;
    private javax.swing.JLabel lblO1T2;
    private javax.swing.JLabel lblO2T1;
    private javax.swing.JLabel lblO2T2;
    private javax.swing.JLabel lblO3T1;
    private javax.swing.JLabel lblO3T2;
    private javax.swing.JLabel lblO4T1;
    private javax.swing.JLabel lblO4T2;
    private javax.swing.JLabel lblO5T1;
    private javax.swing.JLabel lblO5T2;
    private javax.swing.JLabel lblO6T1;
    private javax.swing.JLabel lblO6T2;
    private javax.swing.JLabel lblO7T1;
    private javax.swing.JLabel lblO7T2;
    private javax.swing.JLabel lblO8T1;
    private javax.swing.JLabel lblO8T2;
    private javax.swing.JLabel lblOitavas1;
    private javax.swing.JLabel lblOitavas2;
    private javax.swing.JLabel lblQ1T1;
    private javax.swing.JLabel lblQ1T2;
    private javax.swing.JLabel lblQ2T1;
    private javax.swing.JLabel lblQ2T2;
    private javax.swing.JLabel lblQ3T1;
    private javax.swing.JLabel lblQ3T2;
    private javax.swing.JLabel lblQ4T1;
    private javax.swing.JLabel lblQ4T2;
    private javax.swing.JLabel lblQuartas1;
    private javax.swing.JLabel lblQuartas2;
    private javax.swing.JLabel lblS1T1;
    private javax.swing.JLabel lblS1T2;
    private javax.swing.JLabel lblS2T1;
    private javax.swing.JLabel lblS2T2;
    private javax.swing.JLabel lblSemis1;
    private javax.swing.JLabel lblTaca1;
    private javax.swing.JLabel lblTaca2;
    private javax.swing.JLabel placarF1T1;
    private javax.swing.JLabel placarF1T2;
    private javax.swing.JLabel placarO1T1;
    private javax.swing.JLabel placarO1T2;
    private javax.swing.JLabel placarO2T1;
    private javax.swing.JLabel placarO2T2;
    private javax.swing.JLabel placarO3T1;
    private javax.swing.JLabel placarO3T2;
    private javax.swing.JLabel placarO4T1;
    private javax.swing.JLabel placarO4T2;
    private javax.swing.JLabel placarO5T1;
    private javax.swing.JLabel placarO5T2;
    private javax.swing.JLabel placarO6T1;
    private javax.swing.JLabel placarO6T2;
    private javax.swing.JLabel placarO7T1;
    private javax.swing.JLabel placarO7T2;
    private javax.swing.JLabel placarO8T1;
    private javax.swing.JLabel placarO8T2;
    private javax.swing.JLabel placarQ1T1;
    private javax.swing.JLabel placarQ1T2;
    private javax.swing.JLabel placarQ2T1;
    private javax.swing.JLabel placarQ2T2;
    private javax.swing.JLabel placarQ3T1;
    private javax.swing.JLabel placarQ3T2;
    private javax.swing.JLabel placarQ4T1;
    private javax.swing.JLabel placarQ4T2;
    private javax.swing.JLabel placarS1T1;
    private javax.swing.JLabel placarS1T2;
    private javax.swing.JLabel placarS2T1;
    private javax.swing.JLabel placarS2T2;
    // End of variables declaration//GEN-END:variables
}
