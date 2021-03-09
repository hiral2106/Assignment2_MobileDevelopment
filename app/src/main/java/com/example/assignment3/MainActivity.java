package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;

public class MainActivity extends AppCompatActivity {
    int c1=0,c2=0,c3=0;
    TextView cv_1,cv_2,cv_3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cv_1=findViewById(R.id.c1_voteCount);
        cv_2=findViewById(R.id.c2_voteCount);
        cv_3=findViewById(R.id.c3_voteCount);
        cv_1.setText(""+c1);
        cv_2.setText(""+c2);
        cv_3.setText(""+c1);
        //Intent intent = getIntent();
//        String voteNumber = intent.getExtras().getString("Number");
//        c1.setText(voteNumber);
    }
    public void onActivityResult(int requestCode,int resultCode, Intent i) {
        super.onActivityResult(requestCode, resultCode, i);
        if(requestCode==1){
            if(resultCode== RESULT_OK){
                c1=i.getExtras().getInt("uv_1");
                c2=i.getExtras().getInt("uv_2");
                c3=i.getExtras().getInt("uv_3");
                cv_1.setText(""+c1);
                cv_2.setText(""+c2);
                cv_3.setText(""+c3);
            }
        }
    }

    //To redirect - Activity2
    public void startVoting(View view){
        //when we click this - create an intent
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("candidate1", c1);
        intent.putExtra("candidate2", c2);
        intent.putExtra("candidate3", c3);

        //we can pass extra info into intent
        //we get the chosen fruit in choice textview and added to my intent as an extra info
        //intent.putExtra("Number",voteCountC1.getText().toString());
        startActivityForResult(intent, 1); //Start intent to direct on other activity
   }

}