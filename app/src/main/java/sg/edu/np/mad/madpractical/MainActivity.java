package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart(){
        super.onStart();

        // set up user
        User user = new User();
        user.followed = false;

        // attach listener to the button
        Button but = findViewById(R.id.button);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.followed == false){
                    but.setText("UNFOLLOW");
                    user.followed = true;

                    // toast
                    Toast.makeText(getApplicationContext(),"Unfollowed!",Toast.LENGTH_LONG);

                }
                else{
                    but.setText("FOLLOW");
                    user.followed = false;

                    Toast.makeText(getApplicationContext(),"Followed!",Toast.LENGTH_LONG);
                }
            }
        });

        // list activity

        Button b = findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create intent
                Intent i = new Intent(MainActivity.this, ListActivity.class);
                startActivity(i);
            }
        });

        // changing the text value
        Intent rec = getIntent();
        Integer i = rec.getIntExtra("value",0);
        String str;
        if (i == 0){
            str = "";
        }
        else{
            str = i.toString();
        }
        TextView title = findViewById(R.id.textView);
        title.setText("MAD " + str);

    }

}
