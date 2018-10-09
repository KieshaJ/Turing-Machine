package main;

import java.util.ArrayList;

public class SequenceList {
	private ArrayList<Sequence> list;
	
	public SequenceList() {
		this.list = new ArrayList<Sequence>();
	}
	
	public void addToList(Sequence sequence) {
		list.add(sequence);
	}
	
	public ArrayList<Sequence> getList() {
		return list;
	}
	
	public int getListLength() {
		return list.size();
	}
	
	public Sequence findSequence(int currentState, char tapeSymbol) {
		for(int x = 0; x < getListLength(); x++) {
			if(list.get(x).getCurrentState() == currentState && list.get(x).getTapeSymbol() == tapeSymbol) {
				return list.get(x);
			}
		}
		
		return null;
	}
}