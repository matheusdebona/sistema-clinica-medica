package br.com.matheusdebona.sistemaclinicamedica.view.telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.matheusdebona.sistemaclinicamedica.core.entity.MedicoEntity;
import br.com.matheusdebona.sistemaclinicamedica.core.service.MedicoService;
import br.com.matheusdebona.sistemaclinicamedica.util.NegocioException;

public class TelaCadastroMedico {

	public JFrame frmGestoDeClnicas;
	private JTextField textNome;
	private JTextField textCrm;
	private JTextField textEmail;
	private JTextField textEspecialidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroMedico window = new TelaCadastroMedico();
					window.frmGestoDeClnicas.setVisible(true);
					window.frmGestoDeClnicas.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroMedico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestoDeClnicas = new JFrame();
		frmGestoDeClnicas.setLocationRelativeTo(null);
		frmGestoDeClnicas.setTitle("Gestão de Clínicas - Matheus de Bona");
		frmGestoDeClnicas.setBounds(100, 100, 1280, 720);
		frmGestoDeClnicas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGestoDeClnicas.getContentPane().setLayout(null);
		frmGestoDeClnicas.setLocationRelativeTo(null);
		
		JLabel lblCadastroDeMdico = new JLabel("Cadastro de Médico");
		lblCadastroDeMdico.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeMdico.setForeground(Color.WHITE);
		lblCadastroDeMdico.setFont(new Font("Verdana", Font.BOLD, 45));
		lblCadastroDeMdico.setBounds(341, 103, 581, 58);
		frmGestoDeClnicas.getContentPane().add(lblCadastroDeMdico);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_1.setBounds(606, 184, 51, 32);
		frmGestoDeClnicas.getContentPane().add(lblNewLabel_1);
		
		textNome = new JTextField();
		textNome.setHorizontalAlignment(SwingConstants.CENTER);
		textNome.setFont(new Font("Verdana", Font.PLAIN, 15));
		textNome.setColumns(10);
		textNome.setBounds(460, 212, 343, 32);
		frmGestoDeClnicas.getContentPane().add(textNome);
		
		JLabel lblNewLabel_1_1 = new JLabel("CRM");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(582, 256, 99, 32);
		frmGestoDeClnicas.getContentPane().add(lblNewLabel_1_1);
		
		textCrm = new JTextField();
		textCrm.setHorizontalAlignment(SwingConstants.CENTER);
		textCrm.setFont(new Font("Verdana", Font.PLAIN, 15));
		textCrm.setColumns(10);
		textCrm.setBounds(460, 284, 343, 32);
		frmGestoDeClnicas.getContentPane().add(textCrm);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(590, 327, 83, 32);
		frmGestoDeClnicas.getContentPane().add(lblNewLabel_1_2);
		
		textEmail = new JTextField();
		textEmail.setHorizontalAlignment(SwingConstants.CENTER);
		textEmail.setFont(new Font("Verdana", Font.PLAIN, 15));
		textEmail.setColumns(10);
		textEmail.setBounds(460, 355, 343, 32);
		frmGestoDeClnicas.getContentPane().add(textEmail);
		
		JLabel lblNewLabel_1_3 = new JLabel("Especialidade");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(564, 398, 135, 32);
		frmGestoDeClnicas.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblCadastroSucesso = new JLabel("");
		lblCadastroSucesso.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroSucesso.setForeground(Color.WHITE);
		lblCadastroSucesso.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCadastroSucesso.setBounds(460, 469, 343, 28);
		frmGestoDeClnicas.getContentPane().add(lblCadastroSucesso);
		
		textEspecialidade = new JTextField();
		textEspecialidade.setHorizontalAlignment(SwingConstants.CENTER);
		textEspecialidade.setFont(new Font("Verdana", Font.PLAIN, 15));
		textEspecialidade.setColumns(10);
		textEspecialidade.setBounds(460, 426, 343, 32);
		frmGestoDeClnicas.getContentPane().add(textEspecialidade);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String nome = textNome.getText();
				String crm = textCrm.getText();
				String email = textEmail.getText();
				String especialidade = textEspecialidade.getText();
				
				MedicoEntity medico = new MedicoEntity();

				medico.setNome("Dr(a) " + nome);
				medico.setCrm(crm);
				medico.setEmail(email);
				medico.setEspecialidade(especialidade);
				
				MedicoService ms = new MedicoService();
				
				try {
					ms.salvarMedico(medico);
					lblCadastroSucesso.setText("Médico cadastrado com sucesso!");
					limparCampos();
				
				} catch (NegocioException e1) {
					e1.getMensagemDeErro();
				}
				
			}
		});
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Verdana", Font.BOLD, 16));
		btnCadastrar.setBackground(new Color(255, 204, 204));
		btnCadastrar.setBounds(549, 508, 165, 32);
		frmGestoDeClnicas.getContentPane().add(btnCadastrar);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Criado por Matheus de Bona");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(507, 622, 249, 26);
		frmGestoDeClnicas.getContentPane().add(lblNewLabel_1_1_1);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicialAssistente tia = new TelaInicialAssistente();
				tia.frmGestoDeClnicas.setVisible(true);
				frmGestoDeClnicas.dispose();
			}
		});
		btnVoltar.setForeground(Color.PINK);
		btnVoltar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(10, 11, 125, 45);
		frmGestoDeClnicas.getContentPane().add(btnVoltar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(TelaCadastroMedico.class.getResource("/br/com/matheusdebona/sistemaclinicamedica/view/resource/Ícone - Rosa fundo rosa claro.jpg")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(0, 0, 1264, 681);
		frmGestoDeClnicas.getContentPane().add(lblNewLabel_2);
		
	}
	
	public void limparCampos() {
		textNome.setText("");
		textCrm.setText("");
		textEmail.setText("");
		textEspecialidade.setText("");
	}

}
