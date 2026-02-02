package com.xtm.balanced.brackets;

import com.xtm.balanced.brackets.factory.BracketHandlerFactory;
import com.xtm.balanced.brackets.services.BracketProcessingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BalancedBracketsApplicationTests {

   private BracketProcessingService service;

   /**
    * @BeforeEach:
    * Runs before every test method
    * Ensures each test gets a fresh service instance
    */
   @BeforeEach
   void setUp() {
      BracketHandlerFactory factory = new BracketHandlerFactory();
      service = new BracketProcessingService(factory);
   }

   @Test
   void shouldReturnFalseForSizeLessThanOrEqualToOne() {
      assertFalse(service.isBalanced("{"));
   }

   @Test
   void shouldReturnFalseForEmptyString() {
      assertFalse(service.isBalanced(""));
   }

   @Test
   void shouldReturnFalseForNullString() {
      assertFalse(service.isBalanced(null));
   }

   @ParameterizedTest
   @ValueSource(strings = { "{()", "(()", "[{}(", "{[(" })
   void shouldReturnFalseForOddLengthStrings(String input) {
      assertFalse(service.isBalanced(input));
   }

   @ParameterizedTest
   @ValueSource(strings = { "{[{}]}", "{{[[(())]]}}" })
   void shouldValidateBalancedBrackets(String input) {
      assertTrue(service.isBalanced(input));
   }

   @Test
   void shouldReturnFalseForIncorrectlyNestedString() {
      assertFalse(service.isBalanced("{[{]}]}"));
   }

}
