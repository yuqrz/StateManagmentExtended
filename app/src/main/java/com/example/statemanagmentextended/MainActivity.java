package com.example.statemanagmentextended;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.statemanagmentextended.R;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_COUNT = "count";
    private TextView textViewCount;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewCount = findViewById(R.id.textViewCount);
        Button buttonIncrement = findViewById(R.id.buttonIncrement); //
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(KEY_COUNT);
        }
        updateCountText();
        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                updateCountText();
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT, count);
    }
    private void updateCountText() {
        textViewCount.setText("Licznik: " + count);
    }
}
