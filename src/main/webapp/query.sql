create table psDB (
	question varchar2(100) not null,
	answer number(1)
);

insert into psDB values ('누구나 크고 작은 실수를 할 수 있다고 생각하시나요?', 0);
insert into psDB values ('친한 친구와 함께 활동하는 것에 흥미를 느끼시나요?', 0);
insert into psDB values ('동료가 맘에 들지 않는 행동을 했을 때 어떻게 대처하시나요?', 0);
insert into psDB values ('어떻게 자신의 감정을 표현하고 다른 사람들과 공유하나요?', 0);
insert into psDB values ('새로운 기술이나 개념을 배우는 것에 어떤 자세를 가지고 있나요?', 0);
insert into psDB values ('어떤 유형의 사람들과 가장 잘 어울리는 것 같아요?', 0);
insert into psDB values ('타인과의 갈등을 어떻게 해결하는 편이신가요?', 0);
insert into psDB values ('어떤 방식으로 스트레스를 해소하거나 긍정적인 에너지를 얻나요?', 0);
insert into psDB values ('주변의 지인들이 당신을 어떤 사람으로 기억하는 편인가요?', 0);
insert into psDB values ('자신의 꿈과 목표를 달성하기 위해 어떤 방식으로 행동할 것 같나요?', 0);
insert into psDB values ('어떤 가치가 당신의 선택과 행동을 주도하는 데 중요한 역할을 하나요?', 0);
insert into psDB values ('우선순위를 결정할 때 어떤 기준을 사용하시나요?', 0);
insert into psDB values ('어떤 종류의 영화가 당신의 기분을 좋게 만드나요?', 0);
insert into psDB values ('가족이나 지인들과 어떻게 시간을 보내는 것을 좋아하시나요?', 0);
insert into psDB values ('어떤 상황에서 가장 편안하게 느끼시나요?', 0);

create table itDB (
	question varchar2(200) not null,
	answer varchar2(500)
);

insert into itDB values('컴퓨터의 주요 하드웨어 구성 요소는 무엇입니까?', '');
insert into itDB values('이진수의 표현방법을 예를 들어 설명해주세요', '');
insert into itDB values('IT 분야에서 가장 흥미로운 직업은 무엇이라고 생각하나요?', '');
insert into itDB values('인공지능의 주요 응용 분야는 어떤 것들이 있나요?', '');
insert into itDB values('C/C++의 차이를 설명해주세요', '');
insert into itDB values('깃허브의 장점에는 무엇이 있나요?', '');
insert into itDB values('List의 장점을 Array와 비교하여 설명해 주세요', '');
insert into itDB values('빅 데이터 분석 기술은 어떤 분야에서 활용될 수 있다고 생각하나요?', '');
insert into itDB values('서버의 역할에는 무엇이 있나요?', '');
insert into itDB values('인터넷을 사용할때 쿠키는 무엇인가요?', '');
insert into itDB values('RAM과 하드드라이브의 차이점은 무엇인가요?', '');
insert into itDB values('CPU란 무엇이며, 컴퓨터에서 어떤 역할을 하나요?', '');
insert into itDB values('가장 편한 프로그래밍 언어는 무엇이며, 그 이유는 무엇인가요?', '');
insert into itDB values('변수와 상수의 차이를 설명해주세요.', '');
insert into itDB values('컴퓨터의 입출력 장치에 대해 설명하세요.', '');
insert into itDB values('좋은 개발자의 요소에는 무엇이 있나고 생각하나요?', '');
insert into itDB values('운영체제의 역할과 기능에는 무엇이 있나요?', '');
insert into itDB values('과적합(Overfitting)이 무엇이며, 방지하기 위한 방법은 무엇인가요?', '');
insert into itDB values('네트워크 보안을 위한 기술 혹은 방법엔 어떤 것이 있나요?', '');
insert into itDB values('소프트웨어 개발 과정 중에서 특히 중요하다고 생각하는 단계와 그 이유를 설명해보세요.', '');

