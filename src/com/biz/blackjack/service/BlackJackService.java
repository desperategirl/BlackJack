package com.biz.blackjack.service;
// 패키지 이름

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// java.util 패키지에 포함된 ArrayList, Collections, List를 
//  import를 통해 외부 클래스를 호출했음.

import com.biz.blackjack.model.DeckVO;

// 카드정보를 생성하고
// 게임을 진행하는데 필요한 클래스를 호출해 옴

public class BlackJackService { 
   // BlackJackService라는 public 클래스
   
   /* 자바에는 변수와 함수, 클래스에 대한 접근을 제한하는 문법이 있다. 
    * 접근을 제한하는 이유는 
    * 객체가 가진 고유의 멤버 변수값들이 외부에서 잘못 변경되는 것을 막기 위해서이다. 
    * 사전에 멤버 변수와 함수들의 성격을 규정하고 
    * 원치 않았던 외부의 개입을 차단함으로써 의도치 않은 실수를 줄이기 위한 의도가 깔려 있다. 
    * 
    * 총 4가지가 있는데 public 과 private 를 가장 많이 사용한다.
    * 
    * 접근 허용 가능 범위 순서는 다음과 같다. 
    * 접근 범위는 왼쪽부터 크다.
    * 
    * public > protected > default > private
    * 
    * public : 접근에 대한 제한이 없음
    * protected : 동일한 패키지 내 또는 파생 클래스에서만 접근 가능
    * default : 아무런 접근 제한자를 명시하지 않으면 default 값이 되며, 동일한 패키지 내에서만 접근이 가능
    * private : 자기 자신의 클래스 내에서만 접근이 가능 
    */
   
   
   private List<DeckVO> deckList;
   /* 자바의 리스트 클래스들 중 하나인 List<>
    * 
    * List<DeckVO> deckList는 deckList라 이름지어진 List 객체이고
    * 제네릭스(<>)안에 들어있는 DeckVO 객체만 사용할 수 있음.
    * 
    * 리스트는 배열의 한계 때문에 만들어진 자료형이다. 
    * 배열을 사용하기 위해서는 크기를 정해야 하는데 프로그래밍 중 크기를 알 수 없는 경우가 많다.
    * 이 때 메모리가 허용하는 한 계속해서 입력값을 추가 할 수 있도록 만든 자료형 클래스가 List이다. 
    * 
    * java.util.List 는 인터페이스 클래스이다.
    * 선언만 있고 구현 내용은 없다.
    * 
    * Interface를 어원을 찾아보면 Inter(중간) + face(맞대고 있는)이다. 
    * 어느 중간 사이에서 맞대고 있는 부분을 의미한다. 
    * User Interface라는 단어는 사용자와 컴퓨터 사이에서 일어나는 상호작용을 매개하는 것을 말한다. 
    * 객체 지향 언어의 인터페이스도 객체와 객체 사이에서 일어나는 사이에서 상호 작용의 매개로 쓰인다.
     *
     * Java에서는 Interface라는 키워드를 통해서 Interface를 생성할 수 있다. 
     * interface로 할 수 있는 일이 무엇이냐 하면 
     * 클래스의 기본 틀을 제공하면서 다른 객체 사이에서의 중간 매개 역할도 담당한다는 것이다.
     * 
     * java.util.Collection 인터페이스를 구현한 것이다. 
    * List 를 사용하기 위해서는 아래 클래스들중 하나로 인스턴스화 할 수 있다.
    * 
    * import java.util.ArrayList;
    * import java.util.LinkedList;
    * import java.util.List;
    * import java.util.Stack;
    * import java.util.Vector;  // 알파벳 순으로 import가 되는 것 같다
    * 
    * List listA = new ArrayList()
    * List listB = new LinkedList();
    * List listC = new Vector();
    * List listD = new Stack(); 
    */
   
   private String suit = "다이아몬드(◆):하트(♥):스페이드(♠):클로버(♣)"; 
   // suit은 카드의 무늬.
   // suit가 다이아몬드:하트:스페이드:클로버 이렇게 되어있고
   // makeDeck()에서는 suit.split(":") 해서 
   // 콜론을 기준으로 문자열을 나눠서 suits 문자열 배열에 넣음. 
   // suits[0]="다이아몬드", suits[1]="하트", suits[2]="클로버", suits[3]="스페이드"가 됨
   
   private String denomiation = "A234567890KQJ";
   // denomiation은 표면값, 문자나 숫자로 표현되는 카드의 액면가이다.
   // String class로 카드의 표면값을 뜻하는 denomiation이라는 변수를 생성하고 
   // 변수에 카드들의 표면값인 A234567890KQJ이라는 값을 담았다.
   
   
   public BlackJackService() { // BlackJackService()라는 메서드(함수)를 작성함
      deckList = new ArrayList();
      // 39행에서 선언한 deckList 리스트를 
      // 객체로 사용할 수 있도록 ArrayList() 생성자로 초기화했다.
   }
   
