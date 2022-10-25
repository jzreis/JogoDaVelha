import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

	JFrame window = new JFrame();
	JLabel text = new JLabel();
	JPanel title = new JPanel();
	JPanel button = new JPanel();

	JButton[] buttons = new JButton[9];

	private boolean player1time = true;

	public TicTacToe() {

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(800, 800);
		window.getContentPane().setBackground(new Color(28, 28, 28));
		window.setVisible(true);

		text.setFont(new Font("Matrix", Font.BOLD, 75));
//text.setBackground(new Color(0,172,237));
		text.setBackground(new Color(0, 0, 0));
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setText("Jogo da Velha");
		text.setOpaque(true);

		title.setLayout(new BorderLayout());
		title.setBounds(0, 0, 800, 200);

		button.setLayout(new GridLayout(3, 3));

		for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton();

			button.add(buttons[i]);
			buttons[i].setFont(new Font("Matrix", Font.BOLD, 80));
			buttons[i].setBackground(new Color(40, 40, 40));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
			buttons[i].setEnabled(true);
		}

		title.add(text);
		window.add(title, BorderLayout.NORTH);
		window.add(button);

	}

	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < 9; i++) {
			if (e.getSource() == buttons[i]) {
				if (player1time) {
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(0, 191, 255));
						text.setBackground(new Color(220, 20, 60));
						buttons[i].setText("X");
						text.setText("Player O");
						player1time = false;

						check();
					}
				} else {
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(220, 20, 60));
						text.setBackground(new Color(0, 191, 255));
						buttons[i].setText("O");
						text.setText("Player X");
						player1time = true;

						check();
					}

				}

			}

		}

	}

	public void check() {
		
//Variavel para saber se o jogo deu uma vitoria ou um empate 
		boolean empate,win;
		empate = false;
		win=false;
		
//Possibilidades de vitoria do X
		if (buttons[0].getText() == "X" && buttons[1].getText() == "X" && buttons[2].getText() == "X") {
			win(0, 1, 2);
			win=true;
		}
		if (buttons[3].getText() == "X" && buttons[4].getText() == "X" && buttons[5].getText() == "X") {
			win(3, 4, 5);
			win=true;
		}
		if (buttons[6].getText() == "X" && buttons[7].getText() == "X" && buttons[8].getText() == "X") {
			win(6, 7, 8);
			win=true;
		}
		if (buttons[0].getText() == "X" && buttons[3].getText() == "X" && buttons[6].getText() == "X") {
			win(0, 3, 6);
			win=true;
		}
		if (buttons[1].getText() == "X" && buttons[4].getText() == "X" && buttons[7].getText() == "X") {
			win(1, 4, 7);
			win=true;
		}
		if (buttons[2].getText() == "X" && buttons[5].getText() == "X" && buttons[8].getText() == "X") {
			win(2, 5, 8);
			win=true;
		}
		if (buttons[0].getText() == "X" && buttons[4].getText() == "X" && buttons[8].getText() == "X") {
			win(0, 4, 8);
			win=true;
		}
		if (buttons[2].getText() == "X" && buttons[4].getText() == "X" && buttons[6].getText() == "X") {
			win(2, 4, 6);
			win=true;
		}

//Possiblidades de vitoria do O

		if (buttons[0].getText() == "O" && buttons[1].getText() == "O" && buttons[2].getText() == "O") {
			win(0, 1, 2);
			win=true;
		}
		if (buttons[3].getText() == "O" && buttons[4].getText() == "O" && buttons[5].getText() == "O") {
			win(3, 4, 5);
			win=true;
		}
		if (buttons[6].getText() == "O" && buttons[7].getText() == "O" && buttons[8].getText() == "O") {
			win(6, 7, 8);
			win=true;
		}
		if (buttons[0].getText() == "O" && buttons[3].getText() == "O" && buttons[6].getText() == "O") {
			win(0, 3, 6);
			win=true;
		}
		if (buttons[1].getText() == "O" && buttons[4].getText() == "O" && buttons[7].getText() == "O") {
			win(1, 4, 7);
			win=true;
		}
		if (buttons[2].getText() == "O" && buttons[5].getText() == "O" && buttons[8].getText() == "O") {
			win(2, 5, 8);
			win=true;
		}
		if (buttons[0].getText() == "O" && buttons[4].getText() == "O" && buttons[8].getText() == "O") {
			win(0, 4, 8);
			win=true;
		}
		if (buttons[2].getText() == "O" && buttons[4].getText() == "O" && buttons[6].getText() == "O") {
			win(2, 4, 6);
			win=true;
		}

//Descobre se deu empate

		

		int cont = 0;
		for (int i = 0; i < 9; i++) {
			if ((buttons[i].getText() == "O") || (buttons[i].getText() == "X")) {
				cont++;
			}
			if ((cont == 9)&&(win == false)) {
				empate = true;
			}
		}
		if (empate == true) {
			text.setBackground(new Color(28, 28, 28));
			text.setText("Empate!!!");
		}
	}

//Metodo para contar se todos os botoes ja foram presisonados

	public boolean win(int x, int y, int z) {

		buttons[x].setBackground(new Color(0, 255, 0));
		buttons[y].setBackground(new Color(0, 255, 0));
		buttons[z].setBackground(new Color(0, 255, 0));

		for (int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}

		text.setBackground(new Color(0, 255, 0));
		text.setText("Ganhou!!!");

		return true;
	}

	public void clear() {
		for (int i = 0; i < 9; i++) {
			buttons[i].setText("");
			buttons[i].setEnabled(false);
		}
	}
}
