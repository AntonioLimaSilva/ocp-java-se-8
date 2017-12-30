package br.com.luciano.exameocp.jdbc;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * 
 * @author Luciano Lima
 *
 */
public class DisplayQueryResults extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final String URL = "jdbc:sqlserver://localhost;databaseName=crud";
	private static final String USERNAME = "user";
	private static final String PASSWORD = "*****";
	private static final String DEFAULT_QUERY = "SELECT * FROM pessoa";

	private ResultSetTableModel tableModel;
	private JTextArea queryArea;

	public DisplayQueryResults() {
		super("Displaying Query Results");

		try {
			this.tableModel = new ResultSetTableModel(URL, USERNAME, PASSWORD, DEFAULT_QUERY);

			this.queryArea = new JTextArea(DEFAULT_QUERY, 3, 100);
			this.queryArea.setWrapStyleWord(true);
			this.queryArea.setLineWrap(true);

			JScrollPane scrollPane = new JScrollPane(this.queryArea, 
					ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

			JButton submitBtn = new JButton("Submit Query");

			Box boxNorth = Box.createHorizontalBox();
			boxNorth.add(scrollPane);
			boxNorth.add(submitBtn);

			JTable resultTable = new JTable(tableModel);

			JLabel filterLabel = new JLabel("Filter:");
			final JTextField filterText = new JTextField();
			JButton filterBtn = new JButton("Apply filter");
			Box boxSouth = Box.createHorizontalBox();

			boxSouth.add(filterLabel);
			boxSouth.add(filterText);
			boxSouth.add(filterBtn);

			add(boxNorth, BorderLayout.NORTH);
			add(new JScrollPane(resultTable));
			add(boxSouth, BorderLayout.SOUTH);

			submitBtn.addActionListener((evento) -> {
				try {
					this.tableModel.setQuery(this.queryArea.getText());
				} catch (SQLException ex1) {
					JOptionPane.showMessageDialog(null, ex1.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
					try {
						this.tableModel.setQuery(DEFAULT_QUERY);
						this.queryArea.setText(DEFAULT_QUERY);
					} catch (SQLException ex2) {
						JOptionPane.showMessageDialog(null, ex2.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
						this.tableModel.desconnectFromDatabase();
						System.exit(1);
					}
				}
			});

			final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(this.tableModel);
			resultTable.setRowSorter(sorter);

			setSize(500, 250);
			setVisible(true);

			filterBtn.addActionListener((evento) -> {
				String text = filterText.getText();
				if(text.length() == 0)
					sorter.setRowFilter(null);
				else {
					try {
						sorter.setRowFilter(RowFilter.regexFilter(text));
					}catch(PatternSyntaxException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);			
			this.tableModel.desconnectFromDatabase();			
			System.exit(1);
		}
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				tableModel.desconnectFromDatabase();
				System.exit(1);
			}
		});
	}

	public static void main(String[] args) {
		new DisplayQueryResults();
	}

}