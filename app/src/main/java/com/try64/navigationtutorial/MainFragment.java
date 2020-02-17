package com.try64.navigationtutorial;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {

    NavController navController;
    Button viewTransactionButton, sendMoneyButton, viewBalanceButton;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //navController = new NavController(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        viewTransactionButton = view.findViewById(R.id.view_transactions_btn);
        sendMoneyButton = view.findViewById(R.id.send_money_btn);
        viewBalanceButton = view.findViewById(R.id.view_balance_btn);

        viewTransactionButton.setOnClickListener(this);
        sendMoneyButton.setOnClickListener(this);
        viewBalanceButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.view_transactions_btn:
                navController.navigate(R.id.action_mainFragment_to_viewTransactionFragment);
                break;
            case R.id.send_money_btn:
                navController.navigate(R.id.action_mainFragment_to_chooseRecipientFragment);
                break;
            case R.id.view_balance_btn:
                navController.navigate(R.id.action_mainFragment_to_viewBalanceFragment);
                break;

        }
    }


//    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.view_transactions_btn:
//                navController.navigate(R.id.viewBalanceFragment);
//                break;
//            case R.id.send_money_btn:
//                navController.navigate(R.id.chooseRecipientFragment);
//                break;
//            case R.id.view_balance_btn:
//                navController.navigate(R.id.viewBalanceFragment);
//                break;
//
//        }
//    }

}
