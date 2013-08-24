package com.example.app;


 
import java.util.logging.Logger;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    private Button sendResume;
    private TextView textMail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Boolean answer = getIntent().getBooleanExtra("answer",false);
        if (answer) {
			/*
			 * Работаем с формой обработки ответа
			 */
        	setContentView(R.layout.activity_answer);
        	
        	String textMessage = getIntent().getStringExtra("textMessage");
        	String textAnswer = getIntent().getStringExtra("textAnswer");
        	
        	TextView resumeTextView = (TextView)findViewById(R.id.resume);
        	TextView answerTextView = (TextView)findViewById(R.id.answer);
        	resumeTextView.setText(textMessage);
        	answerTextView.setText(textAnswer);
        	
        } else {
	        /*
	         * Работаем с формой отправки резюме
	         */
	        setContentView(R.layout.activity_main);
	        sendResume = (Button)findViewById(R.id.button1);
	        sendResume.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
					DatePicker birthday = ((DatePicker)findViewById(R.id.dateBirthResume));
					String  textMail = 
							"ФИО:" + ((EditText)findViewById(R.id.fioResume)).getText().toString() + "\n" + 
							"Дата рождения:" + birthday.getDayOfMonth() + "." + birthday.getMonth() + "." + birthday.getYear() + "\n" +
							"Пол:" + ((Spinner)findViewById(R.id.genderResume)).getSelectedItem().toString() + "\n" +
							"Зарплата:" + ((EditText)findViewById(R.id.moneyResume)).getText().toString() + "\n" +
							"Номер телефона:" + ((EditText)findViewById(R.id.numberPhoneResume)).getText().toString() + "\n" +
							"Адрес электронной почты:" + ((EditText)findViewById(R.id.emailResume)).getText().toString(); 
					intent.putExtra("textMail", textMail);
					startActivity(intent);
				}
			});
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
