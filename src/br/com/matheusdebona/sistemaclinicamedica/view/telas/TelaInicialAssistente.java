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
import javax.swing.SwingConstants;

public class TelaInicialAssistente {

	public JFrame frmGestoDeClnicas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicialAssistente window = new TelaInicialAssistente();
					window.frmGestoDeClnicas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaInicialAssistente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestoDeClnicas = new JFrame();
		frmGestoDeClnicas.setTitle("Gestão de Clínicas - Matheus de Bona");
		frmGestoDeClnicas.setResizable(false);
		frmGestoDeClnicas.setBounds(100, 100, 1280, 720);
		frmGestoDeClnicas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGestoDeClnicas.getContentPane().setLayout(null);
		frmGestoDeClnicas.setLocationRelativeTo(null);
		
		JButton btnCadastrarProcedimentos = new JButton("Cadastrar Procedimentos");
		btnCadastrarProcedimentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaCadastroProcedimento cadastrarProcedimento = new TelaCadastroProcedimento();
				cadastrarProcedimento.setVisible(true);
				cadastrarProcedimento.setLocationRelativeTo(null);
				
				frmGestoDeClnicas.dispose();
				
				
			}
		});
		btnCadastrarProcedimentos.setForeground(new Color(255, 192, 203));
		btnCadastrarProcedimentos.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnCadastrarProcedimentos.setBackground(Color.WHITE);
		btnCadastrarProcedimentos.setBounds(507, 212, 249, 111);
		frmGestoDeClnicas.getContentPane().add(btnCadastrarProcedimentos);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Criado por Matheus de Bona");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(507, 578, 249, 26);
		frmGestoDeClnicas.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Gestão de Clínicas");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 45));
		lblNewLabel_1.setBounds(402, 48, 460, 58);
		frmGestoDeClnicas.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Administrador");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 35));
		lblNewLabel_1_1.setBounds(438, 103, 387, 58);
		frmGestoDeClnicas.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnCadastrarClientes = new JButton("Cadastrar Clientes");
		btnCadastrarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroCliente tcc = new TelaCadastroCliente();
				tcc.setVisible(true);
				tcc.setLocationRelativeTo(null);
				frmGestoDeClnicas.dispose();
				
			}
		});
		btnCadastrarClientes.setForeground(new Color(255, 192, 203));
		btnCadastrarClientes.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnCadastrarClientes.setBackground(Color.WHITE);
		btnCadastrarClientes.setBounds(205, 212, 249, 111);
		frmGestoDeClnicas.getContentPane().add(btnCadastrarClientes);
		
		JButton btnCadastrarMedicos = new JButton("Cadastrar Médicos");
		btnCadastrarMedicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroMedico tcm = new TelaCadastroMedico();
				tcm.frmGestoDeClnicas.setVisible(true);
				tcm.frmGestoDeClnicas.setLocationRelativeTo(null);
				frmGestoDeClnicas.dispose();
				
			}
		});
		btnCadastrarMedicos.setForeground(new Color(255, 192, 203));
		btnCadastrarMedicos.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnCadastrarMedicos.setBackground(Color.WHITE);
		btnCadastrarMedicos.setBounds(810, 212, 249, 111);
		frmGestoDeClnicas.getContentPane().add(btnCadastrarMedicos);
		
		JButton btnListaClientes = new JButton("Lista de Clientes");
		btnListaClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaCliente tlc = new TelaListaCliente();
				tlc.frmSistema.setVisible(true);
				frmGestoDeClnicas.dispose();
				
			}
		});
		btnListaClientes.setForeground(new Color(255, 192, 203));
		btnListaClientes.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnListaClientes.setBackground(Color.WHITE);
		btnListaClientes.setBounds(205, 374, 249, 111);
		frmGestoDeClnicas.getContentPane().add(btnListaClientes);
		
		JButton btnListaProcedimentos = new JButton("Lista de Procedimentos");
		btnListaProcedimentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaListaProcedimento tlp = new TelaListaProcedimento();
				tlp.frmSistema.setVisible(true);
				tlp.frmSistema.setLocationRelativeTo(null);
				frmGestoDeClnicas.dispose();
				
				
			}
		});
		btnListaProcedimentos.setForeground(new Color(255, 192, 203));
		btnListaProcedimentos.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnListaProcedimentos.setBackground(Color.WHITE);
		btnListaProcedimentos.setBounds(507, 374, 249, 111);
		frmGestoDeClnicas.getContentPane().add(btnListaProcedimentos);
		
		JButton btnListaMedicos = new JButton("Lista de Médicos");
		btnListaMedicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaMedico tlm = new TelaListaMedico();
				tlm.frmSistema.setVisible(true);
				frmGestoDeClnicas.dispose();
				
			}
		});
		btnListaMedicos.setForeground(new Color(255, 192, 203));
		btnListaMedicos.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnListaMedicos.setBackground(Color.WHITE);
		btnListaMedicos.setBounds(810, 374, 249, 111);
		frmGestoDeClnicas.getContentPane().add(btnListaMedicos);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(TelaInicialAssistente.class.getResource("/br/com/matheusdebona/sistemaclinicamedica/view/resource/Ícone - Rosa fundo rosa claro.jpg")));
		lblNewLabel_2.setBounds(0, 0, 1264, 681);
		frmGestoDeClnicas.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Usuário");
		lblNewLabel.setBounds(181, 39, 223, 31);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		
	}
}
