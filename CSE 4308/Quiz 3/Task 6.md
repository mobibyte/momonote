## Question

Consider the 8-Puzzle problem. There are 8 tiles on a 3 by 3 grid. Your task is to get from some given configuration to a goal configuration. You can move a tile to an adjacent location as long as that location is empty.

Sample Initial configuration:
| 2 | 3 | 6 |
|---|---|---|
| 1 |   | 7 |
| 4 | 8 | 5 |

Sample Goal configuration:
| 1 | 2 | 3 |
|---|---|---|
| 4 | 5 | 6 |
| 7 | 8 |   |


Your task is to define this problem in PDDL Describe the initial state and the goal test using PDDL. Define appropriate actions for this planning problem, in the PDDL language. For each action, provide a name, arguments, preconditions, and effects.

## Answer

In PDDL (Planning Domain Definition Language), we can represent the 8-puzzle problem as follows. The domain describes the types, predicates, and actions, while the problem definition includes the specific initial state and the goal state.

### Domain Definition

::: details 
*pddl*
:::
```lisp
(define (domain eight-puzzle)

    (:requirements :strips)

    ;; Types
    (:types 
        position
    )

    ;; Predicates
    (:predicates
        (tile-at ?t - position ?p - position) ; Tile ?t is at position ?p
        (adjacent ?p1 ?p2 - position) ; Position ?p1 is adjacent to ?p2
        (empty ?p - position) ; Position ?p is empty
    )

    ;; Actions
    (:action move-tile
        :parameters (?t - position ?from - position ?to - position)
        :precondition (and (tile-at ?t ?from) (empty ?to) (adjacent ?from ?to))
        :effect (and (tile-at ?t ?to) (empty ?from) (not (tile-at ?t ?from)) (not (empty ?to)))
    )
)
```

### Problem Definition

::: details 
*pddl*
:::
```lisp
(define (problem eight-puzzle-problem)
    (:domain eight-puzzle)

    ;; Initial state
    (:init
        (tile-at t2 p1) (tile-at t3 p2) (tile-at t6 p3)
        (tile-at t1 p4) (empty p5) (tile-at t7 p6)
        (tile-at t4 p7) (tile-at t8 p8) (tile-at t5 p9)

        ;; Define adjacency (assuming p1 to p9 are the positions in the grid)
        (adjacent p1 p2) (adjacent p2 p1)
        (adjacent p2 p3) (adjacent p3 p2)
        (adjacent p4 p5) (adjacent p5 p4)
        (adjacent p5 p6) (adjacent p6 p5)
        (adjacent p7 p8) (adjacent p8 p7)
        (adjacent p8 p9) (adjacent p9 p8)
        (adjacent p1 p4) (adjacent p4 p1)
        (adjacent p2 p5) (adjacent p5 p2)
        (adjacent p3 p6) (adjacent p6 p3)
        (adjacent p4 p7) (adjacent p7 p4)
        (adjacent p5 p8) (adjacent p8 p5)
        (adjacent p6 p9) (adjacent p9 p6)
    )

    ;; Goal state
    (:goal (and
        (tile-at t1 p1) (tile-at t2 p2) (tile-at t3 p3)
        (tile-at t4 p4) (tile-at t5 p5) (tile-at t6 p6)
        (tile-at t7 p7) (tile-at t8 p8) (empty p9)
    ))
)
```

In this PDDL representation:

- The domain defines a single action type, `move-tile`, with parameters for the tile and its from/to positions. The precondition checks that the tile is in the 'from' position, the 'to' position is adjacent and empty. The effect moves the tile and updates the empty position.
  
- The problem definition specifies the initial state, with each tile's position and the empty slot, and the adjacency relationships between positions. The goal state reflects the desired configuration.
