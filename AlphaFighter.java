import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AlphaFighter implements KeyListener {

            int b = -1;
            int c = -1;
            int d = -1;
            int e = -1;
            int f = -1;
            int gg = -1;
            int h = -1;
            int hh = -1;
            int ia = -1;
            int ja = -1;
            int ka = -1;
            int la = -1;
            int ma = -1;
            int na = -1;
            int oa = -1;
            int pa = -1;
            int qa = -1;
            int ra = -1;
            int sa = -1;
            boolean isBlockingFriend = false;;
            
            boolean isBlockingEnemy = false;;
    private String key = ""; /*user input pressied*/
    private String ky = ""; /*user input pressied*/
    private String kk = ""; /*user input pressied*/
    private String kyk = ""; /*user input pressied*/
    private String kkk = "e"; /*user input pressied*/
    private String kky = "u"; /*user input pressied*/
    private String kyx = ""; /*user input pressied*/
    private String yx = ""; /*user input pressied*/
    private int eky = 0; /*user input pressied*/
    private boolean bb = false; /*user presseed*/
    private boolean enemyAggressing = false; /*user presseed*/

    private int babysitter3 = 0; /*user input pressied*/
    private int babysitter = 0; /*user input pressied*/
    private int baseball = 0;

    public int livesEnemy = 50;
    public int livesFriend = 51;
    
    private int y = 500;
    private int x = 200;

    private int y2 = 500;
    private int x2 = 700;

    private Graphics g;
    //  pUblick Graphics g2; ;
    private JPanel p = new JPanel();
    private JFrame j = new JFrame();
    
    class fireball {
        int x;
        int y;
        boolean fst = true;
        public fireball(int x, int y) {
            this.x = x;
            this.y = y;
        }
        void move() {
            if (fst)
                fst = false;
            g.setColor(Color.WHITE);
            g.fillOval(this.x, this.y, 50, 50);
            this.x+=5;
        }
        void moveEnemy() {
            if (fst)
                fst = false;
            g.setColor(Color.WHITE);
            g.fillOval(this.x, this.y, 50, 50);
            this.x-=5;
        }
    }
    
    private fireball fb = null;
    private fireball fb2 = null;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        /* User can press up or kick button
        */
        if(e.getKeyCode() == KeyEvent.VK_UP && (kyx.equals("l") || kyx.equals("r"))) {

            Thread t = new Thread() {

                public void run() {

                    if(key.equals("e")/* || key.equals("u")*/)
                        return;

                    key = "u";
                    kky = "u";
                    try {
                        Thread tt1 = new Thread() {
                            public void run() {
                                while(true) {
                                    if(kyx.equals("r")) {
                                        clear();
                                        x+=1;
                                        if(baseball < 95)
                                            y-=2;
                                        if(baseball > 95)
                                            y+=2;
                                        if(kkk.equals("e"))
                                            drawJumpKick();
                                        else
                                            drawJump1();
                                        try {
                                            Thread.sleep(1);
                                        } catch(Exception e) {
                                            
                                        }
                                        baseball++;
                                        if(baseball > 190) {
                                            kyx = "";
                                            baseball = 0;
                                            kkk = "";
                                            return;
                                        }
                                    } else
                                        break;
                                }
                                baseball = 0;
                            }
                        };
                        tt1.start();

                        Thread tt2 = new Thread() {
                            public void run() {
                                while(true) {
                                    if(kyx.equals("l")) {
                                        clear();
                                        x-=1;
                                        if(baseball < 95)
                                            y-=2;
                                        if(kkk.equals("e"))
                                            drawJumpKick();
                                        else
                                            drawJump1();
                                        if(baseball > 95)
                                            y+=2;
                                        try {
                                            Thread.sleep(1);
                                        } catch(Exception e) {
                                            
                                        }
                                        baseball++;
                                        if(baseball > 190) {
                                            kyx = "";
                                            baseball = 0;
                                            kkk = "";
                                            return;
                                        }
                                    } else
                                        break;
                                }
                                baseball = 0;
                            }
                        };
                        tt2.start();

                        Thread.sleep(150);
                    } catch(Exception ev) {
                        ev.printStackTrace();
                    }
                    key = "";
                    ky = "";
                    kk = "";
                }
            };
            t.start();
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            yx = "dp";
        }
        if(e.getKeyCode() == KeyEvent.VK_G) {
            if(yx.equals("dp")) {
                Thread tt1 = new Thread() {
                    public void run() {
                        while(true) {
                            if(yx.equals("dp")) {
                                try {
clear();
                                Random rnd = new Random();
                                int a = rnd.nextInt(6);
                                if(a == 0) {
                                    drawBlockEnemy();
                                } else if(a == 1) {
                                    drawBlockDownEnemy();
                                }
                                   if(babysitter == 50 || babysitter == 100 || babysitter == 140)
                                   if(x >= x2 - 50 && x <= x2 + 100 - 50 &&
                                            y >= y2 && y <= y2 + 300)
                                        livesEnemy -= 6;
                                    drawScoreLives();
                                } catch(Exception e) {}

                                clear();
                                if(babysitter > 50 && babysitter < 100){
                                    y-=2;
                                    drawDPunch1();
                                }
                                if(babysitter > 100 && babysitter < 140) {
                                    y-=2;
                                    drawDPunch2();
                                }
                                if(babysitter > 140){
                                    y+=2;
                                    drawDPunch3();
                                }
                                try {
                                    Thread.sleep(1);
                                } catch(Exception e) {

                                }
                                babysitter++;
                                if(babysitter > 190) {
                                    y = 500;
                                    babysitter = 0;
                                    return;
                                }
                            } else
                                break;
                        }
                        babysitter = 0;
                        yx = "";
                    }
                };
                tt1.start();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_E || e.getKeyCode() == KeyEvent.VK_UP) {
            
            if(e.getKeyCode() == KeyEvent.VK_E) {
                kkk = "e";
            } else
                kky = "u";

            Thread thread = new Thread() {
                public void run() {
                    while(true)
                    if(!kyx.equals("l") && !kyx.equals("r") && kky.equals("u")) {
                        clear();
                        if(baseball < 95)
                            y-=2;
                        if(baseball > 95)
                            y+=2;
                        if(kkk.equals("e"))
                            drawJumpKick();
                        
                        else
                            drawJump1();
                        try {
                            Thread.sleep(1);
                        } catch(Exception ee) {

                        }
                        baseball++;
                        if(baseball > 190) {
                            kyx = "";
                            baseball = 0;
                            kkk = "";
                            kky = "";
                            return;
                        }
                    } else
                        return;
                }
            };
            
            thread.start();
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT  &&  enemyAggressing) {

            Thread t = new Thread() {
                public void run() {

                    if(bb) {
                        clear();
                        while(true) {
                            drawBlockDown();
                            try {
                                Thread.sleep(1000);
                            } catch(Exception etwo) {
                                etwo.printStackTrace();
                            }
                            if(!enemyAggressing)
                                break;
                        }
                    }
                }
            };
            t.start();
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN  &&  enemyAggressing) {

            Thread t = new Thread() {
                public void run() {

                    bb = true;
                }
            };
            t.start();
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT  && !bb  &&  enemyAggressing) {

            Thread t = new Thread() {
                public void run() {

                    clear();
                    while(true) {
                        drawBlock();
                        try {
                            Thread.sleep(1000);
                        } catch(Exception etwo) {
                            etwo.printStackTrace();
                        }
                        if(!enemyAggressing)
                            break;
                    }
                }
            };
            t.start();
        }
        if(e.getKeyCode() == KeyEvent.VK_F) {

            Thread t = new Thread() {
                public void run() {

                    clear();
                    drawPunch();
                }
            };
            t.start();
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            kyx = "r";
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            kyx = "l";
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            Thread t = new Thread() {
                public void run() {
                    ky = "r";
                    kyk = "rr";
                    eky = -99;
                    kk = "";
                    x+=5;
                    clear();
                    drawStander();
                }
            };
            t.start();
        }
        else if(e.getKeyCode() == KeyEvent.VK_D) {
            if(eky == -99 && eky != 0) {
                clear();
                drawFireballStance();
            }
            eky = 0;
        }
        else if(e.getKeyCode() == KeyEvent.VK_R) {
            clear();
            drawKick();
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT && !enemyAggressing) {
            Thread t = new Thread() {
                public void run() {
                    ky = "l";
                    kk = "";
                    x-=5;
                    clear();
                    drawStander();
                }
            };
            t.start();
        }
    }
    
    public void drawEnemy() {
        Thread t = new Thread() {
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(500);
                    } catch(Exception ev) {
                        ev.printStackTrace();
                    }
                    Random random = new Random();
                    int v = random.nextInt(7);
                    Random random2 = new Random();
                    int v2 = random.nextInt(2);
                    if (v2 == 0) {
                        x2 -= 15;
                    }
                    if (v2 == 1) {
                        x2 += 15;
                    }
                    clear();
                    switch(v) {
                        case 0:
                            isBlockingEnemy = false;
                            drawStanderEnemy();
                            enemyAggressing = false;
                            break;
                        case 1:
                            isBlockingEnemy = false;
                            drawFireballStanceEnemy();
                            enemyAggressing = true;
                            break;
                        case 2:

                        case 3:
                            isBlockingEnemy = false;
                            drawKickEnemy();
                            enemyAggressing = true;
                            break;
                        case 4:
                            isBlockingEnemy = false;
                            drawEnemyPunch();
                            enemyAggressing = true;
                            break;
                            
                        case 5:
                            isBlockingEnemy = false;
                            drawFireballStanceEnemy();
                            enemyAggressing = true;
                            break;
                        case 6:
                            isBlockingEnemy = false;
                            Thread tt1 = new Thread() {
                                public void run() {
                                    while(true) {
                                        clear();
                                        if(babysitter3 > 50 && babysitter3 < 100){
                                            y2-=2;
                                            drawDPunch1Enemy();
                                        }
                                        if(babysitter3 > 100 && babysitter3 < 140) {
                                            y2-=2;
                                            drawDPunch2Enemy();
                                        }
                                        if(babysitter3 > 140){
                                            y2+=2;
                                            drawDPunch3Enemy();
                                        }
                                        try {
                                            Thread.sleep(1);
                                        } catch(Exception e) {

                                        }
                                        babysitter3++;
                                        if(babysitter3 > 190) {
                                            y2 = 500;
                                            babysitter3 = 0;
                                            return;
                                        }
                                        try {
                                            if(babysitter3 == 50 || babysitter3 == 100 || babysitter3 == 140)
                                            if(x2 >= x && x2 <= x + 100 &&
                                                    y2 >= y && y2 <= y + 300)
                                                livesFriend -= 6;
                                            drawScoreLives();
                                        } catch(Exception e) {}
                                    }
                                }
                            };
                            tt1.start();
                        default:
                            enemyAggressing = false;
                            break;
                    }
                    clear();
                    drawStanderEnemy();
                }
            }
        };
        t.start();
    }
    
    public void drawFireballStance() {
        /* use the image that is the jump/kick picture
        */
            if (eky != -99)
                return;
clear();
            Thread t = new Thread() {
                public void run() {
                    try {
                        Image i = ImageIO.read(getClass().getResourceAsStream("hadoken.png"));
                        g.drawImage(i, x, y, 100, 300, null);
                        isBlockingFriend = false;
                    } catch(Exception ev) {
                        ev.printStackTrace();
                    }
                    fb = new fireball(x, y+130);
                    while(true) {
                        try {
                            try {
                                Random rnd = new Random();
                                int a = rnd.nextInt(6);
                                if(a == 0) {
                                    drawBlockEnemy();
                                } else if(a == 1) {
                                    drawBlockDownEnemy();
                                }
                                if(!isBlockingEnemy)
                                if(b == -1)
                                if(fb.x >= x2 - 50 && fb.x <= x2 + 100 - 50 &&
                                        fb.y >= y2 && fb.y <= y2 + 300) {
                                    livesEnemy -= 12;
                                    b = 0;
                                }
                                drawScoreLives();
                            } catch(Exception e) {}
                            Thread.sleep(50);
                            fb.move();
                            g.setColor(Color.white);
                            g.fillOval(fb.x, fb.y, 50, 50);
                            if (fb.x > 1070) {
                                fb = null;
                                break;
                            }
                        } catch(Exception ev) {
                        }
                    }
                    clear();
                    drawStander();
                }
            };
            t.start();
    }

    public void drawFireballStanceEnemy() {
        /* use the image that is the jump/kick picture
        */
            if (eky != -99)
                return;
            Thread t = new Thread() {
                public void run() {
                    try {
                        Image i = ImageIO.read(getClass().getResourceAsStream("hadokenb.png"));
                        g.drawImage(i, x2, y2, 100, 300, null);
                    } catch(Exception ev) {
                        ev.printStackTrace();
                    }
                    fb2 = new fireball(x2, y2+130);
                    while(true) {
                        try {
                            try {
                                if(c == -1)
                                if(fb2.x >= x - 50 && fb2.x <= x + 100 - 50 &&
                                        fb2.y >= y && fb2.y <= y + 300) {
                                    livesFriend -= 12;
                                    c = 0;
                                }
                                drawScoreLives();
                            } catch(Exception e) {}
                            Thread.sleep(50);
                            fb2.moveEnemy();
                            g.setColor(Color.white);
                            g.fillOval(fb2.x, fb2.y, 50, 50);
                            if (fb2.x < -70) {
                                fb2 = null;
                                break;
                            }
                        } catch(Exception ev) {
                        }
                    }
                    clear();
                    drawStander();
                }
            };
            t.start();
    }

    public void drawKick() {
        /* use the image that is the jump/kick picture
        */
        try {
clear();

            Image i = ImageIO.read(getClass().getResourceAsStream("kickb.png"));
            g.drawImage(i, x, y, 100, 300, null);
            Random rnd = new Random();
            int a = rnd.nextInt(6);
            if(a == 0) {
                drawBlockEnemy();
            } else if(a == 1) {
                drawBlockDownEnemy();
            }
            isBlockingFriend = false;
            if(!isBlockingEnemy)
            if(x >= x2 - 50 && x <= x2 + 100 - 50 &&
                    y >= y2 && y <= y2 + 300)
                livesEnemy -= 6;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void drawEnemyPunch() {
        /* use the image that is the jump/kick picture
        */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("punchb.png"));
            g.drawImage(i, x2, y2, 100, 300, null);
            if(!isBlockingFriend)
            if(x >= x2 - 50 && x <= x2 + 100 - 50 &&
                    y >= y2 && y <= y2 + 300)
                livesFriend -= 6;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void drawBlock() {
        /* use the image that is the jump/kick picture
        */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("blockdown.png"));
            g.drawImage(i, x, y, 100, 300, null);
            isBlockingFriend = true;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void drawBlockDown() {
        /* use the image that is the jump/kick picture
        */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("blockdown.png"));
            g.drawImage(i, x, y, 100, 300, null);
            isBlockingFriend = true;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void drawBlockEnemy() {
        /* use the image that is the jump/kick picture
        */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("blockdownb.png"));
            g.drawImage(i, x2, y2, 100, 300, null);
            isBlockingEnemy = true;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void drawBlockDownEnemy() {
        /* use the image that is the jump/kick picture
        */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("blockdownb.png"));
            g.drawImage(i, x2, y2, 100, 300, null);
            isBlockingEnemy = true;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void drawPunch() {
        /* use the image that is the jump/kick picture
        */
        try {
clear();
            Image i = ImageIO.read(getClass().getResourceAsStream("punch.png"));
            g.drawImage(i, x, y, 100, 300, null);
            Random rnd = new Random();
            int a = rnd.nextInt(6);
            if(a == 0) {
                drawBlockEnemy();
            } else if(a == 1) {
                drawBlockDownEnemy();
            }
            isBlockingFriend = false;
            if(!isBlockingEnemy)
            if(x >= x2 - 50 && x <= x2 + 100 - 50 &&
                    y >= y2 && y <= y2 + 300)
                livesEnemy -= 6;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void drawKickEnemy() {
        /* use the image that is the jump/kick picture
        */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("kick.png"));
            g.drawImage(i, x2, y2, 100, 300, null);
            if(!isBlockingFriend)
            if(x >= x2 - 50 && x <= x2 + 100 - 50 &&
                    y >= y2 && y <= y2 + 300)
                livesFriend -= 6;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void drawJumpKick() {
        /* use the image that is the jump/kick picture
        */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("jumpkick.png"));
            g.drawImage(i, x, y, 100, 300, null);
            Random rnd = new Random();
            int a = rnd.nextInt(6);
            if(a == 0) {
                drawBlockEnemy();
            } else if(a == 1) {
                drawBlockDownEnemy();
            }
            isBlockingFriend = false;
            if(!isBlockingEnemy)
            if(x >= x2 - 50 && x <= x2 + 100 - 50 &&
                    y >= y2 && y <= y2 + 300)
                livesEnemy -= 6;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void drawJump1() {
        /* jump up middle position
        */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("float.png"));
            g.drawImage(i, x, y-50, 100, 300, null);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void drawJump2() {
        /* jump up high position
        */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("float8.png"));
            g.drawImage(i, x, y, 100, 300, null);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void drawDPunch1() {
        /* dragon punch high position
        */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("dpunch1.png"));
            g.drawImage(i, x, y, 100, 300, null);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void drawDPunch2() {
        /* dragon punch high position
        */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("dpunch2.png"));
            g.drawImage(i, x, y, 100, 300, null);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void drawDPunch3() {
        /* dragon punch high position
        */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("dpunch3.png"));
            g.drawImage(i, x, y, 100, 300, null);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void drawDPunch1Enemy() {
        /* dragon punch high position
        */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("dpunch1b.png"));
            g.drawImage(i, x2, y2, 100, 300, null);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void drawDPunch2Enemy() {
        /* dragon punch high position
        */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("dpunch2b.png"));
            g.drawImage(i, x2, y2, 100, 300, null);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void drawDPunch3Enemy() {
        /* dragon punch high position
        */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("dpunch3b.png"));
            g.drawImage(i, x2, y2, 100, 300, null);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void drawJumpKickEnemy() {
        /* use the image that is the jump/kick picture
        */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("jumpkickb.png"));
            g.drawImage(i, x2, y2, 100, 300, null);
            if(!isBlockingFriend)
            if(x >= x2 - 50 && x <= x2 + 100 - 50 &&
                    y >= y2 && y <= y2 + 300)
                livesFriend -= 6;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void drawJump1Enemy() {
        /* jump up middle position
        */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("floatb.png"));
            g.drawImage(i, x2, y2, 100, 300, null);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void drawJump2Enemy() {
        /* jump up high position
        */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("float8b.png"));
            g.drawImage(i, x2, y2, 100, 300, null);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    public void clear(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    g.setColor(Color.PINK);
                    g.fillRect(0, 0, 1000, 800);
                    drawScoreLives();
                } catch(Exception e) {}
            }
        });
        thread.start();
    }

    public AlphaFighter() {
        j.setTitle ("Alpha Fighter II");
        
        j.setLayout(null);

        j.setBounds(0,0,1000,800);
        p.setBounds(j.getBounds());
        j.add(p);
        
        
        j.setVisible(true);

        g = p.getGraphics();

        j.addKeyListener(this);

        clear();

        Thread t = new Thread() {
            public void run() {
                while(true) {
                    drawStander();
                    try {
                        Thread.sleep(100);
                    } catch(Exception ee) {}
                }
            }
        };
        t.start();
        drawStanderEnemy();
        drawEnemy();
        
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
    }
    
    public void drawScoreLives() {
        g.setColor(Color.white);
        g.fillRect(10+(6*(50-livesFriend)), 10, 6*livesFriend, 30);
        g.fillRect(650, 10, 6*
                livesEnemy, 30);
        
        if(livesEnemy <= 0 || livesFriend <= 0) {
            try {
                Thread.sleep(5000);
                livesEnemy = 50;
                livesFriend = 50;
                if(livesFriend <= 0)
                {
                    g.setColor(Color.PINK);
                    g.drawOval(10, 42, 16, 16);
                }
                if(livesEnemy <= 0)
                {
                    g.setColor(Color.pink);
                    g.drawOval(650, 42, 16, 16);
                }
            } catch (Exception e) {}
        }
    }
    
    public void drawStanderEnemy() {
        // draw enemy him standing
        Thread t = new Thread() {
            public void run() {

                try {

                    Image i = ImageIO.read(getClass().getResourceAsStream("standb.png"));
                    g.drawImage(i, x2, y2, 100, 300, null);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }

    public void drawStander() {
        // draw Him standing
        Thread t = new Thread() {
            public void run() {

                try {

                    Image i = ImageIO.read(getClass().getResourceAsStream("stand.png"));
                    g.drawImage(i, x, y, 100, 300, null);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
    
    private void makeSound(String file) throws Exception {

        File audioFile = new File(file);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

        AudioFormat format = audioStream.getFormat();

        DataLine.Info info = new DataLine.Info(Clip.class, format);
        Clip audioClip = (Clip) AudioSystem.getLine(info);

        audioClip.open(audioStream);
        audioClip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void main (String[] arg) { 
        try {
            new AlphaFighter().makeSound("guile.wav");;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}