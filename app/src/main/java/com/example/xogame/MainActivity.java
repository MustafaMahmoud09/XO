package com.example.xogame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtResultO;
    private TextView txtResultX;
    private TextView txtLoadingO;
    private TextView txtLoadingX;
    private TextView txtStart;
    private TextView txtNumRound;
    private TextView btn_1_1;
    private TextView btn_1_2;
    private TextView btn_1_3;
    private TextView btn_2_1;
    private TextView btn_2_2;
    private TextView btn_2_3;
    private TextView btn_3_1;
    private TextView btn_3_2;
    private TextView btn_3_3;
    private boolean oPlay=true;
    private boolean check=false;
    private boolean checkGameStart=true;
    private final String RESULT_O_PLAYER= "OPlayer";
    private final String RESULT_X_PLAYER= "XPlayer";
    private final String NUMBER_ROUND= "NumberRound";
    private final String LOADING_X="LoadingX";
    private final String LOADING_O="LoadingO";
    private final String O_PLAY_CHECK="OPlay";
    private final String CHECK_WIN_OR_NO="Check";
    private final String CHECK_GAME="CheckGame";
    private final String TEXT_IN_BTN_ONE="textOne";
    private final String TEXT_IN_BTN_TWO="textTwo";
    private final String TEXT_IN_BTN_THREE="textThree";
    private final String TEXT_IN_BTN_FOUR="textFour";
    private final String TEXT_IN_BTN_FIVE="texTFive";
    private final String TEXT_IN_BTN_SIX="textSix";
    private final String TEXT_IN_BTN_SEVEN="textSeven";
    private final String TEXT_IN_BTN_EIGHT="textEight";
    private final String TEXT_IN_BTN_NINE="textNine";
    private final String TEXT_START_GAME="textStart";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();
    }
    @Override
    protected void onResume() {
        super.onResume();
        clickTextStart();
        clickOnButton();
    }
    private void clickTextStart(){
        txtStart.setOnClickListener(view -> {
            String txtNew=txtStart.getText().toString();
            if(checkGameStart) {
                if(txtNew.equals(getResources().getString(R.string.start_the_match))){
                    txtResultO.setText("0");
                    txtResultX.setText("0");
                    txtNumRound.setText("0");
                }
                int numRoundNew=Integer.parseInt(txtNumRound.getText().toString());
                txtNumRound.setText(""+(numRoundNew+1));
                checkGameStart = false;
                txtStart.setText(getResources().getText(R.string.the_round_is_playing));
                removeDataLastGame();
                txtLoadingO.setTextColor(getResources().getColor(R.color.dark_blue));
                txtLoadingX.setTextColor(getResources().getColor(R.color.dark_blue));
                if(oPlay){
                    txtLoadingX.setText("");
                    txtLoadingO.setText(getResources().getText(R.string.loading));
                }else {
                    txtLoadingO.setText("");
                    txtLoadingX.setText(getResources().getText(R.string.loading));
                }
            }
        });
    }
    private void clickOnButton(){
        btn_1_1.setOnClickListener(view -> {
            click(btn_1_1);
            printWinnerRound();
            printNoWinner();
            printWinnerAfterFiveRound();
        });
        btn_1_2.setOnClickListener(view -> {
            click(btn_1_2);
            printWinnerRound();
            printNoWinner();
            printWinnerAfterFiveRound();
        });
        btn_1_3.setOnClickListener(view -> {
            click(btn_1_3);
            printWinnerRound();
            printNoWinner();
            printWinnerAfterFiveRound();
        });
        btn_2_1.setOnClickListener(view -> {
            click(btn_2_1);
            printWinnerRound();
            printNoWinner();
            printWinnerAfterFiveRound();
        });
        btn_2_2.setOnClickListener(view -> {
            click(btn_2_2);
            printWinnerRound();
            printNoWinner();
            printWinnerAfterFiveRound();
        });
        btn_2_3.setOnClickListener(view -> {
            click(btn_2_3);
            printWinnerRound();
            printNoWinner();
            printWinnerAfterFiveRound();
        });
        btn_3_1.setOnClickListener(view -> {
            click(btn_3_1);
            printWinnerRound();
            printNoWinner();
            printWinnerAfterFiveRound();
        });
        btn_3_2.setOnClickListener(view -> {
            click(btn_3_2);
            printWinnerRound();
            printNoWinner();
            printWinnerAfterFiveRound();
        });
        btn_3_3.setOnClickListener(view -> {
            click(btn_3_3);
            printWinnerRound();
            printNoWinner();
            printWinnerAfterFiveRound();
        });
    }
    private void removeDataLastGame(){
        btn_1_1.setText("");
        btn_1_2.setText("");
        btn_1_3.setText("");
        btn_2_1.setText("");
        btn_2_2.setText("");
        btn_2_3.setText("");
        btn_3_1.setText("");
        btn_3_2.setText("");
        btn_3_3.setText("");
    }
    private void printNoWinner(){
        if (checkMatchNotWinner()){
            checkGameStart=true;
            txtLoadingX.setTextColor(getResources().getColor(R.color.teal_700));
            txtLoadingO.setTextColor(getResources().getColor(R.color.teal_700));
            txtStart.setText(getResources().getText(R.string.start_the_tour));
            txtLoadingO.setText(getResources().getString(R.string.Equality));
            txtLoadingX.setText(getResources().getString(R.string.Equality));
        }
    }
    private void printWinnerAfterFiveRound(){
        if(checkMatchNotWinner() || check()){
            if(txtNumRound.getText().toString().equals("5")){
                txtStart.setText(getResources().getText(R.string.start_the_match));
                if(Integer.parseInt(txtResultO.getText().toString())>Integer.parseInt(txtResultX.getText().toString())){
                    txtLoadingO.setTextColor(getResources().getColor(R.color.teal_200));
                    txtLoadingO.setText(getResources().getString(R.string.Winner));
                    txtLoadingX.setText("");
                }else if(Integer.parseInt(txtResultO.getText().toString())<Integer.parseInt(txtResultX.getText().toString())){
                    txtLoadingX.setTextColor(getResources().getColor(R.color.teal_200));
                    txtLoadingX.setText(getResources().getString(R.string.Winner));
                    txtLoadingO.setText("");
                }else {
                    txtLoadingX.setTextColor(getResources().getColor(R.color.teal_700));
                    txtLoadingO.setTextColor(getResources().getColor(R.color.teal_700));
                    txtLoadingO.setText(getResources().getString(R.string.Equality));
                    txtLoadingX.setText(getResources().getString(R.string.Equality));
                }
            }
        }
    }
    private boolean checkMatchNotWinner(){
        return !(check() || btn_1_1.getText().toString().isEmpty() || btn_1_2.getText().toString().isEmpty()
                || btn_1_3.getText().toString().isEmpty() || btn_2_1.getText().toString().isEmpty() ||
                btn_2_2.getText().toString().isEmpty() || btn_2_3.getText().toString().isEmpty() ||
                btn_3_1.getText().toString().isEmpty() || btn_3_2.getText().toString().isEmpty() ||
                btn_3_3.getText().toString().isEmpty());
    }
    private void initialization() {
        txtResultO=findViewById(R.id.txtOResultId);
        txtResultX=findViewById(R.id.txtXResultId);
        txtLoadingO=findViewById(R.id.oLoadingId);
        txtLoadingX=findViewById(R.id.xLoadingId);
        txtNumRound=findViewById(R.id.txtNumRoundId);
        btn_1_1=findViewById(R.id.btnOneOneId);
        btn_1_2=findViewById(R.id.btnOntTwoId);
        btn_1_3=findViewById(R.id.btnOneThreeId);
        btn_2_1=findViewById(R.id.btnTwoOneId);
        btn_2_2=findViewById(R.id.btnTwoTwoId);
        btn_2_3=findViewById(R.id.btnTwoThreeId);
        btn_3_1=findViewById(R.id.btnThreeOneId);
        btn_3_2=findViewById(R.id.btnThreeTwoId);
        btn_3_3=findViewById(R.id.btnThreeThreeId);
        txtStart=findViewById(R.id.textStartId);
    }
    private void click(TextView btn){
        if(btn.getText().toString().isEmpty()&& !checkGameStart){
            if (oPlay){
                btn.setText(getResources().getText(R.string.O));
                oPlay=false;
            }else {
                btn.setText(getResources().getText(R.string.X));
                oPlay=true;
            }
        }
    }
    private boolean check(){
        return  (btn_1_1.getText().toString()).equals(btn_1_2.getText().toString()) && (btn_1_3.getText().toString()).equals(btn_1_2.getText().toString()) &&
                !(btn_1_1.getText().toString().isEmpty()) || (btn_2_1.getText().toString()).equals(btn_2_2.getText().toString()) && (btn_2_3.getText().toString()).equals(btn_2_2.getText().toString()) &&
                !(btn_2_1.getText().toString().isEmpty()) || (btn_3_1.getText().toString()).equals(btn_3_2.getText().toString()) && (btn_3_3.getText().toString()).equals(btn_3_2.getText().toString()) &&
                !(btn_3_1.getText().toString().isEmpty()) || (btn_1_1.getText().toString()).equals(btn_2_1.getText().toString()) && (btn_3_1.getText().toString()).equals(btn_2_1.getText().toString()) &&
                !(btn_1_1.getText().toString().isEmpty()) || (btn_1_2.getText().toString()).equals(btn_2_2.getText().toString()) && (btn_3_2.getText().toString()).equals(btn_2_2.getText().toString()) &&
                !(btn_1_2.getText().toString().isEmpty()) || (btn_1_3.getText().toString()).equals(btn_2_3.getText().toString()) && (btn_3_3.getText().toString()).equals(btn_2_3.getText().toString()) &&
                !(btn_1_3.getText().toString().isEmpty()) || (btn_1_1.getText().toString()).equals(btn_2_2.getText().toString()) && (btn_3_3.getText().toString()).equals(btn_2_2.getText().toString()) &&
                !(btn_1_1.getText().toString().isEmpty()) || (btn_1_3.getText().toString()).equals(btn_2_2.getText().toString()) && (btn_3_1.getText().toString()).equals(btn_2_2.getText().toString()) &&
                !(btn_1_3.getText().toString().isEmpty());

    }
    @SuppressLint("SetTextI18n")
    private void printWinnerRound() {
        check=check();
        if(!checkGameStart){
            if(check){
                checkGameStart=true;
                if(!oPlay){
                    String result= txtResultO.getText().toString();
                    txtResultO.setText(""+(Integer.parseInt(result)+1));
                }else{
                    String result= txtResultX.getText().toString();
                    txtResultX.setText(""+(Integer.parseInt(result)+1));
                }
                if(Integer.parseInt(txtResultO.getText().toString())<3&&Integer.parseInt(txtResultX.getText().toString())<3){
                    if(!oPlay){
                        txtLoadingO.setTextColor(getResources().getColor(R.color.teal_200));
                        txtLoadingO.setText("Round winner");
                        txtLoadingX.setText("");

                    }else {
                        txtLoadingX.setTextColor(getResources().getColor(R.color.teal_200));
                        txtLoadingX.setText("Round winner");
                        txtLoadingO.setText("");
                    }
                    txtStart.setText(getResources().getText(R.string.start_the_tour));
                }else if(Integer.parseInt(txtResultO.getText().toString())==3){
                    txtLoadingO.setTextColor(getResources().getColor(R.color.teal_200));
                    txtLoadingO.setText("Winner");
                    txtLoadingX.setText("");
                    txtStart.setText(getResources().getText(R.string.start_the_match));
                }else if(Integer.parseInt(txtResultX.getText().toString())==3){
                    txtLoadingX.setTextColor(getResources().getColor(R.color.teal_200));
                    txtLoadingX.setText("Winner");
                    txtLoadingO.setText("");
                    txtStart.setText(getResources().getText(R.string.start_the_match));
                }
            }else {
                if (oPlay){
                    txtLoadingX.setText("");
                    txtLoadingO.setText(getResources().getText(R.string.loading));
                }else {
                    txtLoadingO.setText("");
                    txtLoadingX.setText(getResources().getText(R.string.loading));
                }
            }
        }
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(RESULT_O_PLAYER,txtResultO.getText().toString());
        outState.putString(RESULT_X_PLAYER,txtResultX.getText().toString());
        outState.putString(NUMBER_ROUND,txtNumRound.getText().toString());
        outState.putString(LOADING_X,txtLoadingX.getText().toString());
        outState.putString(LOADING_O,txtLoadingO.getText().toString());
        outState.putBoolean(O_PLAY_CHECK,oPlay);
        outState.putBoolean(CHECK_WIN_OR_NO,check);
        outState.putBoolean(CHECK_GAME,checkGameStart);
        outState.putString(TEXT_IN_BTN_ONE,btn_1_1.getText().toString());
        outState.putString(TEXT_IN_BTN_TWO,btn_1_2.getText().toString());
        outState.putString(TEXT_IN_BTN_THREE,btn_1_3.getText().toString());
        outState.putString(TEXT_IN_BTN_FOUR,btn_2_1.getText().toString());
        outState.putString(TEXT_IN_BTN_FIVE,btn_2_2.getText().toString());
        outState.putString(TEXT_IN_BTN_SIX,btn_2_3.getText().toString());
        outState.putString(TEXT_IN_BTN_SEVEN,btn_3_1.getText().toString());
        outState.putString(TEXT_IN_BTN_EIGHT,btn_3_2.getText().toString());
        outState.putString(TEXT_IN_BTN_NINE,btn_3_3.getText().toString());
        outState.putString(TEXT_START_GAME,txtStart.getText().toString());
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        check=savedInstanceState.getBoolean(CHECK_WIN_OR_NO);
        oPlay=savedInstanceState.getBoolean(O_PLAY_CHECK);
        checkGameStart=savedInstanceState.getBoolean(CHECK_GAME);
        txtResultO.setText(savedInstanceState.getString(RESULT_O_PLAYER));
        txtResultX.setText(savedInstanceState.getString(RESULT_X_PLAYER));
        txtNumRound.setText(savedInstanceState.getString(NUMBER_ROUND));
        btn_1_1.setText(savedInstanceState.getString(TEXT_IN_BTN_ONE));
        btn_1_2.setText(savedInstanceState.getString(TEXT_IN_BTN_TWO));
        btn_1_3.setText(savedInstanceState.getString(TEXT_IN_BTN_THREE));
        btn_2_1.setText(savedInstanceState.getString(TEXT_IN_BTN_FOUR));
        btn_2_2.setText(savedInstanceState.getString(TEXT_IN_BTN_FIVE));
        btn_2_3.setText(savedInstanceState.getString(TEXT_IN_BTN_SIX));
        btn_3_1.setText(savedInstanceState.getString(TEXT_IN_BTN_SEVEN));
        btn_3_2.setText(savedInstanceState.getString(TEXT_IN_BTN_EIGHT));
        btn_3_3.setText(savedInstanceState.getString(TEXT_IN_BTN_NINE));
        txtLoadingO.setText(savedInstanceState.getString(LOADING_O));
        txtLoadingX.setText(savedInstanceState.getString(LOADING_X));
        if(savedInstanceState.getString(LOADING_O).equals("Winner")||savedInstanceState.getString(LOADING_O).equals("Round winner")){
            txtLoadingO.setTextColor(getResources().getColor(R.color.teal_200));
        }else if(savedInstanceState.getString(LOADING_X).equals("Winner")||savedInstanceState.getString(LOADING_X).equals("Round winner")){
            txtLoadingX.setTextColor(getResources().getColor(R.color.teal_200));
        }else if(savedInstanceState.getString(LOADING_X).equals("Equality")){
            txtLoadingO.setTextColor(getResources().getColor(R.color.teal_700));
            txtLoadingX.setTextColor(getResources().getColor(R.color.teal_700));
        }
        if(savedInstanceState.getString(TEXT_START_GAME).equals("Start the match")){
            txtStart.setText(getResources().getText(R.string.start_the_match));
        }else if(savedInstanceState.getString(TEXT_START_GAME).equals("Start the round")){
            txtStart.setText(getResources().getText(R.string.start_the_tour));
        }else {
            txtStart.setText(getResources().getText(R.string.the_round_is_playing));
        }
    }
}