# spring-level1
스프링 부트로 로그인 기능이 없는 나만의 블로그 백엔드 서버 만들기

## 프로젝트 설정
### build.gradle
```
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web' // web
    compileOnly 'org.projectlombok:lombok' // lombok
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    implementation 'mysql:mysql-connector-java:8.0.28' // MySQL
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa' // JPA 설정
}
```

### application.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/{database이름}
spring.datasource.username=root
spring.datasource.password={비밀번호} // 비밀번호를 제대로 적자!!!!!
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update // create하면 실행할때마다 생성해서 종료하고 데이터 안남음

// sql 예쁘게
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
```

### 프로젝트 구조
- `/main/com.example.springlevel1`
    - `/controller`
    - `/service`
    - `/repository`
    - `/entity`
    - `/dto`

패키지를 따로 만들어서 관리해준다!

## Use Case
<img width="727" alt="스크린샷 2023-06-29 오전 11 33 44" src="https://github.com/thing-zoo/spring-level1/assets/62596783/c9814a90-c05c-419f-bbe6-1b14289fdff0">

use case는 좀더 연습해야겠다.

## API 설계
| Description | Method | URI               | Request                                                                                                  | Response                                                                                                                                                                                          |
| - | - |-------------------|----------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 전체 게시글 목록 조회 | GET | `/api/posts`      | -                                                                                                        | {<br>{<br>"id": 1,<br>"title": "title1",<br>"content": "content1",<br>"author":"author1",<br>"createdAt": "2023-01-01T12:34:56.78900",<br>"modifiedAt": "2023-01-01T12:34:56.78900"<br>},...<br>} |
| 게시글 작성 | POST | `/api/posts`      | {<br>"title": "title1",<br>"content": "content1",<br>"author":"author1",<br> "password": "password1"<br>} | {<br>"id": 1,<br>"title": "title1",<br>"content": "content1",<br>"author":"author1",<br>"createdAt": "2023-01-01T12:34:56.78900",<br>"modifiedAt": "2023-01-01T12:34:56.78900"<br>}               |
| 선택한 게시글 조회 | GET | `/api/posts/{id}` | -                                                                                                        | {<br>"id": 1,<br>"title": "title11",<br>"content": "content11",<br>"author":"author11",<br>"createdAt": "2023-01-01T12:34:56.78900",<br>"modifiedAt": "2023-01-02T12:34:56.78900"<br>}            |
| 선택한 게시글 수정 | PUT | `/api/posts/{id}` | {<br>"title": "title11",<br>"content": "content11",<br>"author":"author1",<br> "password": "password1"<br>}                          | {<br>"id": 1,<br>"title": "title11",<br>"content": "content11",<br>"author":"author11",<br>"createdAt": "2023-01-01T12:34:56.78900",<br>"modifiedAt": "2023-01-02T12:34:56.78900"<br>}            |
| 선택한 게시글 삭제 | DELETE | `/api/posts/{id}` | {<br>"password": "password1"<br>}                                                                        | {<br>"success": true<br>}                                                                                                                                                                         |
