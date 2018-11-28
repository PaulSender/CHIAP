/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import javax.accessibility.AccessibleContext;

/**
 *
 * @author ryanr4
 */
public class ChatGUI extends javax.swing.JFrame {
    private static String IP = new String();
    private static String userName = new String();
    public static Deck deck = new Deck();
    public static Player player = new Player("Player");
    public static Player dealer = new Player("Dealer");
    public static int count = 0;
    public static double balance = 0;

    /**
     * Creates new form ChatGUI
     */
    public ChatGUI() {
        initComponents();
        ConnectScreen.setVisible(true);
        Shop.setVisible(false);
        BlackJack.setVisible(false);
        Files.setVisible(false);
        MainMenu.setVisible(false);
        TicTacToe.setVisible(false);
        mainMenu.setVisible(false);
    }
    public static int port = 2222;
	public static boolean isConnected = false;
	public static Socket sock = new Socket();
	public static BufferedReader reader;
	public static PrintWriter writer;
        ArrayList<String> users = new ArrayList();
        public boolean connectToServer(String address, String username){
            if(isConnected == false){
                try{
                    sock = new Socket(address, port);
                    InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
                    reader = new BufferedReader(streamreader);
                    writer = new PrintWriter(sock.getOutputStream());
                    writer.println(username + ":has connected.:Connect");
                    writer.flush();
                    isConnected = true;
                }
                catch(IOException e){
                      return false; 
                }
          
            }
            return true;
	}
        public String disconnectFromServer(String username){
            	String bye = (username + ": :Disconnect");
		try {
                        writer.println(bye);
			writer.flush();
                        sock.close();
                        return "";
		} catch (IOException e) {
			return ("Could not disconnect.\n");
		}
		
        }
        public void ListenThread() {
		Thread IncomingReader = new Thread(new IncomingReader());
		IncomingReader.start();
	}
        public void userAdd(String data) {
		users.add(data);
	}

