package ca.mcgill.ecse321.tutoring_service_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLEncoder;

import cz.msebera.android.httpclient.Header;

public class RequestTutorialActivity extends AppCompatActivity {
    private String error = null;
    private String studentName;
    private String courseName;
    private String tutorName;
    private String startTime;
    private String endTime;
    private String[] feedbacks;
    private ListView listView;
    private LinearLayout feedbackSec;
    private boolean isFeedbackRendered;
    private RequestParams params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_tutorial);
        feedbackSec = (LinearLayout)findViewById(R.id.feedbackSec);
        feedbackSec.setVisibility(View.GONE);
        setNames();
        loadFeedback();
        isFeedbackRendered = false;
    }

    private void loadFeedback() {
        String urlStr = "all_student_feedbacks/?"+ "tutor_name=" + tutorName;
        urlStr = urlStr.replaceAll("\\s", "\\+");
        Log.d("CREATION", urlStr);
        HttpUtils.get(urlStr, null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray success) {
                try {
                    feedbacks = new String[success.length()];
                    for (int i = 0; i < success.length(); i++) {
                        feedbacks[i] = success.getJSONObject(i).getString("comment");
                    }
                } catch (final JSONException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                try {
                    System.out.println("Received event with data: " + "!11111");
                    error += errorResponse.get("message").toString();
                } catch (JSONException e) {
                    error += e.getMessage();
                }
                refreshErrorMessage();
            }
        });
    }

    private void refreshErrorMessage() {
        // set the error message
        TextView tvError = (TextView) findViewById(R.id.error);
        tvError.setText(error);

        if (error == null || error.length() == 0) {
            tvError.setVisibility(View.GONE);
        } else {
            tvError.setVisibility(View.VISIBLE);
        }
    }

    private void setNames() {
        Intent myIntent = getIntent(); // gets the previously created intent
        studentName = myIntent.getStringExtra("studentName");
        courseName = myIntent.getStringExtra("courseName");
        tutorName = myIntent.getStringExtra("tutorName");
        final TextView tvc = (TextView) findViewById(R.id.courseName);
        final TextView tvs = (TextView) findViewById(R.id.studentName);
        final TextView tvt = (TextView) findViewById(R.id.tutorName);
        final TextView tvf = (TextView) findViewById(R.id.fee);
        tvc.setText("Course: " + courseName);
        tvs.setText("Student: " + studentName);
        tvt.setText("Tutor: " + tutorName);
        tvf.setText(("Fee: 30$/h"));
        final Button checkFeedback = (Button) findViewById(R.id.checkFeedback);
        final Button RequestGroup =(Button) findViewById(R.id.groupTutReq);
//        checkFeedback.setOnClickListener(reviewFeedback());
//
//        final Button confirmButton = (Button) findViewById(R.id.Confirm);
    }


    public void onCheckboxClicked(View view) {
        CheckBox ch1 = (CheckBox) findViewById(R.id.checkBox);
        CheckBox ch2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox ch3 = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox ch4 = (CheckBox) findViewById(R.id.checkBox4);
        CheckBox ch5 = (CheckBox) findViewById(R.id.checkBox5);
        CheckBox ch6 = (CheckBox) findViewById(R.id.checkBox6);
        CheckBox ch7 = (CheckBox) findViewById(R.id.checkBox7);
        CheckBox ch8 = (CheckBox) findViewById(R.id.checkBox8);
        CheckBox ch9 = (CheckBox) findViewById(R.id.checkBox9);
        CheckBox ch10 = (CheckBox) findViewById(R.id.checkBox10);
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.checkBox:
                if(checked){
                    startTime = ch1.getText()+"";
                    endTime = "Monday 11:00";
                    ch2.setEnabled(false);
                    ch3.setEnabled(false);
                    ch4.setEnabled(false);
                    ch5.setEnabled(false);
                    ch6.setEnabled(false);
                    ch7.setEnabled(false);
                    ch8.setEnabled(false);
                    ch9.setEnabled(false);
                    ch10.setEnabled(false);
                }
                else{
                    startTime = "";
                    endTime = "";
                    ch2.setEnabled(true);
                    ch3.setEnabled(true);
                    ch4.setEnabled(true);
                    ch5.setEnabled(true);
                    ch6.setEnabled(true);
                    ch7.setEnabled(true);
                    ch8.setEnabled(true);
                    ch9.setEnabled(true);
                    ch10.setEnabled(true);
                }
                break;
            case R.id.checkBox2:
                if(checked) {
                    startTime = ch2.getText() + "";
                    endTime = "Tuesday 11:00";
                    ch1.setEnabled(false);
                    ch3.setEnabled(false);
                    ch4.setEnabled(false);
                    ch5.setEnabled(false);
                    ch6.setEnabled(false);
                    ch7.setEnabled(false);
                    ch8.setEnabled(false);
                    ch9.setEnabled(false);
                    ch10.setEnabled(false);
                }
                else{
                    startTime = "";
                    endTime = "";
                    ch1.setEnabled(true);
                    ch3.setEnabled(true);
                    ch4.setEnabled(true);
                    ch5.setEnabled(true);
                    ch6.setEnabled(true);
                    ch7.setEnabled(true);
                    ch8.setEnabled(true);
                    ch9.setEnabled(true);
                    ch10.setEnabled(true);

                }
                break;
            case R.id.checkBox3:
                if(checked){
                    startTime = ch3.getText()+"";
                    endTime = "Wednesday 11:00";
                    ch1.setEnabled(false);
                    ch2.setEnabled(false);
                    ch4.setEnabled(false);
                    ch5.setEnabled(false);
                    ch6.setEnabled(false);
                    ch7.setEnabled(false);
                    ch8.setEnabled(false);
                    ch9.setEnabled(false);
                    ch10.setEnabled(false);
                }
                else{
                    startTime = "";
                    endTime = "";
                    ch1.setEnabled(true);
                    ch2.setEnabled(true);
                    ch4.setEnabled(true);
                    ch5.setEnabled(true);
                    ch6.setEnabled(true);
                    ch7.setEnabled(true);
                    ch8.setEnabled(true);
                    ch9.setEnabled(true);
                    ch10.setEnabled(true);
                }
                break;
            case R.id.checkBox4:
                if(checked){
                    startTime = ch4.getText()+"";
                    endTime = "Thursday 11:00";
                    ch1.setEnabled(false);
                    ch2.setEnabled(false);
                    ch3.setEnabled(false);
                    ch5.setEnabled(false);
                    ch6.setEnabled(false);
                    ch7.setEnabled(false);
                    ch8.setEnabled(false);
                    ch9.setEnabled(false);
                    ch10.setEnabled(false);
                }
                else{
                    startTime = "";
                    endTime = "";
                    ch1.setEnabled(true);
                    ch2.setEnabled(true);
                    ch3.setEnabled(true);
                    ch5.setEnabled(true);
                    ch6.setEnabled(true);
                    ch7.setEnabled(true);
                    ch8.setEnabled(true);
                    ch9.setEnabled(true);
                    ch10.setEnabled(true);
                }
                break;
            case R.id.checkBox5:
                if(checked){
                    startTime = ch5.getText()+"";
                    endTime = "Thursday 11:00";
                    ch1.setEnabled(false);
                    ch2.setEnabled(false);
                    ch3.setEnabled(false);
                    ch4.setEnabled(false);
                    ch6.setEnabled(false);
                    ch7.setEnabled(false);
                    ch8.setEnabled(false);
                    ch9.setEnabled(false);
                    ch10.setEnabled(false);
                }
                else{
                    startTime = "";
                    endTime = "";
                    ch1.setEnabled(true);
                    ch2.setEnabled(true);
                    ch3.setEnabled(true);
                    ch4.setEnabled(true);
                    ch6.setEnabled(true);
                    ch7.setEnabled(true);
                    ch8.setEnabled(true);
                    ch9.setEnabled(true);
                    ch10.setEnabled(true);
                }
                break;
            case R.id.checkBox6:
                if(checked){
                    startTime = ch6.getText()+"";
                    endTime = "Thursday 11:00";
                    ch1.setEnabled(false);
                    ch2.setEnabled(false);
                    ch3.setEnabled(false);
                    ch4.setEnabled(false);
                    ch5.setEnabled(false);
                    ch7.setEnabled(false);
                    ch8.setEnabled(false);
                    ch9.setEnabled(false);
                    ch10.setEnabled(false);
                }
                else{
                    startTime = "";
                    endTime = "";
                    ch1.setEnabled(true);
                    ch2.setEnabled(true);
                    ch3.setEnabled(true);
                    ch4.setEnabled(true);
                    ch5.setEnabled(true);
                    ch7.setEnabled(true);
                    ch8.setEnabled(true);
                    ch9.setEnabled(true);
                    ch10.setEnabled(true);
                }
                break;
            case R.id.checkBox7:
                if(checked){
                    startTime = ch7.getText()+"";
                    endTime = "Friday 11:00";
                    ch1.setEnabled(false);
                    ch2.setEnabled(false);
                    ch3.setEnabled(false);
                    ch4.setEnabled(false);
                    ch5.setEnabled(false);
                    ch6.setEnabled(false);
                    ch8.setEnabled(false);
                    ch9.setEnabled(false);
                    ch10.setEnabled(false);
                }
                else{
                    startTime = "";
                    endTime = "";
                    ch1.setEnabled(true);
                    ch2.setEnabled(true);
                    ch3.setEnabled(true);
                    ch4.setEnabled(true);
                    ch5.setEnabled(true);
                    ch6.setEnabled(true);
                    ch8.setEnabled(true);
                    ch9.setEnabled(true);
                    ch10.setEnabled(true);
                }
                break;
            case R.id.checkBox8:
                if(checked){
                    startTime = ch8.getText()+"";
                    endTime = "Saturday 12:00";
                    ch1.setEnabled(false);
                    ch2.setEnabled(false);
                    ch3.setEnabled(false);
                    ch4.setEnabled(false);
                    ch5.setEnabled(false);
                    ch6.setEnabled(false);
                    ch7.setEnabled(false);
                    ch9.setEnabled(false);
                    ch10.setEnabled(false);
                }
                else{
                    startTime = "";
                    endTime = "";
                    ch1.setEnabled(true);
                    ch2.setEnabled(true);
                    ch3.setEnabled(true);
                    ch4.setEnabled(true);
                    ch5.setEnabled(true);
                    ch6.setEnabled(true);
                    ch7.setEnabled(true);
                    ch9.setEnabled(true);
                    ch10.setEnabled(true);
                }
                break;
            case R.id.checkBox9:
                if(checked){
                    startTime = ch9.getText()+"";
                    endTime = "Saturday 14:00";
                    ch1.setEnabled(false);
                    ch2.setEnabled(false);
                    ch3.setEnabled(false);
                    ch4.setEnabled(false);
                    ch5.setEnabled(false);
                    ch6.setEnabled(false);
                    ch7.setEnabled(false);
                    ch9.setEnabled(false);
                    ch10.setEnabled(false);
                }
                else{
                    startTime = "";
                    endTime = "";
                    ch1.setEnabled(true);
                    ch2.setEnabled(true);
                    ch3.setEnabled(true);
                    ch4.setEnabled(true);
                    ch5.setEnabled(true);
                    ch6.setEnabled(true);
                    ch7.setEnabled(true);
                    ch8.setEnabled(true);
                    ch10.setEnabled(true);
                }
                break;
            case R.id.checkBox10:
                if(checked){
                    startTime = ch9.getText()+"";
                    endTime = "Saturday 16:00";
                    ch1.setEnabled(false);
                    ch2.setEnabled(false);
                    ch3.setEnabled(false);
                    ch4.setEnabled(false);
                    ch5.setEnabled(false);
                    ch6.setEnabled(false);
                    ch7.setEnabled(false);
                    ch8.setEnabled(false);
                    ch9.setEnabled(false);
                }
                else{
                    startTime = "";
                    endTime = "";
                    ch1.setEnabled(true);
                    ch2.setEnabled(true);
                    ch3.setEnabled(true);
                    ch4.setEnabled(true);
                    ch5.setEnabled(true);
                    ch6.setEnabled(true);
                    ch7.setEnabled(true);
                    ch8.setEnabled(true);
                    ch9.setEnabled(true);
                }
                break;
        }
    }

    public void requestGroupTut(View v) {
        Intent intent;
        intent = new Intent(RequestTutorialActivity.this, MailActivity.class);
        intent.putExtra("tutorName", tutorName);
        intent.putExtra("studentName", studentName);
        intent.putExtra("courseName", courseName);
        intent.putExtra("endTime", endTime);
        intent.putExtra("startTime", startTime);
        startActivity(intent);
    }

    public void requestTutorial(View v) {
        error = "";
        if (startTime == null) {
            error = "Please select a time";
        }
        RequestParams par = new RequestParams();
//        par.put("startTime", startTime);
//        par.put("finishTime", endTime);
//        par.put("courseName",courseName);
//        par.put("tutorName", tutorName);
        String urlStr = "tutorial_request/tutorial_sessions/?"+ "startTime=" + startTime + "&finishTime=" + endTime + "&courseName=" + courseName
                + "&tutorName=" + tutorName;
        urlStr = urlStr.replaceAll("\\s", "\\+");
        Log.d("CREATION", urlStr);
        HttpUtils.post(urlStr, par, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Toast toast = Toast.makeText(getApplicationContext(), "Request Success!", Toast.LENGTH_LONG);
                toast.show();
                Intent intent;
                intent = new Intent(RequestTutorialActivity.this, BillActivity.class);
                intent.putExtra("tutorName", tutorName);
                intent.putExtra("studentName", studentName);
                intent.putExtra("courseName", courseName);
                intent.putExtra("endTime", endTime);
                intent.putExtra("startTime", startTime);

                startActivity(intent);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                try {
                    System.out.println("Received event with data: " + "!11111");
                    error += errorResponse.get("message").toString();
                } catch (JSONException e) {
                    error += e.getMessage();
                }
                refreshErrorMessage();
            }
        });
    }

    public void checkFeedback(View v) {
        if (!isFeedbackRendered) {
            feedbackSec.setVisibility(View.VISIBLE);
            listView=(ListView)findViewById(R.id.listView);
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, feedbacks);
            listView.setAdapter(adapter);
            isFeedbackRendered = true;
        } else {
            feedbackSec.setVisibility(View.VISIBLE);
        }
    }

    public void dismissFeedback(View v) {
        feedbackSec.setVisibility(View.GONE);
    }

}
