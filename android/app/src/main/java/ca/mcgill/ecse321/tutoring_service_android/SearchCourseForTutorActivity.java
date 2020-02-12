package ca.mcgill.ecse321.tutoring_service_android;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.ParseException;

public class SearchCourseForTutorActivity extends AppCompatActivity {
    private String error = null;
    private int tutorListLength = 0;
    private String courseName;
    private String[] tutorList;
    Button buttons[];

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

    public void populateButtons(){

        buttons = new Button[tutorListLength];

        TableLayout talbe = (TableLayout) findViewById(R.id.TableForTutorList);

        for(int row = 0; row < tutorListLength; row++){
            final String tutorName = tutorList[row];
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f));
            talbe.addView(tableRow);
            Button button = new Button(this);
            button.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.MATCH_PARENT,
                    1.0f));

            button.setText(tutorList[row]);

            // Make text not clip on small buttons
            button.setPadding(0, 0, 0, 0);
            tableRow.addView(button);
            buttons[row] = button;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectTutor(tutorName, courseName);
                }
            });
        }
    }

    private void selectTutor(String tutorName, String courseName) {
        Intent myIntent = getIntent(); // gets the previously created intent
        String studentName = myIntent.getStringExtra("studentName");
        error = "";
        Intent intent;
        intent = new Intent(SearchCourseForTutorActivity.this, RequestTutorialActivity.class);
        intent.putExtra("tutorName", tutorName);
        intent.putExtra("studentName", studentName);
        intent.putExtra("courseName", courseName);
        startActivity(intent);
    }


    public void courseSearch(View v){
        error = "";
        final TextView tv = (TextView) findViewById(R.id.course_name);
        Toast toast1 = Toast.makeText(getApplicationContext(), tv.getText().toString(), Toast.LENGTH_LONG);
        toast1.show();
        HttpUtils.get("tutors_byCourse/" + tv.getText().toString(), new RequestParams(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray success) {
                try {
                    courseName = tv.getText().toString();
                    refreshErrorMessage();
                    tv.setText("");
                    String names = "" + success.length();
                    tutorListLength = success.length();
                    tutorList = new String[tutorListLength];
                    for (int i = 0; i < tutorListLength; i++) {
                        String s = success.get(i) + "";
                        if(s.contains("name")){
                            String sub = s.split("\",\"")[0];
                            String tutorName = sub.split("name\":\"")[1];
                            tutorList[i] = tutorName;
                        }
                    }
                    Toast toast = Toast.makeText(getApplicationContext(), names, Toast.LENGTH_LONG);
                    toast.show();
                    populateButtons();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_course_for_tutor);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
