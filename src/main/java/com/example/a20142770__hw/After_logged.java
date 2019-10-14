package com.example.a20142770__hw;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//로그인 성공시의 화면 출력
public class After_logged extends Activity {
    EditText edit1, edit2;//입력 받을 두개의 FIRST_NUM, SECOND_NUM을 저장할 변수.
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;//결과창이다.

    String num1, num2;
    Button [] numButtons = new Button[10];

    int [] numBtnIDs = { R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout8);
        //setTitle("테이블레이아웃 계산기");

        setContentView(R.layout.after_login);
        setTitle("GRIDLAYOUT XML이용한 계산기입니다");

        edit1 = (EditText) findViewById(R.id.first_num);
        edit2 = (EditText) findViewById(R.id.second_num);

        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);

        textResult = (TextView) findViewById(R.id.TextResult);

        //버튼 id ui 별 눌렀을 떄 처리하기위해 저장해놓는다. 각각의 버튼이 눌리면 어떤값으로 계산할지에 대해서 numButtons에 저장한다.
        for (int i = 0; i < numBtnIDs.length; i++) {
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
        }

        for (int i = 0; i < numBtnIDs.length; i++) {
            final int index;
            index = i;

            //버튼 UI 두개를 누를 경우, 나중에 연산을 이해 넣어놓는다.NUM1, NUM2
            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (edit1.isFocused() == true) {
                        num1 = edit1.getText().toString() + numButtons[index].getText().toString();
                        edit1.setText(num1);
                    } else if(edit2.isFocused() == true) {
                        num2 = edit2.getText().toString() + numButtons[index].getText().toString();
                        edit2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(), "먼저 입력할 란을 선택하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                int result = Integer.parseInt(num1) + Integer.parseInt(num2);

                textResult.setText("계산 결과:" + result);
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                int result = Integer.parseInt(num1) - Integer.parseInt(num2);

                textResult.setText("계산 결과:" + result);
            }
        });


        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                int result = Integer.parseInt(num1) * Integer.parseInt(num2);

                textResult.setText("계산 결과:" + result);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                int result = Integer.parseInt(num1) / Integer.parseInt(num2);

                textResult.setText("계산 결과:" + result);
            }
        });

    }
}
