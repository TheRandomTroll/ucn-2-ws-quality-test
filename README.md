# UCN Workshop - Quality & Testing | 2nd semester

---
Participants: dmaj0920, Group 1

- Mihail Gerginov
- Teo Stanic
- Antonio Kovacevic
- Marko Veljkovic
- Lucas Inaschwili-Hongre

---

## Abstract

This workshop is a part of the 2nd semester curriculum for the Computer Science degree at UCN. The premise of the project is to design Use-Case scenarios, unit tests and integration tests for a pre-made project. Other tasks may include refactoring the code to resolve issues or to improve code quality and performance.

## Section 1: System Development (Diagrams and Use-Case scenarios)

All diagrams can be found in the ***diagrams*** folder. The prefix notation is as follows:

- `[UC]` - **U**se **C**ase
- `[UCS]` - **U**se-**C**ase **S**cenario

## Section 2: Programming (Setting up the work environment)

In order to make a successful connection to the database, make sure you check the file: `src/databaselayer/DBConnection.java`. Lines 14 and 15 should look like this:

```java
private static String userName = ";user=sa";
private static String password = ";password=Password1!";
```

Make sure you change the user and password within the quotes to match your user and password login.