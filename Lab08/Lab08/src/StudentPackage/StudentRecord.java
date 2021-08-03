package StudentPackage;

public class StudentRecord {
    public String SID;
    public String Letter;
    public float Assignments;
    public float Midterm;
    public float FinalExam;
    public float FinalMark;
    public StudentRecord(String SID, float Assignments, float Midterm, float FinalExam){
        this.SID = SID;
        this.Assignments = Assignments;
        this.Midterm = Midterm;
        this.FinalExam = FinalExam;
        CalcFinal();
        CalcLetterGrade();
    }
    //getters
    public float getAssignments(){return Assignments;}
    public float getMidterm(){return  Midterm;}
    public float getFinalMark(){return FinalMark;}
    public float getFinalExam(){return FinalExam;}
    public String getLetter(){return Letter;}
    public String getSID(){return SID;}

    public void CalcFinal(){
        this.FinalMark = (0.2f*Assignments + 0.3f* Midterm + 0.5f* FinalExam);
    }

    public void CalcLetterGrade(){
        if(FinalMark >= 80.0){
            Letter = "A";
        }else if(FinalMark >= 70.0 && FinalMark < 80.0){
            Letter = "B";
        }else if(FinalMark >= 60.0 && FinalMark < 70.0){
            Letter = "C";
        }else if(FinalMark >= 50.0 && FinalMark < 60.0){
            Letter = "D";
        }else{
            Letter = "F";
        }
    }
}
