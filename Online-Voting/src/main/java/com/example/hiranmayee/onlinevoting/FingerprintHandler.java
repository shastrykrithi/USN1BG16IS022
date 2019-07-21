package com.example.hiranmayee.onlinevoting;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.biometrics.BiometricPrompt;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.support.v4.app.ActivityCompat;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.widget.Toast;

@android.support.annotation.RequiresApi(api = Build.VERSION_CODES.M)
public class FingerprintHandler extends FingerprintManager.AuthenticationCallback {

    private Context context;



    public FingerprintHandler(Context context){
        this.context=context;
    }

    public void startAuthentication(FingerprintManager fingerprintManager, FingerprintManager.CryptoObject cryptoObject){

        if((ActivityCompat.checkSelfPermission(context,Manifest.permission.USE_FINGERPRINT) !=PackageManager.PERMISSION_GRANTED))
            return;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            CancellationSignal cencancellationSignal = new CancellationSignal();

            fingerprintManager.authenticate(cryptoObject,cencancellationSignal,0,this,null);
        }
    }

    @Override
    public void onAuthenticationFailed() {
        super.onAuthenticationFailed();
        Toast.makeText(context,"FingerPrint Authentication Failed", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
        super.onAuthenticationSucceeded(result);
        context.startActivity(new Intent(context,Contestent.class));
    }

}

