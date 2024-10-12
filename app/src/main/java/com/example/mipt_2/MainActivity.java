package com.example.mipt_2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mipt_2.utils.TextCounter;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    EditText edUserInput;
    Spinner spSelectionOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.tvResult = findViewById(R.id.tvCountResult);
        this.edUserInput = findViewById(R.id.edUserInput);

        this.spSelectionOptions = findViewById(R.id.spSelectionOptions);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.count_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spSelectionOptions.setAdapter(adapter);
    }

    public void onBtnCountClick(View view)
    {
        String userPhrase = this.edUserInput.getText().toString();

        if (userPhrase.isEmpty())
        {
            Toast.makeText(this, "Please enter some text", Toast.LENGTH_SHORT).show();
            return; // Exit the method if input is empty
        }

        String selectedOption = this.spSelectionOptions.getSelectedItem().toString();

        if (selectedOption.equalsIgnoreCase("Chars"))
        {
            int charsCount = TextCounter.getCharsCount(userPhrase);
            this.tvResult.setText(String.valueOf(charsCount));
        } else if (selectedOption.equalsIgnoreCase("Words"))
        {
            int wordsCount = TextCounter.getWordsCount(userPhrase);
            this.tvResult.setText(String.valueOf(wordsCount));
        } else {
            this.tvResult.setText("Not Implemented");
        }
    }
}