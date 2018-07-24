package com.example.user.emailapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// при нажатии на кнопку ACTIVITY
        Button Activity = findViewById(R.id.btnActivity);
        Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                EditText messageView = findViewById(R.id.message);
                String messageText = messageView.getText().toString().trim();
                Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                intent.putExtra(MessageActivity.EXTRA_MESSAGE, messageText);
                startActivity(intent);
            }
        });
 // при нажатии на кнопку EMAIL
        Button email = findViewById(R.id.btnEmail);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                EditText messageView = findViewById(R.id.message);
                String messageText = messageView.getText().toString().trim();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, messageText);
                intent.putExtra(Intent.EXTRA_SUBJECT, "The message I wrote on my app");
                String chooserTitle = getString(R.string.chooser);
                Intent chooserIntent = Intent.createChooser(intent, chooserTitle); //всегда выводит окно выбора для оправки Email
                startActivity(chooserIntent); //запустить активити выбраную пользователем
            }
        });

    }
    //вызвать onSendMessage() при нажатии на кнопку ACTIVITY
   // public void onSendMessage(View view) {
    //    EditText messageView = findViewById(R.id.message);
     //   String messageText = messageView.getText().toString().trim();
   // Intent intent = new Intent(MainActivity.this, MessageActivity.class);
    //    intent.putExtra(MessageActivity.EXTRA_MESSAGE, messageText);
         //       startActivity(intent);
         //       }

    //вызвать onSendEmail() при нажатии на кнопку EMAIL
   // public void onSendEmail(View view) {
     //   EditText messageView = findViewById(R.id.message);
      //  String messageText = messageView.getText().toString().trim();
      //  Intent intent = new Intent(Intent.ACTION_SEND);
       // intent.setType("text/plain");
      //  intent.putExtra(Intent.EXTRA_TEXT, messageText);
     //   intent.putExtra(Intent.EXTRA_SUBJECT, "The message I wrote on my app");
     //   startActivity(intent);
  //  }
}
