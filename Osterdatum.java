package JavaUebung08;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Osterdatum extends JFrame
{
	private JPanel contentPane;
	private JTextField jahreszahl;
	private JLabel datum;
	public Osterdatum()
	{
		//Frame
		setTitle("OsterDatumOstern");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 209);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Labels
		JLabel jahr = new JLabel("Jahr");
		jahr.setBounds(10,11,84,14);
		contentPane.add(jahr);
		
		JLabel DatumOstern = new JLabel("DatumOstern für Ostersonntag:");
		DatumOstern.setBounds(10, 86, 148, 14);
		contentPane.add(DatumOstern);
		
		JLabel Datum = new JLabel("Berechnung nur f\u00FCr Jahreszahl > 1583");
		Datum.setBounds(167, 86, 238, 14);
		contentPane.add(Datum);
		
		//TextField
		
		JTextField jahreszahl = new JTextField();
		jahreszahl.setBounds(8, 26, 86, 20);
		contentPane.add(jahreszahl);
		jahreszahl.setColumns(10);
		
		//Button
		JButton berechnung = new JButton("Datum für Ostersonntag ausrechnen");
		berechnung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				berechnen();
			}
		});
		berechnung.setBounds(112, 25, 262, 23);
		contentPane.add(berechnung);
		
		
		JButton Ende = new JButton("Ende");
		Ende.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    System.exit(0);
			}
		});
		Ende.setBounds(204, 129, 89, 23);
		contentPane.add(Ende);
	    
	}
	
	private void berechnen()
	{
		int y = Integer.parseInt(jahreszahl.getText());
		if (y > 1583) {
		    int g = y % 19;
		    int c = y / 100;
		    int h = (c - c / 4 - (8 * c + 13) / 25 + 19 * g + 15) % 30;
		    int i = h - (h / 28) * (1 - (29 / (h + 1)) * ((21 - g) / 11));
		    int j = (y + y / 4 + i + 2 - c + c / 4) % 7;
		    int l = i - j;
		    int m = 3 + (l + 40) / 44;
		    int d = l + 28 - 31 * (m / 4);
		    datum.setText(d + "." + m + ".");
		} else {
		    datum.setText("Berechnung nur f�r Jahreszahl > 1583");
		}
		jahreszahl.requestFocus();
		jahreszahl.selectAll();
	}

	
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Osterdatum frame = new Osterdatum();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }
	}

