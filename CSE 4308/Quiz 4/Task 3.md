# Task 3

## Part a (Solve before Part b)
George doesn't watch much TV in the evening, unless there is a baseball game on. When there is baseball on TV, George is very likely to watch. George has a cat that he feeds most evenings, although he forgets every now and then. He's much more likely to forget when he's watching TV. He's also very unlikely to feed the cat if he has run out of cat food (although sometimes he gives the cat some of his own food). Design a Bayesian network for modeling the relations between these four events:

- baseball_game_on_TV
- George_watches_TV
- out_of_cat_food
- George_feeds_cat

Your task is to connect these nodes with arrows pointing from causes to effects.

## Part b (Solve after Part a)
You have been given the correct answer for Part A (here). You have also been given the conditional probabilties of each variable given it's parents. Calculate P ( not(Baseball Game on TV) | not(George Feeds Cat) ) using Inference by Enumeration