## Question
Consider the KB

(A => C) AND (B <=> C) AND (D => A) AND E AND [(B AND E) => G] AND (B => F) AND D

Show that this entails G (if possible) by

i. Forward Chaining  
ii. Backward Chaining  
iii. Resolution  

## Answer

To show that the given knowledge base entails $ G $, we will apply three different logical inference techniques: forward chaining, backward chaining, and resolution.

### Knowledge Base (KB)

The knowledge base can be represented as:
1. $ A \implies C $
2. $ B \Leftrightarrow C $
3. $ D \implies A $
4. $ E $
5. $ (B \wedge E) \implies G $
6. $ B \implies F $
7. $ D $

### i. Forward Chaining

In forward chaining, we start with the known facts and apply inference rules to derive new facts until we either reach the goal or exhaust all possibilities.

1. Start with the known facts: $ E $ and $ D $.
2. From $ D $ and $ D \implies A $, infer $ A $.
3. From $ A $ and $ A \implies C $, infer $ C $.
4. From $ C $ and $ B \Leftrightarrow C $, infer $ B $.
5. Now we have $ B $ and $ E $, so from $ (B \wedge E) \implies G $, we can infer $ G $.

Thus, using forward chaining, we have shown that $ G $ follows from the knowledge base.

### ii. Backward Chaining

In backward chaining, we start with the goal and work backwards to see if it can be deduced from the known facts.

1. Goal: $ G $.
2. To infer $ G $, we need $ B \wedge E $.
3. $ E $ is a known fact.
4. To infer $ B $, we look at $ B \Leftrightarrow C $. We need either $ B $ or $ C $.
5. $ C $ can be inferred from $ A $ (using $ A \implies C $).
6. $ A $ can be inferred from $ D $ (using $ D \implies A $).
7. $ D $ is a known fact.

Since we can trace back from $ G $ to the known facts, backward chaining also shows that $ G $ is entailed by the knowledge base.

### iii. Resolution

In resolution, we convert all statements into clauses and use the resolution rule to derive contradictions or the goal.

1. Convert KB into clauses:
   - $ A \implies C $ becomes $ \neg A \vee C $.
   - $ B \Leftrightarrow C $ becomes $ (\neg B \vee C) \wedge (\neg C \vee B) $.
   - $ D \implies A $ becomes $ \neg D \vee A $.
   - $ E $.
   - $ (B \wedge E) \implies G $ becomes $ \neg B \vee \neg E \vee G $.
   - $ B \implies F $ becomes $ \neg B \vee F $.
   - $ D $.

2. Using resolution:
   - Resolve $ D $ and $ \neg D \vee A $ to get $ A $.
   - Resolve $ A $ and $ \neg A \vee C $ to get $ C $.
   - Resolve $ C $ and $ \neg C \vee B $ to get $ B $.
   - With $ B $ and $ E $ (known fact), we get $ G $ from $ \neg B \vee \neg E \vee G $.

Thus, by resolution, we can derive $ G $ from the knowledge base.

In summary, all three methods — forward chaining, backward chaining, and resolution — demonstrate that $ G $ is entailed by the given knowledge base.

