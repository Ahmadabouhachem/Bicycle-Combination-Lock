# faktorzehn
A bicycle combination lock consists of rings with the digits 0 to 9. 
The rings can be rotated upwards and downwards. When locking, the lock should be set to a combination with the same digits. 
To achieve this, a tool should be written that, given any starting combination, finds the settings with the same digits that can be reached with the minimum number of rotations on the lock. 
It should determine both the number of rotations and the digits of the combinations.
Examples:
Starting Combination | Combinations | Number of Rotations
1-1-1-1 | 1-1-1-1 | Achieved with 0 rotations
1-1-9-9 | 0-0-0-0 |
        | 1-1-1-1 | Both achieved with 4 rotations
        | 9-9-9-9 |
Additional Requirements:
The API of the tool can be freely chosen, but it should be possible to pass the digits of a starting combination (e.g. as a string, int, collection, array...) and programmatically retrieve the minimum number of rotations as well as the digits of the combinations. 
This API should be used in unit tests. A graphical user interface is not necessary.
