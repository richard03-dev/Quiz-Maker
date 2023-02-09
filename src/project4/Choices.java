package project4;

public class Choices {
	
	private String letter;
	private String text;
	private boolean correct;
	
	public Choices(String letter, String text, boolean correct) {
		this.letter = letter;
		this.text = text;
		this.correct = correct;
	}
	
	public Choices(String letter, String text) {
		this.letter = letter;
		this.text = text;
	}
	
	public String getLetter() {
		return this.letter;
	}
	
	public void setLetter(String letter) {
		this.letter = letter;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Boolean isCorrect() {
		return this.correct;
	}
	
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	
	public String toString() {
		return this.letter + ") " + this.text;
	}
	
	

}