package com.xtm.balanced.brackets.factory;

import com.xtm.balanced.brackets.handlers.BracketHandler;
import com.xtm.balanced.brackets.enums.Bracket;
import com.xtm.balanced.brackets.handlers.CurlyBraceHandler;
import com.xtm.balanced.brackets.handlers.ParenthesisHandler;
import com.xtm.balanced.brackets.handlers.SquareBracketHandler;

import java.util.EnumMap;
import java.util.Map;

/**
 * The BracketHandlerFactory is a factory class whose primary responsibility
 * is to supply the correct BracketHandler for a given closing bracket.
 * It decouples the client code (the bracket-processing service) from the specific handler implementations.
 * The service does not need to know which handler to create — it simply asks the factory for one.

 * Think of it as a lookup service:
 * "Given a closing bracket, give me the right handler that knows how to validate it against the stack."
 */
public class BracketHandlerFactory {

   // EnumMap<>(Bracket.class) tells the map: “all keys are of type Bracket”
   // Cleaner and slightly faster than HashMap
   private static final Map<Bracket, BracketHandler> HANDLERS = new EnumMap<>(Bracket.class);

   /**
    * Static initializer block.
    * Runs once when the class is loaded, before any instances are created.
    * It’s used to initialize static variables, in this case HANDLERS.
    * HANDLERS is static final --> we need a way to populate it once
    */
   static {
      HANDLERS.put(Bracket.PAREN_CLOSE, new ParenthesisHandler());
      HANDLERS.put(Bracket.CURLY_CLOSE, new CurlyBraceHandler());
      HANDLERS.put(Bracket.SQUARE_CLOSE, new SquareBracketHandler());
   }

   /**
    * Itt returns the appropriate bracket handler
    * @param bracket
    * @return
    */
   public static BracketHandler getHandler(Bracket bracket) {
      return HANDLERS.get(bracket);
   }

}
