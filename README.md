<h1 align="center">CMSC388T PacMan</h1>

<p align="center">John Blanco, Daniel Rowe, Will Spencer, Gilbert Garczynski<p>

<div align="center">

![PacMan GIF](pacman.gif)

</div>

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

Enter the following in the terminal while in the `Projects/P1` directory

```bash
javac -cp "src/" src/*.java
java -cp "src/" StartMenu
```

## PacMan

### get_valid_moves

Returns the valid moves for the PacMan object at any current position on the board.  It checks each direction and if the direction is not a wall, it adds this direction to an Array List.

Test:
Created a new map and positioned a PacMan at the coordinates (1,1).  The right and down directions are valid moves, so these two are checked for in the array that is returned from pacman.get_valid_moves().  The valid moves are: (2,1) and (1,2).

### move

Takes a random Location that's being passed in using PacMan.get_valid_moves() and since that's returned in get_valid_moves() are all valid, this function only returns true.

Test:
Created a new map and positioned a new PacMan instance at position (1,0). I then created a for loop that contained an assertTrue() to make sure that PacMan.move() returns True for the a consecutive amount of times, in which the group decided would be four times.

### is_ghost_in_range

Checks if any ghost is in attack range of PacMan. A ghost can attack PacMan if it is within 1 block of PacMan. Uses [`Map.getLoc()`](#getloc) to see check the 1 block radius surrounding PacMan. The method returns true when a ghost is within 1 block of PacMan and returns false otherwise.

Test:
To test this method, a `NoFrame` is created with a PacMan at (1, 0) and a ghost at (3, 0) `pacMan.is_ghost_in_range()` and is asserted to be `false`. Another ghost is added at (2, 0) and `pacMan.is_ghost_in_range()` is asserted to be true.

### consume

Uses [`Map.getLoc()`](#getloc) to see if the current location contains a *power-cookie*. If it does, it calls [`Map.eatCookie()`](#eatcookie) and returns the `CookieComponent` that was eaten. Otherwise, it returns `null`.

Test:
To test this method, a `NoFrame` is created with a PacMan at a location that does not contain a cookie. `pacMan.consume()` is called and asserted to be `null`. Then a PacMan is added at a location with a cookie and `pacMan.consume()` is called again and asserted to not be `null`.

## Ghost

### get_valid_moves

Returns the valid moves for the Ghost object at any current position on the board.  It checks each direction and if the direction is not a wall, it adds this direction to an Array List.

Test:
Created a new map and positioned a Ghost at the coordinates (1,1).  The right and down directions are valid moves, so these two are checked for in the array that is returned from ghost.get_valid_moves().  The valid moves are: (2,1) and (1,2).

### move

Takes a random Location that's being passed in using Ghost.get_valid_moves() and since that's returned in get_valid_moves() are all valid, this function only returns true.

Test:
Created a new map and positioned a new Ghost instance at position (1,0). I then created a for loop that contained an assertTrue() to make sure that Ghost.move() returns True for the a consecutive amount of times, in which the group decided would be four times.

### is_pacman_in_range

Checks if PacMan is in attack range of a ghost. A ghost can attack PacMan if it is within 1 block of PacMan. Uses [`Map.getLoc()`](#getloc) to see check the 1 block radius surrounding the ghost. The method returns true when a ghost is within 1 block of PacMan and returns false otherwise.

Test:
To test this method, a `NoFrame` is created with a PacMan at (1, 0) and a ghost at (3, 0) `pacMan.is_ghost_in_range()` and is asserted to be `false`. Another ghost is added at (2, 0) and `pacMan.is_ghost_in_range()` is asserted to be true.

### attack

Checks if pacman is in range with [`Ghost.is_pacman_in_range`](#is_pacman_in_range) then returns the result of [`Map.attack(myName)`](#attack-1). Otherwise returns false.

Test:
To test this method, a `NoFrame` is created with a Ghost at a location that is not near a PacMan. `ghost.attack()` is called and asserted to be `false`. Then a PacMan is added one space away from the ghost and `ghost.attack()` is called again and asserted to be `true`.

## Map

### move

Updates the locations HashMap by using locations.replace(name, loc). I store the returned location as prev_loc for a null check later on. I then get the JComponent for the object being passed into Map.move() which is either PacMan or a Ghost, and store it into comp. If either prev_loc or comp is null then Map.move() returns False. Otherwise, it sets the location using setLocation() and adds comp back into the components HashMap.

Test:
Created a new map and positioned a new Ghost and PacMan instance. I then used AssertTrue to ensure that Map.move() would return true for both the PacMan and Ghost that I created.

### getLoc

Returns what is currently at the location.  Map.Type.WALL, Map.Type.PACMAN, Map.Type.GHOST, Map.Type.COOKIE, Map.Type.EMPTY

Test:
To test each possible location type, I created a map and loaded each object into it in specific coordinates.  

### attack

Controls the game state. When called, it changes the `gameOver` variable to `true`, signifying that the game has ended. The method is called from [`Ghost.attack()`](#attack)

Test:
Created a `NoFrame` with PacMan located at (5, 5) and a ghost located at (4, 5). Got the game state using `Map.isGameOver()` and asserted `gameOver` to be `false`. Then, called ['Ghost.attack()`](#attack), got the game state using`Map.isGameOver()` and asserted `gameOver` to be `true`

### eatCookie

First attempts to remove the location by the given name in the format `tok_x<num>_y<num>`. If this is successful, the `CookieComponent` is removed from the list of componenets. Then, the cookie is removed from the field and the cookie score is incremented. The `CookieComponent` that was consumed is returned.

Test:
To test this method, a `NoFrame` is created without PacMan and ghosts. The map created by the `NoFrame` is extracted and used for the tests. First, `eatCookie` is called on an invalid location and asserted that eatCookie returns null and also does not increment the cookies. This ensures that the method returns at the if statement. Then `eatCookie` is called with a valid cookie location and asserted to return a `CookieComponent`. Also, the location is verified to no longer contain a cookie and that the cookie score has been incremented properly.
