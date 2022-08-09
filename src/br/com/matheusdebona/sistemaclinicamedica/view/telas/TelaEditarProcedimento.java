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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import br.com.matheusdebona.sistemaclinicamedica.core.entity.ProcedimentoEntity;
import br.com.matheusdebona.sistemaclinicamedica.core.service.ProcedimentoService;
import br.com.matheusdebona.sistemaclinicamedica.util.NegocioException;

public class TelaEditarProcedimento extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textValor;
	private JLabel lblCadastroSucesso;
	private JTextField textCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEditarProcedimento frame = new TelaEditarProcedimento();
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
	public TelaEditarProcedimento() {
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
		
		
		JLabel lblNewLabel = new JLabel("Atualizar Procedimento");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 45));
		lblNewLabel.setBounds(327, 103, 609, 58);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_1.setBounds(606, 292, 51, 32);
		contentPane.add(lblNewLabel_1);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Verdana", Font.PLAIN, 15));
		textNome.setHorizontalAlignment(SwingConstants.CENTER);
		textNome.setBounds(460, 320, 343, 32);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProcedimentoEntity procedimento = new ProcedimentoEntity();

				procedimento.setCodigo(procedimento.getCodigo());
				procedimento.setNome(textNome.getText());
				procedimento.setValor(Double.parseDouble(textValor.getText()));
				
				ProcedimentoService ps = new ProcedimentoService();
				
				try {
					procedimento.setCodigo(Long.parseLong(textCodigo.getText()));
					ps.editarProcedimento(procedimento);
					dispose();
					
					TelaListaProcedimento tlp = new TelaListaProcedimento();
					tlp.frmSistema.setVisible(true);
					tlp.frmSistema.setLocationRelativeTo(null);
				
				} catch (NegocioException e1) {
					e1.getMensagemDeErro();
				}
				
				
			}
		});
		btnAtualizar.setForeground(new Color(255, 255, 255));
		btnAtualizar.setBackground(new Color(255, 204, 204));
		btnAtualizar.setFont(new Font("Verdana", Font.BOLD, 16));
		btnAtualizar.setBounds(549, 477, 165, 32);
		contentPane.add(btnAtualizar);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Criado por Matheus de Bona");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(507, 622, 249, 26);
		contentPane.add(lblNewLabel_1_1_1);
		
		textValor = new JTextField();
		textValor.setHorizontalAlignment(SwingConstants.CENTER);
		textValor.setFont(new Font("Verdana", Font.PLAIN, 15));
		textValor.setColumns(10);
		textValor.setBounds(460, 392, 343, 32);
		contentPane.add(textValor);
		
		JLabel lblNewLabel_1_1 = new JLabel("Valor");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(569, 364, 125, 32);
		contentPane.add(lblNewLabel_1_1);
		
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
		
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Código");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1.setForeground(Color.WHITE);
		lblNewLabel_1_3_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_1_3_1.setBounds(593, 221, 78, 32);
		contentPane.add(lblNewLabel_1_3_1);
		
		textCodigo = new JTextField();
		textCodigo.setEditable(false);
		textCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		textCodigo.setFont(new Font("Verdana", Font.PLAIN, 15));
		textCodigo.setColumns(10);
		textCodigo.setBounds(460, 249, 343, 32);
		contentPane.add(textCodigo);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/br/com/matheusdebona/sistemaclinicamedica/view/resource/Ícone - Rosa fundo rosa claro.jpg")));
		lblNewLabel_2.setBounds(0, 0, 1264, 730);
		contentPane.add(lblNewLabel_2);
	}
	
	public void limparCampos() {
		textNome.setText("");
		textValor.setText("");
	}
	
	public void carregarProcedimentoPorId(Long codigoProcedimento) {
		try {
			ProcedimentoEntity procedimentoEncontrado = new ProcedimentoService().buscarProcedimentoPorId(codigoProcedimento);
			if(procedimentoEncontrado == null) {
				JOptionPane.showMessageDialog(null, "O cliente não foi encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				
				textCodigo.setText("" + procedimentoEncontrado.getCodigo());
				textNome.setText(procedimentoEncontrado.getNome());
				textValor.setText(procedimentoEncontrado.getValor().toString());
				
			}
			
		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, e.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
