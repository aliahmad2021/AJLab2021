/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.*;
import javafx.scene.layout.*; 
import javafx.geometry.*; 

/**
 *
 * @author Ali
 */
public class HomeScreen extends Application {
   BackgroundImage bgImg;
   @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Home Screen");
        
        
      InputStream stream1 = new FileInputStream("C:\\Users\\Ali\\Documents\\NetBeansProjects\\AJLab2021\\src\\Assignment3\\slide0.jpg");
      InputStream stream2 = new FileInputStream("C:\\Users\\Ali\\Documents\\NetBeansProjects\\AJLab2021\\src\\Assignment3\\slide1.jpg");
      InputStream stream3 = new FileInputStream("C:\\Users\\Ali\\Documents\\NetBeansProjects\\AJLab2021\\src\\Assignment3\\slide2.jpg");
      InputStream stream4 = new FileInputStream("C:\\Users\\Ali\\Documents\\NetBeansProjects\\AJLab2021\\src\\Assignment3\\slide3.jpg");
      InputStream stream5 = new FileInputStream("C:\\Users\\Ali\\Documents\\NetBeansProjects\\AJLab2021\\src\\Assignment3\\slide4.jpg");
      InputStream stream6 = new FileInputStream("C:\\Users\\Ali\\Documents\\NetBeansProjects\\AJLab2021\\src\\Assignment3\\slide5.jpg");
      InputStream stream7 = new FileInputStream("C:\\Users\\Ali\\Documents\\NetBeansProjects\\AJLab2021\\src\\Assignment3\\slide6.jpg");
      InputStream stream8 = new FileInputStream("C:\\Users\\Ali\\Documents\\NetBeansProjects\\AJLab2021\\src\\Assignment3\\slide7.jpg");
      InputStream stream9 = new FileInputStream("C:\\Users\\Ali\\Documents\\NetBeansProjects\\AJLab2021\\src\\Assignment3\\slide8.jpg");
      InputStream stream10 = new FileInputStream("C:\\Users\\Ali\\Documents\\NetBeansProjects\\AJLab2021\\src\\Assignment3\\slide9.jpg");
      Image image1 = new Image(stream1);
      Image image2 = new Image(stream2);
      Image image3 = new Image(stream3);
      Image image4 = new Image(stream4);
      Image image5 = new Image(stream5);
      Image image6 = new Image(stream6);
      Image image7 = new Image(stream7);
      Image image8 = new Image(stream8);
      Image image9 = new Image(stream9);
      Image image10 = new Image(stream10);
          
          
          
        ImageView imageView = new ImageView();
        
      
       
         imageView.setOpacity(0.25);   
        
      

        
       Button btn1 = new Button("Sign In");
         btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                try{
           Login s = new Login();
           Stage stage = new Stage();
           s.start(stage);
            stage.show();
            primaryStage.close();
        }catch(Exception err){}
  
            }
        });
     Button btn2 = new Button("Sign Up");
        
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                try{
           RegistrationForm s = new RegistrationForm();
           Stage stage = new Stage();
           s.start(stage);
            stage.show();
            primaryStage.close();
        }catch(Exception err){}
  
            }
        });
        // Button btn3 = new Button("ImageViewTimeLine");
        
        
          // btn3.setOnAction(new EventHandler<ActionEvent>() {

            // @Override
            // public void handle(ActionEvent e) {
                // try{
           // ImageViewTimeLine s = new ImageViewTimeLine();
           // Stage stage = new Stage();
           // s.start(stage);
            // stage.show();
            // primaryStage.close();
        // }catch(Exception err){}
  
            // }
        // });
        
        

        btn1.setStyle("-fx-font-size: 2em; ");
        btn2.setStyle("-fx-font-size: 2em; ");
   //     btn3.setStyle("-fx-font-size: 2em; ");

         HBox hbox = new HBox(btn1, btn2);
         hbox.setPadding(new Insets(15, 12, 15, 12));
    hbox.setSpacing(10);
        imageView.setOpacity(0.25);   
          Timeline timeline = new Timeline(
                  
                new KeyFrame(Duration.ZERO, new EventHandler<ActionEvent>(){
                       
                    @Override
                        public void handle(ActionEvent t) {
                            bgImg  = new BackgroundImage(image1, 
    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
    BackgroundPosition.DEFAULT, 
    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
                              imageView.setOpacity(0.25);   
    Background background = new Background(bgImg);
      imageView.setOpacity(0.25);   
            hbox.setBackground(background); 
              imageView.setOpacity(0.25);   
                        }
                        
                    }),
                new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent t) {
                            bgImg  = new BackgroundImage(image2, 
    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
    BackgroundPosition.DEFAULT, 
    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
    Background background = new Background(bgImg);
      imageView.setOpacity(0.25);   
            hbox.setBackground(background); 
                        }
                    }),
                new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent t) {
                            bgImg  = new BackgroundImage(image3, 
    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
    BackgroundPosition.DEFAULT, 
    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
    Background background = new Background(bgImg);
            hbox.setBackground(background); 
                        }
                    }),
               new KeyFrame(Duration.seconds(3), new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent t) {
                            bgImg  = new BackgroundImage(image4, 
    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
    BackgroundPosition.DEFAULT, 
    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
    Background background = new Background(bgImg);
            hbox.setBackground(background); 
                        }
                    }),
               new KeyFrame(Duration.seconds(4), new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent t) {
                            bgImg  = new BackgroundImage(image5, 
    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
    BackgroundPosition.DEFAULT, 
    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
    Background background = new Background(bgImg);
            hbox.setBackground(background); 
                        }
                    }),
                new KeyFrame(Duration.seconds(5), new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent t) {
                            bgImg  = new BackgroundImage(image6, 
    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
    BackgroundPosition.DEFAULT, 
    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
    Background background = new Background(bgImg);
            hbox.setBackground(background); 
                        }
                    }),
               
                   new KeyFrame(Duration.seconds(6), new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent t) {
                            bgImg  = new BackgroundImage(image7, 
    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
    BackgroundPosition.DEFAULT, 
    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
    Background background = new Background(bgImg);
            hbox.setBackground(background); 
                        }
                    }),
                   new KeyFrame(Duration.seconds(7), new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent t) {
                            bgImg  = new BackgroundImage(image7, 
    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
    BackgroundPosition.DEFAULT, 
    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
    Background background = new Background(bgImg);
            hbox.setBackground(background); 
                        }
                    }),
                  
                  new KeyFrame(Duration.seconds(8), new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent t) {
                            bgImg  = new BackgroundImage(image8, 
    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
    BackgroundPosition.DEFAULT, 
    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
    Background background = new Background(bgImg);
            hbox.setBackground(background); 
                        }
                    }),
                  new KeyFrame(Duration.seconds(9), new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent t) {
                            bgImg  = new BackgroundImage(image9, 
    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
    BackgroundPosition.DEFAULT, 
    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
    Background background = new Background(bgImg);
            hbox.setBackground(background); 
                        }
                    }),
                  new KeyFrame(Duration.seconds(10), new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent t) {
                            bgImg  = new BackgroundImage(image10, 
    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
    BackgroundPosition.DEFAULT, 
    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
    Background background = new Background(bgImg);
            hbox.setBackground(background); 
                        }
                    })
                );
                     
        timeline.setCycleCount(timeline.INDEFINITE);
        timeline.play();
       

            // create Background 
            
            // set background 
            
    
        Scene scene = new Scene(hbox,800, 600);
    
        hbox.setAlignment(Pos.CENTER);
           
        primaryStage.setScene(scene);
        primaryStage.show();
       
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}