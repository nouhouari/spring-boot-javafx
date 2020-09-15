package com.example.robot.robotspring;

import org.springframework.context.ApplicationEvent;

import javafx.stage.Stage;

class StageReadyEvent extends ApplicationEvent {
  /**
   * 
   */
  private static final long serialVersionUID = 6120266366889287781L;

  public StageReadyEvent(Stage stage) {
    super(stage);
  }

  public Stage getStage() {
    return ((Stage) getSource());
  }

}