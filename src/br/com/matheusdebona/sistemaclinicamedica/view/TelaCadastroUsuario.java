package br.com.matheusdebona.sistemaclinicamedica.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.matheusdebona.sistemaclinicamedica.core.entity.UsuarioEntity;
import br.com.matheusdebona.sistemaclinicamedica.core.service.UsuarioService;
import br.com.matheusdebona.sistemaclinicamedica.util.NegocioException;

public class TelaCadastroUsuario {

	private JFrame frame;
	private JTextField textNome;
	private JTextField textLogin;
	private JTextField textEmail;
	private JTextField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroUsuario window = new TelaCadastroUsuario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Usuário");
		lblNewLabel.setBounds(181, 39, 223, 31);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(58, 118, 59, 25);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textNome = new JTextField();
		textNome.setBounds(121, 115, 381, 31);
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textNome.setColumns(10);
		
		JLabel lblErroNome = new JLabel("");
		lblErroNome.setBounds(302, 146, 200, 14);
		lblErroNome.setForeground(Color.RED);
		lblErroNome.setFont(new Font("Tahoma", Font.ITALIC, 11));
		
		JLabel lblNewLabel_1_1 = new JLabel("Login:");
		lblNewLabel_1_1.setBounds(58, 175, 59, 25);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textLogin = new JTextField();
		textLogin.setBounds(121, 172, 381, 31);
		textLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textLogin.setColumns(10);
		
		JLabel lblErroLogin = new JLabel("");
		lblErroLogin.setBounds(302, 203, 200, 14);
		lblErroLogin.setForeground(Color.RED);
		lblErroLogin.setFont(new Font("Tahoma", Font.ITALIC, 11));
		
		JLabel lblNewLabel_1_2 = new JLabel("Email:");
		lblNewLabel_1_2.setBounds(58, 232, 59, 25);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textEmail = new JTextField();
		textEmail.setBounds(121, 229, 381, 31);
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textEmail.setColumns(10);
		
		JLabel lblErroEmail = new JLabel("");
		lblErroEmail.setBounds(302, 262, 200, 14);
		lblErroEmail.setForeground(Color.RED);
		lblErroEmail.setFont(new Font("Tahoma", Font.ITALIC, 11));
		
		JLabel lblNewLabel_1_3 = new JLabel("Senha:");
		lblNewLabel_1_3.setBounds(58, 290, 62, 25);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textSenha = new JTextField();
		textSenha.setBounds(121, 287, 381, 31);
		textSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textSenha.setColumns(10);
		
		JLabel lblErroSenha = new JLabel("");
		lblErroSenha.setBounds(302, 318, 200, 14);
		lblErroSenha.setForeground(Color.RED);
		lblErroSenha.setFont(new Font("Tahoma", Font.ITALIC, 11));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblNewLabel_1_3);
		frame.getContentPane().add(textSenha);
		frame.getContentPane().add(lblErroSenha);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(lblErroNome);
		frame.getContentPane().add(lblNewLabel_1);
		frame.getContentPane().add(textNome);
		frame.getContentPane().add(lblNewLabel_1_1);
		frame.getContentPane().add(textLogin);
		frame.getContentPane().add(lblErroLogin);
		frame.getContentPane().add(lblNewLabel_1_2);
		frame.getContentPane().add(textEmail);
		frame.getContentPane().add(lblErroEmail);
		
		JLabel lblSucesso = new JLabel("");
		lblSucesso.setForeground(Color.BLUE);
		lblSucesso.setBackground(Color.WHITE);
		lblSucesso.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblSucesso.setBounds(157, 349, 270, 14);
		frame.getContentPane().add(lblSucesso);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = textNome.getText();
				String login = textLogin.getText();
				String email = textEmail.getText();
				String senha = textSenha.getText();
			
				
				UsuarioEntity usuario = new UsuarioEntity();
				
				usuario.setNome(nome);
				if(nome != null && nome.equals("")) {
					lblErroNome.setText("Campo nome precisa ser preenchido.");
				}
				usuario.setLogin(login);
				if(login != null && login.equals("")) {
					lblErroLogin.setText("Campo login precisa ser preenchido.");
				}
				usuario.setEmail(email);
				if(email != null && email.equals("")) {
					lblErroEmail.setText("Campo email precisa ser preenchido.");
				}
				usuario.setSenha(senha);
				if(senha != null && senha.equals("")) {
					lblErroSenha.setText("Campo senha precisa ser preenchido.");
				}
				
				UsuarioService us = new UsuarioService();
				
				try {
					us.salvarUsuario(usuario);
					lblSucesso.setText("Usuário cadastrado com sucesso");
				} catch (NegocioException e1) {
					e1.getMensagemDeErro();
				}
				
				
				textNome.setText("");
				textLogin.setText("");
				textEmail.setText("");
				textSenha.setText("");
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(180, 375, 223, 65);
		frame.getContentPane().add(btnNewButton);
		

	}
}
