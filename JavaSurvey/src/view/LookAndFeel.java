package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LookAndFeel extends JDialog {

	private static final long serialVersionUID = 567428732984733599L;
	private JLabel title = new JLabel("Ändere dein LookAndFeel");
	private JPanel buttonPanel = new JPanel(new GridLayout(0, 2));
	private JButton back = new JButton("Zurück");
	private JButton save = new JButton("Anwenden");
	private JPanel eingaben = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JComboBox<ColorType> colorComboBox = new JComboBox<ColorType>();
	private Color chosenColor = Color.WHITE; 

	public LookAndFeel() {
		
		for(ColorType ct : ColorType.values()) {
			colorComboBox.addItem(ct);
		}

		setLayout(new BorderLayout());
		title.setHorizontalAlignment(JLabel.CENTER);
		add(title, BorderLayout.NORTH);
		eingaben.add(colorComboBox);
		add(eingaben, BorderLayout.CENTER);
		buttonPanel.add(back);
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				getContentPane().setBackground(((ColorType)colorComboBox.getSelectedItem()).getColor());
				eingaben.setBackground(((ColorType)colorComboBox.getSelectedItem()).getColor());

			}
		});
		buttonPanel.add(save);
		add(buttonPanel, BorderLayout.SOUTH);
		setSize(400, 400);

		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				MainView launcher = new MainView();
				launcher.setVisible(true);
				setVisible(false);

			}
		});

	}

	public static void main(String[] args) {

		LookAndFeel launcher = new LookAndFeel();
		launcher.setVisible(true);

	}

}
