/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import javafx.application.Application;
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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Ali
 */


public class register extends Application {

    TextField txt1;
    
    @Override
    public void start(Stage primaryStage) throws Exception {

GridPane gridPane = createGridPane();

Scene scene = new Scene(gridPane);

primaryStage.setScene(scene);
primaryStage.setTitle("Registration Form");
primaryStage.show();

    }
    
    public static void main (String[] args){
        launch(args);
    }

    private GridPane createGridPane(){
        Label labelA = new Label();
        Label labelB = new Label();
        Label labelC = new Label();
        Label labelD = new Label();
        Label labelE = new Label();
        Label labelF = new Label();
            
        
        labelA.setTextFill(Color.RED);
        labelB.setTextFill(Color.RED);
        labelC.setTextFill(Color.RED);
        labelD.setTextFill(Color.RED);
        labelE.setTextFill(Color.RED);
        labelF.setTextFill(Color.RED);
        
        
                
        Label name = new Label("Name:");
        Label email = new Label("Email:");
        Label phone = new Label("Phone:");
        Label password = new Label("Password:");
        Label confirm = new Label("Confirm:");
        Label country = new Label("Country:");

        txt1 = new TextField();
        txt1.setPromptText("Please enter your name");
        TextField txt2 = new TextField();
        txt2.setPromptText("Please enter your email");
        TextField txt3 = new TextField();
        txt3.setPromptText("Please enter your phone number");
        PasswordField pf1 = new PasswordField();
        pf1.setPromptText("Please enter your Password");
        PasswordField pf2 = new PasswordField();
        pf2.setPromptText("Please reenter your Password");
         
    
        txt1.setOnAction(e -> textAlphabet(txt1,labelA));
        txt2.setOnAction(e -> emailFormat(txt2, labelB, "Invalid Email"));
        txt3.setOnAction(e -> zID(txt3, labelC,"Phone number must be 8 digits length"));
        pf2.setOnAction(e -> matching(pf1, pf2, labelD, "Not Matching"));
        txt1.setPrefColumnCount(20);
        txt2.setPrefColumnCount(20);
        txt3.setPrefColumnCount(20);
        pf1.setPrefColumnCount(20);
        pf2.setPrefColumnCount(20);
        
        
        
        
        ComboBox<String> cb = new ComboBox<String>();
        cb.getItems().addAll("select...", "USA", "China", "UK", "Lebanon", "Germany", "France", "Belgium", "Italy","Finland");
        cb.getSelectionModel().select(0);
        
        cb.setOnAction(e -> comboSelect(cb, labelE, "Country is not  selected"));
        
        GridPane gp1 = new GridPane();
     
        gp1.add(name,0,0);
        gp1.add(email,0,1);
        gp1.add(phone,0,2);
        gp1.add(password,0,3);
        gp1.add(confirm,0,4);
        gp1.add(country,0,5);
        
 
        gp1.add(txt1,1,0);
        gp1.add(txt2,1,1);
        gp1.add(txt3,1,2);
        gp1.add(pf1,1,3);
        gp1.add(pf2,1,4); 
        gp1.add(cb, 1, 5);
        
        HBox gender=firstHbox();
        HBox lang=secondHbox();
        HBox about=thirdHbox();
        HBox r=fourthHbox(labelA);
        
        gp1.add(gender, 0, 6);
        
        gp1.add(lang, 0, 7);
        
        gp1.add(r, 0, 8);
        
        
        gp1.add(labelA,0,9);
        gp1.add(labelB,0,10);
        gp1.add(labelC,0,11);
        gp1.add(labelD,0,12);
        gp1.add(labelE,0,13);
        gp1.add(labelF,0,14);
        
        gp1.setHgap(20);
        gp1.setVgap(10);
        gp1.setAlignment(Pos.CENTER);
        return gp1;
    }
    private HBox firstHbox(){
        Label label6 = new Label("Gender:");
        
        
        RadioButton rb1 = new RadioButton("Male");
        RadioButton rb2 = new RadioButton("Female");
        
    final ToggleGroup tg = new ToggleGroup(); 
    rb1.setToggleGroup(tg);
    rb2.setToggleGroup(tg);

        HBox hbox1 = new HBox(20);
       hbox1.setAlignment(Pos.CENTER);
        hbox1.getChildren().addAll(label6, rb1, rb2);
        rb1.setPadding(new Insets(0, 0, 0,12));
      hbox1.setPadding(new Insets(20,0,20,0));
        return hbox1;
        
    }
    private HBox secondHbox(){
        Label label7 = new Label("Language:");
        CheckBox check1 = new CheckBox("Arabic");
        CheckBox check2 = new CheckBox("English");
        CheckBox check3 = new CheckBox("Spanish");
        
        HBox hbox2 = new HBox(20);
        hbox2.setAlignment(Pos.CENTER);
        hbox2.getChildren().addAll(label7, check1, check2, check3);
       hbox2.setPadding(new Insets(20,0,20,0));
        return hbox2;
    }
    private HBox thirdHbox(){
        Label label8 = new Label("About you:");
        label8.setPadding(new Insets(38, 0, 0, 0));
        TextArea tb = new TextArea("Your Biography...");
        //tb.setPrefColumnCount(18);
        tb.setMaxWidth(230);
        tb.setPrefHeight(100);
       HBox hbox3 = new HBox(20);
       hbox3.getChildren().addAll(label8, tb);
       //hbox3.setAlignment(Pos.CENTER);
           hbox3.setPadding(new Insets(20,0,20,0));
    return hbox3;
    
    }
    
    private HBox fourthHbox(Label l){
        Button bt = new Button("Register");
        HBox hbox4 = new HBox();
        hbox4.getChildren().add(bt);
        hbox4.setAlignment(Pos.CENTER);
            hbox4.setPadding(new Insets(20,0,20,0));
            bt.setStyle("-fx-border-color: blue;");
            bt.setPrefWidth(320);
            bt.setOnMouseClicked(e -> {
                if(textAlphabet(txt1,l))
                    System.out.println("True");
                else System.out.println("False");
            });
        return hbox4;
    }
    
  private boolean isInt(TextField input, String message){
        try{
            int phoneNumber = Integer.parseInt(input.getText());
             System.out.println("Good");
            return true;
        }
         
    catch(NumberFormatException e){
    System.out.println("error");
    return false;
}
}
   
     public static boolean textAlphabet(TextField inputTextField,Label l) {
        if (!inputTextField.getText().matches("[a-z A-Z]+")) {
            l.setText("Invalid Name");
            return false;
        }
        return true;
} 
    
    
    
      public static boolean emailFormat(TextField inputTextField, Label inputLabel, String validationText) {
        boolean isEmail = false;
        String validationString = null;

        if (!inputTextField.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com")) {
            isEmail = true;
            validationString = validationText;

        }
        inputLabel.setText(validationString);
        System.out.println(inputTextField.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com"));
        return isEmail;

    }
      public static boolean zID(TextField inputTextField, Label inputLabel, String validationText) {
        boolean isZID = true;
        String validationString = null;

        if (!inputTextField.getText().matches("[0-9]{8}")) {
            isZID = false;
            validationString = validationText;

        }
        inputLabel.setText(validationString);
        System.out.println(inputTextField.getText().matches("[0-9]{8}"));
        return isZID;

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
  


