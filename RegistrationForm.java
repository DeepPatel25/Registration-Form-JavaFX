package com.example.javafx.RegistrationForm;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.regex.Pattern;

public class RegistrationForm extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Using GridPane for Scene1
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER); // Setting pane's Alignment
        pane.setHgap(5);    // Setting Gap between Rows
        pane.setVgap(5);    // Setting Gap Between Columns

        // Creating Label and TextField for FirstName
        Label fName = new Label("First Name");
        TextField fNameText = new TextField();
        pane.add(fName, 1, 0);
        pane.add(fNameText, 2, 0);

        // Creating Label and TextField for MiddleName
        Label mName = new Label("Middle Name");
        TextField mNameText = new TextField();
        pane.add(mName, 1,1);
        pane.add(mNameText, 2, 1);

        // Creating Label and TextField for LastName
        Label lName = new Label("Last Name");
        TextField lNameText = new TextField();
        pane.add(lName, 1,2);
        pane.add(lNameText, 2, 2);

        // Creating Label and TextField for EmailAddress
        Label email = new Label("Email Address");
        TextField emailText = new TextField();
        pane.add(email, 1, 3);
        pane.add(emailText,2,3);

        // Creating Label and TextField for MobileNumber
        Label mNumber = new Label("Mobile Number");
        TextField mNumberText = new TextField();
        pane.add(mNumber,1,4);
        pane.add(mNumberText, 2, 4);

        // Create a ComboBox for DateOfBirth
        Label DOB = new Label("Date of Birth");
        Label Day = new Label("Day");
        Label Month = new Label("Month");
        Label Year = new Label("Year");
        String[] days = {"1","2","3","4","5","6","7","8","9","10","11","12",
                "13","14","15","16","17","18","19","20","21","22",
                "23","24","25","26","27","28","29","30","31"};
        String[] months = {"January","February","March","April","May","June",
                "July","August","September","October","November","December"};
        String[] year = {"1995", "1996","1997","1998","1999","2000","2001","2002","2003","2004","2005"};
        ComboBox comboBoxDay = new ComboBox(FXCollections.observableArrayList(days));
        ComboBox comboBoxMonth = new ComboBox(FXCollections.observableArrayList(months));
        ComboBox comboBoxYear = new ComboBox(FXCollections.observableArrayList(year));
        pane.add(DOB,1,5);
        pane.add(Day,1,6);
        pane.add(comboBoxDay, 2, 6);
        pane.add(Month,1,7);
        pane.add(comboBoxMonth, 2, 7);
        pane.add(Year,1,8);
        pane.add(comboBoxYear, 2, 8);

        // Create a Radio Button for Gender
        Label gender = new Label("Gender");
        RadioButton rbMale = new RadioButton("Male");
        RadioButton rbFemale = new RadioButton("Female");
        ToggleGroup group = new ToggleGroup();
        rbMale.setToggleGroup(group);
        rbFemale.setToggleGroup(group);
        pane.add(gender, 1,9);
        pane.add(rbMale, 2, 9);
        pane.add(rbFemale, 2, 10);

        // Create a Language known option by using CheckBox Class
        Label language = new Label("Language");
        CheckBox hindi = new CheckBox("Hindi");
        CheckBox gujarati = new CheckBox("Gujarati");
        CheckBox english = new CheckBox("English");
        pane.add(language, 1, 11);
        pane.add(hindi, 2, 11);
        pane.add(gujarati, 2, 12);
        pane.add(english, 2, 13);

        // Create a Submit and Cancel Button for Submitting the data and Cancel button for Clear the Data
        Button submit = new Button("Submit");
        Button cancel = new Button("Cancel");
        pane.add(cancel, 1, 18);
        pane.add(submit, 2, 18);

        // Create a 2nd Scene For When a user Submit the data the new Scene will appear.
        GridPane pane2 = new GridPane();
        Scene scene2 = new Scene(pane2, 500, 300);
        pane2.setStyle("-fx-font: 40px CENTER"); // Setting GridPane styling and Alignment
        pane2.setAlignment(Pos.CENTER);
        Label welcomePage = new Label();

        // Creating a setOnAction event that takes place when user click submit button.
        submit.setOnAction(e -> {

            // Name Checker regex for user enter name or not.
            String nameChecker = "[A-Za-z\\s]+";
            Pattern namePattern = Pattern.compile(nameChecker);

            // Creating a String with regexValidation code of gmail and mobile number validation
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                    "[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            String numRegex = "[6-9][0-9]{9}";

            // Compiling the String of email validation and mobile number validation
            Pattern pattern = Pattern.compile(emailRegex);
            Pattern numPattern = Pattern.compile(numRegex);

            // Checking the firstName, MiddleName and LastName are true or not and store the variable in boolean variable.
            boolean fNameChecker = namePattern.matcher(fNameText.getText()).matches();
            boolean mNameChecker = namePattern.matcher(mNameText.getText()).matches();
            boolean lNameChecker = namePattern.matcher(lNameText.getText()).matches();

            // Checking the email and mobile number are true or not and store the value in boolean variable.
            boolean emailChecker = pattern.matcher(emailText.getText()).matches();
            boolean numberChecker = numPattern.matcher(mNumberText.getText()).matches();

            // Checking ComboBox is empty or not.
            boolean cbDayChecker = comboBoxDay.getSelectionModel().isEmpty();
            boolean cbMonthChecker = comboBoxMonth.getSelectionModel().isEmpty();
            boolean cbYearChecker = comboBoxYear.getSelectionModel().isEmpty();

            // Checking the RadioButton if its choose or not.
            boolean rbChecker = ( rbFemale.isSelected() || rbMale.isSelected());

            // Checking Checkbox is chosen or not.
            boolean cbChecker = ( hindi.isSelected() || gujarati.isSelected() || english.isSelected());

            // Checking the all conditions if some fields are empty then it will show Alert Warning.
            if(!fNameChecker) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("First Name Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter First Name");
                alert.showAndWait();
            } else if(!mNameChecker){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Middle Name Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter Middle Name");
                alert.showAndWait();
            } else if(!lNameChecker) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Last Name Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter Last Name");
                alert.showAndWait();
            } else if(!emailChecker){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Email Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter Valid Email Address");
                alert.showAndWait();
            } else if (!numberChecker) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Number Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter Valid Mobile number with limit in 10 digits.");
                alert.showAndWait();
            } else if (cbDayChecker) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("ComboBox Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please choose Date of Birth");
                alert.showAndWait();
            } else if (cbMonthChecker) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("ComboBox Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please choose Month of Birth");
                alert.showAndWait();
            } else if (cbYearChecker) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("ComboBox Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please choose Year of Birth");
                alert.showAndWait();
            } else if (!rbChecker) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Gender Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please choose gender");
                alert.showAndWait();
            } else if (!cbChecker) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("CheckBox Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please choose any of the language.");
                alert.showAndWait();
            } else {
                Stage stage = new Stage();
                stage.setScene(scene2);
                String name = fNameText.getText() + " " + lNameText.getText();
                welcomePage.setText("Welcome " + name );
                pane2.add(welcomePage, 1, 1);
                stage.setTitle("Welcome");
                stage.show();
            }
        });

        // Creating a setOnAction event that takes place when user click cancel button.
        // It will clear the input which are in the form.
        cancel.setOnAction(e -> {
            fNameText.clear();
            mNameText.clear();
            lNameText.clear();
            emailText.clear();
            mNumberText.clear();
            comboBoxDay.getSelectionModel().clearSelection();
            comboBoxMonth.getSelectionModel().clearSelection();
            comboBoxYear.getSelectionModel().clearSelection();
            rbMale.setSelected(false);
            rbFemale.setSelected(false);
            hindi.setSelected(false);
            gujarati.setSelected(false);
            english.setSelected(false);
        });

        // Setting the First Scene.
        Scene scene1 = new Scene(pane, 400, 450);
        primaryStage.setTitle("Registration Form");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
}