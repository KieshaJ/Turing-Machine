package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TuringMachine {
	private static void runFile(String file) throws FileNotFoundException {
		int headerPosition;
		int currentState = 0;
		char[] tape;
		SequenceList list = new SequenceList();
		
		Scanner input = new Scanner(new File("src/resources/" + file));
		
		headerPosition = input.nextInt() - 1;
		tape = input.next().toString().toCharArray();
		
		System.out.println(tape);
		
		while(input.hasNext()) {
			int state = input.nextInt();
			System.out.println(state);
			char tapeSymbol = input.next().charAt(0);
			char writeSymbol = input.next().charAt(0);
			char direction = input.next().charAt(0);
			int nextState;
			
			if(input.hasNextInt()) {
				nextState = input.nextInt();
			}
			else {
				nextState = -1;
				input.next();
			}
			
			list.addToList(new Sequence(state, tapeSymbol, writeSymbol, direction, nextState));
		}
		
		input.close();
		
		Scanner in = new Scanner(System.in);
		int iterationCount = 0;
		
		while(headerPosition > -1 && headerPosition < tape.length) {
			Sequence sequence = list.findSequence(currentState, tape[headerPosition]);
			
			if(currentState == -1) break;
			
			tape[headerPosition] = sequence.getWriteSymbol();
			currentState = sequence.getNextState();
			
			if(sequence.getDirection() == 'R') headerPosition++;
			if(sequence.getDirection() == 'L') headerPosition--;
			
			System.out.println(tape);
			
			iterationCount++;
			
			if(iterationCount > 500000) {
				System.out.println("Ar testi? (1/0)");
				int x = in.nextInt();
				
				if(x == 1) {
					iterationCount = 0;
				}
				else {
					break;
				}
			}
		}
	};
	
	private static void greeting() {
		System.out.println("Tiuringo masina");
		System.out.println("----------------------------------");
		System.out.println("Pasirinkite viena is keturiu failu(1-4) arba iveskite 0, jei norite nutraukti programos darba: ");
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		final String file1 = "1.txt";
		final String file2 = "2.txt";
		final String file3 = "3.txt";
		final String file4 = "4.txt";
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			greeting();
			
			String input = scanner.nextLine();
			
			switch(input) {
				case "1":
					runFile(file1);
					break;
				case "2":
					runFile(file2);
					break;
				case "3":
					runFile(file3);
					break;
				case "4":
					runFile(file4);
					break;
				case "0":
					System.out.println("Viso gero!");
					scanner.close();
					System.exit(0);
				default:
					break;
			}
		}
	}
}