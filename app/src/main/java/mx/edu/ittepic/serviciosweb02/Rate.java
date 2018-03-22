package mx.edu.ittepic.serviciosweb02;

import android.Manifest;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Bryan on 21/03/2018.
 */

public class Rate extends AsyncTask <Void, Void, Void> {

    String data = "";
    Double current = 0.0;

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected Void doInBackground(Void... voids) {


        try {
            URL url = new URL("https://openexchangerates.org/api/latest.json?app_id=cd07595abcb9419f97c68e3e76d348c8&base=USD");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }
            JSONObject JA = new JSONObject(data);
            for(int i = 0 ;i < JA.length(); i++){
                JSONObject JO = (JSONObject) JA.getJSONObject("rates");
                current =  JO.getDouble(MainActivity.spCurrent.getSelectedItem().toString());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        double total = Double.parseDouble(MainActivity.txtCurrent.getText().toString()) * current;
        MainActivity.txtTotal.setText(total + "");
    }
}
