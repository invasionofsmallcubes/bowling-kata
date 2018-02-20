### Bowling Kata

*Create a program, which, given a valid sequence of rolls for one line of American Ten-Pin Bowling, produces the total score for the game.*

[source](http://codingdojo.org/kata/Bowling/)

### Rules of the game

A **game** is composed by **10 Frames**.

For each **frame** you have **2 throws**.

If you knock down all the pins with the **first throw**, then it's a **strike**.

Score for a **frame** when a **strike** happens: 10 + next two throws.

*Example: if you score a strike in the first frame, then an 7 and 1 in the second frame, you would score 18 (10+7+1) for the first frame, and 8 for the second frame, making a total of 26 after two frames.*

If you knock down some of the pins on the first ball, and knocked down the remainder of the pins in the second ball, it is known as a *spare*.

Score for a **frame** when a **spare** happens: 10 + next one throw.

*Example: if score a spare in the first frame, say an 6 and a 4, then got an 8 and a 1 in the second frame, you would score 18 (6+4+8) for the first frame, and 9 for the second frame, making a total of 27 after two frames.*

In the final frame you get a **bonus throw** if you make a **strike** or a **spare**.

*Example: If you strike in the first delivery you have the opportunity to strike in the remaining two and have three deliveries in total. If you scored strikes in each of your final three deliveries, the score for the final frame would be 30 (10+10+10). If you spare the final frame, you get the third delivery as a bonus. So, a spare, 9 and 1, followed by a strike would equal 20 (9+1+10).*

[source](http://www.topendsports.com/sport/tenpin/scoring.htm)

#### Acceptance Tests
- `X X X X X X X X X X X X` (12 rolls: 12 strikes) = 10 frames * 30 points = 300
- `9- 9- 9- 9- 9- 9- 9- 9- 9- 9-` (20 rolls: 10 pairs of 9 and miss) = 10 frames * 9 points = 90
- `5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5` (21 rolls: 10 pairs of 5 and spare, with a final 5) = 10 frames * 15 points = 150

where:
- `X` is a strike
- `-` is a miss
- `/` is a spare
