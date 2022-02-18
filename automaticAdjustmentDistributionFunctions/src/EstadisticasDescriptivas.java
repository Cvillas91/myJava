import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DecimalFormat;


public class EstadisticasDescriptivas extends JFrame {

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
					EstadisticasDescriptivas frame = new EstadisticasDescriptivas(2,3,2,3,4,5);
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
	public EstadisticasDescriptivas(double media, double sigma, double asimetria, double curtosis, double minimo, double maximo) {
		DecimalFormat formato = new DecimalFormat("#.########");
		setTitle("Estadisticas Descriptivas");
		setBounds(550, 100, 250, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMedia = new JLabel("Media =");
		lblMedia.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblMedia.setBounds(27, 11, 60, 28);
		contentPane.add(lblMedia);
		
		JLabel lblNewLabel = new JLabel("\u03C3 =");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel.setBounds(27, 54, 60, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblAsimetra = new JLabel("Asimetr\u00EDa = ");
		lblAsimetra.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblAsimetra.setBounds(27, 93, 99, 14);
		contentPane.add(lblAsimetra);
		
		JLabel lblCurtosis = new JLabel("Curtosis =");
		lblCurtosis.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCurtosis.setBounds(27, 132, 87, 14);
		contentPane.add(lblCurtosis);
		
		JLabel lblMnimo = new JLabel("M\u00EDnimo = ");
		lblMnimo.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblMnimo.setBounds(27, 175, 87, 14);
		contentPane.add(lblMnimo);
		
		JLabel lblMximo = new JLabel("M\u00E1ximo =");
		lblMximo.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblMximo.setBounds(27, 224, 87, 14);
		contentPane.add(lblMximo);
		
		JLabel lblRes = new JLabel(Formato.devolverFormato(media));
		lblRes.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblRes.setBounds(124, 18, 70, 14);
		contentPane.add(lblRes);
		
		JLabel lblRes_1 = new JLabel(formato.format(sigma));
		lblRes_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblRes_1.setBounds(124, 58, 70, 14);
		contentPane.add(lblRes_1);
		
		
		JLabel lblResasimetria = new JLabel(formato.format(asimetria));
		lblResasimetria.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblResasimetria.setBounds(124, 93, 70, 14);
		contentPane.add(lblResasimetria);
		
		JLabel lblRescurtosis = new JLabel(formato.format(curtosis));
		lblRescurtosis.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblRescurtosis.setBounds(124, 132, 70, 14);
		contentPane.add(lblRescurtosis);
		
		JLabel lblResminimo = new JLabel(formato.format(minimo));
		lblResminimo.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblResminimo.setBounds(124, 175, 70, 14);
		contentPane.add(lblResminimo);
		
		JLabel lblResmaximo = new JLabel(formato.format(maximo));
		lblResmaximo.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblResmaximo.setBounds(124, 224, 70, 14);
		contentPane.add(lblResmaximo);
	}
}
