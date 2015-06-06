package screens;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class FileIO implements Runnable {

	Thread IO;
	PingPongGameEngine Engine;
	BufferedReader br;

	public FileIO(PingPongGameEngine gameEngine) {
		Engine = gameEngine;
		IO = new Thread(this);
		IO.start();
	}
//	@Override
//	public void run() {
//
//		try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(
//				new FileOutputStream("D://write//notes.txt", true)))) {
//			while (true) {
//				synchronized (Engine.monitor) {
//					try {
//						Engine.monitor.wait();
//					} catch (InterruptedException e1) {
//						e1.printStackTrace();
//					}
//					if (Engine.REC) {
//						pw.println(Engine.ballX);
//						pw.println(Engine.ballY);
//						pw.println(Engine.computerRacket_Y);
//						pw.println(Engine.kidRacket_Y);
//					}
//					if (Engine.recMode) {
//						try {
//							String line = null;
//							line = Engine.br.readLine();
//							Integer ballX = new Integer(line);
//							line = Engine.br.readLine();
//							Integer ballY = new Integer(line);
//							line = Engine.br.readLine();
//							Integer computerRacket_Y = new Integer(line);
//							line = Engine.br.readLine();
//							Integer kidRacket_Y = new Integer(line);
//							Engine.ballX = ballX;
//							Engine.ballY = ballY;
//							Engine.computerRacket_Y = computerRacket_Y;
//							Engine.kidRacket_Y = kidRacket_Y;
//
//						} catch (IOException e) {
//							e.printStackTrace();
//						} catch (NumberFormatException e) {
//							e.printStackTrace();
//							Engine.recMode = false;
//						}
//					}
//				}
//			}
//		} catch (FileNotFoundException q) {
//			System.err.println(q.getMessage());
//		}
//	}
//}
	@Override
	public void run() {

		while (true) {
			try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(
					new FileOutputStream("D://write//notes.txt", true)))) {
				synchronized (Engine.monitor) {
					try {
						Engine.monitor.wait();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					if (Engine.REC) {

						pw.println(Engine.ballX);
						pw.println(Engine.ballY);
						pw.println(Engine.computerRacket_Y);
						pw.println(Engine.kidRacket_Y);
						pw.println(Engine.computerScore);
						pw.println(Engine.kidScore);

					}
					try {
						Engine.monitor.wait();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					if (Engine.recMode) {
						try {
							String line = null;
							line = Engine.br.readLine();
							Integer ballX = new Integer(line);
							line = Engine.br.readLine();
							Integer ballY = new Integer(line);
							line = Engine.br.readLine();
							Integer computerRacket_Y = new Integer(line);
							line = Engine.br.readLine();
							Integer kidRacket_Y = new Integer(line);
							line = Engine.br.readLine();
							Integer computerScore = new Integer(line);
							line = Engine.br.readLine();
							Integer kidScore = new Integer(line);
							Engine.ballX = ballX;
							Engine.ballY = ballY;
							Engine.computerRacket_Y = computerRacket_Y;
							Engine.kidRacket_Y = kidRacket_Y;
							Engine.computerScore = computerScore;
							Engine.kidScore = kidScore;

						} catch (IOException e) {
							e.printStackTrace();
						} catch (NumberFormatException e) {
							e.printStackTrace();
							Engine.recMode = false;
						}

					}
				}
			} catch (FileNotFoundException q) {
				System.err.println(q.getMessage());
			}
		}

	}
}

