Student name: Samuele Joshi
Student number:

LEVEL YOU WISH THE MINI-PROJECT TO BE MARKED FOR: 1 / 2

Now complete the statements below for each level you wish to be marked. Replace all text in square brackets.

LEVEL ONE

My code demonstrates inheritance in the following way...

I have a superclass called [Character]

This superclass is extended into at least three subclasses called [Player, Enemy, Boss, Lifeline, Hunter]

For each of the named subclasses complete the following...

Subclass 1.

Subclass [Player] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [potion, inventory, storeXP]

These/this new properties/property are used by the subclass in the following way: 

Potion - Increases the health of the player by equipping a potion. (5,50,51,52,57,58)

Inventory - Allows them to store items they find in there adventure which they can then use. (7, 13)

storeXP - stores the XP points the player gains which will increase the attack damage made as reward. (9,21,37,61,62,65,66)


Subclass [Player] extends the superclass by overriding the following methods (there must be at least one): 
attack - (18)
statistics - (32)
selfIncreaseHP - (46)
increaseAD - (47)
[Insert names of overridden methods and their line numbers in the code.]

These overridden methods are used in the working code in the following places: 
Player class:
attack - (18)
statistics - (32)

TestGame class:
attack - (80, 287)
statistics - (71, 96, 278, 303)
[list the file names and line numbers where the overridden methods are called.]

Subclass 2.
Subclass [Boss] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [weapon]

These/this new properties/property are used by the subclass in the following way: 
Weapon - Allows the boss to increase there attack damage by equipping a weapon. Reason I used this was to make the boss diffrenet to the enemies making it powerful. (4, 10, 11, 14, 15, 18-26, 30-35, 45-47, 56-58, 60- 62)
[Insert justification for adding the property and give the line numbers in the code of where the property is used.]

Subclass [Boss] extends the superclass by overriding the following methods (there must be at least one): 

attack - (28 - 38)
statistics - (40 - 54)
[Insert names of overridden methods and their line numbers in the code.]

These overridden methods are used in the working code in the following places: 
Boss class:
attack - (28 - 38)
statistics - (40 - 54)

TestGame class:
attack - (301)
statistics - (289)

[list the file names and line numbers where the overridden methods are called.]

Subclass 3.

Subclass [Enemy] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [level, xp]

These/this new properties/property are used by the subclass in the following way: 
level - determines the level of the character which will affect the amount of xp is given is enemy is taken down by the player.
(11,16,21-35,58,64-66,68-70)

xp - is the amount of xp they store. If player reaches a certain amount of xp in the game, then the player can do more damage as a reward.
(12,22,27,32)

[Insert justification for adding the property and give the line numbers in the code of where the property is used.]

Subclass [Enemy] extends the superclass by overriding the following methods (there must be at least one): [Insert names of overridden methods and their line numbers in the code.]
attack (46 - 51)
statistics (53 - 60)

These overridden methods are used in the working code in the following places: 
Enemy class:
attack (46 - 51)
statistics (53 - 60)

TestGame class:
attack (94)
statistics (70,82)

[list the file names and line numbers where the overridden methods are called.]

Subclass 4.

Subclass [Hunter] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [selfIncreaseAttack]

These/this new properties/property are used by the subclass in the following way: [Insert justification for adding the property and give the line numbers in the code of where the property is used.]

selfIncreaseAttack - Allows only the charcater Hunter to increase there damage only once in battle. This is used to give the player this special ability. (4,8,29,33)

Subclass [Hunter] extends the superclass by overriding the following methods (there must be at least one): [Insert names of overridden methods and their line numbers in the code.]
increaseAD - (12 - 25)

These overridden methods are used in the working code in the following places: [list the file names and line numbers where the overridden methods are called.]
Hunter class:
increaseAD - (12 - 25)

TestGame class:
increaseAD - (109)

Subclass 5.

Subclass [Lifeline] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [selfHPIncrease]

These/this new properties/property are used by the subclass in the following way: [Insert justification for adding the property and give the line numbers in the code of where the property is used.]

selfHPIncrease - Allows only the charcater Lifeline to increase there health three times in battle. This is used to give the player this special ability. (4,8,13,42,46)

Subclass [Lifeline] extends the superclass by overriding the following methods (there must be at least one): [Insert names of overridden methods and their line numbers in the code.]
selfIncreaseHP - (17 - 39)

These overridden methods are used in the working code in the following places: [list the file names and line numbers where the overridden methods are called.]
Lifeline class:
selfIncreaseHP - (17 - 39)

TestGame class:
selfIncreaseHP - (106)

[If you have more than three subclasses you want to tell us about, copy and paste the above text for as many subclasses as you want.]

LEVEL TWO

[In no more than three sentences and in your own words, define polymorphism.]
Polymorphism allows an object to take many forms hence the name “poly” which means many and morphism “shapes”. Therefore, it is viewed as the way object references are processed based on the class and data type used. In other words, it is the ability to change method code of the derived class. We use polymorphism when a super class is used to refer to a subclass of that object. We can only consider an object polymorphic if it is part of a “IS-A” relationship. We use this OOP concept to reduce our program complexity. We have two types i.e. dynamic binding and substitution principle.
Dynamic binding – Object type is determined at run time. An example of dynamic binding would be method overriding. 
Substitution principle – The type of object is determined at compile time. If the class contains private, final or static method. 
 

[List the places in your code where polymorphism is implemented, listing file names and line numbers.]
TestGame class:
Declared Line number: 18, 60, 268

Methods (as overrding is an example of dynamic binding):
Lines:
Boss class:
attack - (28 - 38)
statistics - (40 - 54)

TestGame class:
attack - (301)
statistics - (289)

Hunter class:
increaseAD - (12 - 25)

TestGame class:
increaseAD - (109)

Lifeline class:
selfIncreaseHP - (17 - 39)

TestGame class:
selfIncreaseHP - (106)

Player class:
attack - (18)
statistics - (32)

TestGame class:
attack - (80, 287)
statistics - (71, 96, 278, 303)

[Explain briefly (no more than four sentences), why polymorphism is necessary in your code.]
Polymorphism is nessercy in my code as rather than making a generic method for example my "attack" method, I can make it more personalised and specific for the type of class that has it. A player attack wouldn't need to have weapon damage seeing that Player class does not have an instance weapon compared to my Boss class which does have a weapon. It also allows me to reduce code as I do not need to check the instance of the object making my code faster and efficient. 

ANYTHING ELSE
