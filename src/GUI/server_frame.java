package GUI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Dimension;
import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Font;

public class server_frame extends javax.swing.JFrame 
{
   ArrayList clientOutputStreams;
   ArrayList<String> users;

   public class ClientHandler implements Runnable	
   {
       BufferedReader reader;
       Socket sock;
       PrintWriter client;

       public ClientHandler(Socket clientSocket, PrintWriter user) 
       {
            client = user;
            try 
            {
                sock = clientSocket;
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);
            }
            catch (Exception ex) 
            {
                ta_chat.append("Unexpected error... \n");
            }

       }

       @Override
       public void run() 
       {
            String message, connect = "Connect", disconnect = "Disconnect", chat = "Chat" ;
            String[] data;

            try 
            {
                while ((message = reader.readLine()) != null) 
                {
                    ta_chat.append("Received: " + message + "\n");
                    data = message.split(":");
                    
                    for (String token:data) 
                    {
                        ta_chat.append(token + "\n");
                    }

                    if (data[2].equals(connect)) 
                    {
                        tellEveryone((data[0] + ":" + data[1] + ":" + chat));
                        userAdd(data[0]);
                    } 
                    else if (data[2].equals(disconnect)) 
                    {
                        tellEveryone((data[0] + ":has disconnected." + ":" + chat));
                        userRemove(data[0]);
                    } 
                    else if (data[2].equals(chat)) 
                    {
                        tellEveryone(message);
                    } 
                    else 
                    {
                        ta_chat.append("No Conditions were met. \n");
                    }
                } 
             } 
             catch (Exception ex) 
             {
                ta_chat.append("Lost a connection. \n");
                ex.printStackTrace();
                clientOutputStreams.remove(client);
             } 
	} 
    }

    public server_frame() 
    {
    	getContentPane().setBackground(new Color(128, 128, 128));
    	setMinimumSize(new Dimension(500, 500));
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setBounds(12, 13, 470, 344);
        ta_chat = new javax.swing.JTextArea();
        ta_chat.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
        ta_chat.setForeground(new Color(0, 204, 0));
        ta_chat.setBackground(Color.DARK_GRAY);
        b_start = new javax.swing.JButton();
        b_start.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
        b_start.setBackground(SystemColor.control);
        b_start.setBounds(12, 375, 75, 25);
        b_end = new javax.swing.JButton();
        b_end.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
        b_end.setBackground(SystemColor.control);
        b_end.setBounds(12, 418, 75, 25);
        b_users = new javax.swing.JButton();
        b_users.setBackground(SystemColor.control);
        b_users.setFont(new Font("OCR A Extended", Font.PLAIN, 9));
        b_users.setBounds(379, 375, 103, 25);
        b_clear = new javax.swing.JButton();
        b_clear.setBackground(SystemColor.control);
        b_clear.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
        b_clear.setBounds(379, 418, 103, 25);
      

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat - Server's frame");
        setName("server"); // NOI18N
        setResizable(false);

        ta_chat.setColumns(20);
        ta_chat.setRows(5);
        jScrollPane1.setViewportView(ta_chat);

        b_start.setText("START");
        b_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_startActionPerformed(evt);
            }
        });

        b_end.setText("END");
        b_end.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_endActionPerformed(evt);
            }
        });

        b_users.setText("Online Users");
        b_users.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_usersActionPerformed(evt);
            }
        });

        b_clear.setText("Clear");
        b_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_clearActionPerformed(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(jScrollPane1);
        getContentPane().add(b_end);
        getContentPane().add(b_start);
        getContentPane().add(b_clear);
        getContentPane().add(b_users);

       
    }// </editor-fold>                        

    private void b_endActionPerformed(java.awt.event.ActionEvent evt) {                                      
        try 
        {
        	ta_chat.append("Server Shutting down");
            Thread.sleep(1000);     
            
        } 
        catch(InterruptedException ex) {Thread.currentThread().interrupt();}
        
        tellEveryone("Server:Server is stopping and all users will now be disconnected.\n:Chat");
       
    }                                     

    private void b_startActionPerformed(java.awt.event.ActionEvent evt) {                                        
        Thread chat = new Thread(new ServerStart());
        Thread ticTac = new Thread(new ServerStart());
        chat.start();
        ticTac.start();
        
        ta_chat.append("Servers running...\n");
        
    }                                       

    private void b_usersActionPerformed(java.awt.event.ActionEvent evt) {                                        
        ta_chat.append("\n Online users : \n");
        for (String current_user : users)
        {
            ta_chat.append(current_user);
            ta_chat.append("\n");
        }    
        
    }                                       

    private void b_clearActionPerformed(java.awt.event.ActionEvent evt) {                                        
        ta_chat.setText("");
    }          
    private void b_startTicTacServer(java.awt.event.ActionEvent evt) {
    	Thread starter = new Thread(new ServerStart());
    	starter.start();
    	ta_chat.append("Tic Tac Toe Started... \n");
    	
    }

    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() {
                new server_frame().setVisible(true);
                
            }
        });
    }
    
    public class ServerStart implements Runnable 
    {
        @Override
        public void run() 
        {
            clientOutputStreams = new ArrayList();
            users = new ArrayList();  
// Chat Room
            try 
            {
                ServerSocket serverSock = new ServerSocket(2222);
                while (true) 
                {
				Socket clientSock = serverSock.accept();
				PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
				clientOutputStreams.add(writer);

				Thread listener = new Thread(new ClientHandler(clientSock, writer));
				listener.start();
				ta_chat.append("Got a connection. \n");
                }
                //while 
            }
            catch (Exception ex) {
                //ta_chat.append("Error making a connection. \n");
            }
// Tic Tac Toe
            try {
            	ServerSocket serverSock = new ServerSocket(2221);
            	while (true) {
                    Game game = new Game();
                    Game.Player playerX = game.new Player(serverSock.accept(), 'X');
                    Game.Player playerO = game.new Player(serverSock.accept(), 'O');
                    playerX.setOpponent(playerO);
                    playerO.setOpponent(playerX);
                    game.currentPlayer = playerX;
                    playerX.start();
                    playerO.start();
                }
          
            	}
            catch (Exception ex) {
            	//ta_chat.append("Error");
            }
        }
    }
    
    public void userAdd (String data) 
    {
        String message, add = ": :Connect", done = "Server: :Done", name = data;
        ta_chat.append("Before " + name + " added. \n");
        users.add(name);
        ta_chat.append("After " + name + " added. \n");
        String[] tempList = new String[(users.size())];
        users.toArray(tempList);

        for (String token:tempList) 
        {
            message = (token + add);
            tellEveryone(message);
        }
        tellEveryone(done);
    }
    
    public void userRemove (String data) 
    {
        String message, add = ": :Connect", done = "Server: :Done", name = data;
        users.remove(name);
        String[] tempList = new String[(users.size())];
        users.toArray(tempList);

        for (String token:tempList) 
        {
            message = (token + add);
            tellEveryone(message);
        }
        tellEveryone(done);
    }
    
    public void tellEveryone(String message) 
    {
	Iterator it = clientOutputStreams.iterator();

        while (it.hasNext()) 
        {
            try 
            {
                PrintWriter writer = (PrintWriter) it.next();
		writer.println(message);
		ta_chat.append("Sending: " + message + "\n");
                writer.flush();
                ta_chat.setCaretPosition(ta_chat.getDocument().getLength());

            } 
            catch (Exception ex) 
            {
		ta_chat.append("Error telling everyone. \n");
            }
        } 
    }
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton b_clear;
    private javax.swing.JButton b_end;
    private javax.swing.JButton b_start;
    private javax.swing.JButton b_users;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea ta_chat;
}
