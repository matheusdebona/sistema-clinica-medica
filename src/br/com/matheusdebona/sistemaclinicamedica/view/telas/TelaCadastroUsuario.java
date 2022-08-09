package br.com.matheusdebona.sistemaclinicamedica.view.telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.com.matheusdebona.sistemaclinicamedica.core.entity.UsuarioEntity;
import br.com.matheusdebona.sistemaclinicamedica.core.service.UsuarioService;
import br.com.matheusdebona.sistemaclinicamedica.util.NegocioException;
import javax.swing.ImageIcon;

public class TelaCadastroUsuario {

	public JFrame frmGestoDeClnicas;
	private JTextField textNome;
	private JTextField textLogin;
	private JTextField textEmail;
	private JTextField textSenha;
	private JTable table;
	private JTextField textIdBusca;
	private JTextField textNomeLogin;
	private List<UsuarioEntity> usuarios;
	private JTextField textId2;
	private JButton btnLimpar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroUsuario window = new TelaCadastroUsuario();
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
	public TelaCadastroUsuario() {
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
		frmGestoDeClnicas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestoDeClnicas.setLocationRelativeTo(null);
		
		JLabel lblTitle = new JLabel("Central do Usuário");
		lblTitle.setForeground(SystemColor.textHighlight);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(361, 39, 541, 68);
		lblTitle.setFont(new Font("Verdana", Font.PLAIN, 45));
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setBounds(87, 228, 59, 25);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		textNome = new JTextField();
		textNome.setForeground(SystemColor.textHighlight);
		textNome.setBackground(SystemColor.text);
		textNome.setBounds(156, 225, 326, 31);
		textNome.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textNome.setColumns(10);
		
		JLabel lblErroNome = new JLabel("");
		lblErroNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErroNome.setBounds(166, 257, 316, 14);
		lblErroNome.setForeground(Color.RED);
		lblErroNome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblNewLabel_1_1 = new JLabel("Login:");
		lblNewLabel_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1.setBounds(87, 282, 59, 28);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		textLogin = new JTextField();
		textLogin.setForeground(SystemColor.textHighlight);
		textLogin.setBackground(SystemColor.text);
		textLogin.setBounds(156, 282, 326, 31);
		textLogin.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textLogin.setColumns(10);
		
		JLabel lblErroLogin = new JLabel("");
		lblErroLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErroLogin.setBounds(224, 313, 258, 14);
		lblErroLogin.setForeground(Color.RED);
		lblErroLogin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblNewLabel_1_2 = new JLabel("Email:");
		lblNewLabel_1_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_2.setBounds(87, 348, 59, 25);
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		textEmail = new JTextField();
		textEmail.setForeground(SystemColor.textHighlight);
		textEmail.setBackground(SystemColor.text);
		textEmail.setBounds(156, 346, 326, 31);
		textEmail.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textEmail.setColumns(10);
		
		JLabel lblErroEmail = new JLabel("");
		lblErroEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErroEmail.setBounds(224, 377, 258, 14);
		lblErroEmail.setForeground(Color.RED);
		lblErroEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblNewLabel_1_3 = new JLabel("Senha:");
		lblNewLabel_1_3.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_3.setBounds(87, 404, 62, 25);
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		textSenha = new JTextField();
		textSenha.setForeground(SystemColor.textHighlight);
		textSenha.setBackground(SystemColor.text);
		textSenha.setBounds(156, 402, 326, 31);
		textSenha.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textSenha.setColumns(10);
		
		JLabel lblErroSenha = new JLabel("");
		lblErroSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErroSenha.setBounds(224, 433, 258, 14);
		lblErroSenha.setForeground(Color.RED);
		lblErroSenha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		frmGestoDeClnicas.getContentPane().setLayout(null);
		frmGestoDeClnicas.getContentPane().add(lblNewLabel_1_3);
		frmGestoDeClnicas.getContentPane().add(textSenha);
		frmGestoDeClnicas.getContentPane().add(lblErroSenha);
		frmGestoDeClnicas.getContentPane().add(lblTitle);
		frmGestoDeClnicas.getContentPane().add(lblErroNome);
		frmGestoDeClnicas.getContentPane().add(lblNewLabel_1);
		frmGestoDeClnicas.getContentPane().add(textNome);
		frmGestoDeClnicas.getContentPane().add(lblNewLabel_1_1);
		frmGestoDeClnicas.getContentPane().add(textLogin);
		frmGestoDeClnicas.getContentPane().add(lblErroLogin);
		frmGestoDeClnicas.getContentPane().add(lblNewLabel_1_2);
		frmGestoDeClnicas.getContentPane().add(textEmail);
		frmGestoDeClnicas.getContentPane().add(lblErroEmail);
		
		JLabel lblSucesso = new JLabel("");
		lblSucesso.setHorizontalAlignment(SwingConstants.CENTER);
		lblSucesso.setForeground(Color.WHITE);
		lblSucesso.setBackground(Color.WHITE);
		lblSucesso.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblSucesso.setBounds(87, 444, 395, 31);
		frmGestoDeClnicas.getContentPane().add(lblSucesso);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(SystemColor.text);
		btnCadastrar.setForeground(SystemColor.textHighlight);
		btnCadastrar.addActionListener(new ActionListener() {
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
				
				popularTabela();
				
			}
		});
		btnCadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnCadastrar.setBounds(358, 484, 125, 48);
		frmGestoDeClnicas.getContentPane().add(btnCadastrar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UsuarioEntity usuario = usuarios.get(table.getSelectedRow());
				
				if(JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o usuário " + usuario.getNome() + " ?") == JOptionPane.OK_OPTION) {
					try {
						new UsuarioService().excluirUsuario(usuario.getCodigo());
						
						popularTabela();
						
						limparCampos();
						
						btnDeletar.setEnabled(false);
						
					} catch (NegocioException e1) {
						JOptionPane.showMessageDialog(null, e1.getMensagemDeErro());
					}
				} else {
					
					btnDeletar.setEnabled(false);
					
					popularTabela();
				}
				
			}
		});
		btnDeletar.setEnabled(false);
		btnDeletar.setBackground(SystemColor.text);
		btnDeletar.setForeground(SystemColor.textHighlight);
		btnDeletar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnDeletar.setBounds(224, 484, 125, 48);
		frmGestoDeClnicas.getContentPane().add(btnDeletar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UsuarioEntity usuario = new UsuarioEntity();

				usuario.setCodigo(usuario.getCodigo());
				usuario.setNome(textNome.getText());
				usuario.setLogin(textLogin.getText());
				usuario.setEmail(textEmail.getText());
				usuario.setSenha(textSenha.getText());
				
				UsuarioService us = new UsuarioService();
				
				try {
					
					usuario.setCodigo(Long.parseLong(textId2.getText()));
					
					us.editarUsuario(usuario);
					
					limparCampos();
					
					popularTabela();
					
				} catch (NegocioException e1) {
					e1.getMensagemDeErro();
				}
				
			}
		});
		btnEditar.setBackground(SystemColor.text);
		btnEditar.setForeground(SystemColor.textHighlight);
		btnEditar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnEditar.setBounds(87, 484, 125, 48);
		frmGestoDeClnicas.getContentPane().add(btnEditar);
		
		JScrollPane scrollLista = new JScrollPane();
		scrollLista.setForeground(SystemColor.controlText);
		scrollLista.setBackground(new Color(255, 255, 255));
		scrollLista.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollLista.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		scrollLista.setBorder(new LineBorder(SystemColor.activeCaption));
		scrollLista.setBounds(547, 118, 672, 405);
		frmGestoDeClnicas.getContentPane().add(scrollLista);
		
		table = new JTable();
		table.setForeground(SystemColor.menuText);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				UsuarioEntity usuarioSelecionado = usuarios.get(table.getSelectedRow());
				
				carregarUsuarioPorId(usuarioSelecionado.getCodigo());
				
				btnCadastrar.setVisible(false);
				btnLimpar.setVisible(true);
				btnEditar.setEnabled(true);
				btnDeletar.setEnabled(true);
				
				
			}
		});
		table.setRowHeight(25);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOME", "LOGIN", "EMAIL", "SENHA"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(0).setMinWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(175);
		table.getColumnModel().getColumn(1).setMinWidth(25);
		table.getColumnModel().getColumn(2).setPreferredWidth(125);
		table.getColumnModel().getColumn(2).setMinWidth(25);
		table.getColumnModel().getColumn(3).setPreferredWidth(250);
		table.getColumnModel().getColumn(3).setMinWidth(25);
		table.getColumnModel().getColumn(4).setPreferredWidth(125);
		table.getColumnModel().getColumn(4).setMinWidth(25);
		
		JLabel lblIdBusca = new JLabel("ID");
		lblIdBusca.setEnabled(false);
		lblIdBusca.setForeground(SystemColor.textHighlight);
		lblIdBusca.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdBusca.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblIdBusca.setBounds(557, 551, 62, 31);
		frmGestoDeClnicas.getContentPane().add(lblIdBusca);
		
		JLabel lblNomeOuLogin = new JLabel("NOME ou LOGIN ou EMAIL ou SENHA");
		lblNomeOuLogin.setEnabled(false);
		lblNomeOuLogin.setForeground(SystemColor.textHighlight);
		lblNomeOuLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeOuLogin.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNomeOuLogin.setBounds(629, 551, 442, 31);
		frmGestoDeClnicas.getContentPane().add(lblNomeOuLogin);
		scrollLista.setViewportView(table);
		
		textIdBusca = new JTextField();
		textIdBusca.setHorizontalAlignment(SwingConstants.CENTER);
		textIdBusca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				lblIdBusca.setVisible(false);
				
			}
		});
		textIdBusca.setForeground(SystemColor.textHighlight);
		textIdBusca.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textIdBusca.setColumns(10);
		textIdBusca.setBackground(Color.WHITE);
		textIdBusca.setBounds(557, 551, 62, 31);
		frmGestoDeClnicas.getContentPane().add(textIdBusca);
		
		textNomeLogin = new JTextField();
		textNomeLogin.setHorizontalAlignment(SwingConstants.CENTER);
		textNomeLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				lblNomeOuLogin.setVisible(false);
			}
		});
		textNomeLogin.setForeground(SystemColor.textHighlight);
		textNomeLogin.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textNomeLogin.setColumns(10);
		textNomeLogin.setBackground(Color.WHITE);
		textNomeLogin.setBounds(627, 551, 444, 31);
		frmGestoDeClnicas.getContentPane().add(textNomeLogin);
		
		textId2 = new JTextField();
		textId2.setEnabled(false);
		textId2.setEditable(false);
		textId2.setForeground(SystemColor.textHighlight);
		textId2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textId2.setColumns(10);
		textId2.setBackground(Color.WHITE);
		textId2.setBounds(156, 172, 326, 31);
		frmGestoDeClnicas.getContentPane().add(textId2);
		
		JLabel lblNewLabel_1_4 = new JLabel("ID:");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_4.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(87, 175, 59, 25);
		frmGestoDeClnicas.getContentPane().add(lblNewLabel_1_4);
		
		popularTabela();
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				UsuarioEntity usuarioFiltro = new UsuarioEntity();
				
				usuarioFiltro.setNome(textNomeLogin.getText());
				usuarioFiltro.setLogin(textNomeLogin.getText());
				usuarioFiltro.setEmail(textNomeLogin.getText());
				usuarioFiltro.setSenha(textNomeLogin.getText());
				
				try {
					if(!textIdBusca.getText().equals("")) {
						Long codigo = Long.parseLong(textIdBusca.getText());
						usuarioFiltro.setCodigo(codigo);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro");
				}
				popularTabelaFiltrada(usuarioFiltro);
				
			}
		});
		btnBuscar.setForeground(SystemColor.textHighlight);
		btnBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setBounds(1081, 551, 125, 31);
		frmGestoDeClnicas.getContentPane().add(btnBuscar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				limparCampos();
				
				popularTabela();
				
				btnLimpar.setVisible(false);
				
				btnCadastrar.setVisible(true);
				
			}
		});
		btnLimpar.setEnabled(true);
		btnLimpar.setVisible(false);
		btnLimpar.setForeground(SystemColor.textHighlight);
		btnLimpar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnLimpar.setBackground(Color.WHITE);
		btnLimpar.setBounds(361, 486, 121, 46);
		frmGestoDeClnicas.getContentPane().add(btnLimpar);
		
		JPanel painelCadastro = new JPanel();
		painelCadastro.setBackground(SystemColor.menu);
		painelCadastro.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		painelCadastro.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Cadastro de Usu\u00E1rio", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 120, 215)));
		painelCadastro.setBounds(35, 118, 502, 479);
		frmGestoDeClnicas.getContentPane().add(painelCadastro);
		
		JPanel painelBusca = new JPanel();
		painelBusca.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		painelBusca.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Filtro de Busca", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 120, 215)));
		painelBusca.setBackground(SystemColor.menu);
		painelBusca.setBounds(547, 534, 672, 63);
		frmGestoDeClnicas.getContentPane().add(painelBusca);
		
		JLabel lblCriadoPorMatheus = new JLabel("Criado por Matheus de Bona");
		lblCriadoPorMatheus.setHorizontalAlignment(SwingConstants.CENTER);
		lblCriadoPorMatheus.setForeground(SystemColor.textHighlight);
		lblCriadoPorMatheus.setFont(new Font("Verdana", Font.PLAIN, 24));
		lblCriadoPorMatheus.setBounds(361, 602, 541, 68);
		frmGestoDeClnicas.getContentPane().add(lblCriadoPorMatheus);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin tl = new TelaLogin();
				tl.setVisible(true);
				tl.setLocationRelativeTo(null);
				frmGestoDeClnicas.dispose();
				
			}
		});
		
		btnVoltar.setForeground(SystemColor.textHighlight);
		btnVoltar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(35, 58, 125, 48);
		frmGestoDeClnicas.getContentPane().add(btnVoltar);
		
		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(TelaCadastroUsuario.class.getResource("/br/com/matheusdebona/sistemaclinicamedica/view/resource/ícone - Azul fundo branco.jpg")));
		lblFundo.setBounds(0, 0, 1264, 681);
		frmGestoDeClnicas.getContentPane().add(lblFundo);
		
	}
	
	private void popularTabela() {
		try {
			usuarios = new UsuarioService().listarUsuario();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.getDataVector().removeAllElements();
			
			for (UsuarioEntity usuarioEntity : usuarios) {
				model.addRow(new Object[] { usuarioEntity.getCodigo(), usuarioEntity.getNome(), usuarioEntity.getLogin(), usuarioEntity.getEmail(), usuarioEntity.getSenha()});
				
			}
		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar usuários do banco de dados" + e.getMensagemDeErro());
			e.printStackTrace();
		}
				
	}
	
	private void popularTabelaFiltrada(UsuarioEntity usuarioFiltro) {
		try {
							
			usuarios = new UsuarioService().buscarUsuarioFiltrado(usuarioFiltro);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.getDataVector().removeAllElements();
			
			for (UsuarioEntity usuarioEntity : usuarios) {
				model.addRow(new Object[] { usuarioEntity.getCodigo(), usuarioEntity.getNome(), usuarioEntity.getLogin(), usuarioEntity.getEmail(), usuarioEntity.getSenha()});
				
				}
			
		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar usuários do banco de dados" + e.getMensagemDeErro());
			e.printStackTrace();
		}
		
	}
	
	public void carregarUsuarioPorId(Long codigoUsuario) {
		try {
			UsuarioEntity usuarioEncontrado = new UsuarioService().buscarUsuarioPorId(codigoUsuario);
			if(usuarioEncontrado == null) {
				JOptionPane.showMessageDialog(null, "O usuário não foi encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				
				textId2.setText("" + usuarioEncontrado.getCodigo());
				textNome.setText(usuarioEncontrado.getNome());
				textLogin.setText(usuarioEncontrado.getLogin());
				textEmail.setText(usuarioEncontrado.getEmail());
				textSenha.setText(usuarioEncontrado.getSenha());
				
			}
			
		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, e.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void limparCampos() {
		
		textId2.setText("");
		textNome.setText("");
		textLogin.setText("");
		textEmail.setText("");
		textSenha.setText("");
	}
}
