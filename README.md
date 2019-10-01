# java-socket-TicTacToegame
使用java+socket实现双人九宫棋，内附jp和en版启动方法说明。

Use java+socket to achieve double nine house chess, with jp and en version of the start-up method description.
About the startup method.

Because the class file already exists, you can execute the program directly (not packaged in the jar file). 
First execute the TicTacToeServer.java, as shown below. 
Enter the command line 1: java TicTacToeServer
  
The server shows that you are waiting for port and player1.  

Next, execute TicTacToeClient.java. Username is up to you. 
Enter the command line 2 : java TicTacToeClient username1
On the server, display the username and player2 for player1. The customer pops up the first game window. 
 


Then run the client again. 
Enter the command line 3 :java TicTacToeClient username2
The last successful startup results in three command lines, two windows.  

Next the game starts normally, each player only has the next chess piece, please be careful not to put the chess piece in the place where there are already chess pieces. The results of the final victories and losers are as follows.  

As shown in the figure, the "x" flag is assigned to the user who first connects to the server, and the next connected user is assigned the "0" flag. Either "0" or "x" can be turned first.
