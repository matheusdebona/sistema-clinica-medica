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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import br.com.matheusdebona.sistemaclinicamedica.core.entity.ClienteEntity;
import br.com.matheusdebona.sistemaclinicamedica.core.service.ClienteService;
import br.com.matheusdebona.sistemaclinicamedica.util.NegocioException;

public class TelaCadastroCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textEndereco;
	private JTextField textTelefone;
	private JLabel lblCadastroSucesso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroCliente() {
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Gestão de Clínicas - Matheus de Bona");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Cadastro de Cliente");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 45));
		lblNewLabel.setBounds(386, 103, 492, 58);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_1.setBounds(606, 184, 51, 32);
		contentPane.add(lblNewLabel_1);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Verdana", Font.PLAIN, 15));
		textNome.setHorizontalAlignment(SwingConstants.CENTER);
		textNome.setBounds(460, 212, 343, 32);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = textNome.getText();
				String cpf = textCPF.getText();
				String endereco = textEndereco.getText();
				String telefone = textTelefone.getText();
				
				ClienteEntity cliente = new ClienteEntity();

				cliente.setNome(nome);
				cliente.setCpf(cpf);
				cliente.setEndereco(endereco);
				cliente.setTelefone(telefone);
				
				ClienteService cs = new ClienteService();
				
				try {
					cs.salvarCliente(cliente);
					lblCadastroSucesso.setText("Cliente cadastrado com sucesso!");
					limparCampos();
				
				} catch (NegocioException e1) {
					e1.getMensagemDeErro();
				}
				
				
				
				
				
				
			}
		});
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBackground(new Color(255, 204, 204));
		btnCadastrar.setFont(new Font("Verdana", Font.BOLD, 16));
		btnCadastrar.setBounds(549, 508, 165, 32);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Criado por Matheus de Bona");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(507, 622, 249, 26);
		contentPane.add(lblNewLabel_1_1_1);
		
		textCPF = new JTextField();
		textCPF.setHorizontalAlignment(SwingConstants.CENTER);
		textCPF.setFont(new Font("Verdana", Font.PLAIN, 15));
		textCPF.setColumns(10);
		textCPF.setBounds(460, 284, 343, 32);
		contentPane.add(textCPF);
		
		JLabel lblNewLabel_1_1 = new JLabel("CPF");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(615, 256, 34, 32);
		contentPane.add(lblNewLabel_1_1);
		
		textEndereco = new JTextField();
		textEndereco.setHorizontalAlignment(SwingConstants.CENTER);
		textEndereco.setFont(new Font("Verdana", Font.PLAIN, 15));
		textEndereco.setColumns(10);
		textEndereco.setBounds(460, 355, 343, 32);
		contentPane.add(textEndereco);
		
		JLabel lblNewLabel_1_2 = new JLabel("Endereço");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(590, 327, 83, 32);
		contentPane.add(lblNewLabel_1_2);
		
		textTelefone = new JTextField();
		textTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		textTelefone.setFont(new Font("Verdana", Font.PLAIN, 15));
		textTelefone.setColumns(10);
		textTelefone.setBounds(460, 426, 343, 32);
		contentPane.add(textTelefone);
		
		JLabel lblNewLabel_1_3 = new JLabel("Telefone");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(593, 398, 78, 32);
		contentPane.add(lblNewLabel_1_3);
		
		lblCadastroSucesso = new JLabel("");
		lblCadastroSucesso.setForeground(new Color(255, 255, 255));
		lblCadastroSucesso.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCadastroSucesso.setBounds(507, 551, 249, 14);
		contentPane.add(lblCadastroSucesso);
		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaInicialAssistente tia = new TelaInicialAssistente();
				tia.frmGestoDeClnicas.setVisible(true);
				dispose();
				
			}
		});
		btnVoltar.setForeground(Color.PINK);
		btnVoltar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(10, 11, 125, 45);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/br/com/matheusdebona/sistemaclinicamedica/view/resource/Ícone - Rosa fundo rosa claro.jpg")));
		lblNewLabel_2.setBounds(0, 0, 1264, 730);
		contentPane.add(lblNewLabel_2);
	}
	
	public void limparCampos() {
		textNome.setText("");
		textCPF.setText("");
		textEndereco.setText("");
		textTelefone.setText("");
	}
	
	
}
