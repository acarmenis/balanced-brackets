package com.xtm.balanced.brackets.handlers;

import com.xtm.balanced.brackets.enums.Bracket;

import java.util.Deque;

/**
 * BracketHandler interface is used to abstract the logic for handling closing brackets.
 * It allows the processing service to be decoupled from concrete implementations,
 * supports adding new bracket types without changing the service, and makes testing
 * easier by isolating each handler’s logic
 */
public interface BracketHandler {
   boolean handle(Deque<Bracket> stack);
}
