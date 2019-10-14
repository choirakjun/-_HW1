package com.example.a20142770__hw;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Pattern;


public class enroll extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enroll);





        Button check_id;
        check_id = (Button)findViewById(R.id.check_id);
        check_id.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {



                boolean is_ok = true;

                //id중복 검사
                EditText input_id;
                input_id = (EditText) findViewById(R.id.enroll_input_id);
                String id = input_id.getText().toString();

                //읽기
                try{
                    BufferedReader br = new BufferedReader(new FileReader(getFilesDir()+"user_data.txt"));
                    //String readStr = "";
                    String str = null;
                    while(((str = br.readLine()) != null)){

                        if(str.toString() == id)
                            is_ok=false;
                        //  readStr += str +"\n";
                    }
                    br.close();

                }catch (IOException e) {
                    e.printStackTrace();
                }





//
//                String line = null; // 한줄씩 읽기
//                File saveFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+ "/hw"); // 저장 경로
//                System.out.println("dir!!!!!!!!!!!!!!!!!!!!!===>"+saveFile);
//                // 폴더 생성
//                if(!saveFile.exists()){ // 폴더 없을 경우
//                    saveFile.mkdir(); // 폴더 생성
//                }
//                try {
//                    BufferedReader buf = new BufferedReader(new FileReader(saveFile+"/user_data.txt"));
//                    while((line=buf.readLine())!=null){
//                        if(line.toString() == id)
//                        {
//                            is_ok=false;
//                        }
//                    }
//                    buf.close();
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }




//                String file_name = Environment.getExternalStorageDirectory().getAbsolutePath() + "/TestLog/user_data.txt";
//                System.out.println(file_name);
//                StringBuffer strBuffer = new StringBuffer();
//                try {
//                    InputStream is = new FileInputStream(file_name);
//                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//                    String line = "";
//                    while ((line = reader.readLine()) != null) {
//                        strBuffer.append(line + "\n");
//                        if (line.toString() == id) {
//                            is_ok = false;
//                        }
//
//                    }
//
//                    reader.close();
//                    is.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//
//                }


                if (is_ok == false) {
                    Toast toast = Toast.makeText(getApplicationContext(), "ID중복됩니다", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "ID 사용가능합니다.", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });


        final Button check_pw;
        check_pw = (Button)findViewById(R.id.check_pw);
        check_pw.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                boolean is_ok = true;

                //pw검사
                EditText input_pw ;
                input_pw= (EditText) findViewById(R.id.enroll_input_pw);
                String pw = input_pw.getText().toString();
                String pwPattern = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,10}$";
                Boolean tt = Pattern.matches(pwPattern,pw);
                if(tt==false)
                {

                    Toast toast = Toast.makeText(getApplicationContext(), "비밀번호는 대,소문자,숫자,특수문자로 구성되며 9-12자리여야 합니다.", Toast.LENGTH_LONG);
                    toast.show();

                }

                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "비밀번호 사용가능합니다", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });




        Button submit;
        submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                boolean is_ok = true;

                //약관 동의 여부 <-- 라디오 그룹에서 선택된 라디어 버튼의 값을 찾아서 확인한다.
                RadioGroup rg = (RadioGroup) findViewById(R.id.ok_false_enroll);
                int radio_id = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton)findViewById(radio_id);
                String res = rb.getText().toString();
                System.out.println(res);
                if (res.equals("Decline")){
                    is_ok=false;
                    System.out.println("여기실행");

                }
                System.out.println(is_ok);
                if(is_ok==true)
                {

                    //data load
                    EditText input_id ;
                    input_id= (EditText) findViewById(R.id.enroll_input_id);
                    String id = input_id.getText().toString();
                    EditText input_pw ;
                    input_pw= (EditText) findViewById(R.id.enroll_input_pw);
                    String pw = input_pw.getText().toString();
                    EditText enroll_name ;
                    enroll_name= (EditText) findViewById(R.id.enroll_name);
                    String name = enroll_name.getText().toString();
                    EditText enroll_phone_number ;
                    enroll_phone_number= (EditText) findViewById(R.id.enroll_phone_number);
                    String phone_number = enroll_phone_number.getText().toString();
                    EditText enroll_address ;
                    enroll_address= (EditText) findViewById(R.id.enroll_address);
                    String address = enroll_address.getText().toString();



                    //DATA입력
//                    String foldername = Environment.getExternalStorageDirectory().getAbsolutePath()+"/TestLog";
//                    String filename = "user_data.txt";
                    String contents = id+"\n"+pw+"\n"+name+"\n"+phone_number+"\n"+address+"\n";

                    try{
                        BufferedWriter buf = new BufferedWriter(new FileWriter(getFilesDir() + "user_data.txt", true));
                        buf.append(id); // 데이터 입력
                        buf.newLine(); // 개행
                        buf.append(pw); // 데이터 입력
                        buf.newLine(); // 개행
                        buf.append(name); // 데이터 입력
                        buf.newLine(); // 개행
                        buf.append(phone_number); // 데이터 입력
                        buf.newLine(); // 개행
                        buf.append(address); // 데이터 입력
                        buf.newLine(); // 개행
                        buf.close();
                        Toast toast = Toast.makeText(getApplicationContext(), "회원 저장 완료.", Toast.LENGTH_LONG);
                        toast.show();
                    }catch (Exception e){
                        e.printStackTrace();

                    }


//
//                    // 파일 생성
//                    File saveFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+ "/hw"); // 저장 경로
//                    // 폴더 생성
//                    if(!saveFile.exists()){ // 폴더 없을 경우
//                        saveFile.mkdir(); // 폴더 생성
//                    }
//                    try {
//
//                        BufferedWriter buf = new BufferedWriter(new FileWriter(saveFile+"/user_data.txt", true));
//                        buf.append(id); // 데이터 입력
//                        buf.newLine(); // 개행
//                        buf.append(pw); // 데이터 입력
//                        buf.newLine(); // 개행
//                        buf.append(name); // 데이터 입력
//                        buf.newLine(); // 개행
//                        buf.append(phone_number); // 데이터 입력
//                        buf.newLine(); // 개행
//                        buf.append(address); // 데이터 입력
//                        buf.newLine(); // 개행
//                        buf.close();
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }






//                    try{
//                        File dir = new File (foldername);
//                        //디렉토리 폴더가 없으면 생성함
//                        if(!dir.exists()){
//                            dir.mkdir();
//                        }
//                        //파일 output stream 생성
//                        FileOutputStream fos = new FileOutputStream(foldername+"/"+filename, true);
//                        //파일쓰기
//                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
//                        writer.write(contents);
//                        writer.flush();
//
//                        writer.close();
//                        fos.close();
//                    }catch (IOException e){
//                        e.printStackTrace();
//                    }
                    //첫 번째 페이지도 이동
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);

                }
                else
                {
                    //에러 메시지 출력
                    Toast toast = Toast.makeText(getApplicationContext(), "아이디 중복검사 , 비밀번호 검사, 약관 동의를 해주셔야 합니다.", Toast.LENGTH_LONG);
                    toast.show();
                }

            }
    });

    }
}
