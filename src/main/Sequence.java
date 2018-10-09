package main;

public class Sequence {
	private int currentState;
	private char tapeSymbol;
	private char writeSymbol;
	private char direction;
	private int nextState;
	
	public Sequence(int currentState, char tapeSymbol, char writeSymbol, char direction, int nextState) {
		this.currentState = currentState;
		this.tapeSymbol = tapeSymbol;
		this.writeSymbol = writeSymbol;
		this.direction = direction;
		this.nextState = nextState;
	}

	public int getCurrentState() {
		return currentState;
	}

	public char getTapeSymbol() {
		return tapeSymbol;
	}

	public char getWriteSymbol() {
		return writeSymbol;
	}

	public char getDirection() {
		return direction;
	}

	public int getNextState() {
		return nextState;
	}
}