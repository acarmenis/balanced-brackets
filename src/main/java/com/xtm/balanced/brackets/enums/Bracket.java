package com.xtm.balanced.brackets.enums;


import lombok.Getter;

@Getter
public enum Bracket {

   PAREN_OPEN('(', true),
   PAREN_CLOSE(')', false),
   CURLY_OPEN('{', true),
   CURLY_CLOSE('}', false),
   SQUARE_OPEN('[', true),
   SQUARE_CLOSE(']', false);

   private final char symbol;

   private final boolean opening;

   Bracket(char symbol, boolean opening) {
      this.symbol = symbol;
      this.opening = opening;
   }

   // Helper: get enum from char
   public static Bracket fromChar(char ch) {
      for (Bracket b : values()) {
         if (b.symbol == ch) return b;
      }
      return null;
   }

}
