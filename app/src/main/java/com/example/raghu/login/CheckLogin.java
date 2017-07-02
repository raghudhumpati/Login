package com.example.raghu.login;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by R A G H U on 7/2/2017.
 */

public class CheckLogin extends AsyncTask {

String tresult;
    Context context;

    AlertDialog alertDialog;

    CheckLogin(Context ctx)
    {

        context=ctx;

    }

    @Override
    protected String doInBackground(Object[] params) {


        String type=params[0].toString();
        String login_url="http://192.168.1.4/andriod/checkLogin.php";


        if(type.equals("Login"))

            try {
                URL url=new URL(login_url);

                String jname=params[1].toString();
                String jpassword=params[2].toString();

                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder.encode("jname","UTF-8")+"="+URLEncoder.encode(jname,"UTF-8")+"&"+URLEncoder.encode("jpassword","UTF-8")+"="+URLEncoder.encode(jpassword,"UTF-8");

                bw.write(post_data);
                bw.flush();
                bw.close();

                InputStream is=httpURLConnection.getInputStream();
                BufferedReader br=new BufferedReader(new InputStreamReader(is,"iso-8859-1"));
                String result ="" ;
                String line="";


                while((line = br.readLine())!=null)
                {
                    result +=line;
                }
                br.close();
                is.close();
                httpURLConnection.disconnect();

                return result;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        {

        }

        return null;
    }

    @Override
    protected void onPreExecute() {

        alertDialog=new AlertDialog.Builder(context).create();
        alertDialog.setTitle("LOGIN STATUS");

    }

    @Override
    protected void onPostExecute(Object o) {


        alertDialog.setMessage("ALMOST REACHED");

        alertDialog.show();

    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
    }
}
