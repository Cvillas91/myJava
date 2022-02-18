import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;


public class Resultados extends JFrame implements WindowListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTitulo;
	private JTextField txtA1;
	private JTextField txtMu1;
	private JTextField txtS1;
	private JTextField txtA2;
	private JTextField txtMu;
	private JTextField txtMu2;
	private JTextField txtBSigma;
	private JTextField txtS2;
	private JTextField txtA21;
	private JTextField txtMu21;
	private JTextField txtS21;
	private JTextField txtA22;
	private JTextField txtA3;
	private JTextField txtMu22;
	private JTextField txtMu3;
	private JTextField txtS22;
	private JTextField txtS3;
	private JLabel lblMu;
	private JLabel lblSigma;
	private JLabel lblB;
	private JLabel lblAlfa1;
	private JLabel lblMu1;
	private JLabel lblSigma1;
	private JLabel lblSigma2;
	private JLabel lblMu2;
	private JLabel lblAlfa2;
	private JLabel lblSigma31;
	private JLabel lblMu31;
	private JLabel lblAlfa31;
	private JLabel lblAlfa32;
	private JLabel lblMu32;
	private JLabel lblSigma32;
	private JLabel lblAlfa33;
	private JLabel lblMu33;
	private JLabel lblSigma33;

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	
	public JTextField getTxtA1() {
		return txtA1;
	}

	public void setTxtA1(JTextField txtA1) {
		this.txtA1 = txtA1;
	}

	public JTextField getTxtMu1() {
		return txtMu1;
	}

	public void setTxtMu1(JTextField txtMu1) {
		this.txtMu1 = txtMu1;
	}

	public JTextField getTxtS1() {
		return txtS1;
	}

	public void setTxtS1(JTextField txtS1) {
		this.txtS1 = txtS1;
	}

	public JTextField getTxtA2() {
		return txtA2;
	}

	public void setTxtA2(JTextField txtA2) {
		this.txtA2 = txtA2;
	}

	public JTextField getTxtMu() {
		return txtMu;
	}

	public void setTxtMu(JTextField txtMu) {
		this.txtMu = txtMu;
	}

	public JTextField getTxtMu2() {
		return txtMu2;
	}

	public void setTxtMu2(JTextField txtMu2) {
		this.txtMu2 = txtMu2;
	}

	public JTextField getTxtBSigma() {
		return txtBSigma;
	}

	public void setTxtBSigma(JTextField txtBSigma) {
		this.txtBSigma = txtBSigma;
	}

	public JTextField getTxtS2() {
		return txtS2;
	}

	public void setTxtS2(JTextField txtS2) {
		this.txtS2 = txtS2;
	}

	public JTextField getTxtA21() {
		return txtA21;
	}

	public void setTxtA21(JTextField txtA21) {
		this.txtA21 = txtA21;
	}

	public JTextField getTxtMu21() {
		return txtMu21;
	}

	public void setTxtMu21(JTextField txtMu21) {
		this.txtMu21 = txtMu21;
	}

	public JTextField getTxtS21() {
		return txtS21;
	}

	public void setTxtS21(JTextField txtS21) {
		this.txtS21 = txtS21;
	}

	public JTextField getTxtA22() {
		return txtA22;
	}

	public void setTxtA22(JTextField txtA22) {
		this.txtA22 = txtA22;
	}

	public JTextField getTxtA3() {
		return txtA3;
	}

	public void setTxtA3(JTextField txtA3) {
		this.txtA3 = txtA3;
	}

	public JTextField getTxtMu22() {
		return txtMu22;
	}

	public void setTxtMu22(JTextField txtMu22) {
		this.txtMu22 = txtMu22;
	}

	public JTextField getTxtMu3() {
		return txtMu3;
	}

	public void setTxtMu3(JTextField txtMu3) {
		this.txtMu3 = txtMu3;
	}

	public JTextField getTxtS22() {
		return txtS22;
	}

	public void setTxtS22(JTextField txtS22) {
		this.txtS22 = txtS22;
	}

	public JTextField getTxtS3() {
		return txtS3;
	}

	public void setTxtS3(JTextField txtS3) {
		this.txtS3 = txtS3;
	}

	public JLabel getLblMu() {
		return lblMu;
	}

	public void setLblMu(JLabel lblMu) {
		this.lblMu = lblMu;
	}

	public JLabel getLblSigma() {
		return lblSigma;
	}

	public void setLblSigma(JLabel lblSigma) {
		this.lblSigma = lblSigma;
	}

	public JLabel getLblB() {
		return lblB;
	}

	public void setLblB(JLabel lblB) {
		this.lblB = lblB;
	}

	public JLabel getLblAlfa1() {
		return lblAlfa1;
	}

	public void setLblAlfa1(JLabel lblAlfa1) {
		this.lblAlfa1 = lblAlfa1;
	}

	public JLabel getLblMu1() {
		return lblMu1;
	}

	public void setLblMu1(JLabel lblMu1) {
		this.lblMu1 = lblMu1;
	}

	public JLabel getLblSigma1() {
		return lblSigma1;
	}

	public void setLblSigma1(JLabel lblSigma1) {
		this.lblSigma1 = lblSigma1;
	}

	public JLabel getLblSigma2() {
		return lblSigma2;
	}

	public void setLblSigma2(JLabel lblSigma2) {
		this.lblSigma2 = lblSigma2;
	}

	public JLabel getLblMu2() {
		return lblMu2;
	}

	public void setLblMu2(JLabel lblMu2) {
		this.lblMu2 = lblMu2;
	}

	public JLabel getLblAlfa2() {
		return lblAlfa2;
	}

	public void setLblAlfa2(JLabel lblAlfa2) {
		this.lblAlfa2 = lblAlfa2;
	}

	public JLabel getLblSigma31() {
		return lblSigma31;
	}

	public void setLblSigma31(JLabel lblSigma31) {
		this.lblSigma31 = lblSigma31;
	}

	public JLabel getLblMu31() {
		return lblMu31;
	}

	public void setLblMu31(JLabel lblMu31) {
		this.lblMu31 = lblMu31;
	}

	public JLabel getLblAlfa31() {
		return lblAlfa31;
	}

	public void setLblAlfa31(JLabel lblAlfa31) {
		this.lblAlfa31 = lblAlfa31;
	}

	public JLabel getLblAlfa32() {
		return lblAlfa32;
	}

	public void setLblAlfa32(JLabel lblAlfa32) {
		this.lblAlfa32 = lblAlfa32;
	}

	public JLabel getLblMu32() {
		return lblMu32;
	}

	public void setLblMu32(JLabel lblMu32) {
		this.lblMu32 = lblMu32;
	}

	public JLabel getLblSigma32() {
		return lblSigma32;
	}

	public void setLblSigma32(JLabel lblSigma32) {
		this.lblSigma32 = lblSigma32;
	}

	public JLabel getLblAlfa33() {
		return lblAlfa33;
	}

	public void setLblAlfa33(JLabel lblAlfa33) {
		this.lblAlfa33 = lblAlfa33;
	}

	public JLabel getLblMu33() {
		return lblMu33;
	}

	public void setLblMu33(JLabel lblMu33) {
		this.lblMu33 = lblMu33;
	}

	public JLabel getLblSigma33() {
		return lblSigma33;
	}

	public void setLblSigma33(JLabel lblSigma33) {
		this.lblSigma33 = lblSigma33;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resultados frame = new Resultados();
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
	public Resultados() {
		setTitle("Par\u00E1metros Estimados");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 400, 450, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.lblTitulo = new JLabel("TITULO");
		lblTitulo.setBounds(10, 5, 414, 45);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitulo);
		
		this.lblMu = new JLabel("\u00B5 =");
		lblMu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMu.setBounds(146, 81, 31, 24);
		contentPane.add(lblMu);
		this.lblMu.setVisible(false);
		
		this.lblSigma = new JLabel("\u03C3 =");
		lblSigma.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSigma.setBounds(146, 136, 31, 24);
		contentPane.add(lblSigma);
		this.lblSigma.setVisible(false);
		
		this.lblB = new JLabel("b =");
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblB.setBounds(146, 136, 31, 24);
		contentPane.add(lblB);
		this.lblB.setVisible(false);
		
		this.lblAlfa1 = new JLabel("\u03B11 =");
		lblAlfa1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlfa1.setBounds(84, 66, 42, 24);
		contentPane.add(lblAlfa1);
		this.lblAlfa1.setVisible(false);
		
		this.lblMu1 = new JLabel("\u00B51 =");
		lblMu1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMu1.setBounds(84, 121, 42, 24);
		contentPane.add(lblMu1);
		this.lblMu1.setVisible(false);
		
		this.lblSigma1 = new JLabel("\u03C31 =");
		lblSigma1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSigma1.setBounds(84, 173, 42, 24);
		contentPane.add(lblSigma1);
		this.lblSigma1.setVisible(false);
		
		this.lblSigma2 = new JLabel("\u03C32 =");
		lblSigma2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSigma2.setBounds(211, 173, 42, 24);
		contentPane.add(lblSigma2);
		this.lblSigma2.setVisible(false);
		
		this.lblMu2 = new JLabel("\u00B52 =");
		lblMu2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMu2.setBounds(211, 121, 42, 24);
		contentPane.add(lblMu2);
		this.lblMu2.setVisible(false);
		
		this.lblAlfa2 = new JLabel("\u03B12 =");
		lblAlfa2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlfa2.setBounds(211, 66, 42, 24);
		contentPane.add(lblAlfa2);
		this.lblAlfa2.setVisible(false);
		
		this.lblSigma31 = new JLabel("\u03C31 =");
		lblSigma31.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSigma31.setBounds(37, 173, 42, 24);
		contentPane.add(lblSigma31);
		this.lblSigma31.setVisible(false);
		
		this.lblMu31 = new JLabel("\u00B51 =");
		lblMu31.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMu31.setBounds(37, 121, 42, 24);
		contentPane.add(lblMu31);
		this.lblMu31.setVisible(false);
		
		this.lblAlfa31 = new JLabel("\u03B11 =");
		lblAlfa31.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlfa31.setBounds(37, 66, 42, 24);
		contentPane.add(lblAlfa31);
		this.lblAlfa31.setVisible(false);
		
		this.lblAlfa32 = new JLabel("\u03B12 =");
		lblAlfa32.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlfa32.setBounds(153, 66, 42, 24);
		contentPane.add(lblAlfa32);
		this.lblAlfa32.setVisible(false);
		
		this.lblMu32 = new JLabel("\u00B52 =");
		lblMu32.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMu32.setBounds(153, 121, 42, 24);
		contentPane.add(lblMu32);
		this.lblMu32.setVisible(false);
		
		this.lblSigma32 = new JLabel("\u03C32 =");
		lblSigma32.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSigma32.setBounds(153, 173, 42, 24);
		contentPane.add(lblSigma32);
		this.lblSigma32.setVisible(false);
		
		this.lblAlfa33 = new JLabel("\u03B13 =");
		lblAlfa33.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlfa33.setBounds(269, 66, 42, 24);
		contentPane.add(lblAlfa33);
		this.lblAlfa33.setVisible(false);
		
		this.lblMu33 = new JLabel("\u00B53 =");
		lblMu33.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMu33.setBounds(269, 121, 42, 24);
		contentPane.add(lblMu33);
		this.lblMu33.setVisible(false);
		
		this.lblSigma33 = new JLabel("\u03C33 =");
		lblSigma33.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSigma33.setBounds(269, 173, 42, 24);
		contentPane.add(lblSigma33);
		this.lblSigma33.setVisible(false);
		
		this.txtA1 = new JTextField();
		txtA1.setEditable(false);
		txtA1.setBounds(72, 70, 77, 20);
		contentPane.add(txtA1);
		txtA1.setColumns(10);
		this.txtA1.setVisible(false);
		
		this.txtMu1 = new JTextField();
		txtMu1.setEditable(false);
		txtMu1.setColumns(10);
		txtMu1.setBounds(72, 125, 77, 20);
		contentPane.add(txtMu1);
		this.txtMu1.setVisible(false);
		
		this.txtS1 = new JTextField();
		txtS1.setEditable(false);
		txtS1.setColumns(10);
		txtS1.setBounds(72, 177, 77, 20);
		contentPane.add(txtS1);
		this.txtS1.setVisible(false);
		
		this.txtA2 = new JTextField();
		txtA2.setEditable(false);
		txtA2.setColumns(10);
		txtA2.setBounds(188, 70, 77, 20);
		contentPane.add(txtA2);
		this.txtA2.setVisible(false);
		
		this.txtMu = new JTextField();
		txtMu.setEditable(false);
		txtMu.setColumns(10);
		txtMu.setBounds(176, 81, 77, 20);
		contentPane.add(txtMu);
		this.txtMu.setVisible(false);
		
		this.txtMu2 = new JTextField();
		txtMu2.setEditable(false);
		txtMu2.setColumns(10);
		txtMu2.setBounds(188, 125, 77, 20);
		contentPane.add(txtMu2);
		this.txtMu2.setVisible(false);
		
		this.txtBSigma = new JTextField();
		txtBSigma.setEditable(false);
		txtBSigma.setColumns(10);
		txtBSigma.setBounds(176, 136, 77, 20);
		contentPane.add(txtBSigma);
		this.txtBSigma.setVisible(false);
		
		this.txtS2 = new JTextField();
		txtS2.setEditable(false);
		txtS2.setColumns(10);
		txtS2.setBounds(188, 177, 77, 20);
		contentPane.add(txtS2);
		this.txtS2.setVisible(false);
	
		this.txtA21 = new JTextField();
		txtA21.setEditable(false);
		txtA21.setColumns(10);
		txtA21.setBounds(124, 70, 77, 20);
		contentPane.add(txtA21);
		this.txtA21.setVisible(false);
		
		this.txtMu21 = new JTextField();
		txtMu21.setEditable(false);
		txtMu21.setColumns(10);
		txtMu21.setBounds(124, 125, 77, 20);
		contentPane.add(txtMu21);
		this.txtMu21.setVisible(false);
		
		this.txtS21 = new JTextField();
		txtS21.setEditable(false);
		txtS21.setColumns(10);
		txtS21.setBounds(124, 177, 77, 20);
		contentPane.add(txtS21);
		this.txtS21.setVisible(false);
		
		this.txtA22 = new JTextField();
		txtA22.setEditable(false);
		txtA22.setColumns(10);
		txtA22.setBounds(245, 70, 77, 20);
		contentPane.add(txtA22);
		this.txtA22.setVisible(false);
		
		this.txtA3 = new JTextField();
		txtA3.setEditable(false);
		txtA3.setColumns(10);
		txtA3.setBounds(305, 70, 77, 20);
		contentPane.add(txtA3);
		this.txtA3.setVisible(false);
		
		this.txtMu22 = new JTextField();
		txtMu22.setEditable(false);
		txtMu22.setColumns(10);
		txtMu22.setBounds(245, 125, 77, 20);
		contentPane.add(txtMu22);
		this.txtMu22.setVisible(false);
		
		this.txtMu3 = new JTextField();
		txtMu3.setEditable(false);
		txtMu3.setColumns(10);
		txtMu3.setBounds(305, 125, 77, 20);
		contentPane.add(txtMu3);
		this.txtMu3.setVisible(false);
		
		this.txtS22 = new JTextField();
		txtS22.setEditable(false);
		txtS22.setColumns(10);
		txtS22.setBounds(245, 177, 77, 20);
		contentPane.add(txtS22);
		this.txtS22.setVisible(false);
		
		this.txtS3 = new JTextField();
		txtS3.setEditable(false);
		txtS3.setColumns(10);
		txtS3.setBounds(305, 177, 77, 20);
		contentPane.add(txtS3);
		this.txtS3.setVisible(false);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
