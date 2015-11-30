package com.theironyard;

import java.util.HashSet;
import java.util.stream.Collectors;

public class Main {

    static HashSet<Card> createDeck() {
        HashSet<Card> deck = new HashSet();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                Card c = new Card(suit, rank);
                deck.add(c);
            }
        }
        return deck;
    }

    static HashSet<HashSet<Card>> createHands(HashSet<Card> deck) {
        HashSet<HashSet<Card>> hands = new HashSet();
        for (Card c1 : deck) {
            HashSet<Card> deck2 = (HashSet<Card>) deck.clone();
            deck2.remove(c1);
            for (Card c2 : deck2) {
                HashSet<Card> deck3 = (HashSet<Card>) deck2.clone();
                deck3.remove(c2);
                for (Card c3 : deck3) {
                    HashSet<Card> deck4 = (HashSet<Card>) deck3.clone();
                    deck4.remove(c3);
                    for (Card c4 : deck4) {
                        HashSet<Card> hand = new HashSet();
                        hand.add(c1);
                        hand.add(c2);
                        hand.add(c3);
                        hand.add(c4);
                        hands.add(hand);
                    }
                }
            }
        }
        return hands;
    }

    static boolean isFlush(HashSet<Card> hand) {
        HashSet<Card.Suit> suits = hand.stream()
                .map(card -> {
                    return card.suit;
                })
                .collect(Collectors.toCollection(HashSet::new));
        return suits.size() == 1;
    }

    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();

        Card aceOfSpades = new Card(Card.Suit.SPADES, Card.Rank.ACE);
        HashSet<Card> deck = createDeck();
        //System.out.println(deck.size());
        //System.out.println(deck.contains(aceOfSpades));
        HashSet<HashSet<Card>> hands = createHands(deck);
        hands = hands.stream()
                .filter(Main::isFlush)
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println(hands.size());

        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Elapsed time: %d msecs", endTime - beginTime));
    }
}
