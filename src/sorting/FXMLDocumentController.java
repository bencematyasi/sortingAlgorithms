/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.net.URL;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 *
 * @author Bence
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private ListView<Integer> listInput;
    @FXML
    private ListView<Integer> listOutput;
    
    private Integer [] input = {4,7,2,9,20,51,1,0,8};
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
        listInput.setItems(FXCollections.observableArrayList(input));
        
    }    

    @FXML
    private void clickDoSort(ActionEvent event) {
        intersectionSort(input);
        listOutput.setItems(FXCollections.observableArrayList(input));
        
    }
    
    private void createGiantIntList()
    {
        input = new Integer[100_000];
        Random r = new Random();
        for (int i = 0; i < 100_000; i++) {
            input[i] = r.nextInt(200_000);
            
        }
    }
    
    public void bubbleSort(Integer[] list){
        long startTime = System.nanoTime();
        
        for (int i = 1; i < list.length; i++) {
            for (int j = 0; j < list.length-i; j++) {
                if(list[j] > list[j+1])
                {
                 int tmp = list[j];
                 list[j] = list[j+1];
                 list[j+1] = tmp;
                }
            }
            
        }
        long timeElapsed = System.nanoTime() - startTime;
        System.out.println(timeElapsed /1_000_000_000f);
    }
    public void selectionSort(Integer[] list)
    {
        long startTime = System.nanoTime();
        for (int i = 0; i < list.length-1; i++) {
            int minindex = i;
            for (int j = i + 1; j < list.length; j++) {
                if(list[j] < list[minindex])
                {
                    minindex = j;
                 
                }
            }
            int tmp = list[i];
                 list[i] = list[minindex];
                 list[minindex] = tmp;
        }
        long timeElapsed = System.nanoTime() - startTime;
        System.out.println(timeElapsed /1_000_000_000f);
    }
        
    public void intersectionSort(Integer[] list)
    {
        long startTime = System.nanoTime();
        for (int i = 1; i < list.length; i++)
        {
            int tmp = list[i];
            int holeIndex = i;
            
            while(holeIndex > 0 && list[holeIndex-1]>tmp)
            {
                list[holeIndex] = list[holeIndex-1];
                holeIndex--;
            }
            list[holeIndex] = tmp;
            
        }
        long timeElapsed = System.nanoTime() - startTime;
        System.out.println(timeElapsed /1_000_000_000);
    }
}
