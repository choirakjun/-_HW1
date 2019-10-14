package com.example.a20142770__hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



            try {
                BufferedWriter buf = new BufferedWriter(new FileWriter(getFilesDir() + "user_data.txt", true));
                buf.close();
            }catch (Exception e){
                e.printStackTrace();

            }


        /*


//읽기
String line = null; // 한줄씩 읽기
File saveFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/db"); // 저장 경로
// 폴더 생성
if(!saveFile.exists()){ // 폴더 없을 경우
    saveFile.mkdir(); // 폴더 생성
}
try {
    BufferedReader buf = new BufferedReader(new FileReader(saveFile+"/user_data.txt"));
    while((line=buf.readLine())!=null){
        tv.append(line);
        tv.append("\n");
    }
    buf.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}




//쓰기
String str = input_text.getText().toString();
// 파일 생성
File saveFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/db"); // 저장 경로
// 폴더 생성
if(!saveFile.exists()){ // 폴더 없을 경우
    saveFile.mkdir(); // 폴더 생성
}
try {
    long now = System.currentTimeMillis(); // 현재시간 받아오기
    Date date = new Date(now); // Date 객체 생성
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String nowTime = sdf.format(date);

    BufferedWriter buf = new BufferedWriter(new FileWriter(saveFile+"/user_data.txt", true));
    buf.append(nowTime + " "); // 날짜 쓰기
    buf.append(str); // 파일 쓰기
    buf.newLine(); // 개행
    buf.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}





         */

        //회원가입 버튼 클릭 시
        Button enroll;
        enroll = (Button)findViewById(R.id.enroll);
        enroll.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(),enroll.class);
                startActivity(intent);
            }
        });


        //id , pw 입력 후 로그인 버튼 클릭 시
        Button login;
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {

                //EditText를 통해 받은 id 및 password 를 input_id , input_pw에 저장.
                EditText input_id ;
                input_id = (EditText) findViewById(R.id.input_id);
                String id = input_id.getText().toString();

                EditText input_pw ;
                input_pw = (EditText) findViewById(R.id.input_pw);
                String pw = input_pw.getText().toString();



                //파일에 해당 id와 비밀번호를 가진 회원이 존재하는지 확인한다.
                boolean is_Existed=false;
                boolean id_Existed=false;
                boolean pw_Existed=false;
//                List<String> tv = new ArrayList<>();
//
//                String line = null; // 한줄씩 읽기
//                File saveFile = new File("/hw"); // 저장 경로
//                // 폴더 생성
//                if(!saveFile.exists()){ // 폴더 없을 경우
//                    saveFile.mkdir(); // 폴더 생성
//                }

//
//                try {
//                    BufferedReader buf = new BufferedReader(new FileReader(saveFile+"/user_data.txt"));
//                    while((line=buf.readLine())!=null){
//                        if(line.toString() == id)
//                        {
//                            id_Existed=true;
//
//                        }
//                        if(line.toString() == pw)
//                        {
//                            pw_Existed=true;
//                        }
//
//                    }
//                    buf.close();
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }


//                //input_id , input_pw를 이용한 회원 정보 유무 파악
//                String file_name = Environment.getExternalStorageDirectory().getAbsolutePath()+"/TestLog/user_data.txt";
//                StringBuffer strBuffer = new StringBuffer();
//                try{
//                    InputStream is = new FileInputStream(file_name);
//                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//                    String line="";
//                    while((line=reader.readLine())!=null){
//                        strBuffer.append(line+"\n");
//                        if(line.toString()==id){
//                            id_Existed=true;
//                        }
//                        if(line.toString()==pw) {
//                            pw_Existed = true;
//                        }
//                    }
//
//                    reader.close();
//                    is.close();
//                }catch (IOException e){
//                    e.printStackTrace();
//
//                }
                try{
                    BufferedReader br = new BufferedReader(new FileReader(getFilesDir()+"user_data.txt"));
                    //String readStr = "";
                    String str = null;
                    while(((str = br.readLine()) != null)){
                        if(str.toString().equals(id))
                            id_Existed=true;
                        if(str.toString().equals(pw))
                            pw_Existed=true;
                        //  readStr += str +"\n";
                    }
                    br.close();

                }catch (IOException e) {
                    e.printStackTrace();
                }

                if(id_Existed && pw_Existed)
                {
                    is_Existed=true;
                }


                if(is_Existed==true){
                    //is_Existed 가 True --> 3번째 화면으로 넘어간다.
                    Intent intent = new Intent(getApplicationContext(),After_logged.class);
                    startActivity(intent);

                }
                else {
                    //is_Existed 가 False --> 회원정보없다고 출력
                    Toast toast = Toast.makeText(getApplicationContext(), "회원 정보 없습니다.", Toast.LENGTH_LONG);
                    toast.show();
                }

            }
        });



    }





}
