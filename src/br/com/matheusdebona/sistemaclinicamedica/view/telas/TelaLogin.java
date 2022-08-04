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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import br.com.matheusdebona.sistemaclinicamedica.core.entity.UsuarioEntity;
import br.com.matheusdebona.sistemaclinicamedica.core.service.UsuarioService;
import br.com.matheusdebona.sistemaclinicamedica.util.NegocioException;

public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField textSenha;
	private JTextField textLogin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Gestão de Clínicas - Matheus de Bona");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		JLabel lblNewLabel = new JLabel("Gestão de Clínicas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 45));
		lblNewLabel.setBounds(402, 103, 460, 58);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_1.setBounds(608, 210, 47, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(604, 296, 55, 26);
		contentPane.add(lblNewLabel_1_1);
		
		textSenha = new JPasswordField();
		textSenha.setHorizontalAlignment(SwingConstants.CENTER);
		textSenha.setFont(new Font("Verdana", Font.PLAIN, 15));
		textSenha.setBounds(549, 319, 165, 32);
		contentPane.add(textSenha);
		
		textLogin = new JTextField();
		textLogin.setFont(new Font("Verdana", Font.PLAIN, 15));
		textLogin.setHorizontalAlignment(SwingConstants.CENTER);
		textLogin.setBounds(549, 238, 165, 32);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String login = textLogin.getText();
				String senha = new String(textSenha.getPassword());
				
				UsuarioEntity usuario = new UsuarioEntity();
				
				usuario.setLogin(login);
				usuario.setSenha(senha);
				
				TelaInicialAssistente tia = new TelaInicialAssistente();
				
				UsuarioService us = new UsuarioService();
				try {
					if(us.autenticacaoUsuario(usuario)) {
						tia.frmGestoDeClnicas.setVisible(true);
						tia.frmGestoDeClnicas.setLocationRelativeTo(null);
						dispose();
						
					} else {
						System.out.println("Deu ruim.");
					}
				} catch (NegocioException e1) {
					e1.getMensagemDeErro();
				}
				
				
				
				
				
				
			}
		});
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(255, 204, 204));
		btnEntrar.setFont(new Font("Verdana", Font.BOLD, 16));
		btnEntrar.setBounds(549, 394, 165, 32);
		contentPane.add(btnEntrar);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Criado por Matheus de Bona");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(507, 522, 249, 26);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(TelaLogin.class.getResource("/br/com/matheusdebona/sistemaclinicamedica/view/resource/Ícone - Rosa fundo rosa claro.jpg")));
		lblNewLabel_2.setBounds(0, 0, 1264, 797);
		contentPane.add(lblNewLabel_2);
		
	}
}
