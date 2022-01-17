package com.example.realEstate;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Captcha {

  @FXML
  Canvas dc;
  GraphicsContext gc;


  @FXML
    private void initialize(){
        Lines();
    }
    double up = 2;
    double pass = 2;
    double height = 190;
    double left = 36;
    double weight = 2;
    double newLine = left;


   private void Lines(){
      gc = dc.getGraphicsContext2D();
      gc.setFill(Color.BLACK);

      gc.fillRect (newLine,up,weight,height + 10);
      newLine = newLine + weight + pass;
      gc.fillRect(newLine ,up,weight,height + 10);
      newLine = newLine + weight + pass;
      String bar = Bar("123456", "5");
      int[] arr = Code(bar);
      for(int i = 0; i < 15; i++)
      {
          if(arr[i] == 0){
              weight =  2 * 2;
          }
          else {
              weight = arr[i] * 2;
              gc.fillRect(newLine, up, weight, height);
          }
          newLine = newLine + weight + pass;
      }
       gc.fillRect(newLine, up, 2, height + 10);
       newLine = newLine + 2 + pass;
       gc.fillRect(newLine, up, 2, height + 10);
       Text text = new Text();
       text.setText(bar);
       Font font = new Font("Arial", 14);
       text.setFont(font);
       gc.setFont(font);
       gc.fillText(text.getText(), left  , height + 25);

   }



   private int[] Code(String s){
       int[] arr = new int[s.length()];
       char[] array = s.toCharArray();
       for(int i = 0; i < s.length(); i++) {
           try{
               arr[i] = Character.getNumericValue(array[i]) ;
           }
            catch(Exception e)
           {
               for(int y = 0; y < s.length(); y++) {
                   {
                       arr[y] = 1;
                   }
               }
               System.out.println("Error, default data");

           }
       }
       return arr;
   }

   private String Bar(String unik, String lab){
       String bar = "";
      String date = new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime());
      bar = bar + date;
      bar = lab + bar + unik;
       System.out.println(bar);
      return bar;
   }
}
