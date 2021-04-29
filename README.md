# Spring Batch 학습 저장소

## 학습내용

1. [스프링 배치란](https://www.notion.so/c1627488a244489895d04854712e930e)
    - 개념 및 환경설정
2. 스프링 배치 아키텍처
    - 배치의 기본 구조
    - 배치 테이블
    - Job, Step
    - ExecutionContext
3.   [스프링 배치 기초학습](https://github.com/Ilisha29/spring-batch-example/tree/master/src/main/java/fastcampus/spring/batch/part3)
     - Tasklet / Chunk
     - JobParameters
     - ItemReader
     - ItemWriter
     - ItemProcessor
     - Listener
     - skip / retry
4. [회원 등급 프로젝트](https://github.com/Ilisha29/spring-batch-example/tree/master/src/main/java/fastcampus/spring/batch/part4)
    - 요구사항 분석
    - 배치 Job / Step 개발
    - Listener 적용으로 시간측정 
5. [주문금액 집계 프로젝트](https://github.com/Ilisha29/spring-batch-example/tree/master/src/main/java/fastcampus/spring/batch/part5)
    - 요구사항 추가
    - JobExecutionDecider
6.  [성능 개선과 비교](https://github.com/Ilisha29/spring-batch-example/tree/master/src/main/java/fastcampus/spring/batch/part6)
    - Simple Step
    - Async Step
    - Multi-Thread Step
    - Partition Step
    - Async + Partition Step
    - Parallel Step
    - Partition+ Parallel Step
    - [성능 비교표](https://github.com/Ilisha29/spring-batch-example/blob/master/%EC%84%B1%EB%8A%A5%EC%B8%A1%EC%A0%95_%EB%B0%8F_%EA%B0%9C%EC%84%A0.md)
7. 스프링 배치 설정과 실행

## 추후 목표
학습한 내용을 바탕으로 좀 더 반복 학습을 하여 현재 진행중인 팀 프로젝트인 [으쌰으쌰](https://github.com/sproutt/eussya-eussya-batch) 에 적용 