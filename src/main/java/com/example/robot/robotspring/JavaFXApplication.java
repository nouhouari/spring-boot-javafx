package com.example.robot.robotspring;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * Normal JavaFX application class.
 * @author nhouari
 *
 */
public class JavaFXApplication extends Application {

  private ConfigurableApplicationContext applicationContext;

  @Override
  public void init() {
    // Create the spring context
    this.applicationContext = new SpringApplicationBuilder()
        .sources(SpringApplication.class)
        .run();
  }

  @Override
  public void stop() throws Exception {
    // Close JavaFX application
    Platform.exit();
    // Close Spring boot application context
    this.applicationContext.close();
    
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    // We can use the Spring pattern of publishing events via
    // the application context to signal when this Stage is ready
    applicationContext.publishEvent(new StageReadyEvent(primaryStage));
  }

}
