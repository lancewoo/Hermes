package xiaofei.library.hermestest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import xiaofei.library.hermes.Hermes;
import xiaofei.library.hermestest.test.C;
import xiaofei.library.hermestest.test.NewInstance;
import xiaofei.library.hermestest.test.TestingActivity;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Hermes.register(NewInstance.class);
        Hermes.register(C.class);
        Hermes.register(UserManager.class);
        Hermes.register(LoadingTask.class);
        findViewById(R.id.testing).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TestingActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.demo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DemoActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("eric zhao", "destroy");
    }
}