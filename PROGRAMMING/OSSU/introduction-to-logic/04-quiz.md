# Logical Relationships

1. **If $\Delta \vDash \Psi$, then $\Delta \nvDash \neg \Psi$. True or false?**

|$\Delta$|$\Psi$|$\neg \Psi$|
|--|--|--|
|1|1|0|
|0|0|1|
|0|1|0|

Row two above is a counter example where $\Delta \vDash \neg \Psi$. The answer is false.

***

2. **If $\Delta \nvDash \neg \Psi$, then $\Delta \vDash \Psi$. True or false?**

The table shows possible truth values satisfying $\Delta \nvDash \neg \Psi$.

|$\Delta$|$\Psi$|$\neg \Psi$|
|--|--|--|
|1|1|0|
|0|1|0|
|0|0|1|

Consider the second row, where $\Delta \vDash \Psi$ is false. The answer is false.

***

3. **If $\Gamma \nvDash \phi$ and $\Delta \nvDash \Psi$, then $\Gamma \bigcap \Delta \vDash (\phi \land \Psi)$. True or false?**

|$\Gamma$|$\phi$|$\Delta$|$\Psi$|$\Gamma \bigcap \Delta$|$\phi \land \Psi$
|--|--|--|--|--|--|
|1|0|1|0|1|0
|0|1|0|1|0|1
|0|0|0|0|0|0

False.

***

4. **If $\phi \vDash \psi$ and $\phi \vDash \neg \psi$ then $\phi$ is unsatisfiable. True or false?**

|$\phi$|$\psi$|$\neg \psi$|
|--|--|--|
|1|1|0|
|0|0|1|
|0|1|0|

True.

***

5. **If $\phi \vDash \psi$ and $\neg \phi \vDash \psi$ then $\psi$ is valid. True or false?**

|$\phi$|$\psi$|$\neg \phi$|
|--|--|--|
|1|1|0|
|0|0|1|
|0|1|1|

True.