package com.biz.blackjack.service;

import java.util.ArrayList;
import java.util.List;

import com.biz.blackjack.model.DeckVO;

public class PlayService {

   List<DeckVO> playList; // DeckVO의 자료형만 사용하는 List를 만들어 playList라 이름지음
   List<DeckVO> deckList; // DeckVO의 자료형만 사용하는 List를 만들어 deckList라 이름지음
   String playName ; // playName이라는 문자열 변수를 지정
   
   public PlayService(List<DeckVO> deckList, String playName) {
      // PlayService라는 메서드를 만들고 deckList 리스트, playName객체를 호출하여 이용
      this.playList = new ArrayList<DeckVO>();
      /*
       * java에서 this는 자기 자신을 말함. 
       * 객체는 자기자신의 참조를 가지고 있는 키워드로 멤버임을 명확히 하기 위해 this를 사용한다.
       * 현재 클래스의 인스턴스임을 가리킴.
       * this.playList라 함은 PlayService 메서드가 가지고 있는 playList 필드라는 의미이다.
       * this를 사용하여 생성자를 호출함.
       */
      
      this.deckList = deckList;
      this.playName = playName;
   }
      // this를 사용하지 않으면 매개 변수의 이름과 PlayService 내의 지역변수 이름이 같기 때문에 
      // PlayService의 객체인 deckList, playName 속성에 값이 저장되지 않는다. 
      // 이 때 PlayService의 인스턴스라는 것을 가리켜 주는 this 키워드를 사용해야 되는 것이다.

   
   public int sumValue() { // 정수형 sumValue 메서드(함수)를 선언
      int sumValue = 0; // 정수형 sumValue 변수를 선언하고 0으로 초기화 함
      for(DeckVO vo : playList) { 
         /* playList라는 리스트(객체 배열 클래스)의 배열 내용이 하나씩
          * 순서대로 준비된 DeckVO의 배열 변수 vo에 기억된 후 반복하게 한다. 
          */
         sumValue += vo.getValue(); // sumValue에 vo.getValue()를 하나씩 순차적으로 더해 나감
      }
      return sumValue; // 그렇게 만들어진 결과값을 sumValue에 담는다
   }
   
   public void hit() { // hit 메서드 생성
      
      if(playName.equals("딜러") && this.sumValue() > 16) { 
         // 만약 '딜러'의 sumValue가 16보다 크면 (if문의 조건식)
         System.out.println("딜러점수:" + this.sumValue());
         // '딜러점수:'와 sumValue값을 콘솔에 출력하고
         System.out.println("딜러 Hit 금지");
         // '딜러 Hit 금지'를 출력하라
      } else { // 위의 경우 그 이외라면
         playList.add(deckList.get(0)); // 이해가 어려운 코드
         deckList.remove(0);
      }

      System.out.println("----------------");
      System.out.println(playName);
      System.out.println("----------------");
      for(DeckVO vo : playList) {
         System.out.println(vo); // vo 변수를 출력
      }
   }
   
}