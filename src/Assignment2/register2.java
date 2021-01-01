
package Assignment2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 *
 * @author Ali
 */


public class register2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = createGridPane();
    HBox gender = Hbox1();
    HBox lang = Hbox2();
    HBox about = Hbox3();
    HBox reg = Hbox4();



VBox vbox= new VBox();
vbox.setPadding(new Insets(25));
vbox.getChildren().addAll(gridPane, gender, lang, about, reg);
vbox.setStyle("-fx-border-color: blue;");
Scene scene = new Scene(vbox);
primaryStage.setScene(scene);
primaryStage.setTitle("Registration Form");
primaryStage.show();

    }
    
    public static void main (String[] args){
        launch(args);
    }
    
    private GridPane createGridPane(){
        Label label1 = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        Label label5 = new Label();
    
        label1.setTextFill(Color.RED);
        label2.setTextFill(Color.RED);
        label3.setTextFill(Color.RED);
        label4.setTextFill(Color.RED);
        label5.setTextFill(Color.RED);
      
        
        Label name = new Label("Name:");
        Label email = new Label("Email:");
        Label phone = new Label("Phone:");
        Label password = new Label("Password:");
        Label confirm = new Label("Confirm:");
        Label country = new Label("Country:");

        TextField txt1 = new TextField();
        txt1.setPromptText("Please enter your name");
        TextField txt2 = new TextField();
        txt2.setPromptText("Please enter your email");
        TextField txt3 = new TextField();
        txt3.setPromptText("Please enter your phone number");
        PasswordField pf1 = new PasswordField();
        pf1.setPromptText("Please enter your Password");
        PasswordField pf2 = new PasswordField();
        pf2.setPromptText("Please reenter your Password");
        
        ComboBox<String> cb = new ComboBox<String>();
        cb.getItems().addAll("select...", "USA", "China", "UK", "Lebanon", "Germany", "France");
        cb.getSelectionModel().select(0);
        
        
        txt1.setOnAction(e -> textAlphabet(txt1, label1, "Letters Only"));
        txt2.setOnAction(e -> emailFormat(txt2, label2, "Invalid Email"));
        txt3.setOnAction(e -> number(txt3, label3,"Phone number must be 8 digits length"));
        pf1.setOnAction(e -> checkstring(pf1, label4, "Contains at least one capital letter, one small letter, one digit and minimum\n" +
"length is 8"));
        pf2.setOnAction(e -> matching(pf1, pf2, label4, "Not Matching"));
        cb.setOnAction(e -> comboSelect(cb, label5, "Must be selected"));
       
      
        txt1.setPrefColumnCount(20);
        txt2.setPrefColumnCount(20);
        txt3.setPrefColumnCount(20);
        pf1.setPrefColumnCount(20);
        pf2.setPrefColumnCount(20);
        

        GridPane gp1 = new GridPane();
        gp1.add(name,0,0);
        gp1.add(email,0,1);
        gp1.add(phone,0,2);
        gp1.add(password,0,3);
        gp1.add(confirm,0,4);
        gp1.add(country,0,5);
        gp1.add(label1,1,6);
        gp1.add(label2,1,7);
        gp1.add(label3,1,8);
        gp1.add(label4,1,9);
        gp1.add(label5,1,10);
      
        gp1.add(txt1,1,0);
        gp1.add(txt2,1,1);
        gp1.add(txt3,1,2);
        gp1.add(pf1,1,3);
        gp1.add(pf2,1,4);
        gp1.add(cb, 1, 5);
        
        gp1.setHgap(20);
        gp1.setVgap(10);
        
      
    
        return gp1;
    }
    private HBox Hbox1(){
        Label label6 = new Label("Gender:");
        
        
        RadioButton rb1 = new RadioButton("Male");
        RadioButton rb2 = new RadioButton("Female");
        
    final ToggleGroup tg = new ToggleGroup(); 
    rb1.setToggleGroup(tg);
    rb2.setToggleGroup(tg);

        HBox hbox1 = new HBox(20);
        hbox1.getChildren().addAll(label6, rb1, rb2);
        rb1.setPadding(new Insets(0, 0, 0,12));
      hbox1.setPadding(new Insets(20,0,20,0));
        return hbox1;
        
    }
    private HBox Hbox2(){
        Label label7 = new Label("Language:");
        CheckBox check1 = new CheckBox("Arabic");
        CheckBox check2 = new CheckBox("English");
        CheckBox check3 = new CheckBox("Spanish");
        
        HBox hbox2 = new HBox(20);
        hbox2.getChildren().addAll(label7, check1, check2, check3);
       hbox2.setPadding(new Insets(20,0,20,0));
        return hbox2;
    }
    private HBox Hbox3(){
        Label label8 = new Label("About you:");
        label8.setPadding(new Insets(38, 0, 0, 0));
        TextArea tb = new TextArea();
        tb.setPromptText("Your Biography...");
        tb.setMaxWidth(230);
        tb.setPrefHeight(100);
       HBox hbox3 = new HBox(20);
       hbox3.getChildren().addAll(label8, tb);

           hbox3.setPadding(new Insets(20,0,20,0));
    return hbox3;
    
    }
    
    private HBox Hbox4(){
        Button btn = new Button("Register");
        HBox hbox4 = new HBox();
        hbox4.getChildren().add(btn);
        hbox4.setAlignment(Pos.CENTER);
            hbox4.setPadding(new Insets(20,0,20,0));
            btn.setStyle("-fx-border-color: blue;");
            btn.setPrefWidth(320);   
            
             btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
               
                 JOptionPane.showMessageDialog(null,"Successfully Registered");
            }
        });
            
        return hbox4;
    }

     public static boolean textAlphabet(TextField inputTextField, Label inputLabel, String validationText) {
        boolean isAlphabet = true;
        String validationString = null;

        if (!inputTextField.getText().matches("[a-z A-Z]+")) {
            isAlphabet = false;
            validationString = validationText;

        }
        inputLabel.setText(validationString);

        System.out.println(inputTextField.getText().matches("[a-z A-Z]+"));
        return isAlphabet;
} 
    
    
    
      public static boolean emailFormat(TextField inputTextField, Label inputLabel, String validationText) {
        boolean isEmail = true;
        String validationString = null;

        if (!inputTextField.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com")) {
            isEmail = false;
            validationString = validationText;

        }
        inputLabel.setText(validationString);
        System.out.println(inputTextField.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com"));
        return isEmail;

    }
      public static boolean number(TextField inputTextField, Label inputLabel, String validationText) {
        boolean isnumber = true;
        String validationString = null;

        if (!inputTextField.getText().matches("[0-9]{8}")) {
            isnumber = false;
            validationString = validationText;

        }
        inputLabel.setText(validationString);
System.out.println(inputTextField.getText().matches("[0-9]{8}"));
        return isnumber;

    }
       public static boolean matching(TextField inputTextField,TextField input2, Label inputLabel, String validationText){
           boolean isMatching = true;
           String validationString = null;
           
           if(inputTextField.getText().compareTo(input2.getText()) != 0){
               isMatching = false;
               validationString = validationText;
           }
           inputLabel.setText(validationString);
           return isMatching;
           
           }
       
         private boolean checkstring(TextField inputTextField, Label inputLabel, String validationText) { 
        boolean checkstring = true;
        String validationString = null;

        if (!inputTextField.getText().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$")) {
            checkstring = false;
            validationString = validationText;

        }
        inputLabel.setText(validationString);

        System.out.println(inputTextField.getText().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$"));
        return checkstring;
    }
             public static boolean comboSelect(ComboBox b, Label inputLabel, String validationText){
           boolean isSelected = true;
           String validationString = null;
           
           if (b.getSelectionModel().getSelectedIndex()==0){
               isSelected = false;
               validationString = validationText;
           }
           inputLabel.setText(validationString);
           return isSelected;
           
           }
             
                          
                          
 
        
    }   
 