package com.afy.cheaper;

import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.os.AsyncTask;
import android.widget.Toast;

/*import org.json.Jsoup*/
import com.afy.cheaper.data.EndPoints;
import com.afy.cheaper.data.Offer;
import com.afy.cheaper.data.OffersResponse;
import com.afy.cheaper.data.OffersResponseModel;

//import org.simpleframework.xml.convert.Convert;

import java.io.InputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
//import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.afy.cheaper.data.URLS.BASE_URL;

/*import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
*/
public class MainActivity extends AppCompatActivity implements Callback<List<Offer>>{
    public final static String EXTRA_MESSAGE = "com.afy.cheaper.MESSAGE";
    private static final String TAG = MainActivity.class.getCanonicalName();
    //EditText etResponse;
    TextView tvIsConnected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvIsConnected = (TextView) findViewById(R.id.tvIsConnected);
        //tvIsConnected.setText("You are conncted");
        if(isConnected()){
            tvIsConnected.setBackgroundColor(0xFF00CC00);
            tvIsConnected.setText("You are conncted");
        }
        else{
            tvIsConnected.setText("You are NOT conncted");
        }
        // call AsynTask to perform network operation on separate thread
        //new HttpAsyncTask().execute("http://hmkcode.appspot.com/rest/control");
        LoadOffers();

    }

    private void LoadOffers() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        EndPoints endPoints = retrofit.create(EndPoints.class);

        Call<List<Offer>> call = endPoints.getOffers();

        call.enqueue(this);
 /*       List<Offer> offers = (List<Offer>)call;
        Offer of = offers.get(0);
        System.out.print(of.getName());*/
    }

    public void authAndGoHome(View view) {
        // @todo do Auth and go to Home Activity
       /* Intent intent = new Intent(this, HomeActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);*/
    }
    public boolean isConnected(){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;

    }



    @Override
    public void onResponse(Call<List<Offer>> call, Response<List<Offer>> response) {
        List<Offer> offers = response.body();
        Log.d(TAG, "onResponse: " + offers.size());
        Iterator<Offer> offerIt = offers.iterator();
        while (offerIt .hasNext()) {
            Log.d(TAG,offerIt .next().topString());
        }
    }

    @Override
    public void onFailure(Call<List<Offer>> call, Throwable t) {
        Log.d(TAG,"EROOOR");
    }

    /*
    public static String GET(String url){
        InputStream inputStream = null;
        String result = "";

        try {
            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

            // receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return result;
    }*/
    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            //return GET(urls[0]);
            return "";
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), "Received!", Toast.LENGTH_LONG).show();
            //etResponse.setText(result);
        }
    }
}
