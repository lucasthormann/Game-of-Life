# ***Conway's-Game-of-Life***
* This program is the solution to the fifth homework assignment assigned in the Object Oriented Principals & Design course from the Computer Science Department of Texas State University during the Fall 2021 semester. It is an adapted implementation of John Conway's Game of Life written in Java.

**Description**
* This program is a digitalized version of a cellular automaton devised by the British mathematician John Horton Conway. The program will allow the user to set the initial configuration of the game board and the number of evolutions to be processed. The user will then be able to observe the boards final state after the number of specified evolutions have been processed. The logic of this program is implemented using threads such that each cell in the automaton is evaluated within its own subprocess. In order to properly use this software the user must understand John Conway's Game of Life and all of its associated rules.

**Building on Windows/MAC/Linux**
* In order to properly build and run this program, you must install all of the files included in the repository. This software is capable of running on any digital, computational device capable of compiling and executing Java files. Once you have properly installed the files you should then open them in an IDE capable of compiling and executing Java files. Once the files are properly opened in a functional IDE, use the tools provided by the IDE to build and run the program.

**Dependencies**
* Install the latest version of an IDE capable of compiling and executing Java files.

**Program Execution**
* I've used Eclipse IDE for running and debugging, so the execution could be done using the graphical interface of the IDE.

**Conway's Game of Life Rule Set**
- At the heart of this game are four simple rules that determine if a cell is live or dead. All depend on how many of that cell's neighbors are alive.
```
1. Births: Each dead cell adjacent to exactly three live neighbors will become live in the next generation.
2. Death by isolation: Each live cell with one or fewer live neighbors will die in the next generation.
3. Death by overcrowding: Each live cell with four or more live neighbors will die in the next generation.
4. Survival: Each live cell with either two or three live neighbors will remain alive for the next generation
```
