package QuestionAnswer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import QuestionAnswer.Question.answer;

public class QuestionDemo extends JPanel implements ActionListener{

		JLabel questionText, scoreLabel;
		JRadioButton answerRadioA, answerRadioB, answerRadioC, answerRadioD, answerRadioE;
		JButton confirmButton;	
		ButtonGroup answersGroup;
		
		Question[] Questions = new Question[5];	
		int recentQuestion = 0;
		int score = 0;
		int questionMax = 5;
		
		public  QuestionDemo() 
		{	
			scoreLabel = new JLabel("Score: " + score);
			questionText = new JLabel();
			answerRadioA = new JRadioButton();
			answerRadioB = new JRadioButton();
			answerRadioC = new JRadioButton();
			answerRadioD = new JRadioButton();
			answerRadioE = new JRadioButton();
		
			confirmButton = new JButton("Confirm");
			
			answersGroup = new ButtonGroup();
			
			answersGroup.add(answerRadioA);
			answersGroup.add(answerRadioB);
			answersGroup.add(answerRadioC);
			answersGroup.add(answerRadioD);
			answersGroup.add(answerRadioE);
			
			confirmButton.addActionListener(this);
			
			add(questionText);
			add(answerRadioA);
			add(answerRadioB);
			add(answerRadioC);
			add(answerRadioD);
			add(answerRadioE);
			add(confirmButton);	
			add(scoreLabel);
			
			createQuestions();
			showQuestion(recentQuestion);
		}			
		
		public void createQuestions()
		{		
			Questions[0] = new Question ("Which one is not a programming language?",
					"Java", "C++", "C#", "Oracle", "Python", Question.answer.answer_D);		
			Questions[1] = new Question ("Which one is a programming language?",
					"Java", "Microsoft", "Apple", "Google", "IBM", Question.answer.answer_A);
			Questions[2] = new Question ("Which one is a computer manufacturer?",
					"Logitec", "Unity", "Python", "iPhone", "HP", Question.answer.answer_E);
			Questions[3] = new Question ("Which one is not a phone?",
					"iPhone", "Surface X", "Note 8", "Mi 11", "S23", Question.answer.answer_B);
			Questions[4] = new Question ("Which one is the biggest number?",
					"100110", "1011111011", "11010101101", "10111101", "101011", Question.answer.answer_C);	
		}
		
		public void showQuestion(int questionNo)
		{	
						questionText.setText(Questions[questionNo].questionText);
			answerRadioA.setText(Questions[questionNo].optionA);
			answerRadioB.setText(Questions[questionNo].optionB);
			answerRadioC.setText(Questions[questionNo].optionC);
			answerRadioD.setText(Questions[questionNo].optionD);
			answerRadioE.setText(Questions[questionNo].optionE);
		}
		
		public boolean answerCheck(Question.answer givenAnswer) {
			
			return Questions[recentQuestion].answerCheck(givenAnswer);
		}		
		
	public void actionPerformed(ActionEvent e)
	{
		boolean answer;
		
		if(answerRadioA.isSelected()) {
			answer = answerCheck(Question.answer.answer_A);	
		}
		else if(answerRadioB.isSelected()) {
			answer = answerCheck(Question.answer.answer_B);		
		}
		else if(answerRadioC.isSelected()) {
			answer = answerCheck(Question.answer.answer_C);		
		}
		else if(answerRadioD.isSelected()) {
			answer = answerCheck(Question.answer.answer_D);		
		}
		else if(answerRadioE.isSelected()) {
			answer = answerCheck(Question.answer.answer_E);		
		}
		else {
			answer = false;		
		}
		if(answer) {
		JOptionPane.showMessageDialog(this, "Correct!");
		score += 20;
		scoreLabel.setText("Score: " + score);
		}
		else{
		JOptionPane.showMessageDialog(this, "Wrong!");
		}
		recentQuestion++;
		if(recentQuestion < questionMax) {
		showQuestion(recentQuestion);
		}
		else {
			JOptionPane.showMessageDialog(this, "Finished! Your score is: " + score);
		}
		}
}
