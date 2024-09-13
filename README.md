## 개발 일지

### 2024-09-02

[as-is]
1. docker-compose를 통한 Infra 배포 완료 V
2. membership-service Kafka 연결 확인 V

### 2024-09-03

[to-be]
1. membership 회원가입 API 확인
   1. membership-created-event 발행 여부 확인 필요 V
   2. money 정보 생성 확인 V
2. (테스트용)백오피스 개발
3. docker 배포 후 api 테스트 V

### 2024-09-06

[to-be]
1. 백오피스 유저 생성 테스트 V
2. 송금 Orchestration 서비스 설계 V

### 2024-09-08

[to-be]
1. banking-service(mocking) 구현

## 특이사항
- docker-compose.yml에 bridge network 포트 지정 방식 확인
  - 0000:1111 이면 host에다가 포트 포워딩
  - 0000 이게 network에 노출되는 포트
- 송금 Orchestration의 경우 멤버와 멤버간 포인트 송금 로직 구현(2024.09.08)