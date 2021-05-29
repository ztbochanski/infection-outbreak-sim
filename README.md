# Bochanski Java Basic Concepts Demo

## Summary

> A zombie vs human simulation using the [Processing](https://processing.org/) library and Java.

The intent of this project is to create a functional demonstration of object oriented programming concepts including:
- encapsulation
- inheritance
- abstraction
- polymorphism

A focus is placed adhering to the Java conventions outlined in [Java Style Guide](https://google.github.io/styleguide/javaguide.html#s5-naming).

## Design Approach

1. prototyping/brainstorming document
2. UML diagram
3. lay out programming tasks
4. run sprints on tasks
5. compare program to UML
6. write tests

## Requirements Analysis:
### Movement:
- Random, side to side, up and down
- Stay within window
- Humans up
- Zombies down
### 2 sets of circles (humans top, zombies bottom):
- Random sizes
- Different colors
- Collision between humans and zombies:
- Sound effect when human kills zombie
- Human turns into zombie object changes direction
- Explosion when death
### 2 counters:
- One for humans, one for zombies
- Both show initial population of each
- 25% chance of initial total being zombies
- Population of each tracked in real time

## Questions on Design:
- Programming chance/probability?
- Designing random movement?
- Zombie/human, human/zombie interaction?
- How to create an explosion?
- Class design?
- Population size using probability?
## Objects/Behaviors Outline:
- Zombie/Human Objects
  - Behaviors
    - Move
      - Random∏
      - Heads south
    - Draw
      - Circle, transparent
    - Collides
- Counter
  - Behaviors
    - Draw
       - Display count of respective population
    - Increment
       - Update count
- Sketch
  - Behaviors
     - Settings
       - Window size
     - Setup
       - Initial sapien populations
