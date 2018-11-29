package GUI;

import java.awt.Color;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import javax.accessibility.AccessibleContext;
public class ChatGUI extends javax.swing.JFrame {
    private static String IP = new String();
    private static String userName = new String();
    public static Deck deck = new Deck();
    public static Player player = new Player("Player");
    public static Player dealer = new Player("Dealer");
    public static int count = 0;
    public static double balance = 100;
    public static String jarFilePath;
    
    public static double getBalance(){
        return balance;
    }
    public static void addBalance(){
        balance+=10;
    }
    public static void removeBalance(){
       if (balance>=1){
        balance-=1;
       }
    }
    public ChatGUI() {
        initComponents();
        ConnectScreen.setVisible(true);
        Shop.setVisible(false);
        BlackJack.setVisible(false);
     
        MainMenu.setVisible(false);
     
        mainMenu.setVisible(false);
    }
    public static int port = 2222;
	public static boolean isConnected = false;
	public static Socket sock = new Socket();
	public static BufferedReader reader;
	public static PrintWriter writer;
        ArrayList<String> users = new ArrayList();
        
        public static PrintWriter getWriter(){
            return writer;
        }
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
                                                
						mainMenuConsole.setCaretPosition(mainMenuConsole.getDocument().getLength());
                                                shopConsole.setCaretPosition(shopConsole.getDocument().getLength());
                                                BlackJackConsole.setCaretPosition(BlackJackConsole.getDocument().getLength());
                                              
					} else if (data[2].equals(connect)) {
						mainMenuConsole.removeAll();
                                                shopConsole.removeAll();
                                                BlackJackConsole.removeAll();
                                              
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
        MainMenu = new javax.swing.JPanel();
        ShopButton = new javax.swing.JButton();
        BlackJackButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        DisconnectButton = new javax.swing.JButton();
        Exit4 = new javax.swing.JButton();
        mainMenu4 = new javax.swing.JButton();
        menuConsole = new javax.swing.JScrollPane();
        mainMenuConsole = new javax.swing.JTextArea();
        messageOut = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        TicTacToeButton = new javax.swing.JButton();
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
        card5 = new javax.swing.JLabel();
        card6 = new javax.swing.JLabel();
        card7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1050, 600));
        setResizable(false);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        ConnectScreen.setPreferredSize(new java.awt.Dimension(1000, 500));

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
        connectButton.setAlignmentX(0.5F);
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        usernameLabel.setText("Username");
        usernameLabel.setAlignmentX(0.5F);

        ipaddressLabel.setText("IP address of server");
        ipaddressLabel.setAlignmentX(0.5F);

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
                .addContainerGap()
                .addComponent(console)
                .addContainerGap())
            .addGroup(ConnectScreenLayout.createSequentialGroup()
                .addGap(429, 429, 429)
                .addGroup(ConnectScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usernameLabel)
                    .addComponent(serverIP)
                    .addComponent(ipaddressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ClientUsername)
                    .addComponent(connectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(498, Short.MAX_VALUE))
        );
        ConnectScreenLayout.setVerticalGroup(
            ConnectScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConnectScreenLayout.createSequentialGroup()
                .addGroup(ConnectScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mainMenu)
                    .addComponent(Exit))
                .addGap(27, 27, 27)
                .addComponent(console, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ipaddressLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(serverIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameLabel)
                .addGap(8, 8, 8)
                .addComponent(ClientUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(connectButton)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        getContentPane().add(ConnectScreen);

        MainMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MainMenu.setPreferredSize(new java.awt.Dimension(750, 513));

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

        jLabel3.setFont(new java.awt.Font("Niagara Engraved", 1, 48)); // NOI18N
        jLabel3.setText("Main Menu");

        DisconnectButton.setText("Disconnect");
        DisconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisconnectButtonActionPerformed(evt);
            }
        });

        Exit4.setBackground(new java.awt.Color(0, 0, 0));
        Exit4.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 13)); // NOI18N
        Exit4.setForeground(new java.awt.Color(255, 0, 51));
        Exit4.setText("Exit");
        Exit4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit4ActionPerformed(evt);
            }
        });

        mainMenu4.setBackground(new java.awt.Color(0, 0, 0));
        mainMenu4.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 13)); // NOI18N
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
                .addContainerGap()
                .addGroup(MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TicTacToeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ShopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DisconnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BlackJackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainMenuLayout.createSequentialGroup()
                        .addComponent(messageOut, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(menuConsole))
                .addContainerGap())
            .addGroup(MainMenuLayout.createSequentialGroup()
                .addComponent(mainMenu4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(370, 370, 370)
                .addComponent(Exit4))
        );
        MainMenuLayout.setVerticalGroup(
            MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainMenuLayout.createSequentialGroup()
                .addGroup(MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Exit4)
                    .addComponent(mainMenu4))
                .addGap(42, 42, 42)
                .addGroup(MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuConsole, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MainMenuLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(ShopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BlackJackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TicTacToeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DisconnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(messageOut, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MainMenuLayout.createSequentialGroup()
                        .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))))
        );

        getContentPane().add(MainMenu);

        Shop.setPreferredSize(new java.awt.Dimension(1000, 500));

        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 48)); // NOI18N
        jLabel4.setText("Shop");

        fiftyButton.setForeground(java.awt.Color.green);
        fiftyButton.setText("50$");
        fiftyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiftyButtonActionPerformed(evt);
            }
        });

        hundredButton.setForeground(java.awt.Color.blue);
        hundredButton.setText("100$");
        hundredButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hundredButtonActionPerformed(evt);
            }
        });

        hundredfiftyButton.setForeground(java.awt.Color.orange);
        hundredfiftyButton.setText("150$");
        hundredfiftyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hundredfiftyButtonActionPerformed(evt);
            }
        });

        twohundredButton.setForeground(java.awt.Color.red);
        twohundredButton.setText("200$");
        twohundredButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twohundredButtonActionPerformed(evt);
            }
        });

        jLabel7.setForeground(java.awt.Color.green);
        jLabel7.setText("Green Background");

        jLabel8.setForeground(java.awt.Color.blue);
        jLabel8.setText("Blue Background");

        jLabel9.setForeground(java.awt.Color.red);
        jLabel9.setText("Red Background");

        jLabel10.setForeground(java.awt.Color.orange);
        jLabel10.setText("Orange Background");

        mainMenu1.setBackground(new java.awt.Color(0, 0, 0));
        mainMenu1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 13)); // NOI18N
        mainMenu1.setForeground(new java.awt.Color(0, 255, 0));
        mainMenu1.setText("Main Menu");
        mainMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenu1ActionPerformed(evt);
            }
        });

        Exit1.setBackground(new java.awt.Color(0, 0, 0));
        Exit1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 13)); // NOI18N
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
                .addComponent(mainMenu1)
                .addGap(329, 329, 329)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Exit1))
            .addGroup(ShopLayout.createSequentialGroup()
                .addGroup(ShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(64, 64, 64)
                .addGroup(ShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(hundredButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fiftyButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(twohundredButton, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(hundredfiftyButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(ShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ShopLayout.createSequentialGroup()
                        .addComponent(messageOut1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(shopSendButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        ShopLayout.setVerticalGroup(
            ShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ShopLayout.createSequentialGroup()
                .addGroup(ShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mainMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Exit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(ShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ShopLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(ShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fiftyButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hundredButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hundredfiftyButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(twohundredButton))
                        .addGap(211, 211, 211))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ShopLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(ShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(shopSendButton)
                    .addComponent(messageOut1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(Shop);

        BlackJack.setPreferredSize(new java.awt.Dimension(1050, 600));

        BlackJackLabel.setFont(new java.awt.Font("Sylfaen", 1, 48)); // NOI18N
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

        card5.setText("card5");

        card6.setText("card6");

        card7.setText("card7");

        javax.swing.GroupLayout BlackJackLayout = new javax.swing.GroupLayout(BlackJack);
        BlackJack.setLayout(BlackJackLayout);
        BlackJackLayout.setHorizontalGroup(
            BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlackJackLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BlackJackLayout.createSequentialGroup()
                        .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(card5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(card6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(card7, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(BlackJackLayout.createSequentialGroup()
                                .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(185, 185, 185)
                                .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dealerCard, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(HitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BlackJackLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(messageOut2, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(blackJackSendButton))
                            .addGroup(BlackJackLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4))))
                    .addGroup(BlackJackLayout.createSequentialGroup()
                        .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BlackJackLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(playerHandValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DealerHandValue, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(BlackJackLayout.createSequentialGroup()
                                .addComponent(stayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(newBlackJackGame)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(BlackJackLayout.createSequentialGroup()
                .addComponent(mainMenu2)
                .addGap(396, 396, 396)
                .addComponent(BlackJackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Exit2))
        );
        BlackJackLayout.setVerticalGroup(
            BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlackJackLayout.createSequentialGroup()
                .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainMenu2)
                    .addComponent(BlackJackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Exit2))
                .addGap(26, 26, 26)
                .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BlackJackLayout.createSequentialGroup()
                        .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BlackJackLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(dealerCard, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BlackJackLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(card5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(card6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(card7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BlackJackLayout.createSequentialGroup()
                        .addGap(0, 33, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(stayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(HitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(newBlackJackGame))
                    .addGroup(BlackJackLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(messageOut2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(blackJackSendButton))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BlackJackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DealerHandValue, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerHandValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(BlackJack);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BlackJackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BlackJackButtonActionPerformed
        // TODO add your handling code here:
        ConnectScreen.setVisible(false);
        Shop.setVisible(false);
        card1.setVisible(false);
        card2.setVisible(false);
        card3.setVisible(false);
        card4.setVisible(false);
        card5.setVisible(false);
        card6.setVisible(false);
        card7.setVisible(false);
        DealerHandValue.setVisible(false);
        playerHandValue1.setVisible(false);
        HitButton.setVisible(false);
        stayButton.setVisible(false);
        BlackJackConsole.append("Your balance is: " + balance + "$");
        BlackJackConsole.append("\nPress new Game to begin\n");
        dealerCard.setVisible(false);
        BlackJack.setVisible(true);
     
        MainMenu.setVisible(false);
    
    
    }//GEN-LAST:event_BlackJackButtonActionPerformed

    private void ShopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShopButtonActionPerformed

        ConnectScreen.setVisible(false);
        shopConsole.append("Your balance is: " + balance + "$\n");
        Shop.setVisible(true);
        BlackJack.setVisible(false);
     
        MainMenu.setVisible(false);
    
        // TODO add your handling code here:
    }//GEN-LAST:event_ShopButtonActionPerformed

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
                    addBalance();
                    BlackJackConsole.append("Your balance is now: " + balance + "$\n");
                    writer.println("Server: "+ userName + " won a game of Black Jack" + ":Chat");
                    writer.flush();
                }
                else{
                    removeBalance();
                    BlackJackConsole.append("Your balance is now: " + balance + "$\n");
                   writer.println("Server: "+ userName + " lost in a game of Black Jack" + ":Chat");
                   writer.flush();
                }
    }//GEN-LAST:event_stayButtonActionPerformed

    private void mainMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenu1ActionPerformed
        // TODO add your handling code here:
         ConnectScreen.setVisible(false);
        Shop.setVisible(false);
        BlackJack.setVisible(false);
     
        MainMenu.setVisible(true);

                
    }//GEN-LAST:event_mainMenu1ActionPerformed

    private void Exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_Exit1ActionPerformed

    private void Exit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_Exit2ActionPerformed

    private void Exit4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit4ActionPerformed
      System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_Exit4ActionPerformed

    private void mainMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenu2ActionPerformed
        // TODO add your handling code here:
         ConnectScreen.setVisible(false);
        Shop.setVisible(false);
        BlackJack.setVisible(false);
 
        MainMenu.setVisible(true);
     
                
    }//GEN-LAST:event_mainMenu2ActionPerformed

    private void mainMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenu4ActionPerformed
        // TODO add your handling code here:
         ConnectScreen.setVisible(false);
        Shop.setVisible(false);
        BlackJack.setVisible(false);
 
        MainMenu.setVisible(true);

                
    }//GEN-LAST:event_mainMenu4ActionPerformed

    private void messageOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_messageOutActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
      
        if(messageOut.getText().equals("/bal")){
           mainMenuConsole.append("Your balance is: " + balance + "$\n");
              BlackJackConsole.append("Your balance is: " + balance + "$\n");
              shopConsole.append("Your balance is: " + balance + "$\n");
 
        }
        else if(messageOut.getText().startsWith("@@")){
          jarFilePath = messageOut.getText();
           jarFilePath = jarFilePath.substring(2);
          mainMenuConsole.append("\"" + jarFilePath + "\" has been set as the path to the Jar file.\n");
        }
       else if(messageOut.getText().equals("")){
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
          
          }
          messageOut.setText("");
          messageOut.requestFocus();
      }
      messageOut.setText("");
      messageOut.requestFocus();
        
        
// TODO add your handling code here:
    }//GEN-LAST:event_sendButtonActionPerformed

    private void TicTacToeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TicTacToeButtonActionPerformed
        // TODO add your handling code here
        
        
        try {
					Desktop.getDesktop().open(new File(jarFilePath));
                                        writer.println("Server: " + userName + " has started a game of Tic Tac Toe" + ":Chat");
         writer.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            
        
        
    }//GEN-LAST:event_TicTacToeButtonActionPerformed

    private void shopSendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shopSendButtonActionPerformed
if(messageOut1.getText().equals("/bal")){
           mainMenuConsole.append("Your balance is: " + balance + "$\n");
              BlackJackConsole.append("Your balance is: " + balance + "$\n");
              shopConsole.append("Your balance is: " + balance + "$\n");
        }
else if(messageOut1.getText().startsWith("@@")){
          jarFilePath = messageOut1.getText();
          jarFilePath = jarFilePath.substring(2);
           mainMenuConsole.append("\"" + jarFilePath + "\" has been set as the path to the Jar file.\n");
        }
        
       else if(messageOut1.getText().equals("")){
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
       if(messageOut2.getText().equals("/bal")){
           mainMenuConsole.append("Your balance is: " + balance + "$\n");
              BlackJackConsole.append("Your balance is: " + balance + "$\n");
              shopConsole.append("Your balance is: " + balance + "$\n");

        }
       else if(messageOut2.getText().startsWith("@@")){
          jarFilePath = messageOut2.getText();
           jarFilePath = jarFilePath.substring(2);
          mainMenuConsole.append("\"" + jarFilePath + "\" has been set as the path to the Jar file.\n");
        }
       else if(messageOut2.getText().equals("")){
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
          }
          messageOut2.setText("");
          messageOut2.requestFocus();
      }
      messageOut2.setText("");
      messageOut2.requestFocus();
        
    }//GEN-LAST:event_blackJackSendButtonActionPerformed

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
                if (count == 2) {
			card5.setVisible(true);
			card5.setText(player.getHand().getCards().getCard(0).toString());
		}
		if (count == 3) {
			card6.setVisible(true);
			card6.setText("" + player.getHand().getCards().getCard(0).toString());
		}
                if (count == 4) {
			card6.setVisible(true);
			card6.setText("" + player.getHand().getCards().getCard(0).toString());
		}
                if (count == 5) {
			card7.setVisible(true);
			card7.setText("" + player.getHand().getCards().getCard(0).toString());
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
                        
                        writer.println("Server: "+ userName+ " lost a game of Black Jack" + ":Chat");
                        writer.flush();
                        removeBalance();
                        BlackJackConsole.append("Your new balance is: " + balance + "$\n");
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
        card5.setVisible(false);
        card6.setVisible(false);
        card7.setVisible(false);
	dealerCard.setText("" + dealer.getHand().getCards().getCard(0).toString());
        playerHandValue1.setText("Player value is: " + player.getHand().getCards().valueOfHand());
        dealerCard.setVisible(true);
        DealerHandValue.setVisible(false);
        BlackJackConsole.append("Hit or Stay?\n");
       
    }//GEN-LAST:event_newBlackJackGameActionPerformed

    private void fiftyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiftyButtonActionPerformed
      if (balance>=50){
          fiftyButton.setVisible(false);
          hundredButton.setVisible(true);
          hundredfiftyButton.setVisible(true);
          twohundredButton.setVisible(true);
          balance -= 50;
          Shop.setBackground(Color.green);
          BlackJack.setBackground(Color.green);
          MainMenu.setBackground(Color.green);

          shopConsole.append("Your new balance is: " + balance + "$\n");
      }
      else{
          shopConsole.append("Not enough balance\nYour balance is: "+ balance + "$\n");
      }
        
// TODO add your handling code here:
    }//GEN-LAST:event_fiftyButtonActionPerformed

    private void hundredButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hundredButtonActionPerformed
        // TODO add your handling code here:
         if (balance>=100){
          fiftyButton.setVisible(true);
          hundredButton.setVisible(false);
          hundredfiftyButton.setVisible(true);
          twohundredButton.setVisible(true);
          balance -= 100;
          Shop.setBackground(Color.blue);
          BlackJack.setBackground(Color.blue);
          MainMenu.setBackground(Color.blue);

          shopConsole.append("Your new balance is: " + balance + "$\n");
      }
      else{
          shopConsole.append("Not enough balance\nYour balance is: "+ balance + "$\n");
      }
    }//GEN-LAST:event_hundredButtonActionPerformed

    private void hundredfiftyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hundredfiftyButtonActionPerformed
        // TODO add your handling code here:
         if (balance>=150){
          fiftyButton.setVisible(true);
          hundredButton.setVisible(true);
          hundredfiftyButton.setVisible(false);
          twohundredButton.setVisible(true);
          balance -= 150;
          Shop.setBackground(Color.orange);
          BlackJack.setBackground(Color.orange);
          MainMenu.setBackground(Color.orange);

          shopConsole.append("Your new balance is: " + balance + "$\n");
      }
      else{
          shopConsole.append("Not enough balance\nYour balance is: "+ balance + "$\n");
      }
    }//GEN-LAST:event_hundredfiftyButtonActionPerformed

    private void twohundredButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twohundredButtonActionPerformed
        // TODO add your handling code here:
         if (balance>=200){
          fiftyButton.setVisible(true);
          hundredButton.setVisible(true);
          hundredfiftyButton.setVisible(true);
          twohundredButton.setVisible(false);
          balance -= 200;
          Shop.setBackground(Color.red);
          BlackJack.setBackground(Color.red);
          MainMenu.setBackground(Color.red);

          shopConsole.append("Your new balance is: " + balance + "$\n");
          writer.println(userName + ": just bought the red background for 200$! :Chat");
          writer.flush();
      }
      else{
          shopConsole.append("Not enough balance\nYour balance is: "+ balance + "$\n");
      }
    }//GEN-LAST:event_twohundredButtonActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void mainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuActionPerformed
        ConnectScreen.setVisible(false);
        Shop.setVisible(false);
        BlackJack.setVisible(false);
        MainMenu.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_mainMenuActionPerformed

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed

        userName =  ClientUsername.getText();
        IP  =  serverIP.getText();
        boolean connected = connectToServer(IP, userName);
        if (connected == true){
            ConnectScreen.setVisible(false);
            Shop.setVisible(false);
            BlackJack.setVisible(false);

            MainMenu.setVisible(true);
            mainMenu.setVisible(true);
            BlackJackConsole.append("Use /bal to check your balance\n");
            shopConsole.append("Use /bal to check your balance\n");
            mainMenuConsole.append("Use /bal to check your balance\n");
            mainMenuConsole.append("Use @@ at the begging of the message to specify the jar file for Tic Tac Toe\nFor example type @@C:\\Users\\(Your username)\\Desktop\\TicTacToeWindow.jar into the message box then hit send\n");
         
        }
        else{
            connectScreenConsole.append("Please enter a valid IP address\n");
        }
        ListenThread();

        // TODO add your handling code here:
    }//GEN-LAST:event_connectButtonActionPerformed

    private void serverIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serverIPActionPerformed

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
    private javax.swing.JButton Exit4;
    private javax.swing.JButton HitButton;
    private javax.swing.JPanel MainMenu;
    private javax.swing.JPanel Shop;
    private javax.swing.JButton ShopButton;
    private javax.swing.JButton TicTacToeButton;
    private javax.swing.JButton blackJackSendButton;
    private javax.swing.JLabel card1;
    private javax.swing.JLabel card2;
    private javax.swing.JLabel card3;
    private javax.swing.JLabel card4;
    private javax.swing.JLabel card5;
    private javax.swing.JLabel card6;
    private javax.swing.JLabel card7;
    private javax.swing.JButton connectButton;
    private javax.swing.JTextArea connectScreenConsole;
    private javax.swing.JScrollPane console;
    private javax.swing.JLabel dealerCard;
    private javax.swing.JButton fiftyButton;
    private javax.swing.JButton hundredButton;
    private javax.swing.JButton hundredfiftyButton;
    private javax.swing.JLabel ipaddressLabel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton mainMenu;
    private javax.swing.JButton mainMenu1;
    private javax.swing.JButton mainMenu2;
    private javax.swing.JButton mainMenu4;
    private javax.swing.JTextArea mainMenuConsole;
    private javax.swing.JScrollPane menuConsole;
    private javax.swing.JTextField messageOut;
    private javax.swing.JTextField messageOut1;
    private javax.swing.JTextField messageOut2;
    private javax.swing.JButton newBlackJackGame;
    private javax.swing.JLabel playerHandValue1;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextField serverIP;
    private javax.swing.JTextArea shopConsole;
    private javax.swing.JButton shopSendButton;
    private javax.swing.JButton stayButton;
    private javax.swing.JButton twohundredButton;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
