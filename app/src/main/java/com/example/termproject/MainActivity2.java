package com.example.termproject;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity2<clip> extends AppCompatActivity {

    public static Context mContext; //외부에서 Activity 함수 호출용 Context

    public String stock_name[] = {"DRB동일", "DSR", "GS글로벌", "HDC현대산업개발", "KEC", "KG동부제철", "KG케미칼", "KTis", "LG이노텍", "LG전자", "LG헬로비전", "OCI", "SK이노베이션", "STX", "WISCOM", "갤럭시아에스엠", "경농", "경동인베스트", "국도화학", "국동", "극동유화", "기아", "까뮤이앤씨", "대덕전자", "대우건설", "대웅", "덴티움", "두산인프라코어", "디피씨", "락앤락", "롯데정보통신", "마니커", "메리츠증권", "명문제약", "모두투어리츠", "부국증권", "삼성SDI", "삼성엔지니어링", "삼성출판사", "삼성화재해상보험", "삼영화학공업", "삼호개발", "상상인증권", "선진", "세기상사", "세방전지", "세아제강지주", "세화아이엠씨", "신라교역", "신한알파리츠", "신한지주", "쌍용자동차", "쎌마테라퓨틱스", "영화금속", "오뚜기", "우진", "윌비스", "유나이티드", "이월드", "인지컨트롤스", "인터지스", "일성건설", "일진다이아", "자화전자", "제일약품", "제일파마홀딩스", "조비", "조흥", "종근당홀딩스", "지역난방공사", "코오롱인더", "키다리스튜디오", "태경산업", "태양금속공업", "포스코", "포스코강판", "한국공항", "한국종합기술", "한국패러랠", "한솔로지스틱스", "한일철강", "한창제지", "한화생명", "현대건설", "현대건설기계", "현대비앤지스틸", "현대엘리베이터", "현대차증권", "호전실업", "EDGC", "ES큐브", "GS홈쇼핑", "JW신약", "KB오토시스", "KH바텍", "YW", "강스템바이오텍", "경창산업", "교보9호스팩", "국순당", "국일제지", "그리티", "나노브릭", "나노스", "네오리진", "네오위즈", "네오티스", "네이처셀", "녹십자셀", "농우바이오", "뉴인텍", "대동기어", "대봉엘에스", "대유", "대유에이피", "대주산업", "대한그린파워", "대한약품", "동구바이오제약", "디에이테크놀로지", "디에이피", "디엔에프", "디지틀조선", "룽투코리아", "링크제니시스", "모두투어", "모비스", "모트렉스", "미래에셋대우스팩3호", "미스터블루", "미코바이오메드", "바디텍메드", "브랜드엑스코퍼레이션", "삼보판지", "삼아제약", "상지카일룸", "샘씨엔에스", "서암기계공업", "선진뷰티사이언스", "성창오토텍", "세보엠이씨", "세종메디칼", "셀바스헬스케어", "셀트리온제약", "스타모빌리티", "스튜디오산타클로스", "스페코", "승일", "시티랩스", "신영스팩6호", "쌍용정보통신", "썸에이지", "쎄미시스코", "씨이랩", "씨케이에이치", "아나패스", "아이비김영", "아이센스", "아이씨디", "아이씨케이", "아이오케이", "아이원스", "아이즈비전", "아이큐어", "아이티센", "알에프세미", "알에프텍", "애니플러스", "앤디포스", "어보브반도체", "에스앤더블류", "에스앤에스텍", "에스에너지", "에쎈테크", "에이디테크놀로지", "에이루트", "에이스토리", "에이치엘비파워", "에이티넘인베스트", "엑세스바이오", "엑시콘", "엔시트론", "엔투텍", "엘아이에스", "엠게임", "엠벤처투자", "엠씨넥스", "영화테크", "예스티", "오공", "오스템임플란트", "오픈베이스", "옵티시스", "원방테크", "원익QnC", "웰크론", "위지트", "유니온커뮤니티", "유니테크노", "유비쿼스홀딩스", "유신", "유안타제5호스팩", "유안타제7호스팩", "유진스팩5호", "유테크", "유티아이", "이베스트스팩5호", "이베스트이안스팩1호", "이스트소프트", "이스트아시아홀딩스", "이엠넷", "이지바이오", "인베니아", "인텍플러스", "자비스", "자이글", "정상제이엘에스", "제우스", "제이씨현시스템", "제이엘케이", "제이엠티", "제주반도체", "조아제약", "주성엔지니어링", "지엔씨에너지", "지엔코", "초록뱀컴퍼니", "캐스텍코리아", "케이비제20호스팩", "케이프이에스제4호", "케이피엠테크", "케이피티유", "켄코아에어로스페이스", "코스나인", "코스온", "코오롱생명과학", "코프라", "크로바하이텍", "키네마스터", "테스나", "토탈소프트", "트루윈", "특수건설", "티앤알바이오팹", "파라텍", "파세코", "파워로직스", "파커스", "패션플랫폼", "포인트엔지니어링", "푸드웰", "프로스테믹스", "피델릭스", "피에스엠씨", "피제이전자", "하나금융15호스팩", "하나기술", "하이즈항공", "한국경제TV", "한국맥널티", "한국선재", "한국테크놀로지", "한솔인티큐브", "한양디지텍", "현대무벡스", "현대바이오", "현대바이오랜드", "화성밸브", "휴맥스", "희림", "골프존데카", "관악산업", "나눔테크", "다이오진", "선바이오", "씨앗", "에스알바이오텍", "에이스캠퍼", "엘리비젼", "유투바이오", "이도바이오", "진코스텍", "큐엠씨", "티티씨디펜스", "폭스소프트", "CJ대한통운", "CJ제일제당", "KB금융", "KC코트렐", "KPX케미칼", "KR모터스", "KTcs", "LS전선아시아", "LX홀딩스", "SK렌터카", "SPC삼립", "강원랜드", "교보증권", "금강공업", "금호건설", "금호전기", "기업은행", "남성", "넷마블", "대구백화점", "대영포장", "대원제약", "대한방직", "대한전선", "대한제당", "대한해운", "덕양산업", "동원F&B", "동원금속", "디씨엠", "롯데제과", "롯데하이마트", "백산", "보락", "빙그레", "사조대림", "사조동아원", "삼양식품", "삼진제약", "서원", "세방", "세아홀딩스", "세우글로벌", "세이브존I&C", "솔루스첨단소재", "신송홀딩스", "신일전자", "신풍제약", "아이마켓코리아", "아이에이치큐", "엔씨소프트", "영보화학", "영진약품", "영풍", "우리금융캐피탈", "유니온머티리얼", "이마트", "이수화학", "이스타코", "인천도시가스", "일동홀딩스", "지엠비코리아", "케이씨텍", "코리아써키트", "코스모화학", "코아스", "코오롱", "코오롱플라스틱", "쿠쿠홀딩스", "큐로", "태영건설", "티비에이치글로벌", "포스코케미칼", "한국금융지주", "한국전자홀딩스", "한국주철관공업", "한국콜마", "한국타이어앤테크놀로지", "한국토지신탁", "한국프랜지공업", "한온시스템", "한올바이오파마", "해태제과식품", "현대에너지솔루션", "호텔신라", "화승알앤에이", "화승인더스트리", "화천기공", "환인제약", "효성", "효성화학", "흥아해운", "APS홀딩스", "CS", "CSA 코스믹", "HRS", "KTH", "NHN벅스", "NICE평가정보", "PN풍년", "RF머트리얼즈", "THQ", "TS트릴리온", "갤럭시아머니트리", "경남제약헬스케어", "고영", "국영지앤엠", "나노엔텍", "나이벡", "남화토건", "네오팜", "넥스틴", "넵튠", "노바렉스", "뉴로스", "대성파인텍", "대아티아이", "대양제지", "대주전자재료", "대창솔루션", "덕산네오룩스", "동국S&C", "동국산업", "동아엘텍", "디딤", "디알텍", "디엠티", "디오", "딜리", "럭슬", "레드캡투어", "레이언스", "로보로보", "루트로닉", "리더스코스메틱", "릭스솔루션", "매일홀딩스", "머큐리", "메디앙스", "메디프론", "메타바이오메드", "멕아이씨에스", "멜파스", "무림SP", "미래에셋벤처투자", "바이오로그디바이스", "박셀바이오", "부스타", "비트컴퓨터", "삼륭물산", "삼성스팩4호", "삼양옵틱스", "삼일", "삼일기업공사", "삼지전자", "삼진", "삼표시멘트", "삼화네트웍스", "상보", "상신이디피", "서호전기", "성우하이텍", "세경하이테크", "세명전기", "셀바스AI", "손오공", "솔루에타", "솔브레인", "슈프리마", "스튜디오드래곤", "스포츠서울", "시스웍", "신라에스지", "신한제6호스팩", "씨앤투스성진", "씨앤티85", "아가방컴퍼니", "아래스", "아모텍", "아미코젠", "아이에이", "아이퀘스트", "액트로", "앱코", "에스에스알", "에스엘바이오닉스", "에스티팜", "에이씨티", "에프알텍", "엠에프엠코리아", "연이비앤티", "영신금속", "예림당", "오성첨단소재", "오션브릿지", "와이더플래닛", "와이지-원", "우리로", "우리손에프앤지", "우림기계", "우수AMS", "원익큐브", "원일특강", "윈하이텍", "윌링스", "유니테스트", "유바이오로직스", "유안타제8호스팩", "육일씨엔에쓰", "이글루시큐리티", "이글벳", "이녹스", "이랜시스", "이삭엔지니어링", "이엔코퍼레이션", "이지케어텍", "인바디", "인선이엔티", "인포바인", "인포뱅크", "잉크테크", "전진바이오팜", "정다운", "제놀루션", "제일바이오", "제일제강", "젬백스지오", "조이시티", "지니뮤직", "지니언스", "지니틱스", "지란지교시큐리티", "지유온", "지티지웰니스", "참좋은여행", "천보", "케이씨피드", "케이엔더블유", "코데즈컴바인", "코드네이처", "코리아센터", "코메론", "코미팜", "코아시아", "코웰패션", "코위버", "큐브앤컴퍼니", "큐브엔터", "크루셜텍", "크리스탈지노믹스", "클리노믹스", "테고사이언스", "테라사이언스", "테라젠이텍스", "파멥신", "파수", "파인디지털", "팍스넷", "팬엔터테인먼트", "펌텍코리아", "풍강", "플레이디", "피에스텍", "피엔티", "픽셀플러스", "핌스", "핑거", "하나금융14호스팩", "하나마이크론", "하나머스트7호스팩", "하이제6호스팩", "한국바이오젠", "한국비엔씨", "한국정보인증", "한국코퍼레이션", "한글과컴퓨터", "한일단조", "한일화학", "한컴MDS", "한컴위드", "현진소재", "형지I&C", "휴네시온", "휴맥스홀딩스", "흥국에프엔비", "노드메이슨", "단디바이오", "대주이엔티", "메디안디노스틱", "미애부", "바이오시네틱스", "바이오프로테크", "바이옵트로", "아이피몬스터", "앙츠", "에이치엔에스하이텍", "이노벡스", "테크엔", "테크트랜스", "틸론", "휴럼", "BGF리테일", "BNK금융지주", "GS건설", "HDC아이콘트롤스", "LG상사", "MH에탄올", "SBS", "SBS미디어홀딩스", "SG글로벌", "SH에너지화학", "SK", "SK가스", "SK텔레콤", "STX중공업", "YG PLUS", "국제약품", "금양", "금호타이어", "넥센타이어", "녹십자홀딩스", "농심홀딩스", "다스코", "대웅제약", "대한유화", "더존비즈온", "덕성", "도화엔지니어링", "동서", "동양", "동양생명", "디아이", "디와이", "롯데정밀화학", "롯데푸드", "만도", "맥쿼리인프라", "메타랩스", "모토닉", "미래에셋맵스리츠", "미원화학", "범양건영", "베트남개발1", "삼성바이오로직스", "삼성에스디에스", "삼성증권", "삼성카드", "삼양통상", "삼영무역", "삼일제약", "삼정펄프", "샘표식품", "서연이화", "성보화학", "세아제강", "센트랄모텍", "송원산업", "수산중공업", "신도리코", "신성이엔지", "신세계인터내셔날", "신세계푸드", "신화실업", "쌍용씨앤이", "씨아이테크", "아모레퍼시픽그룹", "아이에스동서", "애경산업", "에스엘", "엔에이치엔", "유니켐", "유양디앤유", "유화증권", "이구산업", "일성신약", "일정실업", "제이에스코퍼레이션", "제이준코스메틱", "조선선재", "종근당바이오", "지누스", "진도", "진양화학", "케이탑리츠", "코스모신소재", "태평양물산", "테이팩스", "텔코웨어", "티와이홀딩스", "팜스코", "하이스틸", "하이트진로", "한국석유공업", "한국수출포장공업", "한국자산신탁", "한국전력공사", "한국주강", "한국콜마홀딩스", "한국항공우주", "한라홀딩스", "한미사이언스", "한샘", "한솔홀딩스", "한신공영", "한신기계공업", "한화에어로스페이스", "현대퓨처넷", "효성 ITX", "휴니드테크놀러지스", "IBKS제13호스팩", "JTC", "KCC건설", "KCI", "KG ETS", "NEW", "SBI핀테크솔루션즈", "SGA솔루션즈", "SK4호스팩", "SM Life Design", "WI", "고려시멘트", "골드앤에스", "국일신동", "국전약품", "나노신소재", "나무가", "나인테크", "넥스트아이", "넥슨지티", "노터스", "다산네트웍스", "다원시스", "대명소노시즌", "대성미생물", "대원산업", "대한광통신", "더블유에스아이", "덕신하우징", "덴티스", "동국알앤에스", "동신건설", "동일기연", "듀오백", "디지아이", "디지털대성", "디티앤씨", "라이트론", "램테크놀러지", "레고켐바이오", "레몬", "로보스타", "리드코프", "맥스로텍", "메디콕스", "메디포스트", "미래컴퍼니", "바이오니아", "베셀", "보라티알", "부방", "브리지텍", "비디아이", "비즈니스온", "삼보산업", "삼영에스앤씨", "삼진엘앤디", "삼천리자전거", "삼현철강", "서산", "성우테크론", "세운메디칼", "세종텔레콤", "세코닉스", "소리바다", "솔고바이오", "솔본", "솔브레인홀딩스", "수산아이앤티", "슈펙스비앤피", "슈피겐코리아", "스카이이앤엠", "시공테크", "시큐브", "신도기연", "신테카바이오", "신흥에스이씨", "실리콘웍스", "쎄노텍", "쎄트렉아이", "씨엠에스에듀", "씨큐브", "아비코전자", "아스타", "아이디피", "아이톡시", "아진산업", "아프리카TV", "안트로젠", "알체라", "알티캐스트", "애니젠", "앱클론", "에스제이그룹", "에스트래픽", "에스퓨얼셀", "에이디칩스", "에이비엘바이오", "에이스침대", "에이치피오", "에이텍티앤", "에코프로에이치엔", "에코플라스틱", "엑셈", "엔브이에이치코리아", "엔지스테크널러지", "엔지켐생명과학", "엔케이맥스", "엔텔스", "엘디티", "엘컴텍", "영림원소프트랩", "오리엔트정공", "오스테오닉", "오텍", "와이즈버즈", "원익머트리얼즈", "원풍", "웹젠", "위닉스", "위메이드", "유비벨록스", "유비쿼스", "유안타제4호스팩", "유진테크", "이건홀딩스", "이노와이어리스", "이녹스첨단소재", "이디티", "이랜텍", "이수앱지스", "인산가", "인성정보", "인탑스", "인터파크", "인텔리안테크", "자이언트스텝", "재영솔루텍", "제낙스", "제이시스메디칼", "제이앤티씨", "제이티", "제주맥주", "좋은사람들", "진바이오텍", "진성티이씨", "청보산업", "초록뱀미디어", "카스", "카이노스메드", "캐리소프트", "캠시스", "케어젠", "케이비제18호스팩", "케이비제19호스팩", "케이엠더블유", "케이피에프", "코디엠", "코리아에셋투자증권", "코미코", "코스맥스엔비티", "코스메카코리아", "코아시아옵틱스", "코이즈", "키이스트", "태웅로직스", "테라셈", "텔콘RF제약", "토비스", "티라유텍", "티비씨", "티엘비", "파나진", "파버나인", "파워넷", "판타지오", "프로텍", "피에스케이", "피에이치씨", "피에이치에이", "필옵틱스", "하나금융16호스팩", "하이제5호스팩", "한국정보통신", "한국제8호스팩", "한국캐피탈", "한일네트웍스", "한화플러스제1호스팩", "헬릭스미스", "현우산업", "휴먼엔", "럭스피아", "무진메디", "씨앤에스링크", "에스제이켐", "엠로", "이십일스토어", "이엠티", "인카금융서비스", "태양기계", "한중엔시에스", "AJ네트웍스", "DL건설", "DSR제강", "ESR켄달스퀘어리츠", "GKL", "JW중외제약", "KPX홀딩스", "KSS해운", "LG하우시스", "LG화학", "LIG넥스원", "LS", "NAVER", "NICE", "NI스틸", "SK증권", "SNT에너지", "가온전선", "경인양행", "경인전자", "국보", "기신정기", "남선알미늄", "녹십자", "대덕", "대동전자", "대림비앤코", "대양금속", "대원강업", "대창", "동국제강", "동화약품", "두산", "두산밥캣", "디아이동일", "디아이씨", "롯데관광개발", "롯데칠성음료", "롯데케미칼", "맵스리얼티1", "명신산업", "무학", "미래아이앤지", "바다로19호", "부산산업", "부산주공", "사조산업", "사조씨푸드", "삼성전자", "삼성제약", "삼양사", "삼원강재", "삼익THK", "삼화왕관", "서연", "성신양회", "세아특수강", "세원정공", "세진중공업", "셀트리온", "신성통상", "신세계", "써니전자", "아모레퍼시픽", "아세아", "에넥스", "에스제이엠", "엔케이", "엔피씨", "영원무역", "영원무역홀딩스", "용평리조트", "우리들휴브레인", "우신시스템", "우진플라임", "유니드", "유안타증권", "유진증권", "이건산업", "이노션", "이연제약", "인스코비", "조광페인트", "조선내화", "진에어", "참엔지니어링", "케이씨씨글라스", "코오롱글로벌", "태경케미컬", "토니모리", "퍼시스", "페이퍼코리아", "폴루스바이오팜", "하나제약", "한국내화", "한국철강", "한국화장품제조", "한미글로벌", "한솔피엔에스", "한양증권", "한일현대시멘트", "한진중공업", "한진중공업홀딩스", "한화", "현대일렉트릭", "현대제철", "황금에스티", "효성첨단소재", "DSC인베스트먼트", "EG", "GST", "IBKS제15호스팩", "KD", "KMH", "SDN", "SK머티리얼즈", "SM C&C", "SNK", "가비아", "감성코퍼레이션", "경남스틸", "광진윈텍", "글로벌텍스프리", "글로본", "나노", "내츄럴엔도텍", "네오셈", "네오위즈홀딩스", "네이블커뮤니케이션즈", "넥스턴바이오", "넥스트BT", "뉴프렉스", "대성엘텍", "대신밸런스제7호스팩", "대양전기공업", "대원", "대한뉴팜", "덕산테코피아", "덕산하이메탈", "동국제약", "동진쎄미켐", "디바이스이엔지", "디알젬", "디에스티", "디엔에이링크", "라이온켐텍", "레이크머티리얼즈", "레인보우로보틱스", "로지시스", "루멘스", "링네트", "마이크로프랜드", "매직마이크로", "메가스터디교육", "메드팩토", "메디톡스", "모바일리더", "모베이스전자", "모헨즈", "미코", "민앤지", "바른손", "바른손이앤에이", "바이넥스", "바이브컴퍼니", "바이온", "베노홀딩스", "비보존 헬스케어", "비에이치아이", "사람인에이치알", "새로닉스", "서연탑메탈", "서울반도체", "서울전자통신", "서원인텍", "서진오토모티브", "선데이토즈", "세틀뱅크", "센코", "슈프리마에이치큐", "스타플렉스", "시그네틱스", "시노펙스", "신라젠", "신원종합개발", "신한제7호스팩", "씨앤지하이테크", "씨티씨바이오", "아시아종묘", "아우딘퓨쳐스", "아이엘사이언스", "아이진", "아이크래프트", "알에스오토메이션", "알톤스포츠", "알파홀딩스", "액션스퀘어", "앤씨앤", "에스디생명공학", "에스씨엠생명과학", "에스엔유", "에스텍파마", "에이스테크", "에이치엠씨제5호스팩", "에이티세미콘", "에이팩트", "에이프로젠 H&G", "엔시스", "엔에스", "엔피디", "엘앤씨바이오", "엘오티베큠", "엠브레인", "엠투아이", "엠플러스", "예스24", "오가닉티코스메틱", "오하임아이엔티", "옵트론텍", "옵티팜", "와이솔", "와이아이케이", "와이어블", "우리산업홀딩스", "우양", "우진비앤지", "원바이오젠", "원익", "원익홀딩스", "위메이드맥스", "유성티엔에스", "유에스티", "이루온", "이브이첨단소재", "이엔에프테크놀로지", "이엘피", "이엠앤아이", "이트론", "인터엠", "자안바이오", "제너셈", "제노레이", "제로투세븐", "제룡전기", "젬백스", "칩스앤미디어", "컴퍼니케이", "케이사인", "케이씨에스", "케이아이엔엑스", "켐온", "코세스", "코엔텍", "코텍", "콜마비앤에이치", "쿠콘", "큐캐피탈", "크리스에프앤씨", "타이거일렉", "태광", "티로보틱스", "티에스아이", "티엘아이", "파라다이스", "파인디앤씨", "파인텍", "파크시스템스", "펩트론", "포스코 ICT", "폴라리스웍스", "풍국주정", "퓨쳐스트림네트웍스", "퓨쳐켐", "프리시젼바이오", "피씨디렉트", "피에스케이홀딩스", "피엔에이치테크", "피엔케이피부임상연구센타", "피플바이오", "하나머티리얼즈", "하이로닉", "하이소닉", "한국유니온제약", "한국컴퓨터", "한송네오텍", "한일사료", "헝셩그룹", "화일약품", "효성오앤비", "휴온스", "휴젤", "다원넥스뷰", "도부마스크", "디피코", "메디쎄이", "빅텐츠", "썬테크", "씨알푸드", "아퓨어스", "안지오랩", "엔에스엠", "엔에스컴퍼니", "엘에이티", "유비온", "지오씨", "AK홀딩스", "CJ", "CJ씨푸드", "DB금융투자", "DGB금융지주", "DL", "HDC", "KISCO홀딩스", "KTB투자증권", "LG", "LG디스플레이", "NH프라임리츠", "S-Oil", "SK네트웍스", "SK아이이테크놀로지", "SK케미칼", "SK하이닉스", "SNT모티브", "계룡건설산업", "고려아연", "남양유업", "남해화학", "노루페인트", "대상", "대성에너지", "대성홀딩스", "대한제강", "동원산업", "두산퓨얼셀", "만호제강", "모나미", "문배철강", "미창석유공업", "백광산업", "벽산", "부국철강", "부산도시가스", "비비안", "비상교육", "삼부토건", "삼성공조", "삼성생명", "삼성전기", "삼양패키징", "삼일씨엔에스", "삼화전기", "삼화페인트공업", "샘표", "서흥", "성안", "세아베스틸", "세하", "센트럴인사이트", "신세계건설", "신영와코루", "신영증권", "신원", "신풍제지", "아시아나IDT", "에쓰씨엔지니어링", "에어부산", "에이블씨엔씨", "에이프로젠 KIC", "엘브이엠씨", "오리온", "우리금융지주", "우성사료", "유니온", "일진전기", "제일연마", "조광피혁", "조일알미늄", "카카오", "케이씨티시", "케이티", "코리안리", "코오롱머티리얼", "쿠쿠홈시스", "크라운제과", "크라운해태홀딩스", "키움증권", "태광산업", "태림포장", "태원물산", "티에이치엔", "팬오션", "퍼스텍", "평화산업", "하나투어", "하이골드12호", "한국쉘석유", "한독", "한세엠케이", "한솔제지", "한솔케미칼", "한솔테크닉스", "한전기술", "한진", "해성디에스", "현대리바트", "현대백화점", "형지엘리트", "혜인", "화성산업", "화승코퍼레이션", "휴비스", "CJ프레시웨이", "CNH", "DB금융스팩9호", "DMS", "GH신소재", "GV", "IBKS제14호스팩", "KBI메탈", "KG모빌리언스", "KMH하이텍", "KT서브마린", "MP그룹", "SBS콘텐츠허브", "SG&G", "SK5호스팩", "SV인베스트먼트", "TPC", "TS인베스트먼트", "YBM넷", "iMBC", "가온미디어", "게임빌", "경동제약", "골든센츄리", "광림", "국보디자인", "나무기술", "나스미디어", "나이스정보통신", "남화산업", "네오오토", "네오크레마", "넷게임즈", "노랑풍선", "노바텍", "뉴보텍", "뉴지랩파마", "다날", "대신밸런스제9호스팩", "대원미디어", "대한과학", "대호특수강", "대화제약", "동아화성", "동양파일", "디앤씨미디어", "디이엔티", "디지탈옵틱", "라닉스", "라온피플", "랩지노믹스", "로스웰", "리메드", "린드먼아시아", "마니커에프앤지", "마이더스AI", "메가엠디", "메이슨캐피탈", "메카로", "모베이스", "모아텍", "바이오다인", "바이오스마트", "보광산업", "본느", "브릿지바이오", "비엠티", "삼보모터스", "삼영엠텍", "삼천당제약", "상상인", "샘코", "서울바이오시스", "서울옥션", "서울제약", "성도이엔지", "세원", "세원물산", "셀루메드", "셀리버리", "소룩스", "소프트캠프", "수성이노베이션", "스카이문스테크놀로지", "스킨앤스킨", "시너지이노베이션", "신성델타테크", "신화인터텍", "싸이버원", "싸이토젠", "씨엔플러스", "아이컴포넌트", "아주IB투자", "아즈텍WB", "안랩", "알서포트", "에너토크", "에스넷", "에스에이엠티", "에스피지", "에이비프로바이오", "에이아이비트", "에이치엔티", "에이치엘비", "에이프로", "에이피티씨", "에코마케팅", "에코바이오", "에코캡", "에프앤가이드", "에프엔에스테크", "엑사이엔씨", "엔바이오니아", "엔에이치스팩13호", "엘엠에스", "엠아이텍", "엠에스오토텍", "엠케이전자", "오르비텍", "오이솔루션", "올리패스", "와이엠씨", "와이엠티", "와이제이엠게임즈", "와이팜", "와토스코리아", "우리기술", "우리넷", "원익IPS", "웹스", "위세아이텍", "유니슨", "유니크", "유아이디", "유아이엘", "유틸렉스", "이미지스", "이상네트웍스", "이에스에이", "이엠네트웍스", "이엠코리아", "이오플로우", "이큐셀", "이퓨쳐", "이화공영", "이화전기", "인피니트헬스케어", "일신바이오", "잉글우드랩", "자안코스메틱", "장원테크", "정원엔시스", "제노코", "제이씨케미칼", "제이웨이", "젬백스링크", "조광ILI", "줌인터넷", "중앙백신", "지놈앤컴퍼니", "지트리비앤티", "진시스템", "카카오게임즈", "카페24", "케이비17호스팩", "케이에스피", "코너스톤네트웍스", "코다코", "코디", "큐로홀딩스", "큐리언트", "크리스탈신소재", "크린앤사이언스", "클래시스", "클리오", "토박스코리아", "투비소프트", "티케이케미칼", "팅크웨어", "파마리서치", "팜스토리", "펄어비스", "포인트모바일", "폴라리스오피스", "푸드나무", "푸른저축은행", "프리엠스", "피제이메탈", "한국전자인증", "한국큐빅", "한독크린텍", "한탑", "한프", "해성산업", "현대에버다임", "홈캐스트", "휴메딕스", "휴온스글로벌", "휴온스블러썸", "흥구석유", "EMB", "네추럴FNP", "데이터스트림즈", "루켄테크놀러지스", "블루탑", "비엔디생활건강", "아이케이세미콘", "애드바이오텍", "에스엘에스바이오", "엔지브이아이", "유엑스엔", "이비테크", "이앤에치", "청광건설", "펨토바이오메드", "프로테옴텍", "피엔아이컴퍼니", "BGF", "CS홀딩스", "DB", "E1", "F&F 홀딩스", "GS리테일", "KC그린홀딩스", "LG유플러스", "SGC에너지", "SK바이오사이언스", "SNT중공업", "SNT홀딩스", "STX엔진", "경동도시가스", "경방", "고려제강", "광동제약", "광주신세계", "교촌에프앤비", "금비", "금호석유화학", "대림통상", "대신증권", "대원전선", "대원화성", "대유에이텍", "더블유게임즈", "동방아그로", "동부건설", "동성제약", "동성케미컬", "동아에스티", "동양고속", "동양철관", "동원수산", "동일제강", "롯데쇼핑", "메리츠화재", "미래에셋생명", "미원에스씨", "부광약품", "삼성중공업", "삼양홀딩스", "삼익악기", "삼천리", "서울식품공업", "성창기업지주", "세원이앤씨", "세종공업", "솔루엠", "시디즈", "아세아시멘트", "알루코", "에스제이엠홀딩스", "엔에스쇼핑", "유성기업", "유수홀딩스", "유한양행", "이리츠코크렙", "이수페타시스", "이아이디", "인디에프", "일진홀딩스", "자이에스앤디", "전방", "제이알글로벌리츠", "제이콘텐트리", "제일기획", "지투알", "진양폴리우레탄", "컨버즈", "케이씨씨", "코람코에너지리츠", "코스맥스", "코스맥스비티아이", "코웨이", "콤텍시스템", "태경비케이", "티웨이항공", "팜젠사이언스", "포스코인터내셔널", "하이골드3호", "한국ANKOR유전", "한국화장품", "한라", "한미반도체", "한섬", "한세실업", "한솔홈데코", "한전산업", "한화손해보험", "한화솔루션", "핸즈코퍼레이션", "현대모비스", "현대자동차", "화승엔터프라이즈", "화인베스틸", "화천기계", "효성티앤씨", "후성", "휠라홀딩스", "휴스틸", "3S", "COWON", "DB금융스팩8호", "EMW", "JYP Ent.", "RFHIC", "강원", "경남제약", "고려신용정보", "고바이오랩", "골드퍼시픽", "광진실업", "그린플러스", "기산텔레콤", "나노씨엠에스", "나이스디앤비", "네패스", "네패스아크", "녹원씨엔아이", "누리플렉스", "대동금속", "대림제지", "대신정보통신", "데브시스터즈", "동방선기", "동우팜투테이블", "동운아나텍", "드림시큐리티", "드림씨아이에스", "드림어스컴퍼니", "디아이티", "디에이치피코리아", "디케이락", "디케이앤디", "디케이티", "라온시큐어", "라파스", "리노스", "마이크로컨텍솔", "마크로젠", "멀티캠퍼스", "메지온", "모비릭스", "미디어젠", "미래나노텍", "미래에셋대우스팩 5호", "미래테크놀로지", "미투젠", "바이오리더스", "바텍", "베스파", "뷰웍스", "블루콤", "비덴트", "비에이치", "비올", "비츠로셀", "비츠로테크", "비피도", "빅텍", "상상인이안1호스팩", "상아프론테크", "서린바이오", "서부T&D", "석경에이티", "선광", "성호전자", "세진티에스", "세화피앤씨", "센트럴바이오", "셀레믹스", "셀리드", "소마젠", "수젠텍", "스맥", "신라섬유", "신영스팩5호", "신화콘텍", "쎄니트", "씨씨에스", "씨젠", "아리온", "아시아경제", "아이디스홀딩스", "아이쓰리시스템", "안국약품", "알테오젠", "압타바이오", "에스맥", "에스에이티", "에스엠코어", "에스코넥", "에스티오", "에이치엘사이언스", "에이치엠씨제4호스팩", "에이테크솔루션", "에코마이스터", "에프엔씨엔터", "엔에프씨", "엘비세미콘", "엘이티", "엠에스씨", "엠젠플러스", "연우", "오디텍", "오킨스전자", "와이엔텍", "와이오엠", "와이지엔터테인먼트", "우리이앤엘", "우리조명", "우주일렉트로", "웨이브일렉트로", "웹케시", "위니아딤채", "위더스제약", "위드텍", "위지윅스튜디오", "윈스", "윈텍", "유라테크", "율호", "이그잭스", "이니텍", "이더블유케이", "인지디스플레", "인콘", "인크로스", "일지테크", "제넥신", "제이에스티나", "제이엠아이", "제일전기공업", "지엔원에너지", "진로발효", "체리부로", "케이디켐", "케이씨티", "케이피에스", "코리아에스이", "코맥스", "코아스템", "큐렉소", "큐로컴", "태양", "태웅", "테크윙", "티씨케이", "티앤엘", "티에스이", "티움바이오", "파루", "파인테크닉스", "팜스빌", "팬스타엔터프라이즈", "포메탈", "플레이위드", "피씨엘", "피피아이", "하나금융17호스팩", "하나머스트제6호스팩", "한국파마", "한창산업", "해성티피씨", "핸디소프트", "현대공업", "화신정공", "휴마시스", "휴비츠", "흥국", "굿센", "데이드림엔터", "듀켐바이오", "라온테크", "라이프사이언스테크놀로지", "렌딩머신", "로보쓰리", "명진홀딩스", "미래엔에듀파트너", "바이오인프라생명과학", "셀젠텍", "수프로", "스템랩", "에브리봇", "에스앤디", "에스에이티이엔지", "에스엠비나", "에이원알폼", "유니포인트", "이노진", "이성씨엔아이", "제노텍", "탑선", "파워풀엑스", "CJ CGV", "DB하이텍", "DL이앤씨", "HDC현대EP", "HSD엔진", "LF", "LG생활건강", "SG세계물산", "SIMPAC", "SKC", "SK디앤디", "SUN&L", "TCC스틸", "TYM", "경보제약", "고려산업", "광전자", "남광토건", "넥센", "농심", "다우기술", "대교", "대성산업", "대유플러스", "대한제분", "대한항공", "대한화섬", "대호에이엘", "동남합성", "동방", "동아타이어", "동양피스톤", "동원시스템즈", "디와이파워", "디티알오토모티브", "롯데리츠", "롯데손해보험", "메리츠금융지주", "무림P&P", "미원상사", "방림", "보령제약", "사조오양", "삼아알미늄", "삼영전자공업", "삼화전자공업", "새론오토모티브", "성문전자", "신대양제지", "신세계I&C", "쌍방울", "아남전자", "아세아제지", "애경유화", "에스원", "에이엔피", "엔케이물산", "영흥", "오리엔트바이오", "오리온홀딩스", "웅진", "원림", "웰바이오텍", "유니퀘스트", "이엔플러스", "이지스밸류플러스리츠", "인바이오젠", "일동제약", "일신석재", "일양약품", "일진머티리얼즈", "주연테크", "지코", "케이비아이동국실업", "케이씨", "케이티스카이라이프", "티웨이홀딩스", "파미셀", "평화홀딩스", "풀무원", "풍산홀딩스", "프레스티지바이오파마", "하이브", "하이트진로홀딩스", "한국단자공업", "한국앤컴퍼니", "한국조선해양", "한국카본", "한농화성", "한미약품", "한익스프레스", "한화시스템", "한화투자증권", "현대글로비스", "현대약품", "현대오토에버", "현대중공업지주", "현대해상", "현대홈쇼핑", "효성중공업", "CJ ENM", "CMG제약", "HB테크놀러지", "IBKS제12호스팩", "ISC", "KG이니시스", "KNN", "KPX생명과학", "NE능률", "NHN한국사이버결제", "SBI인베스트먼트", "SG", "SK6호스팩", "고려제약", "구영테크", "금강철강", "기가레인", "나노캠텍", "나라엠앤디", "나우IB", "네오펙트", "녹십자엠에스", "뉴파워프라즈마", "대륙제관", "대모", "대보마그네틱", "대성창투", "대정화금", "대창스틸", "덕우전자", "동성화인텍", "동양에스텍", "동양이엔피", "동일철강", "디스플레이텍", "디에스케이", "디와이피엔에프", "디자인", "디젠스", "러셀", "레이", "리더스 기술투자", "매일유업", "메가스터디", "명성티엔에스", "모다이노칩", "모바일어플라이언스", "미투온", "바이오솔루션", "바이오톡스텍", "베뉴지", "뷰노", "비나텍", "빅솔론", "삼강엠앤티", "삼목에스폼", "삼성스팩2호", "상신전자", "서진시스템", "서플러스글로벌", "서한", "서희건설", "선익시스템", "성광벤드", "소프트센", "신진에스엠", "심텍", "심텍홀딩스", "쎌바이오텍", "씨유메디칼", "씨티케이코스메틱스", "아모그린텍", "아미노로직스", "아바텍", "아이디스", "아이앤씨", "아이에스이커머스", "아이엠", "아진엑스텍", "아톤", "알엔투테크놀로지", "압타머사이언스", "애머릿지", "액토즈소프트", "에스디시스템", "에스엠", "에스제이케이", "에스티아이", "에스티큐브", "에이치엘비제약", "에이치케이", "에이텍", "에코프로", "에코프로비엠", "에프앤리퍼블릭", "엑스큐어", "엔비티", "엔에스엔", "엔에이치스팩17호", "엔에이치스팩18호", "엘비루셈", "엘앤에프", "엘앤케이바이오", "오로스테크놀로지", "오리엔탈정공", "오리콤", "오스템", "우리기술투자", "우리바이오", "우정바이오", "원풍물산", "월덱스", "웰크론한텍", "윙입푸드", "유니셈", "유니트론텍", "유일에너테크", "유진기업", "유진로봇", "유진스팩6호", "이노와이즈", "이노인스트루먼트", "이라이콤", "이베스트투자증권", "이엠텍", "이원컴포텍", "이즈미디어", "이크레더블", "인트로메딕", "인트론바이오", "인포마크", "일승", "일야", "일진파워", "제넨바이오", "제노포커스", "제닉", "제룡산업", "젠큐릭스", "중앙에너비스", "지더블유바이텍", "지스마트글로벌", "지엘팜텍", "진매트릭스", "창해에탄올", "컬러레이", "컴투스", "케어랩스", "케이엔제이", "케이엠", "케이엠제약", "케이프", "켐트로닉스", "켐트로스", "코리아에프티", "코센", "코퍼스코리아", "탑엔지니어링", "티사이언티픽", "티피씨글로벌", "파트론", "팬젠", "포티스", "플랜티넷", "피앤씨테크", "하림지주", "하이텍팜", "한국9호스팩", "한국가구", "한국정밀기계", "한국팩키지", "한빛소프트", "한스바이오메드", "한양이엔지", "한일진공", "한화에스비아이스팩", "현대에이치티", "현대이지웰", "휘닉스소재", "휴림로봇", "KC산업", "나우코스", "노브메타파마", "다이노나", "대동고려삼", "더콘텐츠온", "루트락", "볼빅", "비플라이소프트", "뿌리깊은나무들", "시그넷이브이", "시큐센", "씨엔티드림", "에스엔피제네틱스", "에이비온", "엔솔바이오사이언스", "엠앤씨생명과학", "인바이츠바이오코아", "인터코스", "질경이", "크로넥스", "파마리서치바이오", "판도라티비", "피노텍", "BYC", "DB손해보험", "F&F", "GS", "HMM", "JB금융지주", "JW생명과학", "JW홀딩스", "KH 필룩스", "LS네트웍스", "NH투자증권", "SK디스커버리", "강남제비스코", "경동나비엔", "계양전기", "광명전기", "그린케미칼", "금호에이치티", "깨끗한나라", "넥스트사이언스", "노루홀딩스", "대동", "대상홀딩스", "대우부품", "대우조선해양", "대창단조", "대현", "동아쏘시오홀딩스", "동아지질", "동일고무벨트", "동일산업", "두산중공업", "두올", "드림텍", "롯데지주", "모나리자", "무림페이퍼", "미래산업", "미래에셋증권", "미원홀딩스", "보해양조", "비케이탑스", "삼성물산", "삼화콘덴서공업", "상신브레이크", "서울도시가스", "선도전기", "신흥", "씨에스윈드", "아센디오", "아시아나항공", "에스케이바이오팜", "에이리츠", "에이프로젠제약", "에이플러스에셋", "엔에이치스팩19호", "엘에스일렉트릭", "영풍제지", "예스코홀딩스", "우리종금", "우진아이엔에스", "웅진씽크빅", "유엔젤", "유유제약", "율촌화학", "이지스레지던스리츠", "이화산업", "인팩", "일신방직", "일진디스플", "잇츠한불", "제주은행", "제주항공", "종근당", "진양산업", "진양홀딩스", "진원생명과학", "진흥기업", "천일고속", "체시스", "카프로", "케이티앤지", "풍산", "하나금융지주", "하이트론씨스템즈", "한국가스공사", "한국특강", "한성기업", "한세예스24홀딩스", "한일시멘트", "한일홀딩스", "한전KPS", "한진칼", "한창", "현대그린푸드", "현대로템", "현대미포조선", "현대위아", "현대코퍼레이션", "현대코퍼레이션홀딩스", "화신", "휴켐스", "흥국화재", "AP시스템", "AP위성", "GRT", "ITX-AI", "KH E&T", "KH 일렉트론", "OQP", "PI첨단소재", "S&K폴리텍", "SCI평가정보", "SFA반도체", "SGA", "SGC이테크건설", "THE E&M", "THE MIDONG", "TJ미디어", "UCI", "YTN", "골프존", "골프존뉴딘홀딩스", "교보10호기업인수목적", "글로벌에스엠", "금화피에스시", "까스텔바작", "네오이뮨텍", "네온테크", "녹십자랩셀", "녹십자웰빙", "누리플랜", "뉴트리", "다나와", "다믈멀티미디어", "다우데이타", "대동스틸", "대신밸런스제8호스팩", "더네이쳐홀딩스", "데이타솔루션", "덱스터", "도이치모터스", "동원개발", "동일금속", "동화기업", "드래곤플라이", "디지캡", "라이프시맨틱스", "레드로버", "로보티즈", "로체시스템즈", "리노공업", "마이크로디지탈", "맘스터치", "매커스", "메디아나", "미래생명자원", "바른전자", "배럴", "백금T&A", "버킷스튜디오", "보성파워텍", "브이원텍", "브이티지엠피", "블루베리 NFT", "비비씨", "비씨월드제약", "비아트론", "비츠로시스", "빛샘전자", "삼기", "삼영이엔씨", "상상인이안제2호스팩", "상상인인더스트리", "서남", "서울리거", "서전기전", "성우전자", "세동", "세중", "셀트리온헬스케어", "솔트룩스", "쇼박스", "슈프리마아이디", "신신제약", "신일제약", "싸이맥스", "쏠리드", "씨아이에스", "씨앤씨인터내셔널", "씨에스베어링", "아난티", "아바코", "아세아텍", "아스트", "아이스크림에듀", "아이텍", "아이티엠반도체", "알로이스", "알리코제약", "야스", "양지사", "얼라인드", "에스씨디", "에스아이리소스", "에스에프에이", "에스와이", "에스텍", "에스폴리텍", "에스피시스템스", "에이디엠코리아", "에이에프더블류", "에이치시티", "에이치엘비생명과학", "에이트원", "에치에프알", "에프에스티", "엔에이치스팩16호", "엔젠바이오", "엔피케이", "엘티씨", "엠투엔", "영우디에스피", "영풍정밀", "예선테크", "오로라", "오상자이엘", "오스코텍", "오파스넷", "올릭스", "옴니시스템", "우노앤컴퍼니", "우리산업", "우원개발", "원익피앤이", "위즈코프", "윈팩", "유비케어", "유안타제6호스팩", "유앤아이", "유진스팩4호", "이노메트리", "이노테라피", "이루다", "이씨에스", "이엔드디", "이오테크닉스", "이지홀딩스", "인바이오", "인터로조", "인터플렉스", "인피니티엔티", "인화정공", "자연과환경", "정산애강", "제이브이엠", "제이스텍", "제이엔케이히터", "제일테크노스", "제테마", "지노믹트리", "지어소프트", "지에스이", "진양제약", "차바이오텍", "천랩", "청담러닝", "캔서롭", "케이맥", "케이엘넷", "코나아이", "코렌", "코렌텍", "코리아나", "코오롱티슈진", "코윈테크", "코콤", "퀀타매트릭스", "큐에스아이", "클라우드에어", "키움제5호스팩", "테스", "텔레칩스", "텔레필드", "톱텍", "티플랙스", "파이오링크", "포스코엠텍", "포시에스", "푸른기술", "프럼파스트", "프레스티지바이오로직스", "플리토", "하림", "하이록코리아", "하이비젼시스템", "하츠", "한국기업평가", "한국알콜", "한국전자금융", "한국정보공학", "한네트", "한라IMS", "해성옵틱스", "현대사료", "홈센타홀딩스", "힘스", "나라소프트", "래몽래인", "메디젠휴먼케어", "엄지하우스", "에스케이씨에스", "에이펙스인텍", "오션스톤", "원텍", "원포유", "위월드", "지앤이헬스케어", "케어룸의료산업", "코셋", "툴젠", "플럼라인생명과학", "한국미라클피플사", "휴벡셀"};

    private ArrayList<MainData> arrayList, filteredList;
    private MainAdapter mainAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private EditText searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        mContext = this;

        searchView = (EditText) findViewById(R.id.txtSearch);
        recyclerView = (RecyclerView)findViewById(R.id.RecyclerView_contents);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();
        filteredList=new ArrayList<>();

        mainAdapter = new MainAdapter(arrayList);
        recyclerView.setAdapter(mainAdapter);


        //데이터 추가하기.
        for(int i = 0; i < stock_name.length; i++){
            MainData mainData = new MainData(stock_name[i]);
            arrayList.add(mainData);
        }

        mainAdapter.notifyDataSetChanged(); //새로고침
        searchView.addTextChangedListener(new TextWatcher() { //에딧텍스트에 내용이 변하면
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String searchText = searchView.getText().toString();
                searchFilter(searchText);
            }
        });


    }


    //필터링구현
    public void searchFilter(String searchText) {
        filteredList.clear();

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getTextView_title().toLowerCase().contains(searchText.toLowerCase())) {
                filteredList.add(arrayList.get(i));
            }
        }

        mainAdapter.filterList(filteredList);
    }
}