   public List<DeckVO> getDeck() {
      for(int i = 0 ; i < 50 ; i++) { 
         // 이 for 반복문의 i는 0부터 시작해서 49까지 1씩 증가함, 총 50번 반복
         Collections.shuffle(deckList);   
         // Collections Class 에 있는 메서드로 
         // List나 배열의 내용을 랜덤 형태로 보여주고자 할 때 사용
         // 현재는 deckList 안의 내용을 랜덤 형태로 섞기 위해 이 메서드를 사용하였다.
      }
      return deckList;
      // 위에서 Collections.shuffle()으로 섞은 deckList의 값을 다시 deckList에 담는다.
   }
   
   public void makeDeck() { 
      // 카드 덱을 구현하는 메서드. 카드의 무늬인 suit, 표면값인 denomiation을 구현.
      
      String[] suits = suit.split(":");
      // 카드의 무늬를 뜻하는 문자열 형 배열을 만든 후 배열로 suits이라는 객체를 선언하고
      // 문자열을 쪼개는 함수인 split()을 사용하여 위에서 선언한 suit 문자열을 :단위로 쪼개고 
      // 그 값을 문자열(String) 형 배열로 선언한 변수인 suits에 담는다.
      String[] denominations = denomiation.split(""); 
      // 카드의 표면값을 뜻하는 문자열 형 배열을 만든 후 배열로 denominations라는 객체를 선언하고
      // 문자열을 쪼개는 함수인 split()을 사용해 위에서 선언한 denomiation 문자열을 
      // 알파벳 단위(알파벳 사이의 공백단위)로 쪼개고 그 값을 문자열(String) 형 배열로 선언한 변수인 denomiations에 담는다.
      
      for(String s : suits) { 
         /* 이 for 반복문은 확장(advanced, 진화된)for문이라고 한다. 
          * 제네릭 타입으로 선언한 객체는 확장 for 문을 사용할 수 있다.
          * 형식은
          * 
          *  for(변수 : 배열,컬렉션){
          *   }
          *   
          *   ==> 배열/컬렉션의 내용이 하나씩 순서대로 준비된 변수에 기억된 후 반복하게 된다.
          *   주의할 점은 확장 for 문 변수의 자료형은 배열이나 컬렉션의 자료형과 동일해야 한다.
          */
         
         for(String d : denominations) {
            // 마찬가지로 denominations 문자열 형 배열의 내용이 하나씩 순서대로
            // 준비된 문자열 형 변수 d에 기억된 후 반복하게 된다.
            // 현재 이 확장 for문 변수의 자료형과 denomiations 배열의 자료형은 문자열 형 String으로 동일하다.
            
            DeckVO vo = new DeckVO(); 
            // DeckVO 클래스로 vo라는 인스턴스를 선언, DeckVO 생성자 메서드로 초기화.
            vo.setSuit(s); // vo 인스턴스로 setSuit()함수를 불러옴.
            vo.setDenomination(d); // vo 인스턴스로 setDenomiation()함수를 불러옴.
            
            int intValue = 0;
            // int 자료형으로 정수형 변수 intValue를 선언한 후 0으로 값을 초기화했음.
            
            try {
               intValue = Integer.valueOf(d);   
               // 위에서 선언한 d라는 문자열 형 변수를 Integer.valueOf() 메서드로 정수형으로 바꾼 뒤
               // 그 값을 intValue에 담음.
               if(intValue == 0) intValue = 10;
               // intValue의 값이 0이면, intValue에 10이라는 값을 담음.
            } catch (Exception e) {
               if(d.equals("A")) { // 만약 d가 A와 같은 값이라면 (이때 A는 대소문자를 구분한다)
                  intValue = 1; // intValue에 1이라는 값을 담음.
               } else { // 저 두가지의 if 외의 경우에는
                  intValue = 10; // intValue에 10이라는 값을 담음.
               }
            }

            vo.setValue(intValue); // vo 인스턴스로 setValue()함수를 실행하고 그 함수에 intValue값을 담음
            deckList.add(vo); 
            // deckList에 vo라는 값을 추가하기 위해 add()함수를 사용함
   
            
         }
      }

      
   }
   
   // 테스트코드
   public void viewCardList() {
      
      for(DeckVO vo : deckList) {
         // deckList라는 리스트(객체 배열 클래스)의 배열 내용이 하나씩
         // 순서대로 준비된 배열 변수 vo에 기억된 후 반복하게 한다. 
         // 현재 이 리스트의 자료형은 List이고 변수인 vo의 자료형 또한 List이다.
         System.out.println(vo.toString()); // vo형 변수를 String 형으로 바꾸고 콘솔에 출력하라는 코드.
      }
      System.out.println("===============");
      System.out.println("카드매수:" + deckList.size());
      // 카드 매수와 deckList의 길이만큼 콘솔에 출력하라는 코드.
      
   }

}

