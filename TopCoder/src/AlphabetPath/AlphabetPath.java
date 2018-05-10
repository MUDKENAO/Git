/*Problem Statement
https://community.topcoder.com/stat?c=problem_statement&pm=11615
	
	@author Sun*/

package AlphabetPath;

import java.awt.Point;

public class AlphabetPath {

	/**
	 * 
	 * @param letterMaze
	 *            array of strings with maze itself
	 * @return "YES" if maze satisfied conditions from above. "NO" otherwise.
	 */
	public String doesItExist(String[] letterMaze) {
		Symbol firstElement = this.findA(letterMaze);
		if (firstElement != null) {
			Symbol element = firstElement;
			for (;;) {
				element = this.findNextNeighbor(letterMaze, element);
				if (element == null) {
					break;
				} else if (element.isLastElement()) {
					return "YES";
				}
			}
		}
		return "NO";
	}

	/**
	 * Get Symbol from maze
	 * 
	 * @param x
	 *            - x coordinate of the symbol in maze
	 * @param y
	 *            - y coordinate of the symbol in maze
	 * @param letterMaze
	 *            - maze itself
	 * @return Symbol or null if coordinates are not valid
	 */
	protected Symbol getSymbol(int x, int y, String[] letterMaze) {
		Symbol s = null;
		if (y >= 0 && y < letterMaze.length) {
			String row = letterMaze[y];
			if (x >= 0 && x < row.length()) {
				s = new Symbol(x, y, row.charAt(x));
			}
		}
		return s;
	}

	/**
	 * Looking for next symbol, based on current symbol. Next symbol must satisfy
	 * conditions from above.
	 * 
	 * @param letterMaze
	 *            - maze itself
	 * @param symbol
	 *            - current symbol
	 * @return Symbol or null if current symbol has no appropriate neighbor
	 */
	protected Symbol findNextNeighbor(String[] letterMaze, Symbol symbol) {
		Point coordinates = symbol.coordinates;
		Symbol up = this.getSymbol(coordinates.x, coordinates.y + 1, letterMaze);
		Symbol down = this.getSymbol(coordinates.x, coordinates.y - 1, letterMaze);
		Symbol right = this.getSymbol(coordinates.x + 1, coordinates.y, letterMaze);
		Symbol left = this.getSymbol(coordinates.x - 1, coordinates.y, letterMaze);

		if (up != null && up.element == symbol.nextElement()) {
			return up;
		} else if (down != null && down.element == symbol.nextElement()) {
			return down;
		} else if (right != null && right.element == symbol.nextElement()) {
			return right;
		} else if (left != null && left.element == symbol.nextElement()) {
			return left;
		}

		return null;
	}

	/**
	 * Looking for 'A' in maze
	 * 
	 * @param letterMaze
	 *            - maze itself
	 * @return Symbol or null if no 'A' in maze
	 */
	protected Symbol findA(String[] letterMaze) {
		Symbol aSymbol = null;
		for (int y = 0; y < letterMaze.length; y++) {
			int x = letterMaze[y].indexOf(Symbol.firstElement());
			if (x != -1) {
				aSymbol = new Symbol(x, y);
				break;
			}
		}
		return aSymbol;
	}

	/*Test with the example Data*/
	public static void main(String args[]) {
		String letterMaze[] = {"..............",
				 "..............",
				 "..............",
				 "...DEFGHIJK...",
				 "...C......L...",
				 "...B......M...",
				 "...A......N...",
				 "..........O...",
				 "..ZY..TSRQP...",
				 "...XWVU.......",
				 ".............."};
		
		System.out.println(new AlphabetPath().doesItExist(letterMaze));
	}
}

/**
 * Auxiliary class for representation symbols in maze
 * 
 */
class Symbol {

	public final char element;
	public Point coordinates;

	/**
	 * Constructor
	 * 
	 * @param x
	 *            - x coordinate
	 * @param y
	 *            - y coordinate
	 * @param c
	 *            - maze element
	 */
	public Symbol(int x, int y, char c) {
		this.element = c;
		this.coordinates = new Point(x, y);

	}

	/**
	 * Constructor for 'A'
	 * 
	 * @param x
	 *            - x coordinate
	 * @param y
	 *            - y coordinate
	 */
	public Symbol(int x, int y) {
		this(x, y, Symbol.firstElement());
	}

	/**
	 * @return true if this == first element in sequence (see conditions for maze
	 *         sequence)
	 */
	public boolean isFirstElement() {
		return this.element == Symbol.firstElement();
	}

	/**
	 * @return true if this == last element in sequence (see conditions for maze
	 *         sequence)
	 */
	public boolean isLastElement() {
		return this.element == Symbol.lastElement();
	}

	/**
	 * @return next sequence element
	 */
	public char nextElement() {
		return (char) (this.element + 1);
	}

	/**
	 * @return first sequence element
	 */
	public static char firstElement() {
		return 'A';
	}

	/**
	 * @return last sequence element
	 */
	public static char lastElement() {
		return 'Z';
	}
}
