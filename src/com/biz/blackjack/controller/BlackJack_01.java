package com.biz.blackjack.controller;

import com.biz.blackjack.service.BlackJackService;

public class BlackJack_01 {

   public static void main(String[] args) {

      BlackJackService bs = new BlackJackService();
      // BlackJackService 클래스로 bs라는 인스턴스를 생성하고
      // BlackJackService() 생성자 메서드로 초기화 해 이 클래스에서 bs를 사용할 수 있도록 한다.
      
      bs.makeDeck(); // bs 인스턴스로 makeDeck() 함수를 가져온다.
      bs.viewCardList(); // bs 인스턴스로 viewVardList() 함수를 가져온다.
      
      
   }

}