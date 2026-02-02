package com.xtm.balanced.brackets.handlers;

import com.xtm.balanced.brackets.enums.Bracket;

import java.util.Deque;

/**
 * CurlyBraceHandler is a specialized class that implement the BracketHandler interface.
 * It handles exactly one type of closing bracket: '{'
 * It encapsulates the logic of matching a closing bracket to its corresponding opening bracket on a stack.
 */
public class CurlyBraceHandler implements BracketHandler {
   @Override
   public boolean handle(Deque<Bracket> stack) {
      return !stack.isEmpty() && stack.pop() == Bracket.CURLY_OPEN;
   }
}
