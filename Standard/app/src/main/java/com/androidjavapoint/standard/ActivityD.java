package com.androidjavapoint.standard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ActivityD extends AppCompatActivity implements View.OnClickListener {

    private String TAG = this.getClass().getSimpleName();
    private StringBuilder mCalledLifeCycleMethods;
    private TextView mCalledLifeCycleMethodsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);

        mCalledLifeCycleMethods = new StringBuilder();

        mCalledLifeCycleMethodsText = (TextView) findViewById(R.id.textLifeCycle);

        findViewById(R.id.buttonFinish).setOnClickListener(this);

        updateLifeCycleMethod("Called OnCreate()");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        updateLifeCycleMethod("Called onNewIntent()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        updateLifeCycleMethod("Called onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateLifeCycleMethod("Called onResume()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        updateLifeCycleMethod("Called onDestroy()");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonFinish:
                finish();
                break;
        }
    }

    /**
     * Update the text view
     *
     * @param method activity life cycle method name
     */
    private void updateLifeCycleMethod(String method) {
        mCalledLifeCycleMethods.append(TAG).append(" : ").append(method).append("\n");
        mCalledLifeCycleMethodsText.setText(mCalledLifeCycleMethods.toString());
    }
}
