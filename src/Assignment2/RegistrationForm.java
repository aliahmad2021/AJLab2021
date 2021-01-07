/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Ali
 */
public class RegistrationForm extends Application {
    
    private Label lblName;
    private TextField txtName;
    private Label lblEmail;
    private TextField txtEmail;
    private Label lblPhone;
    private TextField txtPhone;
    private Label lblPassword;
    private PasswordField txtPassword;
    private Label lblConfirm;
    private PasswordField txtConfirm;
    private Label lblCountry;
    private ChoiceBox selCountry;
    private Label lblGender;
    private RadioButton rMale;
    private RadioButton rFemale;
    private Label lblLanguages;
    private CheckBox chkArabic;
    private CheckBox chkEnglish;
    private CheckBox chkSpanish;
    private Label lblAboutYou;
    private TextArea taAboutYou;
    private Label lblMsg;
    private String msg;
    

    public void trim(TextField tf) {
        tf.setText(tf.getText().trim());
    }

    public boolean checkName() {
        trim(txtName);
        String name = txtName.getText();
        boolean isValid = true;
        if(name.equals("")){
            msg = msg + "Name cannot be empty\n";
            isValid = false;
        }
        for(int i=0; i<name.length(); i++){
            if(Character.isDigit(name.charAt(i))){
                msg = msg + "Name must not have digits\n";
                isValid = false;
                break;
            }
            if(!Character.isLetter(name.charAt(i))){
                msg = msg + "Invalid Name\n";
                isValid = false;
                break;
            }
        }
        return isValid;
    }
    

    public boolean checkEmail() {
        trim(txtEmail);
        String email = txtEmail.getText();
        boolean isValid = true;
        if(email.equals("")){
            msg = msg + "Email cannot be empty\n";
            isValid =  false;
        }
        else {
            boolean atTheRatePresent = false, dotPresent = false;
            for(int i=0; i<email.length(); i++){
                if(email.charAt(i) == '@')
                    atTheRatePresent = true;
                if(email.charAt(i) == '.')
                    dotPresent = true;
            }
            if(!atTheRatePresent || !dotPresent){
                msg = msg + "Invalid Email\n";
                isValid =  false;
            }
        }
        return isValid;
    }
    

    public boolean checkPhone() {
        trim(txtPhone);
        String phone = txtPhone.getText();
        boolean isValid = true;
        if(phone.length() != 8) {
            msg = msg + "Phone number should have 8 digits\n";
            isValid =  false;
        }
        else {
            for(int i=0; i<phone.length(); i++) {
                if(!Character.isDigit(phone.charAt(i))){
                    msg = msg + "Phone number should only contain digits\n";
                    isValid =  false;
                    break;
                }
            }
        }
        return isValid;
    }
    

    public boolean checkPassword() {
        boolean isValid = true;
        String password = txtPassword.getText();
        if(password.length()<8) {
            msg = msg + "Minimum password length is 8 characters\n";
            isValid =  false;
        }
        boolean digit = false, lower = false, upper = false;
        for(int i=0; i<password.length(); i++) {
            if(Character.isDigit(password.charAt(i)))
                digit = true;
            else if(Character.isLowerCase(password.charAt(i)))
                lower = true;
            else if(Character.isUpperCase(password.charAt(i)))
                upper = true;
        }
        if(!digit || !lower || !upper) {
            msg = msg + "Password should contain atleast one capital letter, one small letter and one digit\n";
            isValid = false;
        }
        return isValid;
    }

    public boolean checkConfirm() {
        String password = txtPassword.getText();
        String confirmPassword = txtConfirm.getText();
        if(password.equals(confirmPassword))
            return true;
        else {
            msg = msg + "Passwords don't match\n";
            return false;
        }
    }
    

    public boolean checkAboutYou() {
        boolean isValid = true;
        String aboutYou = taAboutYou.getText();
        taAboutYou.setText(aboutYou);
        if(aboutYou.length()<50) {
            msg = msg + "About You should contain 50 characters\n";
            isValid = false;
        }
        return isValid;
    }
    

    public boolean checkCountry() {
        boolean isValid = true;
        String country = (String)selCountry.getSelectionModel().getSelectedItem();
        if(country.equals("Select...")) {
            msg = msg + "Country not selected\n";
            isValid = false;
        }
        return isValid;
    }
    

    public boolean checkCountry(Integer i) {
        boolean isValid = true;
        if(i == 0) {
            msg = msg + "Country not selected\n";
            isValid = false;
        }
        return isValid;
    }
    
