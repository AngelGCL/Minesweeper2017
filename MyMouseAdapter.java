import java.awt.Color;

import java.awt.Component;

import java.awt.Insets;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import java.util.Random;

import javax.swing.JFrame;

public class MyMouseAdapter extends MouseAdapter {

	private Random generator = new Random();

	public void mousePressed(MouseEvent e) {

		switch (e.getButton()) {

		case 1: // Left mouse button

			Component c = e.getComponent();

			while (!(c instanceof JFrame)) {

				c = c.getParent();

				if (c == null) {

					return;

				}

			}

			JFrame myFrame = (JFrame) c;

			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);

			Insets myInsets = myFrame.getInsets();

			int x1 = myInsets.left;

			int y1 = myInsets.top;

			e.translatePoint(-x1, -y1);

			int x = e.getX();

			int y = e.getY();

			myPanel.x = x;

			myPanel.y = y;

			myPanel.mouseDownGridX = myPanel.getGridX(x, y);

			myPanel.mouseDownGridY = myPanel.getGridY(x, y);

			myPanel.repaint();

			break;

		case 3: // Right mouse button

			// Do nothing

			break;

		default: // Some other button (2 = Middle mouse button, etc.)

			// Do nothing

			break;

		}

	}

	public void mouseReleased(MouseEvent e) {

		switch (e.getButton()) {

		case 1: // Left mouse button

			Component c = e.getComponent();

			while (!(c instanceof JFrame)) {

				c = c.getParent();

				if (c == null) {

					return;

				}

			}

			JFrame myFrame = (JFrame) c;

			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0); // Can

			// also

			// loop

			// among

			// components

			// to

			// find

			// MyPanel

			Insets myInsets = myFrame.getInsets();

			int x1 = myInsets.left;

			int y1 = myInsets.top;

			e.translatePoint(-x1, -y1);

			int x = e.getX();

			int y = e.getY();

			myPanel.x = x;

			myPanel.y = y;

			int gridX = myPanel.getGridX(x, y);

			int gridY = myPanel.getGridY(x, y);

			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {

				// Had pressed outside

				// Do nothing

			} else {

				if ((gridX == -1) || (gridY == -1)) {

					// Is releasing outside

					// Do nothing

				} else {

					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {

						// Released the mouse button on a different cell where

						// it was pressed

						// Do nothing

					} else {

						// Released the mouse button on the same cell where it

						// was pressed

						if ((gridX == 0) || (gridY == 0)) {

							if (((gridX == 0) && (gridY == 0)) || ((gridX == 0) && (gridY == 10))) {

								if ((gridX == 0) && (gridY == 0)) {

									Color newDiagonalColor = null;

									switch (generator.nextInt(5)) {

									case 0:

										newDiagonalColor = Color.YELLOW;

										break;

									case 1:

										newDiagonalColor = Color.MAGENTA;

										break;

									case 2:

										newDiagonalColor = Color.BLACK;

										break;

									case 3:

										newDiagonalColor = new Color(0x964B00); // Brown

										// (from

										// http://simple.wikipedia.org/wiki/List_of_colors)

										break;

									case 4:

										newDiagonalColor = new Color(0xB57EDC); // Lavender

										// (from

										// http://simple.wikipedia.org/wiki/List_of_colors)

										break;

									}

									if (myPanel.colorArray[1][1].equals(newDiagonalColor)) {

										for (int i = 1; i < myPanel.colorArray.length; i++) {

											newDiagonalColor = Color.BLUE;

											myPanel.colorArray[i][i] = newDiagonalColor;

											myPanel.repaint();

										}

									} else {

										for (int i = 1; i < myPanel.colorArray.length; i++) {

											myPanel.colorArray[i][i] = newDiagonalColor;

											myPanel.repaint();

										}

									}

								}

							}

						

						// On the left column and on the top row... do nothing

						if (((gridY == 0) && ((gridX >= 1)) && (gridX <= 9))) {

							Color newColumnsColor = null;

							switch (generator.nextInt(5)) {

							case 0:

								newColumnsColor = Color.YELLOW;

								break;

							case 1:

								newColumnsColor = Color.MAGENTA;

								break;

							case 2:

								newColumnsColor = Color.BLACK;

								break;

							case 3:

								newColumnsColor = new Color(0x964B00); // Brown

								// (from

								// http://simple.wikipedia.org/wiki/List_of_colors)

								break;

							case 4:

								newColumnsColor = new Color(0xB57EDC); // Lavender

								// (from

								// http://simple.wikipedia.org/wiki/List_of_colors)

								break;

							}

							if (myPanel.colorArray[myPanel.mouseDownGridX][1].equals(newColumnsColor)) {

								for (int i = 1; i < myPanel.colorArray.length; i++) {

									newColumnsColor = Color.BLUE;

									myPanel.colorArray[myPanel.mouseDownGridX][i] = newColumnsColor;

									myPanel.repaint();

								}

							} else {

								for (int i = 1; i < myPanel.colorArray.length; i++) {

									myPanel.colorArray[myPanel.mouseDownGridX][i] = newColumnsColor;

									myPanel.repaint();

								}

							}

						}

						else if (((gridX == 0) && ((gridY >= 1)) && (gridY <= 9))) {

							Color newRowColor = null;

							switch (generator.nextInt(5)) {

							case 0:

								newRowColor = Color.YELLOW;

								break;

							case 1:

								newRowColor = Color.MAGENTA;

								break;

							case 2:

								newRowColor = Color.BLACK;

								break;

							case 3:

								newRowColor = new Color(0x964B00); // Brown

								// (from

								// http://simple.wikipedia.org/wiki/List_of_colors)

								break;

							case 4:

								newRowColor = new Color(0xB57EDC); // Lavender

								// (from

								// http://simple.wikipedia.org/wiki/List_of_colors)

								break;

							}

							if (myPanel.colorArray[1][myPanel.mouseDownGridY].equals(newRowColor)) {

								for (int i = 1; i < myPanel.colorArray.length; i++) {

									newRowColor = Color.BLUE;

									myPanel.colorArray[i][myPanel.mouseDownGridY] = newRowColor;

									myPanel.repaint();

								}

							} else {

								for (int i = 1; i < myPanel.colorArray.length; i++) {

									myPanel.colorArray[i][myPanel.mouseDownGridY] = newRowColor;

									myPanel.repaint();

								}

							}

						}

					}else {

							// On the grid other than on the left column and on

							// the top row:

							Color newColor = null;

							switch (generator.nextInt(5)) {

							case 0:

								newColor = Color.YELLOW;

								break;

							case 1:

								newColor = Color.MAGENTA;

								break;

							case 2:

								newColor = Color.BLACK;

								break;

							case 3:

								newColor = new Color(0x964B00); // Brown (from

								// http://simple.wikipedia.org/wiki/List_of_colors)

								break;

							case 4:

								newColor = new Color(0xB57EDC); // Lavender

								// (from

								// http://simple.wikipedia.org/wiki/List_of_colors)

								break;

							}

							if (myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY].equals(newColor)) {

								newColor = Color.BLUE;

								myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;

								myPanel.repaint();

							}

							else {

								myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;

								myPanel.repaint();

							}

						}

					}

				}

			}

			myPanel.repaint();

			break;

		case 3: // Right mouse button

			// Do nothing

			break;

		default: // Some other button (2 = Middle mouse button, etc.)

			// Do nothing

			break;

		}

	}

}