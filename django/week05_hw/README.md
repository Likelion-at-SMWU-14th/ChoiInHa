# 나만의 Blog API

## 가상환경 켜서 실행하기

이미 `myvenv` 가상환경과 패키지 설치가 되어 있으므로 아래 명령으로 실행하면 됩니다.

```bash
cd /Users/choeinha/Projects/LikeLion/ChoiInHa/django/week05_hw
source myvenv/bin/activate
python manage.py runserver
```

또는 실행 스크립트를 사용할 수 있습니다.

```bash
cd /Users/choeinha/Projects/LikeLion/ChoiInHa/django/week05_hw
./runserver.sh
```

서버 주소는 `http://127.0.0.1:8000` 입니다.

## 처음부터 다시 설치해야 할 때

```bash
cd /Users/choeinha/Projects/LikeLion/ChoiInHa/django/week05_hw
python -m venv myvenv
source myvenv/bin/activate
pip install -r requirements.txt
python manage.py migrate
python manage.py runserver
```

## API

| 기능 | Method | URL | 인증 |
| --- | --- | --- | --- |
| 회원가입 | POST | `/api/users/signup/` | 필요 없음 |
| 로그인/JWT 발급 | POST | `/api/users/login/` | 필요 없음 |
| 토큰 재발급 | POST | `/api/users/token/refresh/` | refresh 토큰 |
| 글 목록 보기 | GET | `/api/posts/` | 필요 없음 |
| 글 작성하기 | POST | `/api/posts/` | Bearer access 토큰 필요 |
| 글 상세 보기 | GET | `/api/posts/<id>/` | 필요 없음 |
| 글 삭제하기 | DELETE | `/api/posts/<id>/` | 작성자 Bearer access 토큰 필요 |
