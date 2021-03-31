package entity;

public class Question {
    

    private Integer questionId;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String reponse;
    private int quiz;
    
    @Override
    public String toString() {
        return this.question;
    }
    
    public Question() {
    }

    public Question(String question, String option1, String option2, String option3, String option4, String reponse, int quiz) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.reponse = reponse;
        this.quiz = quiz;
    }

    public Question(String question, String option1, String option2, String option3, String option4, int quiz) {
        this.quiz=quiz;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        
    }

    public Question(String question) {
        this.question = question;
    }
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }


    public Integer getQuestionId() {
        return questionId;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }
    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getReponse() {
        return reponse;
    }   

    public void setQuiz(int quiz) {
        this.quiz = quiz;
    }
    public int getQuiz() {
        return quiz;
    }
    
    
}
