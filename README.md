## 개발 일지

### 2024-09-02

[as-is]
1. docker-compose를 통한 Infra 배포 완료 V
2. membership-service Kafka 연결 확인 V

### 2024-09-03

[to-be]
1. membership 회원가입 API 확인
   1. membership-created-event 발행 여부 확인 필요
   2. money 정보 생성 확인

[as-is]

## 특이사항
- docker-compose.yml에 bridge network 포트 지정 방식 확인
  - 0000:1111 이면 host에다가 포트 포워딩
  - 0000 이게 network에 노출되는 포트