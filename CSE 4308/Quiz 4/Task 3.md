# Task 3

## Question
### Part a (Solve before Part b)
George doesn't watch much TV in the evening, unless there is a baseball game on. When there is baseball on TV, George is very likely to watch. George has a cat that he feeds most evenings, although he forgets every now and then. He's much more likely to forget when he's watching TV. He's also very unlikely to feed the cat if he has run out of cat food (although sometimes he gives the cat some of his own food). Design a Bayesian network for modeling the relations between these four events:

- baseball_game_on_TV
- George_watches_TV
- out_of_cat_food
- George_feeds_cat

Your task is to connect these nodes with arrows pointing from causes to effects.

### Part b (Solve after Part a)
You have been given the correct answer for Part A (here). You have also been given the conditional probabilties of each variable given it's parents. Calculate P ( not(Baseball Game on TV) | not(George Feeds Cat) ) using Inference by Enumeration

## Answer  

### Part b  

Let's represent  
B: Baseball_game_on_TV  
G: George_watches_TV  
C: out_of_cat_food  
F: George_feeds_cat  

$P(\frac{not(Baseball\_game\_on\_TV)}{not(George\_feeds\_cat)})=P(\frac{\neg B}{\neg F})$

$P(\frac{not(Baseball\_game\_on\_TV)}{not(George\_feeds\_cat)})=\frac{P(\neg B \wedge \neg F)}{P(\neg F)}$

$P(\neg F)=$ \
$=P(B \wedge G \wedge C \wedge \neg F)$ \
$+P(B \wedge G \wedge \neg C \wedge \neg F)$ \
$+P(B \wedge \neg G \wedge C \wedge \neg F)$ \
$+P(B \wedge \neg G \wedge \neg C \wedge \neg F)$ \
$+P(\neg B \wedge G \wedge C \wedge \neg F)$ \
$+P(\neg B \wedge G \wedge \neg C \wedge \neg F)$ \
$+P(\neg B \wedge \neg G \wedge C \wedge \neg F)$ \
$+P(\neg B \wedge \neg G \wedge \neg C \wedge \neg F)$  

$=P(B) \times P(\frac{G}{B}) \times P(C) \times P(\frac{\neg F}{G,C})$  \
$+P(B) \times P(\frac{G}{B}) \times P(\neg C) \times P(\frac{\neg F}{G,\neg C})$  \
$+P(B) \times P(\frac{\neg G}{B}) \times P(C) \times P(\frac{\neg F}{\neg G,C})$  \
$+P(B) \times P(\frac{\neg G}{B}) \times P(\neg C) \times P(\frac{\neg F}{\neg G,\neg C})$  \
$+P(\neg B) \times P(\frac{G}{\neg B}) \times P(C) \times P(\frac{\neg F}{G, C})$  \
$+P(\neg B) \times P(\frac{G}{\neg B}) \times P(\neg C) \times P(\frac{\neg F}{G, \neg C})$  \
$+P(\neg B) \times P(\frac{\neg G}{\neg B}) \times P(C) \times P(\frac{\neg F}{\neg G, C})$  \
$+P(\neg B) \times P(\frac{\neg G}{\neg B}) \times P(\neg C) \times P(\frac{\neg F}{\neg G, \neg C})$   

$=0.304109589 \times 0.927927928 \times 0.169863014 \times 0.958333333$ \
$+0.304109589 \times 0.927927928 \times 0.830136986 \times 0.293577982$ \
$+0.304109589 \times 0.72072072 \times 0.169863014 \times 0.684210526$ \
$+0.304109589 \times 0.72072072 \times 0.830136986 \times 0.041237113$ \
$+0.695890411 \times 0.118110236 \times 0.169863014 \times 0.958333333$ \
$+0.695890411 \times 0.118110236 \times 0.830136986 \times 0.293577982$ \
$+0.695890411 \times 0.8818897644 \times 0.169863014 \times 0.684210526$ \
$+0.695890411 \times 0.8818897644 \times 0.830136986 \times 0.041237113$ \

$=0.243751575$

$P(\neg B \wedge \neg F) =$ \
$=P(\neg B \wedge G \wedge C \wedge \neg F)$ \
$+P(\neg B \wedge G \wedge \neg C \wedge \neg F)$ \
$+P(\neg B \wedge \neg G \wedge C \wedge \neg F)$ \
$+P(\neg B \wedge \neg G \wedge \neg C \wedge \neg F)$ 

$=P(\neg B) \times P(\frac{G}{\neg B}) \times P(C) \times P(\frac{\neg F}{G, C})$ \
$+P(\neg B) \times P(\frac{G}{\neg B}) \times P(\neg C) \times P(\frac{\neg F}{G, \neg C})$ \
$+P(\neg B) \times P(\frac{\neg G}{\neg B}) \times P(C) \times P(\frac{\neg F}{\neg G, C})$ \
$+P(\neg B) \times P(\frac{\neg G}{\neg B}) \times P(\neg C) \times P(\frac{\neg F}{\neg G, \neg C})$ \

$= 0.125744303$

$P(\neg B \wedge \neg F) = \frac{0.125744303}{0.243751575}$ \

$P(\neg B \wedge \neg F) = 0.515870730$ \