    @Override
    public void start(Stage primaryStage) {
        // Creating Label
        lblName = new Label("Name: ");
        lblName.setMinWidth(70);
        // Creating TextField
        txtName = new TextField();
        txtName.setMinWidth(300);        
        // Event Handling when text value changes 
        txtName.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                msg = "";
                checkName();
                lblMsg.setText(msg);
            }
        });
        
       lblEmail = new Label("Email: ");
       txtEmail = new TextField();
        txtEmail.setMinWidth(300);      
       txtEmail.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                msg = "";
                checkName();
                checkEmail();
                lblMsg.setText(msg);
            }
        });
        
        lblPhone = new Label("Phone: ");
        txtPhone = new TextField();
        txtPhone.setMinWidth(300);    
        txtPhone.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                msg = "";
                checkName();
                checkEmail();
                checkPhone();
                lblMsg.setText(msg);
            }
        });
        
        lblPassword = new Label("Password: ");
        txtPassword = new PasswordField();
        txtPassword.setMinWidth(300);  
        txtPassword.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                msg = "";
                checkName();
                checkEmail();
                checkPhone();
                checkPassword();
                lblMsg.setText(msg);
            }
        });
        lblConfirm = new Label("Confirm: ");
       txtConfirm = new PasswordField();
        txtConfirm.setMinWidth(300); 
        txtConfirm.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                msg = "";
                checkName();
                checkEmail();
                checkPhone();
                checkPassword();
                checkConfirm();
                lblMsg.setText(msg);
            }
        });
        
        lblCountry = new Label("Country: ");
        selCountry = new ChoiceBox(FXCollections.observableArrayList(
                "Select...", "USA", "China", "UK", "Lebanon", "Germany", "France", "Belgium", "Italy","Finland"));
        selCountry.getSelectionModel().selectFirst();
        selCountry.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                msg = "";
                checkName();
                checkEmail();
                checkPhone();
                checkPassword();
                checkConfirm();
                checkCountry((Integer) number2);
                lblMsg.setText(msg);
            }
        });
        
       lblGender = new Label("Gender: ");
        rMale = new RadioButton("Male"); 
        rFemale = new RadioButton("Female"); 
        
        lblLanguages = new Label("Languages: ");
       chkArabic = new CheckBox("Arabic"); 
        chkEnglish = new CheckBox("English"); 
        chkSpanish = new CheckBox("Spanish"); 
        
        lblAboutYou = new Label("About You: ");
        taAboutYou = new TextArea();
        taAboutYou.setText("Your Biography...");
        taAboutYou.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                msg = "";
                checkName();
                checkEmail();
                checkPhone();
                checkPassword();
                checkConfirm();
                checkCountry();
                checkAboutYou();
                lblMsg.setText(msg);
            }
        });
       
   
        lblMsg = new Label("");
      
        lblMsg.setTextFill(Color.web("#FF0000"));
        
      
        Alert regAlert = new Alert(AlertType.INFORMATION);
        
     
        Button btnRegister = new Button();
        btnRegister.setText("Register");
        btnRegister.setMinWidth(390);
        
        
  btnRegister.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                msg = "";
                checkName();
                checkEmail();
                checkPhone();
                checkPassword();
                checkConfirm();
                checkCountry();
                checkAboutYou();
                lblMsg.setText(msg);
                if(checkName()&& checkEmail() && checkPhone() && checkPassword()
                        && checkConfirm() && checkCountry() && checkAboutYou()) {
                    regAlert.setContentText("Successfully Registered");
                    regAlert.show();
                }
                
           
                
            }
        });
        
       
        GridPane root = new GridPane();
        
       
        root.setHgap(20);
      
        root.setVgap(12);
        
        int startCol = 3;
        int startRow = 2;
      
        root.add(lblName, startCol, startRow);
        root.add(txtName, startCol+1, startRow, 3, 1);
        root.add(lblEmail, startCol, startRow+1);
        root.add(txtEmail,startCol+1, startRow+1, 3, 1);
        root.add(lblPhone, startCol, startRow+2);
        root.add(txtPhone, startCol+1, startRow+2, 3, 1);
        root.add(lblPassword, startCol, startRow+3);
        root.add(txtPassword,startCol+1, startRow+3, 3, 1);
        root.add(lblConfirm, startCol, startRow+4);
        root.add(txtConfirm, startCol+1, startRow+4, 3, 1);
        root.add(lblCountry, startCol, startRow+5);
        root.add(selCountry, startCol+1, startRow+5, 3, 1);
        root.add(lblGender, startCol, startRow+6);
        root.add(rMale, startCol+1, startRow+6);
        root.add(rFemale, startCol+2, startRow+6);
        root.add(lblLanguages, startCol, startRow+7);
        root.add(chkArabic, startCol+1, startRow+7);
        root.add(chkEnglish, startCol+2, startRow+7);
        root.add(chkSpanish, startCol+3, startRow+7);
        root.add(lblAboutYou, startCol, startRow+8);
        root.add(taAboutYou, startCol+1, startRow+8, 3, 1);
        root.add(btnRegister, startCol,startRow+9 , 4, 1);
        root.add(lblMsg, startCol, startRow+11, 5, 6);
        
      
        Scene scene = new Scene(root, 520, 720);
        
     
        primaryStage.setTitle("Registration Form");
        
    
        primaryStage.setScene(scene);
        
      
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}