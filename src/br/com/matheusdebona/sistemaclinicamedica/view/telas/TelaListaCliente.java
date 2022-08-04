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
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.com.matheusdebona.sistemaclinicamedica.core.entity.ClienteEntity;
import br.com.matheusdebona.sistemaclinicamedica.core.service.ClienteService;
import br.com.matheusdebona.sistemaclinicamedica.util.NegocioException;

public class TelaListaCliente {

	public JFrame frmSistema;
	private JTable table;
	private List<ClienteEntity> clientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaCliente window = new TelaListaCliente();
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
	public TelaListaCliente() {
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
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClienteEntity clienteSelecionado = clientes.get(table.getSelectedRow());
				
				TelaEditarCliente tec = new TelaEditarCliente();
			
				tec.carregarClientePorId(clienteSelecionado.getCodigo());
				
				tec.setVisible(true);
				
				tec.setLocationRelativeTo(null);
				
				frmSistema.dispose();
				
				
			}
		});
		btnEditar.setBackground(Color.WHITE);
		btnEditar.setForeground(Color.PINK);
		btnEditar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnEditar.setEnabled(false);
		btnEditar.setBounds(834, 569, 174, 45);
		frmSistema.getContentPane().add(btnEditar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				popularTabela();
			}
		});
		btnAtualizar.setBackground(Color.WHITE);
		btnAtualizar.setForeground(Color.PINK);
		btnAtualizar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnAtualizar.setBounds(1038, 569, 174, 45);
		frmSistema.getContentPane().add(btnAtualizar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setForeground(Color.PINK);
		btnExcluir.setBackground(Color.WHITE);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteEntity cliente = clientes.get(table.getSelectedRow());
				
				if(JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o cliente " + cliente.getNome() + " ?") == JOptionPane.OK_OPTION) {
					try {
						new ClienteService().excluirCliente(cliente.getCodigo());
						
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
		btnExcluir.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(54, 569, 174, 45);
		frmSistema.getContentPane().add(btnExcluir);
		
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
				"C\u00F3digo", "Nome", "CPF", "Endere\u00E7o", "Telefone"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
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
		
		JLabel lblListaDeClientes = new JLabel("Lista de Clientes");
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
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Criado por Matheus de Bona");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(507, 644, 249, 26);
		frmSistema.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaListaCliente.class.getResource("/br/com/matheusdebona/sistemaclinicamedica/view/resource/Ícone - Rosa fundo rosa claro.jpg")));
		lblNewLabel.setBounds(0, 0, 1264, 681);
		frmSistema.getContentPane().add(lblNewLabel);
		
		
		
		
		popularTabela();
	}
	
	private void popularTabela() {
		try {
			clientes = new ClienteService().listarCliente();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.getDataVector().removeAllElements();
			
			for (ClienteEntity clienteEntity : clientes) {
				model.addRow(new Object[] { clienteEntity.getCodigo(), clienteEntity.getNome(), clienteEntity.getCpf(), clienteEntity.getEndereco(), clienteEntity.getTelefone()});
				
			}
		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar clientes do banco de dados" + e.getMensagemDeErro());
			e.printStackTrace();
		}
				
	}
	
}
