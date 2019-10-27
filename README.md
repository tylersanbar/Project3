# Project3
The biggest hurdle in this project was figuring out how to read the instructions.
Most of the coding was simple. I used treemap to sort the hashmaps, which could be reversed by setting the treemap to a descinding key
I printed the maps using an enhanced for loop, which was very useful.

I started using calendar as I found an easy SimpleDateFormat formatter with it, but after moving on when we needed LocalDateTime I found 
that was preferable.
To find the difference in two LocalDates I used the Period object which had the method between() to calculate the time between 2 dates.
LocalDate also had an isLeapYear() method that was helpful.

For the ascii average I added .75 to the average, and then got the floor. If it was under .25, it would be under the next whole number,
and if it was above or equal to .25 it would be floored to the next whole number.

For reading the files, it was tricky that they included tabs but once I figured that out I removed all " " and "  " from the read strings
then took the appropriate substring to parse.

The sorting algorithms was fun, I tried an arraylist insertion sort but that didn't get a grade so I decided to use the values of the hashmap to store
a position value. Then it would do a check on each key and value pair to see if they needed to be greater than or less than, swap the values
if they weren't matching the order of the keys, and then move on to the next key.
If it went through a full check with no operations it was done and exited the while loop.
The methods would then print based on the position values, 1 thru size of map or the reverse, unfortunatly having to loop through the
hashmap each time to find the key that matches the value.
The execution times were not different one way or the other due to my sorting method being called in the constructor, the only difference
would be in the printing time and since hashmap gives the order randomly it will change every time.
