package cn.buaa.red.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvScreen;
    private List<Item> items = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvScreen = findViewById(R.id.tvScreen);

        findViewById(R.id.btn0).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);
        findViewById(R.id.btnADD).setOnClickListener(this);
        findViewById(R.id.btnSUB).setOnClickListener(this);
        findViewById(R.id.btnMUL).setOnClickListener(this);
        findViewById(R.id.btnDIV).setOnClickListener(this);
        findViewById(R.id.btnRESULT).setOnClickListener(this);
        findViewById(R.id.btnCLEAR).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn0:
                tvScreen.append("0");
                break;
            case R.id.btn1:
                tvScreen.append("1");
                break;
            case R.id.btn2:
                tvScreen.append("2");
                break;
            case R.id.btn3:
                tvScreen.append("3");
                break;
            case R.id.btn4:
                tvScreen.append("4");
                break;
            case R.id.btn5:
                tvScreen.append("5");
                break;
            case R.id.btn6:
                tvScreen.append("6");
                break;
            case R.id.btn7:
                tvScreen.append("7");
                break;
            case R.id.btn8:
                tvScreen.append("8");
                break;
            case R.id.btn9:
                tvScreen.append("9");
                break;
            case R.id.btnADD:
                items.add(new Item(Double.parseDouble(tvScreen.getText().toString()),Types.NUM));
                checkAndCompute();
                items.add(new Item(0,Types.ADD));
                tvScreen.setText("");
                break;
            case R.id.btnSUB:
                items.add(new Item(Double.parseDouble(tvScreen.getText().toString()),Types.NUM));
                checkAndCompute();
                items.add(new Item(0,Types.SUB));
                tvScreen.setText("");
                break;
            case R.id.btnMUL:
                items.add(new Item(Double.parseDouble(tvScreen.getText().toString()),Types.NUM));
                checkAndCompute();
                items.add(new Item(0,Types.MUL));
                tvScreen.setText("");
                break;
            case R.id.btnDIV:
                items.add(new Item(Double.parseDouble(tvScreen.getText().toString()),Types.NUM));
                checkAndCompute();
                items.add(new Item(0,Types.DIV));
                tvScreen.setText("");
                break;
            case R.id.btnCLEAR:
                tvScreen.setText("");
                items.clear();
                break;
            case R.id.btnRESULT:
                items.add(new Item(Double.parseDouble(tvScreen.getText().toString()),Types.NUM));
                checkAndCompute();
                tvScreen.setText(items.get(0).value+"");
                items.clear();
                break;
        }
    }

    public void checkAndCompute(){
        if( items.size() >= 3 ){
            double a = items.get(0).value;
            double b = items.get(2).value;
            int opt = items.get(1).type;
            items.clear();

            switch (opt){
                case 1:
                    items.add(new Item(a+b,Types.NUM));
                    break;
                case 2:
                    items.add(new Item(a-b,Types.NUM));
                    break;
                case 3:
                    items.add(new Item(a*b,Types.NUM));
                    break;
                case 4:
                    items.add(new Item(a/b,Types.NUM));
                    break;
            }
        }
    }
}