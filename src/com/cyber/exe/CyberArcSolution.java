package com.cyber.exe;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;


/**
 * 
 * 
 * Deck of cards – Technical overview
Please implement the following steps using the Deck of Cards APIs
(https://www.deckofcardsapi.com):
1.  Create a new CLI project in your preferred language.
2.  Generate a new shuffled deck of cards.
3.  Draw fifteen cards from the deck and print the code of each card.
4.  Sort these cards first by value, then by suit. The order of suits should be
    Hearts, Diamonds, Clubs, and Spades.
5.  Print the codes of the sorted cards.
Good luck!
 * 
 * 
 *
 */
public class CyberArcSolution {
	private HttpClient client;
	
	public CyberArcSolution() {
		this.client = HttpClient.newHttpClient();
	}
	
	public String shuffleCards() throws IOException, InterruptedException {
		String cardUrl = "https://www.deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1";
		
		HttpRequest request = HttpRequest.newBuilder()
				  .uri(URI.create(cardUrl))
				  .GET()
				  .build();
		
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println("Http code: " + response.statusCode());
		return response.body();
	}
	
	
	// https://www.deckofcardsapi.com/api/deck/<<deck_id>>/draw/?count=2
	public String drawACard(String deckID, int amountOfCardToDraw) throws IOException, InterruptedException {
		String drawUrl = String.format("https://www.deckofcardsapi.com/api/deck/%s/draw/?count=%d", deckID, amountOfCardToDraw);
		
		System.out.println("Formated URL" + drawUrl);
		
		HttpRequest request = HttpRequest.newBuilder()
				  .uri(URI.create(drawUrl))
				  .GET()
				  .build();
		
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println("Http code: " + response.statusCode());
		return response.body();
	}
	
	
	public Map<String, String> stringToMap(String response) {
		String[] clear = response.replace("\"","").replace("{", "").replace("}", "").split(",");
		Map<String, String> reconstructedUtilMap = new HashMap<>();
		
		for(String in : clear) {
			String[] mapKV = in.trim().split(":");
			reconstructedUtilMap.put(mapKV[0].trim(), mapKV[1].trim());
		}
		
		
//		Map<String, String> reconstructedUtilMap = Arrays.stream(response.replace("{", "").replace("}", "").split(","))
//	            .map(s -> s.split(":"))
//	            .collect(Collectors.toMap(s -> s[0], s -> s[1]));
		return reconstructedUtilMap;
	}
	
	// 1. shuffle
	// Card -> Suit and Value 
	// 1 - 52 
    // Find a way to map String to Response Object
	
