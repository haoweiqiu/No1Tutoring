package ca.mcgill.ecse321.tutoring_service_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class BillActivity extends AppCompatActivity {
    private String studentName;
    private String courseName;
    private String tutorName;
    private String startTime;
    private String endTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        Intent myIntent = getIntent(); // gets the previously created intent
        studentName = myIntent.getStringExtra("studentName");
        courseName = myIntent.getStringExtra("courseName");
        tutorName = myIntent.getStringExtra("tutorName");
        startTime = myIntent.getStringExtra("startTime");
        endTime = myIntent.getStringExtra("endTime");
        String bill = "\n\n\n\n\n\nStudent :" + studentName + "\n" + "Course :" + courseName + "\n" + "Tutor : " + tutorName + "\n"
                + "Start Time : " + startTime + "\n" + "Finish Time : " + endTime + " \n" + "Fee : " + " 30$";
        System.out.println(bill + "\n\n\n\n\n\n\n\n\n");
        TextView bill2 = (TextView) findViewById(R.id.tutorialBill);

        bill2.setText(bill);
    }
}
