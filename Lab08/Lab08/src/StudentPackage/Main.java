package StudentPackage;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.*;

public class Main extends Application {
    public static TableView<StudentRecord> students;
    public static ObservableList<StudentRecord> records = FXCollections.observableArrayList();
    public static String currentFileName = "outFile.csv";
    //start of text fields
    public TextField SID;
    public TextField Midterm;
    public TextField Assignments;
    public TextField finalExam;
    //Start of additional datatypes
    public Button add;
    public Label addResult;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Lab 8");
        BorderPane layout = new BorderPane();
        students = new TableView<>();
        //Start of Columns Code
        //SID
        TableColumn<StudentRecord, String> SIDCol = new TableColumn<>("SID");
        SIDCol.setPrefWidth(100);
        SIDCol.setCellValueFactory(new PropertyValueFactory<>("SID"));
        //Assignements
        TableColumn<StudentRecord, Float> AssignCol = new TableColumn<>("Assignments");
        AssignCol.setPrefWidth(100);
        AssignCol.setCellValueFactory(new PropertyValueFactory<>("Assignments"));
        //Midterm
        TableColumn<StudentRecord, Float> MidCol = new TableColumn<>("Midterm");
        MidCol.setPrefWidth(100);
        MidCol.setCellValueFactory(new PropertyValueFactory<>("Midterm"));
        //Final Exam
        TableColumn<StudentRecord, Float> ExamCol = new TableColumn<>("Final Exam");
        ExamCol.setPrefWidth(100);
        ExamCol.setCellValueFactory(new PropertyValueFactory<>("Final Exam"));
        //Final Mark
        TableColumn<StudentRecord, Float> MarkCol = new TableColumn<>("Final Mark");
        MarkCol.setPrefWidth(100);
        MarkCol.setCellValueFactory(new PropertyValueFactory<>("Final Mark"));
        //Letter Grade
        TableColumn<StudentRecord, String> LetterCol = new TableColumn<>("Letter");
        LetterCol.setPrefWidth(100);
        LetterCol.setCellValueFactory(new PropertyValueFactory<>("Letter"));

        records.add(new StudentRecord("100100100", 75.0f, 68.0f, 54.25f));
        records.add(new StudentRecord("100100101", 70.0f, 69.25f, 51.5f));
        records.add(new StudentRecord("100100102", 100.0f, 97.0f, 92.5f));
        records.add(new StudentRecord("100100103", 90.0f, 88.5f, 68.75f));
        records.add(new StudentRecord("100100104", 72.25f, 74.75f, 58.25f));
        records.add(new StudentRecord("100100105", 85.0f, 56.0f, 62.5f));
        records.add(new StudentRecord("100100106", 70.0f, 66.5f, 61.75f));
        records.add(new StudentRecord("100100107", 55.0f, 47.0f, 50.5f));
        records.add(new StudentRecord("100100108", 40.0f, 32.5f, 27.75f));
        records.add(new StudentRecord("100100109", 82.5f, 77.0f, 74.25f));

        students.setItems(records);

        students.getColumns().add(SIDCol);
        students.getColumns().add(AssignCol);
        students.getColumns().add(MidCol);
        students.getColumns().add(ExamCol);
        students.getColumns().add(MarkCol);
        students.getColumns().add(LetterCol);
        //forms SID
        this.SID = new TextField();
        this.SID.setPromptText("SID");
        //forms Assignments
        this.Assignments = new TextField();
        this.Assignments.setPromptText("Assignment Mark");
        //forms Midterm
        this.Midterm = new TextField();
        this.Midterm.setPromptText("Midterm Mark");
        //forms Final Exam
        this.finalExam = new TextField();
        this.finalExam.setPromptText("Final Exam Mark");

        this.add = new Button("Add record");
        this.add.setOnAction(event -> {
            addStudent();
            clearTextFields();
        });
        addResult = new Label("");
        GridPane bottom = new GridPane();
        bottom.setPadding(new Insets(10));
        bottom.setHgap(10);
        bottom.setVgap(10);
        //SID textfield
        bottom.add(new Label("SID"), 0, 0);
        bottom.add(SID, 1, 0);
        //assignments
        bottom.add(new Label("Assignments"), 2, 0);
        bottom.add(Assignments, 3, 0);
        //Midterm
        bottom.add(new Label("Midterm"), 0, 1);
        bottom.add(Midterm,1,1);
        //final Exam
        bottom.add(new Label("Final Exam"), 2, 1);
        bottom.add(finalExam, 3, 1);
        //button
        bottom.add(add,1,3);
        bottom.add(addResult,2,3);

