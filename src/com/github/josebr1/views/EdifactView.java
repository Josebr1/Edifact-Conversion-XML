package com.github.josebr1.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import com.github.josebr1.controllers.EdifactController;

public class EdifactView {

	private JButton btnConvert;
	private JButton btnSearch;
	private TitledBorder titleBorderLogs;
	private Icon iconBtnConvert;
	private Icon iconBtnSearch;
	private FileDialog fileDialog;
	private File[] pathFileEdi;
	private JTextArea txtLogs;

	public void execute() {
		
		JFrame view = new JFrame("Convert Edifact to xml");
		view.setSize(250, 150);
		
		JPanel container = new JPanel();
		container.setLayout(null);
		
		iconBtnConvert = new ImageIcon(getClass().getResource("/com/github/josebr1/resources/icon_run.png"));
		btnConvert = new JButton("Convert");
		btnConvert.setBounds(0, 0, 125, 30);
		btnConvert.setIcon(iconBtnConvert);
		btnConvert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (pathFileEdi.length <= 0) {
					JOptionPane.showMessageDialog(null, "Not file");
					return;
				}
				EdifactController controller = new EdifactController();
				String result = controller.xml(pathFileEdi);
				setLog(result);
			}
		});
		
		fileDialog = new FileDialog((Frame)null, "Select file edi");
		fileDialog.setMode(FileDialog.LOAD);
		fileDialog.setMultipleMode(true);
		
		iconBtnSearch = new ImageIcon(getClass().getResource("/com/github/josebr1/resources/icon_search.png"));
		btnSearch = new JButton("Search");
		btnSearch.setBounds(125, 0, 125, 30);
		btnSearch.setIcon(iconBtnSearch);
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fileDialog.setVisible(true);
				System.out.println();
				pathFileEdi = fileDialog.getFiles();
				setLog(Arrays.toString(fileDialog.getFiles()));
				System.out.println(pathFileEdi);
			}
		});
		titleBorderLogs = BorderFactory.createTitledBorder("Logs");

		txtLogs = new JTextArea();
		txtLogs.setBounds(2, 32, 240, 85);
		txtLogs.setWrapStyleWord(true);
		txtLogs.setLineWrap(true);
		txtLogs.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(txtLogs);
		scrollPane.setBounds(2, 32, 240, 85);
		scrollPane.setBorder(titleBorderLogs);

		container.add(btnConvert);
		container.add(btnSearch);
		container.add(scrollPane);
		
		view.add(container);
		view.setVisible(true);
		view.setResizable(false);
		view.setLocationRelativeTo(null);
		view.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	private void setLog(String log) {
		txtLogs.setText("");
		txtLogs.setText(log);
	}
}
