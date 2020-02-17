package com.try64.navigationtutorial;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.math.BigDecimal;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmationFragment extends Fragment {

    BigDecimal value;
    Money money;
    String recipient;
    TextView confirmation_message;
    public ConfirmationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        money = getArguments().getParcelable("ammount");
        value = money.getValue();
        recipient = getArguments().getString("recipient");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        confirmation_message = view.findViewById(R.id.confirmation_message);
        confirmation_message.setText(recipient + " will get $" + value.toString());

    }
}
