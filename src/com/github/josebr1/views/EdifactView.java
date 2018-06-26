package com.github.josebr1.views;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import com.github.josebr1.controllers.EdifactController;

public class EdifactView {

	/*public static void main(String[] args) throws FileNotFoundException, IOException, SAXException {
		// TODO Auto-generated method stub

		
	}*/
	
	private JButton btnConvert;
	private JButton btnSearch;
	private TitledBorder titleBorderLogs;
	private JPanel logContainer;
	private Icon iconBtnConvert;
	private Icon iconBtnSearch;
	private FileDialog fileDialog;
	private String pathFileEdi;
	private JTextArea txtLogs;
	
	public EdifactView() {
		pathFileEdi = "";
	}
	
	public void execute() {
		
		JFrame view = new JFrame("Convert Edifact to xml");
		view.setSize(250, 150);
		
		JPanel container = new JPanel();
		container.setLayout(null);
		
		iconBtnConvert = new ImageIcon(getClass().getResource("/com/github/josebr1/resources/icon_run.png"));
		btnConvert = new JButton("Convert");
		btnConvert.setBounds(0, 0, 125, 50);
		btnConvert.setIcon(iconBtnConvert);
		btnConvert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (pathFileEdi.equals("")) {
					JOptionPane.showMessageDialog(null, "Not file");
					return;
				}
				
				EdifactController controller = new EdifactController();
				String result = controller.toXMLConvert(pathFileEdi);
				setLog(result);
			}
		});
		
		fileDialog = new FileDialog((Frame)null, "Select file edi");
		fileDialog.setMode(FileDialog.LOAD);
		
		iconBtnSearch = new ImageIcon(getClass().getResource("/com/github/josebr1/resources/icon_search.png"));
		btnSearch = new JButton("Search");
		btnSearch.setBounds(125, 0, 125, 50);
		btnSearch.setIcon(iconBtnSearch);
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fileDialog.setVisible(true);
				pathFileEdi = fileDialog.getDirectory() + fileDialog.getFile();
				setLog(pathFileEdi);
				System.out.println(pathFileEdi);
			}
		});
		
		
		titleBorderLogs = BorderFactory.createTitledBorder("Logs");
		
		logContainer = new JPanel();
		logContainer.setLayout(null);
		//logContainer.setBackground(Color.BLUE);
		logContainer.setBounds(0, 50, 250, 80);
		logContainer.setBorder(titleBorderLogs);
		
		txtLogs = new JTextArea();
		txtLogs.setBounds(5, 20, 238, 50);
		txtLogs.setLineWrap(true);
		txtLogs.setEditable(false);
		
		logContainer.add(txtLogs);
		
		container.add(btnConvert);
		container.add(btnSearch);
		container.add(logContainer);
		
		view.add(container);
		view.setVisible(true);
		view.setResizable(false);
		view.setLocationRelativeTo(null);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setLog(String log) {
		txtLogs.setText("");
		txtLogs.setText(log);
	}

}
