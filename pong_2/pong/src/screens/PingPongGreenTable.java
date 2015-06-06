package screens;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Этот класс рисует зеленый стол для пинг-понга, шар, ракетки, отображает счет
 */

public class PingPongGreenTable extends JPanel implements GameConstants {

	private static final long serialVersionUID = 1L;
	private JLabel label;
	PingPongGameEngine gameEngine;
	private int computerRacket_Y = COMPUTER_RACKET_Y_START;
	private int kidRacket_Y = KID_RACKET_Y_START;
	private int ballX = BALL_START_X;
	private int ballY = BALL_START_Y;

	Dimension preferredSize = new Dimension(TABLE_WIDTH, TABLE_HEIGHT); // Устанавливаем
																		// размеры
																		// окна.Вызывается
																		// виртуальной
																		// машиной

	public Dimension getPreferredSize() {
		return preferredSize;
	}

	// Конструктор. Создает обработчик событий мыши.
	PingPongGreenTable() {
		gameEngine = new PingPongGameEngine(this);
		addMouseMotionListener(gameEngine); // Обрабатываем движения мыши для передвижения ракеток
		addKeyListener(gameEngine); // Обрабатываем события клавиатуры
	}

	// Добавим в окно панель с JLabel
	void addLabeltoFrame(Container container) {
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.add(this);
		label = new JLabel("Press N for a new game, S to serve or Q to quit");
		label.setBounds(0, TABLE_HEIGHT, TABLE_WIDTH, 20);
		container.add(label);
	}
	//Строка меню, пункты меню
	void addMenuBartoFrame (Container container){
		
		JMenuBar menu = new JMenuBar();
		container.add(menu);
		menu.setLayout(new BoxLayout(menu, BoxLayout.X_AXIS));
		
		JMenu menuGame = new JMenu ("Игра");
		menuGame.setAlignmentX(LEFT_ALIGNMENT);
		menu.add(menuGame);
		JMenuItem item1 = new JMenuItem("Новая игра  N");
		item1.addActionListener(gameEngine);
		menuGame.add(item1);
		JMenuItem item2 = new JMenuItem("Подача        S");
		item2.addActionListener(gameEngine);
		menuGame.add(item2);
		
		JMenu menuLevel = new JMenu ("Сложность");
		menuGame.add(menuLevel);
		JMenuItem item3 = new JMenuItem("Изи");
		item3.addActionListener(gameEngine);
		menuLevel.add(item3);
		JMenuItem item4 = new JMenuItem("Норм");
		item4.addActionListener(gameEngine);
		menuLevel.add(item4);		
		JMenuItem item5 = new JMenuItem("Хард");
		item5.addActionListener(gameEngine);
		menuLevel.add(item5);
		menuGame. addSeparator();
		
		JMenuItem item8 = new JMenuItem("BOTmode");
		item8.addActionListener(gameEngine);
		menuGame.add(item8);
		
		JMenuItem item7 = new JMenuItem("Воспроизвести игру");
		item7.addActionListener(gameEngine);
		menuGame.add(item7);
		
		JMenuItem item6 = new JMenuItem("Выход    Q");
		item6.addActionListener(gameEngine);
		menuGame.add(item6);
	}

	// Перерисовать окно. Этот метод вызывается виртуальной
	// машиной, когда нужно обновить экран или
	// вызывается метод repaint() из PingPoingGameEngine
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		// Нарисовать зеленый стол
		g.setColor(Color.green);
		g.fillRect(0, 0, TABLE_WIDTH, TABLE_HEIGHT);
		// Нарисовать белые линии

		g.setColor(Color.white);
		g.drawRect(FIELD_LEFT, FIELD_TOP, FIELD_WIGTH, FIELD_HEIGTH);
		g.drawLine(TABLE_WIDTH / 2, FIELD_TOP, TABLE_WIDTH / 2, FIELD_BOTTOM);

		// Нарисовать правую ракетку
		g.setColor(Color.blue);
		g.fillRect(KID_RACKET_X, kidRacket_Y, RACKET_WIDTH, RACKET_LENGTH);

		// Нарисовать левую ракетку
		g.setColor(Color.red);
		g.fillRect(COMPUTER_RACKET_X, computerRacket_Y, RACKET_WIDTH, RACKET_LENGTH);

		// Нарисовать мяч
		g.setColor(Color.orange);
		g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);

		// Установить фокус на стол, чтобы
		// обработчик клавиатуры мог посылать команды столу
		requestFocus();
	}

	// Установить текущее положение ракетки ребенка
	public void setKidRacket_Y(int yCoordinate) {
		this.kidRacket_Y = yCoordinate;
		repaint();
	}

	// Установить текущее положение ракетки компьютера
	public void setComputerRacket_Y(int yCoordinate) {
		this.computerRacket_Y = yCoordinate;
		repaint();
	}

	// Установить игровое сообщение
	public void setMessageText(String text) {
		label.setText(text);
		repaint();
	}

	// Установить позицию мяча
	public void setBallPosition(int xPos, int yPos) {
		ballX = xPos;
		ballY = yPos;
		repaint();
	}

	public static void main(String[] args) {

		// Создать экземпляр окна
		JFrame f = new JFrame("Ping Pong Green Table");

		// Убедиться, что окно может быть закрыто по нажатию на
		// крестик в углу
		
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		PingPongGreenTable table = new PingPongGreenTable();
		table.addMenuBartoFrame(f.getContentPane());
		table.addLabeltoFrame(f.getContentPane());
		// Установить размер окна и сделать его видимым
		f.setBounds(0, 0, TABLE_WIDTH + 15, TABLE_HEIGHT + 80);
		f.setVisible(true);

	}

}
