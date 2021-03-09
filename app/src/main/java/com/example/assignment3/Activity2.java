package com.example.assignment3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

//import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {
    Spinner list;
   //TextView voteCountC1;

    ArrayList<String> aList = new ArrayList<String>();
    int cc1, cc2, cc3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        Intent intent = getIntent();
        cc1=intent.getExtras().getInt("candidate1");
        cc2=intent.getExtras().getInt("candidate2");
        cc3=intent.getExtras().getInt("candidate3");

        Button btnVoteObj = findViewById(R.id.btn_vote);
        EditText voteridObj = findViewById(R.id.voter_id);
        EditText voternameObj = findViewById(R.id.voter_name);          //-----EditText----

        ToggleButton btnStatus = findViewById(R.id.toggleButton);
        list = findViewById(R.id.spinnerCandidate);
       // voteCountC1 = findViewById(R.id.c1_voteCount);
        //TextView errorTxt = findViewById(R.id.txt_error);


        btnVoteObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String checkName = voternameObj.getText().toString();
                String checkID = voteridObj.getText().toString();
                String list_value = list.getSelectedItem().toString();
                String list_first = list.getItemAtPosition(0).toString();
                String list_second = list.getItemAtPosition(1).toString();
                String list_third = list.getItemAtPosition(2).toString();
               // String list_fourth = list.getItemAtPosition(3).toString();


                Log.d("name",voteridObj.getText().toString());

                if(btnStatus.isChecked() && !checkID.isEmpty() && !checkName.isEmpty() && !list_value.equals(list_first)) {
                    if (!aList.contains(checkID)) {
                        aList.add(checkID);
                        Context context = getApplicationContext();
                        CharSequence text = "Thank you for voting!";
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        Log.d("success", ""+checkID);
                        if(list_value.equals(list_second)){
                            cc1++;
                            Log.d("First", "onClick: "+cc1);
                        }
                        else if (list_value.equals(list_third)){
                            cc2++;
                            Log.d("Second", "onClick: "+cc2);
                        }else {
                            cc3++;
                            Log.d("Third", "onClick: "+cc3);
                        }

                    }
                    else {
//                        Log.d("failed", "duplicate");
//                        Log.d("name","Hello"+voteridObj.getText().toString());
                        Context context = getApplicationContext();
                        CharSequence text = "Sorry! You cannot vote again.";
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }
                else {
                    Context context = getApplicationContext();
                    CharSequence text = "Please fill all the details";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }
    @Override
    public void onBackPressed(){
        Intent i = new Intent();
        i.putExtra("uv_1", cc1);
        i.putExtra("uv_2", cc2);
        i.putExtra("uv_3", cc3);
        setResult(RESULT_OK,i);
        finish();

    }
}

//    public void addVote(View view){
//        voteCountC1.setText(list.getSelectedItem().toString());
//        Intent intent = new Intent((this, MainActivity.class);
//        intent.putExtra("Number", voteCountC1.getText().toString());
//        startActivity(intent);
//    }
//}
