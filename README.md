<h1 align="center">CMSC388T PacMan</h1>

<p align="center">John Blanco, Daniel Rowe, Will Spencer, Gilbert Garczynski<p>

TODO GIF of PacMan game running

## Table of Contents <!-- omit in toc -->

- [Usage](#usage)
- [PacMan](#pacman)
  - [get_valid_moves](#get_valid_moves)
  - [move](#move)
  - [is_ghost_in_range](#is_ghost_in_range)
  - [consume](#consume)
- [Ghost](#ghost)
  - [get_valid_moves](#get_valid_moves-1)
  - [move](#move-1)
  - [is_pacman_in_range](#is_pacman_in_range)
  - [attack](#attack)
- [Map](#map)
  - [move](#move-2)
  - [getLoc](#getloc)
  - [attack](#attack-1)
  - [eatCookie](#eatcookie)

## Usage

Enter the following in the terminal while in the `p1` directory

```bash
javac -cp "src/" src/*.java
java -cp "src/" StartMenu
```

## PacMan

### get_valid_moves

Implementation: 
This function returns the valid moves for the PacMan object at any current position on the board.  It checks each direction and if the direction is not a wall, it adds this direction to an Array List. 

Test:
Created a new map and positioned a PacMan at the coordinates (1,1).  The right and down directions are valid moves, so these two are checked for in the array that is returned from pacman.get_valid_moves().  The valid moves are: (2,1) and (1,2).


### move

TODO Implementation

TODO test

### is_ghost_in_range

Implementation:
This function checks if any ghost is in attack range of PacMan. A ghost can attack PacMan if it is within 1 block of PacMan. The function returns true when a ghost is within 1 block of PacMan and returns false otherwise.

Test:
Created a new map and position PacMan at (1, 1). Added a ghost at (3, 3) and a ghost at (1, 2). The function returned false for the ghost at (3, 3) and true for the ghost at (1, 2). 

### consume

Uses [`Map.getLoc()`](#getloc) to see if the current location contains a *power-cookie*. If it does, it calls [`Map.eatCookie()`](#eatcookie) and returns the `CookieComponent` that was eaten. Otherwise, it returns `null`.

Test:
To test this method, a `NoFrame` is created with a PacMan at a location that does not contain a cookie. `pacMan.consume()` is called and asserted to be `null`. Then a PacMan is added at a location with a cookie and `pacMan.consume()` is called again and asserted to not be `null`.

## Ghost

### get_valid_moves

Implementation:
This function returns the valid moves for the Ghost object at any current position on the board.  It checks each direction and if the direction is not a wall, it adds this direction to an Array List. 

Test:
Created a new map and positioned a Ghost at the coordinates (1,1).  The right and down directions are valid moves, so these two are checked for in the array that is returned from ghost.get_valid_moves().  The valid moves are: (2,1) and (1,2).


### move

TODO Implementation

TODO test

### is_pacman_in_range

TODO Implementation

TODO test

### attack

TODO Implementation

TODO test

## Map

### move

TODO Implementation

TODO test

### getLoc

Implementation:
Returns what is currently at the location.  Map.Type.WALL, Map.Type.PACMAN, Map.Type.GHOST, Map.Type.COOKIE, Map.Type.EMPTY

Test:
To test each possible location type, I created a map and loaded each object into it in specific coordinates.  


### attack

TODO Implementation

TODO test

### eatCookie

TODO Implementation

TODO test
