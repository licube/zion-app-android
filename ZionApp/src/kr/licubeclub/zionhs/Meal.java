package kr.licubeclub.zionhs;

import toast.library.meal.MealLibrary;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.ProgressDialog;
import android.util.Log;
import android.widget.TextView;
import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;

public class Meal extends ActionBarActivity {

    private ProgressDialog progressDialog;
    TextView text;
    String[] test = new String[35];
    String[] meal = new String[7];
    String[] meal2 = new String[7];
    String[] meal3 = new String[7];

    @SuppressLint("HandlerLeak")
	private final Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        text = (TextView)this.findViewById(R.id.textView1);
        for(int i = 0; i < 34; i++)
        {
            test[i] = "11";
        }


        final Handler mHandler = new Handler();
        new Thread()
        {

            public void run()
            {
                mHandler.post(new Runnable(){

                    public void run()
                    {
                        progressDialog = ProgressDialog.show(Meal.this,"",
                                "잠시 기다려 주세요.",true);
                    }
                });

    
     
    	//meal = Schoollibrary.getMeal("dge.go.kr","D100000393","3","03","1"); //조식 조회
         meal2 = MealLibrary.getMeal("goe.go.kr","P100000429","4","04","2"); //중식 조회
         //meal3 = Schoollibrary.getMeal("dge.go.kr","D100000393","3","03","3"); //석식 조회
     
   
                
           


                mHandler.post(new Runnable()
                {
                    public void run()
                    {
                        progressDialog.dismiss();
                        text.setText(test[3]);
                        Log.d("meal2", meal2[4]);
                        handler.sendEmptyMessage(0);
                    }
                });

            }
        }.start();


    }
}