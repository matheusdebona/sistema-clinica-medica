package br.com.matheusdebona.sistemaclinicamedica.view.telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.com.matheusdebona.sistemaclinicamedica.core.entity.MedicoEntity;
import br.com.matheusdebona.sistemaclinicamedica.core.service.MedicoService;
import br.com.matheusdebona.sistemaclinicamedica.util.NegocioException;

public class TelaListaMedico {

	public JFrame frmSistema;
	private JTable table;
	private List<MedicoEntity> medicos;
	private JTextField textBuscarPorNome;
	private JTextField textId;
	private JButton btnExcluir;
	private JButton btnEditar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaMedico window = new TelaListaMedico();
					window.frmSistema.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListaMedico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistema = new JFrame();
		frmSistema.setTitle("Gestão de Clínicas - Matheus de Bona");
		frmSistema.setBounds(100, 100, 1280, 720);
		frmSistema.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSistema.getContentPane().setLayout(null);
		frmSistema.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		scrollPane.setBounds(54, 175, 1158, 383);
		frmSistema.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(30);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				btnExcluir.setEnabled(true);
				btnEditar.setEnabled(true);
				
				
			}
		});
		table.setForeground(new Color(0, 0, 0));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "CRM", "Email", "Especialidade"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(58);
		table.getColumnModel().getColumn(0).setMinWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(158);
		table.getColumnModel().getColumn(1).setMinWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(132);
		table.getColumnModel().getColumn(2).setMinWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(163);
		table.getColumnModel().getColumn(3).setMinWidth(30);
		table.getColumnModel().getColumn(4).setPreferredWidth(106);
		table.getColumnModel().getColumn(4).setMinWidth(30);
		scrollPane.setViewportView(table);
		
		JLabel lblListaDeClientes = new JLabel("Lista de Médicos");
		lblListaDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeClientes.setForeground(Color.WHITE);
		lblListaDeClientes.setFont(new Font("Verdana", Font.BOLD, 45));
		lblListaDeClientes.setBounds(386, 70, 492, 58);
		frmSistema.getContentPane().add(lblListaDeClientes);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicialAssistente tia = new TelaInicialAssistente();
				tia.frmGestoDeClnicas.setVisible(true);
				frmSistema.dispose();
				
			}
		});
		btnVoltar.setForeground(Color.PINK);
		btnVoltar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(10, 11, 125, 45);
		frmSistema.getContentPane().add(btnVoltar);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MedicoEntity medicoSelecionado = medicos.get(table.getSelectedRow());
				
				TelaEditarMedico tem = new TelaEditarMedico();
			
				tem.carregarMedicoPorId(medicoSelecionado.getCodigo());
				
				tem.setVisible(true);
				
				tem.setLocationRelativeTo(null);
				
				frmSistema.dispose();
		
			}
		});
		btnEditar.setForeground(Color.PINK);
		btnEditar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnEditar.setEnabled(false);
		btnEditar.setBackground(Color.WHITE);
		btnEditar.setBounds(952, 569, 125, 45);
		frmSistema.getContentPane().add(btnEditar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				popularTabela();
				
			}
		});
		btnAtualizar.setForeground(Color.PINK);
		btnAtualizar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnAtualizar.setBackground(Color.WHITE);
		btnAtualizar.setBounds(1087, 569, 125, 45);
		frmSistema.getContentPane().add(btnAtualizar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MedicoEntity medico = medicos.get(table.getSelectedRow());
				
				if(JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o médico " + medico.getNome() + " ?") == JOptionPane.OK_OPTION) {
					try {
						new MedicoService().excluirMedico(medico.getCodigo());
						
						popularTabela();
						
						btnExcluir.setEnabled(false);
						btnEditar.setEnabled(false);
						
					} catch (NegocioException e1) {
						JOptionPane.showMessageDialog(null, e1.getMensagemDeErro());
					}
				} else {
					
					btnExcluir.setEnabled(false);
					btnEditar.setEnabled(false);
					
					popularTabela();
				}
				
				
			}
		});
		btnExcluir.setForeground(Color.PINK);
		btnExcluir.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnExcluir.setEnabled(false);
		btnExcluir.setBackground(Color.WHITE);
		btnExcluir.setBounds(54, 569, 125, 45);
		frmSistema.getContentPane().add(btnExcluir);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Criado por Matheus de Bona");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(507, 644, 249, 26);
		frmSistema.getContentPane().add(lblNewLabel_1_1_1);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MedicoEntity medicoFiltro = new MedicoEntity();
				
				medicoFiltro.setNome(textBuscarPorNome.getText());
				medicoFiltro.setCrm(textBuscarPorNome.getText());
				medicoFiltro.setEmail(textBuscarPorNome.getText());
				medicoFiltro.setEspecialidade(textBuscarPorNome.getText());
				
				try {
					if(!textId.getText().equals("")) {
						Long codigo = Long.parseLong(textId.getText());
						medicoFiltro.setCodigo(codigo);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro");
				}
				popularTabelaFiltrada(medicoFiltro);
				
				
			}
		});
		btnBuscar.setForeground(Color.PINK);
		btnBuscar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnBuscar.setEnabled(false);
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setBounds(817, 569, 125, 45);
		frmSistema.getContentPane().add(btnBuscar);
		
		JLabel lblNomeOuCrm = new JLabel("NOME ou CRM ou EMAIL ou ESPECIALIDADE");
		lblNomeOuCrm.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeOuCrm.setForeground(Color.PINK);
		lblNomeOuCrm.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNomeOuCrm.setEnabled(false);
		lblNomeOuCrm.setBounds(395, 569, 412, 45);
		frmSistema.getContentPane().add(lblNomeOuCrm);
		
		textBuscarPorNome = new JTextField();
		textBuscarPorNome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				lblNomeOuCrm.setVisible(false);
				btnBuscar.setEnabled(true);
			}
		});
		textBuscarPorNome.setHorizontalAlignment(SwingConstants.CENTER);
		textBuscarPorNome.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textBuscarPorNome.setColumns(10);
		textBuscarPorNome.setBounds(395, 569, 412, 45);
		frmSistema.getContentPane().add(textBuscarPorNome);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(Color.PINK);
		lblId.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblId.setEnabled(false);
		lblId.setBounds(310, 569, 75, 45);
		frmSistema.getContentPane().add(lblId);
		
		textId = new JTextField();
		textId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				lblId.setVisible(false);
				btnBuscar.setEnabled(true);

			}
		});
		textId.setHorizontalAlignment(SwingConstants.CENTER);
		textId.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textId.setColumns(10);
		textId.setBounds(310, 569, 75, 45);
		frmSistema.getContentPane().add(textId);
		
		JLabel lblBuscar = new JLabel("Buscar por: ");
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.PINK);
		lblBuscar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblBuscar.setBounds(199, 569, 111, 45);
		frmSistema.getContentPane().add(lblBuscar);
		
		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(TelaListaMedico.class.getResource("/br/com/matheusdebona/sistemaclinicamedica/view/resource/Ícone - Rosa fundo rosa claro.jpg")));
		lblFundo.setBounds(0, 0, 1264, 681);
		frmSistema.getContentPane().add(lblFundo);
		
		
		
		popularTabela();
	}
	
	private void popularTabela() {
		try {
			medicos = new MedicoService().listarMedico();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.getDataVector().removeAllElements();
			
			for (MedicoEntity medicoEntity : medicos) {
				model.addRow(new Object[] { medicoEntity.getCodigo(), medicoEntity.getNome(), medicoEntity.getCrm(), medicoEntity.getEmail(), medicoEntity.getEspecialidade()});
				
			}
		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar médicos do banco de dados" + e.getMensagemDeErro());
			e.printStackTrace();
		}
				
	}
	
	private void popularTabelaFiltrada(MedicoEntity medicoFiltro) {
		try {
							
			medicos = new MedicoService().buscarMedicoFiltrado(medicoFiltro);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.getDataVector().removeAllElements();
			
			for (MedicoEntity medicoEntity : medicos) {
				model.addRow(new Object[] { medicoEntity.getCodigo(), medicoEntity.getNome(), medicoEntity.getCrm(), medicoEntity.getEmail(), medicoEntity.getEspecialidade()});
				
				}
			
		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar Médicos do banco de dados" + e.getMensagemDeErro());
			e.printStackTrace();
		}
		
	}
	
}

