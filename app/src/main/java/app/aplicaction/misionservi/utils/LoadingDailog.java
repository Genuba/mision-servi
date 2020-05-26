package app.aplicaction.misionservi.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import app.aplicaction.misionservi.R;

public class LoadingDailog {
    private Activity activity;
    private AlertDialog dialog;

    public LoadingDailog(Activity myActivity){
        activity = myActivity;
    }

    public void startLoadingDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dialog,null));
        builder.setCancelable(true);

        dialog = builder.create();
        dialog.show();
    }

    public void dismissDialog(){
        dialog.dismiss();
    }
}
