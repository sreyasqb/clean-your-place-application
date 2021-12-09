package com.example.oopsappv6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;




import org.w3c.dom.Text;

public class DetailsLoc extends AppCompatActivity {
    private EditText D_title;
    private EditText D_desc;
    private EditText D_add;
    private Button D_save;
    private Button D_next;
    private Button D_prev;
    private TextView idDisp;
    public int detidCount=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_details_loc);
        D_title=(EditText)findViewById(R.id.Dtitle);
        D_desc=(EditText)findViewById(R.id.Ddesc);
        D_add=(EditText)findViewById(R.id.Dadd);
        idDisp=(TextView)findViewById(R.id.Did);
        idDisp.setText(String.valueOf(detidCount));
        D_save=(Button)findViewById(R.id.Dsave);
        D_next=(Button)findViewById(R.id.Dnext);
        D_prev=(Button)findViewById(R.id.Dback);

        idDisp.setText(String.valueOf(detidCount));
        D_title.setText(SendTitle(detidCount));
        D_desc.setText(SendDesc(detidCount));
        D_add.setText(SendAdd(detidCount));




        D_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (detidCount>1) {
                    detidCount -= 1;
//                    System.out.println(detidCount);
//                    System.out.println(SendTitle(detidCount));
//                    System.out.println(SendDesc(detidCount));
//                    System.out.println(SendAdd(detidCount));
                    idDisp.setText(String.valueOf(detidCount));
                    D_title.setText(SendTitle(detidCount));
                    D_desc.setText(SendDesc(detidCount));
                    D_add.setText(SendAdd(detidCount));
                }
            }
        });



        D_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (detidCount<LocLen()) {
                    detidCount += 1;
                    idDisp.setText(String.valueOf(detidCount));
                    D_title.setText(SendTitle(detidCount));
                    D_desc.setText(SendDesc(detidCount));
                    D_add.setText(SendAdd(detidCount));

                }
            }
        });


        D_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ST_title=D_title.getText().toString();
                String ST_desc=D_desc.getText().toString();
                String ST_add=D_add.getText().toString();
                WriteDet(detidCount,ST_title,ST_desc,ST_add);

                System.out.println("SAVED SUCCEFULLY");

            }
        });

    }

    public native int LocLen();
    public native void WriteDet(int a,String b,String c,String d) ;
    public native String SendTitle(int x);
    public native String SendDesc(int x);
    public native String SendAdd(int x);
}

