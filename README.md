# StockChart

![React](https://img.shields.io/badge/React-18.x-blue?style=flat-square&logo=react)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=flat-square&logo=spring)
![License](https://img.shields.io/badge/License-MIT-yellow?style=flat-square)
![Version](https://img.shields.io/badge/Version-1.0.0-orange?style=flat-square)
![Build](https://img.shields.io/badge/Build-Passing-success?style=flat-square)

공공데이터 API를 활용한 주식 차트 시각화 웹 애플리케이션

## 프로젝트 소개

StockChart는 한국 공공데이터 API를 활용하여 주식 시장 데이터를 수집하고, 이를 시각적으로 표현하는 웹 애플리케이션입니다. 사용자는 다양한 주식 종목의 실시간 및 과거 데이터를 확인하고, 차트를 통해 주가 동향을 분석할 수 있습니다.

## 🛠️ Tech Stack

### 프론트엔드
- **React**: 사용자 인터페이스 구축
- **React Router**: 클라이언트 사이드 라우팅
- **Redux/Context API**: 상태 관리
- **Recharts/Chart.js**: 데이터 시각화
- **Axios**: API 통신
- **Styled-components/MUI**: UI 디자인

### 백엔드
- **Spring Boot**: 애플리케이션 서버 구축
- **Spring Security**: 사용자 인증 및 권한 관리
- **Spring Data JPA**: 데이터 액세스 계층
- **MySQL/PostgreSQL**: 데이터 저장소
- **Swagger/SpringDoc**: API 문서화

### 인프라
- **Docker**: 컨테이너화
- **Jenkins/GitHub Actions**: CI/CD
- **AWS/Azure**: 클라우드 호스팅

## 주요 기능

- **실시간 주식 정보 조회**: 종목별 현재가, 변동률, 거래량 등 표시
- **다양한 차트 유형**: 라인, 캔들스틱, 바 차트 등
- **커스텀 지표**: 이동평균선, MACD, RSI 등 기술적 지표 설정
- **종목 검색**: 종목명, 코드로 빠른 검색
- **관심 종목 관리**: 즐겨찾기 기능으로 주요 종목 저장
- **알림 설정**: 특정 가격 도달 시 알림 기능
- **사용자 계정**: 개인화된 설정 및 대시보드

## 설치 및 실행 방법

### 사전 요구사항
- Node.js 18.x 이상
- Java 17 이상
- Maven 또는 Gradle
- MySQL/PostgreSQL
- 공공데이터포털 API 키

### 프론트엔드 설정
```bash
# 리포지토리 클론
git clone https://github.com/your-username/stock-chart.git
cd stock-chart/frontend

# 의존성 설치
npm install

# 개발 서버 실행
npm start
```

### 백엔드 설정
```bash
# 백엔드 디렉토리로 이동
cd ../backend

# Maven을 사용할 경우
./mvnw spring-boot:run

# Gradle을 사용할 경우
./gradlew bootRun
```

## 환경 변수 설정

프로젝트 루트에 `.env` 파일을 생성하고 다음 변수를 설정하세요:

```
# 백엔드
DB_URL=jdbc:mysql://localhost:3306/stockdb
DB_USERNAME=root
DB_PASSWORD=your_password
PUBLIC_DATA_API_KEY=your_api_key

# 프론트엔드
REACT_APP_API_BASE_URL=http://localhost:8080/api
```

## API 엔드포인트

| 경로 | 메소드 | 설명 |
|------|--------|------|
| `/api/stocks` | GET | 모든 주식 종목 목록 조회 |
| `/api/stocks/{symbol}` | GET | 특정 종목 상세 정보 조회 |
| `/api/stocks/{symbol}/history` | GET | 특정 종목 과거 데이터 조회 |
| `/api/user/favorites` | GET | 사용자 관심 종목 조회 |
| `/api/user/favorites` | POST | 관심 종목 추가 |
| `/api/user/favorites/{id}` | DELETE | 관심 종목 삭제 |

## 공공데이터 API 연동

한국거래소(KRX)나 금융감독원의 공공데이터 API를 활용하여 주식 정보를 가져옵니다. API 신청 및 키 발급 방법은 다음과 같습니다:

1. [공공데이터포털](https://www.data.go.kr/) 가입
2. 주식 관련 API 검색 및 활용 신청
3. 승인 후 발급받은 API 키를 환경 변수에 설정

## 개발 로드맵

- [x] 프로젝트 기본 구조 설정
- [x] 공공데이터 API 연동
- [x] 기본 차트 구현
- [ ] 사용자 인증 시스템
- [ ] 관심 종목 기능
- [ ] 고급 차트 기능 추가
- [ ] 모바일 반응형 디자인
- [ ] 실시간 데이터 업데이트
