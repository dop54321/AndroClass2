package com.dop54321.noam.androclass2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    Button b;
    TextView tvNum1;
    TextView tvNum2;
    TextView tvCor;
    TextView tvWrong;
    EditText etAnswer;


    private int x;
    private int y;
    private int corCounter =0;
    private int wrongCounter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNum1= (TextView) findViewById(R.id.tvNum1);
        tvNum2= (TextView) findViewById(R.id.tvNum2);
        etAnswer= (EditText) findViewById(R.id.etAnswer);
        tvWrong= (TextView) findViewById(R.id.tvWrongNum);
        tvCor= (TextView) findViewById(R.id.tvCorrectsNum);

        createTwoRandomNumber();

        b= (Button) findViewById(R.id.btSubmit);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x= Integer.parseInt(tvNum1.getText().toString());
                int y= Integer.parseInt(tvNum2.getText().toString());

                int expAns=x+y;
                String ansStr=etAnswer.getText().toString();

                if (ansStr!=null && !ansStr.equals("")) {
                    int userAns= Integer.parseInt(ansStr);
                    if (expAns==userAns){
                        corCounter++;
                        tvCor.setText(String.valueOf(corCounter));
                        Toast.makeText(MainActivity.this,"Correct!",Toast.LENGTH_LONG).show();

                    }else{
                        wrongCounter++;
                        tvWrong.setText(String.valueOf(wrongCounter));


                        Toast t=Toast.makeText(MainActivity.this, "Wrong!", Toast.LENGTH_LONG);
                        t.show();
                    }
                    etAnswer.setText("");
                    createTwoRandomNumber();
                }

            }
        });


    }

    private void createTwoRandomNumber() {
        x = (int) (Math.random() * 100);
        tvNum1.setText(String.valueOf(x));

        y = (int) (Math.random() * 100);
        tvNum2.setText(String.valueOf(y));
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
