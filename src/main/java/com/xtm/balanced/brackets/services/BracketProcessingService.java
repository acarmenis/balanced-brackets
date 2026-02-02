package com.xtm.balanced.brackets.services;

import com.xtm.balanced.brackets.handlers.BracketHandler;
import com.xtm.balanced.brackets.enums.Bracket;
import com.xtm.balanced.brackets.factory.BracketHandlerFactory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * BracketProcessingService orchestrates the process of validating a string of brackets.
 * It delegates the logic for each closing bracket to the appropriate handler via the factory,
 * maintains the stack of opening brackets, and enforces input constraints.
 *
 * This decouples the processing logic from specific bracket types, makes the code extensible
 * for new brackets, and ensures testable, maintainable, and clean architecture.
 */
public class BracketProcessingService {

   private final BracketHandlerFactory factory;

   public BracketProcessingService(BracketHandlerFactory factory) {
      this.factory = factory;
   }

   /**
    * The isBalanced method validates whether a string of brackets is properly balanced.
    * It first performs a fail-fast check for null, single-character strings,
    * overly long strings, or strings with odd length.
    *
    * It then iterates through the string, pushing opening brackets onto a stack.
    * For closing brackets, it delegates the validation to the appropriate BracketHandler obtained
    * from the factory.
    *
    * Finally, it returns true only if the stack is empty, ensuring all brackets were correctly matched.
    * This design is clean, extensible, and separates concerns between orchestration,
    * validation logic, and bracket-specific handling
    * @param s
    * @return
    */
   public boolean isBalanced(String s) {

      if (Objects.isNull(s) || s.length() <= 1 || s.length() >= 1000 || s.length() % 2 != 0) {
         return false; // fail fast if invalid
      }

      Deque<Bracket> stack = new ArrayDeque<>();

      for (char ch : s.toCharArray()) {

         Bracket bracket = Bracket.fromChar(ch);

         if (Objects.isNull(bracket)) return false;

         if (bracket.isOpening()) {

            stack.push(bracket);

         } else {

            BracketHandler handler = factory.getHandler(bracket);

            if (Objects.isNull(handler) || !handler.handle(stack)) {

               return false;

            }

         }
      }

      return stack.isEmpty();
   }
}
