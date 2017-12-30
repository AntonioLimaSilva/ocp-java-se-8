package br.com.luciano.exameocp.jdbc;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Luciano Lima
 *
 */
public class DisplayPessoaResults extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private Pessoa currentEntry;
	private PessoaQueries personQueries;
	private List<Pessoa> results;
	private int numberOfEntries;
	private int currentEntryIndex;
	
	private JButton browseButton;
	private JLabel emailLabel;
	private JTextField emailTextField;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JLabel idLabel;
	private JTextField idTextField;
	private JTextField indexTextField;
	
	private JTextField maxTextField;
	private JButton nextButton;
	private JLabel ofLabel;
	private JButton previousButton;
	private JButton queryButton;
	private JLabel queryLabel;
	private JPanel queryPanel;
	private JPanel navigatePanel;
	private JPanel displayPanel;
	private JTextField queryTextField;
	private JButton insertButton;

	public DisplayPessoaResults() {
		super("Cadastro de pessoa");
		
		this.personQueries = new PessoaQueries();
		
		this.navigatePanel = new JPanel();
		this.previousButton = new JButton();
		this.indexTextField = new JTextField(2);
		this.ofLabel = new JLabel();
		this.maxTextField = new JTextField(2);
		this.nextButton = new JButton();
		this.displayPanel = new JPanel();
		this.idLabel = new JLabel();
		this.idTextField = new JTextField(10);
		this.nameLabel = new JLabel();
		this.nameTextField = new JTextField(10);
		this.emailLabel = new JLabel();
		this.emailTextField = new JTextField();
		this.queryPanel = new JPanel();
		this.queryLabel = new JLabel();
		this.queryTextField = new JTextField(10);
		this.queryButton = new JButton();
		this.browseButton = new JButton();
		this.insertButton = new JButton();
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		setSize(400, 300);
		setResizable(false);
		
		navigatePanel.setLayout(new BoxLayout(navigatePanel, BoxLayout.X_AXIS));
		
		previousButton.setText("Anterior");
		previousButton.setEnabled(false);
		previousButton.addActionListener((evento) -> previousButtonActionPerformad(evento));
		
		navigatePanel.add(previousButton);
		navigatePanel.add(Box.createHorizontalStrut(10));
		
		indexTextField.setHorizontalAlignment(JTextField.CENTER);
		indexTextField.addActionListener((evento) -> indexTextFieldActionPerformad(evento));
		
		navigatePanel.add(indexTextField);
		navigatePanel.add(Box.createHorizontalStrut(10));
		
		ofLabel.setText("de");
		navigatePanel.add(ofLabel);
		navigatePanel.add(Box.createHorizontalStrut(10));
		
		maxTextField.setHorizontalAlignment(JTextField.CENTER);
		maxTextField.setEditable(false);
		navigatePanel.add(maxTextField);
		navigatePanel.add(Box.createHorizontalStrut(10));
		
		nextButton.setText("Próximo");
		nextButton.setEnabled(false);
		nextButton.addActionListener((evento) -> nextButtonActionPerformad(evento));
		
		navigatePanel.add(nextButton);
		add(navigatePanel);
		
		displayPanel.setLayout(new GridLayout(5, 2, 4, 4));
		
		idLabel.setText("ID:");
		displayPanel.add(idLabel);
		
		idTextField.setEditable(false);
		displayPanel.add(idTextField);
		
		nameLabel.setText("Nome:");
		displayPanel.add(nameLabel);
		displayPanel.add(nameTextField);
		
		emailLabel.setText("E-mail:");
		displayPanel.add(emailLabel);
		displayPanel.add(emailTextField);
		add(displayPanel);
		
		queryPanel.setLayout(new BoxLayout(queryPanel, BoxLayout.X_AXIS));
		
		queryPanel.setBorder(BorderFactory.createTitledBorder("Buscar pessoa por nome"));
		queryLabel.setText("Próximo nome");
		queryPanel.add(Box.createHorizontalStrut(5));
		queryPanel.add(queryLabel);
		queryPanel.add(Box.createHorizontalStrut(10));
		queryPanel.add(queryTextField);
		queryPanel.add(Box.createHorizontalStrut(10));
		
		queryButton.setText("Buscar");
		queryButton.addActionListener((evento) -> queryButtonActionPerformad(evento));
		
		queryPanel.add(queryButton);
		queryPanel.add(Box.createHorizontalStrut(5));
		add(queryPanel);
		
		browseButton.setText("Buscar todas as pessoas");
		browseButton.addActionListener((evento) -> browseButtonActionPerformad(evento));		
		add(browseButton);
		
		insertButton.setText("Inserir nova pessoa");
		insertButton.addActionListener((evento) -> insertButtonActionPerformad(evento));	
		add(insertButton);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				personQueries.close();
				System.exit(0);
			}
		});
		
		setVisible(true);		
	}
	
	private void previousButtonActionPerformad(ActionEvent evento) {
		currentEntryIndex--;
		
		if(currentEntryIndex < 0)
			currentEntryIndex = numberOfEntries - 1;
		
		indexTextField.setText("" + (currentEntryIndex + 1));
		indexTextFieldActionPerformad(evento);
	}

	private void nextButtonActionPerformad(ActionEvent evento) {
		currentEntryIndex++;
		
		if(currentEntryIndex >= numberOfEntries)
			currentEntryIndex = 0;
		
		indexTextField.setText("" + (currentEntryIndex + 1));
		indexTextFieldActionPerformad(evento);
	}
	
	private void queryButtonActionPerformad(ActionEvent evento) {
		results = personQueries.getPeapleByName(queryTextField.getText());
		
		numberOfEntries = results.size();
		
		if(numberOfEntries != 0) {
			currentEntryIndex = 0;
			currentEntry = results.get(currentEntryIndex);
			idTextField.setText("" + currentEntry.getId());
			nameTextField.setText(currentEntry.getNome());
			emailTextField.setText(currentEntry.getEmail());
			maxTextField.setText("" + numberOfEntries);
			indexTextField.setText("" + (currentEntryIndex + 1));
			nextButton.setEnabled(true);
			previousButton.setEnabled(true);
		} else {
			browseButtonActionPerformad(evento);
		}
		
	}
	
	private void indexTextFieldActionPerformad(ActionEvent evento) {
		currentEntryIndex = (Integer.parseInt(indexTextField.getText()) - 1);
		
		if(numberOfEntries != 0 && currentEntryIndex < numberOfEntries) {
			currentEntry = results.get(currentEntryIndex);
			idTextField.setText("" + currentEntry.getId());
			nameTextField.setText(currentEntry.getNome());
			emailTextField.setText(currentEntry.getEmail());
			maxTextField.setText("" + numberOfEntries);
			indexTextField.setText("" + (currentEntryIndex + 1));
		}
	}
	
	private void browseButtonActionPerformad(ActionEvent evento) {
		try {
			results = personQueries.getAllPeaple();
			numberOfEntries = results.size();
			
			if(numberOfEntries != 0) {
				currentEntryIndex = 0;
				currentEntry = results.get(currentEntryIndex);
				idTextField.setText("" + currentEntry.getId());
				nameTextField.setText(currentEntry.getNome());
				emailTextField.setText(currentEntry.getEmail());
				maxTextField.setText("" + numberOfEntries);
				indexTextField.setText("" + (currentEntryIndex + 1));
				nextButton.setEnabled(true);
				previousButton.setEnabled(true);
			} 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void insertButtonActionPerformad(ActionEvent evento) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nameTextField.getText());
		pessoa.setEmail(emailTextField.getText());
		
		int result = personQueries.save(pessoa);
		
		if(result == 1) {
			JOptionPane.showMessageDialog(this, this.nameTextField.getText() + " salvo com sucesso!", "Pessoa salva", JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "Pessoa não salva!", "Error", JOptionPane.PLAIN_MESSAGE);
		}
		
		browseButtonActionPerformad(evento);
	}
	
	public static void main(String[] args) {
		new DisplayPessoaResults();
	}
}