	public void userRemove(String data) {
		mainMenuConsole.append(data + " is now offline.\n");
                shopConsole.append(data + "is now offline. \n");
                BlackJackConsole.append(data + "is now offline. \n");
                TTTConsole.append(data + "is now offline. \n");
                FileConsole.append(data + "is now offline. \n");
	}
        public void writeUsers() {
		String[] tempList = new String[(users.size())];
		users.toArray(tempList);
		for (String token : tempList) {
			// users.append(token + "\n");
		}
	}
        public class IncomingReader implements Runnable {
		@Override
		public void run() {
			String[] data;
			String stream, done = "Done", connect = "Connect", disconnect = "Disconnect", chat = "Chat";

			try {
				while ((stream = reader.readLine()) != null) {
					data = stream.split(":");

					if (data[2].equals(chat)) {
						mainMenuConsole.append(data[0] + ": " + data[1] + "\n");
                                                shopConsole.append(data[0] + ": " + data[1] + "\n");
                                                BlackJackConsole.append(data[0] + ": " + data[1] + "\n");
                                                TTTConsole.append(data[0] + ": " + data[1] + "\n");
                                                FileConsole.append(data[0] + ": " + data[1] + "\n");
						mainMenuConsole.setCaretPosition(mainMenuConsole.getDocument().getLength());
                                                shopConsole.setCaretPosition(shopConsole.getDocument().getLength());
                                                BlackJackConsole.setCaretPosition(BlackJackConsole.getDocument().getLength());
                                                TTTConsole.setCaretPosition(TTTConsole.getDocument().getLength());
                                                FileConsole.setCaretPosition(FileConsole.getDocument().getLength());
					} else if (data[2].equals(connect)) {
						mainMenuConsole.removeAll();
                                                shopConsole.removeAll();
                                                BlackJackConsole.removeAll();
                                                TTTConsole.removeAll();
                                                FileConsole.removeAll();
						userAdd(data[0]);
					} else if (data[2].equals(disconnect)) {
						userRemove(data[0]);
					} else if (data[2].equals(done)) {
						// users.setText("");
						writeUsers();
						users.clear();
					}
				}
			} catch (Exception ex) {
			}
		}
	}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ConnectScreen = new javax.swing.JPanel();
        serverIP = new javax.swing.JTextField();
        console = new javax.swing.JScrollPane();
        connectScreenConsole = new javax.swing.JTextArea();
        connectButton = new javax.swing.JButton();
        ClientUsername = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        ipaddressLabel = new javax.swing.JLabel();
        mainMenu = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        Shop = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        fiftyButton = new javax.swing.JButton();
        hundredButton = new javax.swing.JButton();
        hundredfiftyButton = new javax.swing.JButton();
        twohundredButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        mainMenu1 = new javax.swing.JButton();
        Exit1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        shopConsole = new javax.swing.JTextArea();
        shopSendButton = new javax.swing.JButton();
        messageOut1 = new javax.swing.JTextField();
        BlackJack = new javax.swing.JPanel();
        BlackJackLabel = new javax.swing.JLabel();
        stayButton = new javax.swing.JButton();
        Exit2 = new javax.swing.JButton();
        mainMenu2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        BlackJackConsole = new javax.swing.JTextArea();
        messageOut2 = new javax.swing.JTextField();
        blackJackSendButton = new javax.swing.JButton();
        HitButton = new javax.swing.JButton();
        newBlackJackGame = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        card2 = new javax.swing.JLabel();
        dealerCard = new javax.swing.JLabel();
        card4 = new javax.swing.JLabel();
        card3 = new javax.swing.JLabel();
        card1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        DealerHandValue = new javax.swing.JLabel();
        playerHandValue1 = new javax.swing.JLabel();
        Files = new javax.swing.JPanel();
        attachmentButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        FileConsole = new javax.swing.JTextArea();
        Exit3 = new javax.swing.JButton();
        mainMenu3 = new javax.swing.JButton();
        messageOut4 = new javax.swing.JTextField();
        FileSendButton = new javax.swing.JButton();
        MainMenu = new javax.swing.JPanel();
        ShopButton = new javax.swing.JButton();
        BlackJackButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        FilesButton = new javax.swing.JButton();
        DisconnectButton = new javax.swing.JButton();
        Exit4 = new javax.swing.JButton();
        mainMenu4 = new javax.swing.JButton();
        menuConsole = new javax.swing.JScrollPane();
        mainMenuConsole = new javax.swing.JTextArea();
        messageOut = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        TicTacToeButton = new javax.swing.JButton();
        TicTacToe = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TTTConsole = new javax.swing.JTextArea();
        messageOut3 = new javax.swing.JTextField();
        TTTButton = new javax.swing.JButton();
        mainMenu5 = new javax.swing.JButton();
        Exit5 = new javax.swing.JButton();
        TTTstartGameButton = new javax.swing.JButton();
        topMiddle = new javax.swing.JButton();
        topRight = new javax.swing.JButton();
        topLeft = new javax.swing.JButton();
        middleLeft = new javax.swing.JButton();
        middleCenter = new javax.swing.JButton();
        middleRight = new javax.swing.JButton();
        bottomMiddle = new javax.swing.JButton();
        bottomRight = new javax.swing.JButton();
        bottomLeft = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        serverIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverIPActionPerformed(evt);
            }
        });

        connectScreenConsole.setColumns(20);
        connectScreenConsole.setRows(5);
        connectScreenConsole.setText("Please enter the IP address of the server you are trying to connect to.\nThen enter your username and press connect.\n");
        console.setViewportView(connectScreenConsole);

        connectButton.setText("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        usernameLabel.setText("Username");

        ipaddressLabel.setText("IP address of server");

        mainMenu.setBackground(new java.awt.Color(0, 0, 0));
        mainMenu.setForeground(new java.awt.Color(0, 255, 0));
        mainMenu.setText("Main Menu");
        mainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuActionPerformed(evt);
            }
        });

        Exit.setBackground(new java.awt.Color(0, 0, 0));
        Exit.setForeground(new java.awt.Color(255, 0, 51));
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ConnectScreenLayout = new javax.swing.GroupLayout(ConnectScreen);
        ConnectScreen.setLayout(ConnectScreenLayout);
        ConnectScreenLayout.setHorizontalGroup(
            ConnectScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConnectScreenLayout.createSequentialGroup()
                .addComponent(mainMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Exit))
            .addGroup(ConnectScreenLayout.createSequentialGroup()
                .addGroup(ConnectScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConnectScreenLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(usernameLabel)
                        .addGap(366, 366, 366)
                        .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ConnectScreenLayout.createSequentialGroup()
                        .addGroup(ConnectScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ConnectScreenLayout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addGroup(ConnectScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ClientUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(serverIP, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(ConnectScreenLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(console, javax.swing.GroupLayout.PREFERRED_SIZE, 1125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ConnectScreenLayout.createSequentialGroup()
                                .addGap(510, 510, 510)
                                .addComponent(ipaddressLabel)))
                        .addGap(0, 31, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ConnectScreenLayout.setVerticalGroup(
            ConnectScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConnectScreenLayout.createSequentialGroup()
                .addGroup(ConnectScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mainMenu)
                    .addComponent(Exit))
                .addGap(27, 27, 27)
                .addComponent(console, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(ipaddressLabel)
                .addGap(18, 18, 18)
                .addComponent(serverIP, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ConnectScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(ClientUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        getContentPane().add(ConnectScreen);

        jLabel4.setText("Shop");

        fiftyButton.setText("50$");
        fiftyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiftyButtonActionPerformed(evt);
            }
        });

        hundredButton.setText("100$");
        hundredButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hundredButtonActionPerformed(evt);
            }
        });

        hundredfiftyButton.setText("150$");
        hundredfiftyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hundredfiftyButtonActionPerformed(evt);
            }
        });

        twohundredButton.setText("200$");
        twohundredButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twohundredButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Green Background");

        jLabel8.setText("Blue Background");

        jLabel9.setText("Red Background");

        jLabel10.setText("Orange Background");

        mainMenu1.setBackground(new java.awt.Color(0, 0, 0));
        mainMenu1.setForeground(new java.awt.Color(0, 255, 0));
        mainMenu1.setText("Main Menu");
        mainMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenu1ActionPerformed(evt);
            }
        });

        Exit1.setBackground(new java.awt.Color(0, 0, 0));
        Exit1.setForeground(new java.awt.Color(255, 0, 51));
        Exit1.setText("Exit");
        Exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit1ActionPerformed(evt);
            }
        });

        shopConsole.setColumns(20);
        shopConsole.setRows(5);
        jScrollPane1.setViewportView(shopConsole);

        shopSendButton.setText("Send");
        shopSendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shopSendButtonActionPerformed(evt);
            }
        });

        messageOut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageOut1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ShopLayout = new javax.swing.GroupLayout(Shop);
        Shop.setLayout(ShopLayout);
        ShopLayout.setHorizontalGroup(
            ShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ShopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(137, 137, 137)
                .addGroup(ShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ShopLayout.createSequentialGroup()
                        .addGroup(ShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ShopLayout.createSequentialGroup()
                                .addGroup(ShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fiftyButton)
                                    .addComponent(hundredButton))
                                .addGap(0, 9, Short.MAX_VALUE))
                            .addGroup(ShopLayout.createSequentialGroup()
                                .addComponent(hundredfiftyButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(ShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ShopLayout.createSequentialGroup()
                                .addComponent(messageOut1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(shopSendButton)
                                .addGap(33, 33, 33))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ShopLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(ShopLayout.createSequentialGroup()
                        .addComponent(twohundredButton)
                        .addContainerGap())))
            .addGroup(ShopLayout.createSequentialGroup()
                .addComponent(mainMenu1)
                .addGap(190, 190, 190)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Exit1))
        );
        ShopLayout.setVerticalGroup(
            ShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ShopLayout.createSequentialGroup()
                .addGroup(ShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ShopLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mainMenu1))
                .addGap(31, 31, 31)
                .addGroup(ShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiftyButton))
                .addGap(42, 42, 42)
                .addGroup(ShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hundredButton))
                .addGap(85, 85, 85)
                .addGroup(ShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hundredfiftyButton))
                .addGap(41, 41, 41)
                .addGroup(ShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twohundredButton))
                .addGap(167, 167, 167))
            .addGroup(ShopLayout.createSequentialGroup()
                .addComponent(Exit1)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageOut1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shopSendButton))
                .addGap(105, 105, 105))
        );

        getContentPane().add(Shop);

        BlackJackLabel.setText("BlackJack");

        stayButton.setText("Stay");
        stayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stayButtonActionPerformed(evt);
            }
        });

        Exit2.setBackground(new java.awt.Color(0, 0, 0));
        Exit2.setForeground(new java.awt.Color(255, 0, 51));
        Exit2.setText("Exit");
        Exit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit2ActionPerformed(evt);
            }
        });

        mainMenu2.setBackground(new java.awt.Color(0, 0, 0));
        mainMenu2.setForeground(new java.awt.Color(0, 255, 0));
        mainMenu2.setText("Main Menu");
        mainMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenu2ActionPerformed(evt);
            }
        });

        BlackJackConsole.setColumns(20);
        BlackJackConsole.setRows(5);
        jScrollPane4.setViewportView(BlackJackConsole);

        blackJackSendButton.setText("Send");
        blackJackSendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blackJackSendButtonActionPerformed(evt);
            }
        });

        HitButton.setText("Hit");
        HitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HitButtonActionPerformed(evt);
            }
        });

        newBlackJackGame.setText("New Game");
        newBlackJackGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBlackJackGameActionPerformed(evt);
            }
        });

        jLabel2.setText("Player Hand:");

        card2.setText("card2");

        dealerCard.setText("dealerCard1");

        card4.setText("card4");

        card3.setText("card3");

        card1.setText("card1");

        jLabel15.setText("Dealer Hand:");

        DealerHandValue.setText("Dealer hand value:");

        playerHandValue1.setText("Player hand value:");

        javax.swing.GroupLayout BlackJackLayout = new javax.swing.GroupLayout(BlackJack);
        BlackJack.setLayout(BlackJackLayout);
        BlackJackLayout.setHorizontalGroup(
            BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BlackJackLayout.createSequentialGroup()
                .addComponent(mainMenu2)
                .addGap(366, 366, 366)
                .addComponent(BlackJackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Exit2))
            .addGroup(BlackJackLayout.createSequentialGroup()
                .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BlackJackLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BlackJackLayout.createSequentialGroup()
                                .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(BlackJackLayout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(stayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(HitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(96, 96, 96))
                                    .addGroup(BlackJackLayout.createSequentialGroup()
                                        .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(BlackJackLayout.createSequentialGroup()
                                                .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(185, 185, 185)
                                                .addComponent(dealerCard, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(BlackJackLayout.createSequentialGroup()
                                                .addGap(183, 183, 183)
                                                .addComponent(newBlackJackGame)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)))
                                .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(BlackJackLayout.createSequentialGroup()
                                        .addComponent(messageOut2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(127, 127, 127)
                                        .addComponent(blackJackSendButton))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(BlackJackLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(212, 212, 212)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(BlackJackLayout.createSequentialGroup()
                        .addComponent(playerHandValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(DealerHandValue, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        BlackJackLayout.setVerticalGroup(
            BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlackJackLayout.createSequentialGroup()
                .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Exit2)
                        .addComponent(mainMenu2))
                    .addComponent(BlackJackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BlackJackLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(dealerCard, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BlackJackLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(BlackJackLayout.createSequentialGroup()
                                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(16, 16, 16)
                                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(62, 62, 62)))
                            .addComponent(newBlackJackGame))))
                .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BlackJackLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(messageOut2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(blackJackSendButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(BlackJackLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)))
                .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DealerHandValue, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerHandValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(BlackJack);

        attachmentButton.setText("Attachment");
        attachmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachmentButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Files");

        FileConsole.setColumns(20);
        FileConsole.setRows(5);
        jScrollPane3.setViewportView(FileConsole);

        Exit3.setBackground(new java.awt.Color(0, 0, 0));
        Exit3.setForeground(new java.awt.Color(255, 0, 51));
        Exit3.setText("Exit");
        Exit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit3ActionPerformed(evt);
            }
        });

        mainMenu3.setBackground(new java.awt.Color(0, 0, 0));
        mainMenu3.setForeground(new java.awt.Color(0, 255, 0));
        mainMenu3.setText("Main Menu");
        mainMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenu3ActionPerformed(evt);
            }
        });

        messageOut4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageOut4ActionPerformed(evt);
            }
        });

        FileSendButton.setText("Send");
        FileSendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileSendButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FilesLayout = new javax.swing.GroupLayout(Files);
        Files.setLayout(FilesLayout);
        FilesLayout.setHorizontalGroup(
            FilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FilesLayout.createSequentialGroup()
                .addComponent(mainMenu3)
                .addGap(336, 336, 336)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Exit3))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FilesLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(attachmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addGroup(FilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FilesLayout.createSequentialGroup()
                        .addComponent(messageOut4, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(FileSendButton)))
                .addGap(69, 69, 69))
        );
        FilesLayout.setVerticalGroup(
            FilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FilesLayout.createSequentialGroup()
                .addGroup(FilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(FilesLayout.createSequentialGroup()
                        .addGroup(FilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Exit3)
                            .addComponent(mainMenu3))
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(attachmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92)
                .addGroup(FilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageOut4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FileSendButton))
                .addContainerGap(140, Short.MAX_VALUE))
        );

        getContentPane().add(Files);

        ShopButton.setText("Shop");
        ShopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShopButtonActionPerformed(evt);
            }
        });

        BlackJackButton.setText("BlackJack");
        BlackJackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BlackJackButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Main Menu");

        FilesButton.setText("Files");
        FilesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilesButtonActionPerformed(evt);
            }
        });

        DisconnectButton.setText("Disconnect");
        DisconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisconnectButtonActionPerformed(evt);
            }
        });

        Exit4.setBackground(new java.awt.Color(0, 0, 0));
        Exit4.setForeground(new java.awt.Color(255, 0, 51));
        Exit4.setText("Exit");
        Exit4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit4ActionPerformed(evt);
            }
        });

        mainMenu4.setBackground(new java.awt.Color(0, 0, 0));
        mainMenu4.setForeground(new java.awt.Color(0, 255, 0));
        mainMenu4.setText("Main Menu");
        mainMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenu4ActionPerformed(evt);
            }
        });

        mainMenuConsole.setColumns(20);
        mainMenuConsole.setRows(5);
        menuConsole.setViewportView(mainMenuConsole);

        messageOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageOutActionPerformed(evt);
            }
        });

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        TicTacToeButton.setText("Tic Tac Toe");
        TicTacToeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TicTacToeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainMenuLayout = new javax.swing.GroupLayout(MainMenu);
        MainMenu.setLayout(MainMenuLayout);
        MainMenuLayout.setHorizontalGroup(
            MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainMenuLayout.createSequentialGroup()
                .addComponent(mainMenu4)
                .addGap(364, 364, 364)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Exit4))
            .addGroup(MainMenuLayout.createSequentialGroup()
                .addGroup(MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainMenuLayout.createSequentialGroup()
                        .addGroup(MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(FilesButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BlackJackButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ShopButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TicTacToeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE))
                            .addComponent(DisconnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addComponent(menuConsole, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE))
                    .addGroup(MainMenuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(messageOut, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(222, 222, 222)
                        .addComponent(sendButton)))
                .addContainerGap())
        );
        MainMenuLayout.setVerticalGroup(
            MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainMenuLayout.createSequentialGroup()
                .addGroup(MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainMenuLayout.createSequentialGroup()
                        .addGroup(MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Exit4)
                            .addComponent(mainMenu4))
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainMenuLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainMenuLayout.createSequentialGroup()
                        .addComponent(menuConsole, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addGroup(MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(messageOut, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sendButton)))
                    .addGroup(MainMenuLayout.createSequentialGroup()
                        .addComponent(ShopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BlackJackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FilesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TicTacToeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DisconnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(137, Short.MAX_VALUE))
        );

        getContentPane().add(MainMenu);

        jLabel1.setText("Tic Tac Toe");

        TTTConsole.setColumns(20);
        TTTConsole.setRows(5);
        jScrollPane5.setViewportView(TTTConsole);

        TTTButton.setText("Send");
        TTTButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TTTButtonActionPerformed(evt);
            }
        });

        mainMenu5.setBackground(new java.awt.Color(0, 0, 0));
        mainMenu5.setForeground(new java.awt.Color(0, 255, 0));
        mainMenu5.setText("Main Menu");
        mainMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenu5ActionPerformed(evt);
            }
        });

        Exit5.setBackground(new java.awt.Color(0, 0, 0));
        Exit5.setForeground(new java.awt.Color(255, 0, 51));
        Exit5.setText("Exit");
        Exit5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit5ActionPerformed(evt);
            }
        });

        TTTstartGameButton.setText("Start Game");
        TTTstartGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TTTstartGameButtonActionPerformed(evt);
            }
        });

        topMiddle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topMiddleActionPerformed(evt);
            }
        });

        topRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topRightActionPerformed(evt);
            }
        });

        topLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topLeftActionPerformed(evt);
            }
        });

        middleLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                middleLeftActionPerformed(evt);
            }
        });

        middleCenter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                middleCenterActionPerformed(evt);
            }
        });

        middleRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                middleRightActionPerformed(evt);
            }
        });

        bottomMiddle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bottomMiddleActionPerformed(evt);
            }
        });

        bottomRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bottomRightActionPerformed(evt);
            }
        });

        bottomLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bottomLeftActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TicTacToeLayout = new javax.swing.GroupLayout(TicTacToe);
        TicTacToe.setLayout(TicTacToeLayout);
        TicTacToeLayout.setHorizontalGroup(
            TicTacToeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TicTacToeLayout.createSequentialGroup()
                .addGroup(TicTacToeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TicTacToeLayout.createSequentialGroup()
                        .addGroup(TicTacToeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TicTacToeLayout.createSequentialGroup()
                                .addGap(235, 235, 235)
                                .addComponent(topMiddle, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TicTacToeLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(TicTacToeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(TicTacToeLayout.createSequentialGroup()
                                        .addComponent(bottomLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bottomMiddle, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(TicTacToeLayout.createSequentialGroup()
                                        .addComponent(middleLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(middleCenter, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(27, 27, 27)
                        .addGroup(TicTacToeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(topRight, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(middleRight, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bottomRight, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(TicTacToeLayout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(TTTstartGameButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(TicTacToeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TicTacToeLayout.createSequentialGroup()
                        .addComponent(messageOut3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TTTButton)
                        .addGap(25, 25, 25)))
                .addContainerGap())
            .addGroup(TicTacToeLayout.createSequentialGroup()
                .addComponent(mainMenu5)
                .addGap(399, 399, 399)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Exit5))
            .addGroup(TicTacToeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(TicTacToeLayout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(topLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(976, Short.MAX_VALUE)))
        );
        TicTacToeLayout.setVerticalGroup(
            TicTacToeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TicTacToeLayout.createSequentialGroup()
                .addGroup(TicTacToeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainMenu5)
                    .addComponent(Exit5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TicTacToeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TicTacToeLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addGroup(TicTacToeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(messageOut3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TTTButton)))
                    .addGroup(TicTacToeLayout.createSequentialGroup()
                        .addComponent(TTTstartGameButton)
                        .addGap(43, 43, 43)
                        .addGroup(TicTacToeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(topRight, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(topMiddle, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(TicTacToeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(middleLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(middleCenter, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(middleRight, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(TicTacToeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bottomLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bottomMiddle, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bottomRight, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(96, Short.MAX_VALUE))
            .addGroup(TicTacToeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(TicTacToeLayout.createSequentialGroup()
                    .addGap(162, 162, 162)
                    .addComponent(topLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(437, Short.MAX_VALUE)))
        );

        getContentPane().add(TicTacToe);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuActionPerformed
        ConnectScreen.setVisible(false);
        Shop.setVisible(false);
        BlackJack.setVisible(false);
        Files.setVisible(false);
        MainMenu.setVisible(true);
                
        // TODO add your handling code here:
    }//GEN-LAST:event_mainMenuActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void attachmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachmentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_attachmentButtonActionPerformed

    private void FilesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilesButtonActionPerformed
        // TODO add your handling code here:
        ConnectScreen.setVisible(false);
        Shop.setVisible(false);
        BlackJack.setVisible(false);
        Files.setVisible(true);
        MainMenu.setVisible(false);
    
    }//GEN-LAST:event_FilesButtonActionPerformed

    private void BlackJackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BlackJackButtonActionPerformed
        // TODO add your handling code here:
        ConnectScreen.setVisible(false);
        Shop.setVisible(false);
        card1.setVisible(false);
        card2.setVisible(false);
        card3.setVisible(false);
        card4.setVisible(false);
        DealerHandValue.setVisible(false);
        playerHandValue1.setVisible(false);
        HitButton.setVisible(false);
        stayButton.setVisible(false);
        BlackJackConsole.append("Your balance is: " + balance);
        BlackJackConsole.append("\nPress new Game to begin\n");
        dealerCard.setVisible(false);
        BlackJack.setVisible(true);
        Files.setVisible(false);
        MainMenu.setVisible(false);
    
    
    }//GEN-LAST:event_BlackJackButtonActionPerformed

    private void ShopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShopButtonActionPerformed

        ConnectScreen.setVisible(false);
        shopConsole.append("Your balance is: " + balance + "\n");
        Shop.setVisible(true);
        BlackJack.setVisible(false);
        Files.setVisible(false);
        MainMenu.setVisible(false);
    
        // TODO add your handling code here:
    }//GEN-LAST:event_ShopButtonActionPerformed

    private void serverIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverIPActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_serverIPActionPerformed

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        
     
      userName =  ClientUsername.getText();
        IP  =  serverIP.getText();
      boolean connected = connectToServer(IP, userName);
      if (connected == true){
        ConnectScreen.setVisible(false);
        Shop.setVisible(false);
        BlackJack.setVisible(false);
        Files.setVisible(false);
        MainMenu.setVisible(true);
        mainMenu.setVisible(true);
      }
      else{
          connectScreenConsole.append("Please enter a valid IP address\n");
      }
      ListenThread();
      
        
// TODO add your handling code here:
    }//GEN-LAST:event_connectButtonActionPerformed

    private void DisconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisconnectButtonActionPerformed
        // TODO add your handling code here:
       String s = disconnectFromServer(userName);
       System.exit(0);
        
    }//GEN-LAST:event_DisconnectButtonActionPerformed

    private void stayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stayButtonActionPerformed
        // TODO add your handling code here:
        HitButton.setVisible(false);
        stayButton.setVisible(false);
        for (int i = 0; i < player.getHand().getCards().getLength(); i++) {
			if (player.getHand().getCards().getCard(i).getRank() == Card.Rank.Ace) {
				if ((player.getHand().getCards().valueOfHand() + 10) <= 21) {
					player.getHand().getCards().getCard(i).setValue(11);
				}
			}
		}
		// Dealer will continue to take cards until his hand is greater than a value of
		// 16
		while (dealer.getHand().getCards().valueOfHand() <= 16 && dealer.getHand().getCards().bust() == false) {
			deck.dealCard(dealer.getHand().getCards());
			if (dealer.getHand().getCards().getCard(0).getRank() == Card.Rank.Ace
					&& (dealer.getHand().getCards().valueOfHand() + 11) <= 21) {
				dealer.getHand().getCards().getCard(0).setValue(11);
			}
		}
                DealerHandValue.setVisible(true);
                DealerHandValue.setText("Dealer Hand Value: " + dealer.getHand().getCards().valueOfHand());
                playerHandValue1.setVisible(true);
                playerHandValue1.setText("Player Hand Value: " + player.getHand().getCards().valueOfHand());
                BlackJackConsole.append(Pile.whoWon(dealer.getHand().getCards(), player.getHand().getCards()) + "\nPress the New Game button to play again\n");
                if(Pile.whoWon(dealer.getHand().getCards(), player.getHand().getCards()).equals("You won!") ||Pile.whoWon(dealer.getHand().getCards(), player.getHand().getCards()).equals("Dealer bust, You win!") ){
                    balance += 10;
                    BlackJackConsole.append("Your balance is now: " + balance + "\n");
                }
    }//GEN-LAST:event_stayButtonActionPerformed

    private void mainMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenu1ActionPerformed
        // TODO add your handling code here:
         ConnectScreen.setVisible(false);
        Shop.setVisible(false);
        BlackJack.setVisible(false);
        Files.setVisible(false);
        MainMenu.setVisible(true);
        TicTacToe.setVisible(false);
                
    }//GEN-LAST:event_mainMenu1ActionPerformed

    private void Exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_Exit1ActionPerformed

    private void Exit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_Exit2ActionPerformed

    private void Exit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_Exit3ActionPerformed

    private void Exit4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit4ActionPerformed
      System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_Exit4ActionPerformed

    private void mainMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenu2ActionPerformed
        // TODO add your handling code here:
         ConnectScreen.setVisible(false);
        Shop.setVisible(false);
        BlackJack.setVisible(false);
        Files.setVisible(false);
        MainMenu.setVisible(true);
        TicTacToe.setVisible(false);
                
    }//GEN-LAST:event_mainMenu2ActionPerformed

    private void mainMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenu3ActionPerformed
        // TODO add your handling code here:
         ConnectScreen.setVisible(false);
        Shop.setVisible(false);
        BlackJack.setVisible(false);
        Files.setVisible(false);
        MainMenu.setVisible(true);
        TicTacToe.setVisible(false);
                
    }//GEN-LAST:event_mainMenu3ActionPerformed

    private void mainMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenu4ActionPerformed
        // TODO add your handling code here:
         ConnectScreen.setVisible(false);
        Shop.setVisible(false);
        BlackJack.setVisible(false);
        Files.setVisible(false);
        MainMenu.setVisible(true);
         TicTacToe.setVisible(false);
                
    }//GEN-LAST:event_mainMenu4ActionPerformed

    private void messageOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_messageOutActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
      if(messageOut.getText().equals("")){
          messageOut.setText("");
          messageOut.requestFocus();
      }
      else{
          try{
              writer.println(userName + ":" + messageOut.getText() + ":" + "Chat");
              writer.flush();
              messageOut.setText("");
          }
          catch(Exception ex){
              mainMenuConsole.append("Message was not sent");
              BlackJackConsole.append("Message was not sent");
              shopConsole.append("Message was not sent");
              TTTConsole.append("Message was not sent");
              FileConsole.append("Message was not sent");
          }
          messageOut.setText("");
          messageOut.requestFocus();
      }
      messageOut.setText("");
      messageOut.requestFocus();
        
        
// TODO add your handling code here:
    }//GEN-LAST:event_sendButtonActionPerformed

    private void messageOut4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageOut4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_messageOut4ActionPerformed

    private void TicTacToeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TicTacToeButtonActionPerformed
        // TODO add your handling code here
        ConnectScreen.setVisible(false);
        Shop.setVisible(false);
        BlackJack.setVisible(false);
        Files.setVisible(false);
        MainMenu.setVisible(false);
        topMiddle.setVisible(false);
       topLeft.setVisible(false);
       topRight.setVisible(false);
       middleCenter.setVisible(false);
       middleLeft.setVisible(false);
       middleRight.setVisible(false);
       bottomMiddle.setVisible(false);
       bottomLeft.setVisible(false);
       bottomRight.setVisible(false);
        TicTacToe.setVisible(true);
        
        
    }//GEN-LAST:event_TicTacToeButtonActionPerformed

    private void mainMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenu5ActionPerformed
        // TODO add your handling code here:
          ConnectScreen.setVisible(false);
        Shop.setVisible(false);
        BlackJack.setVisible(false);
        Files.setVisible(false);
        MainMenu.setVisible(true);
        TicTacToe.setVisible(false);
    }//GEN-LAST:event_mainMenu5ActionPerformed

    private void Exit5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit5ActionPerformed
        System.exit(0);
// TODO add your handling code here:
    }//GEN-LAST:event_Exit5ActionPerformed

    private void shopSendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shopSendButtonActionPerformed
 if(messageOut1.getText().equals("")){
          messageOut1.setText("");
          messageOut1.requestFocus();
      }
      else{
          try{
              writer.println(userName + ":" + messageOut1.getText() + ":" + "Chat");
              writer.flush();
              messageOut1.setText("");
          }
          catch(Exception ex){
              mainMenuConsole.append("Message was not sent");
              shopConsole.append("Message was not sent");
              BlackJackConsole.append("Message was not sent");
              TTTConsole.append("Message was not sent");
              FileConsole.append("Message was not sent");
          }
          messageOut1.setText("");
          messageOut1.requestFocus();
      }
      messageOut1.setText("");
      messageOut1.requestFocus();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_shopSendButtonActionPerformed

    private void messageOut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageOut1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_messageOut1ActionPerformed

    private void blackJackSendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blackJackSendButtonActionPerformed
        // TODO add your handling code here:
        if(messageOut2.getText().equals("")){
          messageOut2.setText("");
          messageOut2.requestFocus();
      }
      else{
          try{
              writer.println(userName + ":" + messageOut2.getText() + ":" + "Chat");
              writer.flush();
              messageOut2.setText("");
          }
          catch(Exception ex){
              mainMenuConsole.append("Message was not sent");
              shopConsole.append("Message was not sent");
              BlackJackConsole.append("Message was not sent");
              TTTConsole.append("Message was not sent");
              FileConsole.append("Message was not sent");
          }
          messageOut2.setText("");
          messageOut2.requestFocus();
      }
      messageOut2.setText("");
      messageOut2.requestFocus();
        
    }//GEN-LAST:event_blackJackSendButtonActionPerformed

    private void TTTButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TTTButtonActionPerformed
        // TODO add your handling code here:
         if(messageOut3.getText().equals("")){
          messageOut3.setText("");
          messageOut3.requestFocus();
      }
      else{
          try{
              writer.println(userName + ":" + messageOut3.getText() + ":" + "Chat");
              writer.flush();
              messageOut3.setText("");
          }
          catch(Exception ex){
              mainMenuConsole.append("Message was not sent");
              shopConsole.append("Message was not sent");
              BlackJackConsole.append("Message was not sent");
              TTTConsole.append("Message was not sent");
              FileConsole.append("Message was not sent");
          }
          messageOut3.setText("");
          messageOut3.requestFocus();
      }
      messageOut3.setText("");
      messageOut3.requestFocus();
    }//GEN-LAST:event_TTTButtonActionPerformed

    private void FileSendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileSendButtonActionPerformed
        // TODO add your handling code here:
        if(messageOut4.getText().equals("")){
          messageOut4.setText("");
          messageOut4.requestFocus();
      }
      else{
          try{
              writer.println(userName + ":" + messageOut4.getText() + ":" + "Chat");
              writer.flush();
              messageOut4.setText("");
          }
          catch(Exception ex){
              mainMenuConsole.append("Message was not sent");
              shopConsole.append("Message was not sent");
              BlackJackConsole.append("Message was not sent");
              TTTConsole.append("Message was not sent");
              FileConsole.append("Message was not sent");
          }
          messageOut4.setText("");
          messageOut4.requestFocus();
      }
      messageOut4.setText("");
      messageOut4.requestFocus();
    }//GEN-LAST:event_FileSendButtonActionPerformed

    private void HitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HitButtonActionPerformed
        // TODO add your handling code here:
        
		deck.dealCard(player.getHand().getCards());
		if (count == 0) {
			card3.setVisible(true);
			card3.setText(player.getHand().getCards().getCard(0).toString());
		}
		if (count == 1) {
			card4.setVisible(true);
			card4.setText("" + player.getHand().getCards().getCard(0).toString());
		}
		while (dealer.getHand().getCards().valueOfHand() <= 16 && dealer.getHand().getCards().bust() == false) {
			deck.dealCard(dealer.getHand().getCards());
			if (dealer.getHand().getCards().getCard(0).getRank() == Card.Rank.Ace
					&& (dealer.getHand().getCards().valueOfHand() + 11) <= 21) {
				dealer.getHand().getCards().getCard(0).setValue(11);
			}
		}
		// if player busts the game is over for them
		if (player.getHand().getCards().bust()) {
			BlackJackConsole.append("Bust, you lose! Press New Game to play again.\n");
			stayButton.setVisible(false);
			HitButton.setVisible(false);
                        DealerHandValue.setVisible(true);
                        DealerHandValue.setText("Dealer hand value: " + dealer.getHand().getCards().valueOfHand());
		}
                else{
                    BlackJackConsole.append("Hit or Stay?\n");
                }
                count++;
		// Display/ change value of each players hand
                playerHandValue1.setVisible(true);
		playerHandValue1.setText("Player hand value: " + player.getHand().getCards().valueOfHand());
	
    }//GEN-LAST:event_HitButtonActionPerformed

    private void newBlackJackGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBlackJackGameActionPerformed
        // TODO add your handling code here:
        count=0;
        HitButton.setVisible(true);
        stayButton.setVisible(true);
        playerHandValue1.setVisible(true);
        deck.setDeck(Deck.resetDeck(player.getHand().getCards(), dealer.getHand().getCards()));
        deck.dealCard(player.getHand().getCards());
        deck.dealCard(player.getHand().getCards());
        deck.dealCard(dealer.getHand().getCards());
        deck.dealCard(dealer.getHand().getCards());
        card1.setText("" + player.getHand().getCards().getCard(0).toString());
        card2.setText("" + player.getHand().getCards().getCard(1).toString());
        card1.setVisible(true);
        card2.setVisible(true);
        card3.setVisible(false);
        card4.setVisible(false);
	dealerCard.setText("" + dealer.getHand().getCards().getCard(0).toString());
        playerHandValue1.setText("Player value is: " + player.getHand().getCards().valueOfHand());
        dealerCard.setVisible(true);
        DealerHandValue.setVisible(false);
        BlackJackConsole.append("Hit or Stay?\n");
       
    }//GEN-LAST:event_newBlackJackGameActionPerformed

    private void fiftyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiftyButtonActionPerformed
      if (balance>=50){
          balance -= 50;
          Shop.setBackground(Color.green);
          BlackJack.setBackground(Color.green);
          MainMenu.setBackground(Color.green);
          Files.setBackground(Color.green);
          TicTacToe.setBackground(Color.green);
          shopConsole.append("Your new balance is: " + balance + "\n");
      }
      else{
          shopConsole.append("Not enough balance\nYour balance is: "+ balance + "\n");
      }
        
// TODO add your handling code here:
    }//GEN-LAST:event_fiftyButtonActionPerformed

    private void hundredButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hundredButtonActionPerformed
        // TODO add your handling code here:
         if (balance>=100){
          balance -= 100;
          Shop.setBackground(Color.blue);
          BlackJack.setBackground(Color.blue);
          MainMenu.setBackground(Color.blue);
          Files.setBackground(Color.blue);
          TicTacToe.setBackground(Color.blue);
          shopConsole.append("Your new balance is: " + balance + "\n");
      }
      else{
          shopConsole.append("Not enough balance\nYour balance is: "+ balance + "\n");
      }
    }//GEN-LAST:event_hundredButtonActionPerformed

    private void hundredfiftyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hundredfiftyButtonActionPerformed
        // TODO add your handling code here:
         if (balance>=150){
          balance -= 150;
          Shop.setBackground(Color.orange);
          BlackJack.setBackground(Color.orange);
          MainMenu.setBackground(Color.orange);
          Files.setBackground(Color.orange);
          TicTacToe.setBackground(Color.orange);
          shopConsole.append("Your new balance is: " + balance + "\n");
      }
      else{
          shopConsole.append("Not enough balance\nYour balance is: "+ balance + "\n");
      }
    }//GEN-LAST:event_hundredfiftyButtonActionPerformed

    private void twohundredButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twohundredButtonActionPerformed
        // TODO add your handling code here:
         if (balance>=50){
          balance -= 50;
          Shop.setBackground(Color.red);
          BlackJack.setBackground(Color.red);
          MainMenu.setBackground(Color.red);
          Files.setBackground(Color.red);
          TicTacToe.setBackground(Color.red);
          shopConsole.append("Your new balance is: " + balance + "\n");
      }
      else{
          shopConsole.append("Not enough balance\nYour balance is: "+ balance + "\n");
      }
    }//GEN-LAST:event_twohundredButtonActionPerformed

    private void TTTstartGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TTTstartGameButtonActionPerformed
       topMiddle.setVisible(true);
       topLeft.setVisible(true);
       topRight.setVisible(true);
       middleCenter.setVisible(true);
       middleLeft.setVisible(true);
       middleRight.setVisible(true);
       bottomMiddle.setVisible(true);
       bottomLeft.setVisible(true);
       bottomRight.setVisible(true);
       
        
        
        // TODO add your handling code here:
        /*try{
            Desktop.getDesktop().open(new File(""));
        }*/
    }//GEN-LAST:event_TTTstartGameButtonActionPerformed

    private void topLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topLeftActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_topLeftActionPerformed

    private void topMiddleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topMiddleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_topMiddleActionPerformed

    private void topRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topRightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_topRightActionPerformed

    private void middleLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_middleLeftActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_middleLeftActionPerformed

    private void middleCenterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_middleCenterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_middleCenterActionPerformed

    private void middleRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_middleRightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_middleRightActionPerformed

    private void bottomLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bottomLeftActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bottomLeftActionPerformed

    private void bottomMiddleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bottomMiddleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bottomMiddleActionPerformed

    private void bottomRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bottomRightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bottomRightActionPerformed

    /**
     * @param args the command line arguments
     */



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BlackJack;
    private javax.swing.JButton BlackJackButton;
    private javax.swing.JTextArea BlackJackConsole;
    private javax.swing.JLabel BlackJackLabel;
    private javax.swing.JTextField ClientUsername;
    private javax.swing.JPanel ConnectScreen;
    private javax.swing.JLabel DealerHandValue;
    private javax.swing.JButton DisconnectButton;
    private javax.swing.JButton Exit;
    private javax.swing.JButton Exit1;
    private javax.swing.JButton Exit2;
    private javax.swing.JButton Exit3;
    private javax.swing.JButton Exit4;
    private javax.swing.JButton Exit5;
    private javax.swing.JTextArea FileConsole;
    private javax.swing.JButton FileSendButton;
    private javax.swing.JPanel Files;
    private javax.swing.JButton FilesButton;
    private javax.swing.JButton HitButton;
    private javax.swing.JPanel MainMenu;
    private javax.swing.JPanel Shop;
    private javax.swing.JButton ShopButton;
    private javax.swing.JButton TTTButton;
    private javax.swing.JTextArea TTTConsole;
    private javax.swing.JButton TTTstartGameButton;
    private javax.swing.JPanel TicTacToe;
    private javax.swing.JButton TicTacToeButton;
    private javax.swing.JButton attachmentButton;
    private javax.swing.JButton blackJackSendButton;
    private javax.swing.JButton bottomLeft;
    private javax.swing.JButton bottomMiddle;
    private javax.swing.JButton bottomRight;
    private javax.swing.JLabel card1;
    private javax.swing.JLabel card2;
    private javax.swing.JLabel card3;
    private javax.swing.JLabel card4;
    private javax.swing.JButton connectButton;
    private javax.swing.JTextArea connectScreenConsole;
    private javax.swing.JScrollPane console;
    private javax.swing.JLabel dealerCard;
    private javax.swing.JButton fiftyButton;
    private javax.swing.JButton hundredButton;
    private javax.swing.JButton hundredfiftyButton;
    private javax.swing.JLabel ipaddressLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton mainMenu;
    private javax.swing.JButton mainMenu1;
    private javax.swing.JButton mainMenu2;
    private javax.swing.JButton mainMenu3;
    private javax.swing.JButton mainMenu4;
    private javax.swing.JButton mainMenu5;
    private javax.swing.JTextArea mainMenuConsole;
    private javax.swing.JScrollPane menuConsole;
    private javax.swing.JTextField messageOut;
    private javax.swing.JTextField messageOut1;
    private javax.swing.JTextField messageOut2;
    private javax.swing.JTextField messageOut3;
    private javax.swing.JTextField messageOut4;
    private javax.swing.JButton middleCenter;
    private javax.swing.JButton middleLeft;
    private javax.swing.JButton middleRight;
    private javax.swing.JButton newBlackJackGame;
    private javax.swing.JLabel playerHandValue1;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextField serverIP;
    private javax.swing.JTextArea shopConsole;
    private javax.swing.JButton shopSendButton;
    private javax.swing.JButton stayButton;
    private javax.swing.JButton topLeft;
    private javax.swing.JButton topMiddle;
    private javax.swing.JButton topRight;
    private javax.swing.JButton twohundredButton;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
