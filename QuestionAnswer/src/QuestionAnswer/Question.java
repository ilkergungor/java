package QuestionAnswer;

public class Question {
	
	String questionText;
	String optionA, optionB, optionC, optionD, optionE;
	public enum answer {answer_D, answer_A,	answer_E, answer_B, answer_C};

	answer correctAnswer;

	public Question(String questionText, String optionA, String optionB, String optionC,
		String optionD, String optionE, answer correctAnswer) {
	
		super();
		this.questionText = questionText;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.optionE = optionE;
		this.correctAnswer = correctAnswer;
	}
		
	boolean answerCheck (answer answer)
		{
		if( correctAnswer == answer) {
			return true;
			}
		else {
		return false;
			}
		}
		public boolean checkAnswer(answer givenAnswer) {

			return false;
		}
}
