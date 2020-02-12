package ca.mcgill.ecse321.tutoring_service_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class MailActivity extends AppCompatActivity implements View.OnClickListener {

    //Declaring EditText
    private EditText editTextEmail;
    private EditText editTextSubject;
    private EditText editTextMessage;

    private String studentName;
    private String courseName;
    private String tutorName;
    private String startTime;
    private String endTime;

    //Send button
    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        Intent myIntent = getIntent(); // gets the previously created intent
        studentName = myIntent.getStringExtra("studentName");
        courseName = myIntent.getStringExtra("courseName");
        tutorName = myIntent.getStringExtra("tutorName");
        startTime = myIntent.getStringExtra("startTime");
        endTime = myIntent.getStringExtra("endTime");

        //Initializing the views
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextEmail.setText("maizeng2008@gmail.com");
        editTextSubject = (EditText) findViewById(R.id.editTextSubject);
        editTextSubject.setText("Emergency! No.1 Tutor! Ask for group tutorial!");
        editTextMessage = (EditText) findViewById(R.id.editTextMessage);
        String message = "Hi\n, Good morning, professor. I am Student " + studentName + ". \n";
        message += "I want to request a group tutorial with tutor: " +  tutorName + "for course : " + courseName + ".\n";
        message += "Thank you very much!";
        editTextMessage.setText(message);
        buttonSend = (Button) findViewById(R.id.buttonSend);

        //Adding click listener
        buttonSend.setOnClickListener(this);
    }


    private void sendEmail() {
        //Getting content for email
//        String email = editTextEmail.getText().toString().trim();
        setContentView(R.layout.activity_bill);
//        Intent myIntent = getIntent(); // gets the previously created intent
//        studentName = myIntent.getStringExtra("studentName");
//        courseName = myIntent.getStringExtra("courseName");
//        tutorName = myIntent.getStringExtra("tutorName");
//        startTime = myIntent.getStringExtra("startTime");
//        endTime = myIntent.getStringExtra("endTime");
        String email = "maizeng2008@gmail.com";
        String subject = "Emergency! No.1 Tutor! Ask for group tutorial!";
        String message = "Hi\n, Good morning, professor. I am Student " + studentName + ". \n";
        message += "I want to request a group tutorial with tutor: " +  tutorName + " for course : " + courseName + ".\n";
        message += "Thank you very much!";

        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }

    @Override
    public void onClick(View v) {
        sendEmail();
    }
}