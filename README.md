# -_HW1
첫 화면에서 로그인, 회원가입 기능 구현. 두번 째 화면에서 회원 가입기능. 세번쨰 화면에서 계산기 기능.


로그인 및 회원가입 후 계산기 구현. 

첫번째 화면(로그인):
Relative Layout을 사용하고 PPT에 나와있는 속성들을 이용해서 화면 배치.
로그인버튼, 회원가입 버튼으로 구성.

처음,ID와 PW를 입력받고 해당 정보가 있는지 확인하여 존재하면 3번째 계산기 화면을 보여준다.
그렇지 않으면 회원정보가 없다고 TOAST를 이용하여 사용자에게 알려준다. 
회원가입 버튼을 통해 두번째 회원가입 화면을 보여준다.
이 때, 처음 화면 진입시 회원정보파일에 대해서 생성해줘야 한다. 
EXTERNAL STORAGE를 사용하려 했으나 SDK버전확인 하는부분에 이해가 안되서 INTERNAL STORAGE 를 사용하였습니다.

두 번째 화면(회원가입):
LINEAR LAYOUT의 WEIGHT을 통해서 스크롤을 따로 사용하지않아도 한번에 보이도록 설정했다.
ID중복확인버튼을 통해 파일에 존재하는지확인, PW관련해서 정규식표현과 PATTERN 기능을 통해 특수문자 포함 대소문자 9-12글자로 구성되로록확인하고 , RADIO GROUP으로 약관 ACCEPT버튼, DECLINE버튼을 묶어서 DECLINE버튼 묶었을 시 회원가입 실패하도록 TOAST로 알림. 

세 번째 화면(계산기):
GRID LAYOUT을 이용하여 전체 화면을 배치. 이떄 관련 속성부분은 인터넷 참조하였습니다.
이후, XML에 각 버튼에 대한 ID부분을 배열로 만들어 해당 버튼이 눌렀을 때 어떤 숫가 값으로 연산하느 부분을 배열화하여이용해서 ADD,MUL등 연산기능 이용하고 최종 연산 값을 보여준다.