	// Drawn Cards:= {"success": true, "deck_id": "8022r2ac9uah", 
	// "cards": [{"code": "QS", "image": "https://deckofcardsapi.com/static/img/QS.png", "images": {"svg": "https://deckofcardsapi.com/static/img/QS.svg", "png": "https://deckofcardsapi.com/static/img/QS.png"}, "value": "QUEEN", "suit": "SPADES"}, 
	//           
	// {"code": "9C", "image": "https://deckofcardsapi.com/static/img/9C.png", "images": {"svg": "https://deckofcardsapi.com/static/img/9C.svg", "png": "https://deckofcardsapi.com/static/img/9C.png"}, "value": "9", "suit": "CLUBS"}, {"code": "9D", "image": "https://deckofcardsapi.com/static/img/9D.png", "images": {"svg": "https://deckofcardsapi.com/static/img/9D.svg", "png": "https://deckofcardsapi.com/static/img/9D.png"}, "value": "9", "suit": "DIAMONDS"}, {"code": "JD", "image": "https://deckofcardsapi.com/static/img/JD.png", "images": {"svg": "https://deckofcardsapi.com/static/img/JD.svg", "png": "https://deckofcardsapi.com/static/img/JD.png"}, "value": "JACK", "suit": "DIAMONDS"}, {"code": "6H", "image": "https://deckofcardsapi.com/static/img/6H.png", "images": {"svg": "https://deckofcardsapi.com/static/img/6H.svg", "png": "https://deckofcardsapi.com/static/img/6H.png"}, "value": "6", "suit": "HEARTS"}, {"code": "3D", "image": "https://deckofcardsapi.com/static/img/3D.png", "images": {"svg": "https://deckofcardsapi.com/static/img/3D.svg", "png": "https://deckofcardsapi.com/static/img/3D.png"}, "value": "3", "suit": "DIAMONDS"}, {"code": "7S", "image": "https://deckofcardsapi.com/static/img/7S.png", "images": {"svg": "https://deckofcardsapi.com/static/img/7S.svg", "png": "https://deckofcardsapi.com/static/img/7S.png"}, "value": "7", "suit": "SPADES"}, {"code": "2C", "image": "https://deckofcardsapi.com/static/img/2C.png", "images": {"svg": "https://deckofcardsapi.com/static/img/2C.svg", "png": "https://deckofcardsapi.com/static/img/2C.png"}, "value": "2", "suit": "CLUBS"}, {"code": "8C", "image": "https://deckofcardsapi.com/static/img/8C.png", "images": {"svg": "https://deckofcardsapi.com/static/img/8C.svg", "png": "https://deckofcardsapi.com/static/img/8C.png"}, "value": "8", "suit": "CLUBS"}, {"code": "3H", "image": "https://deckofcardsapi.com/static/img/3H.png", "images": {"svg": "https://deckofcardsapi.com/static/img/3H.svg", "png": "https://deckofcardsapi.com/static/img/3H.png"}, "value": "3", "suit": "HEARTS"}, {"code": "QH", "image": "https://deckofcardsapi.com/static/img/QH.png", "images": {"svg": "https://deckofcardsapi.com/static/img/QH.svg", "png": "https://deckofcardsapi.com/static/img/QH.png"}, "value": "QUEEN", "suit": "HEARTS"}, {"code": "8D", "image": "https://deckofcardsapi.com/static/img/8D.png", "images": {"svg": "https://deckofcardsapi.com/static/img/8D.svg", "png": "https://deckofcardsapi.com/static/img/8D.png"}, "value": "8", "suit": "DIAMONDS"}, {"code": "5S", "image": "https://deckofcardsapi.com/static/img/5S.png", "images": {"svg": "https://deckofcardsapi.com/static/img/5S.svg", "png": "https://deckofcardsapi.com/static/img/5S.png"}, "value": "5", "suit": "SPADES"}, {"code": "4D", "image": "https://deckofcardsapi.com/static/img/4D.png", "images": {"svg": "https://deckofcardsapi.com/static/img/4D.svg", "png": "https://deckofcardsapi.com/static/img/4D.png"}, "value": "4", "suit": "DIAMONDS"}, {"code": "7C", "image": "https://deckofcardsapi.com/static/img/7C.png", "images": {"svg": "https://deckofcardsapi.com/static/img/7C.svg", "png": "https://deckofcardsapi.com/static/img/7C.png"}, "value": "7", "suit": "CLUBS"}], "remaining": 37}
    // "code": "6H"
	// Card
	// code
	// "value": "QUEEN", 
	// "suit": "SPADES"
	// sort by: value and then by suit
	// use Comparator or Comparable 1 0 -1
	//  numbers - less than Strings
	//  Map  1 -> 20 .. 10 - 10 J - 11 Q -> 12 K -> 33 A
	//  char_1
	// Hearts, Diamonds, Clubs, and Spades -> 4, Hearts -> 1, Diamonds -> 2, Clubs -> 3 ... 
	// 1 Hearts -> 1
	// 2 He     -> 2
	// last -> 100
	
	
	public static void main(String[] args) {
		CyberArcSolution runner = new CyberArcSolution();
		try {
	       
			// Step 1:
			String cards = runner.shuffleCards();
			System.out.println("Cards:= " + cards);
			
			// Step 2:
			int drawCardAmount = 15;
			Map<String, String> cardsAsMap = runner.stringToMap(cards);
			
			String deckID = cardsAsMap.get("deck_id");

			String drawnCards = runner.drawACard(deckID, drawCardAmount);
			System.out.println("Drawn Cards:= " + drawnCards);
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
