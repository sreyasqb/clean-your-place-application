package com.example.oopsappv6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
    private EditText username;
    private EditText password;
    private Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        username=(EditText)findViewById(R.id.userName);
        password=(EditText)findViewById(R.id.passWord);
        Login=(Button)findViewById(R.id.login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=username.getText().toString();
                String upass=password.getText().toString();
                //System.out.println(text);
                boolean ans=signIn(uname,upass);
                System.out.println(ans);
                if (ans){

                    appPage2();
                }
            }
        });



        // Example of a call to a native method
//        TextView tv = findViewById(R.id.sample_text);
//        tv.setText(stringFromJNI());
    }
    public void appPage2(){
        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    //public native String stringFromJNI();
    public native boolean signIn(String uname,String upass);
    public native void ReadLocation();

}