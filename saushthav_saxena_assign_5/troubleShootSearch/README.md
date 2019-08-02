# CSX42: Assignment 4
## Name: Saushthav Saxena

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in multiThreadedMS/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: 
ant -buildfile multiThreadedMS/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile multiThreadedMS/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: 
ant -buildfile multiThreadedMS/src/build.xml run -Dargs="N input1.txt .. inputN.txt debug_value"

Example:
Accepts a variable number of arguments. Based on the value of N, the program accepts the number of arguments. For example,
If N = 2, to run the program we will do ant run -Dargs="2 input1.txt input2.txt output.txt 0/1/2/3/4"
If N =3, to run the program we will do ant run -Dargs="3 input1.txt input2.txt input3.txt output.txt 0/1/2/3/4"


-----------------------------------------------------------------------
## Description:

I have used arraylists as my primary data structure for threads as well as the main data structure in
results which multiple threads update. I used arraylists because of their dynamic size and O(1) insertion, read time and update time. We can apply mergesort on arraylist as well as arrays which results in NlogN sort time. Also, to update and sort thread individual data structure I am using merge method in mergesort which in worst cast will take linear time to sort with O(N) space complexity.
Using arraylists is better with respect to linkedlist per say is better as it would be much faster to update and keep data sorted as per assignments requirment.

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.""

Date: -- 07/22/2019