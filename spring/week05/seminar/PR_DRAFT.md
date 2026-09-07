# Product 조회 방식 복습

## 작업 내용

- `Product` 엔티티와 응답 DTO를 추가했습니다.
- Spring Data JPA 메서드 쿼리로 가격이 높은 상품 Top 10 조회 API를 구현했습니다.
- JPQL로 2,000원 이하 상품 중 재고가 많은 상품 Top 5 조회 API를 구현했습니다.
- QueryDSL로 이름에 `펜`이 포함된 상품을 가격 오름차순으로 최대 10개 조회하는 테스트를 추가했습니다.

## API

| Method | URL | 설명 |
| --- | --- | --- |
| GET | `/product/jpa` | 가격 내림차순 상품 Top 10 |
| GET | `/product/jpql` | 2,000원 이하, 재고 내림차순 상품 Top 5 |

## 구현 방식 복습

### Spring Data JPA

`findByOrderByPriceDesc(Pageable)`처럼 메서드 이름으로 조건과 정렬을 표현합니다. 별도 쿼리를 작성하지 않아도 되고 단순 조회에 적합합니다. `PageRequest.of(0, 10)`으로 조회 개수를 Top 10으로 제한했습니다.

### JPQL

엔티티와 필드를 기준으로 직접 쿼리를 작성합니다. `price <= 2000` 조건과 `stockQuantity desc` 정렬을 명확하게 표현하고, `PageRequest.of(0, 5)`로 Top 5만 조회했습니다.

### QueryDSL

생성된 `QProduct`를 사용해 자바 코드로 쿼리를 조립합니다. `contains("펜")`, 가격 오름차순 정렬, `limit(10)`을 타입 안전하게 작성했습니다. 이번 요구사항은 테스트에서 세 방식의 차이를 비교하는 데 초점을 맞췄습니다.

## 테스트

- JPA 조회 결과가 가격 내림차순인지 검증
- JPQL 조회 결과가 가격 조건을 만족하고 재고 내림차순인지 검증
- QueryDSL 조회 결과가 이름 조건을 만족하고 가격 오름차순인지 검증

## 확인 방법

```bash
./gradlew test
```
