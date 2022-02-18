import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class BondadAjuste extends JFrame {

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
					BondadAjuste frame = new BondadAjuste(1,2,"", "");
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
	public BondadAjuste(){
		setTitle("Pruebas de bondad de ajuste");
		setBounds(550, 400, 250, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	public BondadAjuste(double ad, double ks, String valorPAD, String valorP) {
	
		this();
		
		String pValue = "P-Value" + valorP;
		String pValueAD = "P-Value" + valorPAD;

		JLabel lblAndersondarling = new JLabel("Anderson-Darling");
		lblAndersondarling.setBounds(65, 110, 150, 20);
		contentPane.add(lblAndersondarling);
		
		JLabel lblResad = new JLabel(pValueAD);
		lblResad.setBounds(80, 140, 150, 20);
		contentPane.add(lblResad);
		
		JLabel lblKolmogorovsmirnov = new JLabel("Kolmogorov-Smirnov");
		lblKolmogorovsmirnov.setBounds(55, 30, 170, 20);
		contentPane.add(lblKolmogorovsmirnov);
		
		JLabel lblResks = new JLabel(pValue);
		lblResks.setBounds(80, 60, 150, 20);
		contentPane.add(lblResks);
	}
	public BondadAjuste(double numero, boolean anderson, String valorP) {
		
		this();
		
		String cadena="";
		String pValue = "P-Value" + valorP;
		
		if(anderson){
			cadena = "Anderson-Darling";
		}else{
			cadena = "Kolmogorov-Smirnov";
		}
		
		JLabel lblKolmogorovsmirnov = new JLabel(cadena);
		lblKolmogorovsmirnov.setBounds(60, 70, 170, 20);
		contentPane.add(lblKolmogorovsmirnov);
		
		JLabel lblResks = new JLabel(pValue);
		lblResks.setBounds(80, 100, 150, 20);
		contentPane.add(lblResks);
		
	}
	


}