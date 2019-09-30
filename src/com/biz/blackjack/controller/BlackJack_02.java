package com.biz.blackjack.controller;

import java.util.Scanner;

import com.biz.blackjack.service.BlackJackService;
import com.biz.blackjack.service.PlayService;

public class BlackJack_02 {

   public static void main(String[] args) {

      Scanner scan = new Scanner(System.in); 
         // 정수, 실수, 문자열을 읽어올 수 있는 Scanner 클래스.
         // 키보드에서 수나 문자열을 읽어오기 위해 Scanner 클래스로 scan이라는 객체를 정의하고 초기화했음.
         // 3번 행에서 java.util 패키지에 포함된 Scanner를 import를 통해 외부 클래스를 호출했음.
         // 생성자메서드란 클래스를 이용하여 메모리를 가진 instance,
         // 즉, 객체를 생성할 때 제일 먼저 호출되는 메서드.
         // 객체를 생성함과 동시에 기본적으로 호출되는 메서드임.
        
         // 생성자 메서드는, 메서드의 리턴타입이 없다.
         // 생성자 메서드의 이름은 클래스의 이름과 동일하다.
         // 생성자 메서드는 new생성자가 메모리를 생성한 직후 호출 되어진다.
      
         //(System.in)안의 System은 입출력을 할 때 사용하는 System 클래스이고 
         // 입력할 때는 System.in, 출력할 때는 System.out을 사용한다.
         // 접근할 때는 접근자 마침표(.)를 이용해 접근한다.



    BlackJackService bs = new BlackJackService(); 
           // BlackJackService라는 생성자로 
         // BlackJackService 라는 객체(클래스)로 정의한 인스턴스 bs를 초기화함
      
        bs.makeDeck(); 
        // BlackJackService안의 makeDeck()안의 함수 안의 코드가 실행되는 코드.
        // bs라는 인스턴스로 makeDeck()이라는 함수를 불러와서 현재 클래스에서 실행시키기 위함임.
        
        // BlackJackService안에 있는 makeDeck()이라는 함수를 불러와서 사용하기 위해
        // bs라는 인스턴스를 BlackJackService라는 객체로 선언하고
        // 그 인스턴스를 BlackJackService()라는 생성자 메서드로 초기화한것임
        

      while(true) { 
         
         /*
          *  while문의 구조:
          *  while(조건식){수행문}
          *  ()안에 든 조건식이 참이면 {}안에 든 수행문을 무한반복함
          *  
          *  위의 while문은 ()안에 든 조건식이 true로 참이기 때문에 {} 안의 수행문을 무한반복함
          */
         System.out.println("=========================");
         System.out.println(" GAME Start ");
         System.out.println("=========================");
         // ("") 안에 든 문자열을 출력하라
         
         PlayService dealer = new PlayService(bs.getDeck(),"딜러");
         PlayService player = new PlayService(bs.getDeck(),"플레이어");
         // PlayService라는 클래스로 정의한 객체 dealer와 player를 
         // PlayService()라는 생성자 메서드로 초기화하고, 객체를 사용할 수 있게 했음
         
         
         for(int i = 0 ; i < 2 ; i++) {
            dealer.hit();
            player.hit();
         }
         /*
          * for문의 구조: 
          * for(초기화식;조건식;증감식){수행문}
          * ()안에서 초기화식 부분에 변수를 선언하고 그곳에 초기화를 한 다음
          * 조건식 부분에 변수의 조건을 선언하고 
          * 증감식 부분에 변수가 증가할지 감소할지를 작성함
          * 
          * 수행문 안은 조건식의 조건대로, 증감식의 증가 또는 감소하는대로
          * 변수가 증가 또는 감소함
          * 
          * 그 변수만큼 {} 안의 수행문이 수행됨
          * 
          * 위의 for문에서는 int형의 정수형으로 선언된 i가
          *  0부터 1까지 1씩 증가함
          */
         
         while(true) { // while문의 조건식 ()안이 true(참)이므로 {}안의 수행문이 무한반복
            System.out.println("=============================");
            System.out.println("1.Hit   2.Stand   0.GameEnd");
            System.out.println("-----------------------------");
            System.out.print("선택>> ");
            // println 과 print의 차이점
            
            // print는 말 그대로 화면에 있는 그대로 출력 하라 라는 의미
            // println 은 print + line 의 합성어로 출력하면서 한 줄을 개행(엔터치는 것)하라는 의미

            
            String strMenu = scan.nextLine();
            // String 클래스로 strMenu라는 객체를 선언하고
            // Scanner클래스로 정의한 객체 scan에 .nextLine()함수를 불러와서
            // strMenu라는 객체에 그 값을 담음
            
            // nextLine()함수는 문자 또는 문장 전체를 한 줄씩 입력받는다는 뜻
            // next() 함수는 문자 또는 문자열을 공백을 기준으로 한단어 또는 한문장씩 입력받는다는 뜻
            
            try {
               /* 예외처리를 하기 위한 Try Catch문이다.
                * 
                * 프로그램이 종료되는 것에 원인은 에러와 예외가 있는데
                * 에러(Error)와 란 컴퓨터 하드웨어의 오동작 또는 고장으로 인해 
                * 응용프로그램에 이상이 생겼거나 JVM 실행에 문제가 생겼을 경우 발생하는것이고
                * 
                * 예외는 사용자의 잘못된 조작,
                * 또는 개발자의 잘못된 코딩으로 인해 발생하는 프로그램 오류이다.
                * 
                * 발생하는 예외들에는 여러가지가 있는데
                * 지금 주로 발생하는 예외들은
                * NullPointException(존재하지 않는 레퍼런스를 참조할 때 발생. 
                *   객체가 없는 상태에서 객체를 사용하려고 하니 발생함.),
                * IOException(입출력 동작 실패 또는 인터럽트 시 발생)등이 있다.
                * 
                * 예외는 예외처리(Exception Handling)을 통해 
                * 프로그램을 종료 되지 않고 정상적으로 작동되게 만들어줄 수 있다.
                * 자바에서 예외처리는 Try Catch문을 통해 해줄 수 있다.
                */
               
               
               int intMenu = Integer.valueOf(strMenu);
               // int 자료형을 이용해 int형 변수 intMenu를 선언하고
               // strMenu를 Integer.valueOf 메서드(함수)를 이용해서 정수값으로 바꾸어
               // intMenu에 그 값을 담는다.
               
               if(intMenu == 0) { // intMenu가 0일 때
                  System.out.println("Good Bye!!"); //("")안의 문자열을 출력
                  // main method에서 return 문을 만나면
                  // 프로젝트 실행이 종료된다.
                  return;
               }
               
               if(intMenu == 1) { // intMenu가 1일 때
                  dealer.hit(); // dealer 객체로 hit 함수를 불러와서 현재 클래스에서 실행한다
                  player.hit(); // player 객체로 hit 함수를 불러와서 현재 클래스에서 실행한다
               }
               
               int dSum = dealer.sumValue();
               // int 자료형으로 dSum이라는 정수형 변수를 만들고 
               // dealer 객체로 sumValue()라는 함수를 불러와 dSum에 담음
               int pSum = player.sumValue();
               // int 자료형으로 pSum이라는 정수형 변수를 만들고 
               // player 객체로 sumValue()라는 함수를 불러와 pSum에 담음
               if(pSum > 21) { // 만약 pSum의 값이 21보다 크면
                  System.out.println("딜러승리!!"); // 딜러 승리!!를 콘솔에 출력하고
                  break; // 멈춘다
               } else if(dSum > 21) { // 그 이외의 경우 중 만약 dSum이 21이 넘으면
                  System.out.println("플레이어 승리!!"); // 플레이어 승리!! 를 출력하고
                  break; // 멈춘다
               }
               
               if(intMenu == 2) { // 만약 intMenu가 2일 때
                  if(dSum > pSum) { // 만약 dSum이 pSum보다 크면
                     System.out.println("딜러승리"); // 딜러 승리를 출력
                  } else { // 그렇지 않으면
                     System.out.println("플리에어 승리"); // 플레이어 승리를 출력
                  }
                  System.out.println("아무키나 누르세요..."); // 아무키나 누르세요를 출력
                  break; // 그리고 멈춘다
               }
               
               
            } catch (Exception e) {
               // 에러시 수행
            }
         }
      }
   }

}