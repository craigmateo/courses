# Logical Properties

1. **Is the sentence $(p \lor (p \implies q))$ valid, contingent, or unsatsfiable?**

| p | q | $p \implies q$ |$(p \lor (p \implies q))$ |
|---|---|---|---|
|T|T|T|T|
|T|F|F|T|
|F|T|T|T|
|F|F|T|T|
VALID

2. **Is the sentence $((p \implies q) \land (¬p \implies q))$ valid, contingent, or unsatsfiable?**

| p | q | $p \implies q$ |$\neg p \implies q$ | $((p \implies q) \land (¬p \implies q))$ |
|---|---|---|---|---|
|T|T|T|T|T|
|T|F|F|T|F|
|F|T|T|T|T|
|F|F|T|F|F|
CONTINGENT

3. **Is the sentence $((p \implies q) \land (p \implies ¬q))$ valid, contingent, or unsatsfiable?**

| p | q | $p \implies q$ |$p \implies \neg q$ | $((p \implies q) \land (p \implies ¬q))$ |
|---|---|---|---|---|
|T|T|T|F|F|
|T|F|F|T|F|
|F|T|T|T|T|
|F|F|T|T|T|
CONTINGENT

4. **Is the sentence $((¬p \lor q) \iff (p \implies (q \implies p)))$ valid, contingent, or unsatsfiable?**

| p | q | $¬p \lor q$ |$q \implies p$ | $p \implies(q \implies p)$ | $(¬p \lor q) \implies (p \implies(q \implies p))$ | $(p \implies(q \implies p)) \implies (¬p \lor q))$ | $(¬p \lor q) \iff (p \implies (q \implies p))$ |
|---|---|---|---|---|--|--|--|
|T|T|T|T|T|T|T|T
|T|F|F|F|F|T|T|T
|F|T|T|T|T|T|F|F
|F|F|T|T|T|T|F|F
CONTINGENT

5. Is the sentence $((p \land ¬p) \iff (q \land ¬q))$ valid, contingent, or unsatsfiable?

| p | q | $p \land ¬p$ |$q \land ¬q$ | $(p \land ¬p) \implies (q \land ¬q)$ | $(q \land ¬q) \implies (p \land ¬p)$ | $((p \land ¬p) \iff (q \land ¬q))$
|---|---|---|---|---|--|--|
|T|T|F|F|T|T|T
|T|F|F|F|T|T|T
|F|T|F|F|T|T|T
|F|F|F|F|T|T|T
VALID