package pl.nataliana.mobilesaver;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String phoneNumberCall = "+48505049029";
    private String phoneNumberSMS = "+48503004074";
    private String sms_text = "I have fallen, and can't move. Please come!";
    private String phoneNumberChoosen = "+48505049029";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button helpButton = (Button) findViewById(R.id.help_btn);
        helpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumberCall));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        Button fallButton = (Button) findViewById(R.id.fall_btn);
        fallButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:" + phoneNumberSMS);
                Intent it = new Intent(Intent.ACTION_SENDTO, uri);
                it.putExtra("sms_body", sms_text);
                startActivity(it);
            }
        });

        Button callButton = (Button) findViewById(R.id.call_btn);
        callButton.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumberChoosen));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}
