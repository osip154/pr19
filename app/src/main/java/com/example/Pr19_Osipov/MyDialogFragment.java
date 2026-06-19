package com.example.pr19_mirzakamilov_pr23103;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class MyDialogFragment extends DialogFragment {

    public interface Listener {
        void onResult(String data);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Диалог")
                .setMessage("Передать данные в Activity?")
                .setPositiveButton("OK", (dialog, id) -> {
                    Listener listener = (Listener) getActivity();
                    if (listener != null) {
                        listener.onResult("Данные получены из диалога пупупу");
                    }
                });
        return builder.create();
    }
}