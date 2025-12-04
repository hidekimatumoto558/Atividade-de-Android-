package preP3.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nEditText;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nEditText = findViewById(R.id.nEditText);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateH();
            }
        });
    }

    private void calculateH() {
        String nStr = nEditText.getText().toString();
        if (nStr.isEmpty()) {
            nEditText.setError("Por favor, insira um valor para n.");
            return;
        }

        int n = Integer.parseInt(nStr);

        if (n <= 0 || n >= 20) {
            nEditText.setError("O número de termos deve ser maior que 0 e menor que 20.");
            return;
        }

        double h = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) { // Termo par
                h += 2.0 * i;
            } else { // Termo ímpar
                h += 1.0 * i;
            }
        }

        resultTextView.setText("H = " + h);
    }
}
