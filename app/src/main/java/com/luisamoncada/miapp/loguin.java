package com.luisamoncada.miapp;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class loguin extends AppCompatActivity {

CallbackManager callbackManager;
TextView name, mail;
    ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_loguin);

        name = (TextView) findViewById(R.id.tName);
        mail = (TextView) findViewById(R.id.tMail);
        foto = (ImageView) findViewById(R.id.iFoto);

        //generarKeyHashes();
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        callbackManager =CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Profile perfil = com.facebook.Profile.getCurrentProfile();
                name.setText(perfil.getLastName());
                mail.setText(perfil.getLastName());

            }

            @Override
            public void onCancel() {
                name.setText("Se cancelo el Login");

            }

            @Override
            public void onError(FacebookException error) {
                name.setText("Error de login:"+ error);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }


    public void generarKeyHashes(){
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.luisamoncada.miapp",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }

}
