/**
 * 
 */
package com.example.robot.robotspring;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author nhouari
 *
 */
@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent>{

  @Override
  public void onApplicationEvent(StageReadyEvent event) {
    // Notification with the application event
    createStage(event.getStage());
  }
  
  /**
   * Initialize the stage.
   * @param primaryStage
   */
  private void createStage(Stage primaryStage) {
    primaryStage.setTitle("Hello, Robot Framework!");

    VBox vBox = new VBox();

    // Line 1
    HBox hbox1 = new HBox();
    Button button = new Button("Click");
    TextField text = new TextField();
    text.setId("message");
    Button anotherButton = new Button("Ok");
    anotherButton.setId("another");
    button.setId("bt1");
    button.setOnMouseClicked((e) -> text.setText("clicked"));
    hbox1.getChildren().add(button);
    hbox1.getChildren().add(text);
    hbox1.getChildren().add(anotherButton);

    // Line 2
    HBox hbox2 = new HBox();
    ComboBox<String> comboBox = new ComboBox<String>();
    comboBox.setId("comboBox");
    comboBox.getItems().add("Choice 1");
    comboBox.getItems().add("Choice 2");
    comboBox.getItems().add("Choice 3");
    TextField value = new TextField();
    value.setId("value");
    comboBox.setOnAction((e) -> value.setText(comboBox.getValue().toString()));
    hbox2.getChildren().add(comboBox);
    hbox2.getChildren().add(value);

    // Line 3
    HBox hbox3 = new HBox();
    CheckBox checkBox1 = new CheckBox("Green");
    checkBox1.setId("checkBox");
    TextField cbvalue = new TextField();
    cbvalue.setId("cbValue");
    checkBox1.setOnAction((e) -> cbvalue.setText(Boolean.toString(checkBox1.isSelected())));
    hbox3.getChildren().add(checkBox1);
    hbox3.getChildren().add(cbvalue);

    vBox.getChildren().add(hbox1);
    vBox.getChildren().add(hbox2);
    vBox.getChildren().add(hbox3);

    Scene scene = new Scene(vBox, 300, 200);
    primaryStage.setScene(scene);
    primaryStage.sizeToScene();
    primaryStage.show();
  }
}
