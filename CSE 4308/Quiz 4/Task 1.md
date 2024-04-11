# Task 1

Consider the given joint probabilty distribution for a domain of two variables (Color, Vehicle) :

|                 | Color = Red | Color = Green | Color = Blue |
|-----------------|-------------|---------------|--------------|
| Vehicle = Car   | 0.1184      | 0.1280        | 0.0736       |
| Vehicle = Van   | 0.0444      | 0.0480        | 0.0276       |
| Vehicle = Truck | 0.1554      | 0.1680        | 0.0966       |
| Vehicle = SUV   | 0.0518      | 0.0560        | 0.0322       |


Part a: Calculate P ( Color is not Green | Vehicle is Truck )

Part b: Check if Vehicle and Color are totally independant from each other

## Part A
Calculate P ( Color is not Green | Vehicle is Truck )

$=P(\frac{Color \not=Green}{Vehicle=Truck})$  

$=\frac{P(Color \not=Green \wedge Vehicle=Truck)}{P(Vehicle=Truck)}$  

$=\frac{0.1554 + 0.0966}{0.1554+0.1680+0.0966}=0.6$

## Part B
Check if Vehicle and Color are totally independant from each other  

$P(Color\not=Green)=1-P(Color=Green)$
$P(Color\not=Green)=1-0.1280+0.0480+0.1680+0.0560$
$P(Color\not=Green)=0.6$ \
$P(Color\not=Green)=P(\frac{Color\not=Green}{Vehicle=Truck})$

So Color & and Vehicle are independent from each other