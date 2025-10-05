# 🏋️‍♂️ gym-management

## 1. 프로젝트 개요
- 회사 프로젝트 기술 검증 및 개선을 위한 개인용 프로젝트
- 목표: 기존 구조 개선, 유지보수 효율성 향상, 코드 확장성 확보

---

## 2. 핵심 기능

### **관리자 API 상품 정보 관리**
- 상품 정보 조회, 등록, 수정, 삭제 기능 제공

### **템플릿 기반 상품 관리**
- **문제점**: 동일 기간에 여러 상품 템플릿 생성 시 충돌 가능
- **개선**: 템플릿 우선순위 지정 기능 구현 → 우선순위가 높은 템플릿 우선 출력

### **Spring Data JPA 기반 Repository 구조 개선**
- **문제점**: QueryDSL, JDBC 쿼리 혼합 관리로 유지보수 어려움 및 불필요한 Bean DI 발생
- **개선**: 커스텀 인터페이스 + 별도 구현체 방식 적용 → 하나의 Bean 주입만으로 구조 단순화, 확장성 확보

### **유틸 클래스 설계**
- **문제점**: Component 방식의 생성자 주입 시 파라미터 관리 번거로움
- **개선**: Object 방식 적용 → 환경 변수 초기화 문제 해결을 위해 ObjectInitializer 클래스 추가
- **결론**: 유지보수와 확장성을 고려해 Component 방식 유지 결정

### **DTO Mapper vs 생성자 방식**
- **문제점**: 생성자 방식의 파라미터 증가로 가독성 저하
- **개선**: DTO Mapper 방식 적용 → 가독성 향상, 서버 분리 시 로직 단순화, Kotlin 람다 스타일 매핑 적용 가능

---

## 3. 사용 기술
- **언어**: Kotlin
- **프레임워크**: Spring Boot
- **데이터베이스**: PostgreSQL
- **기타**: Docker, JPA, QueryDSL

---

## 4. 실행 방법
```bash
git clone https://github.com/parkgeounyong/gym-management.git
cd gym-management

cd infra
docker-compose up -d

cd ..
./gradlew bootRun --args='--spring.profiles.active=local'
```

## 5. 성과
- 운영 프로젝트 JPA 커스텀 인터페이스 + 분리된 구현체 구조로 리팩토링 진행
- 운영 프로젝트에 DTO Mapper 방식 적용
  - 유지보수 효율성 향상 및 POS서버에서 Migration 서버 분리 시 빠른 시간안에 분리 진행하였음(3일)
  - Kotlin 람다 스타일 매핑 활용으로 코드 가독성 및 확장성 개선