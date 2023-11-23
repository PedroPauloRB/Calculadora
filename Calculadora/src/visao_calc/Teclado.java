package visao_calc;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import modelo_calc.Memoria;

@SuppressWarnings("serial")
public class Teclado extends JPanel implements ActionListener {
	
	private final Color Cinzaescuro = new Color(68, 69, 68);
	private final Color Cinzaclaro = new Color(97, 100, 99);
	private final Color Laranja = new Color(242, 163, 60);
	
	
	
	public Teclado() {
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		setLayout(layout);
		
		c.weighty=1;
		c.weightx=1; 
		c.fill = GridBagConstraints.BOTH;
		
	
		adicionarbotao("AC", Cinzaescuro, c,0,0);
		c.gridwidth=2;
		adicionarbotao("+/-", Cinzaescuro, c,1,0);
		c.gridwidth=1;
		adicionarbotao("/", Laranja, c,3,0);
		
		adicionarbotao("7", Cinzaclaro, c,0,1);
		adicionarbotao("8", Cinzaclaro, c,1,1);
		adicionarbotao("9", Cinzaclaro, c,2,1);
		adicionarbotao("*", Laranja, c,3,1);
		
		adicionarbotao("4", Cinzaclaro, c,0,2);
		adicionarbotao("5", Cinzaclaro, c,1,2 );
		adicionarbotao("6", Cinzaclaro, c,2,2 );
		adicionarbotao("-", Laranja, c,3,2 );
		
		adicionarbotao("1", Cinzaclaro, c,0,3 );
		adicionarbotao("2", Cinzaclaro, c,1,3 );
		adicionarbotao("3", Cinzaclaro, c,2,3 );
		adicionarbotao("+", Laranja, c,3,3 );
		
		c.gridwidth=2;
		adicionarbotao("0", Cinzaclaro, c,0,4 );
		c.gridwidth=1;
		adicionarbotao(",", Cinzaclaro, c,2,4 );
		adicionarbotao("=", Laranja, c,3,4 );
		

	}
	private void adicionarbotao( String texto, Color cor, GridBagConstraints c, int x, int y) {
		c.gridx=x;
		c.gridy=y;
		Botao botao = new Botao(texto, cor);
		botao.addActionListener(this);
		add(botao, c);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource() instanceof JButton ) {
		JButton botao = (JButton) e.getSource();
		Memoria.getInstancia().processarComando(botao.getText());
		}
	}
}
