import java.awt.EventQueue;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class InformationCriterion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformationCriterion frame = new InformationCriterion(0,0,0,0,0,0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public InformationCriterion(){
		setTitle("Criterios de Información");
		setBounds(800, 100, 300, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	public InformationCriterion(double AICnormal,  double AICmix2, double AICmix3, 
			double BICnormal, double BICmix2, double BICmix3) {
	
		this();
		
		DecimalFormat formato = new DecimalFormat("#.##");
		
		double strAICnormal = AICnormal;
		String strAICnormal1 = formato.format(strAICnormal);
		
		double strAICmix2 = AICmix2;
		String strAICmix21 = formato.format(strAICmix2);
		
		double strAICmix3 = AICmix3;
		String strAICmix31 = formato.format(strAICmix3);
		
		double strBICnormal = BICnormal;
		String strBICnormal1 = formato.format(strBICnormal);
		
		double strBICmix2 = BICmix2;
		String strBICmix21 = formato.format(strBICmix2);
		
		double strBICmix3 = BICmix3;
		String strBICmix31 = formato.format(strBICmix3);
		
		JLabel lblAIC = new JLabel("Criterio de información de Akaike");
		lblAIC.setBounds(50, 30, 200, 20);
		contentPane.add(lblAIC);
		
		JLabel lblResad0 = new JLabel("Ajuste Normal = " + strAICnormal1);
		lblResad0.setBounds(40, 80, 250, 20);
		contentPane.add(lblResad0);
	
		JLabel lblResad4 = new JLabel("Ajuste Mix 2 Componentes = " + strAICmix21);
		lblResad4.setBounds(40, 110, 250, 20);
		contentPane.add(lblResad4);
		
		JLabel lblResad5 = new JLabel("Ajuste Mix 3 Componentes = " + strAICmix31);
		lblResad5.setBounds(40, 140, 250, 20);
		contentPane.add(lblResad5);
		
		JLabel lblBIC = new JLabel("Criterio de información Bayesiano");
		lblBIC.setBounds(50, 250, 200, 20);
		contentPane.add(lblBIC);
		
		JLabel lblResad1 = new JLabel("Ajuste Normal = " + strBICnormal1);
		lblResad1.setBounds(40, 300, 250, 20);
		contentPane.add(lblResad1);
		
		JLabel lblResad = new JLabel("Ajuste Mix 2 Componentes = " + strBICmix21);
		lblResad.setBounds(40, 330, 250, 20);
		contentPane.add(lblResad);
		
		JLabel lblResad6 = new JLabel("Ajuste Mix 3 Componentes = " + strBICmix31);
		lblResad6.setBounds(40, 360, 250, 20);
		contentPane.add(lblResad6);

	}
	
	public InformationCriterion(double ICnormal, double ICmix2,
			double ICmix3, boolean IC) {
		
		this();
		
		DecimalFormat formato = new DecimalFormat("#.##");
		
		String cadena="";
		
		if(IC){
			cadena = "Criterio de información de Akaike";
		}else{
			cadena = "Criterio de información Bayesiano";
		}
		
		Double strICnormal = ICnormal;
		String strICnormal1 = formato.format(strICnormal);
		
		double strICmix2 = ICmix2;
		String strICmix21 = formato.format(strICmix2);
		
		double strICmix3 = ICmix3;
		String strICmix31 = formato.format(strICmix3);
		
		JLabel lblABIC = new JLabel(cadena);
		lblABIC.setBounds(50, 150, 200, 20);
		contentPane.add(lblABIC);
		
		JLabel lblResks1 = new JLabel("Ajuste Normal = " + strICnormal1);
		lblResks1.setBounds(40, 210, 250, 20);
		contentPane.add(lblResks1);
		
		JLabel lblResks3 = new JLabel("Ajuste Mix 2 Componentes = " + strICmix21);
		lblResks3.setBounds(40, 240, 250, 20);
		contentPane.add(lblResks3);
		
		JLabel lblResks4 = new JLabel("Ajuste Mix 3 Componentes = " + strICmix31);
		lblResks4.setBounds(40, 270, 250, 20);
		contentPane.add(lblResks4);
		
	}
	


}