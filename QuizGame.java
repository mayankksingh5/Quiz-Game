import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String questionText;
    private List<String> choices;
    private int correctChoiceIndex;

    public Question(String questionText, List<String> choices, int correctChoiceIndex) {
        this.questionText = questionText;
        this.choices = choices;
        this.correctChoiceIndex = correctChoiceIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getChoices() {
        return choices;
    }

    public int getCorrectChoiceIndex() {
        return correctChoiceIndex;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }

    public void setCorrectChoiceIndex(int correctChoiceIndex) {
        this.correctChoiceIndex = correctChoiceIndex;
    }
}

public class QuizGame {

    private List<Question> questions;
    private int score;
    private Scanner scanner;

    public QuizGame() {
        this.questions = new ArrayList<>();
        this.score = 0;
        this.scanner = new Scanner(System.in);
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void startGame() {
        for (Question question : questions) {
            displayQuestion(question);
            int userAnswer = getUserAnswer();
            checkAnswer(question, userAnswer);
        }

        displayFinalScore();
    }

    private void displayQuestion(Question question) {
        System.out.println(question.getQuestionText());

        List<String> choices = question.getChoices();
        for (int i = 0; i < choices.size(); i++) {
            System.out.println((i + 1) + ". " + choices.get(i));
        }
    }

    private int getUserAnswer() {
        System.out.print("Enter your choice (1-" + questions.get(0).getChoices().size() + "): ");
        return scanner.nextInt();
    }

    private void checkAnswer(Question question, int userAnswer) {
        if (userAnswer == question.getCorrectChoiceIndex() + 1) {
            System.out.println("Correct!\n");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer was: " +
                    question.getChoices().get(question.getCorrectChoiceIndex()) + "\n");
        }
    }

    private void displayFinalScore() {
        System.out.println("Quiz completed! Your final score is: " + score + " out of " + questions.size());
    }

    public static void main(String[] args) {
        // Create a quiz game
        QuizGame quizGame = new QuizGame();

        // Add questions to the quiz
        List<String> choices1 = List.of("A. Java", "B. Python", "C. C++", "D. JavaScript");
        Question question1 = new Question(
                "Which programming language is known as the 'write once, run anywhere' language?", choices1, 0);

        List<String> choices2 = List.of("A. Red", "B. Green", "C. Blue", "D. Yellow");
        Question question2 = new Question("What color is a banana?", choices2, 3);

        // Add more questions as needed...

        // Add questions to the quiz
        quizGame.addQuestion(question1);
        quizGame.addQuestion(question2);

        // Start the quiz game
        quizGame.startGame();
    }
}
