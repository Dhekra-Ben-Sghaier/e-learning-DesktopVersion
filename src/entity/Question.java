package entity;

public class Question {
    

    private Integer questionId;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    public void setQuiz(Quizz quiz) {
        this.quiz = quiz;
    }
    private Quizz quiz;

    public Quizz getQuiz() {
        return quiz;
    }

    
    

    public Question(Quizz quiz,Integer questionId, String question, String option1, String option2, String option3, String option4, int quizID) {
        this.quiz=quiz;
        this.questionId = questionId;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        
    }
    

    
   
    public Question(String question) {
        this.question = question;
    }

      

    
    
    
    public static class MetaData{
        public static final String TABLE_NAME = "question";
        public static final String OPTION1 = "option1";
        public static final String OPTION2 = "option2";
        public static final String OPTION3 = "option3";
        public static final String OPTION4 = "option4";
        public static final String REPONSE = "reponse";       
        public static final String QUIZ_ID = "quiz_id";   
    
    }
    

            
    
    public Question() {
    }

    public Question(String question, String option1, String option2, String option3, String option4) {
        
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        
    }
       

//    public void setQuiz(Quizz quiz) {
//        this.quiz = quiz;
//    }

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

    
    

//    public Quizz getQuiz() {
//        return quiz;
//    }

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

    
    
}
