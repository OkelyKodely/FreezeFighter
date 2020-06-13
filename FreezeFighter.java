import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class FreezeFighter implements KeyListener {

    String kuk = "";
    boolean done = false;
    boolean youwon = false;
    boolean pause = false;
    int clock = 99;
    int cc = -1;
    int bbbb;
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
    boolean isBlockingFriend = false;
    ;
            
            boolean isBlockingEnemy = false;
    ;
    private int bbb = 0;
    /*user input pressied*/
    private String key = "";
    /*user input pressied*/
    private String ky = "";
    /*user input pressied*/
    private String kk = "";
    /*user input pressied*/
    private String kyk = "";
    /*user input pressied*/
    private String kkk = "e";
    /*user input pressied*/
    private String kky = "u";
    /*user input pressied*/
    private String kyx = "";
    /*user input pressied*/
    private String yx = "";
    /*user input pressied*/
    private int eky = 0;
    /*user input pressied*/
    private boolean bb = false;
    /*user presseed*/
    private boolean enemyAggressing = false;
    /*user presseed*/

    private int babysitter3 = 0;
    /*user input pressied*/
    private int babysitter = 0;
    /*user input pressied*/
    private int baseball = 0;

    public int livesEnemy = 100;
    public int livesFriend = 100;

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
            if (fst) {
                fst = false;
            }
            g.setColor(Color.red);
            g.fillOval(this.x, this.y, 50, 50);
            this.x += 25;
        }

        void moveEnemy() {
            if (fst) {
                fst = false;
            }
            g.setColor(Color.blue);
            g.fillOval(this.x, this.y, 50, 50);
            this.x -= 25;
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
        if (e.getKeyCode() == KeyEvent.VK_P) {
            if(!pause)
                pause = true;
            else
                pause = false;
            if(!pause) {
                try {
                    audioClip.loop(Clip.LOOP_CONTINUOUSLY);
                } catch(Exception ee) {
                    ee.printStackTrace();
                }
            } else if(pause) {
                if(clock > 0)
                    cc = clock;
                try {
                    audioClip.stop();
                } catch(Exception ee) {
                    ee.printStackTrace();
                }
            }
            return;
        }
        if (! pause) {
            if (e.getKeyCode() == KeyEvent.VK_UP && (kyx.equals("l") || kyx.equals("r"))) {

                Thread t = new Thread() {

                    public void run() {

                        key = "u";
                        kky = "u";
                        try {
                            Thread tt1 = new Thread() {
                                public void run() {
                                    while (true) {
                                        if (kyx.equals("r")) {
                                            clear();
                                            x += 1;
                                            if (baseball < 45) {
                                                y -= 4;
                                            }
                                            if (baseball > 45) {
                                                y += 4;
                                            }
                                            if (kkk.equals("e")) {
                                                drawKick();
                                            } else {
                                                drawJump1();
                                            }
                                            try {
                                                Thread.sleep(1);
                                            } catch (Exception e) {

                                            }
                                            baseball++;
                                            if (baseball > 90) {
                                                kyx = "";
                                                baseball = 0;
                                                kkk = "";
                                                return;
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                    baseball = 0;
                                }
                            };
                            tt1.start();

                            Thread tt2 = new Thread() {
                                public void run() {
                                    while (true) {
                                        if (kyx.equals("l")) {
                                            clear();
                                            x -= 1;
                                            if (baseball < 45) {
                                                y -= 4;
                                            }
                                            if (kkk.equals("e")) {
                                                drawKick();
                                            } else {
                                                drawJump1();
                                            }
                                            if (baseball > 45) {
                                                y += 4;
                                            }
                                            try {
                                                Thread.sleep(1);
                                            } catch (Exception e) {

                                            }
                                            baseball++;
                                            if (baseball > 90) {
                                                kyx = "";
                                                baseball = 0;
                                                kkk = "";
                                                return;
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                    baseball = 0;
                                }
                            };
                            tt2.start();

                            Thread.sleep(15);
                        } catch (Exception ev) {
                            ev.printStackTrace();
                        }
                        key = "";
                        ky = "";
                        kk = "";
                    }
                };
                t.start();
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT && enemyAggressing) {
                yx = "hk";
                kyx = "l";

                Thread t = new Thread() {
                    public void run() {

                        clear();
                        while (true) {
                            drawBlockDown();
                            try {
                                Thread.sleep(1000);
                            } catch (Exception etwo) {
                                etwo.printStackTrace();
                            }
                            if (!enemyAggressing) {
                                return;
                            }
                        }
                    }
                };
                t.start();
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN && enemyAggressing) {

                Thread t = new Thread() {
                    public void run() {

                        bb = true;
                    }
                };
                t.start();
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT && !bb && enemyAggressing) {
                yx = "hk";
                kyx = "l";

                Thread t = new Thread() {
                    public void run() {

                        clear();
                        while (true) {
                            drawBlock();
                            try {
                                Thread.sleep(1000);
                            } catch (Exception etwo) {
                                etwo.printStackTrace();
                            }
                            if (!enemyAggressing) {
                                break;
                            }
                        }
                    }
                };
                t.start();
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                yx = "hk";
                kyx = "l";
                x -= 5;
            } else if (e.getKeyCode() == KeyEvent.VK_T) {
                if (yx.equals("hk")) {
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            y -= 50;
                            try {
                                makeSound2("hkick.wav");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            while (true) {
                                if (bbb > 0 && bbb < 40) {
                                    drawHKick1();
                                }
                                if (bbb > 40 && bbb < 80) {
                                    drawHKick2();
                                }
                                if (bbb > 80 && bbb < 120) {
                                    drawHKick1();
                                }
                                try {
                                    Thread.sleep(1);
                                } catch (Exception e) {
                                }
                                x += 1;
                                bbb++;
                                if (bbb > 125) {
                                    bbb = 0;
                                    yx = "";
                                    y = 500;
                                    return;
                                }
                            }
                        }
                    });
                    t.start();
                }
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                kuk = "rf";
                yx = "dp";
            } else if (e.getKeyCode() == KeyEvent.VK_G) {
                if (yx.equals("dp")) {
                    Thread tt1 = new Thread() {
                        public void run() {
                            if (yx.equals("dp")) {
                                try {
                                    makeSound2("shoryuken.wav");
                                } catch (Exception ee) {
                                }
                            }
                            while (true) {
                                if (yx.equals("dp")) {
                                    try {
                                        clear();
                                        Random rnd = new Random();
                                        int a = rnd.nextInt(5);
                                        if (a == 0) {
                                            drawBlockEnemy();
                                        } else if (a == 1) {
                                            //drawBlockDownEnemy();
                                        }
                                        if (babysitter == 50 || babysitter == 100 || babysitter == 140) {
                                            if (x >= x2 - 115 && x <= x2 + 160 - 115
                                                    && y >= y2 && y <= y2 + 300) {
                                                livesEnemy -= 6;
                                            }
                                        }
                                        drawScoreLives();
                                    } catch (Exception e) {
                                    }

//                                clear();
                                    if (babysitter > 10 && babysitter < 30) {
                                        y -= 2;
                                        drawDPunch1();
                                    }
                                    if (babysitter > 30 && babysitter < 60) {
                                        y -= 2;
                                        drawDPunch2();
                                    }
                                    if (babysitter > 60) {
                                        y += 2;
                                        drawDPunch3();
                                    }
                                    try {
                                        Thread.sleep(1);
                                    } catch (Exception e) {

                                    }
                                    babysitter++;
                                    if (babysitter > 90) {
                                        y = 500;
                                        babysitter = 0;
                                        return;
                                    }
                                } else {
                                    break;
                                }
                            }
                            babysitter = 0;
                            yx = "";
                        }
                    };
                    tt1.start();
                }
            } else if (e.getKeyCode() == KeyEvent.VK_E || e.getKeyCode() == KeyEvent.VK_UP) {
                if (!kyx.equals("l") && !kyx.equals("r")) {

                    if (e.getKeyCode() == KeyEvent.VK_E) {
                        kkk = "e";
                    } else {
                        kky = "u";
                    }

                    Thread thread = new Thread() {
                        public void run() {
                            while (true) {
                                if (!kyx.equals("l") && !kyx.equals("r") && kky.equals("u")) {
                                    clear();
                                    if (baseball < 95) {
                                        y -= 2;
                                    }
                                    if (baseball > 95) {
                                        y += 2;
                                    }
                                    if (kkk.equals("e")) {
                                        drawKick();
                                    } else {
                                        drawJump1();
                                    }
                                    try {
                                        Thread.sleep(1);
                                    } catch (Exception ee) {

                                    }
                                    baseball++;
                                    if (baseball > 190) {
                                        kyx = "";
                                        baseball = 0;
                                        kkk = "";
                                        kky = "";
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                        }
                    };

                    thread.start();
                }
            } else if (e.getKeyCode() == KeyEvent.VK_H) {

                Thread t = new Thread() {
                    public void run() {
                        
                        if(kuk.equals("rf")) {
                            clear();
                            drawDownPunch();
                        }
                    }
                };
                t.start();
            } else if (e.getKeyCode() == KeyEvent.VK_F) {

                Thread t = new Thread() {
                    public void run() {

                        clear();
                        drawPunch();
                    }
                };
                t.start();
            } else if (e.getKeyCode() == KeyEvent.VK_W) {

                Thread t = new Thread() {
                    public void run() {

                        clear();
                        drawShort();
                    }
                };
                t.start();
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                kyx = "r";
                Thread t = new Thread() {
                    public void run() {
                        ky = "r";
                        kyk = "rr";
                        eky = -99;
                        kk = "";
                        x += 5;
                        clear();
                        drawStander();
                    }
                };
                t.start();
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                kyx = "l";
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                Thread t = new Thread() {
                    public void run() {
                        ky = "r";
                        kyk = "rr";
                        eky = -99;
                        kk = "";
                        x += 5;
                        clear();
                        drawStander();
                    }
                };
                t.start();
            } else if (e.getKeyCode() == KeyEvent.VK_D) {
                if (eky == -99 && eky != 0) {
                    clear();
                    drawFireballStance();
                }
                eky = 0;
            } else if (e.getKeyCode() == KeyEvent.VK_R) {
                clear();
                drawKick();
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT && !enemyAggressing) {
                Thread t = new Thread() {
                    public void run() {
                        ky = "l";
                        kk = "";
                        x -= 5;
                        clear();
                        drawStander();
                    }
                };
                t.start();
            } else {
                Thread t = new Thread() {
                    public void run() {
                        while (true) {
                            clear();
                            drawStander();
                            try {
                                Thread.sleep(100);
                            } catch (Exception ee) {
                            }
                        }
                    }
                };
                t.start();
            }
        }
        y = 500;
    }
    
    public void drawDownPunch() {
        Thread t = new Thread() {
            public void run() {
                int iii = 0;
                while(true) {
                    try {

                        if(iii == 0) {
                            Image i1 = ImageIO.read(getClass().getResourceAsStream("pdown1.png"));
                            g.drawImage(i1, x, y, 160, 300, null);
                        } else if(iii == 1) {
                            Image i2 = ImageIO.read(getClass().getResourceAsStream("pdown2.png"));
                            g.drawImage(i2, x, y, 160, 300, null);
                        }
                        iii++;
                        Thread.sleep(4000);
                        Random rnd = new Random();
                        int a = rnd.nextInt(5);
                        if (a == 0) {
                            drawBlockEnemy();
                        } else if (a == 1) {
                            //drawBlockDownEnemy();
                        }
                        if (!isBlockingEnemy) {
                            if (x >= x2 - 115 && x <= x2 + 160 - 115
                                    && y >= y2 && y <= y2 + 300) {
                                livesEnemy -= 6;
                            }
                        }
                        if(iii == 2)
                        {
                            kuk = "";
                            return;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }

    public void drawEnemy() {
        Thread t = new Thread() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (Exception ev) {
                        ev.printStackTrace();
                    }
                    Random random = new Random();
                    int v = random.nextInt(10);
                    Random random2 = new Random();
                    int v2 = random.nextInt(2);
                    if(!pause) {
                        if (v2 == 0) {
                            if (x2 > 150) {
                                x2 -= 35;
                            }
                        }
                        if (v2 == 1) {
                            if (x2 < 850) {
                                x2 += 35;
                            }
                        }
                    }
                    clear();
                    if (!pause) {
                        switch (v) {
                            case 0:
                                isBlockingEnemy = false;
                                enemyAggressing = true;
                                drawStanderEnemy();
                                enemyAggressing = false;
                                done = true;
                                bbbb = 0;
                                break;
                            case 1:
                                if (done && bbbb == 0) {
                                    done = false;
                                    isBlockingEnemy = false;
                                    enemyAggressing = true;
                                    drawFireballStanceEnemy();
                                    enemyAggressing = false;
                                }
                                break;
                            case 2:
                                isBlockingEnemy = false;
                                enemyAggressing = true;
                                drawStanderEnemy();
                                enemyAggressing = false;
                                done = true;
                                bbbb = 0;
                                break;
                            case 3:
                                if (done && bbbb == 0) {
                                    done = false;
                                    isBlockingEnemy = false;
                                    enemyAggressing = true;
                                    drawKickEnemy();
                                    enemyAggressing = false;
                                }
                                break;
                            case 4:
                                if (done && bbbb == 0) {
                                    done = false;
                                    isBlockingEnemy = false;
                                    enemyAggressing = true;
                                    drawEnemyPunch();
                                    enemyAggressing = false;
                                }
                                break;
                            case 5:
                            case 6:
                                if (done && bbbb == 0) {
                                    done = false;
                                    isBlockingEnemy = false;
                                    enemyAggressing = true;
                                    drawKickEnemy();
                                    enemyAggressing = true;
                                }
                                break;
                            case 7:
                                if (done && bbbb == 0) {
                                    done = false;
                                    isBlockingEnemy = false;
                                    enemyAggressing = true;
                                    Thread tt1 = new Thread() {
                                        public void run() {
                                            makeSound2("shoryuken.wav");
                                            while (true) {
                                                clear();
                                                if (babysitter3 > 50 && babysitter3 < 100) {
                                                    y2 -= 2;
                                                    drawDPunch1Enemy();
                                                }
                                                if (babysitter3 > 100 && babysitter3 < 140) {
                                                    y2 -= 2;
                                                    drawDPunch2Enemy();
                                                }
                                                if (babysitter3 > 140) {
                                                    y2 += 2;
                                                    drawDPunch3Enemy();
                                                }
                                                try {
                                                    Thread.sleep(1);
                                                } catch (Exception e) {

                                                }
                                                babysitter3++;
                                                if (babysitter3 > 190) {
                                                    y2 = 500;
                                                    babysitter3 = 0;
                                                    done = true;
                                                    enemyAggressing = false;
                                                    return;
                                                }
                                                try {
                                                    if (babysitter3 == 50 || babysitter3 == 100 || babysitter3 == 140) {
                                                        if (x2 >= x && x2 <= x + 100
                                                                && y2 >= y && y2 <= y + 300) {
                                                            livesFriend -= 6;
                                                        }
                                                    }
                                                    drawScoreLives();
                                                } catch (Exception e) {
                                                }
                                            }
                                        }
                                    };
                                    tt1.start();
                                }
                                break;
                            case 8:
                                if(done) {
                                    isBlockingEnemy = false;
                                    enemyAggressing = true;
                                    done = false;
                                    try {
                                        makeSound2("hkick.wav");
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    Thread ttt = new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            while (!done) {
                                                if (bbbb > 0 && bbbb < 40) {
                                                    drawHKick1Enemy();
                                                }
                                                if (bbbb > 40 && bbbb < 80) {
                                                    drawHKick2Enemy();
                                                }
                                                if (bbbb > 80 && bbbb < 120) {
                                                    drawHKick3Enemy();
                                                }
                                                try {
                                                    Thread.sleep(1);
                                                } catch (Exception e) {
                                                }
                                                x2 -= 4;
                                                bbbb++;
                                                if (bbbb > 120) {
                                                    bbbb = 0;
                                                    yx = "";
                                                    y2 = 500;
                                                    done = true;
                                                    enemyAggressing = false;

                                                }
                                            }
                                        }
                                    });
                                    ttt.start();
                                }
                                break;
                            case 9:
                                if(done && bbbb == 0) {
                                    done = false;
                                    isBlockingEnemy = false;
                                    enemyAggressing = true;
                                    drawShortEnemy();
                                    enemyAggressing = false;
                                }
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        };
        t.start();
    }

    public void drawFireballStance() {
        /* use the image that is the jump/kick picture
         */
        if (eky != -99) {
            return;
        }

        b = -1;
//clear();
        Thread t = new Thread() {
            public void run() {
                try {
                    makeSound2("hadoken.wav");
                    Image i = ImageIO.read(getClass().getResourceAsStream("hadoken.png"));
                    g.drawImage(i, x, y, 160, 300, null);
                    isBlockingFriend = false;
                } catch (Exception ev) {
                    ev.printStackTrace();
                }
                fb = new fireball(x, y + 30);
                while (true) {
                    try {
                        try {
                            Random rnd = new Random();
                            int a = rnd.nextInt(5);
                            if (a == 0) {
                                drawBlockEnemy();
                            } else if (a == 1) {
                                //drawBlockDownEnemy();
                            }
                            if (!isBlockingEnemy) {
                                if (b == -1) {
                                    if (fb.x >= x2 - 115 && fb.x <= x2 + 160 - 115
                                            && fb.y >= y2 && fb.y <= y2 + 300) {
                                        livesEnemy -= 12;
                                        b = 0;
                                    }
                                }
                            }
                            drawScoreLives();
                        } catch (Exception e) {
                        }
                        Thread.sleep(50);
                        fb.move();
                        g.setColor(Color.red);
                        g.fillOval(fb.x, fb.y, 50, 50);
                        if (fb.x > 1070) {
                            fb = null;
                            return;
                        }
                    } catch (Exception ev) {
                    }
                }
            }
        };
        t.start();
    }

    public void drawFireballStanceEnemy() {
        /* use the image that is the hadoken b picture
         */
        c = -1;
        Thread t = new Thread() {
            public void run() {
                try {
                    makeSound2("hadoken.wav");
                    Image ii = ImageIO.read(getClass().getResourceAsStream("hadokenb.png"));
                    g.drawImage(ii, x2, y2, 160, 300, null);
                    Thread.sleep(1000);
                } catch (Exception ev) {
                    ev.printStackTrace();
                }
                fb2 = new fireball(x2, y2 + 30);
                while (true) {
                    try {
                        try {
                            if (c == -1) {
                                if (fb2.x >= x && fb2.x <= x + 160
                                        && fb2.y >= y && fb2.y <= y + 300) {
                                    livesFriend -= 12;
                                    c = 0;
                                }
                            }
                            drawScoreLives();
                        } catch (Exception e) {
                        }
                        Thread.sleep(50);
                        fb2.moveEnemy();
                        g.setColor(Color.blue);
                        g.fillOval(fb2.x, fb2.y, 50, 50);
                        if (fb2.x < -70) {
                            fb2 = null;
                            done = true;
                            return;
                        }
                    } catch (Exception ev) {
                    }
                }
            }
        };
        t.start();
    }

    public void drawShortEnemy() {
        /* use the image that is the short
         */
        try {
//clear();

            Image i = ImageIO.read(getClass().getResourceAsStream("shortb.png"));
            g.drawImage(i, x2, y2, 160, 300, null);
            Thread.sleep(1000);
            if (!isBlockingFriend) {
                if (x2 >= x - 115 && x2 <= x + 160 - 115
                        && y2 >= y && y2 <= y + 300) {
                    livesFriend -= 6;
                }
            }
            done = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawKick() {
        /* use the image that is the jump/kick picture
         */
        try {
//clear();

            Image i = ImageIO.read(getClass().getResourceAsStream("kickb.png"));
            g.drawImage(i, x, y, 160, 300, null);
            Random rnd = new Random();
            int a = rnd.nextInt(5);
            if (a == 0) {
                drawBlockEnemy();
            } else if (a == 1) {
                //drawBlockDownEnemy();
            }
            isBlockingFriend = false;
            if (!isBlockingEnemy) {
                if (x >= x2 - 115 && x <= x2 + 160 - 115
                        && y >= y2 && y <= y2 + 300) {
                    livesEnemy -= 6;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawShort() {
        /* use the image that is the jump/kick picture
         */
        try {
//clear();

            Image i = ImageIO.read(getClass().getResourceAsStream("short.png"));
            g.drawImage(i, x, y, 160, 300, null);
            Random rnd = new Random();
            int a = rnd.nextInt(5);
            if (a == 0) {
                drawBlockEnemy();
            } else if (a == 1) {
                //drawBlockDownEnemy();
            }
            isBlockingFriend = false;
            if (!isBlockingEnemy) {
                if (x >= x2 - 115 && x <= x2 + 160 - 115
                        && y >= y2 && y <= y2 + 300) {
                    livesEnemy -= 6;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawHKick3() {
        /* use the image that is the jump/kick picture
         */
        try {
//clear();

            Image i = ImageIO.read(getClass().getResourceAsStream("hkick1.png"));
            g.drawImage(i, x, y, 160, 300, null);
            Random rnd = new Random();
            int a = rnd.nextInt(5);
            if (a == 0) {
                drawBlockEnemy();
            } else if (a == 1) {
                //drawBlockDownEnemy();
            }
            isBlockingFriend = false;
            if (!isBlockingEnemy) {
                if (x >= x2 - 115 && x <= x2 + 160 - 115
                        && y >= y2 && y <= y2 + 300) {
                    livesEnemy -= 6;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawHKick1Enemy() {
        /* use the image that is the jump/kick picture
         */
        try {
//clear();

            Image i = ImageIO.read(getClass().getResourceAsStream("hkick1.png"));
            g.drawImage(i, x2, y2, 160, 300, null);
            Random rnd = new Random();
            int a = rnd.nextInt(5);
            if (a == 0) {
                drawBlockEnemy();
            } else if (a == 1) {
                //drawBlockDownEnemy();
            }
            isBlockingFriend = false;
            if (!isBlockingEnemy) {
                if (x2 >= x - 115 && x2 <= x + 160 - 115
                        && y2 >= y && y2 <= y + 300) {
                    livesFriend -= 6;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawHKick2Enemy() {
        /* use the image that is the jump/kick picture
         */
        try {
//clear();

            Image i = ImageIO.read(getClass().getResourceAsStream("hkick2.png"));
            g.drawImage(i, x2, y2, 160, 300, null);
            Random rnd = new Random();
            int a = rnd.nextInt(5);
            if (a == 0) {
                drawBlockEnemy();
            } else if (a == 1) {
                //drawBlockDownEnemy();
            }
            isBlockingFriend = false;
            if (!isBlockingEnemy) {
                if (x2 >= x - 115 && x2 <= x + 160 - 115
                        && y2 >= y && y2 <= y + 300) {
                    livesFriend -= 6;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawHKick3Enemy() {
        /* use the image that is the jump/kick picture
         */
        try {
//clear();

            Image i = ImageIO.read(getClass().getResourceAsStream("hkick1.png"));
            g.drawImage(i, x2, y2, 160, 300, null);
            Random rnd = new Random();
            int a = rnd.nextInt(5);
            if (a == 0) {
                drawBlockEnemy();
            } else if (a == 1) {
                //drawBlockDownEnemy();
            }
            isBlockingFriend = false;
            if (!isBlockingEnemy) {
                if (x2 >= x - 115 && x2 <= x + 160 - 115
                        && y2 >= y && y2 <= y + 300) {
                    livesFriend -= 6;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawHKick1() {
        /* use the image that is the jump/kick picture
         */
        try {
//clear();

            Image i = ImageIO.read(getClass().getResourceAsStream("hkick1.png"));
            g.drawImage(i, x, y, 160, 300, null);
            Random rnd = new Random();
            int a = rnd.nextInt(5);
            if (a == 0) {
                drawBlockEnemy();
            } else if (a == 1) {
                //drawBlockDownEnemy();
            }
            isBlockingFriend = false;
            if (!isBlockingEnemy) {
                if (x >= x2 - 115 && x <= x2 + 160 - 115
                        && y >= y2 && y <= y2 + 300) {
                    livesEnemy -= 6;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void drawHKick2() {
        /* use the image that is the jump/kick picture
         */
        try {
//clear();

            Image i = ImageIO.read(getClass().getResourceAsStream("hkick2.png"));
            g.drawImage(i, x, y, 160, 300, null);
            Random rnd = new Random();
            int a = rnd.nextInt(5);
            if (a == 0) {
                drawBlockEnemy();
            } else if (a == 1) {
                //drawBlockDownEnemy();
            }
            isBlockingFriend = false;
            if (!isBlockingEnemy) {
                if (x >= x2 - 115 && x <= x2 + 160 - 115
                        && y >= y2 && y <= y2 + 300) {
                    livesEnemy -= 6;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawEnemyPunch() {
        /* use the image that is the jump/kick picture
         */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("punchb.png"));
            g.drawImage(i, x2, y2, 160, 300, null);
            if (!isBlockingFriend) {
                if (x >= x2 - 115 && x <= x2 + 160 - 115
                        && y >= y2 && y <= y2 + 300) {
                    livesFriend -= 6;
                }
            }
            done = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawBlock() {
        /* use the image that is the jump/kick picture
         */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("blockdown.png"));
            g.drawImage(i, x, y, 160, 300, null);
            isBlockingFriend = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawBlockDown() {
        /* use the image that is the jump/kick picture
         */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("blockdown.png"));
            g.drawImage(i, x, y, 160, 300, null);
            isBlockingFriend = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawBlockEnemy() {
        /* use the image that is the jump/kick picture
         */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("blockdownb.png"));
            g.drawImage(i, x2, y2, 160, 300, null);
            isBlockingEnemy = true;
            done = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawBlockDownEnemy() {
        /* use the image that is the jump/kick picture
         */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("blockdownb.png"));
            g.drawImage(i, x2, y2, 160, 300, null);
            isBlockingEnemy = true;
            done = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawPunch() {
        /* use the image that is the jump/kick picture
         */
        try {
//clear();
            Image i = ImageIO.read(getClass().getResourceAsStream("punch.png"));
            g.drawImage(i, x, y, 160, 300, null);
            Random rnd = new Random();
            int a = rnd.nextInt(5);
            if (a == 0) {
                drawBlockEnemy();
            } else if (a == 1) {
                //drawBlockDownEnemy();
            }
            isBlockingFriend = false;
            if (!isBlockingEnemy) {
                if (x >= x2 - 115 && x <= x2 + 160 - 115
                        && y >= y2 && y <= y2 + 300) {
                    livesEnemy -= 6;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawKickEnemy() {
        /* use the image that is the jump/kick picture
         */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("kick.png"));
            g.drawImage(i, x2, y2, 160, 300, null);
            if (!isBlockingFriend) {
                if (x >= x2 - 115 && x <= x2 + 160 - 115
                        && y >= y2 && y <= y2 + 300) {
                    livesFriend -= 6;
                }
            }
            done = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawJumpKick() {
        /* use the image that is the jump/kick picture
         */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("jumpkick.png"));
            g.drawImage(i, x, y, 160, 300, null);
            Random rnd = new Random();
            int a = rnd.nextInt(5);
            if (a == 0) {
                drawBlockEnemy();
            } else if (a == 1) {
                //drawBlockDownEnemy();
            }
            isBlockingFriend = false;
            if (!isBlockingEnemy) {
                if (x >= x2 - 115 && x <= x2 + 160 - 115
                        && y >= y2 && y <= y2 + 300) {
                    livesEnemy -= 6;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawJump1() {
        /* jump up middle position
         */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("float.png"));
            g.drawImage(i, x, y - 50, 160, 300, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawJump2() {
        /* jump up high position
         */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("float8.png"));
            g.drawImage(i, x, y, 160, 300, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawDPunch1() {
        /* dragon punch high position
         */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("dpunch1.png"));
            g.drawImage(i, x, y, 160, 300, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawDPunch2() {
        /* dragon punch high position
         */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("dpunch2.png"));
            g.drawImage(i, x, y, 160, 300, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawDPunch3() {
        /* dragon punch high position
         */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("dpunch3.png"));
            g.drawImage(i, x, y, 160, 300, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawDPunch1Enemy() {
        /* dragon punch high position
         */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("dpunch1b.png"));
            g.drawImage(i, x2, y2, 160, 300, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawDPunch2Enemy() {
        /* dragon punch high position
         */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("dpunch2b.png"));
            g.drawImage(i, x2, y2, 160, 300, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawDPunch3Enemy() {
        /* dragon punch high position
         */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("dpunch3b.png"));
            g.drawImage(i, x2, y2, 160, 300, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawJumpKickEnemy() {
        /* use the image that is the jump/kick picture
         */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("jumpkickb.png"));
            g.drawImage(i, x2, y2, 160, 300, null);
            if (!isBlockingFriend) {
                if (x >= x2 - 115 && x <= x2 + 160 - 115
                        && y >= y2 && y <= y2 + 300) {
                    livesFriend -= 6;
                }
            }
            done = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawJump1Enemy() {
        /* jump up middle position
         */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("floatb.png"));
            g.drawImage(i, x2, y2, 160, 300, null);
            done = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawJump2Enemy() {
        /* jump up high position
         */
        try {

            Image i = ImageIO.read(getClass().getResourceAsStream("float8b.png"));
            g.drawImage(i, x2, y2, 160, 300, null);
            done = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void clear() {
        try {
            g.drawImage(i, 0, 0, 1000, 800, null);
            drawScoreLives();
        } catch (Exception e) {
        }
    }

    public Image i = null;

    public ImageIcon icon = null;

    public FreezeFighter() {
        try {
            icon = new ImageIcon(this.getClass()
                    .getResource("bg.gif"));
            i = icon.getImage();
        } catch (Exception e) {
        }
        j.setTitle("Freeze Fighter 2~");

        j.setLayout(null);

        j.setBounds(0, 0, 1000, 800);
        p.setBounds(j.getBounds());
        j.add(p);

        j.setVisible(true);

        g = p.getGraphics();

        j.addKeyListener(this);

        clear();

        Thread t = new Thread() {
            public void run() {
                while (true) {
                    if(pause)
                        clock = cc;
                    try {
                        Thread.sleep(1000);
                    } catch(Exception e) {}
                }
            }
        };
        t.start();
        Thread tt = new Thread() {
            public void run() {
                try {
                    g.setColor(Color.BLACK);
                    g.drawString("Ready?!", 200, 200);
                    Thread.sleep(5000);
                } catch (Exception e) {
                }
            }
        };
        tt.start();
        drawStanderEnemy();
        drawEnemy();

        Thread f = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    g.setColor(Color.BLUE);
                    g.setFont(new Font("Tahoma", Font.PLAIN, 50));
                    g.drawString("" + clock, 500, 100);
                    g.setColor(Color.BLACK);
                    g.setFont(new Font("arial", Font.BOLD, 27));
                    g.drawString("RYU", 10, 80);
                    g.drawString("KEN", 660, 80);
                }
            }
        });
        f.start();

        Thread d = new Thread() {
            public void run() {
                while (true) {
                    youwon = false;
                    try {
                        if (livesFriend <= 0 || (clock <= 0 && livesFriend < livesEnemy)) {
                            g.setColor(Color.PINK);
                            g.drawOval(10, 42, 16, 16);
                            JOptionPane.showMessageDialog(null, "You lose");
                            x = 200;
                            x2 = 700;
                            y = 500;
                            y2 = 500;
                            livesEnemy = 100;
                            livesFriend = 100;
                            clock = 99;
                        } else if (livesEnemy <= 0 || (clock <= 0 && livesEnemy < livesFriend)) {
                            youwon = true;
                            g.setColor(Color.pink);
                            g.drawOval(650, 42, 16, 16);
                            JOptionPane.showMessageDialog(null, "You win");
                            x = 200;
                            x2 = 700;
                            y = 500;
                            y2 = 500;
                            livesEnemy = 100;
                            livesFriend = 100;
                            clock = 99;
                        }
                        Thread.sleep(1000);
                        clock--;
                    } catch (Exception e) {
                    }
                }
            }
        };
        d.start();

        j.setExtendedState(j.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_Q);
        } catch (AWTException e) {
        }
    }

    public void drawScoreLives() {
        g.setColor(Color.green);
        g.fillRect(10 + (4 * (100 - livesFriend)), 10, 4 * livesFriend, 30);
        g.fillRect(450, 10, 4
                * livesEnemy, 30);
    }

    public void drawStanderEnemy() {
        // draw enemy him standing
        Thread t = new Thread() {
            public void run() {

                try {

                    Image i = ImageIO.read(getClass().getResourceAsStream("standb.png"));
                    g.drawImage(i, x2, y2, 160, 300, null);
                    done = true;
                } catch (Exception e) {
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
                    g.drawImage(i, x, y, 160, 300, null);
                } catch (Exception e) {

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
        audioClip = (Clip) AudioSystem.getLine(info);

        audioClip.open(audioStream);
        audioClip.loop(Clip.LOOP_CONTINUOUSLY);
    }Clip audioClip = null;

    private void makeSound2(String file) {

        try {
            File audioFile = new File(file);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            AudioFormat format = audioStream.getFormat();

            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip audioClip = (Clip) AudioSystem.getLine(info);

            audioClip.open(audioStream);
            audioClip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] arg) {
        try {
            SwingUtilities .invokeAndWait(new Runnable( ) {
                @Override
                public void run() {
                    try {
                        new FreezeFighter().makeSound("guile.wav");;
                    } catch(Exception e) {
                        
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
















