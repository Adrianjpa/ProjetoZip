package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Principal {

	private JFrame janela;
	private JPanel editadoPanel;
	private JButton botaoAbrir;
	private JButton botaoCompactar;
	private JLabel Status, texto1, texto2;
	private JTable tabela;
	private JScrollPane verTabela;

	public static void main(String[] args) {

		Principal principal = new Principal();
		principal.tela();

	}

	private void tela() {

		editadoFrame("ProZip");
		editadoPanel();
		botaoAbrir("PROCURAR");
		botaoCompactar("COMPACTAR");
		imagem();
		verPanel();
		verTabela();
		tabela();
		vertexto();
		Status("Status...");
		verFrame();

	}

	private void imagem() {
		ImageIcon icon = new ImageIcon("simbolo.png");
		JLabel label = new JLabel(icon);
		label.setBounds(10, 10, 100, 100);
		editadoPanel.add(label);

	}

	private void vertexto() {
		texto1 = new JLabel("SELECIONE O ARQUIVO");
		texto1.setFont(new Font("Arial", Font.BOLD, 15));
		texto1.setBounds(250, 40, 390, 30);
		texto2 = new JLabel("CLIQUE PARA COMPACTAR");
		texto2.setFont(new Font("Arial", Font.BOLD, 15));
		texto2.setBounds(250, 105, 390, 30);

		janela.add(texto1);
		janela.add(texto2);
	}

	private void verFrame() {

		janela.setLayout(null);
		janela.setSize(600, 400);
		janela.setVisible(true);

	}

	private void editadoFrame(String titulo) {

		janela = new JFrame(titulo);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLayout(null);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);

	}

	private void botaoAbrir(String titulo) {

		botaoAbrir = new JButton(titulo);
		botaoAbrir.setBounds(460, 30, 110, 50);
		botaoAbrir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				buscaArquivo();
			}

			private void buscaArquivo() {

				JFileChooser jfc = new JFileChooser();

				int retorno = jfc.showOpenDialog(null);
				System.out.printf("Retorno = %d\n", retorno);

				if (retorno == JFileChooser.APPROVE_OPTION) {
					// Colocar o código de compactação do arquivo aqui.
					System.out.printf("Caminho =  %s\n", jfc.getSelectedFile());
				} else {
					// Mostrar uma mensagem informando que o usuário não fez
					// seleção de arquivo/diretório
				}
			}

		});
		janela.add(botaoAbrir);

	}

	public void botaoCompactar(String titulo) {

		botaoCompactar = new JButton(titulo);
		botaoCompactar.setBounds(460, 90, 110, 50);
		janela.add(botaoCompactar);

	}

	private void verPanel() {
		janela.add(editadoPanel);
	}

	private void editadoPanel() {

		editadoPanel = new JPanel();
		editadoPanel.setBounds(20, 20, 150, 130);
		editadoPanel.setBackground(Color.BLACK);

	}

	private void tabela() {

		String[] colunas = { "ID", "DATA", "HORA", };
		Object[][] dados = { { "", "", "", }, { "", "", "", }, { "", "", "", },
				{ "", "", "", }, { "", "", "", }, { "", "", "", },
				{ "", "", "", }, { "", "", "", }, { "", "", "", },
				{ "", "", "", }, { "", "", "", }, { "", "", "", },
				{ "", "", "", }, { "", "", "", }, { "", "", "", }, };
		tabela = new JTable(dados, colunas);
		verTabela.setViewportView(tabela);

	}

	private void verTabela() {
		verTabela = new JScrollPane(tabela);
		verTabela.setBounds(20, 165, 550, 180);

		janela.add(verTabela);
	}

	private void Status(String titulo) {

		Status = new JLabel();
		Status.setBounds(20, 345, 200, 30);
		Status.setForeground(Color.BLUE);

		janela.add(Status);
	}

}