        VBox topBox = new VBox();
        MenuBar menuBar = new MenuBar();
        topBox.getChildren().add(menuBar);

        Menu menuFile = new Menu("File");
        MenuItem newFile = new MenuItem("New");

        newFile.setOnAction((EventHandler<ActionEvent>) event -> students.getItems().clear());
        MenuItem openFile = new MenuItem("Open");

        openFile.setOnAction((EventHandler<ActionEvent>) event -> {
            FileChooser fc = new FileChooser();
            fc.setInitialDirectory(new File("."));
            fc.setTitle("Choose a File");
            fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV files", "*.csv"));

            File fil = fc.showOpenDialog(primaryStage);
            if(fil != null){
                currentFileName = fil.getName();
                handleOpen(fil);
            }
        });
        MenuItem saveFile = new MenuItem("Save");
        saveFile.setOnAction((EventHandler<ActionEvent>) event -> {
            try {
                saveMethod();
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        MenuItem saveAsFile = new MenuItem("Save As");
        saveAsFile.setOnAction((EventHandler<ActionEvent>) event -> {
            FileChooser fc = new FileChooser();
            fc.setInitialDirectory(new File("."));
            fc.setTitle("Save As");
            fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(".csv", "*.csv"));

            File fil = fc.showSaveDialog(primaryStage);
            if (fil != null){
                currentFileName = fil.getName();
                try{
                    saveMethod();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        MenuItem exitFile = new MenuItem("Exit");
        exitFile.setOnAction((EventHandler<ActionEvent>) event -> System.exit(0));
        menuFile.getItems().addAll(newFile, openFile, saveFile, saveAsFile, exitFile);
        menuBar.getMenus().addAll(menuFile);

        layout.setCenter(students);
        layout.setTop(topBox);
        layout.setBottom(bottom);

        Scene scene = new Scene(layout, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
        //end
    }
    public void clearTextFields(){
        this.SID.setText("");
        this.Assignments.setText("");
        this.Midterm.setText("");
        this.finalExam.setText("");
    }
    public boolean addStudent(){
        String id = SID.getText();
        float assignments;
        float midterm;
        float examFinal;
        if (id.equals("")){
            assignments = 0.0f;
            midterm = 0.0f;
            examFinal = 0.0f;
            return false;
        }else if(Assignments.getText().equals("")){
            assignments = 0.0f;
            midterm = 0.0f;
            examFinal = 0.0f;
            return false;
        }else if(Midterm.getText().equals("")){
            assignments = 0.0f;
            midterm = 0.0f;
            examFinal = 0.0f;
            return false;
        }else if(finalExam.getText().equals("")){
            assignments = 0.0f;
            midterm = 0.0f;
            examFinal = 0.0f;
            return false;
        }else{
            assignments = Float.parseFloat(Assignments.getText());
            midterm = Float.parseFloat(Midterm.getText());
            examFinal = Float.parseFloat(finalExam.getText());
            this.addResult.setText("Record Added");
        }
        StudentRecord newStudent = new StudentRecord(id, assignments, midterm, examFinal);
            records.add(newStudent);
            return true;
    }
    public static void handleOpen(File f){
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            students = new TableView<>();
            records.clear();
            int counter = 0;
            String row;
            while((row = br.readLine()) != null){
                if(counter == 1){
                    String[] data = row.split(",");
                    StudentRecord student = new StudentRecord(data[0],
                            Float.valueOf(data[1]),Float.valueOf(data[2]), Float.valueOf(data[3]));
                        records.add(student);
                }
                counter++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        students.setItems(records);
    }
    public void saveMethod(){
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileOutputStream(currentFileName));
            String titles = "SID" + "," + "Assignments" + "," + "Midterm" + "," + "Final Exam";
            out.println(titles);
            for(StudentRecord record : records){
                String row = record.getSID() + "," + record.getAssignments() + "," + record.getMidterm() + "," + record.getFinalExam();
                out.println(row);
            }
            out.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}