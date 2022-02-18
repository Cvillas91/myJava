import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.Checkbox;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import org.jfree.ui.RefineryUtilities;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JLabel;
import java.awt.Font;


public class MainWindow extends Frame implements WindowListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFrame frmTesis;
	
	private TextArea txtDatos;
	private Checkbox cbEst;
	private Checkbox cbAD;
	private Checkbox cbKS;
	private Checkbox cbPP;
	private Checkbox cbQQ;
	private Checkbox cbAIC;
	private Checkbox cbBIC;
	private Checkbox cbDIS;
	private Checkbox cbDEN;
	private JComboBox ajustes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmTesis.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTesis = new JFrame();
		frmTesis.setTitle("Ajuste autom\u00E1tico de funciones de distribuci\u00F3n");
		frmTesis.setBounds(100, 100, 450, 300);
		frmTesis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTesis.getContentPane().setLayout(null);
		
		TextArea txtDatos = new TextArea();
		txtDatos.setBounds(10, 10, 106, 242);
		this.txtDatos = txtDatos;
		frmTesis.getContentPane().add(this.txtDatos);
		txtDatos.toString();
		
		Checkbox cbEst = new Checkbox("Estad\u00EDsticas Descriptivas");
		cbEst.setBounds(135, 95, 164, 22);
		this.cbEst = cbEst;
		frmTesis.getContentPane().add(cbEst);
		
		Checkbox cbAD = new Checkbox("Anderson Darling");
		cbAD.setBounds(135, 123, 164, 22);
		this.cbAD = cbAD;
		frmTesis.getContentPane().add(cbAD);
		
		Checkbox cbKS = new Checkbox("Kolmogorov-Smirnov");
		cbKS.setBounds(135, 148, 139, 22);
		this.cbKS = cbKS;
		frmTesis.getContentPane().add(cbKS);
		
		Checkbox cbPP = new Checkbox("PP-Plot");
		cbPP.setBounds(312, 95, 95, 22);
		this.cbPP = cbPP;
		frmTesis.getContentPane().add(cbPP);
		
		Checkbox cbQQ = new Checkbox("QQ-Plot");
		cbQQ.setBounds(312, 123, 95, 22);
		this.cbQQ = cbQQ;
		frmTesis.getContentPane().add(cbQQ);
		
		Checkbox cbAIC = new Checkbox("AIC");
		cbAIC.setBounds(312, 148, 52, 20);
		this.cbAIC = cbAIC;
		frmTesis.getContentPane().add(cbAIC);
		
		Checkbox cbBIC = new Checkbox("BIC");
		cbBIC.setBounds(312, 174, 52, 22);
		this.cbBIC = cbBIC;
		frmTesis.getContentPane().add(cbBIC);
		
		Checkbox cbDIS = new Checkbox("Funci\u00F3n de Distribuci\u00F3n");
		cbDIS.setBounds(135, 174, 149, 22);
		this.cbDIS = cbDIS;
		frmTesis.getContentPane().add(cbDIS);
		
		Checkbox cbDEN = new Checkbox("Funci\u00F3n de Densidad");
		cbDEN.setBounds(135, 202, 139, 22);
		this.cbDEN = cbDEN;
		frmTesis.getContentPane().add(cbDEN);
		
		JComboBox ajustes = new JComboBox();
		ajustes.setModel(new DefaultComboBoxModel(new String[] {"Ajuste Normal", "Ajuste Laplace", "Ajuste Mixtura 2 Componentes", "Ajuste Mixtura 3 Componentes"}));
		ajustes.setSelectedIndex(0);
		ajustes.setBounds(135, 69, 228, 20);
		this.ajustes = ajustes;
		frmTesis.getContentPane().add(ajustes);
		
		Button btnCalcular = new Button("Calcular");
		btnCalcular.addActionListener(this);
		btnCalcular.setBounds(325, 218, 70, 22);
		frmTesis.getContentPane().add(btnCalcular);
		
		JLabel lblAjueste = new JLabel("Ajuste Autom\u00E1tico de Funciones de Distribuci\u00F3n\r \r\n");
		lblAjueste.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAjueste.setBounds(135, 11, 289, 22);
		frmTesis.getContentPane().add(lblAjueste);
		
		JLabel lblPorCarlosGonzalo = new JLabel("por Carlos Gonzalo Villas Vel\u00E1zquez");
		lblPorCarlosGonzalo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPorCarlosGonzalo.setBounds(221, 44, 174, 14);
		frmTesis.getContentPane().add(lblPorCarlosGonzalo);
		
	}

	public void actionPerformed(ActionEvent arg0) {
		
		ArrayList<Double> datos = new ArrayList<Double>();
		ArrayList<Double> FY = new ArrayList<Double>();
		String texto = this.txtDatos.getText();
		
		double andersonDarling = 0 ,kolmogorovSmirnov = 0;
		String valorP = "", valorPAD = "";
		
		if(texto.isEmpty()) {
			System.out.println("Esta vacio");
		} else {
			
			try {
				String[] tokens = texto.split("\n");
				for(String s : tokens) {
					datos.add(Double.parseDouble(s));
				}
				AndersonDarling ad = new AndersonDarling(datos);
				KolmogorovSmirnov ks = new KolmogorovSmirnov(datos);
				
				Hashtable<String, Double> hash;
				double alfa0 = 0.0;
				double alfa1 = 0.0;
				double alfa2 = 0.0;
				double mu0 = 0.0;
				double mu1 = 0.0;
				double mu2 = 0.0;
				double sigma0 = 0.0;
				double sigma1 = 0.0;
				double sigma2 = 0.0;
				
				Resultados res = new Resultados();
				DecimalFormat formato = new DecimalFormat("#.########");
				
				switch(this.ajustes.getSelectedIndex()) {
					
					case 0:
						
						if(this.cbQQ.getState() == true) {
							
							PuntoQQ q = new PuntoQQ(datos);
							q.agregarPuntosNormal();
							
							GraficaQQ plotter = new GraficaQQ(q.getListaPuntos(), datos);
							plotter.pack();
							RefineryUtilities.centerFrameOnScreen(plotter);
							plotter.setVisible(true);
						}
						
						if(this.cbDIS.getState() == true) {
							
							PuntoFDIS f = new PuntoFDIS(datos);
							f.agregarPuntosNormal();
							
							GraficaFDIS plotter = new GraficaFDIS(f.getListaPuntos1(), f.getListaPuntos2());
							plotter.pack();
							RefineryUtilities.centerFrameOnScreen(plotter);
							plotter.setVisible(true);
						}
						
						if(this.cbDEN.getState() == true) {
							
							PuntoFDEN f = new PuntoFDEN(datos);
							f.agregarPuntosNormal();
							
							GraficaFDEN plotter = new GraficaFDEN(f.getListaPuntos1(), f.getListaPuntos2());
							plotter.pack();
							RefineryUtilities.centerFrameOnScreen(plotter);
							plotter.setVisible(true);
						}
						
						AjusteNormal aNormal = new AjusteNormal(datos);
						double mu = aNormal.calcularMu();
						double sigma = aNormal.calcularSigma(mu);
						res.getLblTitulo().setText("Distribución Normal");
						res.getTxtMu().setText(formato.format(mu));
						res.getTxtBSigma().setText(formato.format(sigma));
						res.getLblMu().setVisible(true);
						res.getLblSigma().setVisible(true);
						res.getTxtMu().setVisible(true);
						res.getTxtBSigma().setVisible(true);
						res.setVisible(true);
						
						FY = ad.calcularFNormal();
						andersonDarling = ad.calcularAD(FY);
						kolmogorovSmirnov = ks.calcularKS(FY);
						valorP = ks.pValueKS(kolmogorovSmirnov);
						valorPAD = ad.getPValue(andersonDarling);
						
						break;
					case 1:
						
						if(this.cbQQ.getState() == true) {
							
							PuntoQQ q = new PuntoQQ(datos);
							q.agregarPuntosLaplace();
							
							GraficaQQ plotter = new GraficaQQ(q.getListaPuntos(), datos);
							plotter.pack();
							RefineryUtilities.centerFrameOnScreen(plotter);
							plotter.setVisible(true);
						}
						
						if(this.cbDIS.getState() == true) {
							
							PuntoFDIS f = new PuntoFDIS(datos);
							f.agregarPuntosLaplace();
							
							GraficaFDIS plotter = new GraficaFDIS(f.getListaPuntos1(), f.getListaPuntos2());
							plotter.pack();
							RefineryUtilities.centerFrameOnScreen(plotter);
							plotter.setVisible(true);
						}
						
						if(this.cbDEN.getState() == true) {
							
							PuntoFDEN f = new PuntoFDEN(datos);
							f.agregarPuntosLaplace();
							
							GraficaFDEN plotter = new GraficaFDEN(f.getListaPuntos1(), f.getListaPuntos2());
							plotter.pack();
							RefineryUtilities.centerFrameOnScreen(plotter);
							plotter.setVisible(true);
						}
						
						AjusteLaplace aLaplace = new AjusteLaplace(datos);
						double muL = aLaplace.calcularMuL();
						double b = aLaplace.calcularB(muL);
						
						res.getLblTitulo().setText("Distribución de Laplace");
						
						res.getTxtMu().setText(formato.format(muL));
						res.getTxtBSigma().setText(formato.format(b));
						
						res.getLblMu().setVisible(true);
						res.getLblB().setVisible(true);
						res.getTxtMu().setVisible(true);
						res.getTxtBSigma().setVisible(true);
						
						res.setVisible(true);
						
						FY = ks.calcularFLaplace();
						andersonDarling = ad.calcularAD(FY);
						kolmogorovSmirnov = ks.calcularKS(FY);
						valorP = ks.pValueKS(kolmogorovSmirnov);
						valorPAD = ad.getPValue(andersonDarling);
						
						break;
					case 2:
						
						if(this.cbQQ.getState() == true) {
							
							PuntoQQ q = new PuntoQQ(datos);
							q.agregarPuntosMix2();
							
							GraficaQQ plotter = new GraficaQQ(q.getListaPuntos(), datos);
							plotter.pack();
							RefineryUtilities.centerFrameOnScreen(plotter);
							plotter.setVisible(true);
						}
						
						if(this.cbDIS.getState() == true) {
							
							PuntoFDIS f = new PuntoFDIS(datos);
							f.agregarPuntosMix2();
							
							GraficaFDIS plotter = new GraficaFDIS(f.getListaPuntos1(), f.getListaPuntos2());
							plotter.pack();
							RefineryUtilities.centerFrameOnScreen(plotter);
							plotter.setVisible(true);
						}
						
						if(this.cbDEN.getState() == true) {
							
							PuntoFDEN f = new PuntoFDEN(datos);
							f.agregarPuntosMix2();
							
							GraficaFDEN plotter = new GraficaFDEN(f.getListaPuntos1(), f.getListaPuntos2());
							plotter.pack();
							RefineryUtilities.centerFrameOnScreen(plotter);
							plotter.setVisible(true);
						}
						
						AjusteMix2 aMix2 = new AjusteMix2(datos);
						hash = aMix2.calcularMix2();
						
						alfa0 = hash.get("alfa0");
						alfa1 = hash.get("alfa1");
						mu0 = hash.get("mu0");
						mu1 = hash.get("mu1");
						sigma0 = hash.get("sigma0");
						sigma1 = hash.get("sigma1");
						
						res.getLblTitulo().setText("Mixtura Gaussiana de 2 Componentes");

						res.getTxtA21().setText(formato.format(alfa0));
						res.getTxtMu21().setText(formato.format(mu0));
						res.getTxtS21().setText(formato.format(sigma0));
						
						res.getTxtA22().setText(formato.format(alfa1));
						res.getTxtMu22().setText(formato.format(mu1));
						res.getTxtS22().setText(formato.format(sigma1));
						
						res.getLblAlfa1().setVisible(true);
						res.getLblMu1().setVisible(true);
						res.getLblSigma1().setVisible(true);
						res.getLblAlfa2().setVisible(true);
						res.getLblMu2().setVisible(true);
						res.getLblSigma2().setVisible(true);
						
						res.getTxtA21().setVisible(true);
						res.getTxtMu21().setVisible(true);
						res.getTxtS21().setVisible(true);
						res.getTxtA22().setVisible(true);
						res.getTxtMu22().setVisible(true);
						res.getTxtS22().setVisible(true);
						
						res.setVisible(true);
						
						FY = ad.calcularFMix2();
						andersonDarling = ad.calcularAD(FY);
						kolmogorovSmirnov = ks.calcularKS(FY);
						valorP = ks.pValueKS(kolmogorovSmirnov);
						valorPAD = ad.getPValue(andersonDarling);
						
						break;
					case 3:
						
						if(this.cbQQ.getState() == true) {
							
							PuntoQQ q = new PuntoQQ(datos);
							q.agregarPuntosMix3();
							
							GraficaQQ plotter = new GraficaQQ(q.getListaPuntos(), datos);
							plotter.pack();
							RefineryUtilities.centerFrameOnScreen(plotter);
							plotter.setVisible(true);
						}
						
						if(this.cbDIS.getState() == true) {
							
							PuntoFDIS f = new PuntoFDIS(datos);
							f.agregarPuntosMix3();
							
							GraficaFDIS plotter = new GraficaFDIS(f.getListaPuntos1(), f.getListaPuntos2());
							plotter.pack();
							RefineryUtilities.centerFrameOnScreen(plotter);
							plotter.setVisible(true);
						}
						
						if(this.cbDEN.getState() == true) {
							
							PuntoFDEN f = new PuntoFDEN(datos);
							f.agregarPuntosMix3();
							
							GraficaFDEN plotter = new GraficaFDEN(f.getListaPuntos1(), f.getListaPuntos2());
							plotter.pack();
							RefineryUtilities.centerFrameOnScreen(plotter);
							plotter.setVisible(true);
						}
						
						AjusteMix3 aMix3 = new AjusteMix3(datos);
						hash = aMix3.calcularMix3();
						
						alfa0 = hash.get("alfa0");
						alfa1 = hash.get("alfa1");
						alfa2 = hash.get("alfa2");
						mu0 = hash.get("mu0");
						mu1 = hash.get("mu1");
						mu2 = hash.get("mu2");
						sigma0 = hash.get("sigma0");
						sigma1 = hash.get("sigma1");
						sigma2 = hash.get("sigma2");
						
						res.getLblTitulo().setText("Mixtura Gaussiana de 3 Componentes");
						
						res.getTxtA1().setText(formato.format(alfa0));
						res.getTxtMu1().setText(formato.format(mu0));
						res.getTxtS1().setText(formato.format(sigma0));
						
						res.getTxtA2().setText(formato.format(alfa1));
						res.getTxtMu2().setText(formato.format(mu1));
						res.getTxtS2().setText(formato.format(sigma1));
						
						res.getTxtA3().setText(formato.format(alfa2));
						res.getTxtMu3().setText(formato.format(mu2));
						res.getTxtS3().setText(formato.format(sigma2));
						
						res.getLblAlfa31().setVisible(true);
						res.getLblMu31().setVisible(true);
						res.getLblSigma31().setVisible(true);
						res.getLblAlfa32().setVisible(true);
						res.getLblMu32().setVisible(true);
						res.getLblSigma32().setVisible(true);
						res.getLblAlfa33().setVisible(true);
						res.getLblMu33().setVisible(true);
						res.getLblSigma33().setVisible(true);
						
						res.getTxtA1().setVisible(true);
						res.getTxtMu1().setVisible(true);
						res.getTxtS1().setVisible(true);
						res.getTxtA2().setVisible(true);
						res.getTxtMu2().setVisible(true);
						res.getTxtS2().setVisible(true);
						res.getTxtA3().setVisible(true);
						res.getTxtMu3().setVisible(true);
						res.getTxtS3().setVisible(true);
						
						res.setVisible(true);
						FY = ad.calcularFMix3();
						andersonDarling = ad.calcularAD(FY);
						kolmogorovSmirnov = ks.calcularKS(FY);
						valorP = ks.pValueKS(kolmogorovSmirnov);
						valorPAD = ad.getPValue(andersonDarling);
						
						break;
					default:
						break;
				}
			} catch(NumberFormatException e) {
				System.out.println("No es número");
			}
			
			//Condicion Estadisticas
			if ( this.cbEst.getState() == true ){
			
				EstDes estadisticas = new EstDes(datos);
				EstadisticasDescriptivas ventanaEstadisticas = new EstadisticasDescriptivas(estadisticas.calcularMedia(),
																							estadisticas.calcularSigma(),
																							estadisticas.calcularAsimetria(), 
																							estadisticas.calcularCurtosis(),
																							estadisticas.calcularMinimo(), 
																							estadisticas.calcularMaximo());
				ventanaEstadisticas.setVisible(true);
				
				
			}
			
			
			//Condiciones de Anderson-Darling Kolmogorov-Smirnov
			if ( this.cbAD.getState() == true && this.cbKS.getState() == true ){
				BondadAjuste b = new BondadAjuste(andersonDarling, kolmogorovSmirnov, valorPAD, valorP);
				b.setVisible(true);
				
			}else if(this.cbAD.getState() == true){
				BondadAjuste b = new BondadAjuste(andersonDarling, true, valorPAD);
				b.setVisible(true);
			}else if(this.cbKS.getState() == true){
				BondadAjuste b = new BondadAjuste(kolmogorovSmirnov, false, valorP);
				b.setVisible(true);
			}else{
				//No haces nada
			}
			
			//Condiciones AIC - BIC
			if ( this.cbAIC.getState() == true && this.cbBIC.getState() == true && this.ajustes.getSelectedIndex() != 1){
				
				double AICnormal = 0.0;
				double AICmix2 = 0.0; double AICmix3 = 0.0;
				double BICnormal = 0.0;
				double BICmix2 = 0.0; double BICmix3 = 0.0;
				
				AkaikeBayesian IC = new AkaikeBayesian(datos);
				AICnormal = IC.calcularAICnormal();
				AICmix2 = IC.calcularAICmix2();
				AICmix3 = IC.calcularAICmix3();
				BICnormal = IC.calcularBICnormal();
				BICmix2 = IC.calcularBICmix2();
				BICmix3 = IC.calcularBICmix3();
				
				InformationCriterion b = new InformationCriterion(AICnormal,
										AICmix2, AICmix3, BICnormal,
										BICmix2, BICmix3);
				b.setVisible(true);
				
			}else if(this.cbAIC.getState() == true && this.ajustes.getSelectedIndex() != 1){
				
				double ICnormal = 0.0; 
				double ICmix2 = 0.0; double ICmix3 = 0.0;
				
				AkaikeBayesian IC = new AkaikeBayesian(datos);
				ICnormal = IC.calcularAICnormal();
				ICmix2 = IC.calcularAICmix2();
				ICmix3 = IC.calcularAICmix3();
			
				InformationCriterion b = new InformationCriterion(ICnormal,
										ICmix2, ICmix3, true);
				
				b.setVisible(true);
				
			}else if(this.cbBIC.getState() == true && this.ajustes.getSelectedIndex() != 1){
				
				double ICnormal = 0.0; 
				double ICmix2 = 0.0; double ICmix3 = 0.0;
				
				AkaikeBayesian IC = new AkaikeBayesian(datos);
				ICnormal = IC.calcularBICnormal();
				ICmix2 = IC.calcularBICmix2();
				ICmix3 = IC.calcularBICmix3();
			
				InformationCriterion b = new InformationCriterion(ICnormal,
										ICmix2, ICmix3, false);
				
				b.setVisible(true);
				
			}else{
				//No haces nada
			}
			
			
			//Condiciones de GraficarPP
			if(this.cbPP.getState() == true){
				PuntoPP p = new PuntoPP(datos,FY);
				p.agregarPuntos();
				
				GraficaPP plotter = new GraficaPP(p.getListaPuntos());
				plotter.pack();
		        RefineryUtilities.centerFrameOnScreen(plotter);
		        plotter.setVisible(true);
				//p.imprimirPuntos();
			}
			
			
		}
	}
	
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
