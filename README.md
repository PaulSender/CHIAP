# P2P-Chat-Client

## Getting started
  - For host 1 Download the server.jar, tic-tac-toe.jar, and CHAIP.jar executables. 
             2 Recommended to keep this files on your desktop for easy access.
             3 For purposes of this lab and without access to a private router, the IP address is hard coded. To change it to whatever                yours is please go to the tictactoeclient class and find the line 
             String serverAddress = (args.length == 0) ? "10.200.91.98" : args[1];  Change "10.200.91.98" to whatever IP address you                   obtain from the IPCONFIG command. 
             4 Recompile the tictactoeclient class to an executable jar file. 
             5 Open CHIAP and set the path of tic-tac-toe.jar to where ever you saved it. (REC: to save to desktop for easy copy paste).
              -If you don't have coding knowledge send an email to senderp@wit.edu and a server will be opened for you to try this Java                 app. All you have to do is follow steps 1, 2, and 5. 
- For clients 1 download CHAIP.jar and Tic-tac-toe.jar executables. 
              2 Sign in to the server using the IP address your server operator obtains
              3 Follow the instructions in the CHIAP.jar windows for all other instruction.
## Features 
  1. Multi-Client chatting across all panes of application 
  2. Blackjack mini game that can be played to learn balance
  3. Tic-Tac-Toe mini game that can be played against someone else using a different machine. 
  4. A shop where you can spend your balance on cosmetics
  
## Description
Version 1: A simple peer to peer chat client run on a user’s command prompt. 


Version 2: 
  - What: A chat client with multiple clients and one server. All parties can communicate, and the server has special functionality. The program is useable through a GUI built with Java and netbeans.
  - Why: Version 1 of the chat client was too boring and simple. Our efforts hope to bring the client into a working application that anyone can access anywhere (Web or Android) so long as the server is running. 
  - How: Multiple messages through one client and multiple clients will be done through a technique called multithreading. Server functionality will be done though specially defined methods within the call that get run whenever one of the clients inputs a special keyword. GUI will be designed and implemented in NetBeans and eclipse. 
  
 ## Deliverables
  1. Create chat room that allows multiple clients to communicate to each other and to the server through server-client architecture. 
  2. Two mini games (Blackjack and Tic-tac-toe) that can be played in the client GUI. Winning Blackjack will award the client with a balance
  3. Integrate functionality into Java GUI
  
  ## Plan
   - Week 1 (October 28 - November 4th): update code so it allows multiple messages to go through
   - Week 2 – Week 3 (November 4th - November 18th): Create the “communication triangle” to allow two unique clients to connect to 	   	one server and communicate with each other
   - Week 4 (November 18th - 25th): Add code to a Java GUI.
   - Week 5 (November 25th - December 7th): Add as much optional features as possible until the deadline is met

## Team Members
- Paul Sender (Team Lead, Full-Stack Development)
- Randy Ryan (Front-end GUI design and functionality)
- Kyle McDevitt (Back-end development)
## Walk Through GIF
Video Coming soon

