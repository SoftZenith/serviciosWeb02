package mx.edu.ittepic.serviciosweb02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    String [] currents = {"MXN", "COP", "ARS", "CLP", "VEF", "RUB", "CNY"};
    static Spinner spCurrent;
    static TextView txtTotal;
    static EditText txtCurrent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCurrent = findViewById(R.id.edtCurrent);
        txtTotal = findViewById(R.id.txtTotal);
        spCurrent = findViewById(R.id.spCurrent);

        spCurrent.setAdapter(new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, currents));
    }


    public void convertir(View view) {
        new Rate().execute();
    }
}
